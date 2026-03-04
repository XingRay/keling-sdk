package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 视频特效创建任务请求(单图特效)
 * 基于文档3-34节，217款单图特效
 */
@Serializable
data class VideoEffectSingleRequest(
    /** 场景名称，如raid_check, fortune_in_motion等 */
    @SerialName("effect_scene")
    val effectScene: String = "",

    /** 单图特效输入 */
    @SerialName("input")
    val input: VideoEffectSingleInput = VideoEffectSingleInput(),

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null
)
