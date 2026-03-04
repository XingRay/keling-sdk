package io.github.xingray.kelingsdk.video.model

import io.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Omni-Video 创建任务请求
 * 基于文档3-1节
 */
@Serializable
data class OmniVideoRequest(
    /** 模型名称，枚举值：kling-video-o1, kling-v3-omni */
    @SerialName("model_name")
    val modelName: String? = null,

    /** 是否生成多镜头视频 */
    @SerialName("multi_shot")
    val multiShot: Boolean? = null,

    /** 分镜方式，枚举值：customize */
    @SerialName("shot_type")
    val shotType: String? = null,

    /** 文本提示词，不超过2500字符 */
    @SerialName("prompt")
    val prompt: String? = null,

    /** 各分镜信息，最多支持6个分镜 */
    @SerialName("multi_prompt")
    val multiPrompt: List<MultiPromptItem>? = null,

    /** 参考图列表，最多7张(有视频时最多4张) */
    @SerialName("image_list")
    val imageList: List<OmniVideoImageItem>? = null,

    /** 主体参考列表 */
    @SerialName("element_list")
    val elementList: List<OmniVideoElementItem>? = null,

    /** 参考视频列表，至多1段视频 */
    @SerialName("video_list")
    val videoList: List<OmniVideoItem>? = null,

    /** 是否同时生成声音，枚举值：on, off */
    @SerialName("sound")
    val sound: String? = null,

    /** 生成视频的模式，枚举值：std(标准模式), pro(专家模式) */
    @SerialName("mode")
    val mode: String? = null,

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
