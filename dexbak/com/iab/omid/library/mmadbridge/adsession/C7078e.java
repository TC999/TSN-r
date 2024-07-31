package com.iab.omid.library.mmadbridge.adsession;

import com.iab.omid.library.mmadbridge.p204d.C7105e;

/* renamed from: com.iab.omid.library.mmadbridge.adsession.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7078e {

    /* renamed from: a */
    private final String f24204a;

    /* renamed from: b */
    private final String f24205b;

    private C7078e(String str, String str2) {
        this.f24204a = str;
        this.f24205b = str2;
    }

    /* renamed from: a */
    public static C7078e m34819a(String str, String str2) {
        C7105e.m34669f(str, "Name is null or empty");
        C7105e.m34669f(str2, "Version is null or empty");
        return new C7078e(str, str2);
    }

    /* renamed from: b */
    public String m34818b() {
        return this.f24204a;
    }

    /* renamed from: c */
    public String m34817c() {
        return this.f24205b;
    }
}
