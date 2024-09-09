package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private Context f46541a;

    /* renamed from: b  reason: collision with root package name */
    private final List<h> f46542b;

    /* renamed from: c  reason: collision with root package name */
    private int f46543c;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f46544d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Activity f46545e;

    /* renamed from: f  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f46546f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f46547g;

    /* renamed from: h  reason: collision with root package name */
    private volatile int f46548h;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            p.this.a("onActivityCreated", activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            p.this.a("onActivityDestroyed", activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            p.this.a("onActivityPaused", activity);
            if (p.this.f46543c != 0 || activity == null) {
                return;
            }
            p.this.f46543c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            p.this.a("onActivityResumed", activity);
            p.this.f46545e = activity;
            int i4 = p.this.f46543c;
            if (activity != null) {
                p.this.f46543c = activity.hashCode();
            }
            if (i4 == 0) {
                p.this.e();
            }
            if (p.this.f46548h >= 0 || p.this.f46545e == null || p.this.f46545e.getIntent() == null) {
                return;
            }
            p pVar = p.this;
            pVar.f46548h = pVar.f46545e.getIntent().getSourceBounds() == null ? 0 : 1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            p.this.a("onActivityStarted", activity);
            int i4 = p.this.f46543c;
            p.this.f46543c = activity != null ? activity.hashCode() : i4;
            if (i4 == 0) {
                p.this.e();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            p.this.a("onActivityStopped", activity);
            if (p.this.f46545e == activity) {
                p.this.f46545e = null;
            }
            if (activity == null || activity.hashCode() != p.this.f46543c) {
                return;
            }
            p.this.f46543c = 0;
            p.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f46550c;

        b(h hVar) {
            this.f46550c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.f46542b.contains(this.f46550c)) {
                return;
            }
            p.this.f46542b.add(this.f46550c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f46552c;

        c(h hVar) {
            this.f46552c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.f46542b.remove(this.f46552c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = p.this.f46542b.iterator();
            while (it.hasNext()) {
                p.this.f46547g = true;
                if (((h) it.next()).b()) {
                    it.remove();
                }
                p.this.f46547g = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = p.this.f46542b.iterator();
            while (it.hasNext()) {
                p.this.f46547g = true;
                if (((h) it.next()).c()) {
                    it.remove();
                }
                p.this.f46547g = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class f implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i f46556c;

        f(i iVar) {
            this.f46556c = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f46556c == null || !p.this.f46542b.remove(this.f46556c)) {
                return;
            }
            this.f46556c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        static int f46558a = -1;

        /* renamed from: b  reason: collision with root package name */
        static int f46559b = 0;

        /* renamed from: c  reason: collision with root package name */
        static int f46560c = 1;
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface h {
        boolean b();

        boolean c();
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface i extends h {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        private static final p f46561a = new p(null);
    }

    /* synthetic */ p(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Activity activity) {
    }

    private p() {
        this.f46548h = -1;
        this.f46542b = new ArrayList();
        this.f46544d = g.f46558a;
        this.f46546f = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f46544d = g.f46559b;
        p0.b(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f46544d = g.f46560c;
        p0.b(new d());
    }

    public boolean c() {
        if (this.f46544d == g.f46558a) {
            if (y.d(this.f46541a)) {
                this.f46544d = g.f46560c;
            } else {
                this.f46544d = g.f46559b;
            }
        }
        return this.f46544d == g.f46560c;
    }

    public static p b() {
        return j.f46561a;
    }

    public void b(h hVar) {
        if (hVar == null) {
            return;
        }
        c cVar = new c(hVar);
        if (this.f46547g) {
            p0.a((Runnable) cVar);
        } else {
            p0.b(cVar);
        }
    }

    public void a(Context context) {
        this.f46541a = context;
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.f46546f);
        }
    }

    public void a(h hVar) {
        if (hVar == null) {
            return;
        }
        b bVar = new b(hVar);
        if (this.f46547g) {
            p0.a((Runnable) bVar);
        } else {
            p0.b(bVar);
        }
    }

    public boolean a(i iVar) {
        if (c() || y.d(this.f46541a)) {
            a((h) iVar);
            p0.a(new f(iVar), com.qq.e.comm.plugin.d0.a.d().f().a("cabt", 2000));
            return true;
        }
        return false;
    }

    public Activity a() {
        return this.f46545e;
    }
}
