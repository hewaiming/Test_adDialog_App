package com.hewaiming.administrator.test_addialog_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

import com.uuch.adlibrary.AdConstant;
import com.uuch.adlibrary.AdManager;
import com.uuch.adlibrary.bean.AdInfo;
import com.uuch.adlibrary.transformer.DepthPageTransformer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<AdInfo> advList = null;
    private TextView dateText;
    private Button nextBtn;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        dateText = (TextView) findViewById(R.id.date);
        SimpleDateFormat sDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd    hh:mm:ss");
        String date = sDateFormat.format(new java.util.Date());
        dateText.setText(date);
        nextBtn=(Button)findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent=new Intent(context,RecyclerView_CardView_Activity.class);
                context.startActivity(nextIntent);
            }
        });
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
