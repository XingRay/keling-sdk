package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 自定义音色创建请求
 * 基于文档3-50节
 */
@Serializable
data class VoiceCloneRequest(
    /** 音色名称，不超过20字符 */
    @SerialName("voice_name")
    val voiceName: String = "",

    /** 音色数据文件获取链接，支持.mp3/.wav/.mp4/.mov */
    @SerialName("voice_url")
    val voiceUrl: String? = null,

    /** 历史作品ID，可引用历史作品提供音频素材 */
    @SerialName("video_id")
    val videoId: String? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null
)
