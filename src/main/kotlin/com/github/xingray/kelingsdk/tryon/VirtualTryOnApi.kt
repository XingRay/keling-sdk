package com.github.xingray.kelingsdk.tryon

import com.github.xingray.kelingsdk.auth.*
import com.github.xingray.kelingsdk.common.ApiResponse
import com.github.xingray.kelingsdk.common.TaskData
import com.github.xingray.kelingsdk.tryon.model.VirtualTryOnRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import com.github.xingray.kelingsdk.common.KelingConstants

/**
 * 虚拟试穿API
 * 基于图片的AI虚拟试穿功能
 * 支持模型：kolors-virtual-try-on-v1, kolors-virtual-try-on-v1-5
 */
class VirtualTryOnApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    /**
     * 创建虚拟试穿任务
     * POST /v1/images/kolors-virtual-try-on
     * @param token 认证令牌
     * @param request 创建任务请求参数
     * @return 任务创建响应
     */
    suspend fun create(token: String, request: VirtualTryOnRequest): ApiResponse<TaskData> {
        return client.post("/v1/images/kolors-virtual-try-on") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 创建虚拟试穿任务（凭证版本） */
    suspend fun create(credentials: Credentials, request: VirtualTryOnRequest): ApiResponse<TaskData> {
        return create(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 查询单个虚拟试穿任务
     * GET /v1/images/kolors-virtual-try-on/{task_id}
     * @param token 认证令牌
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(token: String, taskId: String): ApiResponse<TaskData> {
        return client.get("/v1/images/kolors-virtual-try-on/$taskId") {
            header("Authorization", "Bearer $token")
        }.body()
    }

    /** 查询单个虚拟试穿任务（凭证版本） */
    suspend fun queryById(credentials: Credentials, taskId: String): ApiResponse<TaskData> {
        return queryById(tokenGenerator.generateToken(credentials).token, taskId)
    }

    /**
     * 通过自定义ID查询单个虚拟试穿任务
     * GET /v1/images/kolors-virtual-try-on
     * @param token 认证令牌
     * @param externalTaskId 用户自定义任务ID
     * @return 任务详情
     */
    suspend fun queryByExternalId(token: String, externalTaskId: String): ApiResponse<TaskData> {
        return client.get("/v1/images/kolors-virtual-try-on") {
            header("Authorization", "Bearer $token")
            parameter("external_task_id", externalTaskId)
        }.body()
    }

    /** 通过自定义ID查询单个虚拟试穿任务（凭证版本） */
    suspend fun queryByExternalId(credentials: Credentials, externalTaskId: String): ApiResponse<TaskData> {
        return queryByExternalId(tokenGenerator.generateToken(credentials).token, externalTaskId)
    }

    /**
     * 查询虚拟试穿任务列表
     * GET /v1/images/kolors-virtual-try-on?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/images/kolors-virtual-try-on") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /** 查询虚拟试穿任务列表（凭证版本） */
    suspend fun queryList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }
}
