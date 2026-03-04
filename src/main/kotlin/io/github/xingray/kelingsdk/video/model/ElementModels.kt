package io.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 主体参考图片项
 */
@Serializable
data class ElementImageItem(
    /** 图片URL或Base64编码 */
    @SerialName("image_url")
    val imageUrl: String = "",

    /** 是否为正面参考图 */
    @SerialName("frontal_image")
    val frontalImage: Boolean? = null
)

/**
 * 主体参考视频项
 */
@Serializable
data class ElementVideoItem(
    /** 视频URL */
    @SerialName("video_url")
    val videoUrl: String = ""
)

/**
 * 主体标签项
 */
@Serializable
data class ElementTag(
    /** 标签ID，如o_101(热梗), o_102(人物)等 */
    @SerialName("tag_id")
    val tagId: String = ""
)

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

/**
 * 删除自定义主体请求
 * 基于文档3-49节
 */
@Serializable
data class DeleteElementRequest(
    /** 要删除的主体ID，仅支持删除自定义主体 */
    @SerialName("element_id")
    val elementId: String = ""
)

/**
 * 主体数据
 */
@Serializable
data class ElementData(
    /** 主体ID */
    @SerialName("element_id")
    val elementId: String = "",

    /** 主体名称 */
    @SerialName("element_name")
    val elementName: String? = null,

    /** 主体类型 */
    @SerialName("element_type")
    val elementType: String? = null,

    /** 主体状态 */
    @SerialName("status")
    val status: String? = null,

    /** 主体图片列表 */
    @SerialName("images")
    val images: List<String>? = null,

    /** 创建时间 */
    @SerialName("created_at")
    val createdAt: Long? = null,

    /** 更新时间 */
    @SerialName("updated_at")
    val updatedAt: Long? = null
)
