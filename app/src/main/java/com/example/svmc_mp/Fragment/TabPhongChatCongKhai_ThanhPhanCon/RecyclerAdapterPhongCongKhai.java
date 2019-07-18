package com.example.svmc_mp.Fragment.TabPhongChatCongKhai_ThanhPhanCon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.svmc_mp.DoiTuong.PhongCongKhai;
import com.example.svmc_mp.R;

import java.util.ArrayList;

public class RecyclerAdapterPhongCongKhai  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ItemClickListener itemClickListener;
    private ArrayList<PhongCongKhai> listPhong;
    private Context context;


    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public RecyclerAdapterPhongCongKhai(ArrayList<PhongCongKhai> listPhong, Context context) {
        this.listPhong = listPhong;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list_phong_cong_khai,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onClick(view,position);
            }
        });
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        PhongCongKhai phongCongKhai = listPhong.get(position);
        myViewHolder.imageView.setImageResource(phongCongKhai.getResourceID());
        myViewHolder.textView.setText(phongCongKhai.getNamePhong());
    }

    @Override
    public int getItemCount() {
        return listPhong.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.id_img_phong_cong_khai);
            textView = (TextView) itemView.findViewById(R.id.id_name_phong_cong_khai);
        }
    }

}
