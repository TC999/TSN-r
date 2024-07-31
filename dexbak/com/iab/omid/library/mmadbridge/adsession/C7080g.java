package com.iab.omid.library.mmadbridge.adsession;

import com.iab.omid.library.mmadbridge.p204d.C7105e;
import java.net.URL;

/* renamed from: com.iab.omid.library.mmadbridge.adsession.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7080g {

    /* renamed from: a */
    private final String f24206a;

    /* renamed from: b */
    private final URL f24207b;

    /* renamed from: c */
    private final String f24208c;

    private C7080g(String str, URL url, String str2) {
        this.f24206a = str;
        this.f24207b = url;
        this.f24208c = str2;
    }

    /* renamed from: a */
    public static C7080g m34815a(String str, URL url, String str2) {
        C7105e.m34669f(str, "VendorKey is null or empty");
        C7105e.m34671d(url, "ResourceURL is null");
        C7105e.m34669f(str2, "VerificationParameters is null or empty");
        return new C7080g(str, url, str2);
    }

    /* renamed from: b */
    public static C7080g m34814b(URL url) {
        C7105e.m34671d(url, "ResourceURL is null");
        return new C7080g(null, url, null);
    }

    /* renamed from: c */
    public URL m34813c() {
        return this.f24207b;
    }

    /* renamed from: d */
    public String m34812d() {
        return this.f24206a;
    }

    /* renamed from: e */
    public String m34811e() {
        return this.f24208c;
    }
}
