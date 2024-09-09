package com.qq.e.comm.plugin.h0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.qq.e.comm.plugin.h0.f;
import com.qq.e.comm.plugin.util.d1;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class a implements f, Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    protected final Activity f43998a;

    /* renamed from: b  reason: collision with root package name */
    protected final long f43999b;

    /* renamed from: c  reason: collision with root package name */
    protected int f44000c;

    /* renamed from: d  reason: collision with root package name */
    protected int f44001d;

    /* renamed from: e  reason: collision with root package name */
    protected int f44002e;

    /* renamed from: f  reason: collision with root package name */
    protected int f44003f;

    /* renamed from: g  reason: collision with root package name */
    protected int f44004g;

    /* renamed from: h  reason: collision with root package name */
    protected final AtomicBoolean f44005h = new AtomicBoolean();

    public a(Activity activity, long j4) {
        this.f43998a = activity;
        this.f43999b = j4;
        activity.getApplication().registerActivityLifecycleCallbacks(this);
    }

    @Override // com.qq.e.comm.plugin.h0.f
    public f.a a() {
        return new f.a(this.f44000c, this.f44001d, this.f44002e, this.f44003f, this.f44004g);
    }

    abstract String b();

    protected abstract void c();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity != this.f43998a) {
            return;
        }
        d1.a(b(), "onActivityDestroyed: fps destroy");
        activity.getApplication().unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (activity != this.f43998a) {
            return;
        }
        d1.a(b(), "onActivityPaused: fps pause");
        this.f44005h.set(false);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (activity == this.f43998a && !this.f44005h.get()) {
            d1.a(b(), "onActivityResumed: fps start");
            start();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.qq.e.comm.plugin.h0.f
    public void start() {
        this.f44005h.set(true);
    }

    @Override // com.qq.e.comm.plugin.h0.f
    public final void stop() {
        this.f43998a.getApplication().unregisterActivityLifecycleCallbacks(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i4) {
        if (i4 < 3) {
            this.f44000c++;
        } else if (i4 < 9) {
            this.f44001d++;
        } else if (i4 < 24) {
            this.f44002e++;
        } else if (i4 < 42) {
            this.f44003f++;
        } else {
            this.f44004g++;
        }
    }
}
