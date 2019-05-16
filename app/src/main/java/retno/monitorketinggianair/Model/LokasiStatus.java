package retno.monitorketinggianair.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LokasiStatus {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("jam_tinggi_air")
    @Expose
    private Object jamTinggiAir;

    @SerializedName("ketinggian_air")
    @Expose
    private Object ketinggianAir;

    @SerializedName("tinggi_max")
    @Expose
    private Object tinggiMax;

    @SerializedName("jam_tinggi_max")
    @Expose
    private Object jamTinggiMax;

    @SerializedName("tinggi_min")
    @Expose
    private Object tinggiMin;

    @SerializedName("jam_tinggi_min")
    @Expose
    private Object jamTinggiMin;

    @SerializedName("tinggi_avg")
    @Expose
    private Object tinggiAvg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getJamTinggiAir() {
        return jamTinggiAir;
    }

    public void setJamTinggiAir(Object jamTinggiAir) {
        this.jamTinggiAir = jamTinggiAir;
    }

    public Object getKetinggianAir() {
        return ketinggianAir;
    }

    public void setKetinggianAir(Object ketinggianAir) {
        this.ketinggianAir = ketinggianAir;
    }

    public Object getTinggiMax() {
        return tinggiMax;
    }

    public void setTinggiMax(Object tinggiMax) {
        this.tinggiMax = tinggiMax;
    }

    public Object getJamTinggiMax() {
        return jamTinggiMax;
    }

    public void setJamTinggiMax(Object jamTinggiMax) {
        this.jamTinggiMax = jamTinggiMax;
    }

    public Object getTinggiMin() {
        return tinggiMin;
    }

    public void setTinggiMin(Object tinggiMin) {
        this.tinggiMin = tinggiMin;
    }

    public Object getJamTinggiMin() {
        return jamTinggiMin;
    }

    public void setJamTinggiMin(Object jamTinggiMin) {
        this.jamTinggiMin = jamTinggiMin;
    }

    public Object getTinggiAvg() {
        return tinggiAvg;
    }

    public void setTinggiAvg(Object tinggiAvg) {
        this.tinggiAvg = tinggiAvg;
    }
}
