package retno.monitorketinggianair.Rest;

import okhttp3.ResponseBody;
import retno.monitorketinggianair.Model.GrafikDataRensponse;
import retno.monitorketinggianair.Model.LokasiStatusDataResponse;
import retno.monitorketinggianair.Model.StatusPerDayDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("Api.php")
    Call<LokasiStatusDataResponse> getLokasiStatus(@Query("api") String api);

    @GET("Api.php")
    Call<StatusPerDayDataResponse> getStatusPerDay(@Query("api") String api,
                                                   @Query("id_lokasi") String idLokasi,
                                                   @Query("date") String date);
    @GET("Api.php")
    Call<GrafikDataRensponse> getGrafik(@Query("api") String api,
                                        @Query("id_lokasi") String idLokasi,
                                        @Query("date") String date);

    @GET("Api.php")
    Call<ResponseBody> getGrafikk(@Query("api") String api,
                                 @Query("id_lokasi") String idLokasi,
                                 @Query("date") String date);

}
