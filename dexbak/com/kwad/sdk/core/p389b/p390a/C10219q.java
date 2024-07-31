package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10219q implements InterfaceC10273d<AdMatrixInfo.AdDataV2> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        m26650a(adDataV2, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        return m26649b(adDataV2, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26650a(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adDataV2.templateDataList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("templateDatas");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdMatrixInfo.TemplateData templateData = new AdMatrixInfo.TemplateData();
                templateData.parseJson(optJSONArray.optJSONObject(i));
                adDataV2.templateDataList.add(templateData);
            }
        }
        AdMatrixInfo.BottomBannerInfo bottomBannerInfo = new AdMatrixInfo.BottomBannerInfo();
        adDataV2.bottomBannerInfo = bottomBannerInfo;
        bottomBannerInfo.parseJson(jSONObject.optJSONObject("bottomBannerInfo"));
        AdMatrixInfo.ActionBarInfoNew actionBarInfoNew = new AdMatrixInfo.ActionBarInfoNew();
        adDataV2.actionBarInfo = actionBarInfoNew;
        actionBarInfoNew.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        AdMatrixInfo.AggregationCardInfo aggregationCardInfo = new AdMatrixInfo.AggregationCardInfo();
        adDataV2.aggregationCardInfo = aggregationCardInfo;
        aggregationCardInfo.parseJson(jSONObject.optJSONObject("aggregationCardInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.halfCardInfo = baseMatrixTemplate;
        baseMatrixTemplate.parseJson(jSONObject.optJSONObject("halfCardInfo"));
        AdMatrixInfo.EndCardInfo endCardInfo = new AdMatrixInfo.EndCardInfo();
        adDataV2.endCardInfo = endCardInfo;
        endCardInfo.parseJson(jSONObject.optJSONObject("endCardInfo"));
        AdMatrixInfo.InterstitialCardInfo interstitialCardInfo = new AdMatrixInfo.InterstitialCardInfo();
        adDataV2.interstitialCardInfo = interstitialCardInfo;
        interstitialCardInfo.parseJson(jSONObject.optJSONObject("interstitialCardInfo"));
        AdMatrixInfo.FeedInfo feedInfo = new AdMatrixInfo.FeedInfo();
        adDataV2.feedInfo = feedInfo;
        feedInfo.parseJson(jSONObject.optJSONObject("feedInfo"));
        AdMatrixInfo.FeedTKInfo feedTKInfo = new AdMatrixInfo.FeedTKInfo();
        adDataV2.feedTKCardInfo = feedTKInfo;
        feedTKInfo.parseJson(jSONObject.optJSONObject("feedTKCardInfo"));
        AdMatrixInfo.FeedInfo feedInfo2 = new AdMatrixInfo.FeedInfo();
        adDataV2.adUnionFeedLiveMediaInfo = feedInfo2;
        feedInfo2.parseJson(jSONObject.optJSONObject("adUnionFeedLiveMediaInfo"));
        AdMatrixInfo.FeedInfo feedInfo3 = new AdMatrixInfo.FeedInfo();
        adDataV2.adUnionFeedLiveTemplateInfo = feedInfo3;
        feedInfo3.parseJson(jSONObject.optJSONObject("adUnionFeedLiveTemplateInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate2 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.complianceCardInfo = baseMatrixTemplate2;
        baseMatrixTemplate2.parseJson(jSONObject.optJSONObject("complianceCardInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate3 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.downloadConfirmCardInfo = baseMatrixTemplate3;
        baseMatrixTemplate3.parseJson(jSONObject.optJSONObject("downloadConfirmCardInfo"));
        AdMatrixInfo.SplashInfo splashInfo = new AdMatrixInfo.SplashInfo();
        adDataV2.splashInfo = splashInfo;
        splashInfo.parseJson(jSONObject.optJSONObject("splashInfo"));
        AdMatrixInfo.NeoVideoInfo neoVideoInfo = new AdMatrixInfo.NeoVideoInfo();
        adDataV2.neoVideoInfo = neoVideoInfo;
        neoVideoInfo.parseJson(jSONObject.optJSONObject("neoVideoInfo"));
        AdMatrixInfo.FullScreenInfo fullScreenInfo = new AdMatrixInfo.FullScreenInfo();
        adDataV2.fullScreenInfo = fullScreenInfo;
        fullScreenInfo.parseJson(jSONObject.optJSONObject("fullScreenInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate4 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.middleTKCardInfo = baseMatrixTemplate4;
        baseMatrixTemplate4.parseJson(jSONObject.optJSONObject("middleTKCardInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate5 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.actionBarTKInfo = baseMatrixTemplate5;
        baseMatrixTemplate5.parseJson(jSONObject.optJSONObject("actionBarTKInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate6 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.topBarTKInfo = baseMatrixTemplate6;
        baseMatrixTemplate6.parseJson(jSONObject.optJSONObject("topBarTKInfo"));
        AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo = new AdMatrixInfo.SplashPlayCardTKInfo();
        adDataV2.splashPlayCardTKInfo = splashPlayCardTKInfo;
        splashPlayCardTKInfo.parseJson(jSONObject.optJSONObject("splashPlayCardTKInfo"));
        AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo = new AdMatrixInfo.SplashEndCardTKInfo();
        adDataV2.splashEndCardTKInfo = splashEndCardTKInfo;
        splashEndCardTKInfo.parseJson(jSONObject.optJSONObject("splashEndCardTKInfo"));
        AdMatrixInfo.TopFloorTKInfo topFloorTKInfo = new AdMatrixInfo.TopFloorTKInfo();
        adDataV2.topFloorTKInfo = topFloorTKInfo;
        topFloorTKInfo.parseJson(jSONObject.optJSONObject("topFloorTKInfo"));
        AdMatrixInfo.ActivityMiddlePageInfo activityMiddlePageInfo = new AdMatrixInfo.ActivityMiddlePageInfo();
        adDataV2.activityMiddlePageInfo = activityMiddlePageInfo;
        activityMiddlePageInfo.parseJson(jSONObject.optJSONObject("activityMiddlePageInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate7 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.confirmTKInfo = baseMatrixTemplate7;
        baseMatrixTemplate7.parseJson(jSONObject.optJSONObject("confirmTKInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate8 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.playendTKInfo = baseMatrixTemplate8;
        baseMatrixTemplate8.parseJson(jSONObject.optJSONObject("playendTKInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate9 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.activityTKInfo = baseMatrixTemplate9;
        baseMatrixTemplate9.parseJson(jSONObject.optJSONObject("activityTKInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate10 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.neoTKInfo = baseMatrixTemplate10;
        baseMatrixTemplate10.parseJson(jSONObject.optJSONObject("neoTKInfo"));
        AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo = new AdMatrixInfo.RewardVideoInteractInfo();
        adDataV2.rewardVideoInteractInfo = rewardVideoInteractInfo;
        rewardVideoInteractInfo.parseJson(jSONObject.optJSONObject("rewardVideoInteractInfo"));
        AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo = new AdMatrixInfo.RewardVideoTaskInfo();
        adDataV2.rewardVideoTaskInfo = rewardVideoTaskInfo;
        rewardVideoTaskInfo.parseJson(jSONObject.optJSONObject("rewardVideoTaskInfo"));
        AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo = new AdMatrixInfo.RewardWebTaskCloseInfo();
        adDataV2.rewardWebTaskCloseInfo = rewardWebTaskCloseInfo;
        rewardWebTaskCloseInfo.parseJson(jSONObject.optJSONObject("rewardWebTaskCloseInfo"));
        AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo = new AdMatrixInfo.MerchantLiveReservationInfo();
        adDataV2.merchantLiveReservationInfo = merchantLiveReservationInfo;
        merchantLiveReservationInfo.parseJson(jSONObject.optJSONObject("merchantLiveReservationInfo"));
        AdMatrixInfo.PushTKInfo pushTKInfo = new AdMatrixInfo.PushTKInfo();
        adDataV2.pushTKInfo = pushTKInfo;
        pushTKInfo.parseJson(jSONObject.optJSONObject("pushTKInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate11 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.splashActionBarInfo = baseMatrixTemplate11;
        baseMatrixTemplate11.parseJson(jSONObject.optJSONObject("splashActionBarInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate12 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.videoLiveTKInfo = baseMatrixTemplate12;
        baseMatrixTemplate12.parseJson(jSONObject.optJSONObject("videoLiveTKInfo"));
        AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo = new AdMatrixInfo.PreLandingPageTKInfo();
        adDataV2.preLandingPageTKInfo = preLandingPageTKInfo;
        preLandingPageTKInfo.parseJson(jSONObject.optJSONObject("preLandingPageTKInfo"));
        AdMatrixInfo.InstalledActivateInfo installedActivateInfo = new AdMatrixInfo.InstalledActivateInfo();
        adDataV2.installedActivateInfo = installedActivateInfo;
        installedActivateInfo.parseJson(jSONObject.optJSONObject("installedActivateInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate13 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.videoImageTKInfo = baseMatrixTemplate13;
        baseMatrixTemplate13.parseJson(jSONObject.optJSONObject("videoImageTKInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26649b(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "templateDatas", adDataV2.templateDataList);
        C11126t.m23678a(jSONObject, "bottomBannerInfo", adDataV2.bottomBannerInfo);
        C11126t.m23678a(jSONObject, "actionBarInfo", adDataV2.actionBarInfo);
        C11126t.m23678a(jSONObject, "aggregationCardInfo", adDataV2.aggregationCardInfo);
        C11126t.m23678a(jSONObject, "halfCardInfo", adDataV2.halfCardInfo);
        C11126t.m23678a(jSONObject, "endCardInfo", adDataV2.endCardInfo);
        C11126t.m23678a(jSONObject, "interstitialCardInfo", adDataV2.interstitialCardInfo);
        C11126t.m23678a(jSONObject, "feedInfo", adDataV2.feedInfo);
        C11126t.m23678a(jSONObject, "feedTKCardInfo", adDataV2.feedTKCardInfo);
        C11126t.m23678a(jSONObject, "adUnionFeedLiveMediaInfo", adDataV2.adUnionFeedLiveMediaInfo);
        C11126t.m23678a(jSONObject, "adUnionFeedLiveTemplateInfo", adDataV2.adUnionFeedLiveTemplateInfo);
        C11126t.m23678a(jSONObject, "complianceCardInfo", adDataV2.complianceCardInfo);
        C11126t.m23678a(jSONObject, "downloadConfirmCardInfo", adDataV2.downloadConfirmCardInfo);
        C11126t.m23678a(jSONObject, "splashInfo", adDataV2.splashInfo);
        C11126t.m23678a(jSONObject, "neoVideoInfo", adDataV2.neoVideoInfo);
        C11126t.m23678a(jSONObject, "fullScreenInfo", adDataV2.fullScreenInfo);
        C11126t.m23678a(jSONObject, "middleTKCardInfo", adDataV2.middleTKCardInfo);
        C11126t.m23678a(jSONObject, "actionBarTKInfo", adDataV2.actionBarTKInfo);
        C11126t.m23678a(jSONObject, "topBarTKInfo", adDataV2.topBarTKInfo);
        C11126t.m23678a(jSONObject, "splashPlayCardTKInfo", adDataV2.splashPlayCardTKInfo);
        C11126t.m23678a(jSONObject, "splashEndCardTKInfo", adDataV2.splashEndCardTKInfo);
        C11126t.m23678a(jSONObject, "topFloorTKInfo", adDataV2.topFloorTKInfo);
        C11126t.m23678a(jSONObject, "activityMiddlePageInfo", adDataV2.activityMiddlePageInfo);
        C11126t.m23678a(jSONObject, "confirmTKInfo", adDataV2.confirmTKInfo);
        C11126t.m23678a(jSONObject, "playendTKInfo", adDataV2.playendTKInfo);
        C11126t.m23678a(jSONObject, "activityTKInfo", adDataV2.activityTKInfo);
        C11126t.m23678a(jSONObject, "neoTKInfo", adDataV2.neoTKInfo);
        C11126t.m23678a(jSONObject, "rewardVideoInteractInfo", adDataV2.rewardVideoInteractInfo);
        C11126t.m23678a(jSONObject, "rewardVideoTaskInfo", adDataV2.rewardVideoTaskInfo);
        C11126t.m23678a(jSONObject, "rewardWebTaskCloseInfo", adDataV2.rewardWebTaskCloseInfo);
        C11126t.m23678a(jSONObject, "merchantLiveReservationInfo", adDataV2.merchantLiveReservationInfo);
        C11126t.m23678a(jSONObject, "pushTKInfo", adDataV2.pushTKInfo);
        C11126t.m23678a(jSONObject, "splashActionBarInfo", adDataV2.splashActionBarInfo);
        C11126t.m23678a(jSONObject, "videoLiveTKInfo", adDataV2.videoLiveTKInfo);
        C11126t.m23678a(jSONObject, "preLandingPageTKInfo", adDataV2.preLandingPageTKInfo);
        C11126t.m23678a(jSONObject, "installedActivateInfo", adDataV2.installedActivateInfo);
        C11126t.m23678a(jSONObject, "videoImageTKInfo", adDataV2.videoImageTKInfo);
        return jSONObject;
    }
}
