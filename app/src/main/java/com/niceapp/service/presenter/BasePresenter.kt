package com.niceapp.service.presenter

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by mateng on 2018/1/26.
 */
open class BasePresenter {

    private val mAllSubscription = CompositeSubscription()

    fun registerSubscription(subscription: Subscription) {
        mAllSubscription.add(subscription)
    }

    fun unregisterSubscription(subscription: Subscription) {
        mAllSubscription.remove(subscription)
    }

    private fun clearSubscription() {
        mAllSubscription.clear()
    }

    fun recycler() {
        clearSubscription()
    }
}