package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public static int Ci;
    private String Cj;
    private int Ck = 2;

    private void S(String str) {
        this.Cj = str;
    }

    private void V(int i4) {
        this.Ck = i4;
    }

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar, int i4) {
        d dVar = new d();
        Ci = i4;
        if (adInfo != null && cVar != null) {
            if (i4 != 1 && i4 != 4) {
                if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
                    int nW = cVar.nW();
                    dVar.S("\u6216\u70b9\u51fb" + a(adTemplate, adInfo, nW, 0));
                } else {
                    String a4 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CO);
                    if (TextUtils.isEmpty(a4)) {
                        a4 = "\u70b9\u51fb\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
                    }
                    dVar.S("\u6216" + a4);
                }
            } else {
                dVar.S(a(adTemplate, adInfo, cVar));
            }
        }
        dVar.V(com.kwad.sdk.core.response.b.b.ds(adInfo));
        return dVar;
    }

    public final String ku() {
        return this.Cj;
    }

    public final int kv() {
        return this.Ck;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i4, int i5) {
        String aE = com.kwad.sdk.core.response.b.a.aE(adInfo);
        if (i4 == 2) {
            return i5 + "%";
        } else if (i4 != 4) {
            if (i4 != 8) {
                return i4 != 12 ? aE : com.kwad.sdk.core.response.b.a.ac(adInfo);
            }
            return com.kwad.sdk.core.response.b.a.bY(adTemplate);
        } else {
            return "\u7ee7\u7eed\u4e0b\u8f7d";
        }
    }

    private static String a(AdInfo adInfo, int i4) {
        return i4 == 1 ? com.kwad.sdk.core.response.b.b.dm(adInfo) != null ? com.kwad.sdk.core.response.b.b.dm(adInfo) : "" : (i4 != 4 || com.kwad.sdk.core.response.b.b.dn(adInfo) == null) ? "" : com.kwad.sdk.core.response.b.b.dn(adInfo);
    }

    private static String a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            return a(adTemplate, adInfo, cVar.nW(), 0);
        }
        String a4 = a(adInfo, Ci);
        return TextUtils.isEmpty(a4) ? "\u70b9\u51fb\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528" : a4;
    }
}
