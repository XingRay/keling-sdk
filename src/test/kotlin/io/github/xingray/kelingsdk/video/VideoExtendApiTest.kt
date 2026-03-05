package io.github.xingray.kelingsdk.video

import io.github.xingray.kelingsdk.createAndPollQuery
import io.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import io.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class VideoExtendApiTest : BaseApiIntegrationTest() {

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoExtend.create(credentials, TestFixtures.videoExtendRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoExtend.create(token(), TestFixtures.videoExtendRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoExtend.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.videoExtendRequest(),
            maxAttempts = videoPollMaxAttempts,
            intervalMillis = videoPollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoExtend.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoExtend.queryByExternalId(credentials, TestFixtures.externalTaskId())
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoExtend.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }
}
