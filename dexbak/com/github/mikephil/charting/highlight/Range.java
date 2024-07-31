package com.github.mikephil.charting.highlight;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class Range {
    public float from;

    /* renamed from: to */
    public float f23772to;

    public Range(float f, float f2) {
        this.from = f;
        this.f23772to = f2;
    }

    public boolean contains(float f) {
        return f > this.from && f <= this.f23772to;
    }

    public boolean isLarger(float f) {
        return f > this.f23772to;
    }

    public boolean isSmaller(float f) {
        return f < this.from;
    }
}
