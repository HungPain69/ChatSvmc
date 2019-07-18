package com.example.svmc_mp.Fragment.TabPhongChatCongKhai_ThanhPhanCon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.svmc_mp.DoiTuong.MessagePhongCongKhai;
import com.example.svmc_mp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class RecyclerAdapterMessage extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<MessagePhongCongKhai> listMessage;
    private Context context;
    FirebaseUser firebaseUser;


    public RecyclerAdapterMessage(ArrayList<MessagePhongCongKhai> listMessage, Context context) {
        this.listMessage = listMessage;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String currentUser = firebaseUser.getEmail();
        String []arr=currentUser.split("@");
        currentUser=arr[0];
        String nguoiGui = listMessage.get(position).getUsername();
        if(nguoiGui.equals(currentUser)){
            return 1;
        }
        else{
            return 0;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case 0:// truong hop nhan tin nhan
                View view0 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phong_cong_khai_nhan_mess, parent, false);
                MyViewHolderNhanTin myViewHolder0 = new MyViewHolderNhanTin(view0);
                return myViewHolder0;
            case 1:// truong hop gui tin nhan
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phong_cong_khai_gui_mess, parent, false);
                MyViewHolderGuiTin myViewHolder2 = new MyViewHolderGuiTin(view1);
                return myViewHolder2;
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case 0:
                MyViewHolderNhanTin myViewHolderNhanTin = (MyViewHolderNhanTin) holder;
                MessagePhongCongKhai message0 = listMessage.get(position);
                myViewHolderNhanTin.tvName.setText(message0.getTenNguoiGui());
                String ten = message0.getTenNguoiGui();
                int i = ten.lastIndexOf(' ');
                if(i==-1){
                    myViewHolderNhanTin.imgIcon.setImageResource(setAvatar(ten.charAt(0)));
                }
                else myViewHolderNhanTin.imgIcon.setImageResource(setAvatar(ten.charAt(i+1)));
                myViewHolderNhanTin.tvMessage.setText(message0.getNoiDungTinNhan());
                break;

            case 1:
                MyViewHolderGuiTin myViewHolderGuiTin = (MyViewHolderGuiTin) holder;
                MessagePhongCongKhai message1 = listMessage.get(position);
                myViewHolderGuiTin.tvName.setText(message1.getTenNguoiGui());
                String tenn = message1.getTenNguoiGui();
                int ii = tenn.lastIndexOf(' ');
                if(ii==-1){
                    myViewHolderGuiTin.imgIcon.setImageResource(setAvatar(tenn.charAt(0)));

                }
                else myViewHolderGuiTin.imgIcon.setImageResource(setAvatar(tenn.charAt(ii+1)));
                myViewHolderGuiTin.tvMessage.setText(message1.getNoiDungTinNhan());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listMessage.size();
    }

    class MyViewHolderNhanTin  extends RecyclerView.ViewHolder{
        ImageView imgIcon;
        TextView tvName;
        TextView tvMessage;
        public MyViewHolderNhanTin(View view){
            super(view);
            imgIcon = (ImageView) view.findViewById(R.id.id_img_avatar_nhan_mess_cong_khai);
            tvName  = (TextView) view.findViewById(R.id.id_tv_ten_nguoi_nhan_mess_chat_cong_khai);
            tvMessage = (TextView) view.findViewById(R.id.id_tv_nhan_noi_dung_chat_cong_khai);
        }
    }
    class MyViewHolderGuiTin  extends RecyclerView.ViewHolder{
        ImageView imgIcon;
        TextView tvName;
        TextView tvMessage;
        public MyViewHolderGuiTin(View view){
            super(view);
            imgIcon = (ImageView) view.findViewById(R.id.id_img_avatar_gui_mess_cong_khai);
            tvName  = (TextView) view.findViewById(R.id.id_tv_ten_nguoi_gui_mess_chat_cong_khai);
            tvMessage = (TextView) view.findViewById(R.id.id_tv_gui_noi_dung_chat_cong_khai);
        }
    }
    public int setAvatar(char ch) {
        switch (ch){
            case 'A':
            case 'a':
            case 'Â':
            case 'â':
            case 'Ă':
            case 'ă':
                return R.drawable.avatar_a;
            case 'B':
            case 'b':
                return R.drawable.avatar_b;
            case 'C':
            case 'c':
                return R.drawable.avatar_c;
            case 'D':
            case 'd':
                return R.drawable.avatar_d;
            case 'E':
            case 'e':
            case 'Ê':
            case 'ê':
                return R.drawable.avatar_e;
            case 'F':
            case 'f':
                return  R.drawable.avatar_f;
            case 'G':
            case 'g':
                return R.drawable.avatar_g;
            case 'H':
            case 'h':
                return R.drawable.avatar_h;
            case 'I':
            case 'i':
                return R.drawable.avatar_i;
            case 'J':
            case 'j':
                return R.drawable.avatar_j;
            case 'K':
            case 'k':
                return R.drawable.avatar_k;
            case 'L':
            case 'l':
                return R.drawable.avatar_l;
            case 'M':
            case 'm':
                return R.drawable.avatar_m;
            case 'N':
            case 'n':
                return R.drawable.avatar_n;
            case 'O':
            case 'o':
            case 'Ô':
            case 'ô':
            case 'Ơ':
            case 'ơ':
                return  R.drawable.avatar_o;
            case 'P':
            case 'p':
                return R.drawable.avatar_p;
            case 'Q':
            case 'q':
                return R.drawable.avatar_q;
            case 'R':
            case 'r':
                return R.drawable.avatar_r;
            case 'S':
            case 's':
                return R.drawable.avatar_s;
            case 'T':
            case 't':
                return R.drawable.avatar_t;
            case 'U':
            case 'u':
            case 'Ư':
            case 'ư':
                return R.drawable.avatar_u;
            case 'V':
            case 'v':
                return R.drawable.avatar_v;
            case 'W':
            case 'w':
                return R.drawable.avatar_w;
            case 'X':
            case 'x':
                return R.drawable.avatar_x;
            case 'Y':
            case 'y':
                return R.drawable.avatar_y;
            case 'Z':
            case 'z':
            default:
                return R.drawable.avatar_z;
        }
    }
}
