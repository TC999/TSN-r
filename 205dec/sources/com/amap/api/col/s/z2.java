package com.amap.api.col.s;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.s.dz;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NetManger.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class z2 extends u2 {

    /* renamed from: h  reason: collision with root package name */
    private static z2 f10550h;

    /* renamed from: g  reason: collision with root package name */
    private Handler f10551g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: NetManger.java */
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

    private z2() {
        try {
            if (Looper.myLooper() == null) {
                this.f10551g = new a(Looper.getMainLooper(), (byte) 0);
            } else {
                this.f10551g = new a();
            }
        } catch (Throwable th) {
            g2.o(th, "NetManger", "NetManger1");
            th.printStackTrace();
        }
    }

    private static b3 e(dz dzVar, dz.b bVar, int i4) throws bv {
        try {
            u2.k(dzVar);
            dzVar.f(bVar);
            dzVar.l(i4);
            return new x2().d(dzVar);
        } catch (bv e4) {
            throw e4;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bv("\u672a\u77e5\u7684\u9519\u8bef");
        }
    }

    @Deprecated
    private static b3 j(dz dzVar, boolean z3) throws bv {
        byte[] bArr;
        u2.k(dzVar);
        dzVar.g(z3 ? dz.c.HTTPS : dz.c.HTTP);
        b3 b3Var = null;
        long j4 = 0;
        boolean z4 = false;
        if (u2.g(dzVar)) {
            boolean i4 = u2.i(dzVar);
            try {
                j4 = SystemClock.elapsedRealtime();
                b3Var = e(dzVar, u2.c(dzVar, i4), u2.h(dzVar, i4));
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
                return e(dzVar, u2.f(dzVar, z4), u2.a(dzVar, j4));
            } catch (bv e5) {
                throw e5;
            }
        }
        return b3Var;
    }

    public static z2 l() {
        return m();
    }

    private static synchronized z2 m() {
        z2 z2Var;
        synchronized (z2.class) {
            try {
                if (f10550h == null) {
                    f10550h = new z2();
                }
                z2Var = f10550h;
            }
        }
        return z2Var;
    }

    public static b3 n(dz dzVar) throws bv {
        return j(dzVar, dzVar.z());
    }
}
