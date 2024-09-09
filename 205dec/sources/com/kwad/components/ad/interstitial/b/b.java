package com.kwad.components.ad.interstitial.b;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static int b(AdInfo adInfo) {
        int intValue = a.jv.getValue().intValue();
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            int L2 = com.kwad.sdk.core.response.b.a.L(adInfo);
            return intValue == 0 ? L2 : Math.min(intValue, L2);
        } else if (intValue > 60 || intValue <= 0) {
            return 60;
        } else {
            return intValue;
        }
    }

    public static boolean cE() {
        return a.jx.getValue().booleanValue();
    }

    public static boolean cF() {
        return a.jr.getValue().intValue() == 1;
    }

    public static int cG() {
        return a.js.getValue().intValue();
    }

    public static boolean cH() {
        return a.jt.getValue().intValue() == 1;
    }

    public static boolean cI() {
        return a.ju.getValue().intValue() == 1;
    }

    public static int cJ() {
        return a.jz.getValue().intValue();
    }

    public static boolean cK() {
        return a.jw.getValue().intValue() == 1;
    }

    public static boolean cL() {
        return a.jy.getValue().intValue() == 1;
    }
}
