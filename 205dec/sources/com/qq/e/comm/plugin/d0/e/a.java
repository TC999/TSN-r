package com.qq.e.comm.plugin.d0.e;

import android.content.Context;
import android.content.pm.PackageInfo;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f42259a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f42260b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42261c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42262d;

    /* renamed from: e  reason: collision with root package name */
    private String f42263e;

    /* renamed from: f  reason: collision with root package name */
    private String f42264f;

    public a(String str, Context context, String str2) {
        this.f42259a = str;
        this.f42260b = context;
        this.f42261c = str2;
        this.f42262d = context.getPackageName();
        f();
    }

    private void f() {
        try {
            PackageInfo packageInfo = this.f42260b.getPackageManager().getPackageInfo(this.f42262d, 0);
            this.f42263e = packageInfo.versionName;
            this.f42264f = packageInfo.applicationInfo.loadLabel(this.f42260b.getPackageManager()).toString();
        } catch (Exception unused) {
        }
    }

    public String a() {
        return this.f42259a;
    }

    public String b() {
        return this.f42262d;
    }

    public String c() {
        return this.f42264f;
    }

    public String d() {
        return this.f42263e;
    }

    public String e() {
        return this.f42261c;
    }
}
