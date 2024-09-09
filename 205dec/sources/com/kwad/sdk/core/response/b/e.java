package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    public static boolean F(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo dQ = dQ(adTemplate);
        return (a.aF(dQ) || a.cR(dQ) || dY(adTemplate) != 3) ? false : true;
    }

    @Nullable
    private static g Fh() {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar != null) {
            return fVar.tD();
        }
        return null;
    }

    @Nullable
    public static AdTemplate a(List<AdTemplate> list, long j4, int i4) {
        if (j4 >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (c(adTemplate, j4, i4)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    public static boolean b(List<AdTemplate> list, long j4, int i4) {
        AdTemplate a4 = a(list, j4, i4);
        if (a4 == null) {
            return false;
        }
        long ea = ea(a4);
        int dK = dK(a4);
        if (i4 > 0) {
            if (ea != j4 || dK != i4) {
                return false;
            }
        } else if (ea != j4) {
            return false;
        }
        return true;
    }

    public static boolean c(AdTemplate adTemplate, long j4, int i4) {
        long ea = ea(adTemplate);
        int dK = dK(adTemplate);
        if (i4 > 0) {
            if (ea == j4 && dK == i4) {
                return true;
            }
        } else if (ea == j4) {
            return true;
        }
        return false;
    }

    public static boolean dI(@NonNull AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    public static long dJ(@NonNull AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    public static int dK(@NonNull AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    public static int dL(AdTemplate adTemplate) {
        if (adTemplate != null) {
            SceneImpl sceneImpl = adTemplate.mAdScene;
            return sceneImpl != null ? sceneImpl.getAdStyle() : dK(adTemplate);
        }
        return 0;
    }

    public static int dM(@NonNull AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    public static long dN(@NonNull AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    public static String dO(@NonNull AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    public static String dP(@NonNull AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    @NonNull
    public static AdInfo dQ(@NonNull AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo == null) {
            com.kwad.sdk.core.e.c.e("AdTemplateHelper", "adInfo in null");
            return new AdInfo();
        }
        return adInfo;
    }

    @NonNull
    public static PhotoInfo dR(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    public static String dS(@NonNull AdTemplate adTemplate) {
        if (dI(adTemplate)) {
            return a.K(dQ(adTemplate));
        }
        return h.a(dR(adTemplate));
    }

    public static String dT(@NonNull AdTemplate adTemplate) {
        return dQ(adTemplate).adConversionInfo.appDownloadUrl;
    }

    public static String dU(@NonNull AdTemplate adTemplate) {
        g Fh = Fh();
        String Fl = Fh == null ? "" : Fh.Fl();
        return TextUtils.isEmpty(Fl) ? Fl : a.Y(dQ(adTemplate));
    }

    public static String dV(@NonNull AdTemplate adTemplate) {
        if (dI(adTemplate)) {
            return a.cf(dQ(adTemplate));
        }
        g Fh = Fh();
        return Fh == null ? "" : Fh.Fm();
    }

    public static long dW(@NonNull AdTemplate adTemplate) {
        if (dI(adTemplate)) {
            return a.ab(dQ(adTemplate));
        }
        g Fh = Fh();
        return Fh == null ? adTemplate.hashCode() : Fh.Fn();
    }

    public static int dX(@NonNull AdTemplate adTemplate) {
        g Fh = Fh();
        if (Fh == null) {
            return 0;
        }
        return Fh.Fo();
    }

    public static int dY(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return dQ(adTemplate).adBaseInfo.taskType;
    }

    public static String dZ(@NonNull AdTemplate adTemplate) {
        if (dI(adTemplate)) {
            return a.cC(dQ(adTemplate));
        }
        return h.c(dR(adTemplate));
    }

    public static long ea(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return dQ(adTemplate).adBaseInfo.creativeId;
    }

    public static boolean eb(AdTemplate adTemplate) {
        return dQ(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    public static boolean ec(@NonNull AdTemplate adTemplate) {
        int j4 = j(adTemplate, true);
        return j4 == 1 || j4 == 2;
    }

    public static boolean ed(@NonNull AdTemplate adTemplate) {
        int j4 = j(adTemplate, false);
        return j4 == 1 || j4 == 2;
    }

    public static int ee(@NonNull AdTemplate adTemplate) {
        return dQ(adTemplate).adBaseInfo.ecpm;
    }

    public static boolean ef(@NonNull AdTemplate adTemplate) {
        AdInfo dQ = dQ(adTemplate);
        return dQ.adStyleConfInfo.adPushDownloadJumpType == 0 && dK(adTemplate) == 17 && a.aF(dQ);
    }

    public static int eg(@NonNull AdTemplate adTemplate) {
        AdVideoPreCacheConfig adVideoPreCacheConfig = adTemplate.adVideoPreCacheConfig;
        if (adVideoPreCacheConfig == null) {
            com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
            if (hVar != null) {
                return hVar.yU();
            }
            return 800;
        }
        return adVideoPreCacheConfig.adVideoPreCacheSize;
    }

    public static boolean i(AdTemplate adTemplate, boolean z3) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo dQ = dQ(adTemplate);
        return a.aF(dQ) && !a.cR(dQ) && !z3 && dY(adTemplate) == 2;
    }

    public static int j(@NonNull AdTemplate adTemplate, boolean z3) {
        AdInfo dQ = dQ(adTemplate);
        if (dK(adTemplate) == 3) {
            AdMatrixInfo.AdDataV2 adDataV2 = dQ.adMatrixInfo.adDataV2;
            int i4 = z3 ? adDataV2.actionBarInfo.cardType : adDataV2.endCardInfo.cardType;
            if (i4 == 5) {
                return 1;
            }
            return i4 == 6 ? 2 : -1;
        }
        return dQ.adBaseInfo.mABParams.playableStyle;
    }
}
