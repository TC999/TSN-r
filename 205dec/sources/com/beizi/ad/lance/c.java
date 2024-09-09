package com.beizi.ad.lance;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.beizi.ad.lance.a.l;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OnLineStateClass.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    private String f14390f;

    /* renamed from: i  reason: collision with root package name */
    private a f14393i;

    /* renamed from: a  reason: collision with root package name */
    private String f14385a = "OnLineStateClass";

    /* renamed from: b  reason: collision with root package name */
    private int f14386b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14387c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14388d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14389e = false;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f14391g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private long f14392h = 0;

    static /* synthetic */ int d(c cVar) {
        int i4 = cVar.f14386b;
        cVar.f14386b = i4 + 1;
        return i4;
    }

    static /* synthetic */ int h(c cVar) {
        int i4 = cVar.f14386b;
        cVar.f14386b = i4 - 1;
        return i4;
    }

    public void a(Context context) {
        this.f14392h = System.currentTimeMillis() / 1000;
        ((Application) StubApp.getOrigApplicationContext(context.getApplicationContext())).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.beizi.ad.lance.c.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                c.this.f14390f = activity.getClass().getSimpleName();
                c.this.f14391g.put(c.this.f14390f, c.this.f14390f);
                c.this.f14387c = true;
                c.this.f14388d = false;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                c.this.f14391g.remove(activity.getClass().getSimpleName());
                if (c.this.f14391g.size() == 0 && c.this.f14387c) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (c.this.f14393i != null) {
                        long unused = c.this.f14392h;
                        c.this.f14393i.a(currentTimeMillis, c.this.f14392h);
                        c.this.f14392h = System.currentTimeMillis() / 1000;
                    }
                    c.this.f14387c = false;
                }
                if (c.this.f14391g.size() == 0) {
                    c.this.f14389e = true;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                c.this.f14388d = !activity.getClass().getSimpleName().equals(c.this.f14390f);
                c.this.f14390f = activity.getClass().getSimpleName();
                if (!c.this.f14387c || c.this.f14389e) {
                    c.this.f14389e = false;
                    if (c.this.f14393i != null) {
                        c.this.f14393i.a();
                    }
                    c.this.f14392h = System.currentTimeMillis() / 1000;
                    c.this.f14387c = true;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                l.a(c.this.f14385a, "onActivityStarted");
                c.d(c.this);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                l.a(c.this.f14385a, "onActivityStopped");
                c.h(c.this);
                if (activity.getClass().getSimpleName().equals(c.this.f14390f)) {
                    if (!c.this.f14388d || c.this.f14391g.size() == 1) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        if (c.this.f14393i != null) {
                            long unused = c.this.f14392h;
                            c.this.f14393i.a(c.this.f14392h, currentTimeMillis);
                            c.this.f14392h = System.currentTimeMillis() / 1000;
                        }
                        c.this.f14387c = false;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f14393i = aVar;
    }
}
