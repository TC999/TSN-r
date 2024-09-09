package com.umeng.analytics.pro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BackgroundMonitor.java */
@TargetApi(14)
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class m implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static m f53036a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final int f53037b = 3000;

    /* renamed from: c  reason: collision with root package name */
    private boolean f53038c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f53039d = true;

    /* renamed from: e  reason: collision with root package name */
    private Handler f53040e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<n> f53041f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private a f53042g = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BackgroundMonitor.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f53038c && m.this.f53039d) {
                m.this.f53038c = false;
                UMRTLog.i("MobclickRT", "--->>> went background.");
                for (int i4 = 0; i4 < m.this.f53041f.size(); i4++) {
                    ((n) m.this.f53041f.get(i4)).n();
                }
                return;
            }
            UMRTLog.i("MobclickRT", "--->>> still foreground.");
        }
    }

    private m() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f53039d = true;
        a aVar = this.f53042g;
        if (aVar != null) {
            this.f53040e.removeCallbacks(aVar);
            this.f53040e.postDelayed(this.f53042g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f53039d = false;
        this.f53038c = true;
        a aVar = this.f53042g;
        if (aVar != null) {
            this.f53040e.removeCallbacks(aVar);
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

    public synchronized void b(n nVar) {
        if (nVar != null) {
            for (int i4 = 0; i4 < this.f53041f.size(); i4++) {
                if (this.f53041f.get(i4) == nVar) {
                    this.f53041f.remove(i4);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f53036a);
        }
    }

    public static m a() {
        return f53036a;
    }

    public synchronized void a(n nVar) {
        if (nVar != null) {
            this.f53041f.add(nVar);
        }
    }
}
