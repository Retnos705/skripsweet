package retno.monitorketinggianair.Adapter;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retno.monitorketinggianair.GrafikActivity;
import retno.monitorketinggianair.MapsActivity;
import retno.monitorketinggianair.Model.LokasiStatus;
import retno.monitorketinggianair.R;

public class AdapterLokasiStatus extends RecyclerView.Adapter<AdapterLokasiStatus.MyViewHolder> {
    List<LokasiStatus> mLokasiStatus;


    public AdapterLokasiStatus(List<LokasiStatus> LokasiStatusList){
        mLokasiStatus = LokasiStatusList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lokasistatus_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        String status = mLokasiStatus.get(position).getStatus().toUpperCase();
        if(mLokasiStatus.get(position).getIdStatus() == 1){

            holder.mTextViewStatus.setTextColor(Color.GREEN);
        }else if (mLokasiStatus.get(position).getIdStatus() == 2){

            holder.mTextViewStatus.setTextColor(Color.YELLOW);
        }else {
            holder.mTextViewStatus.setTextColor(Color.RED);
        }

        String ketinggianAir = (mLokasiStatus.get(position).getNowTinggi() == null)? "N/A" : ": "+ (String) mLokasiStatus.get(position).getNowTinggi() + " CM";
        String ketinggianMax = ((mLokasiStatus.get(position).getMaxTinggi() == null)? "N/A" : ": "+ (String) mLokasiStatus.get(position).getMaxTinggi()) + " CM" ;
        String ketinggianMin = ((mLokasiStatus.get(position).getMinTinggi() == null)? "N/A" : ": "+ (String) mLokasiStatus.get(position).getMinTinggi()) + " CM" ;
        String ketinggianAvg = (mLokasiStatus.get(position).getAvg() == null)? "N/A" : ": "+ (String) mLokasiStatus.get(position).getAvg() + " CM";
        String jamKetinggianAir = ((mLokasiStatus.get(position).getNowTime() == null)? "N/A" : "( " + (String) mLokasiStatus.get(position).getNowTime()) +" WIB )" ;
        String jamKetinggianMax = ((mLokasiStatus.get(position).getMaxTime() == null)? "N/A" : "( " + (String) mLokasiStatus.get(position).getMaxTime()) +" WIB )" ;
        String jamKetinggianMin = ((mLokasiStatus.get(position).getMin_time() == null)? "N/A" : "( " + (String) mLokasiStatus.get(position).getMin_time()) +" WIB )"  ;

        holder.mTextViewStatus.setText(status);
        holder.mTextViewName.setText((mLokasiStatus.get(position).getName()).toUpperCase());
        holder.mTextViewKetinggianAir.setText(ketinggianAir);
        holder.mTextViewKetinggianMax.setText(ketinggianMax);
        holder.mTextViewKetinggianMin.setText(ketinggianMin);
        holder.mTextViewKetinggianAvg.setText(ketinggianAvg);
        holder.mTextViewJamAir.setText(jamKetinggianAir);
        holder.mTextViewJamMax.setText(jamKetinggianMax);
        holder.mTextViewJamMin.setText(jamKetinggianMin);

        holder.mBtnGrafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),GrafikActivity.class);
                intent.putExtra("id",mLokasiStatus.get(position).getId().toString());
                v.getContext().startActivity(intent);
            }
        });

        holder.mBtnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapsActivity.class);
                intent.putExtra("id",mLokasiStatus.get(position).getId().toString());
                intent.putExtra("name",mLokasiStatus.get(position).getName());
                intent.putExtra("lat",""+mLokasiStatus.get(position).getLatitude());
                intent.putExtra("lng",""+mLokasiStatus.get(position).getLongitude());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mLokasiStatus.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewStatus
                        ,mTextViewName
                        ,mTextViewKetinggianAir
                        ,mTextViewKetinggianMax
                        ,mTextViewJamAir
                        ,mTextViewJamMax
                        ,mTextViewJamMin
                        ,mTextViewKetinggianMin
                        ,mTextViewKetinggianAvg;

        public Button mBtnGrafik
                ,mBtnMap;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewStatus = (TextView) itemView.findViewById(R.id.status);
            mTextViewName=(TextView) itemView.findViewById(R.id.lokasiNama);
            mTextViewKetinggianAir = (TextView) itemView.findViewById(R.id.ketinggianAir);
            mTextViewKetinggianMax = (TextView) itemView.findViewById(R.id.ketinggianMax);
            mTextViewKetinggianMin = (TextView) itemView.findViewById(R.id.ketinggianMin);
            mTextViewJamAir = (TextView) itemView.findViewById(R.id.jamTinggiAir);
            mTextViewJamMax = (TextView) itemView.findViewById(R.id.jamTinggiMax);
            mTextViewJamMin = (TextView) itemView.findViewById(R.id.jamTinggiMin);
            mTextViewKetinggianAvg = (TextView) itemView.findViewById(R.id.ketinggianAvg);
            mBtnGrafik = (Button) itemView.findViewById(R.id.btnGrafik);
            mBtnMap = (Button) itemView.findViewById(R.id.btnMap);
        }
    }
}
