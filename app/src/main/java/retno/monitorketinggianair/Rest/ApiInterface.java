package retno.monitorketinggianair.Rest;

import okhttp3.ResponseBody;
import retno.monitorketinggianair.Model.GrafikDataRensponse;

import retno.monitorketinggianair.Model.LokasiStatusDataResponse;
import retno.monitorketinggianair.Model.StatusPerDayDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("get_lokasi_status")
    Call<LokasiStatusDataResponse> getLokasiStatus();

    @GET("get_lokasi_status/{id}")
    Call<StatusPerDayDataResponse> getStatusPerDay(@Path(value = "id") String id);

    @GET("get_grafik/{id}")
    Call<GrafikDataRensponse> getGrafik(@Path(value = "id") String id);

}
