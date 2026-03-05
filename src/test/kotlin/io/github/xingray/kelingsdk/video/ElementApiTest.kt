package io.github.xingray.kelingsdk.video

import io.github.xingray.kelingsdk.createAndPollQuery
import io.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import io.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class ElementApiTest : BaseApiIntegrationTest() {

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.element.create(credentials, TestFixtures.createElementRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.element.create(token(), TestFixtures.createElementRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.element.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.createElementRequest(),
            maxAttempts = videoPollMaxAttempts,
            intervalMillis = videoPollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.element.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.element.queryByExternalId(credentials, TestFixtures.externalTaskId())
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.element.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }

    @Test
    fun queryPresetsList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.element.queryPresetsList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }

    @Test
    fun delete_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.element.delete(credentials, TestFixtures.deleteElementRequest())
        assertBasicResponse(response)
    }
}
