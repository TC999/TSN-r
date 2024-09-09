package com.kwad.components.ad.reward.model;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public static String m(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.cL(adInfo) ? "live" : com.kwad.sdk.core.response.b.a.bd(adInfo) ? "image" : com.kwad.sdk.core.response.b.a.bX(adInfo) ? "reward_preview" : "video";
    }
}
