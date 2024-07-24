package com.cemilyildirim.randevuislemleri.repoPattern

import com.cemilyildirim.randevuislemleri.view.service.DataAPI
import kotlinx.coroutines.Dispatchers
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.cemilyildirim.randevuislemleri.view.model.RandevuIslemleriVerileri
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import kotlin.jvm.java


class VeriCekme {

    private val client = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(DataAPI::class.java)

    suspend fun veriCekme(): RandevuIslemleriVerileri {
        return withContext(Dispatchers.IO) {
            retrofit.getData()
        }
    }
    }

