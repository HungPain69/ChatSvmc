package com.example.svmc_mp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.svmc_mp.DoiTuong.PhongCongKhai;
import com.example.svmc_mp.Fragment.TabPhongChatCongKhai_ThanhPhanCon.ItemClickListener;
import com.example.svmc_mp.Fragment.TabPhongChatCongKhai_ThanhPhanCon.ManHinhChatCongKhai;
import com.example.svmc_mp.Fragment.TabPhongChatCongKhai_ThanhPhanCon.RecyclerAdapterPhongCongKhai;
import com.example.svmc_mp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class TabPhongChatCongKhai extends Fragment {
    private RecyclerView mrecyclerView;
    private ArrayList<PhongCongKhai> mListPhong;
    private RecyclerAdapterPhongCongKhai mrecyclerAdapterPhongCongKhai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_phong_chat_cong_khai,container,false);
        mrecyclerView = (RecyclerView) view.findViewById(R.id.id_recycler_phongcongkhai);
        mListPhong = new ArrayList<PhongCongKhai>();
        mListPhong.add(new PhongCongKhai("phong01",R.drawable.naruto_logo,getString(R.string.title_naruto)));
        mListPhong.add(new PhongCongKhai("phong02",R.drawable.onepiece_logo,getString(R.string.title_onepiece)));
        mrecyclerAdapterPhongCongKhai = new RecyclerAdapterPhongCongKhai(mListPhong,getContext());
        mrecyclerView.setAdapter(mrecyclerAdapterPhongCongKhai);
        mrecyclerAdapterPhongCongKhai.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent  = new Intent();
                intent.setClass(getContext(), ManHinhChatCongKhai.class);
                switch (position){
                    case 0:
                        intent.putExtra("idphong","phong01");
                        break;
                    case 1:
                        intent.putExtra("idphong","phong02");
                        break;
                }
                startActivity(intent);
            }
        });
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
