package com.kwad.sdk.commercial.p376e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11064bn;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* renamed from: com.kwad.sdk.commercial.e.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9830a {
    /* renamed from: a */
    public static void m27581a(@Nullable SceneImpl sceneImpl, long j, String str) {
        if (sceneImpl == null) {
            return;
        }
        try {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(0.01d).m27634a(C9825d.m27622ca(sceneImpl.getAdStyle())).m27635N("ad_sdk_ad_parse_performance", "default").m27625u(C9832c.m27572AO().m27571cD(str).setPosId(sceneImpl.posId).setLlsid(j)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bA */
    public static void m27579bA(@NonNull AdTemplate adTemplate) {
        try {
            if (adTemplate.llsid == 0) {
                m27578c(adTemplate, "llsid", "");
            }
            if (C10487e.m25631ea(adTemplate) == 0) {
                m27578c(adTemplate, "create_id", "");
            }
            AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
            int i = m25641dQ.adBaseInfo.adOperationType;
            if (i == 1) {
                String m25839cO = C10483a.m25839cO(m25641dQ);
                if (C11064bn.m23857hb(m25839cO)) {
                    m27578c(adTemplate, DownloadModel.DOWNLOAD_URL, m25839cO);
                }
            } else if (i == 2) {
                String m25943aS = C10483a.m25943aS(m25641dQ);
                if (C11064bn.m23857hb(m25943aS)) {
                    m27578c(adTemplate, "h5_url", m25943aS);
                }
            }
            AdInfo.AdMaterialInfo.MaterialFeature m25974N = C10483a.m25974N(m25641dQ);
            int i2 = m25974N.featureType;
            String str = m25974N.materialUrl;
            if (i2 == 1) {
                if (C11064bn.m23857hb(str)) {
                    m27578c(adTemplate, CampaignEx.JSON_KEY_VIDEO_URL, str);
                }
            } else if (i2 == 2) {
                if (C11064bn.m23857hb(str)) {
                    m27578c(adTemplate, CampaignEx.JSON_KEY_IMAGE_URL, str);
                }
            } else if (i2 == 3) {
                long m25819cg = C10483a.m25819cg(m25641dQ);
                String m25873bg = C10483a.m25873bg(m25641dQ);
                if (m25819cg == 0) {
                    m27578c(adTemplate, "live_author_id", "");
                } else if (TextUtils.isEmpty(m25873bg)) {
                    m27578c(adTemplate, "live_stream_id", m25873bg);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: c */
    private static void m27578c(AdTemplate adTemplate, String str, String str2) {
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(0.01d).m27634a(C9825d.m27624aS(adTemplate)).m27635N("ad_sdk_ad_data_performance", "error_name").m27625u(C9831b.m27576AN().m27574cB(str).m27573cC(str2).setAdTemplate(adTemplate)));
    }

    /* renamed from: e */
    public static void m27577e(AdTemplate adTemplate, String str) {
        m27578c(adTemplate, "tk_template_id", str);
    }

    /* renamed from: a */
    public static void m27580a(@Nullable SceneImpl sceneImpl, long j, String str, String str2) {
        if (sceneImpl == null) {
            return;
        }
        try {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(0.01d).m27634a(C9825d.m27622ca(sceneImpl.getAdStyle())).m27635N("ad_sdk_ad_parse_performance", "default").m27625u(C9832c.m27572AO().m27571cD(str).m27570cE(str2).setErrorCode(100013).setPosId(sceneImpl.posId).setLlsid(j)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
