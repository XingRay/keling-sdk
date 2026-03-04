package io.github.xingray.kelingsdk.common

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement

/**
 * 异步任务创建返回数据
 * 兼容部分接口在 data 字段返回对象或数组两种形态。
 */
@Serializable(with = TaskDataFlexibleSerializer::class)
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

@Serializable
private data class TaskDataSurrogate(
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

object TaskDataFlexibleSerializer : KSerializer<TaskData> {
    override val descriptor: SerialDescriptor = TaskDataSurrogate.serializer().descriptor

    override fun deserialize(decoder: Decoder): TaskData {
        if (decoder !is JsonDecoder) {
            val s = TaskDataSurrogate.serializer().deserialize(decoder)
            return s.toTaskData()
        }

        val raw = decoder.decodeJsonElement()
        val normalized: JsonElement = when (raw) {
            is JsonArray -> raw.firstOrNull() ?: JsonNull
            else -> raw
        }

        if (normalized is JsonNull) {
            return TaskData()
        }

        val s = decoder.json.decodeFromJsonElement(TaskDataSurrogate.serializer(), normalized)
        return s.toTaskData()
    }

    override fun serialize(encoder: Encoder, value: TaskData) {
        val surrogate = value.toSurrogate()
        if (encoder is JsonEncoder) {
            encoder.encodeJsonElement(encoder.json.encodeToJsonElement(TaskDataSurrogate.serializer(), surrogate))
        } else {
            TaskDataSurrogate.serializer().serialize(encoder, surrogate)
        }
    }

    private fun TaskDataSurrogate.toTaskData(): TaskData = TaskData(
        taskId = taskId,
        externalTaskId = externalTaskId,
        taskStatus = taskStatus,
        taskStatusMsg = taskStatusMsg,
        createdAt = createdAt,
        updatedAt = updatedAt,
        taskResult = taskResult,
        finalUnitDeduction = finalUnitDeduction
    )

    private fun TaskData.toSurrogate(): TaskDataSurrogate = TaskDataSurrogate(
        taskId = taskId,
        externalTaskId = externalTaskId,
        taskStatus = taskStatus,
        taskStatusMsg = taskStatusMsg,
        createdAt = createdAt,
        updatedAt = updatedAt,
        taskResult = taskResult,
        finalUnitDeduction = finalUnitDeduction
    )
}

/**
 * 任务结果数据
 */
@Serializable
data class TaskResult(
    /** 结果图片列表 */
    @SerialName("images")
    val images: List<ResultImage>? = null,

    /** 结果视频列表 */
    @SerialName("videos")
    val videos: List<ResultVideo>? = null
)

/**
 * 结果图片
 */
@Serializable
data class ResultImage(
    /** 图片索引 */
    @SerialName("index")
    val index: Int = 0,

    /** 图片URL */
    @SerialName("url")
    val url: String = "",

    /** 带水印的图片URL */
    @SerialName("watermark_url")
    val watermarkUrl: String? = null
)

/**
 * 结果视频
 */
@Serializable
data class ResultVideo(
    /** 视频ID */
    @SerialName("id")
    val id: String = "",

    /** 视频URL */
    @SerialName("url")
    val url: String = "",

    /** 带水印的视频URL */
    @SerialName("watermark_url")
    val watermarkUrl: String? = null,

    /** 视频时长(秒) */
    @SerialName("duration")
    val duration: String? = null
)
