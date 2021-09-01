package com.aliyayman.retrofitsozluk;

public class ApiUtils {

    public static final String BASE_URL="http://www.byrmkus.tk/";

    public static KelimelerDaoInterface getKisilerDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(KelimelerDaoInterface.class);


    }
}
