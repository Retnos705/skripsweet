package retno.monitorketinggianair.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grafik {
    @SerializedName("id_lokasi")
    @Expose
    private Integer idLokasi;
    @SerializedName("jam")
    @Expose
    private Integer jam;
    @SerializedName("ketinggian_air")
    @Expose
    private String ketinggianAir;

    public Integer getIdLokasi() {
        return idLokasi;
    }

    public void setIdLokasi(Integer idLokasi) {
        this.idLokasi = idLokasi;
    }

    public Integer getJam() {
        return jam;
    }

    public void setJam(Integer jam) {
        this.jam = jam;
    }

    public String getKetinggianAir() {
        return ketinggianAir;
    }

    public void setKetinggianAir(String ketinggianAir) {
        this.ketinggianAir = ketinggianAir;
    }
}
