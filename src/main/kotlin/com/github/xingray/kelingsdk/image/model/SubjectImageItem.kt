package com.github.xingray.kelingsdk.image.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 多图参考主体图片项
 */
@Serializable
data class SubjectImageItem(
    /** 图片URL或Base64编码 */
    @SerialName("image")
    val image: String = ""
)
