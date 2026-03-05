package com.github.xingray.kelingsdk.video

import com.github.xingray.kelingsdk.createAndPollQuery
import com.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import com.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class Text2VideoApiTest : BaseApiIntegrationTest() {

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.text2Video.create(credentials, TestFixtures.text2VideoRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.text2Video.create(token(), TestFixtures.text2VideoRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.text2Video.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.text2VideoRequest(),
            maxAttempts = videoPollMaxAttempts,
            intervalMillis = videoPollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.text2Video.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.text2Video.queryByExternalId(credentials, TestFixtures.externalTaskId())
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.text2Video.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }
}
