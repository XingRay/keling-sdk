package io.github.xingray.kelingsdk.image

import io.github.xingray.kelingsdk.auth.*
import io.github.xingray.kelingsdk.common.ApiResponse
import io.github.xingray.kelingsdk.common.TaskData
import io.github.xingray.kelingsdk.image.model.ImageGenerationRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.github.xingray.kelingsdk.common.KelingConstants

/**
 * 图像生成API（文生图/图生图）
 * 支持模型：kling-v1, kling-v1-5, kling-v2, kling-v2-new, kling-v2-1, kling-v3
 */
class ImageGenerationApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    // --- create ---

    /**
     * 创建图像生成任务
     * POST /v1/images/generations
     * @param token 认证令牌
     * @param request 创建任务请求参数
     * @return 任务创建响应
     */
    suspend fun create(token: String, request: ImageGenerationRequest): ApiResponse<TaskData> {
        return client.post("/v1/images/generations") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /**
     * 创建图像生成任务（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param request 创建任务请求参数
     * @return 任务创建响应
     */
    suspend fun create(credentials: Credentials, request: ImageGenerationRequest): ApiResponse<TaskData> {
        return create(tokenGenerator.generateToken(credentials).token, request)
    }

    // --- queryById ---

    /**
     * 查询单个图像生成任务
     * GET /v1/images/generations/{task_id}
     * @param token 认证令牌
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(token: String, taskId: String): ApiResponse<TaskData> {
        return client.get("/v1/images/generations/$taskId") {
            header("Authorization", "Bearer $token")
        }.body()
    }

    /**
     * 查询单个图像生成任务（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(credentials: Credentials, taskId: String): ApiResponse<TaskData> {
        return queryById(tokenGenerator.generateToken(credentials).token, taskId)
    }

    // --- queryByExternalId ---

    /**
     * 通过自定义ID查询单个图像生成任务
     * GET /v1/images/generations
     * @param token 认证令牌
     * @param externalTaskId 用户自定义任务ID
     * @return 任务详情
     */
    suspend fun queryByExternalId(token: String, externalTaskId: String): ApiResponse<TaskData> {
        return client.get("/v1/images/generations") {
            header("Authorization", "Bearer $token")
            parameter("external_task_id", externalTaskId)
        }.body()
    }

    /**
     * 通过自定义ID查询单个图像生成任务（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param externalTaskId 用户自定义任务ID
     * @return 任务详情
     */
    suspend fun queryByExternalId(credentials: Credentials, externalTaskId: String): ApiResponse<TaskData> {
        return queryByExternalId(tokenGenerator.generateToken(credentials).token, externalTaskId)
    }

    // --- queryList ---

    /**
     * 查询图像生成任务列表
     * GET /v1/images/generations?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/images/generations") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /**
     * 查询图像生成任务列表（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }
}
