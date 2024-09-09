package com.kwad.framework.filedownloader.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public static boolean bF(int i4) {
        return i4 < 0;
    }

    public static boolean bG(int i4) {
        return i4 > 0;
    }

    public static boolean f(com.kwad.framework.filedownloader.a aVar) {
        return aVar.tV() == 0 || aVar.tV() == 3;
    }

    public static boolean t(int i4, int i5) {
        if ((i4 == 3 || i4 == 5 || i4 != i5) && !bF(i4)) {
            if (i4 <= 0 || i4 > 6 || i5 < 10 || i5 > 11) {
                if (i4 == 1) {
                    return i5 != 0;
                } else if (i4 == 2) {
                    return (i5 == 0 || i5 == 1 || i5 == 6) ? false : true;
                } else if (i4 == 3) {
                    return (i5 == 0 || i5 == 1 || i5 == 2 || i5 == 6) ? false : true;
                } else if (i4 == 5) {
                    return (i5 == 1 || i5 == 6) ? false : true;
                } else if (i4 != 6) {
                    return true;
                } else {
                    return (i5 == 0 || i5 == 1) ? false : true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean u(int i4, int i5) {
        if ((i4 == 3 || i4 == 5 || i4 != i5) && !bF(i4)) {
            if (i5 == -2 || i5 == -1) {
                return true;
            }
            if (i4 == 0) {
                return i5 == 10;
            } else if (i4 == 1) {
                return i5 == 6;
            } else if (i4 == 2 || i4 == 3) {
                return i5 == -3 || i5 == 3 || i5 == 5;
            } else if (i4 == 5 || i4 == 6) {
                return i5 == 2 || i5 == 5;
            } else if (i4 == 10) {
                return i5 == 11;
            } else if (i4 != 11) {
                return false;
            } else {
                return i5 == -4 || i5 == -3 || i5 == 1;
            }
        }
        return false;
    }
}
