package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 多模态视频编辑-坐标点
 */
@Serializable
data class SelectionPoint(
    /** 横坐标，取值范围[0,1]，百分比表示 */
    @SerialName("x")
    val x: Float = 0f,

    /** 纵坐标，取值范围[0,1]，百分比表示 */
    @SerialName("y")
    val y: Float = 0f
)
