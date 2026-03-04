package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 视频特效双人输入
 */
@Serializable
data class VideoEffectDualInput(
    /** 参考图像组，数组长度必须为2 */
    @SerialName("images")
    val images: List<String> = emptyList()
)
