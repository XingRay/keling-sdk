package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 静态笔刷配置
 */
@Serializable
data class StaticMask(
    /** 静态笔刷涂抹区域，支持图片URL或Base64编码 */
    @SerialName("mask")
    val mask: String = "",

    /** 运动轨迹坐标序列 */
    @SerialName("trajectories")
    val trajectories: List<MaskTrajectory> = emptyList()
)
