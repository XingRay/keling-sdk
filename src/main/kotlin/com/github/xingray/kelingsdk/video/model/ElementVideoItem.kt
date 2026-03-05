package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 主体参考视频项
 */
@Serializable
data class ElementVideoItem(
    /** 视频URL */
    @SerialName("video_url")
    val videoUrl: String = ""
)
