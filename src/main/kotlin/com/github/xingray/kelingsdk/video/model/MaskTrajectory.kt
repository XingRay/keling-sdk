package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 运动轨迹坐标点
 */
@Serializable
data class MaskTrajectory(
    /** 轨迹点横坐标，以输入图片左下角为原点 */
    @SerialName("x")
    val x: Int = 0,

    /** 轨迹点纵坐标，以输入图片左下角为原点 */
    @SerialName("y")
    val y: Int = 0
)
