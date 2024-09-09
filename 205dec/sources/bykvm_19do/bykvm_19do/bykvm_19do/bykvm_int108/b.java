package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.c;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.i;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.f;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.k;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.t;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.v;
import com.bytedance.msdk.adapter.ThirdSdkInit;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: InitHelper.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a f620a;

    /* renamed from: b  reason: collision with root package name */
    private static long f621b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f622c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InitHelper.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f623a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f624b;

        /* compiled from: InitHelper.java */
        /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        class C0026a implements c {
            C0026a() {
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.c
            public void a() {
                c cVar = a.this.f624b;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }

        a(Context context, c cVar) {
            this.f623a = context;
            this.f624b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ThirdSdkInit.initTTPangleSDK(this.f623a);
            b.b();
            Set<String> a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().a();
            Set<String> classNamesSet = DefaultAdapterClasses.getClassNamesSet();
            classNamesSet.addAll(a4);
            Map<String, Map<String, String>> h4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().h();
            b.b(h4);
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a5 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("klevin");
            if (a5 != null) {
                ThirdSdkInit.initTTKlevinSDK(this.f623a, a5.a());
            }
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a6 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("mintegral");
            if (a6 != null) {
                ThirdSdkInit.initTTMintergralSDK(this.f623a, a6.a(), a6.b());
            }
            Map<String, Map<String, String>> r3 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().r();
            if (this.f624b != null) {
                b.f620a.a(this.f623a, classNamesSet, h4, r3, new C0026a());
            } else {
                b.f620a.a(this.f623a, classNamesSet, h4, r3, null);
            }
        }
    }

    public static void b() {
        if (f620a == null) {
            synchronized (b.class) {
                if (f620a == null) {
                    f620a = new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a();
                }
            }
        }
    }

    public static Map<String, ITTAdapterConfiguration> c() {
        b();
        return f620a.a();
    }

    public static long d() {
        return f621b;
    }

    private static void e() {
        try {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a();
        } catch (Throwable th) {
            Logger.e("TTMediationSDK", "InitHelper-->initSetting->loadData Exception=" + th.toString());
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_else10.b.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f()).a();
    }

    private static void f() {
        Context d4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d();
        if (d4 == null) {
            return;
        }
        try {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b.b().a().a(d4, false, true, new bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a(d4));
        } catch (Exception unused) {
        }
    }

    public static boolean g() {
        return f622c;
    }

    public static void a(Activity activity) {
        ThirdSdkInit.initUnitySDK(activity);
    }

    public static String a(Map<String, Object> map, String str) {
        b();
        return f620a.a(bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d(), map, str);
    }

    public static void a(Context context) {
        f622c = true;
        f621b = SystemClock.elapsedRealtime();
        t.a(context);
        b(context);
        k.m(context);
        f();
        e();
        v.c();
        f.c().b();
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.a().a();
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.c().a();
        i.b().a();
    }

    public static void b(Context context) {
        if (context != null) {
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map<String, Map<String, String>> map) {
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a4;
        String a5;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        String a6;
        Class<?> cls4;
        String a7;
        Class<?> cls5;
        String a8;
        Class<?> cls6;
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a9 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("pangle");
        String a10 = a9 != null ? a9.a() : null;
        if (TextUtils.isEmpty(a10)) {
            a10 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().c();
        }
        Class<?> cls7 = DefaultAdapterClasses.getClass("pangle");
        if (cls7 != null && !TextUtils.isEmpty(a10)) {
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", a10);
            map.put(cls7.getName(), hashMap);
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a11 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("baidu");
        if (a11 != null && (a8 = a11.a()) != null && (cls6 = DefaultAdapterClasses.getClass("baidu")) != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("app_id", a8);
            hashMap2.put(TTBaseAdapterConfiguration.BAIDU_IS_READ_DEVICE_ID, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().d() ? "true" : "false");
            map.put(cls6.getName(), hashMap2);
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a12 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("admob");
        if (a12 != null && (a7 = a12.a()) != null && (cls5 = DefaultAdapterClasses.getClass("admob")) != null) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("app_id", a7);
            map.put(cls5.getName(), hashMap3);
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a13 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("gdt");
        if (a13 != null && (a6 = a13.a()) != null && (cls4 = DefaultAdapterClasses.getClass("gdt")) != null) {
            HashMap hashMap4 = new HashMap();
            hashMap4.put("app_id", a6);
            map.put(cls4.getName(), hashMap4);
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a14 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("sigmob");
        if (a14 != null) {
            String a15 = a14.a();
            String b4 = a14.b();
            if (a15 != null && b4 != null && (cls3 = DefaultAdapterClasses.getClass("sigmob")) != null) {
                HashMap hashMap5 = new HashMap();
                hashMap5.put("app_id", a15);
                hashMap5.put("app_key", b4);
                map.put(cls3.getName(), hashMap5);
            }
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a16 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("klevin");
        if (a16 != null) {
            String a17 = a16.a();
            if (!TextUtils.isEmpty(a17) && (cls2 = DefaultAdapterClasses.getClass("klevin")) != null) {
                HashMap hashMap6 = new HashMap();
                hashMap6.put("app_id", a17);
                map.put(cls2.getName(), hashMap6);
            }
        }
        bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a a18 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("ks");
        if (a18 != null && (a5 = a18.a()) != null && (cls = DefaultAdapterClasses.getClass("ks")) != null) {
            HashMap hashMap7 = new HashMap();
            hashMap7.put("app_id", a5);
            hashMap7.put("app_name", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().g());
            map.put(cls.getName(), hashMap7);
        }
        Class<?> cls8 = DefaultAdapterClasses.getClass("mintegral");
        if (cls8 == null || (a4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().a("mintegral")) == null) {
            return;
        }
        String a19 = a4.a();
        String b5 = a4.b();
        HashMap hashMap8 = new HashMap();
        hashMap8.put("app_id", a19);
        hashMap8.put("app_key", b5);
        map.put(cls8.getName(), hashMap8);
    }

    public static void a(Context context, c cVar) {
        ThreadHelper.runOnUiThread(new a(context, cVar));
    }
}
