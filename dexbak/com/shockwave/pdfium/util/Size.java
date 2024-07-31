package com.shockwave.pdfium.util;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Size {

    /* renamed from: a */
    private final int f33779a;

    /* renamed from: b */
    private final int f33780b;

    public Size(int i, int i2) {
        this.f33779a = i;
        this.f33780b = i2;
    }

    /* renamed from: a */
    public int m19714a() {
        return this.f33780b;
    }

    /* renamed from: b */
    public int m19713b() {
        return this.f33779a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.f33779a == size.f33779a && this.f33780b == size.f33780b;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f33780b;
        int i2 = this.f33779a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.f33779a + "x" + this.f33780b;
    }
}
