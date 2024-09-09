package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.bytedance.pangle.annotations.ForbidWrapParam;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c  reason: collision with root package name */
    private static volatile w f30025c;

    /* renamed from: w  reason: collision with root package name */
    private final xv f30026w;

    private w(Application application) {
        this.f30026w = xv.c(application);
    }

    public static w c(Application application) {
        if (f30025c == null) {
            synchronized (w.class) {
                if (f30025c == null) {
                    f30025c = new w(application);
                    application.registerActivityLifecycleCallbacks(f30025c);
                }
            }
        }
        return f30025c;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@ForbidWrapParam Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@ForbidWrapParam Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@ForbidWrapParam Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT < 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        c.c(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT >= 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        c.c(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@ForbidWrapParam Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@ForbidWrapParam Activity activity) {
        xv xvVar = this.f30026w;
        if (xvVar != null) {
            xvVar.c(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@ForbidWrapParam Activity activity) {
        xv xvVar = this.f30026w;
        if (xvVar != null) {
            xvVar.w(activity);
        }
    }

    public String c(String str, long j4, int i4, boolean z3) {
        xv xvVar = this.f30026w;
        if (xvVar != null) {
            return xvVar.c(str, j4, i4, z3);
        }
        return null;
    }
}
