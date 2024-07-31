package com.kwad.components.p208ad.reward.monitor;

import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.monitor.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8031b {
    /* renamed from: a */
    public static void m31782a(boolean z, AdTemplate adTemplate) {
        m31781a(z, z ? "ad_sdk_neo_video_cache_monitor" : "ad_sdk_fullscreen_video_cache_monitor", adTemplate, z ? 102001 : 103001);
    }

    /* renamed from: b */
    public static void m31780b(boolean z, AdTemplate adTemplate) {
        m31781a(z, z ? "ad_sdk_neo_page_enter_monitor" : "ad_sdk_fullscreen_page_enter_monitor", adTemplate, z ? 102002 : 103002);
    }

    /* renamed from: c */
    public static void m31779c(boolean z, int i) {
        m31781a(z, z ? "ad_sdk_neo_request_monitor" : "ad_sdk_fullscreen_request_monitor", null, i);
    }

    /* renamed from: a */
    public static void m31783a(AdTemplate adTemplate, TKRenderFailReason tKRenderFailReason) {
        int i;
        boolean z = C10487e.m25647dK(adTemplate) == 2;
        String str = z ? "ad_sdk_neo_page_native_monitor" : "ad_sdk_fullscreen_page_native_monitor";
        if (TKRenderFailReason.SWITCH_CLOSE.equals(tKRenderFailReason)) {
            i = z ? 102003 : 103003;
        } else {
            i = TKRenderFailReason.TK_FILE_LOAD_ERROR.equals(tKRenderFailReason) ? z ? 102004 : 103004 : 102005;
        }
        m31781a(z, str, adTemplate, i);
    }

    /* renamed from: c */
    public static void m31778c(boolean z, AdTemplate adTemplate) {
        m31781a(z, z ? "ad_sdk_neo_video_play_monitor" : "ad_sdk_fullscreen_video_play_monitor", adTemplate, z ? 102007 : 103007);
    }

    /* renamed from: a */
    private static void m31781a(boolean z, String str, AdTemplate adTemplate, int i) {
        AdInfo m25641dQ;
        C9815b.m27684a(z, str, new RewardMonitorInfo().setErrorCode(i).setCreativeId((adTemplate == null || (m25641dQ = C10487e.m25641dQ(adTemplate)) == null) ? 0L : C10483a.m25978J(m25641dQ)).setAdTemplate(adTemplate));
    }
}
