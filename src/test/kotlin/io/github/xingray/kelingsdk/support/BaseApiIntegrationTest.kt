package io.github.xingray.kelingsdk.support

import io.github.xingray.kelingsdk.KelingClient
import io.github.xingray.kelingsdk.auth.Credentials
import io.github.xingray.kelingsdk.common.ApiResponse
import io.github.xingray.kelingsdk.common.KelingConstants
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.BeforeEach
import kotlin.test.assertNotNull

abstract class BaseApiIntegrationTest {

    protected lateinit var credentials: Credentials
    protected lateinit var client: KelingClient

    @BeforeEach
    fun setUpClient() {
        if (!isEnvReady()) {
            printMissingEnvWarningOnce()
        }
        Assumptions.assumeTrue(
            isEnvReady(),
            "Skipping integration test: set $ENV_ACCESS_KEY and $ENV_SECRET_KEY"
        )
        credentials = Credentials(
            accessKey = requiredEnv(ENV_ACCESS_KEY),
            secretKey = requiredEnv(ENV_SECRET_KEY)
        )
        client = KelingClient(baseUrl = optionalEnv(ENV_BASE_URL) ?: KelingConstants.DEFAULT_BASE_URL)
    }

    @AfterEach
    fun tearDownClient() {
        if (::client.isInitialized) {
            client.close()
        }
    }

    protected fun assumeEnvReady() {
        Assumptions.assumeTrue(
            isEnvReady(),
            "Skipping integration test: set $ENV_ACCESS_KEY and $ENV_SECRET_KEY"
        )
    }

    protected fun token(): String = client.tokenGenerator.generateToken(credentials).token

    protected fun <T> assertBasicResponse(response: ApiResponse<T>) {
        println("[TEST_RESPONSE] $response")
        assertNotNull(response)
        assertNotNull(response.code)
    }

    private fun isEnvReady(): Boolean {
        return !requiredEnv(ENV_ACCESS_KEY).isBlank() && !requiredEnv(ENV_SECRET_KEY).isBlank()
    }

    private fun requiredEnv(name: String): String = System.getenv(name)?.trim().orEmpty()

    private fun optionalEnv(name: String): String? = System.getenv(name)?.trim()?.takeIf { it.isNotEmpty() }

    private fun printMissingEnvWarningOnce() {
        if (missingEnvWarningPrinted) {
            return
        }
        synchronized(BaseApiIntegrationTest::class.java) {
            if (missingEnvWarningPrinted) {
                return
            }
            System.err.println(
                "[WARN] KLING integration tests skipped: missing env vars $ENV_ACCESS_KEY / $ENV_SECRET_KEY"
            )
            missingEnvWarningPrinted = true
        }
    }

    companion object {
        const val ENV_ACCESS_KEY = "KLING_ACCESS_KEY"
        const val ENV_SECRET_KEY = "KLING_SECRET_KEY"
        const val ENV_BASE_URL = "KLING_BASE_URL"

        @Volatile
        private var missingEnvWarningPrinted: Boolean = false
    }
}
