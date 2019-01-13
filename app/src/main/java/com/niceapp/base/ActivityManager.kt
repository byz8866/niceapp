package com.niceapp.base


import android.app.Activity
import java.util.*

class ActivityManager private constructor() {

    val mActivityStack: Stack<Activity> = Stack()


    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {

        mActivityStack.push(activity)
    }

    fun hasActivity(cls: Class<*>): Boolean = mActivityStack!!.any { null != it && it.javaClass == cls }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity? {
        var activity: Activity? = null
        try {
            activity = mActivityStack.lastElement()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return activity
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishCurrentActivity() {
        var activity: Activity? = null
        try {
            activity = mActivityStack.lastElement()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        finishActivity(activity)
    }

    /**
     * 结束指定的Activity
     */

    fun finishActivity(activity: Activity?) {
        if (activity != null) {
            mActivityStack.remove(activity)
            activity.finish()
        }
    }

    fun removeActivity(activity: Activity?) {
        if (activity != null) {
            mActivityStack.remove(activity)
        }
    }


    fun isTopActivity(clz: Class<*>): Boolean {
        var result = false
        val activity = currentActivity() ?: return result
        if (activity.javaClass == clz) {
            result = true
        }
        return result
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        val deleteActivityStack = Stack<Activity>()
        for (activity in mActivityStack) {

            if (null != activity && activity.javaClass == cls) {
                deleteActivityStack.add(activity)
            }
        }

        mActivityStack.removeAll(deleteActivityStack)
        for (activity in deleteActivityStack) {
            activity?.finish()
        }
    }

    /**
     * 结束所有Activity
     */
    private fun finishAllActivity() {
        var i = 0
        val size = mActivityStack.size
        while (i < size) {
            if (null != mActivityStack!![i]) {
                mActivityStack!![i].finish()
            }
            i++
        }
        mActivityStack!!.clear()
    }

    /**
     * 结束除指定activity以外的所有activity
     *
     * @param clazz
     */
    fun finishAllActivityWithOutThis(clazz: Class<*>) {
        var activity: Activity? = null
        var i = 0
        val size = mActivityStack.size
        while (i < size) {
            val current = mActivityStack!![i]
            if (current != null && current.javaClass.simpleName != clazz.simpleName) {
                mActivityStack!![i].finish()
            } else {
                activity = current
            }
            i++
        }
        mActivityStack.clear()
        mActivityStack.add(activity)
    }


    /**
     * 退出应用程序
     */
    fun AppExit() {
        try {
            finishAllActivity()
            android.os.Process.killProcess(android.os.Process.myPid())
            System.exit(0)
        } catch (e: Exception) {

        }

    }

    /**
     * 创建唯一单例
     */
    companion object {
        val instance: ActivityManager
            get() {
                return Inner.activityManager
            }
    }

    private object Inner {
        val activityManager = ActivityManager()
    }

}