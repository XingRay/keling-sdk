package com.github.xingray.kelingsdk.video.model

import com.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 视频续写(延长)创建任务请求
 * 基于文档3-24节
 */
@Serializable
data class VideoExtendRequest(
    /** 模型名称 */
    @SerialName("model_name")
    val modelName: String? = null,

    /** 视频ID，支持文本/图片/视频延长生成的视频ID(原视频不能超过3分钟) */
    @SerialName("video_id")
    val videoId: String = "",

    /** 正向文本提示词，不超过2500字符 */
    @SerialName("prompt")
    val prompt: String? = null,

    /** 负向文本提示词，不超过2500字符 */
    @SerialName("negative_prompt")
    val negativePrompt: String? = null,

    /** 提示词参考强度，取值范围[0, 1]，数值越大参考强度越大 */
    @SerialName("cfg_scale")
    val cfgScale: Float? = null,

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
