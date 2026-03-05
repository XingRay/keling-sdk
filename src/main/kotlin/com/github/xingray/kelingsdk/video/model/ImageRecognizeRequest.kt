package com.github.xingray.kelingsdk.video.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 图像识别请求
 * 基于文档3-44节
 */
@Serializable
data class ImageRecognizeRequest(
    /** 待识别的图片，支持图片URL或Base64编码 */
    @SerialName("image")
    val image: String = ""
)
