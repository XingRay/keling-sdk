package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 语音合成(TTS)请求
 * 基于文档3-43节
 */
@Serializable
data class TtsRequest(
    /** 合成音频的文案，最大长度1000 */
    @SerialName("text")
    val text: String = "",

    /** 音色ID */
    @SerialName("voice_id")
    val voiceId: String = "",

    /** 音色语种，枚举值：zh, en */
    @SerialName("voice_language")
    val voiceLanguage: String = "",

    /** 语速，有效范围0.8~2.0 */
    @SerialName("voice_speed")
    val voiceSpeed: Float? = null
)
