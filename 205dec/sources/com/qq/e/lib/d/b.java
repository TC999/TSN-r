package com.qq.e.lib.d;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.ArrayMap;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class b {

    /* renamed from: f  reason: collision with root package name */
    static final c f47382f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<d> f47383a;

    /* renamed from: b  reason: collision with root package name */
    private final List<com.qq.e.lib.d.d> f47384b;

    /* renamed from: d  reason: collision with root package name */
    private final SparseBooleanArray f47386d = new SparseBooleanArray();

    /* renamed from: c  reason: collision with root package name */
    private final Map<com.qq.e.lib.d.d, d> f47385c = new ArrayMap();

    /* renamed from: e  reason: collision with root package name */
    private final d f47387e = a();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements c {
        a() {
        }

        private boolean b(float[] fArr) {
            return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f;
        }

        private boolean c(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        @Override // com.qq.e.lib.d.b.c
        public boolean a(int i4, float[] fArr) {
            return (c(fArr) || a(fArr) || b(fArr)) ? false : true;
        }

        private boolean a(float[] fArr) {
            return fArr[2] <= 0.05f;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface c {
        boolean a(int i4, float[] fArr);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final int f47396a;

        /* renamed from: b  reason: collision with root package name */
        private final int f47397b;

        /* renamed from: c  reason: collision with root package name */
        private final int f47398c;

        /* renamed from: d  reason: collision with root package name */
        private final int f47399d;

        /* renamed from: e  reason: collision with root package name */
        private final int f47400e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f47401f;

        /* renamed from: g  reason: collision with root package name */
        private int f47402g;

        /* renamed from: h  reason: collision with root package name */
        private int f47403h;

        /* renamed from: i  reason: collision with root package name */
        private float[] f47404i;

        public d(int i4, int i5) {
            this.f47396a = Color.red(i4);
            this.f47397b = Color.green(i4);
            this.f47398c = Color.blue(i4);
            this.f47399d = i4;
            this.f47400e = i5;
        }

        private void a() {
            int d4;
            int d5;
            if (this.f47401f) {
                return;
            }
            int a4 = com.qq.e.lib.c.a.a(-1, this.f47399d, 4.5f);
            int a5 = com.qq.e.lib.c.a.a(-1, this.f47399d, 3.0f);
            if (a4 != -1 && a5 != -1) {
                this.f47403h = com.qq.e.lib.c.a.d(-1, a4);
                this.f47402g = com.qq.e.lib.c.a.d(-1, a5);
                this.f47401f = true;
                return;
            }
            int a6 = com.qq.e.lib.c.a.a(-16777216, this.f47399d, 4.5f);
            int a7 = com.qq.e.lib.c.a.a(-16777216, this.f47399d, 3.0f);
            if (a6 != -1 && a7 != -1) {
                this.f47403h = com.qq.e.lib.c.a.d(-16777216, a6);
                this.f47402g = com.qq.e.lib.c.a.d(-16777216, a7);
                this.f47401f = true;
                return;
            }
            if (a4 != -1) {
                d4 = com.qq.e.lib.c.a.d(-1, a4);
            } else {
                d4 = com.qq.e.lib.c.a.d(-16777216, a6);
            }
            this.f47403h = d4;
            if (a5 != -1) {
                d5 = com.qq.e.lib.c.a.d(-1, a5);
            } else {
                d5 = com.qq.e.lib.c.a.d(-16777216, a7);
            }
            this.f47402g = d5;
            this.f47401f = true;
        }

        public int b() {
            a();
            return this.f47403h;
        }

        public float[] c() {
            if (this.f47404i == null) {
                this.f47404i = new float[3];
            }
            com.qq.e.lib.c.a.a(this.f47396a, this.f47397b, this.f47398c, this.f47404i);
            return this.f47404i;
        }

        public int d() {
            return this.f47400e;
        }

        public int e() {
            return this.f47399d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f47400e == dVar.f47400e && this.f47399d == dVar.f47399d;
        }

        public int f() {
            a();
            return this.f47402g;
        }

        public int hashCode() {
            return (this.f47399d * 31) + this.f47400e;
        }

        public String toString() {
            return d.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + "] [HSL: " + Arrays.toString(c()) + "] [Population: " + this.f47400e + "] [Title Text: #" + Integer.toHexString(f()) + "] [Body Text: #" + Integer.toHexString(b()) + ']';
        }
    }

    b(List<d> list, List<com.qq.e.lib.d.d> list2) {
        this.f47383a = list;
        this.f47384b = list2;
    }

    private d a(com.qq.e.lib.d.d dVar) {
        d b4 = b(dVar);
        if (b4 != null && dVar.j()) {
            this.f47386d.append(b4.e(), true);
        }
        return b4;
    }

    void b() {
        int size = this.f47384b.size();
        for (int i4 = 0; i4 < size; i4++) {
            com.qq.e.lib.d.d dVar = this.f47384b.get(i4);
            dVar.k();
            this.f47385c.put(dVar, a(dVar));
        }
        this.f47386d.clear();
    }

    public d c() {
        return c(com.qq.e.lib.d.d.f47416j);
    }

    public d d() {
        return c(com.qq.e.lib.d.d.f47413g);
    }

    public d e() {
        return c(com.qq.e.lib.d.d.f47414h);
    }

    public d f() {
        return c(com.qq.e.lib.d.d.f47411e);
    }

    public d g() {
        return c(com.qq.e.lib.d.d.f47415i);
    }

    public d h() {
        return c(com.qq.e.lib.d.d.f47412f);
    }

    public d c(com.qq.e.lib.d.d dVar) {
        return this.f47385c.get(dVar);
    }

    private float a(d dVar, com.qq.e.lib.d.d dVar2) {
        float[] c4 = dVar.c();
        d dVar3 = this.f47387e;
        int d4 = dVar3 != null ? dVar3.d() : 1;
        return (dVar2.g() > 0.0f ? dVar2.g() * (1.0f - Math.abs(c4[1] - dVar2.i())) : 0.0f) + (dVar2.a() > 0.0f ? dVar2.a() * (1.0f - Math.abs(c4[2] - dVar2.h())) : 0.0f) + (dVar2.f() > 0.0f ? dVar2.f() * (dVar.d() / d4) : 0.0f);
    }

    private d b(com.qq.e.lib.d.d dVar) {
        int size = this.f47383a.size();
        float f4 = 0.0f;
        d dVar2 = null;
        for (int i4 = 0; i4 < size; i4++) {
            d dVar3 = this.f47383a.get(i4);
            if (b(dVar3, dVar)) {
                float a4 = a(dVar3, dVar);
                if (dVar2 == null || a4 > f4) {
                    dVar2 = dVar3;
                    f4 = a4;
                }
            }
        }
        return dVar2;
    }

    private boolean b(d dVar, com.qq.e.lib.d.d dVar2) {
        float[] c4 = dVar.c();
        return c4[1] >= dVar2.e() && c4[1] <= dVar2.c() && c4[2] >= dVar2.d() && c4[2] <= dVar2.b() && !this.f47386d.get(dVar.e());
    }

    private d a() {
        int size = this.f47383a.size();
        int i4 = Integer.MIN_VALUE;
        d dVar = null;
        for (int i5 = 0; i5 < size; i5++) {
            d dVar2 = this.f47383a.get(i5);
            if (dVar2.d() > i4) {
                i4 = dVar2.d();
                dVar = dVar2;
            }
        }
        return dVar;
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.lib.d.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class C0926b {

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f47388a;

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f47389b;

        /* renamed from: c  reason: collision with root package name */
        private final List<com.qq.e.lib.d.d> f47390c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private int f47391d = 16;

        /* renamed from: e  reason: collision with root package name */
        private int f47392e = 12544;

        /* renamed from: f  reason: collision with root package name */
        private int f47393f = -1;

        /* renamed from: g  reason: collision with root package name */
        private final List<c> f47394g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        private Rect f47395h;

        public C0926b(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f47394g.add(b.f47382f);
                this.f47389b = bitmap;
                this.f47388a = null;
                this.f47390c.add(com.qq.e.lib.d.d.f47411e);
                this.f47390c.add(com.qq.e.lib.d.d.f47412f);
                this.f47390c.add(com.qq.e.lib.d.d.f47413g);
                this.f47390c.add(com.qq.e.lib.d.d.f47414h);
                this.f47390c.add(com.qq.e.lib.d.d.f47415i);
                this.f47390c.add(com.qq.e.lib.d.d.f47416j);
                return;
            }
            throw new IllegalArgumentException("Bitmap is not valid");
        }

        private Bitmap b(Bitmap bitmap) {
            int max;
            int i4;
            double d4;
            if (this.f47392e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i5 = this.f47392e;
                if (width > i5) {
                    double d5 = i5;
                    double d6 = width;
                    Double.isNaN(d5);
                    Double.isNaN(d6);
                    d4 = Math.sqrt(d5 / d6);
                }
                d4 = -1.0d;
            } else {
                if (this.f47393f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i4 = this.f47393f)) {
                    double d7 = i4;
                    double d8 = max;
                    Double.isNaN(d7);
                    Double.isNaN(d8);
                    d4 = d7 / d8;
                }
                d4 = -1.0d;
            }
            if (d4 <= 0.0d) {
                return bitmap;
            }
            double width2 = bitmap.getWidth();
            Double.isNaN(width2);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(width2 * d4), (int) Math.ceil(height * d4), false);
        }

        public b a() {
            List<d> list;
            c[] cVarArr;
            Bitmap bitmap = this.f47389b;
            if (bitmap != null) {
                Bitmap b4 = b(bitmap);
                Rect rect = this.f47395h;
                if (b4 != this.f47389b && rect != null) {
                    double width = b4.getWidth();
                    double width2 = this.f47389b.getWidth();
                    Double.isNaN(width);
                    Double.isNaN(width2);
                    double d4 = width / width2;
                    double d5 = rect.left;
                    Double.isNaN(d5);
                    rect.left = (int) Math.floor(d5 * d4);
                    double d6 = rect.top;
                    Double.isNaN(d6);
                    rect.top = (int) Math.floor(d6 * d4);
                    double d7 = rect.right;
                    Double.isNaN(d7);
                    rect.right = Math.min((int) Math.ceil(d7 * d4), b4.getWidth());
                    double d8 = rect.bottom;
                    Double.isNaN(d8);
                    rect.bottom = Math.min((int) Math.ceil(d8 * d4), b4.getHeight());
                }
                int[] a4 = a(b4);
                int i4 = this.f47391d;
                if (this.f47394g.isEmpty()) {
                    cVarArr = null;
                } else {
                    List<c> list2 = this.f47394g;
                    cVarArr = (c[]) list2.toArray(new c[list2.size()]);
                }
                com.qq.e.lib.d.a aVar = new com.qq.e.lib.d.a(a4, i4, cVarArr);
                if (b4 != this.f47389b) {
                    b4.recycle();
                }
                list = aVar.a();
            } else {
                list = this.f47388a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            b bVar = new b(list, this.f47390c);
            bVar.b();
            return bVar;
        }

        private int[] a(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f47395h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.f47395h.height();
            int[] iArr2 = new int[width2 * height2];
            for (int i4 = 0; i4 < height2; i4++) {
                Rect rect2 = this.f47395h;
                System.arraycopy(iArr, ((rect2.top + i4) * width) + rect2.left, iArr2, i4 * width2, width2);
            }
            return iArr2;
        }
    }
}
