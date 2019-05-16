package retno.monitorketinggianair.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        String tinggiMax = (mDetailGrafik.get(position).getTinggiMax())==null?"N/A": ": " + mDetailGrafik.get(position).getTinggiMax() +" CM";
        String tinggiMin = (mDetailGrafik.get(position).getTinggiMin())==null?"N/A": ": " + mDetailGrafik.get(position).getTinggiMin() +" CM";
        String tinggiAvg = (mDetailGrafik.get(position).getTinggiAvg())==null?"N/A": ": " + mDetailGrafik.get(position).getTinggiAvg() +" CM";
        String jamTinggiMax = (mDetailGrafik.get(position).getTinggiMin())==null?"N/A":"( " + mDetailGrafik.get(position).getJamTinggiMax() +" WIB )";
        String jamTinggiMin = (mDetailGrafik.get(position).getTinggiMax())==null?"N/A":"( " + mDetailGrafik.get(position).getJamTinggiMin() +" WIB )";


        holder.txtNamaLokasi.setText(mDetailGrafik.get(position).getNamaLokasi().toUpperCase());
        holder.txtTinggiMax.setText(tinggiMax);
        holder.txtTinggiMin.setText(tinggiMin);
        holder.txtTinggiAvg.setText(tinggiAvg);
        holder.txtJamTinggiMax.setText(jamTinggiMax);
        holder.txtJamTinggiMin.setText(jamTinggiMin);
    }

    @Override
    public int getItemCount(){
        return mDetailGrafik.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView txtNamaLokasi
                ,txtTinggiMax
                ,txtTinggiMin
                ,txtTinggiAvg
                ,txtJamTinggiMax
                ,txtJamTinggiMin;

        public MyViewHolder(View itemView){
            super(itemView);
            txtNamaLokasi = (TextView) itemView.findViewById(R.id.lokasiNama);
            txtTinggiMax = (TextView) itemView.findViewById(R.id.ketinggianMax);
            txtTinggiMin = (TextView) itemView.findViewById(R.id.ketinggianMin);
            txtTinggiAvg = (TextView) itemView.findViewById(R.id.ketinggianAvg);
            txtJamTinggiMax = (TextView) itemView.findViewById(R.id.jamTinggiMax);
            txtJamTinggiMin = (TextView) itemView.findViewById(R.id.jamTinggiMin);
        }
    }
}
