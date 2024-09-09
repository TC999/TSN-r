package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class zr {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f26862c;

        /* renamed from: w  reason: collision with root package name */
        private final String f26863w;
        private final String xv = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        c(Runnable runnable, String str) {
            this.f26862c = runnable;
            this.f26863w = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f26862c.run();
            } catch (Exception e4) {
                be.xv("Thread:" + this.f26863w + " exception\n" + this.xv, e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.d("HWOAID", "getPackageInfo NameNotFoundException");
            return false;
        } catch (Exception unused2) {
            Log.d("HWOAID", "getPackageInfo Exception");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(@Nullable String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new com.bytedance.sdk.component.gd.sr.xv(new c(runnable, str), str).start();
    }
}
