package com.snail.antifake.deviceid;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import java.lang.Thread;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: CrashHandler.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Application f48132a;

    public c(Application application) {
        this.f48132a = application;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Process.killProcess(Process.myPid());
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) this.f48132a.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                if (this.f48132a.getPackageName().equals(runningAppProcessInfo.processName)) {
                    return;
                }
                Process.killProcess(Process.myPid());
                return;
            }
        }
    }
}
