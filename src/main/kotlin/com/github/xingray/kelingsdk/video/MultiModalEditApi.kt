package com.github.xingray.kelingsdk.video

import com.github.xingray.kelingsdk.auth.*
import com.github.xingray.kelingsdk.common.ApiResponse
import com.github.xingray.kelingsdk.common.TaskData
import com.github.xingray.kelingsdk.video.model.MultiModalEditInitRequest
import com.github.xingray.kelingsdk.video.model.MultiModalEditRequest
import com.github.xingray.kelingsdk.video.model.MultiModalEditSelectionRequest
import com.github.xingray.kelingsdk.video.model.MultiModalEditSessionRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import com.github.xingray.kelingsdk.common.KelingConstants

/**
 * 多模态视频编辑API
 * 基于文档3-16 ~ 3-23节
 * 支持视频初始化、选区管理、视频编辑等功能
 */
class MultiModalEditApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    /**
     * 初始化待编辑视频
     * POST /v1/videos/multi-elements/init-selection
     * @param token 认证令牌
     * @param request 初始化请求参数
     * @return 包含session_id的响应
     */
    suspend fun initSelection(token: String, request: MultiModalEditInitRequest): ApiResponse<TaskData> {
        return client.post("/v1/videos/multi-elements/init-selection") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 初始化待编辑视频（凭证版本） */
    suspend fun initSelection(credentials: Credentials, request: MultiModalEditInitRequest): ApiResponse<TaskData> {
        return initSelection(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 增加视频选区
     * POST /v1/videos/multi-elements/add-selection
     * @param token 认证令牌
     * @param request 增加选区请求参数
     * @return 选区结果
     */
    suspend fun addSelection(token: String, request: MultiModalEditSelectionRequest): ApiResponse<TaskData> {
        return client.post("/v1/videos/multi-elements/add-selection") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 增加视频选区（凭证版本） */
    suspend fun addSelection(credentials: Credentials, request: MultiModalEditSelectionRequest): ApiResponse<TaskData> {
        return addSelection(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 删减视频选区
     * POST /v1/videos/multi-elements/delete-selection
     * @param token 认证令牌
     * @param request 删减选区请求参数
     * @return 选区结果
     */
    suspend fun deleteSelection(token: String, request: MultiModalEditSelectionRequest): ApiResponse<TaskData> {
        return client.post("/v1/videos/multi-elements/delete-selection") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 删减视频选区（凭证版本） */
    suspend fun deleteSelection(credentials: Credentials, request: MultiModalEditSelectionRequest): ApiResponse<TaskData> {
        return deleteSelection(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 清除视频选区
     * POST /v1/videos/multi-elements/clear-selection
     * @param token 认证令牌
     * @param request 清除选区请求参数(仅需session_id)
     * @return 响应结果
     */
    suspend fun clearSelection(token: String, request: MultiModalEditSessionRequest): ApiResponse<TaskData> {
        return client.post("/v1/videos/multi-elements/clear-selection") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 清除视频选区（凭证版本） */
    suspend fun clearSelection(credentials: Credentials, request: MultiModalEditSessionRequest): ApiResponse<TaskData> {
        return clearSelection(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 预览已选区视频
     * POST /v1/videos/multi-elements/preview-selection
     * @param token 认证令牌
     * @param request 预览请求参数(仅需session_id)
     * @return 预览结果
     */
    suspend fun previewSelection(token: String, request: MultiModalEditSessionRequest): ApiResponse<TaskData> {
        return client.post("/v1/videos/multi-elements/preview-selection") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 预览已选区视频（凭证版本） */
    suspend fun previewSelection(credentials: Credentials, request: MultiModalEditSessionRequest): ApiResponse<TaskData> {
        return previewSelection(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 创建多模态视频编辑任务
     * POST /v1/videos/multi-elements/
     * @param token 认证令牌
     * @param request 创建编辑任务请求参数
     * @return 任务创建响应
     */
    suspend fun create(token: String, request: MultiModalEditRequest): ApiResponse<TaskData> {
        return client.post("/v1/videos/multi-elements/") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 创建多模态视频编辑任务（凭证版本） */
    suspend fun create(credentials: Credentials, request: MultiModalEditRequest): ApiResponse<TaskData> {
        return create(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 查询单个多模态视频编辑任务
     * GET /v1/videos/multi-elements/{task_id}
     * @param token 认证令牌
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(token: String, taskId: String): ApiResponse<TaskData> {
        return client.get("/v1/videos/multi-elements/$taskId") {
            header("Authorization", "Bearer $token")
        }.body()
    }

    /** 查询单个多模态视频编辑任务（凭证版本） */
    suspend fun queryById(credentials: Credentials, taskId: String): ApiResponse<TaskData> {
        return queryById(tokenGenerator.generateToken(credentials).token, taskId)
    }

    /**
     * 通过自定义ID查询单个多模态视频编辑任务
     * GET /v1/videos/multi-elements?external_task_id={externalTaskId}
     * @param token 认证令牌
     * @param externalTaskId 用户自定义任务ID
     * @return 任务详情
     */
    suspend fun queryByExternalId(token: String, externalTaskId: String): ApiResponse<TaskData> {
        return client.get("/v1/videos/multi-elements/") {
            header("Authorization", "Bearer $token")
            parameter("external_task_id", externalTaskId)
        }.body()
    }

    /** 通过自定义ID查询单个多模态视频编辑任务（凭证版本） */
    suspend fun queryByExternalId(credentials: Credentials, externalTaskId: String): ApiResponse<TaskData> {
        return queryByExternalId(tokenGenerator.generateToken(credentials).token, externalTaskId)
    }

    /**
     * 查询多模态视频编辑任务列表
     * GET /v1/videos/multi-elements/?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/videos/multi-elements/") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /** 查询多模态视频编辑任务列表（凭证版本） */
    suspend fun queryList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }
}
