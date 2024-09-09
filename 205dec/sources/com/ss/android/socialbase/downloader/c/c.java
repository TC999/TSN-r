package com.ss.android.socialbase.downloader.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.socialbase.downloader.gd.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private Application f49302c;
    private final Application.ActivityLifecycleCallbacks ev;

    /* renamed from: f  reason: collision with root package name */
    private volatile int f49303f;

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f49304r;
    private int sr;
    private WeakReference<Activity> ux;

    /* renamed from: w  reason: collision with root package name */
    private xv f49305w;
    private final List<InterfaceC0974c> xv;

    /* renamed from: com.ss.android.socialbase.downloader.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface InterfaceC0974c {
        @MainThread
        void w();

        @MainThread
        void xv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        private static final c f49307c = new c();
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface xv {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f49303f = 0;
        Object[] sr = sr();
        if (sr != null) {
            for (Object obj : sr) {
                ((InterfaceC0974c) obj).xv();
            }
        }
    }

    private boolean r() {
        try {
            Application application = this.f49302c;
            if (application == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
            return TextUtils.equals(application.getPackageName(), f.sr(application));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private Object[] sr() {
        Object[] array;
        synchronized (this.xv) {
            array = this.xv.size() > 0 ? this.xv.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux() {
        this.f49303f = 1;
        Object[] sr = sr();
        if (sr != null) {
            for (Object obj : sr) {
                ((InterfaceC0974c) obj).w();
            }
        }
    }

    private c() {
        this.xv = new ArrayList();
        this.f49303f = -1;
        this.f49304r = false;
        this.ev = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.c.c.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                c.this.f49304r = true;
                if (c.this.sr != 0 || activity == null) {
                    return;
                }
                c.this.sr = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i4 = c.this.sr;
                c.this.f49304r = false;
                c.this.sr = activity != null ? activity.hashCode() : i4;
                if (i4 == 0) {
                    c.this.ux();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                c.this.ux = new WeakReference(activity);
                int i4 = c.this.sr;
                c.this.sr = activity != null ? activity.hashCode() : i4;
                c.this.f49304r = false;
                if (i4 == 0) {
                    c.this.ux();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == c.this.sr) {
                    c.this.sr = 0;
                    c.this.f();
                }
                c.this.f49304r = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    public boolean w() {
        int i4 = this.f49303f;
        int i5 = i4;
        if (i4 == -1) {
            ?? r3 = r();
            this.f49303f = r3;
            i5 = r3;
        }
        return i5 == 1;
    }

    public boolean xv() {
        return w() && !this.f49304r;
    }

    public static c c() {
        return w.f49307c;
    }

    public void w(InterfaceC0974c interfaceC0974c) {
        synchronized (this.xv) {
            this.xv.remove(interfaceC0974c);
        }
    }

    public void c(Context context) {
        if (this.f49302c == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f49302c == null) {
                    Application application = (Application) context;
                    this.f49302c = application;
                    application.registerActivityLifecycleCallbacks(this.ev);
                }
            }
        }
    }

    public void c(xv xvVar) {
        this.f49305w = xvVar;
    }

    public void c(InterfaceC0974c interfaceC0974c) {
        if (interfaceC0974c == null) {
            return;
        }
        synchronized (this.xv) {
            if (!this.xv.contains(interfaceC0974c)) {
                this.xv.add(interfaceC0974c);
            }
        }
    }
}
