package retno.monitorketinggianair.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GrafikDataRensponse {
    @SerializedName("data")
    @Expose
    private List<Grafik> data = null;

    public List<Grafik> getData() {
        return data;
    }

    public void setData(List<Grafik> data) {
        this.data = data;
    }
}
