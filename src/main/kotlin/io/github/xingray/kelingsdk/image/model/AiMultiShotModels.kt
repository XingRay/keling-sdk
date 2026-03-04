package io.github.xingray.kelingsdk.image.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 智能补全主体图 创建任务请求
 */
@Serializable
data class AiMultiShotRequest(
    /** 主体正面参考图URL或Base64 */
    @SerialName("element_frontal_image")
    val elementFrontalImage: String = "",

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null
)
