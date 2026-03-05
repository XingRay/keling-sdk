package com.github.xingray.kelingsdk.video

import com.github.xingray.kelingsdk.auth.*
import com.github.xingray.kelingsdk.common.ApiResponse
import com.github.xingray.kelingsdk.common.TaskData
import com.github.xingray.kelingsdk.video.model.CreateElementRequest
import com.github.xingray.kelingsdk.video.model.DeleteElementRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import com.github.xingray.kelingsdk.common.KelingConstants

/**
 * 主体库管理API
 * 基于文档3-45 ~ 3-49节
 * 支持创建、查询、删除自定义主体，以及查询官方主体
 */
class ElementApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    /**
     * 创建高级自定义主体
     * POST /v1/general/advanced-custom-elements
     * @param token 认证令牌
     * @param request 创建主体请求参数
     * @return 任务创建响应
     */
    suspend fun create(token: String, request: CreateElementRequest): ApiResponse<TaskData> {
        return client.post("/v1/general/advanced-custom-elements") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 创建高级自定义主体（凭证版本） */
    suspend fun create(credentials: Credentials, request: CreateElementRequest): ApiResponse<TaskData> {
        return create(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 查询单个自定义主体
     * GET /v1/general/advanced-custom-elements/{task_id}
     * @param token 认证令牌
     * @param taskId 系统生成的任务ID
     * @return 主体详情
     */
    suspend fun queryById(token: String, taskId: String): ApiResponse<TaskData> {
        return client.get("/v1/general/advanced-custom-elements/$taskId") {
            header("Authorization", "Bearer $token")
        }.body()
    }

    /** 查询单个自定义主体（凭证版本） */
    suspend fun queryById(credentials: Credentials, taskId: String): ApiResponse<TaskData> {
        return queryById(tokenGenerator.generateToken(credentials).token, taskId)
    }

    /**
     * 通过自定义ID查询单个主体
     * GET /v1/general/advanced-custom-elements?external_task_id={externalTaskId}
     * @param token 认证令牌
     * @param externalTaskId 用户自定义任务ID
     * @return 主体详情
     */
    suspend fun queryByExternalId(token: String, externalTaskId: String): ApiResponse<TaskData> {
        return client.get("/v1/general/advanced-custom-elements") {
            header("Authorization", "Bearer $token")
            parameter("external_task_id", externalTaskId)
        }.body()
    }

    /** 通过自定义ID查询单个主体（凭证版本） */
    suspend fun queryByExternalId(credentials: Credentials, externalTaskId: String): ApiResponse<TaskData> {
        return queryByExternalId(tokenGenerator.generateToken(credentials).token, externalTaskId)
    }

    /**
     * 查询自定义主体列表
     * GET /v1/general/advanced-custom-elements?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 主体列表
     */
    suspend fun queryList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/general/advanced-custom-elements") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /** 查询自定义主体列表（凭证版本） */
    suspend fun queryList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }

    /**
     * 查询官方预置主体列表
     * GET /v1/general/advanced-presets-elements?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 主体列表
     */
    suspend fun queryPresetsList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/general/advanced-presets-elements") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /** 查询官方预置主体列表（凭证版本） */
    suspend fun queryPresetsList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryPresetsList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }

    /**
     * 删除自定义主体
     * POST /v1/general/delete-elements
     * @param token 认证令牌
     * @param request 删除请求参数
     * @return 响应结果
     */
    suspend fun delete(token: String, request: DeleteElementRequest): ApiResponse<Unit> {
        return client.post("/v1/general/delete-elements") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 删除自定义主体（凭证版本） */
    suspend fun delete(credentials: Credentials, request: DeleteElementRequest): ApiResponse<Unit> {
        return delete(tokenGenerator.generateToken(credentials).token, request)
    }
}
