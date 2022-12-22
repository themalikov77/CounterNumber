package com.example.counternumber

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.counternumber.databinding.ActivityMainBinding
import com.example.counternumber.presenter.Presenter
import com.example.counternumber.view.CounterView

class MainActivity : AppCompatActivity(),CounterView {
    private lateinit var binding: ActivityMainBinding
    var presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnPlus.setOnClickListener {
                presenter.increment()

            }
            btnMinus.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun changeCount(count:Int) {
        binding.counterTv.text = count.toString()
    }

    override fun showToast() {

            Toast.makeText(this, "Поздравляю", Toast.LENGTH_SHORT).show()

    }

    override fun color(color: Int) {
        binding.counterTv.setTextColor(color)
    }
}