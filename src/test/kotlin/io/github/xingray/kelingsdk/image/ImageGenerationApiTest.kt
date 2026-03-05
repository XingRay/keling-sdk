package io.github.xingray.kelingsdk.image

import io.github.xingray.kelingsdk.createAndPollQuery
import io.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import io.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class ImageGenerationApiTest : BaseApiIntegrationTest() {

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageGeneration.create(credentials, TestFixtures.imageGenerationRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageGeneration.create(token(), TestFixtures.imageGenerationRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageGeneration.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.imageGenerationRequest(),
            maxAttempts = imagePollMaxAttempts,
            intervalMillis = imagePollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageGeneration.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageGeneration.queryByExternalId(credentials, TestFixtures.externalTaskId())
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageGeneration.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }
}
