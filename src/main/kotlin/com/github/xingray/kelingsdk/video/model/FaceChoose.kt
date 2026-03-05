package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
