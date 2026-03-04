package io.github.xingray.kelingsdk.account

import io.github.xingray.kelingsdk.auth.*
import io.github.xingray.kelingsdk.account.model.ResourcePackInfo
import io.github.xingray.kelingsdk.common.ApiResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.github.xingray.kelingsdk.common.KelingConstants

/**
 * 账号信息查询API
 * 用于查询账号下的资源包列表和余量
 * 注意：该接口免费调用，但请控制请求速率（QPS<=1）
 */
class AccountApi(private val client: HttpClient, private val tokenGenerator: JwtTokenGenerator) {

    /**
     * 查询账号下资源包列表及余量
     * GET /account/costs
     * @param token 认证令牌
     * @param startTime 查询开始时间，Unix时间戳（毫秒）
     * @param endTime 查询结束时间，Unix时间戳（毫秒）
     * @param resourcePackName 资源包名称，可选，用于精准查询某个资源包
     * @return 资源包信息列表
     */
    suspend fun queryCosts(
        token: String,
        startTime: Long,
        endTime: Long,
        resourcePackName: String? = null
    ): ApiResponse<List<ResourcePackInfo>> {
        return client.get("/account/costs") {
            header("Authorization", "Bearer $token")
            parameter("start_time", startTime)
            parameter("end_time", endTime)
            if (resourcePackName != null) {
                parameter("resource_pack_name", resourcePackName)
            }
        }.body()
    }

    /** 查询账号下资源包列表及余量（凭证版本） */
    suspend fun queryCosts(
        credentials: Credentials,
        startTime: Long,
        endTime: Long,
        resourcePackName: String? = null
    ): ApiResponse<List<ResourcePackInfo>> {
        return queryCosts(tokenGenerator.generateToken(credentials).token, startTime, endTime, resourcePackName)
    }
}
