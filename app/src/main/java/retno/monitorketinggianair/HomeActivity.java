package retno.monitorketinggianair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retno.monitorketinggianair.Adapter.AdapterLokasiStatus;
import retno.monitorketinggianair.Model.LokasiStatus;
import retno.monitorketinggianair.Model.LokasiStatusDataResponse;
import retno.monitorketinggianair.Model.StatusPerDay;
import retno.monitorketinggianair.Model.StatusPerDayDataResponse;
import retno.monitorketinggianair.Rest.ApiClient;
import retno.monitorketinggianair.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static HomeActivity ha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ha=this;
        refresh();
    }

    public void refresh(){
        Call<LokasiStatusDataResponse> lokasiStatusCall = mApiInterface.getLokasiStatus("getLokasiStatus");


        lokasiStatusCall.enqueue(new Callback<LokasiStatusDataResponse>() {
            @Override
            public void onResponse(Call<LokasiStatusDataResponse> call, Response<LokasiStatusDataResponse> response) {
                List<LokasiStatus> lokasiStatusList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(lokasiStatusList.size()));
                mAdapter = new AdapterLokasiStatus(lokasiStatusList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<LokasiStatusDataResponse> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
