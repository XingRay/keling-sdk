package com.github.xingray.kelingsdk.image

import com.github.xingray.kelingsdk.createAndPollQuery
import com.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import com.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class ImageExpandApiTest : BaseApiIntegrationTest() {

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageExpand.create(credentials, TestFixtures.imageExpandRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageExpand.create(token(), TestFixtures.imageExpandRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageExpand.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.imageExpandRequest(),
            maxAttempts = imagePollMaxAttempts,
            intervalMillis = imagePollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageExpand.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageExpand.queryByExternalId(credentials, TestFixtures.externalTaskId())
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageExpand.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }
}
