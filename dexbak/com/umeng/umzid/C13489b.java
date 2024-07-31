package com.umeng.umzid;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* renamed from: com.umeng.umzid.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C13489b implements HostnameVerifier {

    /* renamed from: a */
    public final /* synthetic */ String f39668a;

    public C13489b(String str) {
        this.f39668a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f39668a.equalsIgnoreCase(str) || "pre-aaid.umeng.com".equalsIgnoreCase(str);
    }
}
