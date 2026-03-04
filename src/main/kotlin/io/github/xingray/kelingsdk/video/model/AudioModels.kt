package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 视频生音效创建任务请求
 * 基于文档3-40节
 */
@Serializable
data class VideoSfxRequest(
    /** 通过可灵AI生成的视频ID，与video_url二选一 */
    @SerialName("video_id")
    val videoId: String? = null,

    /** 所上传视频的获取链接，与video_id二选一 */
    @SerialName("video_url")
    val videoUrl: String? = null,

    /** 音效生成提示词，不超过200字符 */
    @SerialName("sound_effect_prompt")
    val soundEffectPrompt: String? = null,

    /** 配乐生成提示词，不超过200字符 */
    @SerialName("bgm_prompt")
    val bgmPrompt: String? = null,

    /** 是否开启ASMR模式，增强细节音效 */
    @SerialName("asmr_mode")
    val asmrMode: Boolean? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null
)

/**
 * 文生音效创建任务请求
 * 基于文档3-37节
 */
@Serializable
data class TextSfxRequest(
    /** 文本提示词，不超过200字符 */
    @SerialName("prompt")
    val prompt: String = "",

    /** 生成音频时长(秒)，取值范围3.0~10.0，支持小数点后一位 */
    @SerialName("duration")
    val duration: Float = 5.0f,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null
)

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

/**
 * 自定义音色创建请求
 * 基于文档3-50节
 */
@Serializable
data class VoiceCloneRequest(
    /** 音色名称，不超过20字符 */
    @SerialName("voice_name")
    val voiceName: String = "",

    /** 音色数据文件获取链接，支持.mp3/.wav/.mp4/.mov */
    @SerialName("voice_url")
    val voiceUrl: String? = null,

    /** 历史作品ID，可引用历史作品提供音频素材 */
    @SerialName("video_id")
    val videoId: String? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null
)

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
