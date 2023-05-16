package com.bitcodetech.broadcastdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bitcodetech.broadcastdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var br : BroadcastReceiver
    private lateinit var binding : ActivityMainBinding

    private val downloadBr = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, intent: Intent?) {
            mt("Path: ${intent!!.getStringExtra("path")}")
        }
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        br = MyBr()
        val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        filter.addAction(Intent.ACTION_BATTERY_LOW)

        registerReceiver(br, filter)
        //registerReceiver(downloadBr, IntentFilter("in.bitcode.download.COMPLETE"))

        binding.btnRegister.setOnClickListener {
            registerReceiver(downloadBr, IntentFilter("in.bitcode.download.COMPLETE"))
        }

        binding.btnUnRegister.setOnClickListener {
            unregisterReceiver(downloadBr)
        }
    }

    override fun onDestroy() {
        unregisterReceiver(br)
        //unregisterReceiver(downloadBr)
        super.onDestroy()
    }
}