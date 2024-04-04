package edu.temple.startserviceinclassactivity

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.util.Log

const val COUNTDOWN_START_VALUE = "countdownValue"
class CountdownService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.run{
            val from = getIntExtra(COUNTDOWN_START_VALUE,0)
            CoroutineScope(Dispatchers.IO).launch{
                repeat(from){
                    Log.d("Countdown",(from-it).toString())
                    delay(1000)
                }
            }
        }


        return super.onStartCommand(intent, flags, startId)
    }
}