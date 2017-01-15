package com.chinghao.timemanager.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;

import com.chinghao.timemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by ChingHao on 2017/1/12.
 */

public class AboutActivity extends AppCompatActivity{
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.open_network)
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @OnClick(R.id.open_network)
    public void onClick() {
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/chingHao/TimeManager"));
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
