package com.github.xingray.kelingsdk.auth

/**
 * JWT Token 信息
 * 包含生成的 token 字符串及其过期时间，便于缓存管理和过期判断
 *
 * @param token JWT Token 字符串，用于 API 请求的 Authorization 头
 * @param expireTime Token 过期时间，Unix时间戳（毫秒）
 */
data class JwtToken(
    /** JWT Token 字符串 */
    val token: String,
    /** Token 过期时间，Unix时间戳（毫秒） */
    val expireTime: Long
)
