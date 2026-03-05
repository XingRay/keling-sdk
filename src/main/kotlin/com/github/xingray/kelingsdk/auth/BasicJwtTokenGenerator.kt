package com.github.xingray.kelingsdk.auth

import com.github.xingray.kelingsdk.common.KelingConstants
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.util.Date

/**
 * 基础JWT Token生成器
 * 遵循JWT (Json Web Token, RFC 7519) 标准，使用 HMAC-SHA256 签名
 * 每次调用 [generateToken] 都会生成一个全新的Token
 *
 * Token默认有效期为30分钟，可通过构造参数自定义
 *
 * @param tokenValidityMs Token有效期（毫秒），默认30分钟
 * @param clockSkewMs 时钟偏差容忍（毫秒），默认5秒
 */
class BasicJwtTokenGenerator(
    private val tokenValidityMs: Long = KelingConstants.DEFAULT_TOKEN_VALIDITY_MS,
    private val clockSkewMs: Long = KelingConstants.DEFAULT_CLOCK_SKEW_MS
) : JwtTokenGenerator {

    /**
     * 根据凭证生成JWT Token
     * @param credentials API凭证，包含 AccessKey 和 SecretKey
     * @return JWT Token信息，包含token字符串和过期时间
     */
    override fun generateToken(credentials: Credentials): JwtToken {
        val now = System.currentTimeMillis()
        val expireTime = now + tokenValidityMs
        val key = Keys.hmacShaKeyFor(credentials.secretKey.toByteArray())
        val token = Jwts.builder()
            .header().add(KelingConstants.JWT_HEADER_ALG, KelingConstants.JWT_ALGORITHM).add(KelingConstants.JWT_HEADER_TYP, KelingConstants.JWT_TYPE).and()
            .issuer(credentials.accessKey)
            .expiration(Date(expireTime))
            .issuedAt(Date(now - clockSkewMs))
            .notBefore(Date(now - clockSkewMs))
            .signWith(key)
            .compact()
        return JwtToken(token, expireTime)
    }
}
