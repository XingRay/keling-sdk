package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 视频特效单图输入
 */
@Serializable
data class VideoEffectSingleInput(
    /** 参考图像，支持图片URL或Base64编码 */
    @SerialName("image")
    val image: String = ""
)

/**
 * 视频特效双人输入
 */
@Serializable
data class VideoEffectDualInput(
    /** 参考图像组，数组长度必须为2 */
    @SerialName("images")
    val images: List<String> = emptyList()
)

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
