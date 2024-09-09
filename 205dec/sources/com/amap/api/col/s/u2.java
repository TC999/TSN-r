package com.amap.api.col.s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.dz;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaseNetManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class u2 {

    /* renamed from: a  reason: collision with root package name */
    public static int f10275a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static String f10276b = "";

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, String> f10277c;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, String> f10278d;

    /* renamed from: e  reason: collision with root package name */
    public static HashMap<String, String> f10279e;

    /* renamed from: f  reason: collision with root package name */
    private static u2 f10280f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BaseNetManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        URLConnection a();
    }

    public u2() {
        y0.I();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(dz dzVar, long j4) {
        try {
            k(dzVar);
            long j5 = 0;
            if (j4 != 0) {
                j5 = SystemClock.elapsedRealtime() - j4;
            }
            int u3 = dzVar.u();
            if (dzVar.w() != dz.a.FIX && dzVar.w() != dz.a.SINGLE) {
                long j6 = u3;
                if (j5 < j6) {
                    long j7 = j6 - j5;
                    if (j7 >= 1000) {
                        return (int) j7;
                    }
                }
                return Math.min(1000, dzVar.u());
            }
            return u3;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    public static u2 b() {
        if (f10280f == null) {
            f10280f = new u2();
        }
        return f10280f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static dz.b c(dz dzVar, boolean z3) {
        if (dzVar.w() == dz.a.FIX) {
            return dz.b.FIX_NONDEGRADE;
        }
        if (dzVar.w() == dz.a.SINGLE) {
            return dz.b.NEVER_GRADE;
        }
        return z3 ? dz.b.FIRST_NONDEGRADE : dz.b.NEVER_GRADE;
    }

    public static b3 d(dz dzVar) throws bv {
        return j(dzVar, dzVar.z());
    }

    private static b3 e(dz dzVar, dz.b bVar, int i4) throws bv {
        try {
            k(dzVar);
            dzVar.f(bVar);
            dzVar.l(i4);
            return new x2().o(dzVar);
        } catch (bv e4) {
            throw e4;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bv("\u672a\u77e5\u7684\u9519\u8bef");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static dz.b f(dz dzVar, boolean z3) {
        return dzVar.w() == dz.a.FIX ? z3 ? dz.b.FIX_DEGRADE_BYERROR : dz.b.FIX_DEGRADE_ONLY : z3 ? dz.b.DEGRADE_BYERROR : dz.b.DEGRADE_ONLY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean g(dz dzVar) throws bv {
        k(dzVar);
        try {
            String a4 = dzVar.a();
            if (TextUtils.isEmpty(a4)) {
                return false;
            }
            String host = new URL(a4).getHost();
            if (!TextUtils.isEmpty(dzVar.r())) {
                host = dzVar.r();
            }
            return y0.R(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int h(dz dzVar, boolean z3) {
        try {
            k(dzVar);
            int u3 = dzVar.u();
            int i4 = y0.f10493s;
            if (dzVar.w() != dz.a.FIX) {
                if (dzVar.w() != dz.a.SINGLE && u3 >= i4 && z3) {
                    return i4;
                }
            }
            return u3;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean i(dz dzVar) throws bv {
        k(dzVar);
        if (g(dzVar)) {
            if (dzVar.h().equals(dzVar.a()) || dzVar.w() == dz.a.SINGLE) {
                return false;
            }
            return y0.f10497w;
        }
        return true;
    }

    @Deprecated
    private static b3 j(dz dzVar, boolean z3) throws bv {
        byte[] bArr;
        k(dzVar);
        dzVar.g(z3 ? dz.c.HTTPS : dz.c.HTTP);
        b3 b3Var = null;
        long j4 = 0;
        boolean z4 = false;
        if (g(dzVar)) {
            boolean i4 = i(dzVar);
            try {
                j4 = SystemClock.elapsedRealtime();
                b3Var = e(dzVar, c(dzVar, i4), h(dzVar, i4));
            } catch (bv e4) {
                if (e4.f() == 21 && dzVar.w() == dz.a.INTERRUPT_IO) {
                    throw e4;
                }
                if (!i4) {
                    throw e4;
                }
                z4 = true;
            }
        }
        if (b3Var == null || (bArr = b3Var.f9643a) == null || bArr.length <= 0) {
            try {
                return e(dzVar, f(dzVar, z4), a(dzVar, j4));
            } catch (bv e5) {
                throw e5;
            }
        }
        return b3Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void k(dz dzVar) throws bv {
        if (dzVar != null) {
            if (dzVar.h() == null || "".equals(dzVar.h())) {
                throw new bv("request url is empty");
            }
            return;
        }
        throw new bv("requeust is null");
    }
}
