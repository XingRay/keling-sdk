package io.github.xingray.kelingsdk.support

import io.github.xingray.kelingsdk.image.model.*
import io.github.xingray.kelingsdk.tryon.model.VirtualTryOnRequest
import io.github.xingray.kelingsdk.video.model.*

object TestFixtures {
    // 通用占位ID（使用更接近真实接口风格的值）
    const val TASK_ID = "753908173630445568"
    const val EXTERNAL_TASK_ID = "it-test-ext-20260304-001"
    const val VIDEO_ID = "753908173630445569"
    const val ELEMENT_ID = "element_1234567890"
    const val VOICE_ID = "voice_1234567890"
    const val SESSION_ID = "session_1234567890"
    const val FACE_ID = "face_1"

    // 可公开访问的测试媒体URL
    const val IMAGE_URL = "https://picsum.photos/id/237/1024/1024"
    const val IMAGE_URL_2 = "https://picsum.photos/id/1025/1024/1024"
    const val VIDEO_URL = "https://samplelib.com/lib/preview/mp4/sample-5s.mp4"
    const val AUDIO_URL = "https://samplelib.com/lib/preview/mp3/sample-3s.mp3"
    const val CALLBACK_URL = "https://example.com/callback/kling"

    // 账号查询测试时间窗口
    const val START_TIME = 1735689600000L // 2025-01-01 00:00:00 UTC
    const val END_TIME = 1735776000000L   // 2025-01-02 00:00:00 UTC
    const val RESOURCE_PACK_NAME = "video_generation_pack"

    fun omniImageRequest() = OmniImageRequest(
        modelName = "kling-v3-omni",
        prompt = "一只柯基在海边奔跑，电影感光影，细节清晰",
        resolution = "1k",
        n = 1,
        aspectRatio = "1:1",
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun imageGenerationRequest() = ImageGenerationRequest(
        modelName = "kling-v3",
        prompt = "未来城市夜景，霓虹灯，写实风格",
        n = 1,
        aspectRatio = "16:9",
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun multiImageRequest() = MultiImageRequest(
        modelName = "kling-v2-1",
        prompt = "保持主体一致性，生成商务肖像",
        subjectImageList = listOf(SubjectImageItem(image = IMAGE_URL)),
        n = 1,
        aspectRatio = "1:1",
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun imageExpandRequest() = ImageExpandRequest(
        image = IMAGE_URL,
        upExpansionRatio = 0.2f,
        downExpansionRatio = 0.2f,
        leftExpansionRatio = 0.2f,
        rightExpansionRatio = 0.2f,
        prompt = "向四周自然延展背景",
        n = 1,
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun aiMultiShotRequest() = AiMultiShotRequest(
        elementFrontalImage = IMAGE_URL,
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun virtualTryOnRequest() = VirtualTryOnRequest(
        modelName = "kolors-virtual-try-on-v1-5",
        humanImage = IMAGE_URL,
        clothImage = IMAGE_URL_2,
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun actionControlRequest() = ActionControlRequest(
        prompt = "人物跟随参考视频动作起舞",
        imageUrl = IMAGE_URL,
        videoUrl = VIDEO_URL,
        keepOriginalSound = "no",
        characterOrientation = "image",
        mode = "std",
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun digitalHumanRequest() = DigitalHumanRequest(
        image = IMAGE_URL,
        soundFile = AUDIO_URL,
        prompt = "自然口播，语速平稳",
        mode = "std",
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun createElementRequest() = CreateElementRequest(
        elementName = "it_test_character",
        elementDescription = "integration test custom element",
        referenceType = "image_refer",
        elementImageList = listOf(ElementImageItem(imageUrl = IMAGE_URL, frontalImage = true)),
        tagList = listOf(ElementTag(tagId = "o_102")),
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun deleteElementRequest() = DeleteElementRequest(elementId = ELEMENT_ID)

    fun image2VideoRequest() = Image2VideoRequest(
        modelName = "kling-v2-1",
        image = IMAGE_URL,
        prompt = "微风吹动头发，镜头缓慢推进",
        mode = "std",
        duration = "5",
        aspectRatio = "16:9",
        sound = "off",
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun imageRecognizeRequest() = ImageRecognizeRequest(image = IMAGE_URL)

    fun lipSyncFaceDetectRequest() = LipSyncFaceDetectRequest(videoUrl = VIDEO_URL)

    fun lipSyncRequest() = LipSyncRequest(
        sessionId = SESSION_ID,
        faceChoose = listOf(
            FaceChoose(
                faceId = FACE_ID,
                soundFile = AUDIO_URL,
                soundStartTime = 0,
                soundEndTime = 3000,
                soundInsertTime = 0,
                soundVolume = 1.0f,
                originalAudioVolume = 1.0f
            )
        ),
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun multiImage2VideoRequest() = MultiImage2VideoRequest(
        modelName = "kling-v1-6",
        prompt = "两张参考图中的主体一起向前走",
        imageList = listOf(
            MultiImageItem(
                imageUrl = IMAGE_URL,
                elements = listOf(MultiImageElement(elementId = ELEMENT_ID))
            )
        ),
        mode = "std",
        duration = "5",
        aspectRatio = "16:9",
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun multiModalEditInitRequest() = MultiModalEditInitRequest(videoUrl = VIDEO_URL)

    fun multiModalEditSelectionRequest() = MultiModalEditSelectionRequest(
        sessionId = SESSION_ID,
        frameIndex = 1,
        points = listOf(SelectionPoint(x = 0.2f, y = 0.3f))
    )

    fun multiModalEditSessionRequest() = MultiModalEditSessionRequest(sessionId = SESSION_ID)

    fun multiModalEditRequest() = MultiModalEditRequest(
        modelName = "kling-v1-6",
        sessionId = SESSION_ID,
        editMode = "addition",
        prompt = "在选区内增加一朵红色气球",
        imageList = listOf(MultiModalEditImageItem(imageUrl = IMAGE_URL_2)),
        mode = "std",
        duration = "5",
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun omniVideoRequest() = OmniVideoRequest(
        modelName = "kling-video-o1",
        prompt = "清晨森林航拍，光线柔和，电影感",
        sound = "off",
        mode = "std",
        duration = "5",
        aspectRatio = "16:9",
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun text2VideoRequest() = Text2VideoRequest(
        modelName = "kling-v2-5-turbo",
        prompt = "宇航员在月球上挥手，写实风格",
        sound = "off",
        mode = "std",
        duration = "5",
        aspectRatio = "16:9",
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun videoExtendRequest() = VideoExtendRequest(
        modelName = "kling-v2-1-master",
        videoId = VIDEO_ID,
        prompt = "延续前一镜头动作",
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun videoEffectSingleRequest() = VideoEffectSingleRequest(
        effectScene = "raid_check",
        input = VideoEffectSingleInput(image = IMAGE_URL),
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun videoEffectDualRequest() = VideoEffectDualRequest(
        effectScene = "hug_pro",
        input = VideoEffectDualInput(images = listOf(IMAGE_URL, IMAGE_URL_2)),
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun videoSfxRequest() = VideoSfxRequest(
        videoUrl = VIDEO_URL,
        soundEffectPrompt = "雨声和脚步声",
        bgmPrompt = "轻柔钢琴背景音乐",
        asmrMode = false,
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun textSfxRequest() = TextSfxRequest(
        prompt = "雷雨天气，窗外风声",
        duration = 5.0f,
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun ttsRequest() = TtsRequest(
        text = "这是一条用于集成测试的语音合成文案。",
        voiceId = VOICE_ID,
        voiceLanguage = "zh",
        voiceSpeed = 1.0f
    )

    fun voiceCloneRequest() = VoiceCloneRequest(
        voiceName = "integration_test_voice",
        voiceUrl = AUDIO_URL,
        callbackUrl = CALLBACK_URL,
        externalTaskId = EXTERNAL_TASK_ID
    )

    fun deleteVoiceRequest() = DeleteVoiceRequest(voiceId = VOICE_ID)
}
