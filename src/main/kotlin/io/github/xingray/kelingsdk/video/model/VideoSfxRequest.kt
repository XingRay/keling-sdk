package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 视频生音效创建任务请求
 * 基于文档3-40节
 */
@Serializable
data class VideoSfxRequest(
    /** 通过可灵AI生成的视频ID，与video_url二选一 */
    @SerialName("video_id")
    val videoId: String? = null,

    /** 所上传视频的获取链接，与video_id二选一 */
    @SerialName("video_url")
    val videoUrl: String? = null,

    /** 音效生成提示词，不超过200字符 */
    @SerialName("sound_effect_prompt")
    val soundEffectPrompt: String? = null,

    /** 配乐生成提示词，不超过200字符 */
    @SerialName("bgm_prompt")
    val bgmPrompt: String? = null,

    /** 是否开启ASMR模式，增强细节音效 */
    @SerialName("asmr_mode")
    val asmrMode: Boolean? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null
)
