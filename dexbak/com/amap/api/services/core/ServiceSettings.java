package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.p047s.AuthManager;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.col.p047s.C2048e1;
import com.amap.api.col.p047s.C2077i4;
import com.amap.api.col.p047s.C2082j4;
import com.amap.api.col.p047s.ThreadPoolExecutorUtil;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;

    /* renamed from: c */
    private static ServiceSettings f7315c;

    /* renamed from: a */
    private String f7316a = "zh-CN";

    /* renamed from: b */
    private int f7317b = 1;

    /* renamed from: d */
    private int f7318d = 20000;

    /* renamed from: e */
    private int f7319e = 20000;

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (f7315c == null) {
            f7315c = new ServiceSettings();
        }
        return f7315c;
    }

    public static synchronized void updatePrivacyAgree(Context context, boolean z) {
        synchronized (ServiceSettings.class) {
            C2033cf.m53119i(context, z, C2077i4.m52895a(false));
        }
    }

    public static synchronized void updatePrivacyShow(Context context, boolean z, boolean z2) {
        synchronized (ServiceSettings.class) {
            C2033cf.m53118j(context, z, z2, C2077i4.m52895a(false));
        }
    }

    public void destroyInnerAsynThreadPool() {
        try {
            ThreadPoolExecutorUtil.m52253c();
        } catch (Throwable th) {
            C2082j4.m52825i(th, "ServiceSettings", "destroyInnerAsynThreadPool");
        }
    }

    public int getConnectionTimeOut() {
        return this.f7318d;
    }

    public String getLanguage() {
        return this.f7316a;
    }

    public int getProtocol() {
        return this.f7317b;
    }

    public int getSoTimeOut() {
        return this.f7319e;
    }

    public void setApiKey(String str) {
        AuthManager.m52179a(str);
    }

    public void setConnectionTimeOut(int i) {
        if (i < 5000) {
            this.f7318d = 5000;
        } else if (i > 30000) {
            this.f7318d = 30000;
        } else {
            this.f7318d = i;
        }
    }

    public void setLanguage(String str) {
        this.f7316a = str;
    }

    public void setProtocol(int i) {
        this.f7317b = i;
        C2048e1.m53039a().m53035e(this.f7317b == 2);
    }

    public void setSoTimeOut(int i) {
        if (i < 5000) {
            this.f7319e = 5000;
        } else if (i > 30000) {
            this.f7319e = 30000;
        } else {
            this.f7319e = i;
        }
    }
}
