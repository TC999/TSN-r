package com.facebook.rebound;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class OrigamiValueConverter {
    public static double a(double d4) {
        if (d4 == 0.0d) {
            return 0.0d;
        }
        return 25.0d + ((d4 - 8.0d) * 3.0d);
    }

    public static double b(double d4) {
        if (d4 == 0.0d) {
            return 0.0d;
        }
        return 8.0d + ((d4 - 25.0d) / 3.0d);
    }

    public static double c(double d4) {
        if (d4 == 0.0d) {
            return 0.0d;
        }
        return 30.0d + ((d4 - 194.0d) / 3.62d);
    }

    public static double d(double d4) {
        if (d4 == 0.0d) {
            return 0.0d;
        }
        return 194.0d + ((d4 - 30.0d) * 3.62d);
    }
}
