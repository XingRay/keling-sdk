package io.github.xingray.kelingsdk.auth

import io.github.xingray.kelingsdk.common.KelingConstants
import java.util.concurrent.ConcurrentHashMap

/**
 * 缓存JWT Token生成器（装饰者模式）
 *
 * 对传入的 [JwtTokenGenerator] 添加缓存功能：
 * - 相同凭证的Token会被缓存复用，避免频繁生成
 * - 当Token接近过期（默认提前5分钟）时缓存自动失效，由内部生成器重新生成
 * - 使用 [ConcurrentHashMap] 保证线程安全
 *
 * 使用示例：
 * ```kotlin
 * val generator = CachedJwtTokenGenerator()  // 默认使用 BasicJwtTokenGenerator
 * val generator2 = CachedJwtTokenGenerator(MyCustomGenerator(), refreshAheadMs = 10 * 60 * 1000L)
 * ```
 *
 * @param delegate 实际的Token生成器，默认为 [BasicJwtTokenGenerator]
 * @param refreshAheadMs 提前刷新时间（毫秒），Token距离过期小于此时间时缓存失效，默认5分钟
 */
class CachedJwtTokenGenerator(
    private val delegate: JwtTokenGenerator = BasicJwtTokenGenerator(),
    private val refreshAheadMs: Long = KelingConstants.DEFAULT_REFRESH_AHEAD_MS
) : JwtTokenGenerator {

    /** 缓存Map，key为 accessKey，value为 JwtToken */
    private val cache = ConcurrentHashMap<String, JwtToken>()

    /**
     * 根据凭证获取JWT Token（带缓存）
     * 如果缓存中存在有效的Token（未接近过期），直接返回缓存的Token
     * 否则通过内部生成器生成新Token并缓存
     *
     * @param credentials API凭证，包含 AccessKey 和 SecretKey
     * @return JWT Token信息，包含token字符串和过期时间
     */
    override fun generateToken(credentials: Credentials): JwtToken {
        val cacheKey = credentials.accessKey
        val cached = cache[cacheKey]
        if (cached != null && !isNearExpiry(cached)) {
            return cached
        }
        val newToken = delegate.generateToken(credentials)
        cache[cacheKey] = newToken
        return newToken
    }

    /**
     * 判断Token是否接近过期
     * @param token 待检查的Token
     * @return true 表示Token已过期或即将过期，需要刷新
     */
    private fun isNearExpiry(token: JwtToken): Boolean {
        return System.currentTimeMillis() + refreshAheadMs >= token.expireTime
    }

    /**
     * 清除所有缓存的Token
     */
    fun clearCache() {
        cache.clear()
    }

    /**
     * 清除指定凭证的缓存Token
     * @param credentials 要清除缓存的凭证
     */
    fun clearCache(credentials: Credentials) {
        cache.remove(credentials.accessKey)
    }
}
