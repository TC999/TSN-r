package com.kwad.sdk.core.p391c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.core.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10230a implements Application.ActivityLifecycleCallbacks {
    private final List<WeakReference<Activity>> avb;
    private WeakReference<Activity> currentActivity;
    private Application mApplication;
    private boolean mEnable;
    private boolean mIsInBackground;
    private final List<InterfaceC10246c> mListeners;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.c.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10231a {
        static final C10230a avc = new C10230a((byte) 0);
    }

    /* synthetic */ C10230a(byte b) {
        this();
    }

    /* renamed from: DB */
    public static C10230a m26630DB() {
        return C10231a.avc;
    }

    /* renamed from: DC */
    private boolean m26629DC() {
        return C10232b.m26624DE() || !this.mEnable;
    }

    /* renamed from: f */
    private void m26627f(Activity activity) {
        for (WeakReference<Activity> weakReference : this.avb) {
            if (weakReference.get() == activity) {
                return;
            }
        }
        this.avb.add(new WeakReference<>(activity));
    }

    /* renamed from: g */
    private void m26626g(Activity activity) {
        Activity activity2;
        if (activity == null) {
            return;
        }
        Iterator<WeakReference<Activity>> it = this.avb.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && ((activity2 = next.get()) == activity || activity2 == null)) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public final void m26628a(InterfaceC10246c interfaceC10246c) {
        this.mListeners.add(interfaceC10246c);
    }

    public final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void init(@NonNull Context context) {
        try {
            Application application = (Application) context;
            this.mApplication = application;
            application.registerActivityLifecycleCallbacks(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean isAppOnForeground() {
        return !this.mIsInBackground;
    }

    public final boolean isEnable() {
        return this.mEnable;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.mEnable = true;
        if (m26629DC()) {
            return;
        }
        try {
            for (InterfaceC10246c interfaceC10246c : this.mListeners) {
                interfaceC10246c.mo24393a(activity, bundle);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (m26629DC()) {
            return;
        }
        try {
            for (InterfaceC10246c interfaceC10246c : this.mListeners) {
                interfaceC10246c.mo24589b(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (m26629DC()) {
            return;
        }
        try {
            for (InterfaceC10246c interfaceC10246c : this.mListeners) {
                interfaceC10246c.mo26607c(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (m26629DC()) {
            return;
        }
        try {
            this.currentActivity = new WeakReference<>(activity);
            for (InterfaceC10246c interfaceC10246c : this.mListeners) {
                interfaceC10246c.mo26606d(activity);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (m26629DC()) {
            return;
        }
        try {
            m26627f(activity);
            if (this.avb.size() == 1) {
                this.mIsInBackground = false;
                for (InterfaceC10246c interfaceC10246c : this.mListeners) {
                    interfaceC10246c.onBackToForeground();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (m26629DC()) {
            return;
        }
        try {
            m26626g(activity);
            if (this.avb.size() == 0) {
                this.mIsInBackground = true;
                for (InterfaceC10246c interfaceC10246c : this.mListeners) {
                    interfaceC10246c.onBackToBackground();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private C10230a() {
        this.mIsInBackground = true;
        this.mListeners = new CopyOnWriteArrayList();
        this.avb = new ArrayList();
        this.mEnable = false;
    }
}
