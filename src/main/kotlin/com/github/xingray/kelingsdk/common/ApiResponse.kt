package com.github.xingray.kelingsdk.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 可灵AI API 通用响应包装类
 * @param T 响应数据类型
 */
@Serializable
data class ApiResponse<T>(
    /** 业务状态码，0表示成功 */
    @SerialName("code")
    val code: Int = 0,

    /** 响应消息 */
    @SerialName("message")
    val message: String = "",

    /** 请求ID */
    @SerialName("request_id")
    val requestId: String = "",

    /** 响应数据 */
    @SerialName("data")
    val data: T? = null
)
