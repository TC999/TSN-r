package com.iab.omid.library.mmadbridge.p202b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.mmadbridge.adsession.C7081h;

/* renamed from: com.iab.omid.library.mmadbridge.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7086b implements Application.ActivityLifecycleCallbacks {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d */
    private static C7086b f24229d = new C7086b();

    /* renamed from: a */
    private boolean f24230a;

    /* renamed from: b */
    private boolean f24231b;

    /* renamed from: c */
    private InterfaceC7087a f24232c;

    /* renamed from: com.iab.omid.library.mmadbridge.b.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7087a {
        /* renamed from: a */
        void mo34718a(boolean z);
    }

    private C7086b() {
    }

    /* renamed from: a */
    public static C7086b m34750a() {
        return f24229d;
    }

    /* renamed from: d */
    private void m34747d(boolean z) {
        if (this.f24231b != z) {
            this.f24231b = z;
            if (this.f24230a) {
                m34743h();
                InterfaceC7087a interfaceC7087a = this.f24232c;
                if (interfaceC7087a != null) {
                    interfaceC7087a.mo34718a(!z);
                }
            }
        }
    }

    /* renamed from: h */
    private void m34743h() {
        boolean z = !this.f24231b;
        for (C7081h c7081h : C7085a.m34757a().m34755c()) {
            c7081h.mo34802f().m34639n(z);
        }
    }

    /* renamed from: b */
    public void m34749b(@NonNull Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    /* renamed from: c */
    public void m34748c(InterfaceC7087a interfaceC7087a) {
        this.f24232c = interfaceC7087a;
    }

    /* renamed from: e */
    public void m34746e() {
        this.f24230a = true;
        this.f24231b = false;
        m34743h();
    }

    /* renamed from: f */
    public void m34745f() {
        this.f24230a = false;
        this.f24231b = false;
        this.f24232c = null;
    }

    @RequiresApi(api = 16)
    @VisibleForTesting
    /* renamed from: g */
    ActivityManager.RunningAppProcessInfo m34744g() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        m34747d(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        View m34785w;
        boolean z = true;
        boolean z2 = m34744g().importance != 100;
        boolean z3 = true;
        for (C7081h c7081h : C7085a.m34757a().m34753e()) {
            if (c7081h.m34784x() && (m34785w = c7081h.m34785w()) != null && m34785w.hasWindowFocus()) {
                z3 = false;
            }
        }
        m34747d((z2 && z3) ? false : false);
    }
}
