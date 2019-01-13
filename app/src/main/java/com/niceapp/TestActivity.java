package com.niceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.niceapp.utils.ToastUtils;
import com.niceapp.view.user.activity.GuideActivity;

public class TestActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3;
    LinearLayout ll;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        tv1 = findViewById(R.id.tv1_test);
        tv2 = findViewById(R.id.tv2_test);
        tv3 = findViewById(R.id.tv3_test);
        ll = findViewById(R.id.ll_test);
        et = findViewById(R.id.et_test);
        tv1.setOnClickListener(v -> {
            AppValue.SOCKET_IP = "47.75.52.2";
            AppValue.SERVER_URL = "http://47.75.52.2:8089/";
//            AppValue.SERVER_URL = "http://m.jiedianyule.com/api/";
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
            finish();
        });

        tv2.setOnClickListener(v -> {
            AppValue.SOCKET_IP = "47.75.52.8";
            AppValue.SERVER_URL = "http://47.75.52.8:8089/";
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
            finish();
        });

        tv3.setOnClickListener(v -> {
            AppValue.SOCKET_IP = "192.168.3.22";
            AppValue.SERVER_URL = "http://m.jiedianyuele.com/api/";
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
            finish();
        });

        ll.setOnClickListener(v -> {
            if (TextUtils.isEmpty(et.getText().toString().trim())) {
                ToastUtils.showToast(TestActivity.this, "IP地址？");
                return;
            } else {
                AppValue.SOCKET_IP = "192.168.3." + et.getText().toString().trim();
                AppValue.SERVER_URL = "http://192.168.3." + et.getText().toString().trim() + ":8089/";
            }
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
