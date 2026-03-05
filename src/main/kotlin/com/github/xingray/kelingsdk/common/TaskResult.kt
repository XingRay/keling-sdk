package com.github.xingray.kelingsdk.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 任务结果数据
 */
@Serializable
data class TaskResult(
    /** 结果图片列表 */
    @SerialName("images")
    val images: List<ResultImage>? = null,

    /** 结果视频列表 */
    @SerialName("videos")
    val videos: List<ResultVideo>? = null
)
