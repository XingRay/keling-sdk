package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 多模态视频编辑-初始化待编辑视频请求
 * 基于文档3-16节
 */
@Serializable
data class MultiModalEditInitRequest(
    /** 视频ID，与video_url二选一 */
    @SerialName("video_id")
    val videoId: String? = null,

    /** 视频URL，与video_id二选一 */
    @SerialName("video_url")
    val videoUrl: String? = null
)
