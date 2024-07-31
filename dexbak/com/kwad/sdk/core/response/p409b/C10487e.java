package com.kwad.sdk.core.response.p409b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import java.util.List;

/* renamed from: com.kwad.sdk.core.response.b.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10487e {
    /* renamed from: F */
    public static boolean m25654F(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo m25641dQ = m25641dQ(adTemplate);
        return (C10483a.m25956aF(m25641dQ) || C10483a.m25836cR(m25641dQ) || m25633dY(adTemplate) != 3) ? false : true;
    }

    @Nullable
    /* renamed from: Fh */
    private static InterfaceC10489g m25653Fh() {
        InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
        if (interfaceC10968f != null) {
            return interfaceC10968f.mo24340tD();
        }
        return null;
    }

    @Nullable
    /* renamed from: a */
    public static AdTemplate m25652a(List<AdTemplate> list, long j, int i) {
        if (j >= 0 && list != null) {
            for (AdTemplate adTemplate : list) {
                if (m25650c(adTemplate, j, i)) {
                    return adTemplate;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m25651b(List<AdTemplate> list, long j, int i) {
        AdTemplate m25652a = m25652a(list, j, i);
        if (m25652a == null) {
            return false;
        }
        long m25631ea = m25631ea(m25652a);
        int m25647dK = m25647dK(m25652a);
        if (i > 0) {
            if (m25631ea != j || m25647dK != i) {
                return false;
            }
        } else if (m25631ea != j) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m25650c(AdTemplate adTemplate, long j, int i) {
        long m25631ea = m25631ea(adTemplate);
        int m25647dK = m25647dK(adTemplate);
        if (i > 0) {
            if (m25631ea == j && m25647dK == i) {
                return true;
            }
        } else if (m25631ea == j) {
            return true;
        }
        return false;
    }

    /* renamed from: dI */
    public static boolean m25649dI(@NonNull AdTemplate adTemplate) {
        return (adTemplate.realShowType != 2 || adTemplate.adInfoList.isEmpty() || adTemplate.adInfoList.get(0) == null) ? false : true;
    }

    /* renamed from: dJ */
    public static long m25648dJ(@NonNull AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    /* renamed from: dK */
    public static int m25647dK(@NonNull AdTemplate adTemplate) {
        return adTemplate.adStyle;
    }

    @Deprecated
    /* renamed from: dL */
    public static int m25646dL(AdTemplate adTemplate) {
        if (adTemplate != null) {
            SceneImpl sceneImpl = adTemplate.mAdScene;
            return sceneImpl != null ? sceneImpl.getAdStyle() : m25647dK(adTemplate);
        }
        return 0;
    }

    /* renamed from: dM */
    public static int m25645dM(@NonNull AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    /* renamed from: dN */
    public static long m25644dN(@NonNull AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    /* renamed from: dO */
    public static String m25643dO(@NonNull AdTemplate adTemplate) {
        return adTemplate.extra;
    }

    /* renamed from: dP */
    public static String m25642dP(@NonNull AdTemplate adTemplate) {
        return adTemplate.impAdExtra;
    }

    @NonNull
    /* renamed from: dQ */
    public static AdInfo m25641dQ(@NonNull AdTemplate adTemplate) {
        AdInfo adInfo = adTemplate.adInfoList.size() > 0 ? adTemplate.adInfoList.get(0) : null;
        if (adInfo == null) {
            C10331c.m26250e("AdTemplateHelper", "adInfo in null");
            return new AdInfo();
        }
        return adInfo;
    }

    @NonNull
    /* renamed from: dR */
    public static PhotoInfo m25640dR(@NonNull AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    /* renamed from: dS */
    public static String m25639dS(@NonNull AdTemplate adTemplate) {
        if (m25649dI(adTemplate)) {
            return C10483a.m25977K(m25641dQ(adTemplate));
        }
        return C10490h.m25612a(m25640dR(adTemplate));
    }

    /* renamed from: dT */
    public static String m25638dT(@NonNull AdTemplate adTemplate) {
        return m25641dQ(adTemplate).adConversionInfo.appDownloadUrl;
    }

    /* renamed from: dU */
    public static String m25637dU(@NonNull AdTemplate adTemplate) {
        InterfaceC10489g m25653Fh = m25653Fh();
        String m25617Fl = m25653Fh == null ? "" : m25653Fh.m25617Fl();
        return TextUtils.isEmpty(m25617Fl) ? m25617Fl : C10483a.m25963Y(m25641dQ(adTemplate));
    }

    /* renamed from: dV */
    public static String m25636dV(@NonNull AdTemplate adTemplate) {
        if (m25649dI(adTemplate)) {
            return C10483a.m25820cf(m25641dQ(adTemplate));
        }
        InterfaceC10489g m25653Fh = m25653Fh();
        return m25653Fh == null ? "" : m25653Fh.m25616Fm();
    }

    /* renamed from: dW */
    public static long m25635dW(@NonNull AdTemplate adTemplate) {
        if (m25649dI(adTemplate)) {
            return C10483a.m25934ab(m25641dQ(adTemplate));
        }
        InterfaceC10489g m25653Fh = m25653Fh();
        return m25653Fh == null ? adTemplate.hashCode() : m25653Fh.m25615Fn();
    }

    /* renamed from: dX */
    public static int m25634dX(@NonNull AdTemplate adTemplate) {
        InterfaceC10489g m25653Fh = m25653Fh();
        if (m25653Fh == null) {
            return 0;
        }
        return m25653Fh.m25614Fo();
    }

    /* renamed from: dY */
    public static int m25633dY(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        return m25641dQ(adTemplate).adBaseInfo.taskType;
    }

    /* renamed from: dZ */
    public static String m25632dZ(@NonNull AdTemplate adTemplate) {
        if (m25649dI(adTemplate)) {
            return C10483a.m25851cC(m25641dQ(adTemplate));
        }
        return C10490h.m25610c(m25640dR(adTemplate));
    }

    /* renamed from: ea */
    public static long m25631ea(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return m25641dQ(adTemplate).adBaseInfo.creativeId;
    }

    /* renamed from: eb */
    public static boolean m25630eb(AdTemplate adTemplate) {
        return m25641dQ(adTemplate).adConversionInfo.blockCallbackIfSpam && adTemplate.mCheatingFlow;
    }

    /* renamed from: ec */
    public static boolean m25629ec(@NonNull AdTemplate adTemplate) {
        int m25623j = m25623j(adTemplate, true);
        return m25623j == 1 || m25623j == 2;
    }

    /* renamed from: ed */
    public static boolean m25628ed(@NonNull AdTemplate adTemplate) {
        int m25623j = m25623j(adTemplate, false);
        return m25623j == 1 || m25623j == 2;
    }

    /* renamed from: ee */
    public static int m25627ee(@NonNull AdTemplate adTemplate) {
        return m25641dQ(adTemplate).adBaseInfo.ecpm;
    }

    /* renamed from: ef */
    public static boolean m25626ef(@NonNull AdTemplate adTemplate) {
        AdInfo m25641dQ = m25641dQ(adTemplate);
        return m25641dQ.adStyleConfInfo.adPushDownloadJumpType == 0 && m25647dK(adTemplate) == 17 && C10483a.m25956aF(m25641dQ);
    }

    /* renamed from: eg */
    public static int m25625eg(@NonNull AdTemplate adTemplate) {
        AdVideoPreCacheConfig adVideoPreCacheConfig = adTemplate.adVideoPreCacheConfig;
        if (adVideoPreCacheConfig == null) {
            InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
            if (interfaceC10970h != null) {
                return interfaceC10970h.mo24303yU();
            }
            return 800;
        }
        return adVideoPreCacheConfig.adVideoPreCacheSize;
    }

    /* renamed from: i */
    public static boolean m25624i(AdTemplate adTemplate, boolean z) {
        if (adTemplate == null) {
            return false;
        }
        AdInfo m25641dQ = m25641dQ(adTemplate);
        return C10483a.m25956aF(m25641dQ) && !C10483a.m25836cR(m25641dQ) && !z && m25633dY(adTemplate) == 2;
    }

    /* renamed from: j */
    public static int m25623j(@NonNull AdTemplate adTemplate, boolean z) {
        AdInfo m25641dQ = m25641dQ(adTemplate);
        if (m25647dK(adTemplate) == 3) {
            AdMatrixInfo.AdDataV2 adDataV2 = m25641dQ.adMatrixInfo.adDataV2;
            int i = z ? adDataV2.actionBarInfo.cardType : adDataV2.endCardInfo.cardType;
            if (i == 5) {
                return 1;
            }
            return i == 6 ? 2 : -1;
        }
        return m25641dQ.adBaseInfo.mABParams.playableStyle;
    }
}
