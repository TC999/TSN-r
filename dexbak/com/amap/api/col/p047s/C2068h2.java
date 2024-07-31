package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Build;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ErrorLogManager.java */
/* renamed from: com.amap.api.col.s.h2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2068h2 {

    /* renamed from: a */
    private static WeakReference<C2032c3> f6151a = null;

    /* renamed from: b */
    private static boolean f6152b = true;

    /* renamed from: c */
    private static WeakReference<AbstractC2189v3> f6153c;

    /* renamed from: d */
    private static WeakReference<AbstractC2189v3> f6154d;

    /* renamed from: e */
    private static String[] f6155e = new String[10];

    /* renamed from: f */
    private static int f6156f;

    /* renamed from: g */
    private static boolean f6157g;

    /* renamed from: h */
    private static int f6158h;

    /* renamed from: i */
    private static C2073i1 f6159i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorLogManager.java */
    /* renamed from: com.amap.api.col.s.h2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2069a extends AbstractRunnableC2229z3 {

        /* renamed from: b */
        final /* synthetic */ Context f6160b;

        /* renamed from: c */
        final /* synthetic */ String f6161c;

        /* renamed from: d */
        final /* synthetic */ AbstractC2189v3 f6162d;

        C2069a(Context context, String str, AbstractC2189v3 abstractC2189v3) {
            this.f6160b = context;
            this.f6161c = str;
            this.f6162d = abstractC2189v3;
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            try {
                synchronized (C2068h2.class) {
                    C2032c3 m52901a = C2076i3.m52901a(C2068h2.f6151a);
                    C2076i3.m52897e(this.f6160b, m52901a, this.f6161c, 1000, 4096000, "1");
                    m52901a.f5976f = this.f6162d;
                    if (m52901a.f5977g == null) {
                        m52901a.f5977g = new C2095m3(new C2091l3(this.f6160b, new C2125q3(), new C2094m2(new C2108o2(new C2116p2())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", C2199x0.m52327i(this.f6160b), C2023c1.m53196H(), C2023c1.m53193K(this.f6160b), C2199x0.m52330f(this.f6160b), Build.MODEL, C2199x0.m52332d(this.f6160b), C2199x0.m52329g(this.f6160b), Build.VERSION.RELEASE));
                    }
                    m52901a.f5978h = 3600000;
                    C2042d3.m53084a(m52901a);
                }
            } catch (Throwable th) {
                C2060g2.m52972o(th, "lg", "pul");
            }
        }
    }

    /* renamed from: a */
    private static C2073i1 m52959a(String str) {
        List<C2073i1> m53024b = C2051e2.m53024b();
        if (m53024b == null) {
            m53024b = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (C2073i1 c2073i1 : m53024b) {
                if (C2051e2.m53020f(c2073i1.m52913i(), str)) {
                    return c2073i1;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return C2079j1.m52876a();
                } catch (C2022bv e) {
                    e.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    C2073i1 m52861p = C2079j1.m52861p();
                    m52861p.m52920b();
                    return m52861p;
                } catch (C2022bv e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0101 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x00f5 -> B:107:0x00f8). Please submit an issue!!! */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m52958b(java.util.List<com.amap.api.col.p047s.C2073i1> r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.C2068h2.m52958b(java.util.List):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static void m52956d(Context context) {
        String m52958b;
        C2073i1 c2073i1;
        List<C2073i1> m53024b = C2051e2.m53024b();
        if (m53024b == null || m53024b.size() == 0 || (m52958b = m52958b(m53024b)) == null || "".equals(m52958b) || (c2073i1 = f6159i) == null) {
            return;
        }
        m52955e(context, c2073i1, 2, "ANR", m52958b);
    }

    /* renamed from: e */
    private static void m52955e(Context context, C2073i1 c2073i1, int i, String str, String str2) {
        String str3;
        String m52900b = C2076i3.m52900b();
        String m52899c = C2076i3.m52899c(context, c2073i1);
        C2199x0.m52335a(context);
        String m52898d = C2076i3.m52898d(m52899c, m52900b, i, str, str2);
        if (m52898d == null || "".equals(m52898d)) {
            return;
        }
        String m52989d = C2059g1.m52989d(str2);
        if (i == 1) {
            str3 = C2051e2.f6091b;
        } else if (i == 2) {
            str3 = C2051e2.f6093d;
        } else if (i != 0) {
            return;
        } else {
            str3 = C2051e2.f6092c;
        }
        String str4 = str3;
        C2032c3 m52901a = C2076i3.m52901a(f6151a);
        C2076i3.m52897e(context, m52901a, str4, 1000, 4096000, "1");
        if (m52901a.f5975e == null) {
            m52901a.f5975e = new C2090l2(new C2094m2(new C2108o2(new C2116p2())));
        }
        try {
            C2042d3.m53082c(m52989d, C2079j1.m52862o(m52898d.replaceAll(ShellAdbUtils.f33810d, "<br/>")), m52901a);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    private static void m52954f(Context context, AbstractC2189v3 abstractC2189v3, String str) {
        C2225y3.m52184e().m53246c(new C2069a(context, str, abstractC2189v3));
    }

    /* renamed from: g */
    public static void m52953g(Context context, Throwable th, int i, String str, String str2) {
        String m52872e = C2079j1.m52872e(th);
        C2073i1 m52959a = m52959a(m52872e);
        if (m52951i(m52959a)) {
            String replaceAll = m52872e.replaceAll(ShellAdbUtils.f33810d, "<br/>");
            String th2 = th.toString();
            if (th2 == null || "".equals(th2)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append("class:");
                sb.append(str);
            }
            if (str2 != null) {
                sb.append(" method:");
                sb.append(str2);
                sb.append("$<br/>");
            }
            sb.append(replaceAll);
            m52955e(context, m52959a, i, th2, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static void m52952h(C2073i1 c2073i1, Context context, String str, String str2) {
        if (!m52951i(c2073i1) || str == null || "".equals(str)) {
            return;
        }
        m52955e(context, c2073i1, 1, str, str2);
    }

    /* renamed from: i */
    private static boolean m52951i(C2073i1 c2073i1) {
        return c2073i1 != null && c2073i1.m52914h();
    }

    /* renamed from: j */
    private static String m52950j() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = f6156f; i < 10 && i <= 9; i++) {
                sb.append(f6155e[i]);
            }
            for (int i2 = 0; i2 < f6156f; i2++) {
                sb.append(f6155e[i2]);
            }
        } catch (Throwable th) {
            C2060g2.m52972o(th, "alg", "gLI");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static void m52949k(Context context) {
        C2154t3 c2154t3 = new C2154t3(f6152b);
        f6152b = false;
        m52954f(context, c2154t3, C2051e2.f6092c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static void m52948l(Context context) {
        WeakReference<AbstractC2189v3> weakReference = f6153c;
        if (weakReference == null || weakReference.get() == null) {
            f6153c = new WeakReference<>(new C2165u3(context, 3600000, "hKey", new C2197w3(context)));
        }
        m52954f(context, f6153c.get(), C2051e2.f6093d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public static void m52947m(Context context) {
        WeakReference<AbstractC2189v3> weakReference = f6154d;
        if (weakReference == null || weakReference.get() == null) {
            f6154d = new WeakReference<>(new C2165u3(context, 3600000, "gKey", new C2197w3(context)));
        }
        m52954f(context, f6154d.get(), C2051e2.f6091b);
    }
}
