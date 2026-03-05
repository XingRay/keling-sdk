package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
