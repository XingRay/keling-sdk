package io.github.xingray.kelingsdk

import io.github.xingray.kelingsdk.account.AccountApi
import io.github.xingray.kelingsdk.auth.*
import io.github.xingray.kelingsdk.common.KelingConstants
import io.github.xingray.kelingsdk.image.*
import io.github.xingray.kelingsdk.tryon.VirtualTryOnApi
import io.github.xingray.kelingsdk.video.*
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import java.io.Closeable

/**
 * 可灵AI SDK 客户端
 *
 * 提供可灵AI全部API功能的统一入口，包括：
 * - 图像生成（Omni-Image、文生图/图生图、多图参考生图、扩图、智能补全主体图）
 * - 视频生成（Omni-Video、文生视频、图生视频、多图参考生视频、视频续写、视频特效等）
 * - 数字人、对口型、音频处理
 * - 虚拟试穿
 * - 账号信息查询
 *
 * 支持多凭证场景（如服务端维护 apikey 池），每个请求可使用不同的凭证：
 * ```kotlin
 * val client = KelingClient()
 * val cred1 = Credentials("ak1", "sk1")
 * val cred2 = Credentials("ak2", "sk2")
 *
 * // 使用凭证方式调用（自动通过 tokenGenerator 生成并缓存 token）
 * val response1 = client.omniImage.create(cred1, request)
 * val response2 = client.omniImage.create(cred2, request)
 *
 * // 也可以直接传入 token
 * val token = client.tokenGenerator.generateToken(cred1).token
 * val response3 = client.omniImage.create(token, request)
 *
 * client.close()
 * ```
 *
 * @param tokenGenerator JWT Token 生成器，默认使用 [CachedJwtTokenGenerator]（带缓存的装饰者模式）
 * @param baseUrl API基础URL，默认为 https://api-beijing.klingai.com
 */
class KelingClient(
    val tokenGenerator: JwtTokenGenerator = CachedJwtTokenGenerator(),
    baseUrl: String = KelingConstants.DEFAULT_BASE_URL
) : Closeable {

    private val httpClient = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                encodeDefaults = false
                isLenient = true
            })
        }
        defaultRequest {
            url(baseUrl)
        }
    }

    // ==================== 图像生成 ====================

    /** Omni-Image 图像生成API（支持 kling-image-o1, kling-v3-omni 模型） */
    val omniImage = OmniImageApi(httpClient, tokenGenerator)

    /** 图像生成API（文生图/图生图，支持 kling-v1 ~ kling-v3 系列模型） */
    val imageGeneration = ImageGenerationApi(httpClient, tokenGenerator)

    /** 多图参考生图API（支持 kling-v2, kling-v2-1, kling-v3 模型） */
    val multiImage = MultiImageApi(httpClient, tokenGenerator)

    /** 扩图API（基于已有图片扩展内容） */
    val imageExpand = ImageExpandApi(httpClient, tokenGenerator)

    /** 智能补全主体图API（通过正面图推理其他角度图片） */
    val aiMultiShot = AiMultiShotApi(httpClient, tokenGenerator)

    // ==================== 视频生成 ====================

    /** Omni-Video 视频生成API（支持 kling-video-o1, kling-v3-omni 模型） */
    val omniVideo = OmniVideoApi(httpClient, tokenGenerator)

    /** 文生视频API */
    val text2Video = Text2VideoApi(httpClient, tokenGenerator)

    /** 图生视频API */
    val image2Video = Image2VideoApi(httpClient, tokenGenerator)

    /** 多图参考生视频API */
    val multiImage2Video = MultiImage2VideoApi(httpClient, tokenGenerator)

    /** 视频续写API */
    val videoExtend = VideoExtendApi(httpClient, tokenGenerator)

    /** 视频特效API（单图特效、双人特效） */
    val videoEffect = VideoEffectApi(httpClient, tokenGenerator)

    /** 多模态视频编辑API */
    val multiModalEdit = MultiModalEditApi(httpClient, tokenGenerator)

    /** 动作控制API */
    val actionControl = ActionControlApi(httpClient, tokenGenerator)

    // ==================== 数字人与音频 ====================

    /** 数字人API */
    val digitalHuman = DigitalHumanApi(httpClient, tokenGenerator)

    /** 对口型API */
    val lipSync = LipSyncApi(httpClient, tokenGenerator)

    /** 视频配音效API */
    val videoSfx = VideoSfxApi(httpClient, tokenGenerator)

    /** 文生音效API */
    val textSfx = TextSfxApi(httpClient, tokenGenerator)

    /** 语音合成API */
    val tts = TtsApi(httpClient, tokenGenerator)

    /** 音色定制API */
    val voiceClone = VoiceCloneApi(httpClient, tokenGenerator)

    // ==================== 通用功能 ====================

    /** 主体库管理API */
    val element = ElementApi(httpClient, tokenGenerator)

    /** 图像识别API（人脸识别、元素识别） */
    val imageRecognize = ImageRecognizeApi(httpClient, tokenGenerator)

    // ==================== 虚拟试穿 ====================

    /** 虚拟试穿API */
    val virtualTryOn = VirtualTryOnApi(httpClient, tokenGenerator)

    // ==================== 账号信息 ====================

    /** 账号信息查询API */
    val account = AccountApi(httpClient, tokenGenerator)

    /**
     * 关闭客户端，释放HTTP连接资源
     */
    override fun close() {
        httpClient.close()
    }
}
