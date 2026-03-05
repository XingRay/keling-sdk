package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 多模态视频编辑-清除选区/预览选区请求
 * 基于文档3-19和3-20节
 */
@Serializable
data class MultiModalEditSessionRequest(
    /** 会话ID */
    @SerialName("session_id")
    val sessionId: String = ""
)
