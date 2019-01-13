package com.niceapp.main.activity

import android.content.Intent
import android.os.Bundle
import com.niceapp.R
import com.niceapp.base.BaseActivity
import com.niceapp.base.actionbar.StatusUtils
import com.niceapp.utils.RxCountDown
import com.bumptech.glide.Glide
import com.cheddd.nqd.base.actionbar.ActionBarStyle
import kotlinx.android.synthetic.main.activity_splash.*
import rx.Subscriber

/**
 * Created by mateng on 2018/3/22.
 *
 */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        Glide.with(this).load(R.drawable.qidongye).into(image_splash);

        StatusUtils.setFullToNavigationBar(this)

        registerSubscription(RxCountDown.countdown(3)
                .subscribe(object : Subscriber<Int>() {
                    override fun onNext(t: Int?) {

                    }

                    override fun onCompleted() {
                        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                        finish()
                    }

                    override fun onError(e: Throwable?) {
                    }
                }))
    }

    override fun setActionBarStyle(): ActionBarStyle {
        return ActionBarStyle.NONE
    }


}