package com.acse.ottn;

import androidx.annotation.ColorInt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class o1 {

    /* renamed from: a  reason: collision with root package name */
    public int f6077a;

    /* renamed from: b  reason: collision with root package name */
    public int f6078b;

    /* renamed from: k  reason: collision with root package name */
    public b f6087k;

    /* renamed from: c  reason: collision with root package name */
    public int f6079c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f6080d = u.f6639i;

    /* renamed from: e  reason: collision with root package name */
    public int f6081e = u.f6637g;

    /* renamed from: f  reason: collision with root package name */
    public int f6082f = u.f6638h;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    public int f6083g = -1996488705;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public int f6084h = -2013265920;

    /* renamed from: i  reason: collision with root package name */
    public int f6085i = u.f6642l;

    /* renamed from: j  reason: collision with root package name */
    public int f6086j = u.f6641k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f6088l = true;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public @interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f6089a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f6090b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f6091c = 2;
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f6092a;

        /* renamed from: b  reason: collision with root package name */
        public int f6093b;

        /* renamed from: c  reason: collision with root package name */
        public int f6094c;

        /* renamed from: d  reason: collision with root package name */
        public int f6095d;

        public b() {
            this(u.f6640j);
        }

        public b(int i4) {
            this(i4, i4, i4, i4);
        }

        public b(int i4, int i5, int i6, int i7) {
            this.f6092a = i4;
            this.f6093b = i5;
            this.f6094c = i6;
            this.f6095d = i7;
        }
    }

    public o1 a(b bVar) {
        this.f6087k = bVar;
        return this;
    }

    public int b() {
        return this.f6079c;
    }

    public int c() {
        return this.f6086j;
    }

    public int d() {
        return this.f6077a;
    }

    public int e() {
        return this.f6080d;
    }

    public b f() {
        if (this.f6087k == null) {
            a(new b());
        }
        return this.f6087k;
    }

    public int g() {
        return this.f6083g;
    }

    public int h() {
        return this.f6081e;
    }

    public o1 i(int i4) {
        this.f6084h = i4;
        return this;
    }

    public int j() {
        return this.f6084h;
    }

    public int k() {
        return this.f6082f;
    }

    public boolean l() {
        return this.f6088l;
    }

    public int a() {
        return this.f6078b;
    }

    public o1 b(int i4) {
        this.f6079c = i4;
        return this;
    }

    public o1 c(int i4) {
        this.f6086j = i4;
        return this;
    }

    public o1 d(int i4) {
        this.f6077a = i4;
        return this;
    }

    public o1 e(int i4) {
        this.f6080d = i4;
        return this;
    }

    public o1 g(int i4) {
        this.f6081e = i4;
        return this;
    }

    public o1 h(int i4) {
        this.f6085i = i4;
        return this;
    }

    public int i() {
        return this.f6085i;
    }

    public o1 j(int i4) {
        this.f6082f = i4;
        return this;
    }

    public o1 a(int i4) {
        this.f6078b = i4;
        return this;
    }

    public o1 a(boolean z3) {
        this.f6088l = z3;
        return this;
    }

    public o1 f(int i4) {
        this.f6083g = i4;
        return this;
    }
}
