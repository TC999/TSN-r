package com.kwad.components.ad.reward.monitor;

import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static void a(boolean z3, AdTemplate adTemplate) {
        a(z3, z3 ? "ad_sdk_neo_video_cache_monitor" : "ad_sdk_fullscreen_video_cache_monitor", adTemplate, z3 ? 102001 : 103001);
    }

    public static void b(boolean z3, AdTemplate adTemplate) {
        a(z3, z3 ? "ad_sdk_neo_page_enter_monitor" : "ad_sdk_fullscreen_page_enter_monitor", adTemplate, z3 ? 102002 : 103002);
    }

    public static void c(boolean z3, int i4) {
        a(z3, z3 ? "ad_sdk_neo_request_monitor" : "ad_sdk_fullscreen_request_monitor", null, i4);
    }

    public static void a(AdTemplate adTemplate, TKRenderFailReason tKRenderFailReason) {
        int i4;
        boolean z3 = e.dK(adTemplate) == 2;
        String str = z3 ? "ad_sdk_neo_page_native_monitor" : "ad_sdk_fullscreen_page_native_monitor";
        if (TKRenderFailReason.SWITCH_CLOSE.equals(tKRenderFailReason)) {
            i4 = z3 ? 102003 : 103003;
        } else {
            i4 = TKRenderFailReason.TK_FILE_LOAD_ERROR.equals(tKRenderFailReason) ? z3 ? 102004 : 103004 : 102005;
        }
        a(z3, str, adTemplate, i4);
    }

    public static void c(boolean z3, AdTemplate adTemplate) {
        a(z3, z3 ? "ad_sdk_neo_video_play_monitor" : "ad_sdk_fullscreen_video_play_monitor", adTemplate, z3 ? 102007 : 103007);
    }

    private static void a(boolean z3, String str, AdTemplate adTemplate, int i4) {
        AdInfo dQ;
        com.kwad.sdk.commercial.b.a(z3, str, new RewardMonitorInfo().setErrorCode(i4).setCreativeId((adTemplate == null || (dQ = e.dQ(adTemplate)) == null) ? 0L : com.kwad.sdk.core.response.b.a.J(dQ)).setAdTemplate(adTemplate));
    }
}
