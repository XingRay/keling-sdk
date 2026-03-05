package com.github.xingray.kelingsdk.video.model

import com.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
