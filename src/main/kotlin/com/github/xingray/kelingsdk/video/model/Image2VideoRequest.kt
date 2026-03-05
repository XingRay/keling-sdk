package com.github.xingray.kelingsdk.video.model

import com.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 图生视频创建任务请求
 * 基于文档3-7节
 */
@Serializable
data class Image2VideoRequest(
    /** 模型名称，枚举值：kling-v1, kling-v1-5, kling-v1-6, kling-v2-master, kling-v2-1, kling-v2-1-master, kling-v2-5-turbo, kling-v2-6, kling-v3 */
    @SerialName("model_name")
    val modelName: String? = null,

    /** 参考图像，支持图片URL或Base64编码 */
    @SerialName("image")
    val image: String? = null,

    /** 参考图像-尾帧控制，支持图片URL或Base64编码 */
    @SerialName("image_tail")
    val imageTail: String? = null,

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

    /** 生成视频的自由度，取值范围[0, 1] */
    @SerialName("cfg_scale")
    val cfgScale: Float? = null,

    /** 生成视频的模式，枚举值：std(标准模式), pro(专家模式) */
    @SerialName("mode")
    val mode: String? = null,

    /** 生成视频时长(秒)，枚举值：3~15 */
    @SerialName("duration")
    val duration: String? = null,

    /** 参考主体列表，最多3个 */
    @SerialName("element_list")
    val elementList: List<OmniVideoElementItem>? = null,

    /** 运镜控制 */
    @SerialName("camera_control")
    val cameraControl: CameraControl? = null,

    /** 动态笔刷配置列表，最多6组 */
    @SerialName("dynamic_masks")
    val dynamicMasks: List<DynamicMask>? = null,

    /** 静态笔刷涂抹区域 */
    @SerialName("static_mask")
    val staticMask: StaticMask? = null,

    /** 画面纵横比，枚举值：16:9, 9:16, 1:1 */
    @SerialName("aspect_ratio")
    val aspectRatio: String? = null,

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
