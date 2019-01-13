package com.niceapp.main.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.ViewPager
import android.util.Log
import com.niceapp.R
import com.niceapp.base.BaseActivity
import com.niceapp.main.adapter.FragmentPagerAdapter
import com.niceapp.main.dialog.ActivityDialog
import com.niceapp.main.dialog.FirstLogInDialog
import com.niceapp.main.dialog.UpdateDialog
import com.niceapp.main.fragment.HomeFragment
import com.niceapp.model.result.ActivityResult
import com.niceapp.model.result.BaseResult
import com.niceapp.model.result.LoginResult
import com.niceapp.service.SocketService
import com.niceapp.utils.RxCountDown
import com.niceapp.view.pop.PopMgr
import com.niceapp.view.pop.model.UpgradeModel
import com.cheddd.nqd.base.actionbar.ActionBarStyle
import com.tencent.bugly.beta.Beta
import com.umeng.socialize.UMShareAPI
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import rx.Subscriber

class MainActivity : BaseActivity() {
    private var i = 0
    //    private var dropNum = 0;
    var subscriber: Subscriber<Int>? = null
    var homePageDialog_FirstLogIn: FirstLogInDialog = FirstLogInDialog()
    var homePageDialog_Update: UpdateDialog = UpdateDialog()
    var dialog_Activity: ActivityDialog = ActivityDialog()
    var fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    var runable: Runnable = Runnable {
        showDisconnectDialog()
    }
    var handler: Handler? = null
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager()
        EventBus.getDefault().register(this)

        //自定义换肤属性需要动态添加
        dynamicAddView(tvHome_main, "drawableTop", R.drawable.ic_tab_home_selector)

        handler = Handler()

        PopMgr.getInstance().setPopCallback { popType, obj ->
            run {
                when (popType) {
                    PopMgr.POP_UPGRADE -> {
                        val upgradeModel: UpgradeModel = obj as UpgradeModel
                        //显示弹窗
                        val bundle = Bundle()
                        bundle.putSerializable("update", upgradeModel)
                        homePageDialog_Update.arguments = bundle
                        homePageDialog_Update.show(supportFragmentManager, "update")
                    }
                    PopMgr.POP_NEWER_REGISTER -> {
                        val loginResult: LoginResult = obj as LoginResult
                        //显示弹窗
                        if (loginResult.isFirstLogin) {
                            val d = loginResult.reward
                            val bundle = Bundle()
                            bundle.putString("reward", d)
                            homePageDialog_FirstLogIn.arguments = bundle
//                            fragmentTransaction.add(homePageDialog_FirstLogIn, this.javaClass.simpleName)
                            //防止onSaveInstanceState报错
                            homePageDialog_FirstLogIn.show(supportFragmentManager, "reward")
                        }
                    }


                    PopMgr.POP_DAILY_ACTIVITY -> {
                        val activityResult: ActivityResult = obj as ActivityResult
                        val url = activityResult.url
                        val bundle = Bundle()
                        bundle.putString("url", url)
                        dialog_Activity.arguments = bundle
                        dialog_Activity.show(supportFragmentManager, "activity")
                    }

                }
            }
        }

        if (Build.VERSION.SDK_INT >= 23) {
            val mPermissionList = arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.ACCESS_WIFI_STATE,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS,
                    Manifest.permission.BLUETOOTH,
                    Manifest.permission.INTERNET,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.REQUEST_INSTALL_PACKAGES,
                    Manifest.permission.CAMERA
            )
            ActivityCompat.requestPermissions(this, mPermissionList, 123)
        }

        bindService(Intent(this@MainActivity, SocketService::class.java), connect, Context.BIND_AUTO_CREATE)

        //Bugly检查升级
        Beta.checkUpgrade(false, true)

    }

    override fun onResume() {
        super.onResume()
//        if (dropDialog) {
//            dropDialog = false;
//            showDisconnectDialog()
//
//        }
//        if (dropNum == 1) {
//            showDisconnectDialog()
//            AccountManager.logout()
//            val logout = MessageLogout(true)
//            EventBus.getDefault().post(logout)
//            dropNum = 0
//        }
    }

    private var connect: ServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            Log.i("mateng", "连接断开")
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.i("mateng", "连接成功")
            // 建立连接
            // 获取服务的操作对象
//            val binder: SocketService.MyBinder = service as SocketService.MyBinder
////            binder.service.reConnect(ConnectRequest(true))// 获取到的Service即MyService

        }
    }

    private fun initViewPager() {
        val fragments = ArrayList<Fragment>()
//        fragments.add(HomeFragment())
        fragments.add(HomeFragment())
        fragments.add(HomeFragment())
        fragments.add(HomeFragment())
        fragments.add(HomeFragment())
        vp_fragment.adapter = FragmentPagerAdapter(supportFragmentManager, fragments)
        vp_fragment.offscreenPageLimit = 4

        for (i in 0 until ll_tab.childCount) {
            ll_tab.getChildAt(i).setOnClickListener {
                if (i == vp_fragment.currentItem) {
                    return@setOnClickListener
                }

                for (i in 0 until ll_tab.childCount) {
                    ll_tab.getChildAt(i).isSelected = false
                }
                it.isSelected = true

                vp_fragment.currentItem = i
            }
        }

        vp_fragment.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (ll_tab.getChildAt(position).isSelected) {
                    return
                }
                for (i in 0 until ll_tab.childCount) {
                    ll_tab.getChildAt(i).isSelected = false
                }
                ll_tab.getChildAt(position).isSelected = true
            }

        })

        vp_fragment.currentItem = 0
        ll_tab.getChildAt(0).isSelected = true
    }

    override fun setActionBarStyle(): ActionBarStyle {
        return ActionBarStyle.NONE
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getRobCoinOpen(result: BaseResult) {


    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)

        Log.d("SocketService", "service关闭")
        unbindService(connect)
        //退出销毁
        PopMgr.getInstance().cleanTask()

        handler?.removeCallbacks(runable)

    }

    //在使用QQ分享或者授权的Activity中,fragment中不能添加以下代码，需要在fragment依赖的Activity中添加
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent != null) {

            if (intent.getSerializableExtra("login") == null) {
                return
            }
            val loginResult = intent.getSerializableExtra("login") as LoginResult
            if (loginResult.isFirstLogin) {
                PopMgr.getInstance().showNewerRegisterPopInfo(loginResult)
            }
        }
    }

    override fun onBackPressed() {
        i++
        if (i % 2 == 0) {
            android.os.Process.killProcess(android.os.Process.myPid())    //获取PID
            System.exit(0);   //常规java、c#的标准退出法，返回值为0代表正常退出
        } else if (i % 2 == 1) {
            showToast(getString(R.string.quit))
        }

        subscriber = object : Subscriber<Int>() {
            override fun onCompleted() {

            }

            override fun onError(e: Throwable) {

            }

            override fun onNext(integer: Int?) {
                if (integer == 0) {
                    i = 0
                }
            }
        }

        RxCountDown.countdown(4).subscribe(subscriber)
    }
}
