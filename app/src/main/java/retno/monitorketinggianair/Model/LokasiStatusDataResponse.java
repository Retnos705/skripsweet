package retno.monitorketinggianair.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LokasiStatusDataResponse {
    @SerializedName("data")
    @Expose
    private List<LokasiStatus> data = null;

    public List<LokasiStatus> getData() {
        return data;
    }

    public void setData(List<LokasiStatus> data) {
        this.data = data;
    }
}
