package com.github.xingray.kelingsdk.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TaskDataSurrogate(
    @SerialName("task_id")
    val taskId: String = "",
    @SerialName("external_task_id")
    val externalTaskId: String? = null,
    @SerialName("task_status")
    val taskStatus: String = "",
    @SerialName("task_status_msg")
    val taskStatusMsg: String? = null,
    @SerialName("created_at")
    val createdAt: Long = 0,
    @SerialName("updated_at")
    val updatedAt: Long = 0,
    @SerialName("task_result")
    val taskResult: TaskResult? = null,
    @SerialName("final_unit_deduction")
    val finalUnitDeduction: Double? = null
)
