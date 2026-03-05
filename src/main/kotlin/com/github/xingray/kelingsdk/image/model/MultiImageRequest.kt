package com.github.xingray.kelingsdk.image.model

import com.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 多图参考生图 创建任务请求
 */
@Serializable
data class MultiImageRequest(
    /** 模型名称，枚举值：kling-v2, kling-v2-1, kling-v3 */
    @SerialName("model_name")
    val modelName: String? = null,

    /** 正向文本提示词 */
    @SerialName("prompt")
    val prompt: String? = null,

    /** 参考主体图片列表，最多4张最少1张 */
    @SerialName("subject_image_list")
    val subjectImageList: List<SubjectImageItem> = emptyList(),

    /** 场景参考图URL或Base64 */
    @SerialName("scene_image")
    val sceneImage: String? = null,

    /** 风格参考图URL或Base64 */
    @SerialName("style_image")
    val styleImage: String? = null,

    /** 生成图片数量，取值范围[1,9] */
    @SerialName("n")
    val n: Int? = null,

    /** 画面纵横比 */
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
