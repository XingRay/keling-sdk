package io.github.xingray.kelingsdk.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 水印配置信息
 */
@Serializable
data class WatermarkInfo(
    /** 是否启用水印 */
    @SerialName("enabled")
    val enabled: Boolean = false
)
