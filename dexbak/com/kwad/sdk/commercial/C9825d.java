package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.C11053bg;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* renamed from: com.kwad.sdk.commercial.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9825d {
    /* renamed from: aS */
    public static BusinessType m27624aS(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return BusinessType.OTHER;
        }
        return m27622ca(C10487e.m25646dL(adTemplate));
    }

    @Nullable
    /* renamed from: aT */
    public static AdMatrixInfo.MatrixTemplate m27623aT(AdTemplate adTemplate) {
        String str;
        SceneImpl sceneImpl = adTemplate.mAdScene;
        if (sceneImpl == null) {
            return null;
        }
        AdMatrixInfo.AdDataV2 adDataV2 = C10484b.m25765cc(adTemplate).adDataV2;
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
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : C10484b.m25764cd(adTemplate)) {
            if (C11053bg.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return C10484b.m25668k(adTemplate, str);
    }

    /* renamed from: ca */
    public static BusinessType m27622ca(int i) {
        if (i == 3) {
            return BusinessType.AD_FULLSCREEN;
        }
        if (i == 2) {
            return BusinessType.AD_REWARD;
        }
        if (i == 4) {
            return BusinessType.AD_SPLASH;
        }
        if (i == 13) {
            return BusinessType.AD_INTERSTITIAL;
        }
        if (i == 1) {
            return BusinessType.AD_FEED;
        }
        if (i == 10000) {
            return BusinessType.AD_NATIVE;
        }
        return BusinessType.OTHER;
    }

    /* renamed from: cb */
    public static int m27621cb(int i) {
        if (i == -1) {
            return 100010;
        }
        if (i == -2) {
            return 100011;
        }
        return i;
    }
}
