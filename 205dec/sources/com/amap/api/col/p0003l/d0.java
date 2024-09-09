package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.trans.b;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: GeoFenceNetManager.java */
/* renamed from: com.amap.api.col.3l.d0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    q6 f7359a;

    public d0(Context context) {
        this.f7359a = null;
        try {
            k4.a().c(context);
        } catch (Throwable unused) {
        }
        this.f7359a = q6.b();
    }

    private String d(Context context, String str, Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap(16);
            b bVar = new b();
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.3");
            String a4 = h4.a();
            String c4 = h4.c(context, a4, q4.r(map));
            map.put("ts", a4);
            map.put("scode", c4);
            bVar.b(map);
            bVar.a(hashMap);
            bVar.a(str);
            bVar.setProxy(o4.c(context));
            bVar.setConnectionTimeout(com.autonavi.aps.amapapi.utils.b.f12013i);
            bVar.setSoTimeout(com.autonavi.aps.amapapi.utils.b.f12013i);
            return new String(q6.d(bVar).f9524a, "utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Map<String, String> e(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap(16);
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, e4.j(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("keywords", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            hashMap.put("location", str6 + "," + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("city", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("offset", str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }

    public final String a(Context context, String str, String str2) {
        Map<String, String> e4 = e(context, str2, null, null, null, null, null, null);
        e4.put("extensions", "all");
        e4.put("subdistrict", "0");
        return d(context, str, e4);
    }

    public final String b(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> e4 = e(context, str2, str3, str4, str5, null, null, null);
        e4.put("children", "1");
        e4.put("page", "1");
        e4.put("extensions", "base");
        return d(context, str, e4);
    }

    public final String c(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> e4 = e(context, str2, str3, null, str4, str5, str6, str7);
        e4.put("children", "1");
        e4.put("page", "1");
        e4.put("extensions", "base");
        return d(context, str, e4);
    }
}
