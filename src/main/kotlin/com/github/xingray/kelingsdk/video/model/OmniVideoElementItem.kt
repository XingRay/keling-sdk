package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Omni-Video 主体参考项
 */
@Serializable
data class OmniVideoElementItem(
    /** 主体库中的主体ID */
    @SerialName("element_id")
    val elementId: String = ""
)
