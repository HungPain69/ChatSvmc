package com.example.svmc_mp.Fragment.TabCaiDat_ThanhPhanCon;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.svmc_mp.R;

import java.util.Locale;

public class ChonNgonNgu extends AppCompatActivity {
    private RadioGroup radioGroup;
    private static RadioButton radTiengViet, radTiengAnh;
    private Button btnSave;
    private Toolbar mToolbar;
    private Locale locale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ngon_ngu);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar_man_hinh_chinh);
        setMyToolBar(mToolbar,getString(R.string.title_chon_ngon_ngu),true);

        radioGroup = (RadioGroup) findViewById(R.id.id_radiogroup_ngonngu);
        radTiengAnh = (RadioButton) findViewById(R.id.id_radiobutton_tienganh);
        radTiengViet = findViewById(R.id.id_radiobutton_tiengviet);
        btnSave = (Button) findViewById(R.id.id_btn_save_doi_ngonngu);


        int id = radioGroup.getCheckedRadioButtonId();
        switch (id){
            case R.id.id_radiobutton_tienganh:
                locale = new Locale("en");
                break;
            case R.id.id_radiobutton_tiengviet:
                locale = new Locale("vi");
                break;
        }
        //changeLanguage();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radTiengAnh.isChecked()) {
                    locale = new Locale("en");
                    radTiengAnh.setChecked(true);
                    radTiengViet.setChecked(false);
                    changeLanguage();
                }

                if(radTiengViet.isChecked()) {
                    locale = new Locale("vi");
                    radTiengViet.setChecked(true);
                    radTiengAnh.setChecked(false);
                    changeLanguage();
                }
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


    private void changeLanguage() {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, ChonNgonNgu.class);
        startActivity(refresh);
        finish();
    }
}
