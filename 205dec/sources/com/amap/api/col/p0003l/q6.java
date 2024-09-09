package com.amap.api.col.p0003l;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003l.Cif;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaseNetManager.java */
/* renamed from: com.amap.api.col.3l.q6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class q6 {

    /* renamed from: a  reason: collision with root package name */
    public static int f8834a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static String f8835b = "";

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, String> f8836c;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, String> f8837d;

    /* renamed from: e  reason: collision with root package name */
    public static HashMap<String, String> f8838e;

    /* renamed from: f  reason: collision with root package name */
    private static q6 f8839f;

    /* compiled from: BaseNetManager.java */
    /* renamed from: com.amap.api.col.3l.q6$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        URLConnection a();
    }

    public q6() {
        g4.O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(Cif cif, long j4) {
        try {
            k(cif);
            long j5 = 0;
            if (j4 != 0) {
                j5 = SystemClock.elapsedRealtime() - j4;
            }
            int conntectionTimeout = cif.getConntectionTimeout();
            if (cif.getDegradeAbility() != Cif.a.FIX && cif.getDegradeAbility() != Cif.a.SINGLE) {
                long j6 = conntectionTimeout;
                if (j5 < j6) {
                    long j7 = j6 - j5;
                    if (j7 >= 1000) {
                        return (int) j7;
                    }
                }
                return Math.min(1000, cif.getConntectionTimeout());
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    public static q6 b() {
        if (f8839f == null) {
            f8839f = new q6();
        }
        return f8839f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Cif.b c(Cif cif, boolean z3) {
        if (cif.getDegradeAbility() == Cif.a.FIX) {
            return Cif.b.FIX_NONDEGRADE;
        }
        if (cif.getDegradeAbility() == Cif.a.SINGLE) {
            return Cif.b.NEVER_GRADE;
        }
        return z3 ? Cif.b.FIRST_NONDEGRADE : Cif.b.NEVER_GRADE;
    }

    public static y6 d(Cif cif) throws fk {
        return j(cif, cif.isHttps());
    }

    private static y6 e(Cif cif, Cif.b bVar, int i4) throws fk {
        try {
            k(cif);
            cif.setDegradeType(bVar);
            cif.setReal_max_timeout(i4);
            return new v6().x(cif);
        } catch (fk e4) {
            throw e4;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new fk("\u672a\u77e5\u7684\u9519\u8bef");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Cif.b f(Cif cif, boolean z3) {
        return cif.getDegradeAbility() == Cif.a.FIX ? z3 ? Cif.b.FIX_DEGRADE_BYERROR : Cif.b.FIX_DEGRADE_ONLY : z3 ? Cif.b.DEGRADE_BYERROR : Cif.b.DEGRADE_ONLY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean g(Cif cif) throws fk {
        k(cif);
        try {
            String ipv6url = cif.getIPV6URL();
            if (TextUtils.isEmpty(ipv6url)) {
                return false;
            }
            String host = new URL(ipv6url).getHost();
            if (!TextUtils.isEmpty(cif.getIPDNSName())) {
                host = cif.getIPDNSName();
            }
            return g4.U(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int h(Cif cif, boolean z3) {
        try {
            k(cif);
            int conntectionTimeout = cif.getConntectionTimeout();
            int i4 = g4.f7827s;
            if (cif.getDegradeAbility() != Cif.a.FIX) {
                if (cif.getDegradeAbility() != Cif.a.SINGLE && conntectionTimeout >= i4 && z3) {
                    return i4;
                }
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean i(Cif cif) throws fk {
        k(cif);
        if (g(cif)) {
            if (cif.getURL().equals(cif.getIPV6URL()) || cif.getDegradeAbility() == Cif.a.SINGLE) {
                return false;
            }
            return g4.f7831w;
        }
        return true;
    }

    @Deprecated
    private static y6 j(Cif cif, boolean z3) throws fk {
        byte[] bArr;
        k(cif);
        cif.setHttpProtocol(z3 ? Cif.c.HTTPS : Cif.c.HTTP);
        y6 y6Var = null;
        long j4 = 0;
        boolean z4 = false;
        if (g(cif)) {
            boolean i4 = i(cif);
            try {
                j4 = SystemClock.elapsedRealtime();
                y6Var = e(cif, c(cif, i4), h(cif, i4));
            } catch (fk e4) {
                if (e4.f() == 21 && cif.getDegradeAbility() == Cif.a.INTERRUPT_IO) {
                    throw e4;
                }
                if (!i4) {
                    throw e4;
                }
                z4 = true;
            }
        }
        if (y6Var == null || (bArr = y6Var.f9524a) == null || bArr.length <= 0) {
            try {
                return e(cif, f(cif, z4), a(cif, j4));
            } catch (fk e5) {
                throw e5;
            }
        }
        return y6Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void k(Cif cif) throws fk {
        if (cif != null) {
            if (cif.getURL() == null || "".equals(cif.getURL())) {
                throw new fk("request url is empty");
            }
            return;
        }
        throw new fk("requeust is null");
    }
}
