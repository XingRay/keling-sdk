package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 多图参考生视频-图片中的元素
 */
@Serializable
data class MultiImageElement(
    /** 主体ID */
    @SerialName("element_id")
    val elementId: String = "",

    /** 主体类型 */
    @SerialName("element_type")
    val elementType: String? = null
)
