package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 删除自定义主体请求
 * 基于文档3-49节
 */
@Serializable
data class DeleteElementRequest(
    /** 要删除的主体ID，仅支持删除自定义主体 */
    @SerialName("element_id")
    val elementId: String = ""
)
