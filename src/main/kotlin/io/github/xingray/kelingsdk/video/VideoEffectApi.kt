package io.github.xingray.kelingsdk.video

import io.github.xingray.kelingsdk.auth.*
import io.github.xingray.kelingsdk.common.ApiResponse
import io.github.xingray.kelingsdk.common.TaskData
import io.github.xingray.kelingsdk.video.model.VideoEffectDualRequest
import io.github.xingray.kelingsdk.video.model.VideoEffectSingleRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.github.xingray.kelingsdk.common.KelingConstants

/**
 * 视频特效API
 * 基于文档3-34 ~ 3-36节
 * 支持217款单图特效和7款双人互动特效
 */
class VideoEffectApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    /**
     * 创建单图特效任务
     * POST /v1/videos/effects
     * @param token 认证令牌
     * @param request 单图特效请求参数
     * @return 任务创建响应
     */
    suspend fun createSingle(token: String, request: VideoEffectSingleRequest): ApiResponse<TaskData> {
        return client.post("/v1/videos/effects") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 创建单图特效任务（凭证版本） */
    suspend fun createSingle(credentials: Credentials, request: VideoEffectSingleRequest): ApiResponse<TaskData> {
        return createSingle(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 创建双人互动特效任务
     * POST /v1/videos/effects
     * @param token 认证令牌
     * @param request 双人特效请求参数
     * @return 任务创建响应
     */
    suspend fun createDual(token: String, request: VideoEffectDualRequest): ApiResponse<TaskData> {
        return client.post("/v1/videos/effects") {
            header("Authorization", "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    /** 创建双人互动特效任务（凭证版本） */
    suspend fun createDual(credentials: Credentials, request: VideoEffectDualRequest): ApiResponse<TaskData> {
        return createDual(tokenGenerator.generateToken(credentials).token, request)
    }

    /**
     * 查询单个视频特效任务
     * GET /v1/videos/effects/{task_id}
     * @param token 认证令牌
     * @param taskId 系统生成的任务ID
     * @return 任务详情
     */
    suspend fun queryById(token: String, taskId: String): ApiResponse<TaskData> {
        return client.get("/v1/videos/effects/$taskId") {
            header("Authorization", "Bearer $token")
        }.body()
    }

    /** 查询单个视频特效任务（凭证版本） */
    suspend fun queryById(credentials: Credentials, taskId: String): ApiResponse<TaskData> {
        return queryById(tokenGenerator.generateToken(credentials).token, taskId)
    }

    /**
     * 通过自定义ID查询单个视频特效任务
     * GET /v1/videos/effects?external_task_id={externalTaskId}
     * @param token 认证令牌
     * @param externalTaskId 用户自定义任务ID
     * @return 任务详情
     */
    suspend fun queryByExternalId(token: String, externalTaskId: String): ApiResponse<TaskData> {
        return client.get("/v1/videos/effects") {
            header("Authorization", "Bearer $token")
            parameter("external_task_id", externalTaskId)
        }.body()
    }

    /** 通过自定义ID查询单个视频特效任务（凭证版本） */
    suspend fun queryByExternalId(credentials: Credentials, externalTaskId: String): ApiResponse<TaskData> {
        return queryByExternalId(tokenGenerator.generateToken(credentials).token, externalTaskId)
    }

    /**
     * 查询视频特效任务列表
     * GET /v1/videos/effects?pageNum={pageNum}&pageSize={pageSize}
     * @param token 认证令牌
     * @param pageNum 页码，取值范围[1,1000]，默认1
     * @param pageSize 每页数据量，取值范围[1,500]，默认30
     * @return 任务列表
     */
    suspend fun queryList(token: String, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return client.get("/v1/videos/effects") {
            header("Authorization", "Bearer $token")
            parameter("pageNum", pageNum)
            parameter("pageSize", pageSize)
        }.body()
    }

    /** 查询视频特效任务列表（凭证版本） */
    suspend fun queryList(credentials: Credentials, pageNum: Int = 1, pageSize: Int = 30): ApiResponse<List<TaskData>> {
        return queryList(tokenGenerator.generateToken(credentials).token, pageNum, pageSize)
    }
}
