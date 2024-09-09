package com.bxkj.student.run.app.utils;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.bxkj.student.run.app.location.service.LocationService;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AlarmAppRunTimer.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final long f22792a = 5000;

    /* renamed from: b  reason: collision with root package name */
    private Context f22793b;

    /* renamed from: c  reason: collision with root package name */
    private AlarmManager f22794c;

    /* renamed from: d  reason: collision with root package name */
    private PendingIntent f22795d;

    public b(Context aContext) {
        this.f22793b = aContext;
        this.f22794c = (AlarmManager) aContext.getSystemService("alarm");
        Intent intent = new Intent(aContext, LocationService.class);
        intent.setAction("REQUEST_LOCATION");
        intent.putExtra("msg", "\u5fc3\u8df3\u5305");
        this.f22795d = PendingIntent.getService(this.f22793b, 0, intent, 0);
    }

    public void a() {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = this.f22794c;
        if (alarmManager == null || (pendingIntent = this.f22795d) == null) {
            return;
        }
        alarmManager.cancel(pendingIntent);
    }

    @SuppressLint({"NewApi"})
    public void b() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            this.f22794c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f22795d);
        } else if (i4 >= 19) {
            this.f22794c.setExact(0, System.currentTimeMillis() + 5000, this.f22795d);
        } else {
            this.f22794c.set(0, System.currentTimeMillis() + 5000, this.f22795d);
        }
    }
}
