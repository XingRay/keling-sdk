package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 人脸识别结果数据
 */
@Serializable
data class FaceDetectData(
    /** 人脸列表 */
    @SerialName("face_list")
    val faceList: List<FaceItem>? = null
)
