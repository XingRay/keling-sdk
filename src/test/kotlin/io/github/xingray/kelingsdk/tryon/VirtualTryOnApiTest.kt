package io.github.xingray.kelingsdk.tryon

import io.github.xingray.kelingsdk.createAndPollQuery
import io.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import io.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class VirtualTryOnApiTest : BaseApiIntegrationTest() {

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.virtualTryOn.create(credentials, TestFixtures.virtualTryOnRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.virtualTryOn.create(token(), TestFixtures.virtualTryOnRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.virtualTryOn.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.virtualTryOnRequest(),
            maxAttempts = imagePollMaxAttempts,
            intervalMillis = imagePollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.virtualTryOn.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.virtualTryOn.queryByExternalId(credentials, TestFixtures.externalTaskId())
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.virtualTryOn.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }
}
