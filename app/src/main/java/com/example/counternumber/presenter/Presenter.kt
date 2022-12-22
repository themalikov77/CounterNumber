package com.example.counternumber.presenter

import android.graphics.Color
import com.example.counternumber.model.CounterModel
import com.example.counternumber.view.CounterView

class Presenter {
    val model = CounterModel()
    lateinit var view: CounterView
    fun increment() {
        model.increment()
        view.changeCount(model.count)
        if (model.count == 10) {
            view.showToast()
        }
        if (model.count == 15){
            view.color(Color.GREEN)
        }else view.color(Color.BLACK)
    }

    fun decrement() {
        model.decrement()
        view.changeCount(model.count)
        if (model.count == 10) {
            view.showToast()
        }
        if (model.count != 15){
            view.color(Color.BLACK)
        }else view.color(Color.GREEN)
    }

    fun attachView(view: CounterView) {
        this.view = view
    }


}