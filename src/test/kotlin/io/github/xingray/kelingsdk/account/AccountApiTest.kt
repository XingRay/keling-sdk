package io.github.xingray.kelingsdk.account

import io.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import io.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class AccountApiTest : BaseApiIntegrationTest() {

    @Test
    fun queryCosts_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.account.queryCosts(
            credentials = credentials,
            startTime = TestFixtures.START_TIME,
            endTime = TestFixtures.END_TIME,
            resourcePackName = TestFixtures.RESOURCE_PACK_NAME
        )
        assertBasicResponse(response)
    }

    @Test
    fun queryCosts_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.account.queryCosts(
            token = token(),
            startTime = TestFixtures.START_TIME,
            endTime = TestFixtures.END_TIME
        )
        assertBasicResponse(response)
    }
}
