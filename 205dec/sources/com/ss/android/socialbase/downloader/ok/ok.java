package com.ss.android.socialbase.downloader.ok;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.socialbase.downloader.q.kf;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok {

    /* renamed from: a  reason: collision with root package name */
    private bl f50101a;
    private final List<InterfaceC1022ok> bl;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f50102h;
    private volatile int kf;

    /* renamed from: n  reason: collision with root package name */
    private WeakReference<Activity> f50103n;
    private Application ok;

    /* renamed from: p  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f50104p;

    /* renamed from: s  reason: collision with root package name */
    private int f50105s;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {
        private static final ok ok = new ok();
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface bl {
    }

    /* renamed from: com.ss.android.socialbase.downloader.ok.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface InterfaceC1022ok {
        @MainThread
        void a();

        @MainThread
        void bl();
    }

    private boolean h() {
        try {
            Application application = this.ok;
            if (application == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
            return TextUtils.equals(application.getPackageName(), kf.s(application));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf() {
        this.kf = 0;
        Object[] s3 = s();
        if (s3 != null) {
            for (Object obj : s3) {
                ((InterfaceC1022ok) obj).bl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.kf = 1;
        Object[] s3 = s();
        if (s3 != null) {
            for (Object obj : s3) {
                ((InterfaceC1022ok) obj).a();
            }
        }
    }

    private Object[] s() {
        Object[] array;
        synchronized (this.bl) {
            array = this.bl.size() > 0 ? this.bl.toArray() : null;
        }
        return array;
    }

    private ok() {
        this.bl = new ArrayList();
        this.kf = -1;
        this.f50102h = false;
        this.f50104p = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.ok.ok.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ok.this.f50102h = true;
                if (ok.this.f50105s != 0 || activity == null) {
                    return;
                }
                ok.this.f50105s = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i4 = ok.this.f50105s;
                ok.this.f50102h = false;
                ok.this.f50105s = activity != null ? activity.hashCode() : i4;
                if (i4 == 0) {
                    ok.this.n();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ok.this.f50103n = new WeakReference(activity);
                int i4 = ok.this.f50105s;
                ok.this.f50105s = activity != null ? activity.hashCode() : i4;
                ok.this.f50102h = false;
                if (i4 == 0) {
                    ok.this.n();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == ok.this.f50105s) {
                    ok.this.f50105s = 0;
                    ok.this.kf();
                }
                ok.this.f50102h = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    public boolean a() {
        int i4 = this.kf;
        int i5 = i4;
        if (i4 == -1) {
            ?? h4 = h();
            this.kf = h4;
            i5 = h4;
        }
        return i5 == 1;
    }

    public boolean bl() {
        return a() && !this.f50102h;
    }

    public static ok ok() {
        return a.ok;
    }

    public void a(InterfaceC1022ok interfaceC1022ok) {
        synchronized (this.bl) {
            this.bl.remove(interfaceC1022ok);
        }
    }

    public void ok(Context context) {
        if (this.ok == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.ok == null) {
                    Application application = (Application) context;
                    this.ok = application;
                    application.registerActivityLifecycleCallbacks(this.f50104p);
                }
            }
        }
    }

    public void ok(bl blVar) {
        this.f50101a = blVar;
    }

    public void ok(InterfaceC1022ok interfaceC1022ok) {
        if (interfaceC1022ok == null) {
            return;
        }
        synchronized (this.bl) {
            if (!this.bl.contains(interfaceC1022ok)) {
                this.bl.add(interfaceC1022ok);
            }
        }
    }
}
