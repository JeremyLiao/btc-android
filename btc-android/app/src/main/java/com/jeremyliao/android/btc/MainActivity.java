package com.jeremyliao.android.btc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jeremyliao.android.btc.utils.EncryptUtils;

public class MainActivity extends AppCompatActivity {

    TextView tcContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tcContent = findViewById(R.id.tv_content);
        show();
    }

    private void show() {
        String src = "Hello, world!0";
        String result = EncryptUtils.encryptSHA256ToString(src.getBytes());
        StringBuilder sb = new StringBuilder();
        sb.append(src).append("\n").append(result);
        tcContent.setText(sb.toString());
    }
}
