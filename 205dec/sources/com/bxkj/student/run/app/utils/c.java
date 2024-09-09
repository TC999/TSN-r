package com.bxkj.student.run.app.utils;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AlarmManagerUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final long f22797a = 5000;

    /* renamed from: b  reason: collision with root package name */
    private Context f22798b;

    /* renamed from: c  reason: collision with root package name */
    public AlarmManager f22799c;

    /* renamed from: d  reason: collision with root package name */
    public PendingIntent f22800d;

    public c(Context aContext) {
        this.f22798b = aContext;
        this.f22799c = (AlarmManager) aContext.getSystemService("alarm");
        Intent intent = new Intent("WANG_LEI");
        intent.putExtra("msg", "\u8d76\u7d27\u8d77\u5e8a");
        this.f22800d = PendingIntent.getBroadcast(this.f22798b, 0, intent, 0);
    }

    public void a() {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = this.f22799c;
        if (alarmManager == null || (pendingIntent = this.f22800d) == null) {
            return;
        }
        alarmManager.cancel(pendingIntent);
    }

    @SuppressLint({"NewApi"})
    public void b() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            this.f22799c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f22800d);
        } else if (i4 >= 19) {
            this.f22799c.setExact(0, System.currentTimeMillis() + 5000, this.f22800d);
        } else {
            this.f22799c.set(0, System.currentTimeMillis() + 5000, this.f22800d);
        }
    }

    @SuppressLint({"NewApi"})
    public void c() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            this.f22799c.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 5000, this.f22800d);
        } else if (i4 >= 19) {
            this.f22799c.setExact(0, System.currentTimeMillis() + 5000, this.f22800d);
        } else {
            this.f22799c.set(0, System.currentTimeMillis() + 5000, this.f22800d);
        }
    }
}
