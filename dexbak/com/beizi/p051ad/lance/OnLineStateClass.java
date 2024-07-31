package com.beizi.p051ad.lance;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.beizi.ad.lance.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OnLineStateClass {

    /* renamed from: f */
    private String f10825f;

    /* renamed from: i */
    private OnLineImpl f10828i;

    /* renamed from: a */
    private String f10820a = "OnLineStateClass";

    /* renamed from: b */
    private int f10821b = 0;

    /* renamed from: c */
    private boolean f10822c = true;

    /* renamed from: d */
    private boolean f10823d = false;

    /* renamed from: e */
    private boolean f10824e = false;

    /* renamed from: g */
    private Map<String, String> f10826g = new HashMap();

    /* renamed from: h */
    private long f10827h = 0;

    /* renamed from: d */
    static /* synthetic */ int m49007d(OnLineStateClass onLineStateClass) {
        int i = onLineStateClass.f10821b;
        onLineStateClass.f10821b = i + 1;
        return i;
    }

    /* renamed from: h */
    static /* synthetic */ int m49003h(OnLineStateClass onLineStateClass) {
        int i = onLineStateClass.f10821b;
        onLineStateClass.f10821b = i - 1;
        return i;
    }

    /* renamed from: a */
    public void m49017a(Context context) {
        this.f10827h = System.currentTimeMillis() / 1000;
        ((Application) StubApp.getOrigApplicationContext(context.getApplicationContext())).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.beizi.ad.lance.c.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                OnLineStateClass.this.f10825f = activity.getClass().getSimpleName();
                OnLineStateClass.this.f10826g.put(OnLineStateClass.this.f10825f, OnLineStateClass.this.f10825f);
                OnLineStateClass.this.f10822c = true;
                OnLineStateClass.this.f10823d = false;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                OnLineStateClass.this.f10826g.remove(activity.getClass().getSimpleName());
                if (OnLineStateClass.this.f10826g.size() == 0 && OnLineStateClass.this.f10822c) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (OnLineStateClass.this.f10828i != null) {
                        long unused = OnLineStateClass.this.f10827h;
                        OnLineStateClass.this.f10828i.mo49092a(currentTimeMillis, OnLineStateClass.this.f10827h);
                        OnLineStateClass.this.f10827h = System.currentTimeMillis() / 1000;
                    }
                    OnLineStateClass.this.f10822c = false;
                }
                if (OnLineStateClass.this.f10826g.size() == 0) {
                    OnLineStateClass.this.f10824e = true;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                OnLineStateClass.this.f10823d = !activity.getClass().getSimpleName().equals(OnLineStateClass.this.f10825f);
                OnLineStateClass.this.f10825f = activity.getClass().getSimpleName();
                if (!OnLineStateClass.this.f10822c || OnLineStateClass.this.f10824e) {
                    OnLineStateClass.this.f10824e = false;
                    if (OnLineStateClass.this.f10828i != null) {
                        OnLineStateClass.this.f10828i.mo49093a();
                    }
                    OnLineStateClass.this.f10827h = System.currentTimeMillis() / 1000;
                    OnLineStateClass.this.f10822c = true;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                LogUtil.m49046a(OnLineStateClass.this.f10820a, "onActivityStarted");
                OnLineStateClass.m49007d(OnLineStateClass.this);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                LogUtil.m49046a(OnLineStateClass.this.f10820a, "onActivityStopped");
                OnLineStateClass.m49003h(OnLineStateClass.this);
                if (activity.getClass().getSimpleName().equals(OnLineStateClass.this.f10825f)) {
                    if (!OnLineStateClass.this.f10823d || OnLineStateClass.this.f10826g.size() == 1) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        if (OnLineStateClass.this.f10828i != null) {
                            long unused = OnLineStateClass.this.f10827h;
                            OnLineStateClass.this.f10828i.mo49092a(OnLineStateClass.this.f10827h, currentTimeMillis);
                            OnLineStateClass.this.f10827h = System.currentTimeMillis() / 1000;
                        }
                        OnLineStateClass.this.f10822c = false;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49016a(OnLineImpl onLineImpl) {
        this.f10828i = onLineImpl;
    }
}
