package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 识别到的人脸项
 */
@Serializable
data class FaceItem(
    /** 人脸ID */
    @SerialName("face_id")
    val faceId: String = "",

    /** 人脸边界框 */
    @SerialName("bbox")
    val bbox: List<Float>? = null
)
