package io.github.xingray.kelingsdk.image.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Omni-Image 主体参考项
 */
@Serializable
data class OmniElementItem(
    /** 主体库中的主体ID */
    @SerialName("element_id")
    val elementId: String = ""
)
