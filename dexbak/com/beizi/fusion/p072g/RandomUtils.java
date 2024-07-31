package com.beizi.fusion.p072g;

/* renamed from: com.beizi.fusion.g.al */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RandomUtils {
    /* renamed from: a */
    public static boolean m48438a(int i) {
        return ((int) ((Math.random() * 100.0d) + 1.0d)) <= i;
    }

    /* renamed from: b */
    public static int m48436b(int i) {
        double random = Math.random();
        double d = i;
        Double.isNaN(d);
        return (int) ((random * d) + 1.0d);
    }

    /* renamed from: a */
    public static int[] m48437a(int i, int i2) {
        double d;
        double d2;
        int[] iArr = new int[2];
        boolean z = false;
        while (!z) {
            Double.isNaN(i * 2);
            double rint = Math.rint(m48435b(0, (int) (d * 0.95d)));
            Double.isNaN(i2 * 2);
            double rint2 = Math.rint(m48435b(0, (int) (d2 * 0.95d)));
            double d3 = i;
            double d4 = i2;
            Double.isNaN(d3);
            Double.isNaN(d4);
            if (m48439a(d3, d4, rint, rint2, d3 * 0.9d, d4 * 0.9d) <= 1.0d) {
                iArr[0] = (int) rint;
                iArr[1] = (int) rint2;
                z = true;
            }
        }
        return iArr;
    }

    /* renamed from: b */
    private static int m48435b(int i, int i2) {
        double random = Math.random();
        double d = i2 - i;
        Double.isNaN(d);
        double d2 = i;
        Double.isNaN(d2);
        return (int) ((random * d) + d2);
    }

    /* renamed from: a */
    private static double m48439a(double d, double d2, double d3, double d4, double d5, double d6) {
        return (Math.pow(d3 - d, 2.0d) / Math.pow(d5, 2.0d)) + (Math.pow(d4 - d2, 2.0d) / Math.pow(d6, 2.0d));
    }
}
