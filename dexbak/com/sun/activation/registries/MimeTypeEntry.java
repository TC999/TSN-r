package com.sun.activation.registries;

/* renamed from: com.sun.activation.registries.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MimeTypeEntry {

    /* renamed from: a */
    private String f35838a;

    /* renamed from: b */
    private String f35839b;

    public MimeTypeEntry(String str, String str2) {
        this.f35838a = str;
        this.f35839b = str2;
    }

    /* renamed from: a */
    public String m16451a() {
        return this.f35839b;
    }

    /* renamed from: b */
    public String m16450b() {
        return this.f35838a;
    }

    public String toString() {
        return "MIMETypeEntry: " + this.f35838a + ", " + this.f35839b;
    }
}
