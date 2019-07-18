package com.example.svmc_mp.Fragment.TabPhongChatCongKhai_ThanhPhanCon;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.svmc_mp.DoiTuong.MessagePhongCongKhai;
import com.example.svmc_mp.DoiTuong.Users;
import com.example.svmc_mp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ManHinhChatCongKhai extends AppCompatActivity {
    private String idPhong;
    private Toolbar mToolbar;
    private EditText editText;
    private Button button;
    private RecyclerView recyclerView;

    RecyclerAdapterMessage adapterMessage;
    ArrayList<MessagePhongCongKhai> listMessage;

    FirebaseUser firebaseUser;
    String username;
    String hoten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chat_cong_khai);

        mToolbar = (Toolbar) findViewById(R.id.id_toolbar_man_hinh_chat_cong_khai);
        editText = findViewById(R.id.id_edt_chat_cong_khai);
        button = findViewById(R.id.id_btn_chat_cong_khai);
        recyclerView = findViewById(R.id.id_recycler_chat_cong_khai);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);



        // Tìm username hiện tại
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        username = firebaseUser.getEmail();
        String []arr=username.split("@");
        username=arr[0];
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users").child(username);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Users users = dataSnapshot.getValue(Users.class);
                hoten = users.getHoTen();
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });



        // xet bundle
        Bundle bundle = getIntent().getExtras();
        if(bundle== null){
            idPhong = null;
        } else {
            idPhong = bundle.getString("idphong");
            Log.d("tagg",idPhong);
        }
        if(idPhong.equals("phong01")) {
            setMyToolBar(mToolbar,getString(R.string.title_naruto),true);
        } else if(idPhong.equals("phong02")){
            setMyToolBar(mToolbar,getString(R.string.title_onepiece),true);
        }




        // Click để gửi tin nhắn
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noiDungTinNhan = editText.getText().toString();
                if (noiDungTinNhan.equals("")){
                    Toast.makeText(ManHinhChatCongKhai.this, getString(R.string.notbeempty), Toast.LENGTH_SHORT).show();
                } else {
                    HamGuiTinNhan(idPhong, username,hoten, noiDungTinNhan);
                }
                editText.setText("");
            }
        });


        // tham chiếu tới database để đọc dữ liệu
        DatabaseReference referencee = FirebaseDatabase.getInstance().getReference("chatRoom").child(idPhong);
        referencee.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                HamTaiTinNhan(idPhong);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

    }


    private void HamGuiTinNhan(String idPhong, String username, String hoten, String noiDungTinNhan) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        MessagePhongCongKhai messagePhongCongKhai = new MessagePhongCongKhai(idPhong,username,hoten,noiDungTinNhan);
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("idPhong", idPhong);
//        hashMap.put("username", username);
//        hashMap.put("noiDungTinNhan", noiDungTinNhan);
        reference.child("chatRoom").child(idPhong).push().setValue(messagePhongCongKhai);
    }

    private void HamTaiTinNhan(String idPhong) {
        listMessage = new ArrayList<>();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("chatRoom").child(idPhong);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listMessage.clear();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    MessagePhongCongKhai messagePhongCongKhai = dataSnapshot1.getValue(MessagePhongCongKhai.class);
                    listMessage.add(messagePhongCongKhai);
                    adapterMessage = new RecyclerAdapterMessage(listMessage, ManHinhChatCongKhai.this);
                    recyclerView.setAdapter(adapterMessage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //region Hàm set tiêu đề và nút bấm back quay về trang trước
    public final void setMyToolBar(Toolbar toolbar, String title, Boolean showBackHome){
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayShowHomeEnabled(showBackHome);
        actionBar.setDisplayHomeAsUpEnabled(showBackHome);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion



}
