package retno.monitorketinggianair.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retno.monitorketinggianair.Model.StatusPerDay;
import retno.monitorketinggianair.R;

public class AdapterDetailGrafik extends RecyclerView.Adapter<AdapterDetailGrafik.MyViewHolder> {
    List<StatusPerDay> mDetailGrafik;

    public AdapterDetailGrafik(List<StatusPerDay> DetailGrafikList){
        mDetailGrafik = DetailGrafikList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_grafik,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position){
        String status = mDetailGrafik.get(position).getStatus().toUpperCase();
        if(mDetailGrafik.get(position).getIdStatus() == 1){

            holder.mTextViewStatus.setTextColor(Color.GREEN);
        }else if (mDetailGrafik.get(position).getIdStatus() == 2){

            holder.mTextViewStatus.setTextColor(Color.YELLOW);
        }else {
            holder.mTextViewStatus.setTextColor(Color.RED);
        }

        String ketinggianAir = (mDetailGrafik.get(position).getNowTinggi() == null)? "N/A" : ": "+ (String) mDetailGrafik.get(position).getNowTinggi() + " CM";
        String ketinggianMax = ((mDetailGrafik.get(position).getMaxTinggi() == null)? "N/A" : ": "+ (String) mDetailGrafik.get(position).getMaxTinggi()) + " CM" ;
        String ketinggianMin = ((mDetailGrafik.get(position).getMinTinggi() == null)? "N/A" : ": "+ (String) mDetailGrafik.get(position).getMinTinggi()) + " CM" ;
        String ketinggianAvg = (mDetailGrafik.get(position).getAvg() == null)? "N/A" : ": "+ (String) mDetailGrafik.get(position).getAvg() + " CM";
        String jamKetinggianAir = ((mDetailGrafik.get(position).getNowTime() == null)? "N/A" : "( " + (String) mDetailGrafik.get(position).getNowTime()) +" WIB )" ;
        String jamKetinggianMax = ((mDetailGrafik.get(position).getMaxTime() == null)? "N/A" : "( " + (String) mDetailGrafik.get(position).getMaxTime()) +" WIB )" ;
        String jamKetinggianMin = ((mDetailGrafik.get(position).getMin_time() == null)? "N/A" : "( " + (String) mDetailGrafik.get(position).getMin_time()) +" WIB )"  ;

        holder.mTextViewStatus.setText(status);
        holder.mTextViewName.setText((mDetailGrafik.get(position).getName()).toUpperCase());
        holder.mTextViewKetinggianAir.setText(ketinggianAir);
        holder.mTextViewKetinggianMax.setText(ketinggianMax);
        holder.mTextViewKetinggianMin.setText(ketinggianMin);
        holder.mTextViewKetinggianAvg.setText(ketinggianAvg);
        holder.mTextViewJamAir.setText(jamKetinggianAir);
        holder.mTextViewJamMax.setText(jamKetinggianMax);
        holder.mTextViewJamMin.setText(jamKetinggianMin);
    }

    @Override
    public int getItemCount(){
        return mDetailGrafik.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
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
        }
    }
}
