package com.beizi.ad;

import android.content.Context;
import android.util.TypedValue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdSize.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f13105a = new a(320, 50, "320x50_mb");

    /* renamed from: b  reason: collision with root package name */
    public static final a f13106b = new a(468, 60, "468x60_as");

    /* renamed from: c  reason: collision with root package name */
    public static final a f13107c = new a(320, 100, "320x100_as");

    /* renamed from: d  reason: collision with root package name */
    public static final a f13108d = new a(728, 90, "728x90_as");

    /* renamed from: e  reason: collision with root package name */
    public static final a f13109e = new a(300, 250, "300x250_as");

    /* renamed from: f  reason: collision with root package name */
    public static final a f13110f = new a(160, 600, "160x600_as");

    /* renamed from: g  reason: collision with root package name */
    public static final a f13111g = new a(-1, -2, "smart_banner");

    /* renamed from: h  reason: collision with root package name */
    public static final a f13112h = new a(-3, -4, "fluid");

    /* renamed from: i  reason: collision with root package name */
    public static final a f13113i = new a(-3, 0, "search_v2");

    /* renamed from: j  reason: collision with root package name */
    private final int f13114j;

    /* renamed from: k  reason: collision with root package name */
    private final int f13115k;

    /* renamed from: l  reason: collision with root package name */
    private final String f13116l;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(int r3, int r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = -1
            if (r3 != r1) goto Lb
            java.lang.String r1 = "FULL"
            goto Lf
        Lb:
            java.lang.String r1 = java.lang.String.valueOf(r3)
        Lf:
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            r1 = -2
            if (r4 != r1) goto L1d
            java.lang.String r1 = "AUTO"
            goto L21
        L1d:
            java.lang.String r1 = java.lang.String.valueOf(r4)
        L21:
            r0.append(r1)
            java.lang.String r1 = "_as"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.a.<init>(int, int):void");
    }

    public int a() {
        return this.f13115k;
    }

    public int b() {
        return this.f13114j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f13114j == aVar.f13114j && this.f13115k == aVar.f13115k && this.f13116l.equals(aVar.f13116l);
        }
        return false;
    }

    public int hashCode() {
        return this.f13116l.hashCode();
    }

    public String toString() {
        return this.f13116l;
    }

    private a(int i4, int i5, String str) {
        if (i4 < 0 && i4 != -1 && i4 != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i4);
        } else if (i5 < 0 && i5 != -2 && i5 != -4) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i5);
        } else {
            this.f13114j = i4;
            this.f13115k = i5;
            this.f13116l = str;
        }
    }

    public int a(Context context) {
        int i4 = this.f13115k;
        if (i4 == -4 || i4 == -3) {
            return -1;
        }
        if (i4 != -2) {
            return (int) TypedValue.applyDimension(1, i4, context.getResources().getDisplayMetrics());
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public int b(Context context) {
        int i4 = this.f13114j;
        if (i4 == -4 || i4 == -3) {
            return -1;
        }
        if (i4 != -1) {
            return (int) TypedValue.applyDimension(1, i4, context.getResources().getDisplayMetrics());
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
