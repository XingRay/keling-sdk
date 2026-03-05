package com.github.xingray.kelingsdk.common

/**
 * 分页查询参数
 * @param pageNum 页码，取值范围[1,1000]
 * @param pageSize 每页数据量，取值范围[1,500]
 */
data class PageQuery(
    val pageNum: Int = 1,
    val pageSize: Int = 30
)
