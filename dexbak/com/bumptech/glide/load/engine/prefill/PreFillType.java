package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C3770j;

/* renamed from: com.bumptech.glide.load.engine.prefill.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PreFillType {
    @VisibleForTesting

    /* renamed from: e */
    static final Bitmap.Config f13888e = Bitmap.Config.RGB_565;

    /* renamed from: a */
    private final int f13889a;

    /* renamed from: b */
    private final int f13890b;

    /* renamed from: c */
    private final Bitmap.Config f13891c;

    /* renamed from: d */
    private final int f13892d;

    /* compiled from: PreFillType.java */
    /* renamed from: com.bumptech.glide.load.engine.prefill.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3645a {

        /* renamed from: a */
        private final int f13893a;

        /* renamed from: b */
        private final int f13894b;

        /* renamed from: c */
        private Bitmap.Config f13895c;

        /* renamed from: d */
        private int f13896d;

        public C3645a(int i) {
            this(i, i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public PreFillType m45150a() {
            return new PreFillType(this.f13893a, this.f13894b, this.f13895c, this.f13896d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public Bitmap.Config m45149b() {
            return this.f13895c;
        }

        /* renamed from: c */
        public C3645a m45148c(@Nullable Bitmap.Config config) {
            this.f13895c = config;
            return this;
        }

        /* renamed from: d */
        public C3645a m45147d(int i) {
            if (i > 0) {
                this.f13896d = i;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public C3645a(int i, int i2) {
            this.f13896d = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i2 > 0) {
                this.f13893a = i;
                this.f13894b = i2;
                return;
            }
            throw new IllegalArgumentException("Height must be > 0");
        }
    }

    PreFillType(int i, int i2, Bitmap.Config config, int i3) {
        this.f13891c = (Bitmap.Config) C3770j.m44391e(config, "Config must not be null");
        this.f13889a = i;
        this.f13890b = i2;
        this.f13892d = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap.Config m45154a() {
        return this.f13891c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m45153b() {
        return this.f13890b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m45152c() {
        return this.f13892d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public int m45151d() {
        return this.f13889a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PreFillType) {
            PreFillType preFillType = (PreFillType) obj;
            return this.f13890b == preFillType.f13890b && this.f13889a == preFillType.f13889a && this.f13892d == preFillType.f13892d && this.f13891c == preFillType.f13891c;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f13889a * 31) + this.f13890b) * 31) + this.f13891c.hashCode()) * 31) + this.f13892d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f13889a + ", height=" + this.f13890b + ", config=" + this.f13891c + ", weight=" + this.f13892d + '}';
    }
}
