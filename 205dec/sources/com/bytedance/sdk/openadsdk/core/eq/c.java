package com.bytedance.sdk.openadsdk.core.eq;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Window;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f33204c;

    /* renamed from: w  reason: collision with root package name */
    public static long f33205w;
    public static long xv;

    /* renamed from: a  reason: collision with root package name */
    private volatile WeakReference<Activity> f33206a;
    private volatile InterfaceC0491c sr;
    private volatile w ux;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f33207f = new AtomicBoolean(false);

    /* renamed from: r  reason: collision with root package name */
    private final HashSet<Integer> f33210r = new HashSet<>();
    private volatile CopyOnWriteArrayList<WeakReference<com.bytedance.sdk.component.adexpress.c>> ev = new CopyOnWriteArrayList<>();
    private volatile CopyOnWriteArrayList<w> gd = new CopyOnWriteArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    private final ArrayList<String> f33209p = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private SparseArray<Set<Runnable>> f33208k = new SparseArray<>();

    /* renamed from: com.bytedance.sdk.openadsdk.core.eq.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0491c {
        void c();

        void f();

        void sr();

        void ux();

        void w();

        void xv();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c();

        void w();
    }

    private void f() {
        com.bytedance.sdk.openadsdk.n.f.w(new com.bytedance.sdk.component.gd.p("upload_dpl") { // from class: com.bytedance.sdk.openadsdk.core.eq.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
                long w3 = c4.w("save_dpl_success_time", 0L);
                if (w3 <= 0) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - w3;
                if (currentTimeMillis >= 86400000 || currentTimeMillis <= 0) {
                    return;
                }
                String w4 = c4.w("save_dpl_success_ad_tag", "");
                String w5 = c4.w("save_dpl_success_materialmeta", "");
                if (TextUtils.isEmpty(w4) || TextUtils.isEmpty(w5)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.a.xv.c(currentTimeMillis, w4, w5);
            }
        });
    }

    private boolean sr() {
        Bridge wv = com.bytedance.sdk.openadsdk.core.k.sr().wv();
        if (wv != null) {
            try {
                return ((Boolean) wv.call(2, null, Boolean.class)).booleanValue();
            } catch (Exception unused) {
            }
        }
        return this.f33207f.get();
    }

    private void ux() {
        if (c()) {
            com.bytedance.sdk.component.gd.ev.xv(new com.bytedance.sdk.component.gd.p("reportSdkUseTime") { // from class: com.bytedance.sdk.openadsdk.core.eq.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.f33204c = false;
                    c.xv = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.fz.a.c().c(c.f33205w / 1000, c.xv / 1000, !com.bytedance.sdk.openadsdk.core.q.f34488w.get());
                    com.bytedance.sdk.openadsdk.core.q.f34488w.set(false);
                }
            });
        }
    }

    private void w(boolean z3) {
        try {
            if (z3) {
                if (this.ux != null) {
                    this.ux.w();
                }
                Iterator<w> it = this.gd.iterator();
                while (it.hasNext()) {
                    w next = it.next();
                    if (next != null) {
                        next.w();
                    }
                }
                return;
            }
            if (this.ux != null) {
                this.ux.c();
            }
            Iterator<w> it2 = this.gd.iterator();
            while (it2.hasNext()) {
                w next2 = it2.next();
                if (next2 != null) {
                    next2.c();
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean c() {
        return sr();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@ForbidWrapParam Activity activity, Bundle bundle) {
        if (this.sr != null) {
            this.sr.sr();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@ForbidWrapParam Activity activity) {
        if (activity != null) {
            this.f33210r.remove(Integer.valueOf(activity.hashCode()));
        }
        if (this.sr != null) {
            this.sr.f();
        }
        if (this.ev != null && this.ev.size() > 0) {
            Iterator<WeakReference<com.bytedance.sdk.component.adexpress.c>> it = this.ev.iterator();
            while (it.hasNext()) {
                WeakReference<com.bytedance.sdk.component.adexpress.c> next = it.next();
                if (next != null && next.get() != null) {
                    try {
                        next.get().c(activity);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (this.f33206a != null && this.f33206a.get() == activity) {
            this.f33206a = null;
        }
        if (activity != null) {
            int hashCode = activity.hashCode();
            synchronized (this.f33208k) {
                Set<Runnable> set = this.f33208k.get(hashCode);
                if (set != null) {
                    for (Runnable runnable : set) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    this.f33208k.remove(hashCode);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@ForbidWrapParam Activity activity) {
        if (this.sr != null) {
            this.sr.xv();
        }
        if (activity == null || activity.getComponentName() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.w.c().xv(activity.getComponentName().getClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@ForbidWrapParam Activity activity) {
        if (activity != null) {
            this.f33210r.add(Integer.valueOf(activity.hashCode()));
        }
        if (this.sr != null) {
            this.sr.c();
        }
        com.bytedance.sdk.component.ev.xv.c.c(com.bytedance.sdk.openadsdk.core.ls.getContext(), Integer.parseInt("1371"));
        if (!f33204c) {
            f33205w = System.currentTimeMillis();
            f33204c = true;
        }
        com.bytedance.sdk.openadsdk.core.y.c();
        this.f33206a = new WeakReference<>(activity);
        if (activity != null && activity.getComponentName() != null) {
            com.bytedance.sdk.openadsdk.core.eq.w.c().c(activity.getComponentName().getClassName());
        }
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        bk.c().c(activity.getIntent());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@ForbidWrapParam Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@ForbidWrapParam Activity activity) {
        if (this.f33207f.get()) {
            w(true);
        }
        if (!this.f33209p.contains(activity.toString())) {
            this.f33209p.add(activity.toString());
            this.f33207f.set(false);
        }
        f();
        if (this.sr != null) {
            this.sr.w();
        }
        xk.sr(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@ForbidWrapParam Activity activity) {
        if (this.f33209p.contains(activity.toString())) {
            this.f33209p.remove(activity.toString());
            if (this.f33209p.size() == 0) {
                this.f33207f.set(true);
                w(false);
            }
        }
        if (this.sr != null) {
            this.sr.ux();
        }
        ux();
    }

    public void xv(w wVar) {
        this.ux = wVar;
    }

    public boolean c(boolean z3) {
        Activity activity;
        Window window;
        return (this.f33206a == null || (activity = this.f33206a.get()) == null || (window = activity.getWindow()) == null) ? z3 : window.getDecorView().hasWindowFocus();
    }

    public void xv() {
        com.bytedance.sdk.openadsdk.core.eq.w.c().w();
    }

    public boolean c(@ForbidWrapParam Activity activity) {
        return activity != null && this.f33210r.contains(Integer.valueOf(activity.hashCode()));
    }

    public void c(InterfaceC0491c interfaceC0491c) {
        this.sr = interfaceC0491c;
    }

    public void c(com.bytedance.sdk.component.adexpress.c cVar) {
        this.ev.add(new WeakReference<>(cVar));
    }

    public boolean w(com.bytedance.sdk.component.adexpress.c cVar) {
        return this.ev.remove(new WeakReference(cVar));
    }

    public void c(w wVar) {
        if (this.gd.contains(wVar)) {
            return;
        }
        this.gd.add(wVar);
    }

    public boolean w(w wVar) {
        if (wVar == null) {
            return false;
        }
        return this.gd.remove(wVar);
    }

    public boolean c(Activity activity, Runnable runnable) {
        boolean add;
        if (activity == null) {
            return false;
        }
        int hashCode = activity.hashCode();
        synchronized (this.f33208k) {
            Set<Runnable> set = this.f33208k.get(hashCode);
            if (set == null) {
                set = new HashSet<>();
                this.f33208k.put(hashCode, set);
            }
            add = set.add(runnable);
        }
        return add;
    }

    public void w() {
        if (this.sr != null) {
            this.sr = null;
        }
    }
}
