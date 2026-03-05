package com.github.xingray.kelingsdk.image.model

import com.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 扩图 创建任务请求
 */
@Serializable
data class ImageExpandRequest(
    /** 参考图片URL或Base64编码 */
    @SerialName("image")
    val image: String = "",

    /** 向上扩充比例，基于原图高度，取值范围[0,2] */
    @SerialName("up_expansion_ratio")
    val upExpansionRatio: Float = 0f,

    /** 向下扩充比例，基于原图高度，取值范围[0,2] */
    @SerialName("down_expansion_ratio")
    val downExpansionRatio: Float = 0f,

    /** 向左扩充比例，基于原图宽度，取值范围[0,2] */
    @SerialName("left_expansion_ratio")
    val leftExpansionRatio: Float = 0f,

    /** 向右扩充比例，基于原图宽度，取值范围[0,2] */
    @SerialName("right_expansion_ratio")
    val rightExpansionRatio: Float = 0f,

    /** 正向文本提示词 */
    @SerialName("prompt")
    val prompt: String? = null,

    /** 生成图片数量，取值范围[1,9] */
    @SerialName("n")
    val n: Int? = null,

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
