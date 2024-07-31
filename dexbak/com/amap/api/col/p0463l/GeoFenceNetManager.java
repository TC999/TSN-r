package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.trans.C2426b;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.socialize.common.SocializeConstants;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.amap.api.col.3l.d0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class GeoFenceNetManager {

    /* renamed from: a */
    BaseNetManager f3789a;

    public GeoFenceNetManager(Context context) {
        this.f3789a = null;
        try {
            HttpsDecisionUtil.m54673a().m54671c(context);
        } catch (Throwable unused) {
        }
        this.f3789a = BaseNetManager.m54175b();
    }

    /* renamed from: d */
    private String m55419d(Context context, String str, Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap(16);
            C2426b c2426b = new C2426b();
            hashMap.clear();
            hashMap.put("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.3");
            String m54933a = ClientInfo.m54933a();
            String m54931c = ClientInfo.m54931c(context, m54933a, C1925p4.m54186r(map));
            map.put("ts", m54933a);
            map.put("scode", m54931c);
            c2426b.m51386b(map);
            c2426b.m51389a(hashMap);
            c2426b.m51390a(str);
            c2426b.setProxy(ProxyUtil.m54440c(context));
            c2426b.setConnectionTimeout(C2428b.f8375i);
            c2426b.setSoTimeout(C2428b.f8375i);
            return new String(BaseNetManager.m54173d(c2426b).f5682a, "utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: e */
    private static Map<String, String> m55418e(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap(16);
        hashMap.put(DomainCampaignEx.LOOPBACK_KEY, C1780e4.m55240j(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("keywords", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            hashMap.put(SocializeConstants.KEY_LOCATION, str6 + "," + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(DistrictSearchQuery.KEYWORDS_CITY, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }

    /* renamed from: a */
    public final String m55422a(Context context, String str, String str2) {
        Map<String, String> m55418e = m55418e(context, str2, null, null, null, null, null, null);
        m55418e.put("extensions", "all");
        m55418e.put("subdistrict", "0");
        return m55419d(context, str, m55418e);
    }

    /* renamed from: b */
    public final String m55421b(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> m55418e = m55418e(context, str2, str3, str4, str5, null, null, null);
        m55418e.put("children", "1");
        m55418e.put("page", "1");
        m55418e.put("extensions", "base");
        return m55419d(context, str, m55418e);
    }

    /* renamed from: c */
    public final String m55420c(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> m55418e = m55418e(context, str2, str3, null, str4, str5, str6, str7);
        m55418e.put("children", "1");
        m55418e.put("page", "1");
        m55418e.put("extensions", "base");
        return m55419d(context, str, m55418e);
    }
}
