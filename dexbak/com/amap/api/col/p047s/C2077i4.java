package com.amap.api.col.p047s;

import com.amap.api.col.p047s.C2073i1;
import com.amap.api.services.core.ServiceSettings;

/* compiled from: ConfigableConst.java */
/* renamed from: com.amap.api.col.s.i4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2077i4 {

    /* renamed from: a */
    public static final String[] f6208a = {"com.amap.api.services", "com.amap.api.search.admic"};

    /* renamed from: a */
    public static C2073i1 m52895a(boolean z) {
        try {
            return new C2073i1.C2074a("sea", "9.7.0", "AMAP SDK Android Search 9.7.0").m52910c(f6208a).m52911b(z).m52912a("9.7.0").m52909d();
        } catch (C2022bv e) {
            C2082j4.m52825i(e, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }

    /* renamed from: b */
    public static String m52894b() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v3" : "https://restsdk.amap.com/v3";
    }

    /* renamed from: c */
    public static String m52893c() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v4" : "https://restsdk.amap.com/v4";
    }

    /* renamed from: d */
    public static String m52892d() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v5" : "https://restsdk.amap.com/v5";
    }

    /* renamed from: e */
    public static String m52891e() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://yuntuapi.amap.com" : "https://yuntuapi.amap.com";
    }

    /* renamed from: f */
    public static String m52890f() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/rest/me/cpoint" : "https://restsdk.amap.com/rest/me/cpoint";
    }

    /* renamed from: g */
    public static String m52889g() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://apistore.amap.com" : "https://apistore.amap.com";
    }

    /* renamed from: h */
    public static String m52888h() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://m5.amap.com/ws/mapapi/shortaddress/transform" : "https://m5.amap.com/ws/mapapi/shortaddress/transform";
    }
}
