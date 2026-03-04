package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 文生音效创建任务请求
 * 基于文档3-37节
 */
@Serializable
data class TextSfxRequest(
    /** 文本提示词，不超过200字符 */
    @SerialName("prompt")
    val prompt: String = "",

    /** 生成音频时长(秒)，取值范围3.0~10.0，支持小数点后一位 */
    @SerialName("duration")
    val duration: Float = 5.0f,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null
)
