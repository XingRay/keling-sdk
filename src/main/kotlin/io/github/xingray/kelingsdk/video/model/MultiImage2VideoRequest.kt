package io.github.xingray.kelingsdk.video.model

import io.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 多图参考生视频创建任务请求
 * 基于文档3-10节(实际文档为3-10多图参考生视频)
 */
@Serializable
data class MultiImage2VideoRequest(
    /** 模型名称，枚举值：kling-v1-6 */
    @SerialName("model_name")
    val modelName: String? = null,

    /** 正向文本提示词，不超过2500字符 */
    @SerialName("prompt")
    val prompt: String = "",

    /** 负向文本提示词，不超过2500字符 */
    @SerialName("negative_prompt")
    val negativePrompt: String? = null,

    /** 参考图像列表，最多4张图片 */
    @SerialName("image_list")
    val imageList: List<MultiImageItem> = emptyList(),

    /** 生成视频的模式，枚举值：std(标准模式), pro(专家模式) */
    @SerialName("mode")
    val mode: String? = null,

    /** 生成视频时长(秒)，枚举值：5, 10 */
    @SerialName("duration")
    val duration: String? = null,

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
