package com.github.xingray.kelingsdk.video

import com.github.xingray.kelingsdk.auth.*
import com.github.xingray.kelingsdk.common.ApiResponse
import com.github.xingray.kelingsdk.common.TaskData
import com.github.xingray.kelingsdk.video.model.LipSyncFaceDetectRequest
import com.github.xingray.kelingsdk.video.model.LipSyncRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import com.github.xingray.kelingsdk.common.KelingConstants

/**
 * 对口型API(新版)
 * 基于文档3-30 ~ 3-33节
 * 可结合文案或音频，驱动视频中角色的口型
 */
class LipSyncApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    /**
     * 对口型-人脸识别
     * POST /v1/videos/identify-face
     * @param token 认证令牌
     * @param request 人脸识别请求参数
     * @return 识别结果，包含session_id和人脸列表
     */
    suspend fun identifyFace(token: String, request: LipSyncFaceDetectRequest): ApiResponse<TaskData> {
        return client.post("/v1/videos/identify-face") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 对口型-人脸识别（凭证版本） */
    suspend fun identifyFace(credentials: Credentials, request: LipSyncFaceDetectRequest): ApiResponse<TaskData> {
        return identifyFace(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 创建对口型任务(新版)
     * POST /v1/videos/advanced-lip-sync
     * @param token 认证令牌
     * @param request 创建任务请求参数
     * @return 任务创建响应
     */
    suspend fun create(token: String, request: LipSyncRequest): ApiResponse<TaskData> {
        return client.post("/v1/videos/advanced-lip-sync") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 创建对口型任务（凭证版本） */
    suspend fun create(credentials: Credentials, request: LipSyncRequest): ApiResponse<TaskData> {
        return create(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 查询单个对口型任务
     * GET /v1/videos/advanced-lip-sync/{task_id}
     * @param token 认证令牌
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(token: String, taskId: String): ApiResponse<TaskData> {
        return client.get("/v1/videos/advanced-lip-sync/$taskId") {
            header("Authorization", "Bearer $token")
        }.body()
    }

    /** 查询单个对口型任务（凭证版本） */
    suspend fun queryById(credentials: Credentials, taskId: String): ApiResponse<TaskData> {
        return queryById(tokenGenerator.generateToken(credentials).token, taskId)
    }

    /**
     * 通过自定义ID查询单个对口型任务
     * GET /v1/videos/advanced-lip-sync?external_task_id={externalTaskId}
     * @param token 认证令牌
     * @param externalTaskId 用户自定义任务ID
     * @return 任务详情
     */
    suspend fun queryByExternalId(token: String, externalTaskId: String): ApiResponse<TaskData> {
        return client.get("/v1/videos/advanced-lip-sync") {
            header("Authorization", "Bearer $token")
            parameter("external_task_id", externalTaskId)
        }.body()
    }

    /** 通过自定义ID查询单个对口型任务（凭证版本） */
    suspend fun queryByExternalId(credentials: Credentials, externalTaskId: String): ApiResponse<TaskData> {
        return queryByExternalId(tokenGenerator.generateToken(credentials).token, externalTaskId)
    }

    /**
     * 查询对口型任务列表
     * GET /v1/videos/advanced-lip-sync?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/videos/advanced-lip-sync") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /** 查询对口型任务列表（凭证版本） */
    suspend fun queryList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }
}
