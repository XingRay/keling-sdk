package io.github.xingray.kelingsdk.video

import io.github.xingray.kelingsdk.auth.*
import io.github.xingray.kelingsdk.common.ApiResponse
import io.github.xingray.kelingsdk.common.TaskData
import io.github.xingray.kelingsdk.video.model.DeleteVoiceRequest
import io.github.xingray.kelingsdk.video.model.VoiceCloneRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.github.xingray.kelingsdk.common.KelingConstants

/**
 * 自定义音色API
 * 基于文档3-50 ~ 3-54节
 * 支持创建、查询、删除自定义音色，以及查询官方音色
 */
class VoiceCloneApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    /**
     * 创建自定义音色
     * POST /v1/general/custom-voices
     * @param token 认证令牌
     * @param request 创建音色请求参数
     * @return 任务创建响应
     */
    suspend fun create(token: String, request: VoiceCloneRequest): ApiResponse<TaskData> {
        return client.post("/v1/general/custom-voices") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 创建自定义音色（凭证版本） */
    suspend fun create(credentials: Credentials, request: VoiceCloneRequest): ApiResponse<TaskData> {
        return create(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 查询单个自定义音色
     * GET /v1/general/custom-voices/{task_id}
     * @param token 认证令牌
     * @param taskId 生成音色的任务ID
     * @return 任务详情
     */
    suspend fun queryById(token: String, taskId: String): ApiResponse<TaskData> {
        return client.get("/v1/general/custom-voices/$taskId") {
            header("Authorization", "Bearer $token")
        }.body()
    }

    /** 查询单个自定义音色（凭证版本） */
    suspend fun queryById(credentials: Credentials, taskId: String): ApiResponse<TaskData> {
        return queryById(tokenGenerator.generateToken(credentials).token, taskId)
    }

    /**
     * 通过自定义ID查询单个自定义音色
     * GET /v1/general/custom-voices?external_task_id={externalTaskId}
     * @param token 认证令牌
     * @param externalTaskId 用户自定义任务ID
     * @return 任务详情
     */
    suspend fun queryByExternalId(token: String, externalTaskId: String): ApiResponse<TaskData> {
        return client.get("/v1/general/custom-voices") {
            header("Authorization", "Bearer $token")
            parameter("external_task_id", externalTaskId)
        }.body()
    }

    /** 通过自定义ID查询单个自定义音色（凭证版本） */
    suspend fun queryByExternalId(credentials: Credentials, externalTaskId: String): ApiResponse<TaskData> {
        return queryByExternalId(tokenGenerator.generateToken(credentials).token, externalTaskId)
    }

    /**
     * 查询自定义音色列表
     * GET /v1/general/custom-voices?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,1000]，默认30
     * @return 任务列表
     */
    suspend fun queryList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/general/custom-voices") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /** 查询自定义音色列表（凭证版本） */
    suspend fun queryList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }

    /**
     * 查询官方预置音色列表
     * GET /v1/general/presets-voices?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,1000]，默认30
     * @return 音色列表
     */
    suspend fun queryPresetsList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/general/presets-voices") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /** 查询官方预置音色列表（凭证版本） */
    suspend fun queryPresetsList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryPresetsList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }

    /**
     * 删除自定义音色
     * POST /v1/general/delete-voices
     * @param token 认证令牌
     * @param request 删除请求参数
     * @return 响应结果
     */
    suspend fun delete(token: String, request: DeleteVoiceRequest): ApiResponse<Unit> {
        return client.post("/v1/general/delete-voices") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 删除自定义音色（凭证版本） */
    suspend fun delete(credentials: Credentials, request: DeleteVoiceRequest): ApiResponse<Unit> {
        return delete(tokenGenerator.generateToken(credentials).token, request)
    }
}
