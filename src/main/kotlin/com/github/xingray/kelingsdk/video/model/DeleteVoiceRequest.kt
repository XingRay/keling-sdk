package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 删除自定义音色请求
 * 基于文档3-54节
 */
@Serializable
data class DeleteVoiceRequest(
    /** 待删除的音色ID，仅支持删除自定义音色 */
    @SerialName("voice_id")
    val voiceId: String = ""
)
