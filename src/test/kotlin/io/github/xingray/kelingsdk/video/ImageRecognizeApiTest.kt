package io.github.xingray.kelingsdk.video

import io.github.xingray.kelingsdk.support.BaseApiIntegrationTest
import io.github.xingray.kelingsdk.support.TestFixtures
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class ImageRecognizeApiTest : BaseApiIntegrationTest() {

    @Test
    fun recognize_withCredentials_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageRecognize.recognize(credentials, TestFixtures.imageRecognizeRequest())
        assertBasicResponse(response)
    }

    @Test
    fun recognize_withToken_shouldReturnResponse() = runBlocking {
        assumeEnvReady()
        val response = client.imageRecognize.recognize(token(), TestFixtures.imageRecognizeRequest())
        assertBasicResponse(response)
    }
}
