package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 动态笔刷配置
 */
@Serializable
data class DynamicMask(
    /** 动态笔刷涂抹区域，支持图片URL或Base64编码 */
    @SerialName("mask")
    val mask: String = "",

    /** 运动轨迹坐标序列，坐标个数取值范围[2, 77] */
    @SerialName("trajectories")
    val trajectories: List<MaskTrajectory> = emptyList()
)
