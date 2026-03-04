package io.github.xingray.kelingsdk.image.model

import io.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 图像生成 创建任务请求
 */
@Serializable
data class ImageGenerationRequest(
    /** 模型名称，枚举值：kling-v1, kling-v1-5, kling-v2, kling-v2-new, kling-v2-1, kling-v3 */
    @SerialName("model_name")
    val modelName: String? = null,

    /** 正向文本提示词，不超过2500字符 */
    @SerialName("prompt")
    val prompt: String = "",

    /** 负向文本提示词，不超过2500字符 */
    @SerialName("negative_prompt")
    val negativePrompt: String? = null,

    /** 参考图片URL或Base64编码 */
    @SerialName("image")
    val image: String? = null,

    /** 图片参考类型，枚举值：subject(角色特征), face(人物长相) */
    @SerialName("image_reference")
    val imageReference: String? = null,

    /** 图片参考强度，取值范围[0,1] */
    @SerialName("image_fidelity")
    val imageFidelity: Float? = null,

    /** 面部参考强度，取值范围[0,1] */
    @SerialName("human_fidelity")
    val humanFidelity: Float? = null,

    /** 主体参考列表 */
    @SerialName("element_list")
    val elementList: List<OmniElementItem>? = null,

    /** 生成图片清晰度，枚举值：1k, 2k */
    @SerialName("resolution")
    val resolution: String? = null,

    /** 生成图片数量，取值范围[1,9] */
    @SerialName("n")
    val n: Int? = null,

    /** 画面纵横比，枚举值：16:9, 9:16, 1:1, 4:3, 3:4, 3:2, 2:3, 21:9 */
    @SerialName("aspect_ratio")
    val aspectRatio: String? = null,

    /** 水印配置 */
    @SerialName("watermark_info")
    val watermarkInfo: WatermarkInfo? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null
)
