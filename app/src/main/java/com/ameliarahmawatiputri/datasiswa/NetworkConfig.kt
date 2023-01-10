package com.ameliarahmawatiputri.datasiswa

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

object NetworkConfig {
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return okHttpClient
    }

    //Retrofit
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.224.231/server_api/index.php/ServerApi/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() = getRetrofit().create(SiswaService::class.java)
}


interface SiswaService {
    //fungsi create data
    @FormUrlEncoded
    @POST("addSiswa")
    fun addSiswa(
        @Field("nama") nama: String,
        @Field("kelas") kelas: String
    ): Call<StatusModel>

    //fungsi get data
    @GET("getDataSiswa")
    fun getData(): Call<SiswaModel>

    //fungsi update data
    @FormUrlEncoded
    @POST("updateSiswa")
    fun updateSiswa(
        @Field("id") id: String,
        @Field("nama") name: String,
        @Field("kelas") kelas: String
    ): Call<StatusModel>

    //fungsi delete
    @FormUrlEncoded
    @POST("deleteSiswa")
    fun deleteSiswa(@Field("id") id: String?): Call<StatusModel>

}