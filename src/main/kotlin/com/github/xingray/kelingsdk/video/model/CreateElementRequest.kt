package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 创建高级自定义主体请求
 * 基于文档3-45节
 */
@Serializable
data class CreateElementRequest(
    /** 主体名称，不超过20字符 */
    @SerialName("element_name")
    val elementName: String = "",

    /** 主体描述，不超过100字符 */
    @SerialName("element_description")
    val elementDescription: String = "",

    /** 主体参考方式，枚举值：video_refer(视频角色主体), image_refer(多图主体) */
    @SerialName("reference_type")
    val referenceType: String = "",

    /** 主体参考图列表，reference_type为image_refer时必填 */
    @SerialName("element_image_list")
    val elementImageList: List<ElementImageItem>? = null,

    /** 主体参考视频列表，reference_type为video_refer时必填 */
    @SerialName("element_video_list")
    val elementVideoList: List<ElementVideoItem>? = null,

    /** 主体音色ID，可绑定音色库中已有音色 */
    @SerialName("element_voice_id")
    val elementVoiceId: String? = null,

    /** 主体标签列表 */
    @SerialName("tag_list")
    val tagList: List<ElementTag>? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null
)
