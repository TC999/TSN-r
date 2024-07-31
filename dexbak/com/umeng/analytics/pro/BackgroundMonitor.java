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

@TargetApi(14)
/* renamed from: com.umeng.analytics.pro.m */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BackgroundMonitor implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private static BackgroundMonitor f38358a = new BackgroundMonitor();

    /* renamed from: b */
    private final int f38359b = 3000;

    /* renamed from: c */
    private boolean f38360c = false;

    /* renamed from: d */
    private boolean f38361d = true;

    /* renamed from: e */
    private Handler f38362e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private ArrayList<BackgroundWatcher> f38363f = new ArrayList<>();

    /* renamed from: g */
    private RunnableC13165a f38364g = new RunnableC13165a();

    /* compiled from: BackgroundMonitor.java */
    /* renamed from: com.umeng.analytics.pro.m$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class RunnableC13165a implements Runnable {
        RunnableC13165a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BackgroundMonitor.this.f38360c && BackgroundMonitor.this.f38361d) {
                BackgroundMonitor.this.f38360c = false;
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> went background.");
                for (int i = 0; i < BackgroundMonitor.this.f38363f.size(); i++) {
                    ((BackgroundWatcher) BackgroundMonitor.this.f38363f.get(i)).mo14278n();
                }
                return;
            }
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
        }
    }

    private BackgroundMonitor() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f38361d = true;
        RunnableC13165a runnableC13165a = this.f38364g;
        if (runnableC13165a != null) {
            this.f38362e.removeCallbacks(runnableC13165a);
            this.f38362e.postDelayed(this.f38364g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f38361d = false;
        this.f38360c = true;
        RunnableC13165a runnableC13165a = this.f38364g;
        if (runnableC13165a != null) {
            this.f38362e.removeCallbacks(runnableC13165a);
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

    /* renamed from: b */
    public synchronized void m14280b(BackgroundWatcher backgroundWatcher) {
        if (backgroundWatcher != null) {
            for (int i = 0; i < this.f38363f.size(); i++) {
                if (this.f38363f.get(i) == backgroundWatcher) {
                    this.f38363f.remove(i);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m14285a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f38358a);
        }
    }

    /* renamed from: a */
    public static BackgroundMonitor m14286a() {
        return f38358a;
    }

    /* renamed from: a */
    public synchronized void m14282a(BackgroundWatcher backgroundWatcher) {
        if (backgroundWatcher != null) {
            this.f38363f.add(backgroundWatcher);
        }
    }
}
