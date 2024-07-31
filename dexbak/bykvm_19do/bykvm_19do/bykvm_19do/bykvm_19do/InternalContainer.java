package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.TTSdkSettings;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEvent;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventDispatcher;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventThread;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.AdEventRepertoryImpl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.ReportNetApi;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.ReportNetApiImpl;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.NetworkUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class InternalContainer {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static volatile Context f242a;

    /* renamed from: b */
    private static volatile TTSdkSettings f243b;

    /* renamed from: c */
    private static volatile ReportNetApi<AdEvent> f244c;

    /* renamed from: d */
    private static volatile AdEventDispatcher<AdEvent> f245d;

    /* renamed from: e */
    private static volatile AdEventDispatcher<AdEvent> f246e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InternalContainer.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C0932a implements AdEventThread.InterfaceC0976a {

        /* renamed from: a */
        final /* synthetic */ Context f247a;

        C0932a(Context context) {
            this.f247a = context;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.AdEventThread.InterfaceC0976a
        /* renamed from: a */
        public boolean mo59334a() {
            Context context = this.f247a;
            if (context == null) {
                context = InternalContainer.m59945d();
            }
            return NetworkUtils.m59170a(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InternalContainer.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C0933b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a */
        private static volatile Application f248a;

        static {
            try {
                Object m59941b = m59941b();
                f248a = (Application) m59941b.getClass().getMethod("getApplication", new Class[0]).invoke(m59941b, new Object[0]);
                Logger.m37557e("MyApplication", "application get success");
            } catch (Throwable th) {
                Logger.m37556e("MyApplication", "application get failed", th);
            }
        }

        /* renamed from: a */
        public static Application m59942a() {
            return f248a;
        }

        /* renamed from: b */
        private static Object m59941b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                Logger.m37556e("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    /* renamed from: a */
    public static AdEventDispatcher<AdEvent> m59950a() {
        if (f245d == null) {
            synchronized (InternalContainer.class) {
                if (f245d == null) {
                    f245d = new AdEventDispatcher<>("V1", new AdEventRepertoryImpl(f242a), m59944e(), m59948b(), m59949a(f242a));
                }
            }
        }
        return f245d;
    }

    /* renamed from: b */
    public static synchronized void m59947b(Context context) {
        synchronized (InternalContainer.class) {
            if (f242a == null) {
                synchronized (InternalContainer.class) {
                    if (C0933b.m59942a() != null) {
                        try {
                            f242a = C0933b.m59942a();
                            if (f242a != null) {
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (context != null) {
                        f242a = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static AdEventDispatcher<AdEvent> m59946c() {
        if (f246e == null) {
            synchronized (InternalContainer.class) {
                if (f246e == null) {
                    f246e = new AdEventDispatcher<>("V3", new AdEventRepertoryImpl(f242a), m59944e(), m59948b(), m59949a(f242a));
                }
            }
        }
        return f246e;
    }

    /* renamed from: d */
    public static Context m59945d() {
        if (f242a == null) {
            m59947b(null);
        }
        return f242a;
    }

    /* renamed from: e */
    public static ReportNetApi<AdEvent> m59944e() {
        if (f244c == null) {
            synchronized (InternalContainer.class) {
                if (f244c == null) {
                    f244c = new ReportNetApiImpl(f242a);
                }
            }
        }
        return f244c;
    }

    /* renamed from: f */
    public static TTSdkSettings m59943f() {
        if (f243b == null) {
            synchronized (TTSdkSettings.class) {
                if (f243b == null) {
                    f243b = new TTSdkSettings();
                }
            }
        }
        return f243b;
    }

    /* renamed from: b */
    private static AdEventThread.C0977b m59948b() {
        return AdEventThread.C0977b.m59333a();
    }

    /* renamed from: a */
    private static AdEventThread.InterfaceC0976a m59949a(Context context) {
        return new C0932a(context);
    }
}
