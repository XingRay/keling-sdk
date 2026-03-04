package io.github.xingray.kelingsdk.image.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Omni-Image 图像参考项
 */
@Serializable
data class OmniImageItem(
    /** 图片URL或Base64编码 */
    @SerialName("image_url")
    val imageUrl: String = ""
)
