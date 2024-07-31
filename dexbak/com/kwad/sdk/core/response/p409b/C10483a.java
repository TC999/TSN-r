package com.kwad.sdk.core.response.p409b;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.C2658ck;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.C10493b;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11014ah;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11053bg;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.response.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10483a {
    /* renamed from: Fg */
    public static String m25980Fg() {
        return "继续下载";
    }

    /* renamed from: H */
    public static String m25979H(AdInfo adInfo) {
        return adInfo.downloadFilePath;
    }

    /* renamed from: J */
    public static long m25978J(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    /* renamed from: K */
    public static String m25977K(@NonNull AdInfo adInfo) {
        return m25940aV(adInfo).materialUrl;
    }

    /* renamed from: L */
    public static int m25976L(@NonNull AdInfo adInfo) {
        if (m25875be(adInfo) == 2) {
            return m25941aU(adInfo).videoDuration;
        }
        return m25940aV(adInfo).videoDuration;
    }

    /* renamed from: M */
    public static long m25975M(@NonNull AdInfo adInfo) {
        int i;
        if (m25875be(adInfo) == 2) {
            i = m25941aU(adInfo).videoDuration;
        } else {
            i = m25940aV(adInfo).videoDuration;
        }
        return i * 1000;
    }

    /* renamed from: N */
    public static AdInfo.AdMaterialInfo.MaterialFeature m25974N(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        if (C11014ah.m24125P(list)) {
            return list.get(0);
        }
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* renamed from: O */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m25973O(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = m25875be(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L35
            r3 = 2
            if (r0 == r3) goto L12
            if (r0 == r1) goto L12
            r2 = 8
            if (r0 == r2) goto L58
            goto L7b
        L12:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L35
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1a
            java.lang.String r5 = r4.firstFrame
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1a
            java.lang.String r6 = r4.firstFrame
            return r6
        L35:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L3d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L3d
            java.lang.String r4 = r3.firstFrame
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L3d
            java.lang.String r6 = r3.firstFrame
            return r6
        L58:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L60:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L7b
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L60
            java.lang.String r2 = r0.firstFrame
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L60
            java.lang.String r6 = r0.firstFrame
            return r6
        L7b:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.p409b.C10483a.m25973O(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    /* renamed from: P */
    public static boolean m25972P(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    /* renamed from: Q */
    public static int m25971Q(@NonNull AdInfo adInfo) {
        return m25940aV(adInfo).videoWidth;
    }

    /* renamed from: R */
    public static int m25970R(@NonNull AdInfo adInfo) {
        return m25940aV(adInfo).videoHeight;
    }

    /* renamed from: S */
    public static boolean m25969S(@NonNull AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo;
        return smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId);
    }

    /* renamed from: T */
    public static boolean m25968T(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.webUriSourceType == 2;
    }

    /* renamed from: U */
    public static boolean m25967U(AdInfo adInfo) {
        return adInfo.adConversionInfo.appSecondConfirmationSwitch;
    }

    /* renamed from: V */
    public static boolean m25966V(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5SecondConfirmationSwitch;
    }

    /* renamed from: W */
    public static boolean m25965W(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature m25940aV = m25940aV(adInfo);
        return m25940aV.videoWidth <= m25940aV.videoHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0072  */
    @java.lang.Deprecated
    /* renamed from: X */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m25964X(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = m25875be(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L41
            r3 = 2
            if (r0 == r3) goto L13
            if (r0 == r1) goto L13
            r2 = 8
            if (r0 == r2) goto L64
            goto L87
        L13:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1b:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L41
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1b
            java.lang.String r5 = r4.materialUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L36
            java.lang.String r6 = r4.materialUrl
            return r6
        L36:
            java.lang.String r5 = r4.coverUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1b
            java.lang.String r6 = r4.coverUrl
            return r6
        L41:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L49:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L64
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L49
            java.lang.String r4 = r3.coverUrl
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L49
            java.lang.String r6 = r3.coverUrl
            return r6
        L64:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L6c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L87
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L6c
            java.lang.String r2 = r0.coverUrl
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L6c
            java.lang.String r6 = r0.coverUrl
            return r6
        L87:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.p409b.C10483a.m25964X(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    /* renamed from: Y */
    public static String m25963Y(@NonNull AdInfo adInfo) {
        int m25875be = m25875be(adInfo);
        if (m25875be != 1) {
            if (m25875be != 2 && m25875be != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return m25938aX(adInfo).blurBackgroundUrl;
    }

    /* renamed from: Z */
    private static int m25962Z(@NonNull AdInfo adInfo) {
        return m25940aV(adInfo).width;
    }

    /* renamed from: aA */
    public static float m25961aA(@NonNull AdInfo adInfo) {
        int i = adInfo.adBaseInfo.appScore;
        if (i <= 0) {
            return 0.0f;
        }
        return i / 10.0f;
    }

    /* renamed from: aB */
    public static boolean m25960aB(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.enableClientProofreadTime;
    }

    /* renamed from: aC */
    public static float m25959aC(@NonNull AdInfo adInfo) {
        float f = adInfo.adBaseInfo.appScore;
        if (f < 30.0f) {
            return 3.0f;
        }
        if (f < 35.0f) {
            return 3.5f;
        }
        if (f < 40.0f) {
            return 4.0f;
        }
        return f < 45.0f ? 4.5f : 5.0f;
    }

    /* renamed from: aD */
    public static String m25958aD(AdInfo adInfo) {
        return C11053bg.isNullString(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    /* renamed from: aE */
    public static String m25957aE(@Nullable AdInfo adInfo) {
        if (adInfo == null) {
            return "立即下载";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return m25956aF(adInfo) ? "立即下载" : "查看详情";
        }
        return str;
    }

    /* renamed from: aF */
    public static boolean m25956aF(@NonNull AdInfo adInfo) {
        return m25945aQ(adInfo) == 1;
    }

    /* renamed from: aG */
    public static boolean m25955aG(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardVideoInteractSwitch && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.templateId);
    }

    /* renamed from: aH */
    public static int m25954aH(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.intervalShow;
    }

    /* renamed from: aI */
    public static int m25953aI(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.dayMaxLimit;
    }

    /* renamed from: aJ */
    public static int m25952aJ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.showTime;
    }

    /* renamed from: aK */
    public static int m25951aK(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.rewardTime;
    }

    /* renamed from: aL */
    public static int m25950aL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.showTime;
    }

    /* renamed from: aM */
    public static int m25949aM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.thresholdTime;
    }

    /* renamed from: aN */
    public static int m25948aN(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.taskType;
    }

    /* renamed from: aO */
    public static boolean m25947aO(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.templateId);
    }

    /* renamed from: aP */
    public static boolean m25946aP(@NonNull AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && m25956aF(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    /* renamed from: aQ */
    public static int m25945aQ(@NonNull AdInfo adInfo) {
        int i = adInfo.adBaseInfo.adOperationType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    /* renamed from: aR */
    public static int m25944aR(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    /* renamed from: aS */
    public static String m25943aS(@NonNull AdInfo adInfo) {
        InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
        return TextUtils.isEmpty(adInfo.adConversionInfo.h5Url) ? "" : C11008ac.m24154c(interfaceC10968f == null ? null : interfaceC10968f.getContext(), adInfo.adConversionInfo.h5Url, m25960aB(adInfo));
    }

    /* renamed from: aT */
    public static int m25942aT(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    @NonNull
    /* renamed from: aU */
    public static AdInfo.AdMaterialInfo.MaterialFeature m25941aU(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        C10331c.m26246w("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    /* renamed from: aV */
    public static AdInfo.AdMaterialInfo.MaterialFeature m25940aV(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        C10331c.m26246w("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    /* renamed from: aW */
    public static boolean m25939aW(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature m25941aU;
        if (m25877bc(adInfo)) {
            m25941aU = m25940aV(adInfo);
        } else {
            m25941aU = m25941aU(adInfo);
        }
        return m25941aU.height > m25941aU.width;
    }

    @NonNull
    /* renamed from: aX */
    public static AdInfo.AdMaterialInfo.MaterialFeature m25938aX(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    /* renamed from: aY */
    public static boolean m25937aY(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature m25940aV = m25940aV(adInfo);
        return m25940aV.height > m25940aV.width;
    }

    /* renamed from: aZ */
    public static String m25936aZ(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    /* renamed from: aa */
    private static int m25935aa(@NonNull AdInfo adInfo) {
        return m25940aV(adInfo).height;
    }

    /* renamed from: ab */
    public static long m25934ab(@NonNull AdInfo adInfo) {
        return m25940aV(adInfo).photoId;
    }

    /* renamed from: ac */
    public static String m25933ac(@Nullable AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    /* renamed from: ad */
    public static long m25932ad(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    /* renamed from: ae */
    public static int m25931ae(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    /* renamed from: af */
    public static long m25930af(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime * 1000;
    }

    /* renamed from: ag */
    public static long m25929ag(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime * 1000;
    }

    /* renamed from: ah */
    private static int m25928ah(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        C10331c.m26246w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    /* renamed from: ai */
    public static boolean m25927ai(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdShakeInfo nativeAdShakeInfo;
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null && (nativeAdShakeInfo = nativeAdInfo.shakeInfo) != null) {
            return nativeAdShakeInfo.enableShake;
        }
        C10331c.m26246w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return false;
    }

    /* renamed from: aj */
    public static int m25926aj(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null) {
            return nativeAdInfo.shakeInfo.acceleration;
        }
        C10331c.m26246w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return 2;
    }

    /* renamed from: ak */
    public static boolean m25925ak(@NonNull AdInfo adInfo) {
        return m25928ah(adInfo) != 0;
    }

    /* renamed from: al */
    public static long m25924al(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.fullScreenSkipShowTime * 1000;
        }
        C10331c.m26246w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    /* renamed from: am */
    public static long m25923am(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.closeDelaySeconds * 1000;
        }
        C10331c.m26246w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    /* renamed from: an */
    public static int m25922an(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.showPageType;
    }

    /* renamed from: ao */
    public static boolean m25921ao(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoAutoLoopAtH5;
    }

    /* renamed from: ap */
    public static boolean m25920ap(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoMutedAtH5;
    }

    /* renamed from: aq */
    public static boolean m25919aq(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoClickAtH5;
    }

    /* renamed from: ar */
    public static long m25918ar(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.playableCloseSeconds * 1000;
        }
        C10331c.m26246w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    /* renamed from: as */
    public static boolean m25917as(@NonNull AdInfo adInfo) {
        return !m25956aF(adInfo) && m25916at(adInfo);
    }

    /* renamed from: at */
    public static boolean m25916at(@NonNull AdInfo adInfo) {
        if (adInfo.adRewardInfo.showLandingPage == 1) {
            return ((m25947aO(adInfo) && m25948aN(adInfo) == 1) || m25836cR(adInfo)) ? false : true;
        }
        return false;
    }

    /* renamed from: au */
    public static String m25915au(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    /* renamed from: av */
    public static String m25914av(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    /* renamed from: aw */
    private static String m25913aw(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.realAppName;
    }

    /* renamed from: ax */
    public static String m25912ax(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    /* renamed from: ay */
    public static String m25911ay(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null) {
            return null;
        }
        return adBaseInfo.appPackageName;
    }

    /* renamed from: az */
    public static String m25910az(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    /* renamed from: b */
    public static boolean m25908b(@NonNull AdInfo adInfo, boolean z) {
        return ((z && m25956aF(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || C11053bg.isNullString(m25943aS(adInfo))) ? false : true;
    }

    @Nullable
    /* renamed from: bA */
    public static String m25907bA(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    /* renamed from: bB */
    public static String m25906bB(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    @Nullable
    /* renamed from: bC */
    public static String m25905bC(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfo;
        }
        return null;
    }

    @Nullable
    /* renamed from: bD */
    public static String m25904bD(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfoUrl;
        }
        return null;
    }

    @Nullable
    /* renamed from: bE */
    public static String m25903bE(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    /* renamed from: bF */
    public static String m25902bF(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    /* renamed from: bG */
    public static long m25901bG(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    /* renamed from: bH */
    public static boolean m25900bH(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            String str = adConversionInfo.playableUrl;
            boolean z = (str == null || adConversionInfo.playableStyleInfo == null || TextUtils.isEmpty(str.trim())) ? false : true;
            if (m25897bK(adInfo) && z) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: bI */
    public static long m25899bI(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.h5DeeplinkLimitedTimeMs;
    }

    /* renamed from: bJ */
    public static long m25898bJ(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.playableDeeplinkLimitedTimeMs;
    }

    /* renamed from: bK */
    public static boolean m25897bK(AdInfo adInfo) {
        if (C11015ai.isOrientationPortrait()) {
            return m25895bM(adInfo);
        }
        return m25896bL(adInfo);
    }

    /* renamed from: bL */
    private static boolean m25896bL(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        return i == 0 || i == 2;
    }

    /* renamed from: bM */
    private static boolean m25895bM(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        return i == 0 || i == 1;
    }

    @Nullable
    /* renamed from: bN */
    public static String m25894bN(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.playableUrl;
    }

    @Nullable
    /* renamed from: bO */
    public static String m25893bO(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrl;
    }

    @Nullable
    /* renamed from: bP */
    public static String m25892bP(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrlInfo;
    }

    @Nullable
    /* renamed from: bQ */
    public static String m25891bQ(AdInfo adInfo) {
        String str;
        if (adInfo == null || (str = adInfo.serverExt) == null) {
            return null;
        }
        return str;
    }

    /* renamed from: bR */
    public static boolean m25890bR(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    /* renamed from: bS */
    public static boolean m25889bS(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    /* renamed from: bT */
    public static boolean m25888bT(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoSoundType != 2) ? false : true;
    }

    /* renamed from: bU */
    public static boolean m25887bU(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null) {
            return false;
        }
        int i = adFeedInfo.videoAutoPlayType;
        return i == 1 || i == 0;
    }

    /* renamed from: bV */
    public static boolean m25886bV(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 2) ? false : true;
    }

    /* renamed from: bW */
    public static boolean m25885bW(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 3) ? false : true;
    }

    /* renamed from: bX */
    public static boolean m25884bX(AdInfo adInfo) {
        InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
        return (interfaceC10970h == null || !interfaceC10970h.mo24302yV()) && !TextUtils.isEmpty(m25943aS(adInfo)) && adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse == 1;
    }

    /* renamed from: bY */
    public static String m25882bY(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.getAdStyle() != 2 || m25843cK(C10487e.m25641dQ(adTemplate)) || m25842cL(C10487e.m25641dQ(adTemplate))) {
            if (adTemplate == null) {
                return "立即安装";
            }
            AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
            return TextUtils.isEmpty(m25641dQ.adBaseInfo.installAppLabel) ? "立即安装" : m25641dQ.adBaseInfo.installAppLabel;
        }
        return "安装获取奖励";
    }

    /* renamed from: bZ */
    public static boolean m25880bZ(AdTemplate adTemplate) {
        return C10487e.m25641dQ(adTemplate).adBaseInfo.apiExpParam.aggregateMiddlePageShowPathSwitch;
    }

    @NonNull
    /* renamed from: ba */
    public static List<String> m25879ba(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int m25875be = m25875be(adInfo);
        if (m25875be == 2 || m25875be == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: bb */
    public static String m25878bb(@NonNull AdInfo adInfo) {
        if (m25877bc(adInfo)) {
            return m25977K(adInfo);
        }
        List<String> m25879ba = m25879ba(adInfo);
        return m25879ba.size() > 0 ? m25879ba.get(0) : "";
    }

    /* renamed from: bc */
    public static boolean m25877bc(@NonNull AdInfo adInfo) {
        return m25875be(adInfo) == 1;
    }

    /* renamed from: bd */
    public static boolean m25876bd(@NonNull AdInfo adInfo) {
        return m25941aU(adInfo).featureType == 2;
    }

    /* renamed from: be */
    public static int m25875be(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.materialType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i != 5) {
                    return i != 8 ? 0 : 8;
                }
                return 3;
            }
        }
        return i2;
    }

    /* renamed from: bf */
    public static int m25874bf(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.actionBarInfo.cardType;
    }

    /* renamed from: bg */
    public static String m25873bg(AdInfo adInfo) {
        return adInfo.adBaseInfo.liveStreamId;
    }

    /* renamed from: bh */
    public static boolean m25872bh(AdInfo adInfo) {
        return adInfo.adMaterialInfo.materialType == 1;
    }

    /* renamed from: bi */
    public static boolean m25871bi(AdInfo adInfo) {
        return adInfo.adConversionInfo.needDeeplinkReplaceAdapta;
    }

    /* renamed from: bj */
    public static boolean m25870bj(AdInfo adInfo) {
        return adInfo.adConversionInfo.isSupportKeepPlaying;
    }

    /* renamed from: bk */
    public static long m25869bk(AdInfo adInfo) {
        return adInfo.adConversionInfo.keepPlayingBackOffTime;
    }

    /* renamed from: bl */
    public static boolean m25868bl(AdInfo adInfo) {
        return new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig).length() != 0;
    }

    @Nullable
    /* renamed from: bm */
    public static List<Integer> m25867bm(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt > 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                    }
                }
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: bn */
    private static int[] m25866bn(@NonNull AdInfo adInfo) {
        String[] split;
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            split = str.split(",");
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
        if (split.length < 3) {
            return iArr;
        }
        iArr[0] = Integer.parseInt(split[0]);
        iArr[1] = Integer.parseInt(split[1]);
        iArr[2] = Integer.parseInt(split[2]);
        return iArr;
    }

    /* renamed from: bo */
    public static int m25865bo(@NonNull AdInfo adInfo) {
        int[] m25866bn = m25866bn(adInfo);
        if (m25866bn[0] > 0) {
            return m25866bn[0];
        }
        return 3;
    }

    /* renamed from: bp */
    public static int m25864bp(@NonNull AdInfo adInfo) {
        int[] m25866bn = m25866bn(adInfo);
        return (m25866bn[1] > 0 ? m25866bn[1] : 3) + m25865bo(adInfo);
    }

    /* renamed from: bq */
    public static int m25863bq(@NonNull AdInfo adInfo) {
        int[] m25866bn = m25866bn(adInfo);
        return (m25866bn[2] > 0 ? m25866bn[2] : 3) + m25864bp(adInfo);
    }

    @NonNull
    /* renamed from: br */
    public static C10493b m25862br(@NonNull AdInfo adInfo) {
        String str;
        int m25962Z;
        int m25935aa;
        boolean z;
        String m25973O = m25973O(adInfo);
        int m25971Q = m25971Q(adInfo);
        int m25970R = m25970R(adInfo);
        if (C11053bg.isNullString(m25973O) || C11053bg.m23924gQ(m25973O) || m25971Q == 0 || m25970R == 0) {
            String m25964X = m25964X(adInfo);
            str = m25964X;
            m25962Z = m25962Z(adInfo);
            m25935aa = m25935aa(adInfo);
            z = true;
        } else {
            str = m25973O;
            m25962Z = m25971Q;
            m25935aa = m25970R;
            z = false;
        }
        C10331c.m26254d("AdInfoHelper", "frameUrl=" + str + " useCover=" + z + " isAd=true");
        return new C10493b(str, m25962Z, m25935aa, true, z);
    }

    /* renamed from: bs */
    public static String m25861bs(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    /* renamed from: bt */
    public static boolean m25860bt(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    /* renamed from: bu */
    public static boolean m25859bu(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    /* renamed from: bv */
    public static int m25858bv(AdInfo adInfo) {
        AdInfo.ComplianceInfo complianceInfo = adInfo.downloadSafeInfo.complianceInfo;
        if (complianceInfo == null) {
            return -1;
        }
        return complianceInfo.materialJumpType;
    }

    /* renamed from: bw */
    public static boolean m25857bw(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    /* renamed from: bx */
    public static int m25856bx(AdInfo adInfo) {
        if (adInfo != null) {
            int i = adInfo.status;
            if (i == 0) {
                return 1;
            }
            if (1 == i || 2 == i || 3 == i || 4 == i) {
                return 2;
            }
            return 8 == i ? 3 : 0;
        }
        return 0;
    }

    /* renamed from: by */
    public static int m25855by(AdInfo adInfo) {
        return adInfo.status;
    }

    @Nullable
    /* renamed from: bz */
    public static String m25854bz(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    /* renamed from: cA */
    public static int m25853cA(@NonNull AdInfo adInfo) {
        double d = adInfo.adSplashInfo.impressionLimitSize;
        return ((int) ((d <= Utils.DOUBLE_EPSILON || d > 1.0d) ? 0.699999988079071d : 0.699999988079071d)) * 100;
    }

    /* renamed from: cB */
    public static boolean m25852cB(AdInfo adInfo) {
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        if (adInfo == null || (downloadSafeInfo = adInfo.downloadSafeInfo) == null) {
            return false;
        }
        return downloadSafeInfo.downloadPauseEnable;
    }

    /* renamed from: cC */
    public static String m25851cC(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    @Deprecated
    /* renamed from: cD */
    public static boolean m25850cD(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 3;
    }

    /* renamed from: cE */
    public static boolean m25849cE(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    @Deprecated
    /* renamed from: cF */
    public static boolean m25848cF(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 1;
    }

    @Nullable
    /* renamed from: cG */
    public static String m25847cG(@NonNull AdInfo adInfo) {
        double d;
        int i = adInfo.advertiserInfo.fansCount;
        if (i < 200 || i >= 10000) {
            if (i >= 10000) {
                Double.isNaN(i);
                DecimalFormat decimalFormat = new DecimalFormat(C2658ck.f8834d);
                return decimalFormat.format(d / 10000.0d) + IAdInterListener.AdReqParam.WIDTH;
            }
            return null;
        }
        return String.valueOf(i);
    }

    /* renamed from: cH */
    public static String m25846cH(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    /* renamed from: cI */
    public static String m25845cI(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    @Deprecated
    /* renamed from: cJ */
    public static boolean m25844cJ(@NonNull AdInfo adInfo) {
        int i = adInfo.adStyleConfInfo.innerAdType;
        return i == 4 || i == 5;
    }

    @Deprecated
    /* renamed from: cK */
    public static boolean m25843cK(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 7;
    }

    /* renamed from: cL */
    public static boolean m25842cL(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.universeLiveType == 1 && m25819cg(adInfo) != 0;
    }

    /* renamed from: cM */
    public static boolean m25841cM(@NonNull AdInfo adInfo) {
        return m25842cL(adInfo) || m25843cK(adInfo);
    }

    /* renamed from: cN */
    public static String m25840cN(@NonNull AdInfo adInfo) {
        InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
        return C11008ac.m24154c(interfaceC10968f == null ? null : interfaceC10968f.getContext(), adInfo.adConversionInfo.deeplinkUrl, m25960aB(adInfo));
    }

    /* renamed from: cO */
    public static String m25839cO(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.appDownloadUrl;
    }

    /* renamed from: cP */
    public static AdProductInfo m25838cP(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    /* renamed from: cQ */
    public static String m25837cQ(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    /* renamed from: cR */
    public static boolean m25836cR(@NonNull AdInfo adInfo) {
        if (m25956aF(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    /* renamed from: cS */
    public static boolean m25835cS(@NonNull AdInfo adInfo) {
        return m25836cR(adInfo) && m25929ag(adInfo) < m25975M(adInfo);
    }

    /* renamed from: cT */
    public static boolean m25834cT(@NonNull AdInfo adInfo) {
        if (TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.pushTKInfo.templateId)) {
            C10331c.m26254d("AdInfoHelper", "isPushAdEnable pushTK TemplateId is empty");
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        if ((java.lang.System.currentTimeMillis() - r2) > (r6 * 1000)) goto L7;
     */
    /* renamed from: cU */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m25833cU(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r8) {
        /*
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r0 = r8.adStyleConfInfo
            boolean r0 = r0.adPushSwitch
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            long r2 = com.kwad.sdk.utils.C11137y.m23632LM()
            r0 = 1
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L15
        L13:
            r1 = 1
            goto L2e
        L15:
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r8 = r8.adStyleConfInfo
            int r8 = r8.adPushIntervalTime
            long r6 = (long) r8
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 > 0) goto L20
            r6 = 900(0x384, double:4.447E-321)
        L20:
            r4 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r4
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L2e
            goto L13
        L2e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "isPushAdEnable intervalEnable: "
            r8.<init>(r0)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            java.lang.String r0 = "AdInfoHelper"
            com.kwad.sdk.core.p397e.C10331c.m26254d(r0, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.p409b.C10483a.m25833cU(com.kwad.sdk.core.response.model.AdInfo):boolean");
    }

    /* renamed from: cV */
    public static int m25832cV(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushShowAfterTime * 1000;
    }

    /* renamed from: cW */
    public static boolean m25831cW(@NonNull AdInfo adInfo) {
        return (!m25842cL(adInfo) || TextUtils.isEmpty(C10484b.m25720dU(adInfo)) || m25830cX(adInfo)) ? false : true;
    }

    /* renamed from: cX */
    private static boolean m25830cX(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.useNativeForOuterLiveAd;
    }

    /* renamed from: cY */
    public static long m25829cY(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.callBackAdvanceMs;
    }

    /* renamed from: cZ */
    public static boolean m25828cZ(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.serverCheckSwitch;
    }

    /* renamed from: ca */
    public static String m25826ca(AdTemplate adTemplate) {
        return C10487e.m25641dQ(adTemplate).adMatrixInfo.adDataV2.rewardWebTaskCloseInfo.templateId;
    }

    /* renamed from: cb */
    public static int m25825cb(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.confirmCardType;
    }

    @NonNull
    /* renamed from: cc */
    public static String m25823cc(@NonNull AdInfo adInfo) {
        String m25912ax;
        if (m25956aF(adInfo)) {
            m25912ax = m25914av(adInfo);
        } else {
            m25912ax = m25912ax(adInfo);
        }
        if (TextUtils.isEmpty(m25912ax)) {
            m25912ax = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(m25912ax) ? "可爱的广告君" : m25912ax;
    }

    @NonNull
    /* renamed from: cd */
    public static String m25822cd(@NonNull AdInfo adInfo) {
        String m25913aw = m25913aw(adInfo);
        return TextUtils.isEmpty(m25913aw) ? "可爱的广告君" : m25913aw;
    }

    @NonNull
    /* renamed from: ce */
    public static String m25821ce(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    /* renamed from: cf */
    public static String m25820cf(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        return (TextUtils.isEmpty(str) || !m25956aF(adInfo)) ? adInfo.advertiserInfo.portraitUrl : str;
    }

    /* renamed from: cg */
    public static long m25819cg(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.userId;
    }

    /* renamed from: ch */
    public static String m25818ch(@NonNull AdInfo adInfo) {
        return C11053bg.isNullString(adInfo.adConversionInfo.liveServiceToken) ? "" : adInfo.adConversionInfo.liveServiceToken;
    }

    /* renamed from: ci */
    public static long m25817ci(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.liveVisitorId;
    }

    @NonNull
    /* renamed from: cj */
    public static String m25816cj(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) ? "跳过" : adInfo.adSplashInfo.skipTips;
    }

    /* renamed from: ck */
    public static AdInfo.CutRuleInfo m25815ck(AdInfo adInfo) {
        return adInfo.adSplashInfo.cutRuleInfo;
    }

    /* renamed from: cl */
    public static int m25814cl(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowSecond;
    }

    /* renamed from: cm */
    public static boolean m25813cm(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowCountDown;
    }

    /* renamed from: cn */
    public static int m25812cn(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    /* renamed from: co */
    public static int m25811co(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    /* renamed from: cp */
    public static int m25810cp(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    /* renamed from: cq */
    public static String m25809cq(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    /* renamed from: cr */
    public static boolean m25808cr(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateSwitch;
    }

    /* renamed from: cs */
    public static int m25807cs(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    /* renamed from: ct */
    public static int m25806ct(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateInterval;
    }

    /* renamed from: cu */
    public static int m25805cu(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateDailyShowCount;
    }

    /* renamed from: cv */
    public static boolean m25804cv(@NonNull AdInfo adInfo) {
        int i = adInfo.adSplashInfo.skipType;
        return i == 2 || i == 3;
    }

    /* renamed from: cw */
    public static boolean m25803cw(@Nullable AdInfo adInfo) {
        if (m25802cx(adInfo)) {
            int i = adInfo.adSplashInfo.skipType;
            return i == 0 || i == 2;
        }
        return false;
    }

    /* renamed from: cx */
    public static boolean m25802cx(@Nullable AdInfo adInfo) {
        return adInfo.adSplashInfo.skipSecond >= 0;
    }

    /* renamed from: cy */
    public static boolean m25801cy(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) ? false : true;
    }

    /* renamed from: cz */
    public static boolean m25800cz(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.impressionStatisticalChangeSwitch;
    }

    /* renamed from: da */
    public static boolean m25799da(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.rewardAdvanceSwitch;
    }

    /* renamed from: db */
    public static KSAdInfoData m25798db(AdInfo adInfo) {
        KSAdInfoData interactionType = KSAdInfoData.obtain().setAdDescription(m25915au(adInfo)).setProductName(m25912ax(adInfo)).setAdSource(m25958aD(adInfo)).setVideoUrl(m25820cf(adInfo)).setMaterialType(m25875be(adInfo)).setAppIconUrl(m25820cf(adInfo)).setAppName(m25914av(adInfo)).setImageList(m25797dc(adInfo)).setVideoCoverImageUrl(m25796dd(adInfo)).setInteractionType(m25945aQ(adInfo));
        try {
            interactionType.setCreativeId(m25978J(adInfo));
        } catch (Throwable unused) {
        }
        return interactionType;
    }

    /* renamed from: dc */
    private static List<String> m25797dc(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int m25875be = m25875be(adInfo);
        if (m25875be == 2 || m25875be == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: dd */
    private static String m25796dd(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature m25940aV = m25940aV(adInfo);
        if (TextUtils.isEmpty(m25940aV.coverUrl)) {
            return null;
        }
        return m25940aV.coverUrl;
    }

    @Deprecated
    /* renamed from: dm */
    public static String m25795dm(int i) {
        return m25793q(i, "下载中  %s%%");
    }

    /* renamed from: dn */
    public static String m25794dn(int i) {
        return "继续下载 " + i + "%";
    }

    /* renamed from: q */
    public static String m25793q(int i, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i));
    }

    /* renamed from: bZ */
    public static int m25881bZ(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.actionBarType;
    }

    /* renamed from: ca */
    public static int m25827ca(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.endCardType;
    }

    @Deprecated
    /* renamed from: cb */
    public static boolean m25824cb(@NonNull AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo m25717db = C10484b.m25717db(adTemplate);
        return (m25717db != null && !m25717db.isEmpty()) && m25641dQ.adStyleConfInfo.innerAdType == 2;
    }

    @Nullable
    /* renamed from: b */
    public static SpannableString m25909b(AdInfo adInfo, @ColorInt int i) {
        String format;
        int indexOf;
        String m25847cG = m25847cG(adInfo);
        if (m25847cG == null || (indexOf = (format = String.format("已有%s粉丝关注了TA", m25847cG)).indexOf(m25847cG)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(i), indexOf, m25847cG.length() + indexOf, 18);
        return spannableString;
    }

    @NonNull
    /* renamed from: bY */
    public static String m25883bY(@NonNull AdInfo adInfo) {
        String str = adInfo.adStyleInfo.adBrowseInfo.rewardDescription;
        return TextUtils.isEmpty(str) ? "浏览页面" : str;
    }
}
