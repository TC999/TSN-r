package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.baidu.mobads.sdk.internal.aa */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2580aa {

    /* renamed from: a */
    private static final String f8521a = "LoadRemoteDex";

    /* renamed from: i */
    private static C2580aa f8522i;

    /* renamed from: b */
    private IXAdContainerFactory f8523b;

    /* renamed from: c */
    private C2628bn f8524c;

    /* renamed from: f */
    private Runnable f8527f;

    /* renamed from: g */
    private Context f8528g;

    /* renamed from: k */
    private boolean f8531k;

    /* renamed from: d */
    private int f8525d = 5000;

    /* renamed from: e */
    private Handler f8526e = new Handler(Looper.getMainLooper());

    /* renamed from: h */
    private C2634bs f8529h = C2634bs.m50744a();

    /* renamed from: j */
    private AtomicBoolean f8530j = new AtomicBoolean(false);

    /* renamed from: com.baidu.mobads.sdk.internal.aa$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2581a {

        /* renamed from: a */
        public static final int f8532a = 1;

        /* renamed from: b */
        public static final int f8533b = 2;

        void onFailure();

        void onSuccess();
    }

    private C2580aa() {
    }

    /* renamed from: f */
    private void m51046f() {
        this.f8530j.set(true);
        if (C2598ao.m50996a()) {
            m51044h();
        } else {
            m51045g();
        }
    }

    /* renamed from: g */
    private void m51045g() {
        synchronized (C2580aa.class) {
            try {
                C2628bn c2628bn = new C2628bn(Class.forName(C2736x.f9277aP, true, getClass().getClassLoader()), this.f8528g);
                this.f8524c = c2628bn;
                this.f8523b = c2628bn.m50780a();
                m51041k();
            } catch (Exception unused) {
                m51052a("反射调用remote失败");
            }
        }
    }

    /* renamed from: h */
    private void m51044h() {
        this.f8527f = new RunnableC2582ab(this);
        m51042j();
        if (C2708g.f9067a == null) {
            synchronized (C2640by.class) {
                if (C2708g.f9067a == null) {
                    C2708g.f9067a = new C2640by(this.f8528g);
                }
            }
        }
        if (this.f8523b != null) {
            m51041k();
        } else if (C2708g.f9067a != null) {
            this.f8529h.m50740a(f8521a, "start load apk");
            try {
                C2708g.f9067a.m50701a(new C2583ac(this));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            this.f8529h.m50740a(f8521a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
        }
    }

    /* renamed from: i */
    private void m51043i() {
        Runnable runnable = this.f8527f;
        if (runnable != null) {
            this.f8526e.removeCallbacks(runnable);
        }
        this.f8527f = null;
    }

    /* renamed from: j */
    private void m51042j() {
        Runnable runnable = this.f8527f;
        if (runnable != null) {
            this.f8526e.postDelayed(runnable, this.f8525d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m51041k() {
        this.f8530j.set(false);
        C2624bk.m50799a(this.f8528g);
        m51043i();
        C2720q.m50350a().m50349a(1);
        C2660cm.m50631a(this.f8528g).m50623b();
        C2660cm.m50631a(this.f8528g).m50632a();
    }

    /* renamed from: c */
    public IXAdContainerFactory m51049c() {
        if (this.f8528g == null) {
            return null;
        }
        if (this.f8523b == null && !this.f8530j.get()) {
            m51046f();
        }
        return this.f8523b;
    }

    /* renamed from: d */
    public String m51048d() {
        if (this.f8523b != null) {
            return "_" + this.f8523b.getRemoteVersion();
        }
        return "";
    }

    /* renamed from: e */
    public boolean m51047e() {
        return this.f8531k;
    }

    /* renamed from: b */
    public Context m51051b() {
        return this.f8528g;
    }

    /* renamed from: a */
    public static C2580aa m51057a() {
        if (f8522i == null) {
            synchronized (C2580aa.class) {
                if (f8522i == null) {
                    f8522i = new C2580aa();
                }
            }
        }
        return f8522i;
    }

    /* renamed from: a */
    public void m51056a(Context context, InterfaceC2581a interfaceC2581a) {
        if (context == null) {
            this.f8529h.m50728c(f8521a, "init Context is null,error");
            return;
        }
        this.f8528g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        C2720q.m50350a().m50348a(interfaceC2581a);
        if (this.f8523b != null) {
            m51041k();
        } else if (this.f8530j.get()) {
        } else {
            m51046f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m51052a(String str) {
        C2634bs c2634bs = this.f8529h;
        c2634bs.m50740a(f8521a, "加载dex失败原因=" + str);
        this.f8530j.set(false);
        m51043i();
        C2720q.m50350a().m50349a(2);
    }
}
