package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 运镜配置参数
 */
@Serializable
data class CameraConfig(
    /** 水平运镜，沿x轴平移，取值范围[-10, 10] */
    @SerialName("horizontal")
    val horizontal: Float? = null,

    /** 垂直运镜，沿y轴平移，取值范围[-10, 10] */
    @SerialName("vertical")
    val vertical: Float? = null,

    /** 水平摇镜，绕y轴旋转，取值范围[-10, 10] */
    @SerialName("pan")
    val pan: Float? = null,

    /** 垂直摇镜，沿x轴旋转，取值范围[-10, 10] */
    @SerialName("tilt")
    val tilt: Float? = null,

    /** 旋转运镜，绕z轴旋转，取值范围[-10, 10] */
    @SerialName("roll")
    val roll: Float? = null,

    /** 变焦，控制焦距变化，取值范围[-10, 10] */
    @SerialName("zoom")
    val zoom: Float? = null
)
