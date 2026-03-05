package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 视频特效创建任务请求(双人互动特效)
 * 基于文档3-34节，7款双人特效: snow_night_kiss, eternal_kiss, cheers_2026, kiss_pro, fight_pro, hug_pro, heart_gesture_pro
 */
@Serializable
data class VideoEffectDualRequest(
    /** 场景名称 */
    @SerialName("effect_scene")
    val effectScene: String = "",

    /** 双人特效输入 */
    @SerialName("input")
    val input: VideoEffectDualInput = VideoEffectDualInput(),

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null
)
