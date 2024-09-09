package com.beizi.ad.internal.video;

import android.graphics.Matrix;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdVideoManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private c f14048a;

    /* renamed from: b  reason: collision with root package name */
    private c f14049b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdVideoManager.java */
    /* renamed from: com.beizi.ad.internal.video.a$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14050a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f14051b;

        static {
            int[] iArr = new int[EnumC0130a.values().length];
            f14051b = iArr;
            try {
                iArr[EnumC0130a.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14051b[EnumC0130a.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14051b[EnumC0130a.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14051b[EnumC0130a.CENTER_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14051b[EnumC0130a.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14051b[EnumC0130a.CENTER_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14051b[EnumC0130a.RIGHT_TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14051b[EnumC0130a.RIGHT_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14051b[EnumC0130a.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[b.values().length];
            f14050a = iArr2;
            try {
                iArr2[b.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f14050a[b.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f14050a[b.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f14050a[b.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f14050a[b.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f14050a[b.LEFT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f14050a[b.LEFT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f14050a[b.LEFT_BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f14050a[b.CENTER_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f14050a[b.CENTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f14050a[b.CENTER_BOTTOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f14050a[b.RIGHT_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f14050a[b.RIGHT_CENTER.ordinal()] = 13;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f14050a[b.RIGHT_BOTTOM.ordinal()] = 14;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f14050a[b.LEFT_TOP_CROP.ordinal()] = 15;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f14050a[b.LEFT_CENTER_CROP.ordinal()] = 16;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f14050a[b.LEFT_BOTTOM_CROP.ordinal()] = 17;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f14050a[b.CENTER_TOP_CROP.ordinal()] = 18;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f14050a[b.CENTER_CROP.ordinal()] = 19;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f14050a[b.CENTER_BOTTOM_CROP.ordinal()] = 20;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f14050a[b.RIGHT_TOP_CROP.ordinal()] = 21;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f14050a[b.RIGHT_CENTER_CROP.ordinal()] = 22;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f14050a[b.RIGHT_BOTTOM_CROP.ordinal()] = 23;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f14050a[b.START_INSIDE.ordinal()] = 24;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f14050a[b.CENTER_INSIDE.ordinal()] = 25;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f14050a[b.END_INSIDE.ordinal()] = 26;
            } catch (NoSuchFieldError unused35) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdVideoManager.java */
    /* renamed from: com.beizi.ad.internal.video.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum EnumC0130a {
        LEFT_TOP,
        LEFT_CENTER,
        LEFT_BOTTOM,
        CENTER_TOP,
        CENTER,
        CENTER_BOTTOM,
        RIGHT_TOP,
        RIGHT_CENTER,
        RIGHT_BOTTOM
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdVideoManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum b {
        NONE,
        FIT_XY,
        FIT_START,
        FIT_CENTER,
        FIT_END,
        LEFT_TOP,
        LEFT_CENTER,
        LEFT_BOTTOM,
        CENTER_TOP,
        CENTER,
        CENTER_BOTTOM,
        RIGHT_TOP,
        RIGHT_CENTER,
        RIGHT_BOTTOM,
        LEFT_TOP_CROP,
        LEFT_CENTER_CROP,
        LEFT_BOTTOM_CROP,
        CENTER_TOP_CROP,
        CENTER_CROP,
        CENTER_BOTTOM_CROP,
        RIGHT_TOP_CROP,
        RIGHT_CENTER_CROP,
        RIGHT_BOTTOM_CROP,
        START_INSIDE,
        CENTER_INSIDE,
        END_INSIDE
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AdVideoManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private int f14088a;

        /* renamed from: b  reason: collision with root package name */
        private int f14089b;

        public c(int i4, int i5) {
            this.f14088a = i4;
            this.f14089b = i5;
        }

        public int a() {
            return this.f14088a;
        }

        public int b() {
            return this.f14089b;
        }
    }

    public a(c cVar, c cVar2) {
        this.f14048a = cVar;
        this.f14049b = cVar2;
    }

    private Matrix b() {
        return a(1.0f, 1.0f, EnumC0130a.LEFT_TOP);
    }

    private Matrix c() {
        return a(EnumC0130a.LEFT_TOP);
    }

    private Matrix d() {
        return a(EnumC0130a.CENTER);
    }

    private Matrix e() {
        return a(EnumC0130a.RIGHT_BOTTOM);
    }

    private Matrix f() {
        if (this.f14049b.b() <= this.f14048a.a() && this.f14049b.b() <= this.f14048a.b()) {
            return b(EnumC0130a.LEFT_TOP);
        }
        return c();
    }

    private Matrix g() {
        if (this.f14049b.b() <= this.f14048a.a() && this.f14049b.b() <= this.f14048a.b()) {
            return b(EnumC0130a.CENTER);
        }
        return d();
    }

    private Matrix h() {
        if (this.f14049b.b() <= this.f14048a.a() && this.f14049b.b() <= this.f14048a.b()) {
            return b(EnumC0130a.RIGHT_BOTTOM);
        }
        return e();
    }

    public Matrix a(b bVar) {
        switch (AnonymousClass1.f14050a[bVar.ordinal()]) {
            case 1:
                return a();
            case 2:
                return b();
            case 3:
                return d();
            case 4:
                return c();
            case 5:
                return e();
            case 6:
                return b(EnumC0130a.LEFT_TOP);
            case 7:
                return b(EnumC0130a.LEFT_CENTER);
            case 8:
                return b(EnumC0130a.LEFT_BOTTOM);
            case 9:
                return b(EnumC0130a.CENTER_TOP);
            case 10:
                return b(EnumC0130a.CENTER);
            case 11:
                return b(EnumC0130a.CENTER_BOTTOM);
            case 12:
                return b(EnumC0130a.RIGHT_TOP);
            case 13:
                return b(EnumC0130a.RIGHT_CENTER);
            case 14:
                return b(EnumC0130a.RIGHT_BOTTOM);
            case 15:
                return c(EnumC0130a.LEFT_TOP);
            case 16:
                return c(EnumC0130a.LEFT_CENTER);
            case 17:
                return c(EnumC0130a.LEFT_BOTTOM);
            case 18:
                return c(EnumC0130a.CENTER_TOP);
            case 19:
                return c(EnumC0130a.CENTER);
            case 20:
                return c(EnumC0130a.CENTER_BOTTOM);
            case 21:
                return c(EnumC0130a.RIGHT_TOP);
            case 22:
                return c(EnumC0130a.RIGHT_CENTER);
            case 23:
                return c(EnumC0130a.RIGHT_BOTTOM);
            case 24:
                return f();
            case 25:
                return g();
            case 26:
                return h();
            default:
                return null;
        }
    }

    private Matrix b(EnumC0130a enumC0130a) {
        return a(this.f14049b.a() / this.f14048a.a(), this.f14049b.b() / this.f14048a.b(), enumC0130a);
    }

    private Matrix c(EnumC0130a enumC0130a) {
        float a4 = this.f14048a.a() / this.f14049b.a();
        float b4 = this.f14048a.b() / this.f14049b.b();
        float max = Math.max(a4, b4);
        return a(max / a4, max / b4, enumC0130a);
    }

    private Matrix a(float f4, float f5, float f6, float f7) {
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f5, f6, f7);
        return matrix;
    }

    private Matrix a(float f4, float f5, EnumC0130a enumC0130a) {
        switch (AnonymousClass1.f14051b[enumC0130a.ordinal()]) {
            case 1:
                return a(f4, f5, 0.0f, 0.0f);
            case 2:
                return a(f4, f5, 0.0f, this.f14048a.b() / 2.0f);
            case 3:
                return a(f4, f5, 0.0f, this.f14048a.b());
            case 4:
                return a(f4, f5, this.f14048a.a() / 2.0f, 0.0f);
            case 5:
                return a(f4, f5, this.f14048a.a() / 2.0f, this.f14048a.b() / 2.0f);
            case 6:
                return a(f4, f5, this.f14048a.a() / 2.0f, this.f14048a.b());
            case 7:
                return a(f4, f5, this.f14048a.a(), 0.0f);
            case 8:
                return a(f4, f5, this.f14048a.a(), this.f14048a.b() / 2.0f);
            case 9:
                return a(f4, f5, this.f14048a.a(), this.f14048a.b());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    private Matrix a() {
        return a(this.f14049b.a() / this.f14048a.a(), this.f14049b.b() / this.f14048a.b(), EnumC0130a.LEFT_TOP);
    }

    private Matrix a(EnumC0130a enumC0130a) {
        float a4 = this.f14048a.a() / this.f14049b.a();
        float b4 = this.f14048a.b() / this.f14049b.b();
        float min = Math.min(a4, b4);
        return a(min / a4, min / b4, enumC0130a);
    }
}
