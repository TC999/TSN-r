package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12317a = "LoadRemoteDex";

    /* renamed from: i  reason: collision with root package name */
    private static aa f12318i;

    /* renamed from: b  reason: collision with root package name */
    private IXAdContainerFactory f12319b;

    /* renamed from: c  reason: collision with root package name */
    private bq f12320c;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f12323f;

    /* renamed from: g  reason: collision with root package name */
    private Context f12324g;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12327k;

    /* renamed from: d  reason: collision with root package name */
    private int f12321d = 5000;

    /* renamed from: e  reason: collision with root package name */
    private Handler f12322e = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    private bv f12325h = bv.a();

    /* renamed from: j  reason: collision with root package name */
    private AtomicBoolean f12326j = new AtomicBoolean(false);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f12328a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f12329b = 2;

        void onFailure();

        void onSuccess();
    }

    private aa() {
    }

    private void f() {
        this.f12326j.set(true);
        if (ao.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (aa.class) {
            try {
                bq bqVar = new bq(Class.forName(x.aQ, true, getClass().getClassLoader()), this.f12324g);
                this.f12320c = bqVar;
                this.f12319b = bqVar.a();
                k();
            } catch (Exception unused) {
                a("\u53cd\u5c04\u8c03\u7528remote\u5931\u8d25");
            }
        }
    }

    private void h() {
        this.f12323f = new ab(this);
        j();
        if (g.f12853a == null) {
            synchronized (cb.class) {
                if (g.f12853a == null) {
                    g.f12853a = new cb(this.f12324g);
                }
            }
        }
        if (this.f12319b != null) {
            k();
        } else if (g.f12853a != null) {
            this.f12325h.a("LoadRemoteDex", "start load apk");
            try {
                g.f12853a.a(new ac(this));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            this.f12325h.a("LoadRemoteDex", "BaiduXAdSDKContext.mApkLoader == null,not load apk");
        }
    }

    private void i() {
        Runnable runnable = this.f12323f;
        if (runnable != null) {
            this.f12322e.removeCallbacks(runnable);
        }
        this.f12323f = null;
    }

    private void j() {
        Runnable runnable = this.f12323f;
        if (runnable != null) {
            this.f12322e.postDelayed(runnable, this.f12321d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f12326j.set(false);
        bn.a(this.f12324g);
        i();
        q.a().a(1);
        cp.a(this.f12324g).b();
        cp.a(this.f12324g).a();
    }

    public IXAdContainerFactory c() {
        if (this.f12324g == null) {
            return null;
        }
        if (this.f12319b == null && !this.f12326j.get()) {
            f();
        }
        return this.f12319b;
    }

    public String d() {
        if (this.f12319b != null) {
            return "_" + this.f12319b.getRemoteVersion();
        }
        return "";
    }

    public boolean e() {
        return this.f12327k;
    }

    public Context b() {
        return this.f12324g;
    }

    public static aa a() {
        if (f12318i == null) {
            synchronized (aa.class) {
                if (f12318i == null) {
                    f12318i = new aa();
                }
            }
        }
        return f12318i;
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            this.f12325h.c("LoadRemoteDex", "init Context is null,error");
            return;
        }
        this.f12324g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        q.a().a(aVar);
        if (this.f12319b != null) {
            k();
        } else if (this.f12326j.get()) {
        } else {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        bv bvVar = this.f12325h;
        bvVar.a("LoadRemoteDex", "\u52a0\u8f7ddex\u5931\u8d25\u539f\u56e0=" + str);
        this.f12326j.set(false);
        i();
        q.a().a(2);
    }
}
