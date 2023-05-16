package com.bitcodetech.broadcastdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBr : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent : Intent?) {
        mt(context!!, intent!!.action!!)
        if(intent!!.action!!.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            if(intent!!.getBooleanExtra("state", false)) {
                mt(context, "Airplane mode ON")
            }
            else {
                mt(context, "Airplane mode OFF")
            }
        }
        if(intent!!.action!!.equals(Intent.ACTION_BATTERY_LOW)) {
            mt(context, "Battery LOW")
        }
    }

    private fun mt(context: Context, text : String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}