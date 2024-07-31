package com.amap.api.col.p0463l;

import android.graphics.Bitmap;

/* renamed from: com.amap.api.col.3l.r2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PureScreenCheckTool {

    /* renamed from: d */
    private static boolean f5153d;

    /* renamed from: e */
    private static boolean f5154e;

    /* renamed from: f */
    private static boolean f5155f;

    /* renamed from: a */
    private boolean f5156a = false;

    /* renamed from: b */
    private int f5157b = 0;

    /* renamed from: c */
    private int f5158c = 20;

    /* renamed from: a */
    public static void m54072a(boolean z) {
        f5153d = z;
    }

    /* renamed from: b */
    public static boolean m54071b() {
        return f5153d;
    }

    /* renamed from: d */
    public static void m54069d(boolean z) {
        f5154e = z;
    }

    /* renamed from: e */
    public static boolean m54068e() {
        return f5154e;
    }

    /* renamed from: f */
    public static void m54067f(boolean z) {
        f5155f = z;
    }

    /* renamed from: g */
    public static boolean m54066g() {
        return f5155f;
    }

    /* renamed from: k */
    public static void m54062k() {
        SDKLogHandler.m53863p(new Exception("BlackScreen"), "PureScreenCheckTool", "uploadInfo");
    }

    /* renamed from: c */
    public final boolean m54070c(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i = -1;
                for (int i2 = (int) (width / 4.0f); i2 < (width * 3) / 4.0f; i2++) {
                    for (int i3 = (int) (height / 4.0f); i3 < (height * 3) / 4.0f; i3++) {
                        int pixel = bitmap.getPixel(i2, i3);
                        if (i == -1) {
                            i = pixel;
                        }
                        if (pixel != i) {
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

    /* renamed from: h */
    public final boolean m54065h() {
        return this.f5156a;
    }

    /* renamed from: i */
    public final void m54064i() {
        this.f5157b++;
    }

    /* renamed from: j */
    public final boolean m54063j() {
        return this.f5157b >= this.f5158c;
    }
}
