package io.github.xingray.kelingsdk.video

import io.github.xingray.kelingsdk.createAndPollQuery
import io.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import io.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class VoiceCloneApiTest : BaseApiIntegrationTest() {

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.voiceClone.create(credentials, TestFixtures.voiceCloneRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.voiceClone.create(token(), TestFixtures.voiceCloneRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.voiceClone.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.voiceCloneRequest(),
            maxAttempts = 3,
            intervalMillis = 1000
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.voiceClone.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.voiceClone.queryByExternalId(credentials, TestFixtures.EXTERNAL_TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.voiceClone.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }

    @Test
    fun queryPresetsList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.voiceClone.queryPresetsList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }

    @Test
    fun delete_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.voiceClone.delete(credentials, TestFixtures.deleteVoiceRequest())
        assertBasicResponse(response)
    }
}
