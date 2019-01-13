package com.niceapp.utils

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

object RxCountDown {

    fun countdown(timer: Int): Observable<Int> {

        var time = timer
        if (time < 0) time = 0
        val countTime = time
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .map { increaseTime -> countTime - increaseTime!!.toInt() }
                .take(countTime + 1)

    }

    fun countdown(timer: Long): Observable<Long> {

        var time = timer
        if (time < 0) time = 0
        val countTime = time
        return Observable.interval(0, 1, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .map { increaseTime -> countTime - increaseTime!!.toInt() }
                .take(countTime.toInt() + 1)

    }

    fun countdown(timer: Int, unit: TimeUnit): Observable<Int> {

        var time = timer
        if (time < 0) time = 0
        val countTime = time
        return Observable.interval(0, 1, unit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .map { increaseTime -> countTime - increaseTime!!.toInt() }
                .take(countTime + 1)

    }

}