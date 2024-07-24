package com.cemilyildirim.randevuislemleri.repoPattern

import android.provider.ContactsContract
import com.cemilyildirim.randevuislemleri.view.service.DataAPI
import kotlinx.coroutines.Dispatchers
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.cemilyildirim.randevuislemleri.view.model.RandevuIslemleriVerileri
import dagger.Provides
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.jvm.java


class VeriCekme @Inject constructor(
    private val dataAPI : DataAPI
) {
    suspend fun veriCekme(): RandevuIslemleriVerileri{
        return withContext(Dispatchers.IO){
            dataAPI.getData()
        }
    }
    }

