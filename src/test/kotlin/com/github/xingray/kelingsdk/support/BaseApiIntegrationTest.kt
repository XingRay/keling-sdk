package com.github.xingray.kelingsdk.support

import com.github.xingray.kelingsdk.KelingClient
import com.github.xingray.kelingsdk.auth.Credentials
import com.github.xingray.kelingsdk.common.ApiResponse
import com.github.xingray.kelingsdk.common.KelingConstants
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.BeforeEach
import kotlin.test.assertNotNull

abstract class BaseApiIntegrationTest {

    protected lateinit var credentials: Credentials
    protected lateinit var client: KelingClient

    protected val imagePollMaxAttempts: Int = 30
    protected val imagePollIntervalMillis: Long = 2000

    protected val videoPollMaxAttempts: Int = 150
    protected val videoPollIntervalMillis: Long = 2000

    protected val audioPollMaxAttempts: Int = 60
    protected val audioPollIntervalMillis: Long = 2000

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
