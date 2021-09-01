
package com.aliyayman.retrofitsozluk;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Kelimeler implements Serializable {

    @SerializedName("kelime_id")
    @Expose
    private String kelimeId;
    @SerializedName("ingilizce")
    @Expose
    private String ingilizce;
    @SerializedName("turkce")
    @Expose
    private String turkce;

    public String getKelimeId() {
        return kelimeId;
    }

    public void setKelimeId(String kelimeId) {
        this.kelimeId = kelimeId;
    }

    public String getIngilizce() {
        return ingilizce;
    }

    public void setIngilizce(String ingilizce) {
        this.ingilizce = ingilizce;
    }

    public String getTurkce() {
        return turkce;
    }

    public void setTurkce(String turkce) {
        this.turkce = turkce;
    }

}
