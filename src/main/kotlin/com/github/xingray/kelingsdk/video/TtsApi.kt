package com.github.xingray.kelingsdk.video

import com.github.xingray.kelingsdk.auth.*
import com.github.xingray.kelingsdk.common.ApiResponse
import com.github.xingray.kelingsdk.common.TaskData
import com.github.xingray.kelingsdk.video.model.TtsRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import com.github.xingray.kelingsdk.common.KelingConstants

/**
 * 语音合成(TTS)API
 * 基于文档3-43节
 * 支持多种音色进行语音合成
 */
class TtsApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    /**
     * 创建语音合成任务
     * POST /v1/audio/tts
     * @param token 认证令牌
     * @param request 创建任务请求参数
     * @return 任务创建响应(同步返回音频结果)
     */
    suspend fun create(token: String, request: TtsRequest): ApiResponse<TaskData> {
        return client.post("/v1/audio/tts") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 创建语音合成任务（凭证版本） */
    suspend fun create(credentials: Credentials, request: TtsRequest): ApiResponse<TaskData> {
        return create(tokenGenerator.generateToken(credentials).token, request)
    }
}
