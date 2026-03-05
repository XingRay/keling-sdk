package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 主体标签项
 */
@Serializable
data class ElementTag(
    /** 标签ID，如o_101(热梗), o_102(人物)等 */
    @SerialName("tag_id")
    val tagId: String = ""
)
