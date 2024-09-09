package com.kwad.sdk.core.response.b;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bg;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static String Fg() {
        return "\u7ee7\u7eed\u4e0b\u8f7d";
    }

    public static String H(AdInfo adInfo) {
        return adInfo.downloadFilePath;
    }

    public static long J(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    public static String K(@NonNull AdInfo adInfo) {
        return aV(adInfo).materialUrl;
    }

    public static int L(@NonNull AdInfo adInfo) {
        if (be(adInfo) == 2) {
            return aU(adInfo).videoDuration;
        }
        return aV(adInfo).videoDuration;
    }

    public static long M(@NonNull AdInfo adInfo) {
        int i4;
        if (be(adInfo) == 2) {
            i4 = aU(adInfo).videoDuration;
        } else {
            i4 = aV(adInfo).videoDuration;
        }
        return i4 * 1000;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature N(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        if (ah.P(list)) {
            return list.get(0);
        }
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String O(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = be(r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.O(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static boolean P(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    public static int Q(@NonNull AdInfo adInfo) {
        return aV(adInfo).videoWidth;
    }

    public static int R(@NonNull AdInfo adInfo) {
        return aV(adInfo).videoHeight;
    }

    public static boolean S(@NonNull AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo;
        return smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId);
    }

    public static boolean T(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.webUriSourceType == 2;
    }

    public static boolean U(AdInfo adInfo) {
        return adInfo.adConversionInfo.appSecondConfirmationSwitch;
    }

    public static boolean V(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5SecondConfirmationSwitch;
    }

    public static boolean W(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aV = aV(adInfo);
        return aV.videoWidth <= aV.videoHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0072  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String X(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = be(r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.X(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static String Y(@NonNull AdInfo adInfo) {
        int be = be(adInfo);
        if (be != 1) {
            if (be != 2 && be != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return aX(adInfo).blurBackgroundUrl;
    }

    private static int Z(@NonNull AdInfo adInfo) {
        return aV(adInfo).width;
    }

    public static float aA(@NonNull AdInfo adInfo) {
        int i4 = adInfo.adBaseInfo.appScore;
        if (i4 <= 0) {
            return 0.0f;
        }
        return i4 / 10.0f;
    }

    public static boolean aB(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.enableClientProofreadTime;
    }

    public static float aC(@NonNull AdInfo adInfo) {
        float f4 = adInfo.adBaseInfo.appScore;
        if (f4 < 30.0f) {
            return 3.0f;
        }
        if (f4 < 35.0f) {
            return 3.5f;
        }
        if (f4 < 40.0f) {
            return 4.0f;
        }
        return f4 < 45.0f ? 4.5f : 5.0f;
    }

    public static String aD(AdInfo adInfo) {
        return bg.isNullString(adInfo.adBaseInfo.adSourceDescription) ? "\u5e7f\u544a" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String aE(@Nullable AdInfo adInfo) {
        if (adInfo == null) {
            return "\u7acb\u5373\u4e0b\u8f7d";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return aF(adInfo) ? "\u7acb\u5373\u4e0b\u8f7d" : "\u67e5\u770b\u8be6\u60c5";
        }
        return str;
    }

    public static boolean aF(@NonNull AdInfo adInfo) {
        return aQ(adInfo) == 1;
    }

    public static boolean aG(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardVideoInteractSwitch && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.templateId);
    }

    public static int aH(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.intervalShow;
    }

    public static int aI(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.dayMaxLimit;
    }

    public static int aJ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.showTime;
    }

    public static int aK(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.rewardTime;
    }

    public static int aL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.showTime;
    }

    public static int aM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.thresholdTime;
    }

    public static int aN(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.taskType;
    }

    public static boolean aO(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.templateId);
    }

    public static boolean aP(@NonNull AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && aF(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    public static int aQ(@NonNull AdInfo adInfo) {
        int i4 = adInfo.adBaseInfo.adOperationType;
        int i5 = 1;
        if (i4 != 1) {
            i5 = 2;
            if (i4 != 2) {
                return 0;
            }
        }
        return i5;
    }

    public static int aR(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String aS(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        return TextUtils.isEmpty(adInfo.adConversionInfo.h5Url) ? "" : ac.c(fVar == null ? null : fVar.getContext(), adInfo.adConversionInfo.h5Url, aB(adInfo));
    }

    public static int aT(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aU(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aV(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean aW(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aU;
        if (bc(adInfo)) {
            aU = aV(adInfo);
        } else {
            aU = aU(adInfo);
        }
        return aU.height > aU.width;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aX(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    public static boolean aY(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aV = aV(adInfo);
        return aV.height > aV.width;
    }

    public static String aZ(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    private static int aa(@NonNull AdInfo adInfo) {
        return aV(adInfo).height;
    }

    public static long ab(@NonNull AdInfo adInfo) {
        return aV(adInfo).photoId;
    }

    public static String ac(@Nullable AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "\u7acb\u5373\u6253\u5f00" : adInfo.adBaseInfo.openAppLabel;
    }

    public static long ad(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static int ae(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long af(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime * 1000;
    }

    public static long ag(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime * 1000;
    }

    private static int ah(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static boolean ai(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdShakeInfo nativeAdShakeInfo;
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null && (nativeAdShakeInfo = nativeAdInfo.shakeInfo) != null) {
            return nativeAdShakeInfo.enableShake;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return false;
    }

    public static int aj(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null) {
            return nativeAdInfo.shakeInfo.acceleration;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return 2;
    }

    public static boolean ak(@NonNull AdInfo adInfo) {
        return ah(adInfo) != 0;
    }

    public static long al(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.fullScreenSkipShowTime * 1000;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long am(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static int an(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.showPageType;
    }

    public static boolean ao(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoAutoLoopAtH5;
    }

    public static boolean ap(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoMutedAtH5;
    }

    public static boolean aq(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoClickAtH5;
    }

    public static long ar(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean as(@NonNull AdInfo adInfo) {
        return !aF(adInfo) && at(adInfo);
    }

    public static boolean at(@NonNull AdInfo adInfo) {
        if (adInfo.adRewardInfo.showLandingPage == 1) {
            return ((aO(adInfo) && aN(adInfo) == 1) || cR(adInfo)) ? false : true;
        }
        return false;
    }

    public static String au(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String av(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    private static String aw(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.realAppName;
    }

    public static String ax(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String ay(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null) {
            return null;
        }
        return adBaseInfo.appPackageName;
    }

    public static String az(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static boolean b(@NonNull AdInfo adInfo, boolean z3) {
        return ((z3 && aF(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || bg.isNullString(aS(adInfo))) ? false : true;
    }

    @Nullable
    public static String bA(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    public static String bB(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String bC(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfo;
        }
        return null;
    }

    @Nullable
    public static String bD(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String bE(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    public static String bF(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long bG(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static boolean bH(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            String str = adConversionInfo.playableUrl;
            boolean z3 = (str == null || adConversionInfo.playableStyleInfo == null || TextUtils.isEmpty(str.trim())) ? false : true;
            if (bK(adInfo) && z3) {
                return true;
            }
        }
        return false;
    }

    public static long bI(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.h5DeeplinkLimitedTimeMs;
    }

    public static long bJ(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.playableDeeplinkLimitedTimeMs;
    }

    public static boolean bK(AdInfo adInfo) {
        if (ai.isOrientationPortrait()) {
            return bM(adInfo);
        }
        return bL(adInfo);
    }

    private static boolean bL(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i4 = playableStyleInfo.playableOrientation;
        return i4 == 0 || i4 == 2;
    }

    private static boolean bM(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i4 = playableStyleInfo.playableOrientation;
        return i4 == 0 || i4 == 1;
    }

    @Nullable
    public static String bN(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.playableUrl;
    }

    @Nullable
    public static String bO(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrl;
    }

    @Nullable
    public static String bP(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrlInfo;
    }

    @Nullable
    public static String bQ(AdInfo adInfo) {
        String str;
        if (adInfo == null || (str = adInfo.serverExt) == null) {
            return null;
        }
        return str;
    }

    public static boolean bR(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean bS(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    public static boolean bT(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean bU(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null) {
            return false;
        }
        int i4 = adFeedInfo.videoAutoPlayType;
        return i4 == 1 || i4 == 0;
    }

    public static boolean bV(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean bW(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 3) ? false : true;
    }

    public static boolean bX(AdInfo adInfo) {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        return (hVar == null || !hVar.yV()) && !TextUtils.isEmpty(aS(adInfo)) && adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse == 1;
    }

    public static String bY(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.getAdStyle() != 2 || cK(e.dQ(adTemplate)) || cL(e.dQ(adTemplate))) {
            if (adTemplate == null) {
                return "\u7acb\u5373\u5b89\u88c5";
            }
            AdInfo dQ = e.dQ(adTemplate);
            return TextUtils.isEmpty(dQ.adBaseInfo.installAppLabel) ? "\u7acb\u5373\u5b89\u88c5" : dQ.adBaseInfo.installAppLabel;
        }
        return "\u5b89\u88c5\u83b7\u53d6\u5956\u52b1";
    }

    public static boolean bZ(AdTemplate adTemplate) {
        return e.dQ(adTemplate).adBaseInfo.apiExpParam.aggregateMiddlePageShowPathSwitch;
    }

    @NonNull
    public static List<String> ba(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int be = be(adInfo);
        if (be == 2 || be == 3) {
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
    public static String bb(@NonNull AdInfo adInfo) {
        if (bc(adInfo)) {
            return K(adInfo);
        }
        List<String> ba = ba(adInfo);
        return ba.size() > 0 ? ba.get(0) : "";
    }

    public static boolean bc(@NonNull AdInfo adInfo) {
        return be(adInfo) == 1;
    }

    public static boolean bd(@NonNull AdInfo adInfo) {
        return aU(adInfo).featureType == 2;
    }

    public static int be(AdInfo adInfo) {
        int i4 = adInfo.adMaterialInfo.materialType;
        int i5 = 1;
        if (i4 != 1) {
            i5 = 2;
            if (i4 != 2) {
                if (i4 != 5) {
                    return i4 != 8 ? 0 : 8;
                }
                return 3;
            }
        }
        return i5;
    }

    public static int bf(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.actionBarInfo.cardType;
    }

    public static String bg(AdInfo adInfo) {
        return adInfo.adBaseInfo.liveStreamId;
    }

    public static boolean bh(AdInfo adInfo) {
        return adInfo.adMaterialInfo.materialType == 1;
    }

    public static boolean bi(AdInfo adInfo) {
        return adInfo.adConversionInfo.needDeeplinkReplaceAdapta;
    }

    public static boolean bj(AdInfo adInfo) {
        return adInfo.adConversionInfo.isSupportKeepPlaying;
    }

    public static long bk(AdInfo adInfo) {
        return adInfo.adConversionInfo.keepPlayingBackOffTime;
    }

    public static boolean bl(AdInfo adInfo) {
        return new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig).length() != 0;
    }

    @Nullable
    public static List<Integer> bm(@NonNull AdInfo adInfo) {
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
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static int[] bn(@NonNull AdInfo adInfo) {
        String[] split;
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            split = str.split(",");
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
        if (split.length < 3) {
            return iArr;
        }
        iArr[0] = Integer.parseInt(split[0]);
        iArr[1] = Integer.parseInt(split[1]);
        iArr[2] = Integer.parseInt(split[2]);
        return iArr;
    }

    public static int bo(@NonNull AdInfo adInfo) {
        int[] bn = bn(adInfo);
        if (bn[0] > 0) {
            return bn[0];
        }
        return 3;
    }

    public static int bp(@NonNull AdInfo adInfo) {
        int[] bn = bn(adInfo);
        return (bn[1] > 0 ? bn[1] : 3) + bo(adInfo);
    }

    public static int bq(@NonNull AdInfo adInfo) {
        int[] bn = bn(adInfo);
        return (bn[2] > 0 ? bn[2] : 3) + bp(adInfo);
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.b br(@NonNull AdInfo adInfo) {
        String str;
        int Z;
        int aa;
        boolean z3;
        String O = O(adInfo);
        int Q = Q(adInfo);
        int R = R(adInfo);
        if (bg.isNullString(O) || bg.gQ(O) || Q == 0 || R == 0) {
            String X = X(adInfo);
            str = X;
            Z = Z(adInfo);
            aa = aa(adInfo);
            z3 = true;
        } else {
            str = O;
            Z = Q;
            aa = R;
            z3 = false;
        }
        com.kwad.sdk.core.e.c.d("AdInfoHelper", "frameUrl=" + str + " useCover=" + z3 + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(str, Z, aa, true, z3);
    }

    public static String bs(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "\u60a8\u8bbf\u95ee\u7684\u7f51\u7ad9\u7531\u7b2c\u4e09\u65b9\u63d0\u4f9b";
    }

    public static boolean bt(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean bu(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static int bv(AdInfo adInfo) {
        AdInfo.ComplianceInfo complianceInfo = adInfo.downloadSafeInfo.complianceInfo;
        if (complianceInfo == null) {
            return -1;
        }
        return complianceInfo.materialJumpType;
    }

    public static boolean bw(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int bx(AdInfo adInfo) {
        if (adInfo != null) {
            int i4 = adInfo.status;
            if (i4 == 0) {
                return 1;
            }
            if (1 == i4 || 2 == i4 || 3 == i4 || 4 == i4) {
                return 2;
            }
            return 8 == i4 ? 3 : 0;
        }
        return 0;
    }

    public static int by(AdInfo adInfo) {
        return adInfo.status;
    }

    @Nullable
    public static String bz(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    public static int cA(@NonNull AdInfo adInfo) {
        double d4 = adInfo.adSplashInfo.impressionLimitSize;
        return ((int) ((d4 <= 0.0d || d4 > 1.0d) ? 0.699999988079071d : 0.699999988079071d)) * 100;
    }

    public static boolean cB(AdInfo adInfo) {
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        if (adInfo == null || (downloadSafeInfo = adInfo.downloadSafeInfo) == null) {
            return false;
        }
        return downloadSafeInfo.downloadPauseEnable;
    }

    public static String cC(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    @Deprecated
    public static boolean cD(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 3;
    }

    public static boolean cE(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    @Deprecated
    public static boolean cF(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 1;
    }

    @Nullable
    public static String cG(@NonNull AdInfo adInfo) {
        double d4;
        int i4 = adInfo.advertiserInfo.fansCount;
        if (i4 < 200 || i4 >= 10000) {
            if (i4 >= 10000) {
                Double.isNaN(i4);
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                return decimalFormat.format(d4 / 10000.0d) + "w";
            }
            return null;
        }
        return String.valueOf(i4);
    }

    public static String cH(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String cI(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    @Deprecated
    public static boolean cJ(@NonNull AdInfo adInfo) {
        int i4 = adInfo.adStyleConfInfo.innerAdType;
        return i4 == 4 || i4 == 5;
    }

    @Deprecated
    public static boolean cK(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 7;
    }

    public static boolean cL(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.universeLiveType == 1 && cg(adInfo) != 0;
    }

    public static boolean cM(@NonNull AdInfo adInfo) {
        return cL(adInfo) || cK(adInfo);
    }

    public static String cN(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        return ac.c(fVar == null ? null : fVar.getContext(), adInfo.adConversionInfo.deeplinkUrl, aB(adInfo));
    }

    public static String cO(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.appDownloadUrl;
    }

    public static AdProductInfo cP(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String cQ(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    public static boolean cR(@NonNull AdInfo adInfo) {
        if (aF(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    public static boolean cS(@NonNull AdInfo adInfo) {
        return cR(adInfo) && ag(adInfo) < M(adInfo);
    }

    public static boolean cT(@NonNull AdInfo adInfo) {
        if (TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.pushTKInfo.templateId)) {
            com.kwad.sdk.core.e.c.d("AdInfoHelper", "isPushAdEnable pushTK TemplateId is empty");
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        if ((java.lang.System.currentTimeMillis() - r2) > (r6 * 1000)) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean cU(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r8) {
        /*
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r0 = r8.adStyleConfInfo
            boolean r0 = r0.adPushSwitch
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            long r2 = com.kwad.sdk.utils.y.LM()
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
            com.kwad.sdk.core.e.c.d(r0, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.cU(com.kwad.sdk.core.response.model.AdInfo):boolean");
    }

    public static int cV(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushShowAfterTime * 1000;
    }

    public static boolean cW(@NonNull AdInfo adInfo) {
        return (!cL(adInfo) || TextUtils.isEmpty(b.dU(adInfo)) || cX(adInfo)) ? false : true;
    }

    private static boolean cX(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.useNativeForOuterLiveAd;
    }

    public static long cY(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.callBackAdvanceMs;
    }

    public static boolean cZ(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.serverCheckSwitch;
    }

    public static String ca(AdTemplate adTemplate) {
        return e.dQ(adTemplate).adMatrixInfo.adDataV2.rewardWebTaskCloseInfo.templateId;
    }

    public static int cb(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.confirmCardType;
    }

    @NonNull
    public static String cc(@NonNull AdInfo adInfo) {
        String ax;
        if (aF(adInfo)) {
            ax = av(adInfo);
        } else {
            ax = ax(adInfo);
        }
        if (TextUtils.isEmpty(ax)) {
            ax = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(ax) ? "\u53ef\u7231\u7684\u5e7f\u544a\u541b" : ax;
    }

    @NonNull
    public static String cd(@NonNull AdInfo adInfo) {
        String aw = aw(adInfo);
        return TextUtils.isEmpty(aw) ? "\u53ef\u7231\u7684\u5e7f\u544a\u541b" : aw;
    }

    @NonNull
    public static String ce(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static String cf(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        return (TextUtils.isEmpty(str) || !aF(adInfo)) ? adInfo.advertiserInfo.portraitUrl : str;
    }

    public static long cg(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.userId;
    }

    public static String ch(@NonNull AdInfo adInfo) {
        return bg.isNullString(adInfo.adConversionInfo.liveServiceToken) ? "" : adInfo.adConversionInfo.liveServiceToken;
    }

    public static long ci(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.liveVisitorId;
    }

    @NonNull
    public static String cj(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) ? "\u8df3\u8fc7" : adInfo.adSplashInfo.skipTips;
    }

    public static AdInfo.CutRuleInfo ck(AdInfo adInfo) {
        return adInfo.adSplashInfo.cutRuleInfo;
    }

    public static int cl(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowSecond;
    }

    public static boolean cm(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowCountDown;
    }

    public static int cn(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int co(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int cp(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static String cq(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    public static boolean cr(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateSwitch;
    }

    public static int cs(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static int ct(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateInterval;
    }

    public static int cu(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateDailyShowCount;
    }

    public static boolean cv(@NonNull AdInfo adInfo) {
        int i4 = adInfo.adSplashInfo.skipType;
        return i4 == 2 || i4 == 3;
    }

    public static boolean cw(@Nullable AdInfo adInfo) {
        if (cx(adInfo)) {
            int i4 = adInfo.adSplashInfo.skipType;
            return i4 == 0 || i4 == 2;
        }
        return false;
    }

    public static boolean cx(@Nullable AdInfo adInfo) {
        return adInfo.adSplashInfo.skipSecond >= 0;
    }

    public static boolean cy(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) ? false : true;
    }

    public static boolean cz(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.impressionStatisticalChangeSwitch;
    }

    public static boolean da(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.rewardAdvanceSwitch;
    }

    public static KSAdInfoData db(AdInfo adInfo) {
        KSAdInfoData interactionType = KSAdInfoData.obtain().setAdDescription(au(adInfo)).setProductName(ax(adInfo)).setAdSource(aD(adInfo)).setVideoUrl(cf(adInfo)).setMaterialType(be(adInfo)).setAppIconUrl(cf(adInfo)).setAppName(av(adInfo)).setImageList(dc(adInfo)).setVideoCoverImageUrl(dd(adInfo)).setInteractionType(aQ(adInfo));
        try {
            interactionType.setCreativeId(J(adInfo));
        } catch (Throwable unused) {
        }
        return interactionType;
    }

    private static List<String> dc(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int be = be(adInfo);
        if (be == 2 || be == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
        }
        return arrayList;
    }

    private static String dd(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aV = aV(adInfo);
        if (TextUtils.isEmpty(aV.coverUrl)) {
            return null;
        }
        return aV.coverUrl;
    }

    @Deprecated
    public static String dm(int i4) {
        return q(i4, "\u4e0b\u8f7d\u4e2d  %s%%");
    }

    public static String dn(int i4) {
        return "\u7ee7\u7eed\u4e0b\u8f7d " + i4 + "%";
    }

    public static String q(int i4, String str) {
        if (str == null) {
            str = "\u4e0b\u8f7d\u4e2d  %s%%";
        }
        return String.format(str, Integer.valueOf(i4));
    }

    public static int bZ(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.actionBarType;
    }

    public static int ca(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.endCardType;
    }

    @Deprecated
    public static boolean cb(@NonNull AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo db = b.db(adTemplate);
        return (db != null && !db.isEmpty()) && dQ.adStyleConfInfo.innerAdType == 2;
    }

    @Nullable
    public static SpannableString b(AdInfo adInfo, @ColorInt int i4) {
        String format;
        int indexOf;
        String cG = cG(adInfo);
        if (cG == null || (indexOf = (format = String.format("\u5df2\u6709%s\u7c89\u4e1d\u5173\u6ce8\u4e86TA", cG)).indexOf(cG)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(i4), indexOf, cG.length() + indexOf, 18);
        return spannableString;
    }

    @NonNull
    public static String bY(@NonNull AdInfo adInfo) {
        String str = adInfo.adStyleInfo.adBrowseInfo.rewardDescription;
        return TextUtils.isEmpty(str) ? "\u6d4f\u89c8\u9875\u9762" : str;
    }
}
