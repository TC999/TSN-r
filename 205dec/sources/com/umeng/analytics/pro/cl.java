package com.umeng.analytics.pro;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TField.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class cl {

    /* renamed from: a  reason: collision with root package name */
    public final String f52814a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f52815b;

    /* renamed from: c  reason: collision with root package name */
    public final short f52816c;

    public cl() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(cl clVar) {
        return this.f52815b == clVar.f52815b && this.f52816c == clVar.f52816c;
    }

    public String toString() {
        return "<TField name:'" + this.f52814a + "' type:" + ((int) this.f52815b) + " field-id:" + ((int) this.f52816c) + ">";
    }

    public cl(String str, byte b4, short s3) {
        this.f52814a = str;
        this.f52815b = b4;
        this.f52816c = s3;
    }
}
