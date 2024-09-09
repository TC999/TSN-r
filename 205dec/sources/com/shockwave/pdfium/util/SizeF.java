package com.shockwave.pdfium.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SizeF {

    /* renamed from: a  reason: collision with root package name */
    private final float f48115a;

    /* renamed from: b  reason: collision with root package name */
    private final float f48116b;

    public SizeF(float f4, float f5) {
        this.f48115a = f4;
        this.f48116b = f5;
    }

    public float a() {
        return this.f48116b;
    }

    public float b() {
        return this.f48115a;
    }

    public Size c() {
        return new Size((int) this.f48115a, (int) this.f48116b);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof SizeF) {
            SizeF sizeF = (SizeF) obj;
            return this.f48115a == sizeF.f48115a && this.f48116b == sizeF.f48116b;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f48115a) ^ Float.floatToIntBits(this.f48116b);
    }

    public String toString() {
        return this.f48115a + "x" + this.f48116b;
    }
}
