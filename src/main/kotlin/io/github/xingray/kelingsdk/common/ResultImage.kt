package io.github.xingray.kelingsdk.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 结果图片
 */
@Serializable
data class ResultImage(
    /** 图片索引 */
    @SerialName("index")
    val index: Int = 0,

    /** 图片URL */
    @SerialName("url")
    val url: String = "",

    /** 带水印的图片URL */
    @SerialName("watermark_url")
    val watermarkUrl: String? = null
)
