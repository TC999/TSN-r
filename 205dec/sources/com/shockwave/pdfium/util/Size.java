package com.shockwave.pdfium.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Size {

    /* renamed from: a  reason: collision with root package name */
    private final int f48113a;

    /* renamed from: b  reason: collision with root package name */
    private final int f48114b;

    public Size(int i4, int i5) {
        this.f48113a = i4;
        this.f48114b = i5;
    }

    public int a() {
        return this.f48114b;
    }

    public int b() {
        return this.f48113a;
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
            return this.f48113a == size.f48113a && this.f48114b == size.f48114b;
        }
        return false;
    }

    public int hashCode() {
        int i4 = this.f48114b;
        int i5 = this.f48113a;
        return i4 ^ ((i5 >>> 16) | (i5 << 16));
    }

    public String toString() {
        return this.f48113a + "x" + this.f48114b;
    }
}
