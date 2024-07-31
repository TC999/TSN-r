package com.snail.antifake.deviceid;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.Thread;

/* compiled from: CrashHandler.java */
/* renamed from: com.snail.antifake.deviceid.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11942c implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Application f33798a;

    public C11942c(Application application) {
        this.f33798a = application;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Process.killProcess(Process.myPid());
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) this.f33798a.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                if (this.f33798a.getPackageName().equals(runningAppProcessInfo.processName)) {
                    return;
                }
                Process.killProcess(Process.myPid());
                return;
            }
        }
    }
}
