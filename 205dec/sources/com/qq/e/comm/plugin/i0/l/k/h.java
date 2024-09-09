package com.qq.e.comm.plugin.i0.l.k;

import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f44362a;

    /* renamed from: b  reason: collision with root package name */
    public final int f44363b;

    /* renamed from: c  reason: collision with root package name */
    public final int f44364c;

    /* renamed from: d  reason: collision with root package name */
    public final long f44365d;

    /* renamed from: e  reason: collision with root package name */
    public final int f44366e;

    /* renamed from: f  reason: collision with root package name */
    public final String f44367f;

    public h(String str, int i4, int i5, long j4, int i6, String str2) {
        this.f44362a = str;
        this.f44363b = i4;
        this.f44364c = i5;
        this.f44365d = j4;
        this.f44366e = i6;
        this.f44367f = str2;
    }

    public boolean a() {
        return this.f44363b == 1;
    }

    public boolean b() {
        return this.f44363b == 28;
    }

    public boolean c() {
        return this.f44363b == 5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.f44362a.equals(hVar.f44362a) && this.f44363b == hVar.f44363b && this.f44364c == hVar.f44364c && this.f44365d == hVar.f44365d;
        }
        return false;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "{type:%s, value:%s, source:%s, server:%s, timestamp:%d, ttl:%d}", Integer.valueOf(this.f44363b), this.f44362a, Integer.valueOf(this.f44366e), this.f44367f, Long.valueOf(this.f44365d), Integer.valueOf(this.f44364c));
    }
}
