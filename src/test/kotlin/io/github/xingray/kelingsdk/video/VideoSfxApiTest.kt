package io.github.xingray.kelingsdk.video

import io.github.xingray.kelingsdk.createAndPollQuery
import io.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import io.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class VideoSfxApiTest : BaseApiIntegrationTest() {

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoSfx.create(credentials, TestFixtures.videoSfxRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoSfx.create(token(), TestFixtures.videoSfxRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoSfx.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.videoSfxRequest(),
            maxAttempts = 3,
            intervalMillis = 1000
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoSfx.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoSfx.queryByExternalId(credentials, TestFixtures.EXTERNAL_TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoSfx.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }
}
