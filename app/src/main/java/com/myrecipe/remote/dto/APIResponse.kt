package com.myrecipe.remote.dto

/**
 * API响应 泛型
 * Created by sun on 2017/8/29.
 */
class APIResponse<T> {
    var status = "0"
    var msg = ""
    var result: T? = null
}