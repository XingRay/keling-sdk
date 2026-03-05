package com.github.xingray.kelingsdk.common

/**
 * 任务状态枚举
 */
object TaskStatus {
    /** 已提交 */
    const val SUBMITTED = "submitted"
    /** 处理中 */
    const val PROCESSING = "processing"
    /** 已完成 */
    const val SUCCEED = "succeed"
    /** 失败 */
    const val FAILED = "failed"
}
