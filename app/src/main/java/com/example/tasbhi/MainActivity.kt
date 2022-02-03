package com.example.tasbhi

import android.content.Context
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import com.example.tasbhi.databinding.ActivityMainBinding
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {
    private var count by Delegates.notNull<Int>()
    private lateinit var binding:ActivityMainBinding
    private var totalMala=0
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener {
            val vibe = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            val effect = VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE)
            vibe.vibrate(effect)

            clicked()
            setCount()
        }
        binding.tvClear.setOnClickListener {
        count=0
            setCount()
        }
    }
    override fun onResume(){
        super.onResume()
        count= SharedPreferences(this).getCount()!!.toInt()
        totalMala= SharedPreferences(this).getTotalCount()!!.toInt()
        setCount()
    }
    override fun onPause(){
            super.onPause()
           SharedPreferences(this).saveCount(binding.textView.text.toString())
           SharedPreferences(this).saveTotalCount(binding.tvTotalMala.text.toString())
    }
    private fun clicked(){
    if(count == 108){
        totalMala++
        count=0
        binding.tvTotalMala.isVisible=true
        binding.tvTotalMala.text=totalMala.toString()
        binding.tv108.isVisible=true
    }
        count++
}
    private fun setCount(){
        binding.textView.text= count.toString()
        binding.tvTotalMala.text=totalMala.toString()
    }
}