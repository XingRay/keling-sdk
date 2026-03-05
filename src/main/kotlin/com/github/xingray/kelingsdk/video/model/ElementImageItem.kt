package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 主体参考图片项
 */
@Serializable
data class ElementImageItem(
    /** 图片URL或Base64编码 */
    @SerialName("image_url")
    val imageUrl: String = "",

    /** 是否为正面参考图 */
    @SerialName("frontal_image")
    val frontalImage: Boolean? = null
)
