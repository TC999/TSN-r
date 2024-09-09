package com.autonavi.aps.amapapi.restruct;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Cgi.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d {

    /* renamed from: l  reason: collision with root package name */
    public int f11809l;

    /* renamed from: n  reason: collision with root package name */
    public boolean f11811n;

    /* renamed from: a  reason: collision with root package name */
    public int f11798a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f11799b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f11800c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f11801d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f11802e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f11803f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f11804g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f11805h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f11806i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f11807j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f11808k = -113;

    /* renamed from: m  reason: collision with root package name */
    public short f11810m = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f11812o = 32767;

    /* renamed from: p  reason: collision with root package name */
    public int f11813p = Integer.MAX_VALUE;

    /* renamed from: q  reason: collision with root package name */
    public int f11814q = Integer.MAX_VALUE;

    /* renamed from: r  reason: collision with root package name */
    public boolean f11815r = true;

    /* renamed from: s  reason: collision with root package name */
    public int f11816s = 99;

    /* renamed from: t  reason: collision with root package name */
    public long f11817t = 0;

    public d(int i4, boolean z3) {
        this.f11809l = i4;
        this.f11811n = z3;
    }

    private String e() {
        int i4 = this.f11809l;
        return this.f11809l + "#" + this.f11798a + "#" + this.f11799b + "#0#" + a();
    }

    private String f() {
        return this.f11809l + "#" + this.f11805h + "#" + this.f11806i + "#" + this.f11807j;
    }

    public final long a() {
        if (this.f11809l == 5) {
            return this.f11802e;
        }
        return this.f11801d;
    }

    public final String b() {
        int i4 = this.f11809l;
        if (i4 != 1) {
            if (i4 == 2) {
                return f();
            }
            if (i4 != 3 && i4 != 4 && i4 != 5) {
                return null;
            }
        }
        return e();
    }

    public final String c() {
        String b4 = b();
        if (b4 == null || b4.length() <= 0) {
            return "";
        }
        boolean z3 = this.f11815r;
        return (z3 ? 1 : 0) + "#" + b4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final d clone() {
        d dVar = new d(this.f11809l, this.f11811n);
        dVar.f11798a = this.f11798a;
        dVar.f11799b = this.f11799b;
        dVar.f11800c = this.f11800c;
        dVar.f11801d = this.f11801d;
        dVar.f11802e = this.f11802e;
        dVar.f11803f = this.f11803f;
        dVar.f11804g = this.f11804g;
        dVar.f11805h = this.f11805h;
        dVar.f11806i = this.f11806i;
        dVar.f11807j = this.f11807j;
        dVar.f11808k = this.f11808k;
        dVar.f11810m = this.f11810m;
        dVar.f11812o = this.f11812o;
        dVar.f11813p = this.f11813p;
        dVar.f11814q = this.f11814q;
        dVar.f11815r = this.f11815r;
        dVar.f11816s = this.f11816s;
        dVar.f11817t = this.f11817t;
        return dVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            int i4 = dVar.f11809l;
            if (i4 != 1) {
                return i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 == 5 && this.f11809l == 5 && dVar.f11800c == this.f11800c && dVar.f11802e == this.f11802e && dVar.f11814q == this.f11814q : this.f11809l == 4 && dVar.f11800c == this.f11800c && dVar.f11801d == this.f11801d && dVar.f11799b == this.f11799b : this.f11809l == 3 && dVar.f11800c == this.f11800c && dVar.f11801d == this.f11801d && dVar.f11799b == this.f11799b : this.f11809l == 2 && dVar.f11807j == this.f11807j && dVar.f11806i == this.f11806i && dVar.f11805h == this.f11805h;
            } else if (this.f11809l == 1 && dVar.f11800c == this.f11800c && dVar.f11801d == this.f11801d && dVar.f11799b == this.f11799b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = String.valueOf(this.f11809l).hashCode();
        if (this.f11809l == 2) {
            hashCode = String.valueOf(this.f11807j).hashCode() + String.valueOf(this.f11806i).hashCode();
            hashCode2 = String.valueOf(this.f11805h).hashCode();
        } else {
            hashCode = String.valueOf(this.f11800c).hashCode() + String.valueOf(this.f11801d).hashCode();
            hashCode2 = String.valueOf(this.f11799b).hashCode();
        }
        return hashCode3 + hashCode + hashCode2;
    }
}
