package io.github.xingray.kelingsdk.video

import io.github.xingray.kelingsdk.createDualAndPollQuery
import io.github.xingray.kelingsdk.createSingleAndPollQuery
import io.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import io.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class VideoEffectApiTest : BaseApiIntegrationTest() {

    @Test
    fun createSingle_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoEffect.createSingle(credentials, TestFixtures.videoEffectSingleRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createSingle_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoEffect.createSingle(token(), TestFixtures.videoEffectSingleRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createDual_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoEffect.createDual(credentials, TestFixtures.videoEffectDualRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createSingleAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoEffect.createSingleAndPollQuery(
            credentials = credentials,
            request = TestFixtures.videoEffectSingleRequest(),
            maxAttempts = videoPollMaxAttempts,
            intervalMillis = videoPollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun createDualAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoEffect.createDualAndPollQuery(
            credentials = credentials,
            request = TestFixtures.videoEffectDualRequest(),
            maxAttempts = videoPollMaxAttempts,
            intervalMillis = videoPollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoEffect.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoEffect.queryByExternalId(credentials, TestFixtures.EXTERNAL_TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.videoEffect.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }
}
