package com.umeng.analytics.pro;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: FieldValueMetaData.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ce implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f52757a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f52758b;

    /* renamed from: c  reason: collision with root package name */
    private final String f52759c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f52760d;

    public ce(byte b4, boolean z3) {
        this.f52758b = b4;
        this.f52757a = false;
        this.f52759c = null;
        this.f52760d = z3;
    }

    public boolean a() {
        return this.f52757a;
    }

    public String b() {
        return this.f52759c;
    }

    public boolean c() {
        return this.f52758b == 12;
    }

    public boolean d() {
        byte b4 = this.f52758b;
        return b4 == 15 || b4 == 13 || b4 == 14;
    }

    public boolean e() {
        return this.f52760d;
    }

    public ce(byte b4) {
        this(b4, false);
    }

    public ce(byte b4, String str) {
        this.f52758b = b4;
        this.f52757a = true;
        this.f52759c = str;
        this.f52760d = false;
    }
}
