package com.github.xingray.kelingsdk.video

import com.github.xingray.kelingsdk.createAndPollQuery
import com.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import com.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class LipSyncApiTest : BaseApiIntegrationTest() {

    @Test
    fun identifyFace_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.lipSync.identifyFace(credentials, TestFixtures.lipSyncFaceDetectRequest())
        assertBasicResponse(response)
    }

    @Test
    fun identifyFace_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.lipSync.identifyFace(token(), TestFixtures.lipSyncFaceDetectRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.lipSync.create(credentials, TestFixtures.lipSyncRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.lipSync.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.lipSyncRequest(),
            maxAttempts = videoPollMaxAttempts,
            intervalMillis = videoPollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.lipSync.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.lipSync.queryByExternalId(credentials, TestFixtures.externalTaskId())
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.lipSync.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }
}
