package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public static String F(AdInfo adInfo) {
        return com.kwad.sdk.core.config.d.Cz().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.s.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }

    public static String zS() {
        String CA = com.kwad.sdk.core.config.d.CA();
        return TextUtils.isEmpty(CA) ? "\u5b89\u88c5" : CA;
    }

    public static String zT() {
        String CB = com.kwad.sdk.core.config.d.CB();
        return TextUtils.isEmpty(CB) ? "\u53d6\u6d88" : CB;
    }
}
