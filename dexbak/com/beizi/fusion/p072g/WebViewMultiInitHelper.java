package com.beizi.fusion.p072g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* renamed from: com.beizi.fusion.g.ay */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class WebViewMultiInitHelper {
    /* renamed from: a */
    public static void m48279a(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    try {
                        int myPid = Process.myPid();
                        String str = context.getPackageName() + myPid;
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
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
