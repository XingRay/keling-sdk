package io.github.xingray.kelingsdk.video.model

import io.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 数字人创建任务请求
 * 基于文档3-27节
 */
@Serializable
data class DigitalHumanRequest(
    /** 数字人参考图，支持图片URL或Base64编码 */
    @SerialName("image")
    val image: String = "",

    /** 通过试听接口生成的音频ID，与sound_file二选一 */
    @SerialName("audio_id")
    val audioId: String? = null,

    /** 音频文件，支持Base64编码或音频URL，与audio_id二选一 */
    @SerialName("sound_file")
    val soundFile: String? = null,

    /** 正向文本提示词，可定义数字人动作/情绪/运镜，不超过2500字符 */
    @SerialName("prompt")
    val prompt: String? = null,

    /** 生成视频的模式，枚举值：std(标准模式), pro(专家模式) */
    @SerialName("mode")
    val mode: String? = null,

    /** 水印配置 */
    @SerialName("watermark_info")
    val watermarkInfo: List<WatermarkInfo>? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null
)
