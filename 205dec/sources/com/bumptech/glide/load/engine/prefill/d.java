package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PreFillType.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class d {
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    static final Bitmap.Config f17205e = Bitmap.Config.RGB_565;

    /* renamed from: a  reason: collision with root package name */
    private final int f17206a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17207b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap.Config f17208c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17209d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PreFillType.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f17210a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17211b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f17212c;

        /* renamed from: d  reason: collision with root package name */
        private int f17213d;

        public a(int i4) {
            this(i4, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public d a() {
            return new d(this.f17210a, this.f17211b, this.f17212c, this.f17213d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Bitmap.Config b() {
            return this.f17212c;
        }

        public a c(@Nullable Bitmap.Config config) {
            this.f17212c = config;
            return this;
        }

        public a d(int i4) {
            if (i4 > 0) {
                this.f17213d = i4;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public a(int i4, int i5) {
            this.f17213d = 1;
            if (i4 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i5 > 0) {
                this.f17210a = i4;
                this.f17211b = i5;
                return;
            }
            throw new IllegalArgumentException("Height must be > 0");
        }
    }

    d(int i4, int i5, Bitmap.Config config, int i6) {
        this.f17208c = (Bitmap.Config) j.e(config, "Config must not be null");
        this.f17206a = i4;
        this.f17207b = i5;
        this.f17209d = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap.Config a() {
        return this.f17208c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f17207b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f17209d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f17206a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f17207b == dVar.f17207b && this.f17206a == dVar.f17206a && this.f17209d == dVar.f17209d && this.f17208c == dVar.f17208c;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f17206a * 31) + this.f17207b) * 31) + this.f17208c.hashCode()) * 31) + this.f17209d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f17206a + ", height=" + this.f17207b + ", config=" + this.f17208c + ", weight=" + this.f17209d + '}';
    }
}
