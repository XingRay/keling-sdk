package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Omni-Video 参考图片项
 */
@Serializable
data class OmniVideoImageItem(
    /** 图片URL或Base64编码 */
    @SerialName("image_url")
    val imageUrl: String = "",

    /** 图片类型，first_frame为首帧，end_frame为尾帧，不设置时为普通参考图 */
    @SerialName("type")
    val type: String? = null
)
