package com.bxkj.student.run.app.utils;

import android.app.Activity;
import android.os.PowerManager;

/* renamed from: com.bxkj.student.run.app.utils.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CpuWakeLock {

    /* renamed from: a */
    private PowerManager.WakeLock f19584a = null;

    /* renamed from: b */
    private boolean f19585b = false;

    /* renamed from: a */
    public boolean m39643a() {
        return this.f19585b;
    }

    /* renamed from: b */
    public synchronized boolean m39642b(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (activity.isDestroyed()) {
            return false;
        }
        PowerManager powerManager = (PowerManager) activity.getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870913, "CpuWakeLock");
            this.f19584a = newWakeLock;
            newWakeLock.acquire();
            this.f19585b = true;
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public synchronized void m39641c() {
        PowerManager.WakeLock wakeLock = this.f19584a;
        if (wakeLock != null) {
            wakeLock.release();
            this.f19584a = null;
            this.f19585b = false;
        }
    }
}
