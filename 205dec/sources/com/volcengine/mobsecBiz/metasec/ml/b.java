package com.volcengine.mobsecBiz.metasec.ml;

import android.graphics.Point;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.h1;
import ms.bz.bd.c.Pgl.n1;
import ms.bz.bd.c.Pgl.o0;
import ms.bz.bd.c.Pgl.p0;
import ms.bz.bd.c.Pgl.pblb;
import ms.bz.bd.c.Pgl.pbly;
import ms.bz.bd.c.Pgl.pgla;
import ms.bz.bd.c.Pgl.q0;
import ms.bz.bd.c.Pgl.s0;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class b {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class a extends pblb.pgla {
        a() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            return q0.a(pgla.a().c());
        }
    }

    /* renamed from: com.volcengine.mobsecBiz.metasec.ml.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class C1074b extends pblb.pgla {
        C1074b() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class c extends pblb.pgla {
        c() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            s0.c(pgla.a().c());
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class d extends pblb.pgla {
        d() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            return o0.b(pgla.a().c());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class e extends pblb.pgla {
        e() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class f extends pblb.pgla {
        f() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            return h1.a();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class g extends pblb.pgla {
        g() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            String str2;
            String str3;
            StringBuilder sb;
            WifiInfo connectionInfo;
            Class<?> cls;
            String str4 = "0";
            String str5 = "null";
            try {
                connectionInfo = ((WifiManager) pgla.a().c().getSystemService("wifi")).getConnectionInfo();
                cls = connectionInfo.getClass();
                Method declaredMethod = cls.getDeclaredMethod(new String(pbly.d("6765744253534944")), new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = (String) declaredMethod.invoke(connectionInfo, new Object[0]);
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod(new String(pbly.d("67657453534944")), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    str3 = (String) declaredMethod2.invoke(connectionInfo, new Object[0]);
                } catch (Throwable unused) {
                    str3 = null;
                }
            } catch (Throwable unused2) {
                str2 = null;
                str3 = null;
            }
            try {
                Method declaredMethod3 = cls.getDeclaredMethod(new String(pbly.d("676574497041646472657373")), new Class[0]);
                declaredMethod3.setAccessible(true);
                String num = Integer.toString(((Integer) declaredMethod3.invoke(connectionInfo, new Object[0])).intValue());
                String a4 = n1.a(str3);
                String a5 = n1.a(str2);
                String a6 = n1.a(num);
                sb = new StringBuilder();
                sb.append((a5 == null || a5.length() <= 0) ? "null" : a5.trim());
                sb.append("[<!>]");
                if (a4 != null && a4.length() > 0) {
                    str5 = a4.trim();
                }
                sb.append(str5);
                sb.append("[<!>]");
                if (a6 != null && a6.length() > 0) {
                    str4 = a6.trim();
                }
            } catch (Throwable unused3) {
                String a7 = n1.a(str3);
                String a8 = n1.a(str2);
                String a9 = n1.a(null);
                sb = new StringBuilder();
                sb.append((a8 == null || a8.length() <= 0) ? "null" : a8.trim());
                sb.append("[<!>]");
                if (a7 != null && a7.length() > 0) {
                    str5 = a7.trim();
                }
                sb.append(str5);
                sb.append("[<!>]");
                if (a9 != null && a9.length() > 0) {
                    str4 = a9.trim();
                }
                sb.append(str4);
                sb.append("[<!>]");
                return sb.toString().trim();
            }
            sb.append(str4);
            sb.append("[<!>]");
            return sb.toString().trim();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class h extends pblb.pgla {
        h() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            return q0.d(pgla.a().c());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class i extends pblb.pgla {
        i() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            return o0.a(pgla.a().c());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class j extends pblb.pgla {
        j() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            try {
                Display defaultDisplay = ((WindowManager) pgla.a().c().getSystemService("window")).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                p0.f61427a = point.x;
                p0.f61428b = point.y;
            } catch (Throwable unused) {
            }
            return p0.f61427a + "*" + p0.f61428b;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class k extends pblb.pgla {
        k() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class l extends pblb.pgla {
        l() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            return s0.c(pgla.a().c()).a();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class m extends pblb.pgla {
        m() {
        }

        @Override // ms.bz.bd.c.Pgl.pblb.pgla
        public Object b(int i4, long j4, String str, Object obj) throws Throwable {
            return q0.c(pgla.a().c());
        }
    }

    public static void a() {
        pblb.c(268435457, new j());
        pblb.c(268435458, new k());
        pblb.c(268435459, new e());
        pblb.c(268435460, new i());
        pblb.c(268435461, new d());
        pblb.c(268435462, new f());
        pblb.c(268435463, new h());
        pblb.c(268435464, new g());
        pblb.c(268435465, new a());
        pblb.c(268435466, new C1074b());
        pblb.c(268435467, new c());
        pblb.c(268435468, new l());
        pblb.c(268435469, new m());
    }
}
