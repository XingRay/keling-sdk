package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 多图参考生视频-参考图片项
 */
@Serializable
data class MultiImageItem(
    /** 图片URL或Base64编码 */
    @SerialName("image_url")
    val imageUrl: String = "",

    /** 图片中的元素列表 */
    @SerialName("elements")
    val elements: List<MultiImageElement>? = null
)
