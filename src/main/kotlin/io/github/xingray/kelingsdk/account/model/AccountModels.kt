package io.github.xingray.kelingsdk.account.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 资源包信息
 */
@Serializable
data class ResourcePackInfo(
    /** 资源包名称 */
    @SerialName("resource_pack_name")
    val resourcePackName: String = "",

    /** 资源包总积分 */
    @SerialName("total")
    val total: Double = 0.0,

    /** 已消耗积分 */
    @SerialName("consumed")
    val consumed: Double = 0.0,

    /** 剩余积分 */
    @SerialName("remaining")
    val remaining: Double = 0.0,

    /** 资源包生效时间 */
    @SerialName("effective_time")
    val effectiveTime: Long? = null,

    /** 资源包过期时间 */
    @SerialName("expire_time")
    val expireTime: Long? = null
)
