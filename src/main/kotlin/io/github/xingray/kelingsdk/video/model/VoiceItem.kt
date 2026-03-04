package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 音色引用项
 */
@Serializable
data class VoiceItem(
    /** 音色ID，通过音色定制接口返回或使用系统预置音色 */
    @SerialName("voice_id")
    val voiceId: String = ""
)
