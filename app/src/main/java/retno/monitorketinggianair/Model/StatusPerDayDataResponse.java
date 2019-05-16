package retno.monitorketinggianair.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatusPerDayDataResponse {
    @SerializedName("data")
    @Expose
    private List<StatusPerDay> data = null;

    public List<StatusPerDay> getData() {
        return data;
    }

    public void setData(List<StatusPerDay> data) {
        this.data = data;
    }
}
