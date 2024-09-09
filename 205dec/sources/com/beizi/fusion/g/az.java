package com.beizi.fusion.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;

/* compiled from: WebViewMultiInitHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class az {
    public static void a(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    try {
                        int myPid = Process.myPid();
                        String str = context.getPackageName() + myPid;
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                            if (runningAppProcessInfo.pid == myPid) {
                                str = runningAppProcessInfo.processName;
                            }
                        }
                        WebView.setDataDirectorySuffix(str);
                    } catch (Exception unused) {
                        WebView.setDataDirectorySuffix(packageName);
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }
}
