package com.amap.api.col.p0003l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.y7;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NetManger.java */
/* renamed from: com.amap.api.col.3l.x6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x6 extends q6 {

    /* renamed from: i  reason: collision with root package name */
    private static x6 f9428i;

    /* renamed from: g  reason: collision with root package name */
    private z7 f9429g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f9430h;

    /* compiled from: NetManger.java */
    /* renamed from: com.amap.api.col.3l.x6$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class a extends Handler {
        /* synthetic */ a(Looper looper, byte b4) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i4 = message.what;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }
    }

    private x6(boolean z3) {
        if (z3) {
            try {
                this.f9429g = z7.i(new y7.b().c("amap-netmanger-threadpool-%d").h());
            } catch (Throwable th) {
                u5.p(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f9430h = new a(Looper.getMainLooper(), (byte) 0);
        } else {
            this.f9430h = new a();
        }
    }

    private static synchronized x6 l(boolean z3) {
        x6 x6Var;
        synchronized (x6.class) {
            try {
                x6 x6Var2 = f9428i;
                if (x6Var2 == null) {
                    f9428i = new x6(z3);
                } else if (z3 && x6Var2.f9429g == null) {
                    x6Var2.f9429g = z7.i(new y7.b().c("amap-netmanger-threadpool-%d").h());
                }
                x6Var = f9428i;
            }
        }
        return x6Var;
    }

    private static Map<String, String> m(Cif cif, Cif.b bVar, int i4) throws fk {
        try {
            q6.k(cif);
            cif.setDegradeType(bVar);
            cif.setReal_max_timeout(i4);
            return new v6().j(cif);
        } catch (fk e4) {
            throw e4;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new fk("\u672a\u77e5\u7684\u9519\u8bef");
        }
    }

    public static x6 n() {
        return l(true);
    }

    private static y6 o(Cif cif, Cif.b bVar, int i4) throws fk {
        try {
            q6.k(cif);
            cif.setDegradeType(bVar);
            cif.setReal_max_timeout(i4);
            return new v6().q(cif);
        } catch (fk e4) {
            throw e4;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new fk("\u672a\u77e5\u7684\u9519\u8bef");
        }
    }

    public static x6 p() {
        return l(false);
    }

    @Deprecated
    public static Map<String, String> q(Cif cif, boolean z3) throws fk {
        q6.k(cif);
        cif.setHttpProtocol(z3 ? Cif.c.HTTPS : Cif.c.HTTP);
        Map<String, String> map = null;
        long j4 = 0;
        boolean z4 = false;
        if (q6.g(cif)) {
            boolean i4 = q6.i(cif);
            try {
                j4 = SystemClock.elapsedRealtime();
                map = m(cif, q6.c(cif, i4), q6.h(cif, i4));
            } catch (fk e4) {
                if (!i4) {
                    throw e4;
                }
                z4 = true;
            }
        }
        if (map == null) {
            try {
                return m(cif, q6.f(cif, z4), q6.a(cif, j4));
            } catch (fk e5) {
                throw e5;
            }
        }
        return map;
    }

    public static y6 r(Cif cif) throws fk {
        return s(cif, cif.isHttps());
    }

    @Deprecated
    private static y6 s(Cif cif, boolean z3) throws fk {
        byte[] bArr;
        q6.k(cif);
        cif.setHttpProtocol(z3 ? Cif.c.HTTPS : Cif.c.HTTP);
        y6 y6Var = null;
        long j4 = 0;
        boolean z4 = false;
        if (q6.g(cif)) {
            boolean i4 = q6.i(cif);
            try {
                j4 = SystemClock.elapsedRealtime();
                y6Var = o(cif, q6.c(cif, i4), q6.h(cif, i4));
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
                return o(cif, q6.f(cif, z4), q6.a(cif, j4));
            } catch (fk e5) {
                throw e5;
            }
        }
        return y6Var;
    }
}
