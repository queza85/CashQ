package com.branjoe.cashq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.branjoe.cashq.service.ScreenService;

public class SettingActivity extends Activity {
    private Button onBtn, offBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        onBtn = findViewById(R.id.btn_on);
        offBtn = findViewById(R.id.btn_off);

        onBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ScreenService.class);
                startService(intent);
                Toast.makeText(SettingActivity.this,"Start Service",Toast.LENGTH_SHORT).show();
            }
        });

        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ScreenService.class);
                stopService(intent);
            }
        });
    }
}