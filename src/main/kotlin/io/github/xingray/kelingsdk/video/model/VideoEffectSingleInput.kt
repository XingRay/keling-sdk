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
