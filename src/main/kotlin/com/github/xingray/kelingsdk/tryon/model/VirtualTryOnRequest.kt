package com.github.xingray.kelingsdk.tryon.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 虚拟试穿 创建任务请求
 */
@Serializable
data class VirtualTryOnRequest(
    /**
     * 模型名称
     * 枚举值：kolors-virtual-try-on-v1, kolors-virtual-try-on-v1-5
     */
    @SerialName("model_name")
    val modelName: String? = null,

    /**
     * 人物图片
     * 支持传入图片Base64编码或图片URL（确保可访问）
     * 图片格式支持 .jpg / .jpeg / .png
     * 图片文件大小不能超过10MB，图片宽高尺寸不小于300px
     */
    @SerialName("human_image")
    val humanImage: String = "",

    /**
     * 虚拟试穿的服饰图片
     * 支持上装(upper)、下装(lower)、连体装(dress)
     * V1.5模型还支持"上装+下装"组合输入
     * 支持传入图片Base64编码或图片URL（确保可访问）
     * 图片格式支持 .jpg / .jpeg / .png
     * 图片文件大小不能超过10MB，图片宽高尺寸不小于300px
     */
    @SerialName("cloth_image")
    val clothImage: String = "",

    /**
     * 回调通知地址
     * 任务状态变更时服务端主动通知
     */
    @SerialName("callback_url")
    val callbackUrl: String? = null,

    /**
     * 自定义任务ID
     * 用户自定义任务ID，单用户下需保证唯一性
     */
    @SerialName("external_task_id")
    val externalTaskId: String? = null
)
