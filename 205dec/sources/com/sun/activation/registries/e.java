package com.sun.activation.registries;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: MimeTypeEntry.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private String f50259a;

    /* renamed from: b  reason: collision with root package name */
    private String f50260b;

    public e(String str, String str2) {
        this.f50259a = str;
        this.f50260b = str2;
    }

    public String a() {
        return this.f50260b;
    }

    public String b() {
        return this.f50259a;
    }

    public String toString() {
        return "MIMETypeEntry: " + this.f50259a + ", " + this.f50260b;
    }
}
