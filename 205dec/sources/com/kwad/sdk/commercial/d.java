package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public static BusinessType aS(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return BusinessType.OTHER;
        }
        return ca(e.dL(adTemplate));
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate aT(AdTemplate adTemplate) {
        String str;
        SceneImpl sceneImpl = adTemplate.mAdScene;
        if (sceneImpl == null) {
            return null;
        }
        AdMatrixInfo.AdDataV2 adDataV2 = com.kwad.sdk.core.response.b.b.cc(adTemplate).adDataV2;
        int adStyle = sceneImpl.getAdStyle();
        if (adStyle == 2) {
            str = adDataV2.neoTKInfo.templateId;
        } else if (adStyle == 3) {
            str = adDataV2.fullScreenInfo.templateId;
        } else if (adStyle != 4) {
            str = adStyle != 13 ? "" : adDataV2.interstitialCardInfo.templateId;
        } else {
            str = adDataV2.splashPlayCardTKInfo.templateId;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : com.kwad.sdk.core.response.b.b.cd(adTemplate)) {
            if (bg.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return com.kwad.sdk.core.response.b.b.k(adTemplate, str);
    }

    public static BusinessType ca(int i4) {
        if (i4 == 3) {
            return BusinessType.AD_FULLSCREEN;
        }
        if (i4 == 2) {
            return BusinessType.AD_REWARD;
        }
        if (i4 == 4) {
            return BusinessType.AD_SPLASH;
        }
        if (i4 == 13) {
            return BusinessType.AD_INTERSTITIAL;
        }
        if (i4 == 1) {
            return BusinessType.AD_FEED;
        }
        if (i4 == 10000) {
            return BusinessType.AD_NATIVE;
        }
        return BusinessType.OTHER;
    }

    public static int cb(int i4) {
        if (i4 == -1) {
            return 100010;
        }
        if (i4 == -2) {
            return 100011;
        }
        return i4;
    }
}
