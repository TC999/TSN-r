package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.e;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.n;
import com.bytedance.msdk.adapter.util.Logger;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* compiled from: InternalContainer.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile Context f251a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c f252b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> f253c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> f254d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> f255e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InternalContainer.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class C0015a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f256a;

        C0015a(Context context) {
            this.f256a = context;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.e.a
        public boolean a() {
            Context context = this.f256a;
            if (context == null) {
                context = a.d();
            }
            return n.a(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InternalContainer.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        private static volatile Application f257a;

        static {
            try {
                Object b4 = b();
                f257a = (Application) b4.getClass().getMethod("getApplication", new Class[0]).invoke(b4, new Object[0]);
                Logger.e("MyApplication", "application get success");
            } catch (Throwable th) {
                Logger.e("MyApplication", "application get failed", th);
            }
        }

        public static Application a() {
            return f257a;
        }

        private static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                Logger.e("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> a() {
        if (f254d == null) {
            synchronized (a.class) {
                if (f254d == null) {
                    f254d = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b<>("V1", new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.b(f251a), e(), b(), a(f251a));
                }
            }
        }
        return f254d;
    }

    public static synchronized void b(Context context) {
        synchronized (a.class) {
            if (f251a == null) {
                synchronized (a.class) {
                    if (b.a() != null) {
                        try {
                            f251a = b.a();
                            if (f251a != null) {
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (context != null) {
                        f251a = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    }
                }
            }
        }
    }

    public static bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> c() {
        if (f255e == null) {
            synchronized (a.class) {
                if (f255e == null) {
                    f255e = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b<>("V3", new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.b(f251a), e(), b(), a(f251a));
                }
            }
        }
        return f255e;
    }

    public static Context d() {
        if (f251a == null) {
            b(null);
        }
        return f251a;
    }

    public static bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> e() {
        if (f253c == null) {
            synchronized (a.class) {
                if (f253c == null) {
                    f253c = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b(f251a);
                }
            }
        }
        return f253c;
    }

    public static bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c f() {
        if (f252b == null) {
            synchronized (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c.class) {
                if (f252b == null) {
                    f252b = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.c();
                }
            }
        }
        return f252b;
    }

    private static e.b b() {
        return e.b.a();
    }

    private static e.a a(Context context) {
        return new C0015a(context);
    }
}
