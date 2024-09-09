package com.iab.omid.library.mmadbridge.b;

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
import com.iab.omid.library.mmadbridge.adsession.h;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b implements Application.ActivityLifecycleCallbacks {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static b f37711d = new b();

    /* renamed from: a  reason: collision with root package name */
    private boolean f37712a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f37713b;

    /* renamed from: c  reason: collision with root package name */
    private a f37714c;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(boolean z3);
    }

    private b() {
    }

    public static b a() {
        return f37711d;
    }

    private void d(boolean z3) {
        if (this.f37713b != z3) {
            this.f37713b = z3;
            if (this.f37712a) {
                h();
                a aVar = this.f37714c;
                if (aVar != null) {
                    aVar.a(!z3);
                }
            }
        }
    }

    private void h() {
        boolean z3 = !this.f37713b;
        for (h hVar : com.iab.omid.library.mmadbridge.b.a.a().c()) {
            hVar.f().n(z3);
        }
    }

    public void b(@NonNull Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public void c(a aVar) {
        this.f37714c = aVar;
    }

    public void e() {
        this.f37712a = true;
        this.f37713b = false;
        h();
    }

    public void f() {
        this.f37712a = false;
        this.f37713b = false;
        this.f37714c = null;
    }

    @RequiresApi(api = 16)
    @VisibleForTesting
    ActivityManager.RunningAppProcessInfo g() {
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
        d(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        View w3;
        boolean z3 = true;
        boolean z4 = g().importance != 100;
        boolean z5 = true;
        for (h hVar : com.iab.omid.library.mmadbridge.b.a.a().e()) {
            if (hVar.x() && (w3 = hVar.w()) != null && w3.hasWindowFocus()) {
                z5 = false;
            }
        }
        d((z4 && z5) ? false : false);
    }
}
