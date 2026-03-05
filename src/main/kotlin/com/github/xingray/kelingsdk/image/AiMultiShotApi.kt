package com.github.xingray.kelingsdk.image

import com.github.xingray.kelingsdk.auth.*
import com.github.xingray.kelingsdk.common.ApiResponse
import com.github.xingray.kelingsdk.common.TaskData
import com.github.xingray.kelingsdk.image.model.AiMultiShotRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import com.github.xingray.kelingsdk.common.KelingConstants

/**
 * 智能补全主体图API
 * 根据主体正面参考图自动生成多角度主体图
 */
class AiMultiShotApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    // --- create ---

    /**
     * 创建智能补全主体图任务
     * POST /v1/general/ai-multi-shot
     * @param token 认证令牌
     * @param request 创建任务请求参数
     * @return 任务创建响应
     */
    suspend fun create(token: String, request: AiMultiShotRequest): ApiResponse<TaskData> {
        return client.post("/v1/general/ai-multi-shot") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /**
     * 创建智能补全主体图任务（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param request 创建任务请求参数
     * @return 任务创建响应
     */
    suspend fun create(credentials: Credentials, request: AiMultiShotRequest): ApiResponse<TaskData> {
        return create(tokenGenerator.generateToken(credentials).token, request)
    }

    // --- queryById ---

    /**
     * 查询单个智能补全主体图任务
     * GET /v1/general/ai-multi-shot/{task_id}
     * @param token 认证令牌
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(token: String, taskId: String): ApiResponse<TaskData> {
        return client.get("/v1/general/ai-multi-shot/$taskId") {
            header("Authorization", "Bearer $token")
        }.body()
    }

    /**
     * 查询单个智能补全主体图任务（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(credentials: Credentials, taskId: String): ApiResponse<TaskData> {
        return queryById(tokenGenerator.generateToken(credentials).token, taskId)
    }

    // --- queryList ---

    /**
     * 查询智能补全主体图任务列表
     * GET /v1/general/ai-multi-shot?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/general/ai-multi-shot") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /**
     * 查询智能补全主体图任务列表（使用凭证自动生成令牌）
     * @param credentials 认证凭证
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }
}
