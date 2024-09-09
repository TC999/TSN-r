package com.beizi.fusion.g;

import android.view.MotionEvent;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RandomUtils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class am {

    /* compiled from: RegionClickUtil.java */
    /* renamed from: com.beizi.fusion.g.am$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (am.a(am.this) != null) {
                am.a(am.this).a(am.b(), am.c(), am.d(), am.e(), am.b(), am.c(), am.d(), am.e());
            }
        }
    }

    /* compiled from: RegionClickUtil.java */
    /* renamed from: com.beizi.fusion.g.am$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class AnonymousClass2 implements View.OnTouchListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    am.a(motionEvent.getX() + "");
                    am.b(motionEvent.getY() + "");
                    am.c(motionEvent.getRawX() + "");
                    am.d(motionEvent.getRawY() + "");
                    return false;
                }
                return false;
            } catch (Exception e4) {
                e4.printStackTrace();
                return false;
            }
        }
    }

    /* compiled from: RegionClickUtil.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public static boolean a(int i4) {
        return ((int) ((Math.random() * 100.0d) + 1.0d)) <= i4;
    }

    public static int b(int i4) {
        double random = Math.random();
        double d4 = i4;
        Double.isNaN(d4);
        return (int) ((random * d4) + 1.0d);
    }

    public static int[] a(int i4, int i5) {
        double d4;
        double d5;
        int[] iArr = new int[2];
        boolean z3 = false;
        while (!z3) {
            Double.isNaN(i4 * 2);
            double rint = Math.rint(b(0, (int) (d4 * 0.95d)));
            Double.isNaN(i5 * 2);
            double rint2 = Math.rint(b(0, (int) (d5 * 0.95d)));
            double d6 = i4;
            double d7 = i5;
            Double.isNaN(d6);
            Double.isNaN(d7);
            if (a(d6, d7, rint, rint2, d6 * 0.9d, d7 * 0.9d) <= 1.0d) {
                iArr[0] = (int) rint;
                iArr[1] = (int) rint2;
                z3 = true;
            }
        }
        return iArr;
    }

    private static int b(int i4, int i5) {
        double random = Math.random();
        double d4 = i5 - i4;
        Double.isNaN(d4);
        double d5 = i4;
        Double.isNaN(d5);
        return (int) ((random * d4) + d5);
    }

    private static double a(double d4, double d5, double d6, double d7, double d8, double d9) {
        return (Math.pow(d6 - d4, 2.0d) / Math.pow(d8, 2.0d)) + (Math.pow(d7 - d5, 2.0d) / Math.pow(d9, 2.0d));
    }
}
