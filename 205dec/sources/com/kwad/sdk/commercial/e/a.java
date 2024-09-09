package com.kwad.sdk.commercial.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static void a(@Nullable SceneImpl sceneImpl, long j4, String str) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu("ad_client_error_log").i(0.01d).a(d.ca(sceneImpl.getAdStyle())).N("ad_sdk_ad_parse_performance", "default").u(c.AO().cD(str).setPosId(sceneImpl.posId).setLlsid(j4)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bA(@NonNull AdTemplate adTemplate) {
        try {
            if (adTemplate.llsid == 0) {
                c(adTemplate, "llsid", "");
            }
            if (e.ea(adTemplate) == 0) {
                c(adTemplate, "create_id", "");
            }
            AdInfo dQ = e.dQ(adTemplate);
            int i4 = dQ.adBaseInfo.adOperationType;
            if (i4 == 1) {
                String cO = com.kwad.sdk.core.response.b.a.cO(dQ);
                if (bn.hb(cO)) {
                    c(adTemplate, DownloadModel.DOWNLOAD_URL, cO);
                }
            } else if (i4 == 2) {
                String aS = com.kwad.sdk.core.response.b.a.aS(dQ);
                if (bn.hb(aS)) {
                    c(adTemplate, "h5_url", aS);
                }
            }
            AdInfo.AdMaterialInfo.MaterialFeature N = com.kwad.sdk.core.response.b.a.N(dQ);
            int i5 = N.featureType;
            String str = N.materialUrl;
            if (i5 == 1) {
                if (bn.hb(str)) {
                    c(adTemplate, CampaignEx.JSON_KEY_VIDEO_URL, str);
                }
            } else if (i5 == 2) {
                if (bn.hb(str)) {
                    c(adTemplate, CampaignEx.JSON_KEY_IMAGE_URL, str);
                }
            } else if (i5 == 3) {
                long cg = com.kwad.sdk.core.response.b.a.cg(dQ);
                String bg = com.kwad.sdk.core.response.b.a.bg(dQ);
                if (cg == 0) {
                    c(adTemplate, "live_author_id", "");
                } else if (TextUtils.isEmpty(bg)) {
                    c(adTemplate, "live_stream_id", bg);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void c(AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu("ad_client_error_log").i(0.01d).a(d.aS(adTemplate)).N("ad_sdk_ad_data_performance", "error_name").u(b.AN().cB(str).cC(str2).setAdTemplate(adTemplate)));
    }

    public static void e(AdTemplate adTemplate, String str) {
        c(adTemplate, "tk_template_id", str);
    }

    public static void a(@Nullable SceneImpl sceneImpl, long j4, String str, String str2) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu("ad_client_error_log").i(0.01d).a(d.ca(sceneImpl.getAdStyle())).N("ad_sdk_ad_parse_performance", "default").u(c.AO().cD(str).cE(str2).setErrorCode(100013).setPosId(sceneImpl.posId).setLlsid(j4)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
