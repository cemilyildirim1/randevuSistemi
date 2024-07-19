package com.cemilyildirim.randevuislemleri.view.model

data class RandevuIslemleriVerileri(
    val isMaintenance: Boolean,
    val statusCode: Long,
    val errorMessage: Any? = null,
    val errorCode: Any? = null,
    val validationErrorMessages: Any? = null,
    val result: Result,
    val sid: String,
    val requestID: String,
    val logURL: String
)
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

class Params()

data class ResultObject (
    val key: Long,
    val value: String,
    val image: String
)