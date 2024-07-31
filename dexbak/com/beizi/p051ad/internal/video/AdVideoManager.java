package com.beizi.p051ad.internal.video;

import android.graphics.Matrix;

/* renamed from: com.beizi.ad.internal.video.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdVideoManager {

    /* renamed from: a */
    private C2946c f10447a;

    /* renamed from: b */
    private C2946c f10448b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdVideoManager.java */
    /* renamed from: com.beizi.ad.internal.video.a$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C29431 {

        /* renamed from: a */
        static final /* synthetic */ int[] f10449a;

        /* renamed from: b */
        static final /* synthetic */ int[] f10450b;

        static {
            int[] iArr = new int[EnumC2944a.values().length];
            f10450b = iArr;
            try {
                iArr[EnumC2944a.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10450b[EnumC2944a.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10450b[EnumC2944a.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10450b[EnumC2944a.CENTER_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10450b[EnumC2944a.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10450b[EnumC2944a.CENTER_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10450b[EnumC2944a.RIGHT_TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10450b[EnumC2944a.RIGHT_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10450b[EnumC2944a.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[EnumC2945b.values().length];
            f10449a = iArr2;
            try {
                iArr2[EnumC2945b.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10449a[EnumC2945b.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10449a[EnumC2945b.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10449a[EnumC2945b.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f10449a[EnumC2945b.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f10449a[EnumC2945b.LEFT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f10449a[EnumC2945b.LEFT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f10449a[EnumC2945b.LEFT_BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f10449a[EnumC2945b.CENTER_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f10449a[EnumC2945b.CENTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f10449a[EnumC2945b.CENTER_BOTTOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f10449a[EnumC2945b.RIGHT_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f10449a[EnumC2945b.RIGHT_CENTER.ordinal()] = 13;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f10449a[EnumC2945b.RIGHT_BOTTOM.ordinal()] = 14;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f10449a[EnumC2945b.LEFT_TOP_CROP.ordinal()] = 15;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f10449a[EnumC2945b.LEFT_CENTER_CROP.ordinal()] = 16;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f10449a[EnumC2945b.LEFT_BOTTOM_CROP.ordinal()] = 17;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f10449a[EnumC2945b.CENTER_TOP_CROP.ordinal()] = 18;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f10449a[EnumC2945b.CENTER_CROP.ordinal()] = 19;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f10449a[EnumC2945b.CENTER_BOTTOM_CROP.ordinal()] = 20;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f10449a[EnumC2945b.RIGHT_TOP_CROP.ordinal()] = 21;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f10449a[EnumC2945b.RIGHT_CENTER_CROP.ordinal()] = 22;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f10449a[EnumC2945b.RIGHT_BOTTOM_CROP.ordinal()] = 23;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f10449a[EnumC2945b.START_INSIDE.ordinal()] = 24;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f10449a[EnumC2945b.CENTER_INSIDE.ordinal()] = 25;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f10449a[EnumC2945b.END_INSIDE.ordinal()] = 26;
            } catch (NoSuchFieldError unused35) {
            }
        }
    }

    /* compiled from: AdVideoManager.java */
    /* renamed from: com.beizi.ad.internal.video.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2944a {
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

    /* compiled from: AdVideoManager.java */
    /* renamed from: com.beizi.ad.internal.video.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2945b {
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

    /* compiled from: AdVideoManager.java */
    /* renamed from: com.beizi.ad.internal.video.a$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2946c {

        /* renamed from: a */
        private int f10488a;

        /* renamed from: b */
        private int f10489b;

        public C2946c(int i, int i2) {
            this.f10488a = i;
            this.f10489b = i2;
        }

        /* renamed from: a */
        public int m49257a() {
            return this.f10488a;
        }

        /* renamed from: b */
        public int m49256b() {
            return this.f10489b;
        }
    }

    public AdVideoManager(C2946c c2946c, C2946c c2946c2) {
        this.f10447a = c2946c;
        this.f10448b = c2946c2;
    }

    /* renamed from: b */
    private Matrix m49266b() {
        return m49269a(1.0f, 1.0f, EnumC2944a.LEFT_TOP);
    }

    /* renamed from: c */
    private Matrix m49264c() {
        return m49268a(EnumC2944a.LEFT_TOP);
    }

    /* renamed from: d */
    private Matrix m49262d() {
        return m49268a(EnumC2944a.CENTER);
    }

    /* renamed from: e */
    private Matrix m49261e() {
        return m49268a(EnumC2944a.RIGHT_BOTTOM);
    }

    /* renamed from: f */
    private Matrix m49260f() {
        if (this.f10448b.m49256b() <= this.f10447a.m49257a() && this.f10448b.m49256b() <= this.f10447a.m49256b()) {
            return m49265b(EnumC2944a.LEFT_TOP);
        }
        return m49264c();
    }

    /* renamed from: g */
    private Matrix m49259g() {
        if (this.f10448b.m49256b() <= this.f10447a.m49257a() && this.f10448b.m49256b() <= this.f10447a.m49256b()) {
            return m49265b(EnumC2944a.CENTER);
        }
        return m49262d();
    }

    /* renamed from: h */
    private Matrix m49258h() {
        if (this.f10448b.m49256b() <= this.f10447a.m49257a() && this.f10448b.m49256b() <= this.f10447a.m49256b()) {
            return m49265b(EnumC2944a.RIGHT_BOTTOM);
        }
        return m49261e();
    }

    /* renamed from: a */
    public Matrix m49267a(EnumC2945b enumC2945b) {
        switch (C29431.f10449a[enumC2945b.ordinal()]) {
            case 1:
                return m49271a();
            case 2:
                return m49266b();
            case 3:
                return m49262d();
            case 4:
                return m49264c();
            case 5:
                return m49261e();
            case 6:
                return m49265b(EnumC2944a.LEFT_TOP);
            case 7:
                return m49265b(EnumC2944a.LEFT_CENTER);
            case 8:
                return m49265b(EnumC2944a.LEFT_BOTTOM);
            case 9:
                return m49265b(EnumC2944a.CENTER_TOP);
            case 10:
                return m49265b(EnumC2944a.CENTER);
            case 11:
                return m49265b(EnumC2944a.CENTER_BOTTOM);
            case 12:
                return m49265b(EnumC2944a.RIGHT_TOP);
            case 13:
                return m49265b(EnumC2944a.RIGHT_CENTER);
            case 14:
                return m49265b(EnumC2944a.RIGHT_BOTTOM);
            case 15:
                return m49263c(EnumC2944a.LEFT_TOP);
            case 16:
                return m49263c(EnumC2944a.LEFT_CENTER);
            case 17:
                return m49263c(EnumC2944a.LEFT_BOTTOM);
            case 18:
                return m49263c(EnumC2944a.CENTER_TOP);
            case 19:
                return m49263c(EnumC2944a.CENTER);
            case 20:
                return m49263c(EnumC2944a.CENTER_BOTTOM);
            case 21:
                return m49263c(EnumC2944a.RIGHT_TOP);
            case 22:
                return m49263c(EnumC2944a.RIGHT_CENTER);
            case 23:
                return m49263c(EnumC2944a.RIGHT_BOTTOM);
            case 24:
                return m49260f();
            case 25:
                return m49259g();
            case 26:
                return m49258h();
            default:
                return null;
        }
    }

    /* renamed from: b */
    private Matrix m49265b(EnumC2944a enumC2944a) {
        return m49269a(this.f10448b.m49257a() / this.f10447a.m49257a(), this.f10448b.m49256b() / this.f10447a.m49256b(), enumC2944a);
    }

    /* renamed from: c */
    private Matrix m49263c(EnumC2944a enumC2944a) {
        float m49257a = this.f10447a.m49257a() / this.f10448b.m49257a();
        float m49256b = this.f10447a.m49256b() / this.f10448b.m49256b();
        float max = Math.max(m49257a, m49256b);
        return m49269a(max / m49257a, max / m49256b, enumC2944a);
    }

    /* renamed from: a */
    private Matrix m49270a(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    /* renamed from: a */
    private Matrix m49269a(float f, float f2, EnumC2944a enumC2944a) {
        switch (C29431.f10450b[enumC2944a.ordinal()]) {
            case 1:
                return m49270a(f, f2, 0.0f, 0.0f);
            case 2:
                return m49270a(f, f2, 0.0f, this.f10447a.m49256b() / 2.0f);
            case 3:
                return m49270a(f, f2, 0.0f, this.f10447a.m49256b());
            case 4:
                return m49270a(f, f2, this.f10447a.m49257a() / 2.0f, 0.0f);
            case 5:
                return m49270a(f, f2, this.f10447a.m49257a() / 2.0f, this.f10447a.m49256b() / 2.0f);
            case 6:
                return m49270a(f, f2, this.f10447a.m49257a() / 2.0f, this.f10447a.m49256b());
            case 7:
                return m49270a(f, f2, this.f10447a.m49257a(), 0.0f);
            case 8:
                return m49270a(f, f2, this.f10447a.m49257a(), this.f10447a.m49256b() / 2.0f);
            case 9:
                return m49270a(f, f2, this.f10447a.m49257a(), this.f10447a.m49256b());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    /* renamed from: a */
    private Matrix m49271a() {
        return m49269a(this.f10448b.m49257a() / this.f10447a.m49257a(), this.f10448b.m49256b() / this.f10447a.m49256b(), EnumC2944a.LEFT_TOP);
    }

    /* renamed from: a */
    private Matrix m49268a(EnumC2944a enumC2944a) {
        float m49257a = this.f10447a.m49257a() / this.f10448b.m49257a();
        float m49256b = this.f10447a.m49256b() / this.f10448b.m49256b();
        float min = Math.min(m49257a, m49256b);
        return m49269a(min / m49257a, min / m49256b, enumC2944a);
    }
}
