package com.cheng.waste;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.cheng.utils.DeviceUtils;
import com.cheng.utils.LogUtils;

public class MainActivity extends Activity {

    private final String TAG = "MainActivity";
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        printDeviceInfo();
        toSettings();
    }

    private void printDeviceInfo(){
        int screenWidth = DeviceUtils.getWidth();
        int screenHeight = DeviceUtils.getHeight();
        int dpi = DeviceUtils.getDpi();
        String phone = DeviceUtils.isTablet()?"平板":"手机";
        LogUtils.v(TAG,"ScreenWidth:"+screenWidth+"|ScreenHeight:"+screenHeight+"|dpi:"+dpi+"|scaleWidth:"+DeviceUtils.getScaleWidthDp()+"|"+phone);
    }
    private void toSettings(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
