package com.bxkj.student.run.app.step;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.util.Date;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LongRunningService extends Service {

    /* renamed from: com.bxkj.student.run.app.step.LongRunningService$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC5360a implements Runnable {
        RunnableC5360a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d("LongRunningService", "executed at " + new Date().toString());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new RunnableC5360a()).start();
        AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
        long elapsedRealtime = SystemClock.elapsedRealtime() + 1000;
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, new Intent(this, AlarmReceiver.class), 0);
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(2, elapsedRealtime, broadcast);
        } else {
            alarmManager.set(2, elapsedRealtime, broadcast);
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
