package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: OfflineLocManager.java */
/* renamed from: com.amap.api.col.s.f3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2056f3 {

    /* renamed from: a */
    static int f6113a = 1000;

    /* renamed from: b */
    static boolean f6114b = false;

    /* renamed from: c */
    private static WeakReference<C2032c3> f6115c = null;

    /* renamed from: d */
    static int f6116d = 20;

    /* renamed from: e */
    private static int f6117e = 10;

    /* renamed from: f */
    static int f6118f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineLocManager.java */
    /* renamed from: com.amap.api.col.s.f3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2057a extends AbstractRunnableC2229z3 {

        /* renamed from: b */
        private int f6119b = 2;

        /* renamed from: c */
        private Context f6120c;

        /* renamed from: d */
        private C2053e3 f6121d;

        C2057a(Context context) {
            this.f6120c = context;
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            int i = this.f6119b;
            if (i == 1) {
                try {
                    synchronized (C2056f3.class) {
                        String l = Long.toString(System.currentTimeMillis());
                        C2032c3 m52901a = C2076i3.m52901a(C2056f3.f6115c);
                        C2076i3.m52897e(this.f6120c, m52901a, C2051e2.f6098i, C2056f3.f6113a, 2097152, "6");
                        if (m52901a.f5975e == null) {
                            m52901a.f5975e = new C2094m2(new C2108o2(new C2116p2(new C2108o2())));
                        }
                        C2042d3.m53082c(l, this.f6121d.m53015b(), m52901a);
                    }
                } catch (Throwable th) {
                    C2060g2.m52972o(th, "ofm", "aple");
                }
            } else if (i == 2) {
                try {
                    C2032c3 m52901a2 = C2076i3.m52901a(C2056f3.f6115c);
                    C2076i3.m52897e(this.f6120c, m52901a2, C2051e2.f6098i, C2056f3.f6113a, 2097152, "6");
                    m52901a2.f5978h = 14400000;
                    if (m52901a2.f5977g == null) {
                        m52901a2.f5977g = new C2095m3(new C2091l3(this.f6120c, new C2125q3(), new C2094m2(new C2108o2(new C2116p2())), new String(C2139s1.m52468c()), C2199x0.m52327i(this.f6120c), C2023c1.m53196H(), C2023c1.m53201C(), C2023c1.m53149y(this.f6120c), C2023c1.m53165i(), Build.MANUFACTURER, Build.DEVICE, C2023c1.m53191M(), C2199x0.m52330f(this.f6120c), Build.MODEL, C2199x0.m52329g(this.f6120c), C2199x0.m52332d(this.f6120c), C2023c1.m53151w(this.f6120c), C2023c1.m53164j(this.f6120c), String.valueOf(Build.VERSION.SDK_INT), C2105o1.m52718a(this.f6120c).m52717b()));
                    }
                    if (TextUtils.isEmpty(m52901a2.f5979i)) {
                        m52901a2.f5979i = "fKey";
                    }
                    Context context = this.f6120c;
                    m52901a2.f5976f = new C2165u3(context, m52901a2.f5978h, m52901a2.f5979i, new C2142s3(context, C2056f3.f6114b, C2056f3.f6117e * 1024, C2056f3.f6116d * 1024, "offLocKey", C2056f3.f6118f * 1024));
                    C2042d3.m53084a(m52901a2);
                } catch (Throwable th2) {
                    C2060g2.m52972o(th2, "ofm", "uold");
                }
            }
        }
    }

    /* renamed from: b */
    public static void m53008b(Context context) {
        C2225y3.m52184e().m53246c(new C2057a(context));
    }
}
