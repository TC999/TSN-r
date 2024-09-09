package com.umeng.socialize.a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMAppInfo.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    final String f53897a;

    /* renamed from: b  reason: collision with root package name */
    final String f53898b;

    /* renamed from: c  reason: collision with root package name */
    final String f53899c;

    /* renamed from: d  reason: collision with root package name */
    final long f53900d;

    /* renamed from: e  reason: collision with root package name */
    final long f53901e;

    /* renamed from: f  reason: collision with root package name */
    final int f53902f;

    public f(Object obj, Object obj2) {
        String str;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f53897a = packageInfo.packageName;
        this.f53899c = packageInfo.versionName;
        this.f53900d = packageInfo.firstInstallTime;
        this.f53901e = packageInfo.lastUpdateTime;
        this.f53902f = a(packageInfo);
        try {
            str = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            str = "";
        }
        this.f53898b = str;
    }

    private int a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        int i4 = applicationInfo.flags;
        return ((i4 & 1) == 0 && (i4 & 128) == 0) ? 1 : 0;
    }
}
