package io.github.xingray.kelingsdk.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 结果视频
 */
@Serializable
data class ResultVideo(
    /** 视频ID */
    @SerialName("id")
    val id: String = "",

    /** 视频URL */
    @SerialName("url")
    val url: String = "",

    /** 带水印的视频URL */
    @SerialName("watermark_url")
    val watermarkUrl: String? = null,

    /** 视频时长(秒) */
    @SerialName("duration")
    val duration: String? = null
)
