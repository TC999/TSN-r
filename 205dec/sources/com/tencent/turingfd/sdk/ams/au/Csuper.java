package com.tencent.turingfd.sdk.ams.au;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.super  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Csuper {

    /* renamed from: a  reason: collision with root package name */
    public static final WeakHashMap<Activity, Object> f52357a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReference<Cdo> f52358b = new AtomicReference<>(null);

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.super$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cdo extends com.tencent.turingfd.sdk.ams.au.Cdo implements Cnew, Coconut {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicBoolean f52359a = new AtomicBoolean(false);

        /* renamed from: b  reason: collision with root package name */
        public final Cclass f52360b;

        public Cdo(Cclass cclass) {
            this.f52360b = cclass;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            this.f52359a.set(true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Window window;
            if (activity != null && (window = activity.getWindow()) != null) {
                String name = activity.getClass().getName();
                try {
                    WeakHashMap<Activity, Object> weakHashMap = Csuper.f52357a;
                    if (!weakHashMap.containsKey(activity)) {
                        weakHashMap.put(activity, activity);
                        Window.Callback callback = window.getCallback();
                        if (callback != null && !(callback instanceof Loquat)) {
                            window.setCallback(new Loquat(callback, name, this));
                        }
                        ViewTreeObserver viewTreeObserver = window.getDecorView().getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.addOnPreDrawListener(new Cfinal(window, this, name));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            this.f52359a.set(false);
        }
    }
}
