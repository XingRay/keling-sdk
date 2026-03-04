package io.github.xingray.kelingsdk.image

import io.github.xingray.kelingsdk.auth.*
import io.github.xingray.kelingsdk.common.ApiResponse
import io.github.xingray.kelingsdk.common.TaskData
import io.github.xingray.kelingsdk.image.model.MultiImageRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.github.xingray.kelingsdk.common.KelingConstants

/**
 * 多图参考生图API
 * 支持传入多张主体参考图、场景参考图、风格参考图进行图像生成
 * 支持模型：kling-v2, kling-v2-1, kling-v3
 */
class MultiImageApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    // --- create ---

    /**
     * 创建多图参考生图任务
     * POST /v1/images/multi-image2image
     * @param token 认证令牌
     * @param request 创建任务请求参数
     * @return 任务创建响应
     */
    suspend fun create(token: String, request: MultiImageRequest): ApiResponse<TaskData> {
        return client.post("/v1/images/multi-image2image") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /**
     * 创建多图参考生图任务（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param request 创建任务请求参数
     * @return 任务创建响应
     */
    suspend fun create(credentials: Credentials, request: MultiImageRequest): ApiResponse<TaskData> {
        return create(tokenGenerator.generateToken(credentials).token, request)
    }

    // --- queryById ---

    /**
     * 查询单个多图参考生图任务
     * GET /v1/images/multi-image2image/{task_id}
     * @param token 认证令牌
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(token: String, taskId: String): ApiResponse<TaskData> {
        return client.get("/v1/images/multi-image2image/$taskId") {
            header("Authorization", "Bearer $token")
        }.body()
    }

    /**
     * 查询单个多图参考生图任务（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(credentials: Credentials, taskId: String): ApiResponse<TaskData> {
        return queryById(tokenGenerator.generateToken(credentials).token, taskId)
    }

    // --- queryByExternalId ---

    /**
     * 通过自定义ID查询单个多图参考生图任务
     * GET /v1/images/multi-image2image
     * @param token 认证令牌
     * @param externalTaskId 用户自定义任务ID
     * @return 任务详情
     */
    suspend fun queryByExternalId(token: String, externalTaskId: String): ApiResponse<TaskData> {
        return client.get("/v1/images/multi-image2image") {
            header("Authorization", "Bearer $token")
            parameter("external_task_id", externalTaskId)
        }.body()
    }

    /**
     * 通过自定义ID查询单个多图参考生图任务（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param externalTaskId 用户自定义任务ID
     * @return 任务详情
     */
    suspend fun queryByExternalId(credentials: Credentials, externalTaskId: String): ApiResponse<TaskData> {
        return queryByExternalId(tokenGenerator.generateToken(credentials).token, externalTaskId)
    }

    // --- queryList ---

    /**
     * 查询多图参考生图任务列表
     * GET /v1/images/multi-image2image?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/images/multi-image2image") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /**
     * 查询多图参考生图任务列表（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }
}
