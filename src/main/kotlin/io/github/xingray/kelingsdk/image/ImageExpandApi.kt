package io.github.xingray.kelingsdk.image

import io.github.xingray.kelingsdk.auth.*
import io.github.xingray.kelingsdk.common.ApiResponse
import io.github.xingray.kelingsdk.common.TaskData
import io.github.xingray.kelingsdk.image.model.ImageExpandRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.github.xingray.kelingsdk.common.KelingConstants

/**
 * 扩图API
 * 支持对图片进行上下左右方向的扩展
 */
class ImageExpandApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    // --- create ---

    /**
     * 创建扩图任务
     * POST /v1/images/editing/expand
     * @param token 认证令牌
     * @param request 创建任务请求参数
     * @return 任务创建响应
     */
    suspend fun create(token: String, request: ImageExpandRequest): ApiResponse<TaskData> {
        return client.post("/v1/images/editing/expand") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /**
     * 创建扩图任务（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param request 创建任务请求参数
     * @return 任务创建响应
     */
    suspend fun create(credentials: Credentials, request: ImageExpandRequest): ApiResponse<TaskData> {
        return create(tokenGenerator.generateToken(credentials).token, request)
    }

    // --- queryById ---

    /**
     * 查询单个扩图任务
     * GET /v1/images/editing/expand/{task_id}
     * @param token 认证令牌
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(token: String, taskId: String): ApiResponse<TaskData> {
        return client.get("/v1/images/editing/expand/$taskId") {
            header("Authorization", "Bearer $token")
        }.body()
    }

    /**
     * 查询单个扩图任务（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(credentials: Credentials, taskId: String): ApiResponse<TaskData> {
        return queryById(tokenGenerator.generateToken(credentials).token, taskId)
    }

    // --- queryByExternalId ---

    /**
     * 通过自定义ID查询单个扩图任务
     * GET /v1/images/editing/expand
     * @param token 认证令牌
     * @param externalTaskId 用户自定义任务ID
     * @return 任务详情
     */
    suspend fun queryByExternalId(token: String, externalTaskId: String): ApiResponse<TaskData> {
        return client.get("/v1/images/editing/expand") {
            header("Authorization", "Bearer $token")
            parameter("external_task_id", externalTaskId)
        }.body()
    }

    /**
     * 通过自定义ID查询单个扩图任务（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param externalTaskId 用户自定义任务ID
     * @return 任务详情
     */
    suspend fun queryByExternalId(credentials: Credentials, externalTaskId: String): ApiResponse<TaskData> {
        return queryByExternalId(tokenGenerator.generateToken(credentials).token, externalTaskId)
    }

    // --- queryList ---

    /**
     * 查询扩图任务列表
     * GET /v1/images/editing/expand?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/images/editing/expand") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /**
     * 查询扩图任务列表（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }
}
