package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 多镜头分镜信息项
 */
@Serializable
data class MultiPromptItem(
    /** 分镜序号 */
    @SerialName("index")
    val index: Int = 0,

    /** 分镜提示词，最大长度不超过512 */
    @SerialName("prompt")
    val prompt: String = "",

    /** 分镜时长，不小于1，不大于总时长 */
    @SerialName("duration")
    val duration: Int = 0
)
