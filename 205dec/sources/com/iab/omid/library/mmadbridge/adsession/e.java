package com.iab.omid.library.mmadbridge.adsession;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f37686a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37687b;

    private e(String str, String str2) {
        this.f37686a = str;
        this.f37687b = str2;
    }

    public static e a(String str, String str2) {
        com.iab.omid.library.mmadbridge.d.e.f(str, "Name is null or empty");
        com.iab.omid.library.mmadbridge.d.e.f(str2, "Version is null or empty");
        return new e(str, str2);
    }

    public String b() {
        return this.f37686a;
    }

    public String c() {
        return this.f37687b;
    }
}
