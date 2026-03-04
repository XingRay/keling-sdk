package io.github.xingray.kelingsdk.image

import io.github.xingray.kelingsdk.createAndPollQuery
import io.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import io.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class AiMultiShotApiTest : BaseApiIntegrationTest() {

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.aiMultiShot.create(credentials, TestFixtures.aiMultiShotRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.aiMultiShot.create(token(), TestFixtures.aiMultiShotRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.aiMultiShot.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.aiMultiShotRequest(),
            maxAttempts = imagePollMaxAttempts,
            intervalMillis = imagePollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.aiMultiShot.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.aiMultiShot.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }
}
