package com.kwad.components.p208ad.interstitial.p239b;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;

/* renamed from: com.kwad.components.ad.interstitial.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7721b {
    /* renamed from: b */
    public static int m32576b(AdInfo adInfo) {
        int intValue = C7720a.f26120jv.getValue().intValue();
        if (C10483a.m25877bc(adInfo)) {
            int m25976L = C10483a.m25976L(adInfo);
            return intValue == 0 ? m25976L : Math.min(intValue, m25976L);
        } else if (intValue > 60 || intValue <= 0) {
            return 60;
        } else {
            return intValue;
        }
    }

    /* renamed from: cE */
    public static boolean m32575cE() {
        return C7720a.f26122jx.getValue().booleanValue();
    }

    /* renamed from: cF */
    public static boolean m32574cF() {
        return C7720a.f26116jr.getValue().intValue() == 1;
    }

    /* renamed from: cG */
    public static int m32573cG() {
        return C7720a.f26117js.getValue().intValue();
    }

    /* renamed from: cH */
    public static boolean m32572cH() {
        return C7720a.f26118jt.getValue().intValue() == 1;
    }

    /* renamed from: cI */
    public static boolean m32571cI() {
        return C7720a.f26119ju.getValue().intValue() == 1;
    }

    /* renamed from: cJ */
    public static int m32570cJ() {
        return C7720a.f26124jz.getValue().intValue();
    }

    /* renamed from: cK */
    public static boolean m32569cK() {
        return C7720a.f26121jw.getValue().intValue() == 1;
    }

    /* renamed from: cL */
    public static boolean m32568cL() {
        return C7720a.f26123jy.getValue().intValue() == 1;
    }
}
