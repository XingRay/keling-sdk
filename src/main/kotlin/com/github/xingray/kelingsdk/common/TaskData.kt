package com.github.xingray.kelingsdk.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 异步任务创建返回数据
 * 兼容部分接口在 data 字段返回对象或数组两种形态。
 */
//@Serializable(with = TaskDataFlexibleSerializer::class)
@Serializable
data class TaskData(
    /** 系统生成的任务ID */
    @SerialName("task_id")
    val taskId: String = "",

    /** 用户自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null,

    /** 任务状态 */
    @SerialName("task_status")
    val taskStatus: String = "",

    /** 任务状态消息 */
    @SerialName("task_status_msg")
    val taskStatusMsg: String? = null,

    /** 任务创建时间 */
    @SerialName("created_at")
    val createdAt: Long = 0,

    /** 任务更新时间 */
    @SerialName("updated_at")
    val updatedAt: Long = 0,

    /** 任务结果信息 */
    @SerialName("task_result")
    val taskResult: TaskResult? = null,

    /** 积分消耗 */
    @SerialName("final_unit_deduction")
    val finalUnitDeduction: Double? = null
)
