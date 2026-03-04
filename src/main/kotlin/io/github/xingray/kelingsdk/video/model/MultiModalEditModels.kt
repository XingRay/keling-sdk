package io.github.xingray.kelingsdk.video.model

import io.github.xingray.kelingsdk.common.WatermarkInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 多模态视频编辑-初始化待编辑视频请求
 * 基于文档3-16节
 */
@Serializable
data class MultiModalEditInitRequest(
    /** 视频ID，与video_url二选一 */
    @SerialName("video_id")
    val videoId: String? = null,

    /** 视频URL，与video_id二选一 */
    @SerialName("video_url")
    val videoUrl: String? = null
)

/**
 * 多模态视频编辑-坐标点
 */
@Serializable
data class SelectionPoint(
    /** 横坐标，取值范围[0,1]，百分比表示 */
    @SerialName("x")
    val x: Float = 0f,

    /** 纵坐标，取值范围[0,1]，百分比表示 */
    @SerialName("y")
    val y: Float = 0f
)

/**
 * 多模态视频编辑-增加/删减视频选区请求
 * 基于文档3-17和3-18节
 */
@Serializable
data class MultiModalEditSelectionRequest(
    /** 会话ID */
    @SerialName("session_id")
    val sessionId: String = "",

    /** 帧号，最多支持10个标记帧 */
    @SerialName("frame_index")
    val frameIndex: Int = 0,

    /** 点选坐标列表，某一帧最多可标记10个点 */
    @SerialName("points")
    val points: List<SelectionPoint> = emptyList()
)

/**
 * 多模态视频编辑-清除选区/预览选区请求
 * 基于文档3-19和3-20节
 */
@Serializable
data class MultiModalEditSessionRequest(
    /** 会话ID */
    @SerialName("session_id")
    val sessionId: String = ""
)

/**
 * 多模态视频编辑-参考图片项
 */
@Serializable
data class MultiModalEditImageItem(
    /** 图片URL或Base64编码 */
    @SerialName("image_url")
    val imageUrl: String = ""
)

/**
 * 多模态视频编辑-创建任务请求
 * 基于文档3-21节
 */
@Serializable
data class MultiModalEditRequest(
    /** 模型名称，枚举值：kling-v1-6 */
    @SerialName("model_name")
    val modelName: String? = null,

    /** 会话ID */
    @SerialName("session_id")
    val sessionId: String = "",

    /** 操作类型，枚举值：addition(增加), swap(替换), removal(删除) */
    @SerialName("edit_mode")
    val editMode: String = "",

    /** 裁剪后的参考图像列表 */
    @SerialName("image_list")
    val imageList: List<MultiModalEditImageItem>? = null,

    /** 正向文本提示词，不超过2500字符 */
    @SerialName("prompt")
    val prompt: String = "",

    /** 负向文本提示词，不超过2500字符 */
    @SerialName("negative_prompt")
    val negativePrompt: String? = null,

    /** 生成视频的模式，枚举值：std(标准模式), pro(专家模式) */
    @SerialName("mode")
    val mode: String? = null,

    /** 生成视频时长(秒)，枚举值：5, 10 */
    @SerialName("duration")
    val duration: String? = null,

    /** 水印配置 */
    @SerialName("watermark_info")
    val watermarkInfo: List<WatermarkInfo>? = null,

    /** 回调通知地址 */
    @SerialName("callback_url")
    val callbackUrl: String? = null,

    /** 自定义任务ID */
    @SerialName("external_task_id")
    val externalTaskId: String? = null
)
