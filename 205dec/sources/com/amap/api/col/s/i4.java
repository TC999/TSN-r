package com.amap.api.col.s;

import com.amap.api.col.s.i1;
import com.amap.api.services.core.ServiceSettings;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ConfigableConst.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i4 {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f9936a = {"com.amap.api.services", "com.amap.api.search.admic"};

    public static i1 a(boolean z3) {
        try {
            return new i1.a("sea", "9.7.0", "AMAP SDK Android Search 9.7.0").c(f9936a).b(z3).a("9.7.0").d();
        } catch (bv e4) {
            j4.i(e4, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }

    public static String b() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v3" : "https://restsdk.amap.com/v3";
    }

    public static String c() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v4" : "https://restsdk.amap.com/v4";
    }

    public static String d() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v5" : "https://restsdk.amap.com/v5";
    }

    public static String e() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://yuntuapi.amap.com" : "https://yuntuapi.amap.com";
    }

    public static String f() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/rest/me/cpoint" : "https://restsdk.amap.com/rest/me/cpoint";
    }

    public static String g() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://apistore.amap.com" : "https://apistore.amap.com";
    }

    public static String h() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://m5.amap.com/ws/mapapi/shortaddress/transform" : "https://m5.amap.com/ws/mapapi/shortaddress/transform";
    }
}
