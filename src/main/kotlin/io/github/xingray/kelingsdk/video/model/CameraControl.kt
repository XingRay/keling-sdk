package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 运镜控制
 */
@Serializable
data class CameraControl(
    /** 预定义的运镜类型，枚举值：simple, down_back, forward_up, right_turn_forward, left_turn_forward */
    @SerialName("type")
    val type: String? = null,

    /** 运镜配置参数，当type为simple时必填，6选1 */
    @SerialName("config")
    val config: CameraConfig? = null
)
