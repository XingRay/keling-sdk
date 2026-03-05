package com.github.xingray.kelingsdk.video.model

import com.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 文生视频创建任务请求
 * 基于文档3-4节
 */
@Serializable
data class Text2VideoRequest(
    /** 模型名称，枚举值：kling-v1, kling-v1-6, kling-v2-master, kling-v2-1-master, kling-v2-5-turbo, kling-v2-6, kling-v3 */
    @SerialName("model_name")
    val modelName: String? = null,

    /** 是否生成多镜头视频 */
    @SerialName("multi_shot")
    val multiShot: Boolean? = null,

    /** 分镜方式，枚举值：customize, intelligence */
    @SerialName("shot_type")
    val shotType: String? = null,

    /** 文本提示词，不超过2500字符 */
    @SerialName("prompt")
    val prompt: String? = null,

    /** 各分镜信息，最多支持6个分镜 */
    @SerialName("multi_prompt")
    val multiPrompt: List<MultiPromptItem>? = null,

    /** 负向文本提示词，不超过2500字符 */
    @SerialName("negative_prompt")
    val negativePrompt: String? = null,

    /** 生成视频时引用的音色列表，至多引用2个音色 */
    @SerialName("voice_list")
    val voiceList: List<VoiceItem>? = null,

    /** 是否同时生成声音，枚举值：on, off */
    @SerialName("sound")
    val sound: String? = null,

    /** 生成视频的自由度，取值范围[0, 1]，值越大与提示词相关性越强 */
    @SerialName("cfg_scale")
    val cfgScale: Float? = null,

    /** 生成视频的模式，枚举值：std(标准模式), pro(专家模式) */
    @SerialName("mode")
    val mode: String? = null,

    /** 运镜控制 */
    @SerialName("camera_control")
    val cameraControl: CameraControl? = null,

    /** 画面纵横比，枚举值：16:9, 9:16, 1:1 */
    @SerialName("aspect_ratio")
    val aspectRatio: String? = null,

    /** 生成视频时长(秒)，枚举值：3~15 */
    @SerialName("duration")
    val duration: String? = null,

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
