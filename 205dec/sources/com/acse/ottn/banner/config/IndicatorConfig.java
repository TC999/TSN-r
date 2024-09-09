package com.acse.ottn.banner.config;

import androidx.annotation.ColorInt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class IndicatorConfig {

    /* renamed from: a  reason: collision with root package name */
    private int f5254a;

    /* renamed from: b  reason: collision with root package name */
    private int f5255b;

    /* renamed from: k  reason: collision with root package name */
    private Margins f5264k;

    /* renamed from: c  reason: collision with root package name */
    private int f5256c = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f5257d = a.f5274i;

    /* renamed from: e  reason: collision with root package name */
    private int f5258e = a.f5272g;

    /* renamed from: f  reason: collision with root package name */
    private int f5259f = a.f5273h;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    private int f5260g = -1996488705;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    private int f5261h = -2013265920;

    /* renamed from: i  reason: collision with root package name */
    private int f5262i = a.f5277l;

    /* renamed from: j  reason: collision with root package name */
    private int f5263j = a.f5276k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5265l = true;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public @interface Direction {
        public static final int CENTER = 1;
        public static final int LEFT = 0;
        public static final int RIGHT = 2;
    }

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class Margins {
        public int bottomMargin;
        public int leftMargin;
        public int rightMargin;
        public int topMargin;

        public Margins() {
            this(a.f5275j);
        }

        public Margins(int i4) {
            this(i4, i4, i4, i4);
        }

        public Margins(int i4, int i5, int i6, int i7) {
            this.leftMargin = i4;
            this.topMargin = i5;
            this.rightMargin = i6;
            this.bottomMargin = i7;
        }
    }

    public int a() {
        return this.f5255b;
    }

    public IndicatorConfig a(int i4) {
        this.f5255b = i4;
        return this;
    }

    public IndicatorConfig a(Margins margins) {
        this.f5264k = margins;
        return this;
    }

    public IndicatorConfig a(boolean z3) {
        this.f5265l = z3;
        return this;
    }

    public int b() {
        return this.f5256c;
    }

    public IndicatorConfig b(int i4) {
        this.f5256c = i4;
        return this;
    }

    public int c() {
        return this.f5263j;
    }

    public IndicatorConfig c(int i4) {
        this.f5263j = i4;
        return this;
    }

    public int d() {
        return this.f5254a;
    }

    public IndicatorConfig d(int i4) {
        this.f5254a = i4;
        return this;
    }

    public int e() {
        return this.f5257d;
    }

    public IndicatorConfig e(int i4) {
        this.f5257d = i4;
        return this;
    }

    public Margins f() {
        if (this.f5264k == null) {
            a(new Margins());
        }
        return this.f5264k;
    }

    public IndicatorConfig f(int i4) {
        this.f5260g = i4;
        return this;
    }

    public int g() {
        return this.f5260g;
    }

    public IndicatorConfig g(int i4) {
        this.f5258e = i4;
        return this;
    }

    public int h() {
        return this.f5258e;
    }

    public IndicatorConfig h(int i4) {
        this.f5262i = i4;
        return this;
    }

    public int i() {
        return this.f5262i;
    }

    public IndicatorConfig i(int i4) {
        this.f5261h = i4;
        return this;
    }

    public int j() {
        return this.f5261h;
    }

    public IndicatorConfig j(int i4) {
        this.f5259f = i4;
        return this;
    }

    public int k() {
        return this.f5259f;
    }

    public boolean l() {
        return this.f5265l;
    }
}
