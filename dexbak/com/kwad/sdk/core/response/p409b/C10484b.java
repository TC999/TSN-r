package com.kwad.sdk.core.response.p409b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11053bg;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.response.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10484b {
    private static Random azS = new Random();

    /* renamed from: a */
    public static int m25792a(boolean z, @NonNull AdInfo adInfo) {
        return (z ? adInfo.adMatrixInfo.adDataV2.neoTKInfo : adInfo.adMatrixInfo.adDataV2.fullScreenInfo).renderType;
    }

    @Nullable
    /* renamed from: cA */
    private static String m25791cA(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate m25668k = m25668k(adTemplate, C10487e.m25641dQ(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        return m25668k != null ? m25668k.templateUrl : "";
    }

    /* renamed from: cB */
    public static String m25790cB(@NonNull AdTemplate adTemplate) {
        if (m25789cC(adTemplate)) {
            return m25791cA(adTemplate);
        }
        return C10483a.m25943aS(C10487e.m25641dQ(adTemplate));
    }

    /* renamed from: cC */
    private static boolean m25789cC(@NonNull AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || C10483a.m25880bZ(adTemplate) || !m25704dj(C10487e.m25641dQ(adTemplate))) ? false : true;
    }

    @NonNull
    /* renamed from: cD */
    private static AdMatrixInfo.FeedInfo m25788cD(@NonNull AdTemplate adTemplate) {
        if (m25787cE(adTemplate)) {
            return m25765cc(adTemplate).adDataV2.adUnionFeedLiveTemplateInfo;
        }
        return m25765cc(adTemplate).adDataV2.feedInfo;
    }

    /* renamed from: cE */
    private static boolean m25787cE(@NonNull AdTemplate adTemplate) {
        return C10483a.m25842cL(C10487e.m25641dQ(adTemplate));
    }

    @NonNull
    /* renamed from: cF */
    private static AdMatrixInfo.FeedInfo m25786cF(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    @Nullable
    /* renamed from: cG */
    public static String m25785cG(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate m25668k = m25668k(adTemplate, m25788cD(adTemplate).templateId);
        return m25668k != null ? m25668k.templateUrl : "";
    }

    /* renamed from: cH */
    private static AdMatrixInfo.FeedTKInfo m25784cH(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.feedTKCardInfo;
    }

    @Nullable
    /* renamed from: cI */
    public static String m25783cI(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate m25668k = m25668k(adTemplate, m25786cF(adTemplate).templateId);
        return m25668k != null ? m25668k.templateUrl : "";
    }

    @Nullable
    /* renamed from: cJ */
    public static boolean m25782cJ(@NonNull AdTemplate adTemplate) {
        return m25788cD(adTemplate).interactionInfo.interactiveStyle == 2;
    }

    @Nullable
    /* renamed from: cK */
    public static boolean m25781cK(@NonNull AdTemplate adTemplate) {
        return m25788cD(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    @Nullable
    /* renamed from: cL */
    public static int m25780cL(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = m25788cD(adTemplate).interactionInfo;
        if (adInteractionInfo == null || (shakeInfo = adInteractionInfo.shakeInfo) == null) {
            return 0;
        }
        return shakeInfo.acceleration;
    }

    /* renamed from: cM */
    public static double m25779cM(@NonNull AdTemplate adTemplate) {
        return C10487e.m25641dQ(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    /* renamed from: cN */
    public static boolean m25778cN(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(m25785cG(adTemplate));
    }

    /* renamed from: cO */
    public static boolean m25777cO(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(m25784cH(adTemplate).templateId);
    }

    /* renamed from: cP */
    public static String m25776cP(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.FeedTKInfo m25784cH = m25784cH(adTemplate);
        return TextUtils.isEmpty(m25784cH.templateId) ? "ksad-feed-card" : m25784cH.templateId;
    }

    /* renamed from: cQ */
    public static boolean m25775cQ(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(m25783cI(adTemplate));
    }

    /* renamed from: cR */
    public static float m25774cR(@NonNull AdTemplate adTemplate) {
        int i;
        try {
            i = C10487e.m25641dQ(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            i = 7;
        }
        if (i > 0) {
            return i;
        }
        return 7.0f;
    }

    /* renamed from: cS */
    public static boolean m25773cS(@NonNull AdTemplate adTemplate) {
        try {
            return C10487e.m25641dQ(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            return false;
        }
    }

    /* renamed from: cT */
    public static float m25772cT(@NonNull AdTemplate adTemplate) {
        int i;
        try {
            i = C10487e.m25641dQ(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    /* renamed from: cU */
    public static AdMatrixInfo.RotateInfo m25771cU(@NonNull AdTemplate adTemplate) {
        try {
            return C10487e.m25641dQ(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            return null;
        }
    }

    @NonNull
    /* renamed from: cV */
    private static AdMatrixInfo.BaseMatrixTemplate m25770cV(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.complianceCardInfo;
    }

    @Nullable
    /* renamed from: cW */
    public static String m25769cW(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate m25668k = m25668k(adTemplate, m25770cV(adTemplate).templateId);
        return m25668k != null ? m25668k.templateUrl : "";
    }

    /* renamed from: cX */
    public static boolean m25768cX(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(m25769cW(adTemplate));
    }

    @NonNull
    /* renamed from: cY */
    private static AdMatrixInfo.BaseMatrixTemplate m25767cY(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    @Nullable
    /* renamed from: cZ */
    public static String m25766cZ(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate m25668k = m25668k(adTemplate, m25767cY(adTemplate).templateId);
        return m25668k != null ? m25668k.templateUrl : "";
    }

    @NonNull
    /* renamed from: cc */
    public static AdMatrixInfo m25765cc(@NonNull AdTemplate adTemplate) {
        if (C10487e.m25649dI(adTemplate)) {
            return C10487e.m25641dQ(adTemplate).adMatrixInfo;
        }
        return new AdMatrixInfo();
    }

    /* renamed from: cd */
    public static List<AdMatrixInfo.MatrixTemplate> m25764cd(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).styles.templateList;
    }

    @NonNull
    /* renamed from: ce */
    public static AdMatrixInfo.AdDataV2 m25763ce(@NonNull AdTemplate adTemplate) {
        return C10487e.m25641dQ(adTemplate).adMatrixInfo.adDataV2;
    }

    /* renamed from: cf */
    public static FeedSlideConf m25762cf(@NonNull AdTemplate adTemplate) {
        JSONArray optJSONArray;
        AdMatrixInfo.TemplateData m25667l = m25667l(adTemplate, m25788cD(adTemplate).templateId);
        try {
            JSONObject optJSONObject = new JSONObject(m25667l != null ? m25667l.data : "").optJSONObject("slideInfo");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("angle")) != null && optJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) optJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) optJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: cg */
    public static boolean m25761cg(@NonNull AdTemplate adTemplate) {
        return m25665n(adTemplate, m25760ch(adTemplate).templateId);
    }

    @NonNull
    /* renamed from: ch */
    private static AdMatrixInfo.InterstitialCardInfo m25760ch(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.interstitialCardInfo;
    }

    @Nullable
    /* renamed from: ci */
    public static String m25759ci(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate m25668k = m25668k(adTemplate, m25765cc(adTemplate).adDataV2.splashActionBarInfo.templateId);
        return m25668k != null ? m25668k.templateUrl : "";
    }

    @NonNull
    /* renamed from: cj */
    private static AdMatrixInfo.ActionBarInfoNew m25758cj(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.actionBarInfo;
    }

    @Nullable
    /* renamed from: ck */
    public static String m25757ck(@NonNull AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        int m25647dK = C10487e.m25647dK(adTemplate);
        boolean z = m25647dK == 3 || m25647dK == 2;
        if (C10483a.m25842cL(m25641dQ)) {
            return "";
        }
        if (z && C10483a.m25824cb(adTemplate)) {
            AdMatrixInfo.MatrixTemplate m25668k = m25668k(adTemplate, m25717db(adTemplate).templateId);
            return m25668k != null ? m25668k.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate m25668k2 = m25668k(adTemplate, m25758cj(adTemplate).templateId);
        return m25668k2 != null ? m25668k2.templateUrl : "";
    }

    /* renamed from: cl */
    public static long m25756cl(@NonNull AdTemplate adTemplate) {
        return m25758cj(adTemplate).maxTimeOut;
    }

    /* renamed from: cm */
    public static boolean m25755cm(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(m25757ck(adTemplate));
    }

    @NonNull
    /* renamed from: cn */
    private static AdMatrixInfo.AggregationCardInfo m25754cn(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.aggregationCardInfo;
    }

    @Nullable
    /* renamed from: co */
    public static String m25753co(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate m25668k = m25668k(adTemplate, m25754cn(adTemplate).templateId);
        return m25668k != null ? m25668k.templateUrl : "";
    }

    /* renamed from: cp */
    public static long m25752cp(@NonNull AdTemplate adTemplate) {
        return m25666m(adTemplate, m25754cn(adTemplate).templateId);
    }

    /* renamed from: cq */
    public static long m25751cq(@NonNull AdTemplate adTemplate) {
        return m25754cn(adTemplate).changeTime * 1000;
    }

    /* renamed from: cr */
    public static int m25750cr(@NonNull AdTemplate adTemplate) {
        return m25754cn(adTemplate).maxTimesPerDay;
    }

    /* renamed from: cs */
    public static long m25749cs(@NonNull AdTemplate adTemplate) {
        return m25754cn(adTemplate).intervalTime;
    }

    /* renamed from: ct */
    public static boolean m25748ct(@NonNull AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        return !C10483a.m25956aF(m25641dQ) && C10483a.m25916at(m25641dQ);
    }

    /* renamed from: cu */
    public static boolean m25747cu(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(m25753co(adTemplate)) && m25752cp(adTemplate) > 0) {
            return C11015ai.isOrientationPortrait();
        }
        return false;
    }

    @NonNull
    /* renamed from: cv */
    private static AdMatrixInfo.BaseMatrixTemplate m25746cv(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.halfCardInfo;
    }

    @Nullable
    /* renamed from: cw */
    public static String m25745cw(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate m25668k = m25668k(adTemplate, m25746cv(adTemplate).templateId);
        return m25668k != null ? m25668k.templateUrl : "";
    }

    @NonNull
    /* renamed from: cx */
    private static AdMatrixInfo.EndCardInfo m25744cx(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.endCardInfo;
    }

    @Nullable
    /* renamed from: cy */
    public static String m25743cy(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate m25668k = m25668k(adTemplate, m25744cx(adTemplate).templateId);
        return m25668k != null ? m25668k.templateUrl : "";
    }

    /* renamed from: cz */
    public static boolean m25742cz(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(m25743cy(adTemplate));
    }

    /* renamed from: dA */
    public static boolean m25741dA(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    /* renamed from: dB */
    public static boolean m25739dB(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10;
    }

    /* renamed from: dC */
    public static boolean m25738dC(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    /* renamed from: dD */
    public static boolean m25737dD(@NonNull AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
            return i == 4 || i == 9;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: dE */
    public static boolean m25736dE(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    /* renamed from: dF */
    public static boolean m25735dF(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    /* renamed from: dG */
    public static long m25734dG(@NonNull AdInfo adInfo) {
        try {
            long j = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            if (j <= 0) {
                return 1500L;
            }
            return j;
        } catch (Exception unused) {
            return 1500L;
        }
    }

    /* renamed from: dH */
    public static boolean m25733dH(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    /* renamed from: dI */
    public static float m25732dI(@NonNull AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    /* renamed from: dJ */
    public static float m25731dJ(@NonNull AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    /* renamed from: dK */
    public static String m25730dK(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    /* renamed from: dL */
    public static String m25729dL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    /* renamed from: dM */
    public static String m25728dM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    /* renamed from: dN */
    public static String m25727dN(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    /* renamed from: dO */
    public static AdMatrixInfo.DownloadTexts m25726dO(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    /* renamed from: dP */
    public static AdMatrixInfo.DownloadTexts m25725dP(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    /* renamed from: dQ */
    public static boolean m25724dQ(@NonNull AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    /* renamed from: dR */
    public static boolean m25723dR(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    /* renamed from: dS */
    public static boolean m25722dS(@NonNull AdInfo adInfo) {
        return (C10483a.m25900bH(adInfo) || TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId)) ? false : true;
    }

    /* renamed from: dT */
    public static int m25721dT(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.preLandingPageShowType;
    }

    /* renamed from: dU */
    public static String m25720dU(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.videoLiveTKInfo.templateId;
    }

    /* renamed from: dV */
    public static boolean m25719dV(@NonNull AdInfo adInfo) {
        return C10483a.m25876bd(adInfo) && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.videoImageTKInfo.templateId);
    }

    /* renamed from: da */
    public static boolean m25718da(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(m25766cZ(adTemplate));
    }

    /* renamed from: db */
    public static AdMatrixInfo.MerchantLiveReservationInfo m25717db(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    /* renamed from: dc */
    public static AdMatrixInfo.FullScreenInfo m25716dc(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.fullScreenInfo;
    }

    /* renamed from: dd */
    public static AdMatrixInfo.SplashPlayCardTKInfo m25715dd(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.splashPlayCardTKInfo;
    }

    /* renamed from: de */
    public static boolean m25714de(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    /* renamed from: df */
    public static boolean m25712df(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    /* renamed from: dg */
    public static boolean m25710dg(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    /* renamed from: dh */
    public static boolean m25708dh(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    /* renamed from: di */
    public static boolean m25706di(@NonNull AdInfo adInfo) {
        if (m25704dj(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    /* renamed from: dj */
    public static boolean m25704dj(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    /* renamed from: dk */
    public static String m25702dk(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    /* renamed from: dl */
    public static long m25700dl(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    /* renamed from: dm */
    public static String m25698dm(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    /* renamed from: dn */
    public static String m25696dn(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    /* renamed from: do */
    public static boolean m25694do(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    /* renamed from: dp */
    public static String m25692dp(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.cutIconUrl;
    }

    /* renamed from: dq */
    public static String m25690dq(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.refreshIconUrl;
    }

    /* renamed from: dr */
    public static String m25688dr(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.convertIconUrl;
    }

    /* renamed from: ds */
    public static int m25686ds(@NonNull AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i != 2) {
                return 1;
            }
            return i;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            return 1;
        }
    }

    /* renamed from: dt */
    public static boolean m25684dt(@NonNull AdInfo adInfo) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo;
        return adInteractionInfo.isMediaDisable && adInteractionInfo.interactiveStyle == 4;
    }

    /* renamed from: du */
    public static boolean m25682du(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    /* renamed from: dv */
    public static int m25680dv(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
    }

    /* renamed from: dw */
    public static int m25678dw(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle;
    }

    /* renamed from: dx */
    public static boolean m25676dx(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    /* renamed from: dy */
    public static boolean m25674dy(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    /* renamed from: dz */
    public static boolean m25672dz(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    /* renamed from: ep */
    public static boolean m25670ep(String str) {
        try {
            return ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24325bW(str);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: g */
    public static boolean m25669g(@NonNull AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || C10483a.m25836cR(adInfo) || C10483a.m25900bH(adInfo)) ? false : true;
    }

    @Nullable
    /* renamed from: k */
    public static AdMatrixInfo.MatrixTemplate m25668k(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : m25765cc(adTemplate).styles.templateList) {
            if (C11053bg.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: l */
    private static AdMatrixInfo.TemplateData m25667l(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : m25765cc(adTemplate).adDataV2.templateDataList) {
            if (C11053bg.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    /* renamed from: m */
    private static long m25666m(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData m25667l = m25667l(adTemplate, str);
        if (m25667l != null) {
            return m25667l.templateDelayTime;
        }
        return 0L;
    }

    /* renamed from: n */
    private static boolean m25665n(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData m25667l = m25667l(adTemplate, str);
        try {
            JSONObject optJSONObject = new JSONObject(m25667l != null ? m25667l.data : "").optJSONObject("autoCallAppInfo");
            if (optJSONObject != null) {
                return !TextUtils.isEmpty(optJSONObject.optString("adTitle"));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: dA */
    public static String m25740dA(AdTemplate adTemplate) {
        return m25763ce(adTemplate).feedTKCardInfo.templateId;
    }

    /* renamed from: de */
    public static long m25713de(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.splashPlayCardTKInfo.tkTimeout;
    }

    /* renamed from: df */
    public static int m25711df(@NonNull AdTemplate adTemplate) {
        return m25765cc(adTemplate).adDataV2.splashPlayCardTKInfo.renderType;
    }

    /* renamed from: dg */
    public static boolean m25709dg(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (m25669g(m25641dQ) || C10487e.m25629ec(adTemplate)) {
            return false;
        }
        return !(m25758cj(adTemplate).cardType == 4) && C10487e.m25641dQ(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType <= 0 && m25641dQ.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle == 2;
    }

    /* renamed from: dh */
    public static boolean m25707dh(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (m25669g(m25641dQ) || C10487e.m25629ec(adTemplate)) {
            return false;
        }
        return ((m25758cj(adTemplate).cardType == 4) || C10487e.m25641dQ(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || m25641dQ.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    /* renamed from: dj */
    public static boolean m25703dj(@NonNull AdTemplate adTemplate) {
        return m25763ce(adTemplate).installedActivateInfo.cardSwitch;
    }

    /* renamed from: dk */
    public static long m25701dk(@NonNull AdTemplate adTemplate) {
        long j = m25763ce(adTemplate).installedActivateInfo.showTime;
        if (j > 0) {
            return j;
        }
        return 0L;
    }

    /* renamed from: dl */
    public static String m25699dl(AdTemplate adTemplate) {
        return m25763ce(adTemplate).topFloorTKInfo.templateId;
    }

    /* renamed from: dm */
    public static String m25697dm(AdTemplate adTemplate) {
        return m25763ce(adTemplate).neoTKInfo.templateId;
    }

    /* renamed from: dn */
    public static String m25695dn(AdTemplate adTemplate) {
        return m25763ce(adTemplate).videoLiveTKInfo.templateId;
    }

    /* renamed from: do */
    public static String m25693do(AdTemplate adTemplate) {
        return m25763ce(adTemplate).videoImageTKInfo.templateId;
    }

    /* renamed from: dp */
    public static String m25691dp(AdTemplate adTemplate) {
        return m25763ce(adTemplate).fullScreenInfo.templateId;
    }

    /* renamed from: dq */
    public static String m25689dq(AdTemplate adTemplate) {
        return m25763ce(adTemplate).rewardVideoTaskInfo.templateId;
    }

    /* renamed from: dr */
    public static String m25687dr(AdTemplate adTemplate) {
        return m25763ce(adTemplate).splashPlayCardTKInfo.templateId;
    }

    /* renamed from: dt */
    public static String m25683dt(AdTemplate adTemplate) {
        return m25763ce(adTemplate).interstitialCardInfo.templateId;
    }

    /* renamed from: du */
    public static String m25681du(AdTemplate adTemplate) {
        return m25763ce(adTemplate).confirmTKInfo.templateId;
    }

    /* renamed from: dv */
    public static String m25679dv(AdTemplate adTemplate) {
        return m25763ce(adTemplate).activityTKInfo.templateId;
    }

    /* renamed from: dw */
    public static String m25677dw(AdTemplate adTemplate) {
        return m25763ce(adTemplate).rewardWebTaskCloseInfo.templateId;
    }

    /* renamed from: dx */
    public static String m25675dx(AdTemplate adTemplate) {
        return m25763ce(adTemplate).rewardVideoInteractInfo.templateId;
    }

    /* renamed from: dy */
    public static String m25673dy(AdTemplate adTemplate) {
        return m25763ce(adTemplate).pushTKInfo.templateId;
    }

    /* renamed from: dz */
    public static String m25671dz(AdTemplate adTemplate) {
        return m25763ce(adTemplate).preLandingPageTKInfo.templateId;
    }

    @Nullable
    /* renamed from: di */
    public static AdMatrixInfo.PreLandingPageTKInfo m25705di(@NonNull AdTemplate adTemplate) {
        return C10487e.m25641dQ(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    /* renamed from: ds */
    public static String m25685ds(AdTemplate adTemplate) {
        return m25763ce(adTemplate).splashEndCardTKInfo.templateId;
    }
}
