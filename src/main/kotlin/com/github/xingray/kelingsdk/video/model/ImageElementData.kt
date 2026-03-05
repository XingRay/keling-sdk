package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 图像元素识别结果数据
 */
@Serializable
data class ImageElementData(
    /** 元素列表 */
    @SerialName("element_list")
    val elementList: List<ImageElementItem>? = null
)
