package com.aliyayman.retrofitsozluk;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface KelimelerDaoInterface {

    @GET("kelimeler/tum_kelimeler.php")
    Call<KelimelerCevap> tumKelimeler();

    @POST("kelimeler/kelime_ara.php")
    @FormUrlEncoded
    Call<KelimelerCevap> kelimeAra(@Field("ingilizce")String ingilizce);


}
