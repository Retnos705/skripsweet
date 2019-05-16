package retno.monitorketinggianair;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retno.monitorketinggianair.Adapter.AdapterDetailGrafik;
import retno.monitorketinggianair.Adapter.MyMarkerView;
import retno.monitorketinggianair.Model.Grafik;
import retno.monitorketinggianair.Model.GrafikDataRensponse;
import retno.monitorketinggianair.Model.StatusPerDay;
import retno.monitorketinggianair.Model.StatusPerDayDataResponse;
import retno.monitorketinggianair.Rest.ApiClient;
import retno.monitorketinggianair.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GrafikActivity extends AppCompatActivity {
    String lokasiId ;
    Date todayDate = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String strTodayDate = dateFormat.format(todayDate);

    List<Grafik> mGrafik;

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static GrafikActivity ga;

    private LineChart mChart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik);

        Intent intent = getIntent();
        lokasiId = intent.getStringExtra("id");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewDetailGrafik);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ga=this;
        getStatus();
        getGrafik();
    }

    public void getStatus(){

        Call<StatusPerDayDataResponse> statusPerDayDataResponseCall = mApiInterface.getStatusPerDay("getStatusPerDay",lokasiId,strTodayDate);

        statusPerDayDataResponseCall.enqueue(new Callback<StatusPerDayDataResponse>() {
            @Override
            public void onResponse(Call<StatusPerDayDataResponse> call, Response<StatusPerDayDataResponse> response) {
                List<StatusPerDay> statusPerDayList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data status: " +
                        String.valueOf(statusPerDayList.size()));
                mAdapter = new AdapterDetailGrafik(statusPerDayList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<StatusPerDayDataResponse> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });

    }
    public void getGrafik(){
        Call<GrafikDataRensponse> grafikDataRensponseCall = mApiInterface.getGrafik("getDetailForGrafik",lokasiId,strTodayDate);

        grafikDataRensponseCall.enqueue(new Callback<GrafikDataRensponse>() {
            @Override
            public void onResponse(Call<GrafikDataRensponse> call, Response<GrafikDataRensponse> response) {
                List<Grafik> grafikList = response.body().getData();
                Log.d("Retrofit Get","jumlah data grafik :" +String.valueOf(grafikList.size()));

                renderGrafik(grafikList);
            }

            @Override
            public void onFailure(Call<GrafikDataRensponse> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    public void renderGrafik(List<Grafik> grafikList){
        mChart = findViewById(R.id.chart);
        mChart.setTouchEnabled(true);
        mChart.setPinchZoom(true);

        MyMarkerView mv = new MyMarkerView(getApplicationContext(), R.layout.custom_marker_view);
        mv.setChartView(mChart);
        mChart.setMarker(mv);
        renderData(grafikList);
    }

    public void renderData(List<Grafik> grafikList) {
        LimitLine llXAxis = new LimitLine(24f, "Index 10");
        llXAxis.setLineWidth(4f);
        llXAxis.enableDashedLine(10f, 24f, 0f);
        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        llXAxis.setTextSize(10f);

        XAxis xAxis = mChart.getXAxis();
        xAxis.enableGridDashedLine(24f, 24f, 0f);
        xAxis.setAxisMaximum(24f);
        xAxis.setAxisMinimum(0f);
        xAxis.setDrawLimitLinesBehindData(true);

        LimitLine ll1 = new LimitLine(20f, "Batas Bahaya");
        ll1.setLineWidth(4f);
        ll1.enableDashedLine(10f, 10f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        ll1.setTextSize(10f);

        LimitLine ll2 = new LimitLine(10f, "Batas Waspada");
        ll2.setLineWidth(4f);
        ll2.enableDashedLine(10f, 10f, 0f);
        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        ll2.setTextSize(10f);
        ll2.setLineColor(Color.YELLOW);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.addLimitLine(ll1);
        leftAxis.addLimitLine(ll2);
        leftAxis.setAxisMaximum(30f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawLimitLinesBehindData(false);

        mChart.getAxisRight().setEnabled(false);
        setData(grafikList);
    }


    private void setData(List<Grafik> grafikList){
        ArrayList<Entry> values = new ArrayList<>();
        if(grafikList.size()>0){
            for (Integer i=0;i<grafikList.size();i++){
                values.add(new Entry(grafikList.get(i).getJam(),Integer.parseInt(grafikList.get(i).getKetinggianAir())));
            }
        }


        LineDataSet set1;
        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new LineDataSet(values, "Ketinggian Air");
            set1.setDrawIcons(false);
            set1.enableDashedLine(10f, 5f, 0f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(Color.DKGRAY);
            set1.setCircleColor(Color.DKGRAY);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);

            if (Utils.getSDKInt() >= 18) {
                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_blue);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.DKGRAY);
            }
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);
            mChart.setData(data);
        }
    }

}
