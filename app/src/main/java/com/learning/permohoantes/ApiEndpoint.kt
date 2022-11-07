package com.learning.permohoantes

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {

    @GET("data.php")
    fun data() : Call<NoteModel>

    @FormUrlEncoded
    @POST("create.php")
    fun createData(
        @Field("nama") nama:String?,
        @Field("nohp") nohp:String?,
        @Field("noktp") noktp:String?,
        @Field("alamat") alamat:String?,
        @Field("pekerjaan") pekerjaan:String?,
        @Field("rincian") rincian:String?,
        @Field("tujuan") tujuan:String?
    ) : Call<SubmitModel>
}