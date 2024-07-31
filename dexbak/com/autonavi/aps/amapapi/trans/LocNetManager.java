package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import com.amap.api.col.p0463l.AbstractC1840if;
import com.amap.api.col.p0463l.BaseNetManager;
import com.amap.api.col.p0463l.C1780e4;
import com.amap.api.col.p0463l.C1925p4;
import com.amap.api.col.p0463l.ClientInfo;
import com.amap.api.col.p0463l.HttpsDecisionUtil;
import com.amap.api.col.p0463l.ProxyUtil;
import com.amap.api.col.p0463l.ResponseEntity;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DTileBuildType;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.autonavi.aps.amapapi.trans.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LocNetManager {

    /* renamed from: b */
    private static LocNetManager f8260b;

    /* renamed from: a */
    BaseNetManager f8261a;

    /* renamed from: c */
    private Context f8262c;

    /* renamed from: d */
    private int f8263d = C2428b.f8375i;

    /* renamed from: e */
    private boolean f8264e = false;

    /* renamed from: f */
    private int f8265f = 0;

    private LocNetManager(Context context) {
        this.f8261a = null;
        this.f8262c = null;
        try {
            HttpsDecisionUtil.m54673a().m54671c(context);
        } catch (Throwable unused) {
        }
        this.f8262c = context;
        this.f8261a = BaseNetManager.m54175b();
    }

    /* renamed from: a */
    public static LocNetManager m51384a(Context context) {
        if (f8260b == null) {
            f8260b = new LocNetManager(context);
        }
        return f8260b;
    }

    /* renamed from: a */
    public final void m51385a(long j, boolean z, int i) {
        try {
            this.f8264e = z;
            this.f8263d = Long.valueOf(j).intValue();
            this.f8265f = i;
        } catch (Throwable th) {
            C2428b.m51299a(th, "LocNetManager", "setOption");
        }
    }

    /* renamed from: a */
    public final LocationRequest m51382a(Context context, byte[] bArr, String str, String str2, boolean z) {
        try {
            HashMap hashMap = new HashMap(16);
            LocationRequest locationRequest = new LocationRequest(context, C2428b.m51294c());
            try {
                hashMap.put("Content-Type", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE);
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.3");
                hashMap.put("KEY", C1780e4.m55240j(context));
                hashMap.put("enginever", C2428b.f8367a);
                String m54933a = ClientInfo.m54933a();
                String m54931c = ClientInfo.m54931c(context, m54933a, "key=" + C1780e4.m55240j(context));
                hashMap.put("ts", m54933a);
                hashMap.put("scode", m54931c);
                if (Double.valueOf(C2428b.f8367a).doubleValue() >= 5.3d) {
                    hashMap.put("aps_s_src", "openapi");
                }
                hashMap.put("encr", "1");
                locationRequest.m51376b(hashMap);
                String str3 = z ? "loc" : "locf";
                locationRequest.m51375b(true);
                locationRequest.m51380a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.3", str3, 3));
                locationRequest.m51378a(z);
                locationRequest.m51377b(str);
                locationRequest.m51372c(str2);
                locationRequest.m51371c(C2432j.m51188a(bArr));
                locationRequest.setProxy(ProxyUtil.m54440c(context));
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put(UMCommonContent.f37843bt, AMap3DTileBuildType.AIRPORT_TERMINAL);
                int i = this.f8265f;
                if (i == 0) {
                    hashMap2.remove("custom");
                } else if (i == 1) {
                    hashMap2.put("custom", "language:cn");
                } else if (i != 2) {
                    hashMap2.remove("custom");
                } else {
                    hashMap2.put("custom", "language:en");
                }
                locationRequest.m51379a(hashMap2);
                locationRequest.setConnectionTimeout(this.f8263d);
                locationRequest.setSoTimeout(this.f8263d);
                if (this.f8264e) {
                    locationRequest.setHttpProtocol(AbstractC1840if.EnumC1843c.HTTPS);
                    return locationRequest;
                }
                return locationRequest;
            } catch (Throwable unused) {
                return locationRequest;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* renamed from: a */
    public final ResponseEntity m51381a(LocationRequest locationRequest) throws Throwable {
        if (this.f8264e) {
            locationRequest.setHttpProtocol(AbstractC1840if.EnumC1843c.HTTPS);
        }
        return BaseNetManager.m54173d(locationRequest);
    }

    /* renamed from: a */
    public final String m51383a(Context context, double d, double d2) {
        try {
            HashMap hashMap = new HashMap(16);
            LocationRequest locationRequest = new LocationRequest(context, C2428b.m51294c());
            hashMap.clear();
            hashMap.put("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.3");
            HashMap hashMap2 = new HashMap(16);
            hashMap2.put("custom", "26260A1F00020002");
            hashMap2.put(DomainCampaignEx.LOOPBACK_KEY, C1780e4.m55240j(context));
            int i = this.f8265f;
            if (i == 0) {
                hashMap2.remove("language");
            } else if (i == 1) {
                hashMap2.put("language", "zh-CN");
            } else if (i != 2) {
                hashMap2.remove("language");
            } else {
                hashMap2.put("language", "en");
            }
            hashMap2.put("curLocationType", C2432j.m51154m(this.f8262c) ? "coarseLoc" : "fineLoc");
            String m54933a = ClientInfo.m54933a();
            String m54931c = ClientInfo.m54931c(context, m54933a, C1925p4.m54186r(hashMap2));
            hashMap2.put("ts", m54933a);
            hashMap2.put("scode", m54931c);
            locationRequest.m51374b(("output=json&radius=1000&extensions=all&location=" + d2 + "," + d).getBytes("UTF-8"));
            locationRequest.m51375b(false);
            locationRequest.m51378a(true);
            locationRequest.m51380a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.3", "loc", 3));
            locationRequest.m51379a(hashMap2);
            locationRequest.m51376b(hashMap);
            locationRequest.setProxy(ProxyUtil.m54440c(context));
            locationRequest.setConnectionTimeout(C2428b.f8375i);
            locationRequest.setSoTimeout(C2428b.f8375i);
            locationRequest.m51372c("http://dualstack-arestapi.amap.com/v3/geocode/regeo");
            locationRequest.m51377b("http://restsdk.amap.com/v3/geocode/regeo");
            if (this.f8264e) {
                locationRequest.setHttpProtocol(AbstractC1840if.EnumC1843c.HTTPS);
            }
            return new String(BaseNetManager.m54173d(locationRequest).f5682a, "utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }
}
