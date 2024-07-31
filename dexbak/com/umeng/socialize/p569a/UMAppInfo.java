package com.umeng.socialize.p569a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* renamed from: com.umeng.socialize.a.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class UMAppInfo {

    /* renamed from: a */
    final String f39308a;

    /* renamed from: b */
    final String f39309b;

    /* renamed from: c */
    final String f39310c;

    /* renamed from: d */
    final long f39311d;

    /* renamed from: e */
    final long f39312e;

    /* renamed from: f */
    final int f39313f;

    public UMAppInfo(Object obj, Object obj2) {
        String str;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f39308a = packageInfo.packageName;
        this.f39310c = packageInfo.versionName;
        this.f39311d = packageInfo.firstInstallTime;
        this.f39312e = packageInfo.lastUpdateTime;
        this.f39313f = m13390a(packageInfo);
        try {
            str = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            str = "";
        }
        this.f39309b = str;
    }

    /* renamed from: a */
    private int m13390a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        int i = applicationInfo.flags;
        return ((i & 1) == 0 && (i & 128) == 0) ? 1 : 0;
    }
}
