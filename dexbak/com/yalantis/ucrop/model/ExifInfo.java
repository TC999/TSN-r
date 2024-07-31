package com.yalantis.ucrop.model;

/* renamed from: com.yalantis.ucrop.model.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ExifInfo {

    /* renamed from: a */
    private int f39838a;

    /* renamed from: b */
    private int f39839b;

    /* renamed from: c */
    private int f39840c;

    public ExifInfo(int i, int i2, int i3) {
        this.f39838a = i;
        this.f39839b = i2;
        this.f39840c = i3;
    }

    /* renamed from: a */
    public int m13040a() {
        return this.f39839b;
    }

    /* renamed from: b */
    public int m13039b() {
        return this.f39838a;
    }

    /* renamed from: c */
    public int m13038c() {
        return this.f39840c;
    }

    /* renamed from: d */
    public void m13037d(int i) {
        this.f39839b = i;
    }

    /* renamed from: e */
    public void m13036e(int i) {
        this.f39838a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExifInfo exifInfo = (ExifInfo) obj;
        return this.f39838a == exifInfo.f39838a && this.f39839b == exifInfo.f39839b && this.f39840c == exifInfo.f39840c;
    }

    /* renamed from: f */
    public void m13035f(int i) {
        this.f39840c = i;
    }

    public int hashCode() {
        return (((this.f39838a * 31) + this.f39839b) * 31) + this.f39840c;
    }
}
