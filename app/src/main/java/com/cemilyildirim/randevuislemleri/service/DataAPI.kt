package com.cemilyildirim.randevuislemleri.view.service

import com.cemilyildirim.randevuislemleri.view.model.RandevuIslemleriVerileri
import retrofit2.http.GET


interface DataAPI {

    //BASE URL -> https://raw.githubusercontent.com/
    //END POİNT -> bydevelopertr/versionproject/master/menu.json

    @GET("bydevelopertr/versionproject/master/menu.json")
    suspend fun getData() :RandevuIslemleriVerileri


}
