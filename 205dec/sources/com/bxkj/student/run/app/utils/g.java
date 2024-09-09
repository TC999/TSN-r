package com.bxkj.student.run.app.utils;

import android.app.Activity;
import android.os.PowerManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CpuWakeLock.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private PowerManager.WakeLock f22814a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f22815b = false;

    public boolean a() {
        return this.f22815b;
    }

    public synchronized boolean b(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (activity.isDestroyed()) {
            return false;
        }
        PowerManager powerManager = (PowerManager) activity.getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870913, "CpuWakeLock");
            this.f22814a = newWakeLock;
            newWakeLock.acquire();
            this.f22815b = true;
            return true;
        }
        return false;
    }

    public synchronized void c() {
        PowerManager.WakeLock wakeLock = this.f22814a;
        if (wakeLock != null) {
            wakeLock.release();
            this.f22814a = null;
            this.f22815b = false;
        }
    }
}
