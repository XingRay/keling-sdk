package com.github.xingray.kelingsdk.common

/**
 * 可灵AI SDK 常量定义
 * 集中管理SDK中使用的各类常量值
 */
object KelingConstants {

    // ==================== API 配置 ====================

    /** 默认API基础URL */
    const val DEFAULT_BASE_URL = "https://api-beijing.klingai.com"

    // ==================== JWT 配置 ====================

    /** JWT Header - 算法字段名 */
    const val JWT_HEADER_ALG = "alg"

    /** JWT Header - 类型字段名 */
    const val JWT_HEADER_TYP = "typ"

    /** JWT 签名算法 */
    const val JWT_ALGORITHM = "HS256"

    /** JWT 类型值 */
    const val JWT_TYPE = "JWT"

    /** 默认Token有效期（毫秒），30分钟 */
    const val DEFAULT_TOKEN_VALIDITY_MS = 30 * 60 * 1000L

    /** 默认时钟偏差容忍（毫秒），5秒 */
    const val DEFAULT_CLOCK_SKEW_MS = 5000L

    /** 默认缓存提前刷新时间（毫秒），5分钟 */
    const val DEFAULT_REFRESH_AHEAD_MS = 5 * 60 * 1000L
}
