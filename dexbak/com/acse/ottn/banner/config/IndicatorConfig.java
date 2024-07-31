package com.acse.ottn.banner.config;

import androidx.annotation.ColorInt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class IndicatorConfig {

    /* renamed from: a */
    private int f2653a;

    /* renamed from: b */
    private int f2654b;

    /* renamed from: k */
    private Margins f2663k;

    /* renamed from: c */
    private int f2655c = 1;

    /* renamed from: d */
    private int f2656d = C1454a.f2673i;

    /* renamed from: e */
    private int f2657e = C1454a.f2671g;

    /* renamed from: f */
    private int f2658f = C1454a.f2672h;
    @ColorInt

    /* renamed from: g */
    private int f2659g = C1454a.f2669e;
    @ColorInt

    /* renamed from: h */
    private int f2660h = C1454a.f2670f;

    /* renamed from: i */
    private int f2661i = C1454a.f2676l;

    /* renamed from: j */
    private int f2662j = C1454a.f2675k;

    /* renamed from: l */
    private boolean f2664l = true;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public @interface Direction {
        public static final int CENTER = 1;
        public static final int LEFT = 0;
        public static final int RIGHT = 2;
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class Margins {
        public int bottomMargin;
        public int leftMargin;
        public int rightMargin;
        public int topMargin;

        public Margins() {
            this(C1454a.f2674j);
        }

        public Margins(int i) {
            this(i, i, i, i);
        }

        public Margins(int i, int i2, int i3, int i4) {
            this.leftMargin = i;
            this.topMargin = i2;
            this.rightMargin = i3;
            this.bottomMargin = i4;
        }
    }

    /* renamed from: a */
    public int m56731a() {
        return this.f2654b;
    }

    /* renamed from: a */
    public IndicatorConfig m56730a(int i) {
        this.f2654b = i;
        return this;
    }

    /* renamed from: a */
    public IndicatorConfig m56729a(Margins margins) {
        this.f2663k = margins;
        return this;
    }

    /* renamed from: a */
    public IndicatorConfig m56728a(boolean z) {
        this.f2664l = z;
        return this;
    }

    /* renamed from: b */
    public int m56727b() {
        return this.f2655c;
    }

    /* renamed from: b */
    public IndicatorConfig m56726b(int i) {
        this.f2655c = i;
        return this;
    }

    /* renamed from: c */
    public int m56725c() {
        return this.f2662j;
    }

    /* renamed from: c */
    public IndicatorConfig m56724c(int i) {
        this.f2662j = i;
        return this;
    }

    /* renamed from: d */
    public int m56723d() {
        return this.f2653a;
    }

    /* renamed from: d */
    public IndicatorConfig m56722d(int i) {
        this.f2653a = i;
        return this;
    }

    /* renamed from: e */
    public int m56721e() {
        return this.f2656d;
    }

    /* renamed from: e */
    public IndicatorConfig m56720e(int i) {
        this.f2656d = i;
        return this;
    }

    /* renamed from: f */
    public Margins m56719f() {
        if (this.f2663k == null) {
            m56729a(new Margins());
        }
        return this.f2663k;
    }

    /* renamed from: f */
    public IndicatorConfig m56718f(int i) {
        this.f2659g = i;
        return this;
    }

    /* renamed from: g */
    public int m56717g() {
        return this.f2659g;
    }

    /* renamed from: g */
    public IndicatorConfig m56716g(int i) {
        this.f2657e = i;
        return this;
    }

    /* renamed from: h */
    public int m56715h() {
        return this.f2657e;
    }

    /* renamed from: h */
    public IndicatorConfig m56714h(int i) {
        this.f2661i = i;
        return this;
    }

    /* renamed from: i */
    public int m56713i() {
        return this.f2661i;
    }

    /* renamed from: i */
    public IndicatorConfig m56712i(int i) {
        this.f2660h = i;
        return this;
    }

    /* renamed from: j */
    public int m56711j() {
        return this.f2660h;
    }

    /* renamed from: j */
    public IndicatorConfig m56710j(int i) {
        this.f2658f = i;
        return this;
    }

    /* renamed from: k */
    public int m56709k() {
        return this.f2658f;
    }

    /* renamed from: l */
    public boolean m56708l() {
        return this.f2664l;
    }
}
