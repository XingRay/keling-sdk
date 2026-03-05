package com.github.xingray.kelingsdk.image.model

import com.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Omni-Image 创建任务请求
 */
@Serializable
data class OmniImageRequest(
    /** 模型名称，枚举值：kling-image-o1, kling-v3-omni */
    @SerialName("model_name")
    val modelName: String? = null,

    /** 文本提示词，不超过2500字符 */
    @SerialName("prompt")
    val prompt: String = "",

    /** 参考图列表 */
    @SerialName("image_list")
    val imageList: List<OmniImageItem>? = null,

    /** 主体参考列表 */
    @SerialName("element_list")
    val elementList: List<OmniElementItem>? = null,

    /** 生成图片清晰度，枚举值：1k, 2k, 4k */
    @SerialName("resolution")
    val resolution: String? = null,

    /** 生成结果类型，枚举值：single, series */
    @SerialName("result_type")
    val resultType: String? = null,

    /** 生成图片数量，取值范围[1,9] */
    @SerialName("n")
    val n: Int? = null,

    /** 组图数量，取值范围[2,9]，result_type=series时有效 */
    @SerialName("series_amount")
    val seriesAmount: Int? = null,

    /** 画面纵横比，枚举值：16:9, 9:16, 1:1, 4:3, 3:4, 3:2, 2:3, 21:9, auto */
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
