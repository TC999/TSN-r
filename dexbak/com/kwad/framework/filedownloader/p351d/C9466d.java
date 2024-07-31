package com.kwad.framework.filedownloader.p351d;

import com.kwad.framework.filedownloader.InterfaceC9427a;

/* renamed from: com.kwad.framework.filedownloader.d.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9466d {
    /* renamed from: bF */
    public static boolean m28676bF(int i) {
        return i < 0;
    }

    /* renamed from: bG */
    public static boolean m28675bG(int i) {
        return i > 0;
    }

    /* renamed from: f */
    public static boolean m28674f(InterfaceC9427a interfaceC9427a) {
        return interfaceC9427a.mo28739tV() == 0 || interfaceC9427a.mo28739tV() == 3;
    }

    /* renamed from: t */
    public static boolean m28673t(int i, int i2) {
        if ((i == 3 || i == 5 || i != i2) && !m28676bF(i)) {
            if (i <= 0 || i > 6 || i2 < 10 || i2 > 11) {
                if (i == 1) {
                    return i2 != 0;
                } else if (i == 2) {
                    return (i2 == 0 || i2 == 1 || i2 == 6) ? false : true;
                } else if (i == 3) {
                    return (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 6) ? false : true;
                } else if (i == 5) {
                    return (i2 == 1 || i2 == 6) ? false : true;
                } else if (i != 6) {
                    return true;
                } else {
                    return (i2 == 0 || i2 == 1) ? false : true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: u */
    public static boolean m28672u(int i, int i2) {
        if ((i == 3 || i == 5 || i != i2) && !m28676bF(i)) {
            if (i2 == -2 || i2 == -1) {
                return true;
            }
            if (i == 0) {
                return i2 == 10;
            } else if (i == 1) {
                return i2 == 6;
            } else if (i == 2 || i == 3) {
                return i2 == -3 || i2 == 3 || i2 == 5;
            } else if (i == 5 || i == 6) {
                return i2 == 2 || i2 == 5;
            } else if (i == 10) {
                return i2 == 11;
            } else if (i != 11) {
                return false;
            } else {
                return i2 == -4 || i2 == -3 || i2 == 1;
            }
        }
        return false;
    }
}
