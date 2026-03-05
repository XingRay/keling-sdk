package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Omni-Video 参考视频项
 */
@Serializable
data class OmniVideoItem(
    /** 参考视频的URL */
    @SerialName("video_url")
    val videoUrl: String = "",

    /** 参考视频类型，feature为特征参考视频，base为待编辑视频 */
    @SerialName("refer_type")
    val referType: String? = null,

    /** 是否保留视频原声，yes为保留，no为不保留 */
    @SerialName("keep_original_sound")
    val keepOriginalSound: String? = null
)
