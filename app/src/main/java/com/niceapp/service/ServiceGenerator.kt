package com.niceapp.service

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.google.gson.Gson
import com.niceapp.AppValue.SERVER_URL
import com.niceapp.BuildConfig
import com.niceapp.BaseApp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ServiceGenerator {

    private const val CONNECT_TIME_OUT = 60
    private const val READ_TIME_OUT = 60
    private const val WRITE_TIME_OUT = 60

    //    public const val SERVER_URL = "http://192.168.3.17:8089/"
//    public const val SERVER_URL = "https://www.jiedianyule.com/api/"
//    public const val SERVER_URL = "http://192.168.3.33:8089/"
//    public const val SERVER_URL = "http://test.jiedianyule.com/api/"

    private fun buildOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logInterceptor)
        }
        //设置超时
        httpClient.connectTimeout(CONNECT_TIME_OUT.toLong(), TimeUnit.SECONDS)
        httpClient.readTimeout(READ_TIME_OUT.toLong(), TimeUnit.SECONDS)
        httpClient.writeTimeout(WRITE_TIME_OUT.toLong(), TimeUnit.SECONDS)

        //设置Cookie持久化
        val cookieJar = PersistentCookieJar(SetCookieCache(),
                SharedPrefsCookiePersistor(BaseApp.getApp()))
        httpClient.cookieJar(cookieJar)
        //错误重连
        httpClient.retryOnConnectionFailure(true)
        return httpClient.build()
    }

    fun <T> createService(serviceClass: Class<T>): T {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(SERVER_URL)
                .client(buildOkHttpClient()).build()
        return retrofit.create(serviceClass)
    }
}
