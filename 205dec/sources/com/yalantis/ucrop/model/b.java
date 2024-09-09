package com.yalantis.ucrop.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ExifInfo.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f54374a;

    /* renamed from: b  reason: collision with root package name */
    private int f54375b;

    /* renamed from: c  reason: collision with root package name */
    private int f54376c;

    public b(int i4, int i5, int i6) {
        this.f54374a = i4;
        this.f54375b = i5;
        this.f54376c = i6;
    }

    public int a() {
        return this.f54375b;
    }

    public int b() {
        return this.f54374a;
    }

    public int c() {
        return this.f54376c;
    }

    public void d(int i4) {
        this.f54375b = i4;
    }

    public void e(int i4) {
        this.f54374a = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f54374a == bVar.f54374a && this.f54375b == bVar.f54375b && this.f54376c == bVar.f54376c;
    }

    public void f(int i4) {
        this.f54376c = i4;
    }

    public int hashCode() {
        return (((this.f54374a * 31) + this.f54375b) * 31) + this.f54376c;
    }
}
