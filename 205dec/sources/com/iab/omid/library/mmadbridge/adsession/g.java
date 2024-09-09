package com.iab.omid.library.mmadbridge.adsession;

import java.net.URL;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f37688a;

    /* renamed from: b  reason: collision with root package name */
    private final URL f37689b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37690c;

    private g(String str, URL url, String str2) {
        this.f37688a = str;
        this.f37689b = url;
        this.f37690c = str2;
    }

    public static g a(String str, URL url, String str2) {
        com.iab.omid.library.mmadbridge.d.e.f(str, "VendorKey is null or empty");
        com.iab.omid.library.mmadbridge.d.e.d(url, "ResourceURL is null");
        com.iab.omid.library.mmadbridge.d.e.f(str2, "VerificationParameters is null or empty");
        return new g(str, url, str2);
    }

    public static g b(URL url) {
        com.iab.omid.library.mmadbridge.d.e.d(url, "ResourceURL is null");
        return new g(null, url, null);
    }

    public URL c() {
        return this.f37689b;
    }

    public String d() {
        return this.f37688a;
    }

    public String e() {
        return this.f37690c;
    }
}
