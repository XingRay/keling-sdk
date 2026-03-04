package io.github.xingray.kelingsdk.video.model

import io.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 动作控制创建任务请求
 * 基于文档3-13节
 */
@Serializable
data class ActionControlRequest(
    /** 文本提示词，不超过2500字符 */
    @SerialName("prompt")
    val prompt: String? = null,

    /** 参考图像URL或Base64编码 */
    @SerialName("image_url")
    val imageUrl: String = "",

    /** 参考视频的获取链接 */
    @SerialName("video_url")
    val videoUrl: String = "",

    /** 是否保留视频原声，枚举值：yes, no */
    @SerialName("keep_original_sound")
    val keepOriginalSound: String? = null,

    /** 人物朝向，枚举值：image(与图片一致), video(与视频一致) */
    @SerialName("character_orientation")
    val characterOrientation: String = "",

    /** 生成视频的模式，枚举值：std(标准模式), pro(专家模式) */
    @SerialName("mode")
    val mode: String = "",

    /** 水印配置 */
    @SerialName("watermark_info")
    val watermarkInfo: List<WatermarkInfo>? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null
)
