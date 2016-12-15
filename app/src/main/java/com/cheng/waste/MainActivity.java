package com.cheng.waste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cheng.utils.DeviceUtils;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FloatService.class);
                startService(intent);
            }
        });
        initUtils();
    }
    public void initUtils(){
        DeviceUtils.init(this.getApplicationContext());
    }
}
