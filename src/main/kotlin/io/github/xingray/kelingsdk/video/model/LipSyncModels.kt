package io.github.xingray.kelingsdk.video.model

import io.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 对口型-人脸识别请求
 * 基于文档3-30节
 */
@Serializable
data class LipSyncFaceDetectRequest(
    /** 通过可灵AI生成的视频ID，与video_url二选一 */
    @SerialName("video_id")
    val videoId: String? = null,

    /** 所上传视频的获取URL，与video_id二选一 */
    @SerialName("video_url")
    val videoUrl: String? = null
)

/**
 * 对口型-人脸选择项
 */
@Serializable
data class FaceChoose(
    /** 人脸ID，由人脸识别接口返回 */
    @SerialName("face_id")
    val faceId: String = "",

    /** 通过试听接口生成的音频ID，与sound_file二选一 */
    @SerialName("audio_id")
    val audioId: String? = null,

    /** 音频文件，支持Base64编码或音频URL，与audio_id二选一 */
    @SerialName("sound_file")
    val soundFile: String? = null,

    /** 音频裁剪起点时间(ms) */
    @SerialName("sound_start_time")
    val soundStartTime: Long = 0,

    /** 音频裁剪终点时间(ms) */
    @SerialName("sound_end_time")
    val soundEndTime: Long = 0,

    /** 裁剪后音频插入时间(ms) */
    @SerialName("sound_insert_time")
    val soundInsertTime: Long = 0,

    /** 音频音量大小，取值范围[0, 2] */
    @SerialName("sound_volume")
    val soundVolume: Float? = null,

    /** 原始视频音量大小，取值范围[0, 2] */
    @SerialName("original_audio_volume")
    val originalAudioVolume: Float? = null
)

/**
 * 对口型创建任务请求(新版)
 * 基于文档3-31节
 */
@Serializable
data class LipSyncRequest(
    /** 会话ID，由对口型人脸识别接口生成 */
    @SerialName("session_id")
    val sessionId: String = "",

    /** 指定人脸对口型，暂仅支持单人 */
    @SerialName("face_choose")
    val faceChoose: List<FaceChoose> = emptyList(),

    /** 水印配置 */
    @SerialName("watermark_info")
    val watermarkInfo: List<WatermarkInfo>? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null
)
