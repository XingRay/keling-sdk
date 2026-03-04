package io.github.xingray.kelingsdk.auth

/**
 * JWT Token 生成器接口
 * 负责根据凭证生成可灵AI API所需的JWT鉴权Token
 *
 * 可通过实现此接口自定义Token生成逻辑，例如：
 * - [BasicJwtTokenGenerator] 基础实现，每次调用都生成新Token
 * - [CachedJwtTokenGenerator] 缓存装饰器，自动缓存并在过期前刷新Token
 */
interface JwtTokenGenerator {

    /**
     * 根据凭证生成JWT Token
     * @param credentials API凭证，包含 AccessKey 和 SecretKey
     * @return JWT Token信息，包含token字符串和过期时间
     */
    fun generateToken(credentials: Credentials): JwtToken
}
