package com.hewaiming.administrator.test_addialog_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.net.Uri;

import com.uuch.adlibrary.AdConstant;
import com.uuch.adlibrary.AdManager;
import com.uuch.adlibrary.bean.AdInfo;
import com.uuch.adlibrary.transformer.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<AdInfo> advList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAd();
    }

    private void initAd() {
        initData();
        AdManager adManager = new AdManager(MainActivity.this, advList);
        adManager.setOverScreen(true)
                .setDialogCloseable(true)
                .setOnImageClickListener(new AdManager.OnImageClickListener() {
                    @Override
                    public void onImageClick(View view, AdInfo advInfo) {
                        Toast.makeText(MainActivity.this, advInfo.getUrl(), Toast.LENGTH_LONG).show();
                        GoToWeb(advInfo.getUrl());
                    }
                })
                .setPageTransformer(new DepthPageTransformer());
        //adManager.showAdDialog(AdConstant.ANIM_DOWN_TO_UP);
        adManager.showAdDialog(AdConstant.ANIM_LEFT_TO_RIGHT);
    }

    private void GoToWeb(String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        advList = new ArrayList<>();
        AdInfo adInfo = new AdInfo();
        adInfo.setTitle("优惠活动");
        adInfo.setUrl("http://www.ifeng.com");
        adInfo.setActivityImg("https://raw.githubusercontent.com/yipianfengye/android-adDialog/master/images/testImage1.png");
        advList.add(adInfo);

        adInfo = new AdInfo();
        adInfo.setActivityImg("https://raw.githubusercontent.com/yipianfengye/android-adDialog/master/images/testImage2.png");
        advList.add(adInfo);

        adInfo = new AdInfo();
        adInfo.setActivityImg("http://s14.sinaimg.cn/large/528280c0g9e6ee370fead&690");
        advList.add(adInfo);
    }
}
