package retno.monitorketinggianair.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LokasiStatus {
    @SerializedName("id_lokasi")
    @Expose
    private Integer id;

    @SerializedName("nama")
    @Expose
    private String name;

    @SerializedName("lat")
    @Expose
    private Double latitude;

    @SerializedName("lng")
    @Expose
    private Double longitude;

    @SerializedName("now_time")
    @Expose
    private Object nowTime;

    @SerializedName("now_tinggi")
    @Expose
    private Object nowTinggi;

    @SerializedName("max_time")
    @Expose
    private Object maxTime;

    @SerializedName("max_tinggi")
    @Expose
    private Object maxTinggi;

    @SerializedName("min_time")
    @Expose
    private Object min_time;

    @SerializedName("min_tinggi")
    @Expose
    private Object minTinggi;

    @SerializedName("avg")
    @Expose
    private Object avg;

    @SerializedName("id_status")
    @Expose
    private Integer idStatus;

    @SerializedName("status")
    @Expose
    private String status;


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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Object getNowTime() {
        return nowTime;
    }

    public void setNowTime(Object nowTime) {
        this.nowTime = nowTime;
    }

    public Object getNowTinggi() {
        return nowTinggi;
    }

    public void setNowTinggi(Object nowTinggi) {
        this.nowTinggi = nowTinggi;
    }

    public Object getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Object maxTime) {
        this.maxTime = maxTime;
    }

    public Object getMaxTinggi() {
        return maxTinggi;
    }

    public void setMaxTinggi(Object maxTinggi) {
        this.maxTinggi = maxTinggi;
    }

    public Object getMin_time() {
        return min_time;
    }

    public void setMin_time(Object min_time) {
        this.min_time = min_time;
    }

    public Object getMinTinggi() {
        return minTinggi;
    }

    public void setMinTinggi(Object minTinggi) {
        this.minTinggi = minTinggi;
    }

    public Object getAvg() {
        return avg;
    }

    public void setAvg(Object avg) {
        this.avg = avg;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
