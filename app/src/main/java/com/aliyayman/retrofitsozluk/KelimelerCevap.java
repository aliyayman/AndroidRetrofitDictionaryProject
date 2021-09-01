
package com.aliyayman.retrofitsozluk;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class KelimelerCevap {

    @SerializedName("kelimeler")
    @Expose
    private List<Kelimeler> kelimeler = null;
    @SerializedName("success")
    @Expose
    private Integer success;

    public List<Kelimeler> getKelimeler() {
        return kelimeler;
    }

    public void setKelimeler(List<Kelimeler> kelimeler) {
        this.kelimeler = kelimeler;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}
