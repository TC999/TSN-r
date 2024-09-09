package com.kwad.sdk.commercial.smallApp;

import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void b(AdTemplate adTemplate, JumpFrom jumpFrom, AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        if (adTemplate == null || smallAppJumpInfo == null) {
            return;
        }
        try {
            a(adTemplate, b.a(jumpFrom).cm(2).cT(smallAppJumpInfo.mediaSmallAppId).cS(smallAppJumpInfo.originId).cR(smallAppJumpInfo.smallAppJumpUrl));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z3, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.Br().cz("ad_client_apm_log").i(z3 ? 0.1d : 0.01d).a(d.aT(adTemplate)).N("ad_sdk_small_app_performance", "status").t(aVar));
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        if (adTemplate == null || smallAppJumpInfo == null) {
            return;
        }
        try {
            a(adTemplate, b.a(jumpFrom).cm(1).cT(smallAppJumpInfo.mediaSmallAppId).cS(smallAppJumpInfo.originId).cR(smallAppJumpInfo.smallAppJumpUrl));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, String str, String str2, String str3) {
        try {
            a(adTemplate, b.a(jumpFrom).cm(3).cT(str).cS(str2).cR(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, @Nullable AdInfo.SmallAppJumpInfo smallAppJumpInfo, String str) {
        if (adTemplate == null) {
            return;
        }
        try {
            String str2 = "";
            b cS = b.a(jumpFrom).cm(4).cT(smallAppJumpInfo == null ? "" : smallAppJumpInfo.mediaSmallAppId).cS(smallAppJumpInfo == null ? "" : smallAppJumpInfo.originId);
            if (smallAppJumpInfo != null) {
                str2 = smallAppJumpInfo.smallAppJumpUrl;
            }
            a(adTemplate, true, cS.cR(str2).setErrorCode(100008).setErrorMsg(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
