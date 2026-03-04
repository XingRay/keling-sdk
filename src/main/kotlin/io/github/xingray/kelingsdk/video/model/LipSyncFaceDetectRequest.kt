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
