package com.bytedance.embedapplog;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c  reason: collision with root package name */
    private static int f26750c = 0;
    private static int ev = -1;

    /* renamed from: f  reason: collision with root package name */
    private static long f26751f;
    private static Object gd;

    /* renamed from: k  reason: collision with root package name */
    private static final HashSet<Integer> f26752k = new HashSet<>(8);

    /* renamed from: r  reason: collision with root package name */
    private static String f26753r;
    private static long sr;
    private static String ux;

    /* renamed from: w  reason: collision with root package name */
    private static wo f26754w;
    private static wo xv;

    /* renamed from: p  reason: collision with root package name */
    private final IPicker f26755p;

    public k(IPicker iPicker) {
        this.f26755p = iPicker;
    }

    public static wo c(String str, String str2, long j4, String str3) {
        wo woVar = new wo();
        if (!TextUtils.isEmpty(str2)) {
            woVar.f26834t = str + ":" + str2;
        } else {
            woVar.f26834t = str;
        }
        woVar.f26814w = j4;
        woVar.f26832a = -1L;
        if (str3 == null) {
            str3 = "";
        }
        woVar.bk = str3;
        ys.c(woVar);
        return woVar;
    }

    public static void c(Object obj) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        f26752k.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        f26752k.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (xv != null) {
            c(gd);
        }
        wo woVar = f26754w;
        if (woVar != null) {
            ux = woVar.f26834t;
            long currentTimeMillis = System.currentTimeMillis();
            sr = currentTimeMillis;
            c(f26754w, currentTimeMillis);
            f26754w = null;
            if (activity.isChild()) {
                return;
            }
            ev = -1;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        wo c4 = c(activity.getClass().getName(), "", System.currentTimeMillis(), ux);
        f26754w = c4;
        c4.fz = !f26752k.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        try {
            ev = activity.getWindow().getDecorView().hashCode();
        } catch (Exception e4) {
            be.w(e4);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        IPicker iPicker;
        int i4 = f26750c + 1;
        f26750c = i4;
        if (i4 != 1 || (iPicker = this.f26755p) == null) {
            return;
        }
        iPicker.show(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (ux != null) {
            int i4 = f26750c - 1;
            f26750c = i4;
            if (i4 <= 0) {
                ux = null;
                f26753r = null;
                f26751f = 0L;
                sr = 0L;
                IPicker iPicker = this.f26755p;
                if (iPicker != null) {
                    iPicker.show(false);
                }
            }
        }
    }

    public static wo c(wo woVar, long j4) {
        wo woVar2 = (wo) woVar.clone();
        woVar2.f26814w = j4;
        long j5 = j4 - woVar.f26814w;
        if (j5 >= 0) {
            woVar2.f26832a = j5;
        } else {
            be.w((Throwable) null);
        }
        ys.c(woVar2);
        return woVar2;
    }
}
