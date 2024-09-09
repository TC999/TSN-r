package com.qq.e.comm.plugin.n0;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import cn.jiguang.android.BuildConfig;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.qq.e.comm.plugin.util.d1;
import yaq.pro;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private Handler f44784a;

    /* renamed from: b  reason: collision with root package name */
    private Context f44785b;

    /* renamed from: c  reason: collision with root package name */
    private n f44786c;

    /* renamed from: d  reason: collision with root package name */
    private r f44787d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f44788e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f44789f;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f44790g;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f44791a;

        static {
            int[] iArr = new int[l.values().length];
            f44791a = iArr;
            try {
                iArr[l.SDK_INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44791a[l.BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44791a[l.ITEM_ADD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44791a[l.PAGE_SWITCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f44791a[l.NETWORK_CHANGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.n0.j.a(t.a(t.this).getApplicationContext()).c();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.a f44793c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f44794d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ o f44795e;

        c(com.qq.e.comm.plugin.n0.a aVar, boolean z3, o oVar) {
            this.f44793c = aVar;
            this.f44794d = z3;
            this.f44795e = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f44793c.a(this.f44794d);
                this.f44793c.a((com.qq.e.comm.plugin.n0.a) this.f44795e);
                if (this.f44794d) {
                    this.f44793c.f();
                } else {
                    t.this.a(l.ITEM_ADD);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.b(t.this);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.c(t.this);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.qq.e.comm.plugin.util.p.b().c()) {
                return;
            }
            t.this.a(l.BACKGROUND);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.d(t.this).g();
            t.e(t.this).g();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.d(t.this).a();
            t.e(t.this).a();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.d(t.this).f();
            t.e(t.this).f();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class j extends BroadcastReceiver {
        j() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            t.f(t.this);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static final class k implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private t f44804a;

        public k(t tVar) {
            this.f44804a = tVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            t.g(this.f44804a);
            t.h(this.f44804a);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            this.f44804a.a(l.PAGE_SWITCH);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private enum l {
        SDK_INIT,
        BACKGROUND,
        ITEM_ADD,
        PAGE_SWITCH,
        NETWORK_CHANGE
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static final class m {

        /* renamed from: a  reason: collision with root package name */
        private static final t f44811a = new t(null);
    }

    /* synthetic */ t(b bVar) {
        this();
    }

    static /* synthetic */ Context a(t tVar) {
        return (Context) pro.getobjresult(463, 1, tVar);
    }

    private void a() {
        pro.getVresult(464, 0, this);
    }

    private <T extends o> void a(com.qq.e.comm.plugin.n0.a<T> aVar, T t3, boolean z3) {
        pro.getVresult(465, 0, this, aVar, t3, Boolean.valueOf(z3));
    }

    private void b() {
        pro.getVresult(466, 0, this);
    }

    static /* synthetic */ void b(t tVar) {
        pro.getVresult(467, 1, tVar);
    }

    public static t c() {
        return (t) pro.getobjresult(468, 1, new Object[0]);
    }

    static /* synthetic */ void c(t tVar) {
        pro.getVresult(469, 1, tVar);
    }

    static /* synthetic */ n d(t tVar) {
        return (n) pro.getobjresult(470, 1, tVar);
    }

    private void d() {
        pro.getVresult(471, 0, this);
    }

    static /* synthetic */ r e(t tVar) {
        return (r) pro.getobjresult(TTVideoEngine.PLAYER_OPTION_OUTPUT_LOG, 1, tVar);
    }

    private void e() {
        pro.getVresult(BuildConfig.VERSION_CODE, 0, this);
    }

    private void f() {
        pro.getVresult(474, 0, this);
    }

    static /* synthetic */ void f(t tVar) {
        pro.getVresult(475, 1, tVar);
    }

    static /* synthetic */ void g(t tVar) {
        pro.getVresult(476, 1, tVar);
    }

    static /* synthetic */ void h(t tVar) {
        pro.getVresult(477, 1, tVar);
    }

    public void a(Context context) {
        pro.getVresult(478, 0, this, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.qq.e.comm.plugin.n0.l lVar, boolean z3) {
        pro.getVresult(479, 0, this, lVar, Boolean.valueOf(z3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        pro.getVresult(480, 0, this, pVar);
    }

    void a(l lVar) {
        pro.getVresult(481, 0, this, lVar);
    }

    private t() {
        this.f44788e = new d();
        this.f44789f = new e();
        this.f44790g = new f();
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        this.f44785b = a4;
        this.f44786c = new n(a4);
        this.f44787d = new r(this.f44785b);
        HandlerThread handlerThread = new HandlerThread("gdt_stat_service");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        if (looper != null) {
            this.f44784a = new Handler(looper);
        } else {
            d1.a("Create stat handler failed!");
        }
        if (Build.VERSION.SDK_INT >= 14 && (this.f44785b instanceof Application)) {
            d1.a("Stat register activity listener", new Object[0]);
            ((Application) this.f44785b).registerActivityLifecycleCallbacks(new k(this));
        }
        a(this.f44785b);
        a(l.SDK_INIT);
        Handler handler = this.f44784a;
        if (handler != null) {
            handler.post(new b());
        }
    }
}
