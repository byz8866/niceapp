package com.niceapp.view.user.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.niceapp.R;
import com.niceapp.base.BaseActivity;
import com.cheddd.nqd.base.actionbar.ActionBarStyle;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends BaseActivity {

    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvLogin = findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @NotNull
    @Override
    public ActionBarStyle setActionBarStyle() {
        return ActionBarStyle.GENERIC_BACK_BAR_NOT_DIVIDING;
    }
}
