package com.cemilyildirim.randevuislemleri.model

data class Result (
    val isSuccess: Boolean,
    val message: Any? = null,
    val explanation: Any? = null,
    val errorCode: Any? = null,
    val resultObject: List<ResultObject>,
    val jobID: Any? = null,
    val params: Params,
    val requestContextID: String
)
