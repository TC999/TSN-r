package com.amap.api.col.p047s;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.p047s.AbstractC2044dz;
import com.amap.api.maps.AMapException;

/* compiled from: NetManger.java */
/* renamed from: com.amap.api.col.s.z2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2227z2 extends C2163u2 {

    /* renamed from: h */
    private static C2227z2 f6827h;

    /* renamed from: g */
    private Handler f6828g;

    /* compiled from: NetManger.java */
    /* renamed from: com.amap.api.col.s.z2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class HandlerC2228a extends Handler {
        /* synthetic */ HandlerC2228a(Looper looper, byte b) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i = message.what;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private HandlerC2228a(Looper looper) {
            super(looper);
        }

        public HandlerC2228a() {
        }
    }

    private C2227z2() {
        try {
            if (Looper.myLooper() == null) {
                this.f6828g = new HandlerC2228a(Looper.getMainLooper(), (byte) 0);
            } else {
                this.f6828g = new HandlerC2228a();
            }
        } catch (Throwable th) {
            C2060g2.m52972o(th, "NetManger", "NetManger1");
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    private static C2021b3 m52176e(AbstractC2044dz abstractC2044dz, AbstractC2044dz.EnumC2046b enumC2046b, int i) throws C2022bv {
        try {
            C2163u2.m52420k(abstractC2044dz);
            abstractC2044dz.m53062f(enumC2046b);
            abstractC2044dz.m53058l(i);
            return new C2202x2().m52310d(abstractC2044dz);
        } catch (C2022bv e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new C2022bv(AMapException.ERROR_UNKNOWN);
        }
    }

    @Deprecated
    /* renamed from: j */
    private static C2021b3 m52175j(AbstractC2044dz abstractC2044dz, boolean z) throws C2022bv {
        byte[] bArr;
        C2163u2.m52420k(abstractC2044dz);
        abstractC2044dz.m53061g(z ? AbstractC2044dz.EnumC2047c.HTTPS : AbstractC2044dz.EnumC2047c.HTTP);
        C2021b3 c2021b3 = null;
        long j = 0;
        boolean z2 = false;
        if (C2163u2.m52424g(abstractC2044dz)) {
            boolean m52422i = C2163u2.m52422i(abstractC2044dz);
            try {
                j = SystemClock.elapsedRealtime();
                c2021b3 = m52176e(abstractC2044dz, C2163u2.m52428c(abstractC2044dz, m52422i), C2163u2.m52423h(abstractC2044dz, m52422i));
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
                return m52176e(abstractC2044dz, C2163u2.m52425f(abstractC2044dz, z2), C2163u2.m52430a(abstractC2044dz, j));
            } catch (C2022bv e2) {
                throw e2;
            }
        }
        return c2021b3;
    }

    /* renamed from: l */
    public static C2227z2 m52174l() {
        return m52173m();
    }

    /* renamed from: m */
    private static synchronized C2227z2 m52173m() {
        C2227z2 c2227z2;
        synchronized (C2227z2.class) {
            try {
                if (f6827h == null) {
                    f6827h = new C2227z2();
                }
                c2227z2 = f6827h;
            }
        }
        return c2227z2;
    }

    /* renamed from: n */
    public static C2021b3 m52172n(AbstractC2044dz abstractC2044dz) throws C2022bv {
        return m52175j(abstractC2044dz, abstractC2044dz.m53049z());
    }
}
