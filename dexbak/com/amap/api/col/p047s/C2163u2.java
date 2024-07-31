package com.amap.api.col.p047s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p047s.AbstractC2044dz;
import com.amap.api.maps.AMapException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* compiled from: BaseNetManager.java */
/* renamed from: com.amap.api.col.s.u2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2163u2 {

    /* renamed from: a */
    public static int f6547a = 0;

    /* renamed from: b */
    public static String f6548b = "";

    /* renamed from: c */
    public static HashMap<String, String> f6549c;

    /* renamed from: d */
    public static HashMap<String, String> f6550d;

    /* renamed from: e */
    public static HashMap<String, String> f6551e;

    /* renamed from: f */
    private static C2163u2 f6552f;

    /* compiled from: BaseNetManager.java */
    /* renamed from: com.amap.api.col.s.u2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2164a {
        /* renamed from: a */
        URLConnection m52419a();
    }

    public C2163u2() {
        C2212y0.m52244I();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static int m52430a(AbstractC2044dz abstractC2044dz, long j) {
        try {
            m52420k(abstractC2044dz);
            long j2 = 0;
            if (j != 0) {
                j2 = SystemClock.elapsedRealtime() - j;
            }
            int m53054u = abstractC2044dz.m53054u();
            if (abstractC2044dz.m53052w() != AbstractC2044dz.EnumC2045a.FIX && abstractC2044dz.m53052w() != AbstractC2044dz.EnumC2045a.SINGLE) {
                long j3 = m53054u;
                if (j2 < j3) {
                    long j4 = j3 - j2;
                    if (j4 >= 1000) {
                        return (int) j4;
                    }
                }
                return Math.min(1000, abstractC2044dz.m53054u());
            }
            return m53054u;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    /* renamed from: b */
    public static C2163u2 m52429b() {
        if (f6552f == null) {
            f6552f = new C2163u2();
        }
        return f6552f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public static AbstractC2044dz.EnumC2046b m52428c(AbstractC2044dz abstractC2044dz, boolean z) {
        if (abstractC2044dz.m53052w() == AbstractC2044dz.EnumC2045a.FIX) {
            return AbstractC2044dz.EnumC2046b.FIX_NONDEGRADE;
        }
        if (abstractC2044dz.m53052w() == AbstractC2044dz.EnumC2045a.SINGLE) {
            return AbstractC2044dz.EnumC2046b.NEVER_GRADE;
        }
        return z ? AbstractC2044dz.EnumC2046b.FIRST_NONDEGRADE : AbstractC2044dz.EnumC2046b.NEVER_GRADE;
    }

    /* renamed from: d */
    public static C2021b3 m52427d(AbstractC2044dz abstractC2044dz) throws C2022bv {
        return m52421j(abstractC2044dz, abstractC2044dz.m53049z());
    }

    /* renamed from: e */
    private static C2021b3 m52426e(AbstractC2044dz abstractC2044dz, AbstractC2044dz.EnumC2046b enumC2046b, int i) throws C2022bv {
        try {
            m52420k(abstractC2044dz);
            abstractC2044dz.m53062f(enumC2046b);
            abstractC2044dz.m53058l(i);
            return new C2202x2().m52299o(abstractC2044dz);
        } catch (C2022bv e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new C2022bv(AMapException.ERROR_UNKNOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public static AbstractC2044dz.EnumC2046b m52425f(AbstractC2044dz abstractC2044dz, boolean z) {
        return abstractC2044dz.m53052w() == AbstractC2044dz.EnumC2045a.FIX ? z ? AbstractC2044dz.EnumC2046b.FIX_DEGRADE_BYERROR : AbstractC2044dz.EnumC2046b.FIX_DEGRADE_ONLY : z ? AbstractC2044dz.EnumC2046b.DEGRADE_BYERROR : AbstractC2044dz.EnumC2046b.DEGRADE_ONLY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public static boolean m52424g(AbstractC2044dz abstractC2044dz) throws C2022bv {
        m52420k(abstractC2044dz);
        try {
            String mo52200a = abstractC2044dz.mo52200a();
            if (TextUtils.isEmpty(mo52200a)) {
                return false;
            }
            String host = new URL(mo52200a).getHost();
            if (!TextUtils.isEmpty(abstractC2044dz.mo52198r())) {
                host = abstractC2044dz.mo52198r();
            }
            return C2212y0.m52235R(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public static int m52423h(AbstractC2044dz abstractC2044dz, boolean z) {
        try {
            m52420k(abstractC2044dz);
            int m53054u = abstractC2044dz.m53054u();
            int i = C2212y0.f6770s;
            if (abstractC2044dz.m53052w() != AbstractC2044dz.EnumC2045a.FIX) {
                if (abstractC2044dz.m53052w() != AbstractC2044dz.EnumC2045a.SINGLE && m53054u >= i && z) {
                    return i;
                }
            }
            return m53054u;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public static boolean m52422i(AbstractC2044dz abstractC2044dz) throws C2022bv {
        m52420k(abstractC2044dz);
        if (m52424g(abstractC2044dz)) {
            if (abstractC2044dz.mo52180h().equals(abstractC2044dz.mo52200a()) || abstractC2044dz.m53052w() == AbstractC2044dz.EnumC2045a.SINGLE) {
                return false;
            }
            return C2212y0.f6774w;
        }
        return true;
    }

    @Deprecated
    /* renamed from: j */
    private static C2021b3 m52421j(AbstractC2044dz abstractC2044dz, boolean z) throws C2022bv {
        byte[] bArr;
        m52420k(abstractC2044dz);
        abstractC2044dz.m53061g(z ? AbstractC2044dz.EnumC2047c.HTTPS : AbstractC2044dz.EnumC2047c.HTTP);
        C2021b3 c2021b3 = null;
        long j = 0;
        boolean z2 = false;
        if (m52424g(abstractC2044dz)) {
            boolean m52422i = m52422i(abstractC2044dz);
            try {
                j = SystemClock.elapsedRealtime();
                c2021b3 = m52426e(abstractC2044dz, m52428c(abstractC2044dz, m52422i), m52423h(abstractC2044dz, m52422i));
            } catch (C2022bv e) {
                if (e.m53210f() == 21 && abstractC2044dz.m53052w() == AbstractC2044dz.EnumC2045a.INTERRUPT_IO) {
                    throw e;
                }
                if (!m52422i) {
                    throw e;
                }
                z2 = true;
            }
        }
        if (c2021b3 == null || (bArr = c2021b3.f5893a) == null || bArr.length <= 0) {
            try {
                return m52426e(abstractC2044dz, m52425f(abstractC2044dz, z2), m52430a(abstractC2044dz, j));
            } catch (C2022bv e2) {
                throw e2;
            }
        }
        return c2021b3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public static void m52420k(AbstractC2044dz abstractC2044dz) throws C2022bv {
        if (abstractC2044dz != null) {
            if (abstractC2044dz.mo52180h() == null || "".equals(abstractC2044dz.mo52180h())) {
                throw new C2022bv("request url is empty");
            }
            return;
        }
        throw new C2022bv("requeust is null");
    }
}
