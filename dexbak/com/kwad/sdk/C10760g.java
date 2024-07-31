package com.kwad.sdk;

import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.idc.C10425a;

/* renamed from: com.kwad.sdk.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10760g {
    /* renamed from: bU */
    public static String m24896bU(String str) {
        return str + "/rest/e/system/speed";
    }

    /* renamed from: xV */
    public static String m24895xV() {
        String str = "https://" + C10425a.m26107DU().m26103W("api", "open.e.kuaishou.com");
        C9861c.m27501f(DevelopMangerComponents.class);
        return str;
    }

    /* renamed from: xW */
    public static String m24894xW() {
        return m24895xV() + "/rest/e/v3/open/univ";
    }

    /* renamed from: xX */
    public static String m24893xX() {
        return m24895xV() + "/rest/e/v4/open/univ";
    }

    /* renamed from: xY */
    public static String m24892xY() {
        return m24895xV() + "/rest/e/v4/open/univ/bidding";
    }

    /* renamed from: xZ */
    public static String m24891xZ() {
        return m24895xV() + "/rest/e/v4/open/univ/getMaterial";
    }

    /* renamed from: ya */
    public static String m24890ya() {
        return m24895xV() + "/rest/e/v3/open/logBatch";
    }

    /* renamed from: yb */
    public static String m24889yb() {
        return m24895xV() + "/rest/e/v3/open/config";
    }

    /* renamed from: yc */
    public static String m24888yc() {
        return m24895xV() + "/rest/e/v3/open/callback";
    }

    /* renamed from: yd */
    public static String m24887yd() {
        return m24895xV() + "/rest/e/v3/open/crashLog";
    }

    /* renamed from: ye */
    public static String m24886ye() {
        return m24895xV() + "/rest/e/v3/open/appCheck";
    }

    /* renamed from: yf */
    public static String m24885yf() {
        return m24895xV() + "/rest/e/v3/open/collect";
    }

    /* renamed from: yg */
    public static String m24884yg() {
        return m24895xV() + "/rest/e/v3/open/checkReward";
    }

    /* renamed from: yh */
    public static String m24883yh() {
        return m24895xV() + "/rest/e/v3/open/kwaiGeoLocation";
    }
}
