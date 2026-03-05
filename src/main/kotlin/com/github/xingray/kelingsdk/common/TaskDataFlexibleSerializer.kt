package com.github.xingray.kelingsdk.common

import kotlinx.serialization.KSerializer
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
