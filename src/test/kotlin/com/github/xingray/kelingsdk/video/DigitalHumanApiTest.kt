package com.github.xingray.kelingsdk.video

import com.github.xingray.kelingsdk.createAndPollQuery
import com.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import com.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class DigitalHumanApiTest : BaseApiIntegrationTest() {

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.digitalHuman.create(credentials, TestFixtures.digitalHumanRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.digitalHuman.create(token(), TestFixtures.digitalHumanRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.digitalHuman.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.digitalHumanRequest(),
            maxAttempts = videoPollMaxAttempts,
            intervalMillis = videoPollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.digitalHuman.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.digitalHuman.queryByExternalId(credentials, TestFixtures.externalTaskId())
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.digitalHuman.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }
}
