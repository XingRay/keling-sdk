package io.github.xingray.kelingsdk.auth

/**
 * API凭证
 * 封装可灵AI API的 AccessKey 和 SecretKey
 *
 * 在服务端维护多个 apikey 的场景下，可以为每个请求指定不同的凭证：
 * ```kotlin
 * val credentials1 = Credentials("ak1", "sk1")
 * val credentials2 = Credentials("ak2", "sk2")
 * client.omniImage.create(credentials1, request)
 * client.omniImage.create(credentials2, request)
 * ```
 *
 * @param accessKey 可灵AI API AccessKey
 * @param secretKey 可灵AI API SecretKey
 */
data class Credentials(
    /** 可灵AI API AccessKey */
    val accessKey: String,
    /** 可灵AI API SecretKey */
    val secretKey: String
)
