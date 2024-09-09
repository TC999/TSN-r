package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.e1;
import com.amap.api.col.s.i4;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.y;
import com.amap.api.col.s.z0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;

    /* renamed from: c  reason: collision with root package name */
    private static ServiceSettings f11009c;

    /* renamed from: a  reason: collision with root package name */
    private String f11010a = "zh-CN";

    /* renamed from: b  reason: collision with root package name */
    private int f11011b = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f11012d = 20000;

    /* renamed from: e  reason: collision with root package name */
    private int f11013e = 20000;

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (f11009c == null) {
            f11009c = new ServiceSettings();
        }
        return f11009c;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z3) {
        synchronized (ServiceSettings.class) {
            cf.i(context, z3, i4.a(false));
        }
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z3, boolean z4) {
        synchronized (ServiceSettings.class) {
            cf.j(context, z3, z4, i4.a(false));
        }
    }

    public void destroyInnerAsynThreadPool() {
        try {
            y.c();
        } catch (Throwable th) {
            j4.i(th, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }

    public int getConnectionTimeOut() {
        return this.f11012d;
    }

    public String getLanguage() {
        return this.f11010a;
    }

    public int getProtocol() {
        return this.f11011b;
    }

    public int getSoTimeOut() {
        return this.f11013e;
    }

    public void setApiKey(String str) {
        z0.a(str);
    }

    public void setConnectionTimeOut(int i4) {
        if (i4 < 5000) {
            this.f11012d = 5000;
        } else if (i4 > 30000) {
            this.f11012d = 30000;
        } else {
            this.f11012d = i4;
        }
    }

    public void setLanguage(String str) {
        this.f11010a = str;
    }

    public void setProtocol(int i4) {
        this.f11011b = i4;
        e1.a().e(this.f11011b == 2);
    }

    public void setSoTimeOut(int i4) {
        if (i4 < 5000) {
            this.f11013e = 5000;
        } else if (i4 > 30000) {
            this.f11013e = 30000;
        } else {
            this.f11013e = i4;
        }
    }
}
