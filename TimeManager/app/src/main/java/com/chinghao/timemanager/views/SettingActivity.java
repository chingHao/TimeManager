package com.chinghao.timemanager.views;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.chinghao.timemanager.R;
import com.chinghao.timemanager.fragments.SettingFragment;

/**
 * Created by ChingHao on 2017/1/11.
 */

public class SettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SettingFragment settingFragment=new SettingFragment();
        FragmentManager fragmentManager=getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_settings,settingFragment).commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.home){
            toMainActivity();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void toMainActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        toMainActivity();
        finish();
//        super.onBackPressed();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
