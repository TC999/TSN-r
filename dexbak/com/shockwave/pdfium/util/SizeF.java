package com.shockwave.pdfium.util;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SizeF {

    /* renamed from: a */
    private final float f33781a;

    /* renamed from: b */
    private final float f33782b;

    public SizeF(float f, float f2) {
        this.f33781a = f;
        this.f33782b = f2;
    }

    /* renamed from: a */
    public float m19712a() {
        return this.f33782b;
    }

    /* renamed from: b */
    public float m19711b() {
        return this.f33781a;
    }

    /* renamed from: c */
    public Size m19710c() {
        return new Size((int) this.f33781a, (int) this.f33782b);
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
            return this.f33781a == sizeF.f33781a && this.f33782b == sizeF.f33782b;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f33781a) ^ Float.floatToIntBits(this.f33782b);
    }

    public String toString() {
        return this.f33781a + "x" + this.f33782b;
    }
}
