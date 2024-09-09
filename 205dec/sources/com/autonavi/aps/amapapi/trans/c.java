package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.e4;
import com.amap.api.col.p0003l.h4;
import com.amap.api.col.p0003l.k4;
import com.amap.api.col.p0003l.o4;
import com.amap.api.col.p0003l.q4;
import com.amap.api.col.p0003l.q6;
import com.amap.api.col.p0003l.y6;
import com.autonavi.aps.amapapi.utils.j;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.HashMap;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LocNetManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static c f11932b;

    /* renamed from: a  reason: collision with root package name */
    q6 f11933a;

    /* renamed from: c  reason: collision with root package name */
    private Context f11934c;

    /* renamed from: d  reason: collision with root package name */
    private int f11935d = com.autonavi.aps.amapapi.utils.b.f12013i;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11936e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f11937f = 0;

    private c(Context context) {
        this.f11933a = null;
        this.f11934c = null;
        try {
            k4.a().c(context);
        } catch (Throwable unused) {
        }
        this.f11934c = context;
        this.f11933a = q6.b();
    }

    public static c a(Context context) {
        if (f11932b == null) {
            f11932b = new c(context);
        }
        return f11932b;
    }

    public final void a(long j4, boolean z3, int i4) {
        try {
            this.f11936e = z3;
            this.f11935d = Long.valueOf(j4).intValue();
            this.f11937f = i4;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LocNetManager", "setOption");
        }
    }

    public final d a(Context context, byte[] bArr, String str, String str2, boolean z3) {
        try {
            HashMap hashMap = new HashMap(16);
            d dVar = new d(context, com.autonavi.aps.amapapi.utils.b.c());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.3");
                hashMap.put("KEY", e4.j(context));
                hashMap.put("enginever", com.autonavi.aps.amapapi.utils.b.f12005a);
                String a4 = h4.a();
                String c4 = h4.c(context, a4, "key=" + e4.j(context));
                hashMap.put("ts", a4);
                hashMap.put("scode", c4);
                if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f12005a).doubleValue() >= 5.3d) {
                    hashMap.put("aps_s_src", "openapi");
                }
                hashMap.put("encr", "1");
                dVar.b(hashMap);
                String str3 = z3 ? "loc" : "locf";
                dVar.b(true);
                dVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.3", str3, 3));
                dVar.a(z3);
                dVar.b(str);
                dVar.c(str2);
                dVar.c(j.a(bArr));
                dVar.setProxy(o4.c(context));
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put("policy", "3103");
                int i4 = this.f11937f;
                if (i4 == 0) {
                    hashMap2.remove("custom");
                } else if (i4 == 1) {
                    hashMap2.put("custom", "language:cn");
                } else if (i4 != 2) {
                    hashMap2.remove("custom");
                } else {
                    hashMap2.put("custom", "language:en");
                }
                dVar.a(hashMap2);
                dVar.setConnectionTimeout(this.f11935d);
                dVar.setSoTimeout(this.f11935d);
                if (this.f11936e) {
                    dVar.setHttpProtocol(Cif.c.HTTPS);
                    return dVar;
                }
                return dVar;
            } catch (Throwable unused) {
                return dVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final y6 a(d dVar) throws Throwable {
        if (this.f11936e) {
            dVar.setHttpProtocol(Cif.c.HTTPS);
        }
        return q6.d(dVar);
    }

    public final String a(Context context, double d4, double d5) {
        try {
            HashMap hashMap = new HashMap(16);
            d dVar = new d(context, com.autonavi.aps.amapapi.utils.b.c());
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.3");
            HashMap hashMap2 = new HashMap(16);
            hashMap2.put("custom", "26260A1F00020002");
            hashMap2.put(DomainCampaignEx.LOOPBACK_KEY, e4.j(context));
            int i4 = this.f11937f;
            if (i4 == 0) {
                hashMap2.remove("language");
            } else if (i4 == 1) {
                hashMap2.put("language", "zh-CN");
            } else if (i4 != 2) {
                hashMap2.remove("language");
            } else {
                hashMap2.put("language", "en");
            }
            hashMap2.put("curLocationType", j.m(this.f11934c) ? "coarseLoc" : "fineLoc");
            String a4 = h4.a();
            String c4 = h4.c(context, a4, q4.r(hashMap2));
            hashMap2.put("ts", a4);
            hashMap2.put("scode", c4);
            dVar.b(("output=json&radius=1000&extensions=all&location=" + d5 + "," + d4).getBytes("UTF-8"));
            dVar.b(false);
            dVar.a(true);
            dVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.3", "loc", 3));
            dVar.a(hashMap2);
            dVar.b(hashMap);
            dVar.setProxy(o4.c(context));
            dVar.setConnectionTimeout(com.autonavi.aps.amapapi.utils.b.f12013i);
            dVar.setSoTimeout(com.autonavi.aps.amapapi.utils.b.f12013i);
            dVar.c("http://dualstack-arestapi.amap.com/v3/geocode/regeo");
            dVar.b("http://restsdk.amap.com/v3/geocode/regeo");
            if (this.f11936e) {
                dVar.setHttpProtocol(Cif.c.HTTPS);
            }
            return new String(q6.d(dVar).f9524a, "utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }
}
