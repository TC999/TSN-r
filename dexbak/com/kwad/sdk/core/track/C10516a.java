package com.kwad.sdk.core.track;

import androidx.annotation.NonNull;
import com.kwad.sdk.C10756f;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.commercial.p381j.C9844a;
import com.kwad.sdk.core.adlog.p388c.C9912a;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.core.network.p406c.C10416a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11007ab;
import com.kwad.sdk.utils.C11014ah;
import com.kwad.sdk.utils.C11064bn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.sdk.core.track.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10516a {
    /* renamed from: a */
    private static List<String> m25568a(AdTemplate adTemplate, int i, @NonNull C9912a c9912a) {
        List<String> list;
        ArrayList arrayList = new ArrayList();
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        List<AdInfo.AdTrackInfo> list2 = m25641dQ.adTrackInfoList;
        if (C11014ah.m24126I(list2)) {
            return arrayList;
        }
        List<String> m25569a = m25569a(i, c9912a, arrayList, m25641dQ, list2);
        if (m25569a != null) {
            return m25569a;
        }
        Iterator<AdInfo.AdTrackInfo> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdInfo.AdTrackInfo next = it.next();
            if (next.type == i && (list = next.urls) != null) {
                arrayList.addAll(list);
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static void m25567d(@NonNull C9912a c9912a) {
        AdTemplate adTemplate = c9912a.adTemplate;
        int i = c9912a.aoM;
        List<String> m25568a = m25568a(adTemplate, i, c9912a);
        if (C11014ah.m24126I(m25568a)) {
            return;
        }
        for (String str : m25568a) {
            C9844a.m27525o(adTemplate, i, str);
            if (adTemplate.isCheatingFlow()) {
                C9844a.m27526n(adTemplate, i, str);
                return;
            } else if (C11064bn.m23857hb(str)) {
                C9844a.m27530a(adTemplate, i, str, "", 100001, "", 0);
                return;
            } else {
                String m24157a = C11007ab.m24157a(ServiceProvider.getContext(), str, i == 2 ? c9912a.f29529kn : null, C10483a.m25960aB(C10487e.m25641dQ(adTemplate)));
                AdHttpProxy m24902xT = C10756f.m24902xT();
                int i2 = m24902xT instanceof C10416a ? 2 : 1;
                C10415c doGetWithoutResponse = m24902xT.doGetWithoutResponse(m24157a, null);
                if (m25566dp(doGetWithoutResponse.code)) {
                    C10331c.m26254d("AdTrackUtil", "trackUrl request success actionType: " + i);
                    C9844a.m27531a(adTemplate, i, str, doGetWithoutResponse.code, i2);
                } else {
                    C9844a.m27530a(adTemplate, i, str, m24157a, C9825d.m27621cb(doGetWithoutResponse.code), doGetWithoutResponse.avs, i2);
                }
            }
        }
    }

    /* renamed from: dp */
    private static boolean m25566dp(int i) {
        return i >= 200 && i < 300;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        r4.addAll(r6);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.lang.String> m25569a(int r2, com.kwad.sdk.core.adlog.p388c.C9912a r3, java.util.List<java.lang.String> r4, com.kwad.sdk.core.response.model.AdInfo r5, java.util.List<com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo> r6) {
        /*
            r0 = 402(0x192, float:5.63E-43)
            if (r2 != r0) goto L4f
            boolean r2 = com.kwad.sdk.core.response.p409b.C10483a.m25868bl(r5)
            if (r2 == 0) goto L4f
            java.lang.String r2 = r3.f29522KG     // Catch: java.lang.Throwable -> L4e
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L4e
            if (r2 != 0) goto L20
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = r3.f29522KG     // Catch: java.lang.Throwable -> L4e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = "photoPlaySecond"
            int r2 = r2.optInt(r3)     // Catch: java.lang.Throwable -> L4e
            goto L22
        L20:
            int r2 = r3.apI     // Catch: java.lang.Throwable -> L4e
        L22:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4e
            com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo r5 = r5.adBaseInfo     // Catch: java.lang.Throwable -> L4e
            java.lang.String r5 = r5.videoPlayedNSConfig     // Catch: java.lang.Throwable -> L4e
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L4e
            java.util.Iterator r5 = r6.iterator()     // Catch: java.lang.Throwable -> L4e
        L2f:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L4e
            if (r6 == 0) goto L4e
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L4e
            com.kwad.sdk.core.response.model.AdInfo$AdTrackInfo r6 = (com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo) r6     // Catch: java.lang.Throwable -> L4e
            int r0 = r6.type     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L4e
            int r1 = r3.optInt(r1)     // Catch: java.lang.Throwable -> L4e
            if (r0 != r1) goto L2f
            java.util.List<java.lang.String> r6 = r6.urls     // Catch: java.lang.Throwable -> L4e
            if (r6 == 0) goto L2f
            r4.addAll(r6)     // Catch: java.lang.Throwable -> L4e
        L4e:
            return r4
        L4f:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.track.C10516a.m25569a(int, com.kwad.sdk.core.adlog.c.a, java.util.List, com.kwad.sdk.core.response.model.AdInfo, java.util.List):java.util.List");
    }
}
