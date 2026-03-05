package com.github.xingray.kelingsdk.video

import com.github.xingray.kelingsdk.auth.*
import com.github.xingray.kelingsdk.common.ApiResponse
import com.github.xingray.kelingsdk.video.model.ImageRecognizeRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.JsonObject
import com.github.xingray.kelingsdk.common.KelingConstants

/**
 * 图像识别API
 * 基于文档3-44节
 * 用于识别图片中的元素信息
 */
class ImageRecognizeApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    /**
     * 图像识别
     * POST /v1/videos/image-recognize
     * @param token 认证令牌
     * @param request 图像识别请求参数
     * @return 识别结果，包含识别到的元素信息
     */
    suspend fun recognize(token: String, request: ImageRecognizeRequest): ApiResponse<JsonObject> {
        return client.post("/v1/videos/image-recognize") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 图像识别（凭证版本） */
    suspend fun recognize(credentials: Credentials, request: ImageRecognizeRequest): ApiResponse<JsonObject> {
        return recognize(tokenGenerator.generateToken(credentials).token, request)
    }
}
