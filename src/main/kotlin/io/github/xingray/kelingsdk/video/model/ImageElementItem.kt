package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 识别到的图像元素项
 */
@Serializable
data class ImageElementItem(
    /** 元素ID */
    @SerialName("element_id")
    val elementId: String = "",

    /** 元素类型 */
    @SerialName("element_type")
    val elementType: String? = null,

    /** 元素边界框 */
    @SerialName("bbox")
    val bbox: List<Float>? = null
)
