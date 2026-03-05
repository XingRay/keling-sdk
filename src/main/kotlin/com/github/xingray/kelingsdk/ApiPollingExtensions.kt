package com.github.xingray.kelingsdk

import com.github.xingray.kelingsdk.auth.Credentials
import com.github.xingray.kelingsdk.common.ApiResponse
import com.github.xingray.kelingsdk.common.TaskData
import com.github.xingray.kelingsdk.common.TaskStatus
import com.github.xingray.kelingsdk.image.*
import com.github.xingray.kelingsdk.image.model.*
import com.github.xingray.kelingsdk.tryon.VirtualTryOnApi
import com.github.xingray.kelingsdk.tryon.model.VirtualTryOnRequest
import com.github.xingray.kelingsdk.video.*
import com.github.xingray.kelingsdk.video.model.*
import kotlinx.coroutines.delay

private suspend fun submitAndPollQuery(
    submit: suspend () -> com.github.xingray.kelingsdk.common.ApiResponse<com.github.xingray.kelingsdk.common.TaskData>,
    queryById: suspend (taskId: String) -> com.github.xingray.kelingsdk.common.ApiResponse<com.github.xingray.kelingsdk.common.TaskData>,
    maxAttempts: Int,
    intervalMillis: Long
): com.github.xingray.kelingsdk.common.ApiResponse<com.github.xingray.kelingsdk.common.TaskData> {
    require(maxAttempts > 0) { "maxAttempts must be > 0" }
    require(intervalMillis >= 0) { "intervalMillis must be >= 0" }

    val submitResponse = submit()
    val taskId = submitResponse.data?.taskId
    if (taskId.isNullOrBlank()) {
        return submitResponse
    }

    var latestResponse = submitResponse
    repeat(maxAttempts) {
        val queryResponse = queryById(taskId)
        latestResponse = queryResponse
        val status = queryResponse.data?.taskStatus?.lowercase()
        if (status == TaskStatus.SUCCEED || status == TaskStatus.FAILED) {
            return queryResponse
        }
        if (intervalMillis > 0) {
            delay(intervalMillis)
        }
    }
    return latestResponse
}

suspend fun OmniImageApi.createAndPollQuery(
    credentials: Credentials,
    request: OmniImageRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun ImageGenerationApi.createAndPollQuery(
    credentials: Credentials,
    request: ImageGenerationRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun MultiImageApi.createAndPollQuery(
    credentials: Credentials,
    request: MultiImageRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun ImageExpandApi.createAndPollQuery(
    credentials: Credentials,
    request: ImageExpandRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun AiMultiShotApi.createAndPollQuery(
    credentials: Credentials,
    request: AiMultiShotRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun VirtualTryOnApi.createAndPollQuery(
    credentials: Credentials,
    request: VirtualTryOnRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun OmniVideoApi.createAndPollQuery(
    credentials: Credentials,
    request: OmniVideoRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun Text2VideoApi.createAndPollQuery(
    credentials: Credentials,
    request: Text2VideoRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun Image2VideoApi.createAndPollQuery(
    credentials: Credentials,
    request: Image2VideoRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun MultiImage2VideoApi.createAndPollQuery(
    credentials: Credentials,
    request: MultiImage2VideoRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun VideoExtendApi.createAndPollQuery(
    credentials: Credentials,
    request: VideoExtendRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun VideoEffectApi.createSingleAndPollQuery(
    credentials: Credentials,
    request: VideoEffectSingleRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { createSingle(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun VideoEffectApi.createDualAndPollQuery(
    credentials: Credentials,
    request: VideoEffectDualRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { createDual(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun MultiModalEditApi.createAndPollQuery(
    credentials: Credentials,
    request: MultiModalEditRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun ActionControlApi.createAndPollQuery(
    credentials: Credentials,
    request: ActionControlRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun DigitalHumanApi.createAndPollQuery(
    credentials: Credentials,
    request: DigitalHumanRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun LipSyncApi.createAndPollQuery(
    credentials: Credentials,
    request: LipSyncRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun VideoSfxApi.createAndPollQuery(
    credentials: Credentials,
    request: VideoSfxRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun TextSfxApi.createAndPollQuery(
    credentials: Credentials,
    request: TextSfxRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun ElementApi.createAndPollQuery(
    credentials: Credentials,
    request: CreateElementRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)

suspend fun VoiceCloneApi.createAndPollQuery(
    credentials: Credentials,
    request: VoiceCloneRequest,
    maxAttempts: Int = 30,
    intervalMillis: Long = 2000
): ApiResponse<TaskData> = submitAndPollQuery(
    submit = { create(credentials, request) },
    queryById = { queryById(credentials, it) },
    maxAttempts = maxAttempts,
    intervalMillis = intervalMillis
)
