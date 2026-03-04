package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 多模态视频编辑-增加/删减视频选区请求
 * 基于文档3-17和3-18节
 */
@Serializable
data class MultiModalEditSelectionRequest(
    /** 会话ID */
    @SerialName("session_id")
    val sessionId: String = "",

    /** 帧号，最多支持10个标记帧 */
    @SerialName("frame_index")
    val frameIndex: Int = 0,

    /** 点选坐标列表，某一帧最多可标记10个点 */
    @SerialName("points")
    val points: List<SelectionPoint> = emptyList()
)
