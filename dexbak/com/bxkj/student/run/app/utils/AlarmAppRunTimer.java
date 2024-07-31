package com.bxkj.student.run.app.utils;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.bxkj.student.run.app.location.service.LocationService;

/* renamed from: com.bxkj.student.run.app.utils.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AlarmAppRunTimer {

    /* renamed from: a */
    private final long f19562a = 5000;

    /* renamed from: b */
    private Context f19563b;

    /* renamed from: c */
    private AlarmManager f19564c;

    /* renamed from: d */
    private PendingIntent f19565d;

    public AlarmAppRunTimer(Context aContext) {
        this.f19563b = aContext;
        this.f19564c = (AlarmManager) aContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(aContext, LocationService.class);
        intent.setAction("REQUEST_LOCATION");
        intent.putExtra("msg", "心跳包");
        this.f19565d = PendingIntent.getService(this.f19563b, 0, intent, 0);
    }

    /* renamed from: a */
    public void m39676a() {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = this.f19564c;
        if (alarmManager == null || (pendingIntent = this.f19565d) == null) {
            return;
        }
        alarmManager.cancel(pendingIntent);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void m39675b() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            this.f19564c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f19565d);
        } else if (i >= 19) {
            this.f19564c.setExact(0, System.currentTimeMillis() + 5000, this.f19565d);
        } else {
            this.f19564c.set(0, System.currentTimeMillis() + 5000, this.f19565d);
        }
    }
}
