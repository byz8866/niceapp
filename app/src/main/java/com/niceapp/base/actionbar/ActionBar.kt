package com.niceapp.base.actionbar

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import android.util.TypedValue.COMPLEX_UNIT_SP
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.cheddd.nqd.base.actionbar.ActionBarStyle
import com.niceapp.R
import kotlinx.android.synthetic.main.view_actionbar.view.*

/**
 * Created by mateng on 2018/3/1.
 * 通用ActionBar
 */
class ActionBar(context: Context?) : LinearLayout(context) {

    fun setRightIv(@DrawableRes res: Int) {
        iv_right.setImageResource(res)
    }

    fun setLeftIv(@DrawableRes res: Int) {
        iv_left.setImageResource(res)
    }

    fun setTitle(@StringRes res: Int) {
        tv_title.setText(res)
    }

    fun setTitleSize(@FloatRange float: Float) {
        tv_title.setTextSize(COMPLEX_UNIT_SP, float)
    }

    fun setTitleColor(@ColorInt int: Int) {
        tv_title.setTextColor(int)
    }


    fun setRightTv(@StringRes res: Int) {
        tv_right.setText(res)
    }

    @SuppressLint("ResourceAsColor")
    fun setBackground(@ColorRes res: Int) {
//        framelayout_title.setBackgroundColor(res)
        framelayout_title.setBackgroundResource(res)
    }


    private val activity: Activity = context as Activity

    private fun initView() {

        orientation = VERTICAL

        val statusView = StatusView(context)
        statusView.id = R.id.status_view
        statusView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_0000))
        statusView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        addView(statusView)

        LayoutInflater.from(context).inflate(R.layout.view_actionbar, this, true)
    }

    var title: CharSequence? = null
        set(value) {
            tv_title.text = value
        }

    var titleColor: Int? = null
        set(value) {
            if (value != null) {
                tv_title.setTextColor(value)
            }
        }

    var leftImageVisible: Boolean? = null
        set(value) {
            if (value == true) {
                iv_left.visibility = View.VISIBLE
            } else if (value == false) {
                iv_left.visibility = View.INVISIBLE
            }

        }

    var style: ActionBarStyle? = null
        set(style) {
            when (style) {
                ActionBarStyle.NONE -> {
                    visibility = View.GONE
                }
                ActionBarStyle.GENERIC_BAR -> {
                    iv_left?.visibility = View.GONE
                    dividing_line.visibility = View.VISIBLE
                }
                ActionBarStyle.GENERIC_BAR_NOT_DIVIDING -> {
                    iv_left?.visibility = View.GONE
                    dividing_line.visibility = View.GONE
                }
                ActionBarStyle.GENERIC_BACK_BAR -> {
                    iv_left.setImageResource(R.mipmap.ic_light_back)
                    dividing_line.visibility = View.VISIBLE
                    iv_left.setOnClickListener { activity.finish() }
                }
                ActionBarStyle.GENERIC_BACK_BAR_NOT_DIVIDING -> {
                    iv_left.setImageResource(R.mipmap.ic_light_back)
                    dividing_line.visibility = View.GONE
                    iv_left.setOnClickListener { activity.finish() }
                }
            }
            setBackgroundColor(ContextCompat.getColor(context, R.color.color_0000))
        }

    init {
        initView()
    }

}
