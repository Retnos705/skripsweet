package retno.monitorketinggianair.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusPerDay {
    @SerializedName("id_lokasi")
    @Expose
    private Integer idLokasi;
    @SerializedName("nama_lokasi")
    @Expose
    private String namaLokasi;
    @SerializedName("tinggi_max")
    @Expose
    private String tinggiMax;
    @SerializedName("tinggi_min")
    @Expose
    private String tinggiMin;
    @SerializedName("tinggi_avg")
    @Expose
    private String tinggiAvg;
    @SerializedName("jam_tinggi_max")
    @Expose
    private String jamTinggiMax;
    @SerializedName("jam_tinggi_min")
    @Expose
    private String jamTinggiMin;

    public Integer getIdLokasi() {
        return idLokasi;
    }

    public void setIdLokasi(Integer idLokasi) {
        this.idLokasi = idLokasi;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(Integer idLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public String getTinggiMax() {
        return tinggiMax;
    }

    public void setTinggiMax(String tinggiMax) {
        this.tinggiMax = tinggiMax;
    }

    public String getTinggiMin() {
        return tinggiMin;
    }

    public void setTinggiMin(String tinggiMin) {
        this.tinggiMin = tinggiMin;
    }

    public String getTinggiAvg() {
        return tinggiAvg;
    }

    public void setTinggiAvg(String tinggiAvg) {
        this.tinggiAvg = tinggiAvg;
    }

    public String getJamTinggiMax() {
        return jamTinggiMax;
    }

    public void setJamTinggiMax(String jamTinggiMax) {
        this.jamTinggiMax = jamTinggiMax;
    }

    public String getJamTinggiMin() {
        return jamTinggiMin;
    }

    public void setJamTinggiMin(String jamTinggiMin) {
        this.jamTinggiMin = jamTinggiMin;
    }
}
