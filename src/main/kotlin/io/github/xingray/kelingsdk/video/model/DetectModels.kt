package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 图像识别请求
 * 基于文档3-44节
 */
@Serializable
data class ImageRecognizeRequest(
    /** 待识别的图片，支持图片URL或Base64编码 */
    @SerialName("image")
    val image: String = ""
)

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

/**
 * 人脸识别结果数据
 */
@Serializable
data class FaceDetectData(
    /** 人脸列表 */
    @SerialName("face_list")
    val faceList: List<FaceItem>? = null
)

/**
 * 识别到的图像元素项
 */
@Serializable
data class ImageElementItem(
    /** 元素ID */
    @SerialName("element_id")
    val elementId: String = "",

    /** 元素类型 */
    @SerialName("element_type")
    val elementType: String? = null,

    /** 元素边界框 */
    @SerialName("bbox")
    val bbox: List<Float>? = null
)

/**
 * 图像元素识别结果数据
 */
@Serializable
data class ImageElementData(
    /** 元素列表 */
    @SerialName("element_list")
    val elementList: List<ImageElementItem>? = null
)
