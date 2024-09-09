package com.amap.api.col.p0003l;

import android.graphics.Bitmap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PureScreenCheckTool.java */
/* renamed from: com.amap.api.col.3l.r2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class r2 {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f8859d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f8860e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f8861f;

    /* renamed from: a  reason: collision with root package name */
    private boolean f8862a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f8863b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f8864c = 20;

    public static void a(boolean z3) {
        f8859d = z3;
    }

    public static boolean b() {
        return f8859d;
    }

    public static void d(boolean z3) {
        f8860e = z3;
    }

    public static boolean e() {
        return f8860e;
    }

    public static void f(boolean z3) {
        f8861f = z3;
    }

    public static boolean g() {
        return f8861f;
    }

    public static void k() {
        u5.p(new Exception("BlackScreen"), "PureScreenCheckTool", "uploadInfo");
    }

    public final boolean c(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i4 = -1;
                for (int i5 = (int) (width / 4.0f); i5 < (width * 3) / 4.0f; i5++) {
                    for (int i6 = (int) (height / 4.0f); i6 < (height * 3) / 4.0f; i6++) {
                        int pixel = bitmap.getPixel(i5, i6);
                        if (i4 == -1) {
                            i4 = pixel;
                        }
                        if (pixel != i4) {
                            return false;
                        }
                        if (pixel != -16777216) {
                            return false;
                        }
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return true;
    }

    public final boolean h() {
        return this.f8862a;
    }

    public final void i() {
        this.f8863b++;
    }

    public final boolean j() {
        return this.f8863b >= this.f8864c;
    }
}
