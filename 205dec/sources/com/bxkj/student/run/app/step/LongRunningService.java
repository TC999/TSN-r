package com.bxkj.student.run.app.step;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LongRunningService extends Service {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements Runnable {
        a() {
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
        new Thread(new a()).start();
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
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
