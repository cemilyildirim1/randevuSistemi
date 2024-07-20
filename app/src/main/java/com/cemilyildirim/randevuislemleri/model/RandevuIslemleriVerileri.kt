package com.cemilyildirim.randevuislemleri.view.model
import com.cemilyildirim.randevuislemleri.model.Result


data class RandevuIslemleriVerileri(
    val isMaintenance: Boolean,
    val statusCode: Long,
    val errorMessage: Any? = null,
    val errorCode: Any? = null,
    val validationErrorMessages: Any? = null,
    val result: Result,
    val sid: String,
    val requestId: String,
    val logUrl: String
)




