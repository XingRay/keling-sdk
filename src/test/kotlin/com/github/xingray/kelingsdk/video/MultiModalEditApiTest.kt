package com.github.xingray.kelingsdk.video

import com.github.xingray.kelingsdk.createAndPollQuery
import com.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import com.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class MultiModalEditApiTest : BaseApiIntegrationTest() {

    @Test
    fun initSelection_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.multiModalEdit.initSelection(credentials, TestFixtures.multiModalEditInitRequest())
        assertBasicResponse(response)
    }

    @Test
    fun initSelection_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.multiModalEdit.initSelection(token(), TestFixtures.multiModalEditInitRequest())
        assertBasicResponse(response)
    }

    @Test
    fun addSelection_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.multiModalEdit.addSelection(credentials, TestFixtures.multiModalEditSelectionRequest())
        assertBasicResponse(response)
    }

    @Test
    fun deleteSelection_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.multiModalEdit.deleteSelection(credentials, TestFixtures.multiModalEditSelectionRequest())
        assertBasicResponse(response)
    }

    @Test
    fun clearSelection_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.multiModalEdit.clearSelection(credentials, TestFixtures.multiModalEditSessionRequest())
        assertBasicResponse(response)
    }

    @Test
    fun previewSelection_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.multiModalEdit.previewSelection(credentials, TestFixtures.multiModalEditSessionRequest())
        assertBasicResponse(response)
    }

    @Test
    fun create_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.multiModalEdit.create(credentials, TestFixtures.multiModalEditRequest())
        assertBasicResponse(response)
    }

    @Test
    fun createAndPollQuery_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.multiModalEdit.createAndPollQuery(
            credentials = credentials,
            request = TestFixtures.multiModalEditRequest(),
            maxAttempts = videoPollMaxAttempts,
            intervalMillis = videoPollIntervalMillis
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryById_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.multiModalEdit.queryById(credentials, TestFixtures.TASK_ID)
        assertBasicResponse(response)
    }

    @Test
    fun queryByExternalId_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.multiModalEdit.queryByExternalId(credentials, TestFixtures.externalTaskId())
        assertBasicResponse(response)
    }

    @Test
    fun queryList_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.multiModalEdit.queryList(credentials, pageNum = 1, pageSize = 10)
        assertBasicResponse(response)
    }
}
