package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.commercial.j.a;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.response.model.TemplateConfig;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import com.kwad.sdk.n.k;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class ft {
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> ava;

    static {
        HashMap hashMap = new HashMap();
        ava = hashMap;
        hashMap.put(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo.class, new ga());
        ava.put(AdInfo.UnDownloadConf.class, new kh());
        ava.put(HttpDnsInfo.class, new ew());
        ava.put(AdMatrixInfo.Styles.class, new jt());
        ava.put(URLPackage.class, new kg());
        ava.put(NativeAdExtraDataImpl.class, new go());
        ava.put(AdInfo.AdSplashInfo.class, new an());
        ava.put(AdMatrixInfo.MatrixTemplate.class, new gj());
        ava.put(AdInfo.H5Config.class, new ep());
        ava.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new hk());
        ava.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new dk());
        ava.put(ImageLoaderInfo.class, new fa());
        ava.put(AdInfo.NativeAdInfo.class, new gp());
        ava.put(AdMatrixInfo.RewardVideoInteractInfo.class, new Cif());
        ava.put(AdInfo.AdBaseInfo.class, new i());
        ava.put(AdMatrixInfo.TemplateData.class, new ka());
        ava.put(TemplateConfig.class, new jy());
        ava.put(AdMatrixInfo.FullScreenInfo.class, new ee());
        ava.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new cy());
        ava.put(com.kwad.sdk.h.a.a.class, new he());
        ava.put(AdMatrixInfo.RewardWebTaskCloseInfo.class, new ih());
        ava.put(AdInfo.class, new v());
        ava.put(AdStatusInfo.class, new ao());
        ava.put(com.kwad.sdk.h.a.b.class, new hf());
        ava.put(com.kwad.sdk.core.request.model.f.class, new jw());
        ava.put(com.kwad.sdk.core.threads.d.class, new kc());
        ava.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new aw());
        ava.put(AdStyleInfo.PlayDetailInfo.class, new hn());
        ava.put(AdStyleInfo.PlayDetailInfo.DrawAdInfo.class, new dg());
        ava.put(AdGlobalConfigInfo.class, new t());
        ava.put(AdStyleInfo.class, new aq());
        ava.put(FeedSlideConf.class, new dw());
        ava.put(StatusInfo.SplashStyleControl.class, new jk());
        ava.put(com.kwad.sdk.commercial.b.b.class, new bg());
        ava.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new gf());
        ava.put(com.kwad.sdk.commercial.a.b.class, new bc());
        ava.put(com.kwad.sdk.core.request.model.g.class, new km());
        ava.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new cx());
        ava.put(AdInfo.FullScreenVideoInfo.class, new ef());
        ava.put(com.kwad.sdk.utils.b.a.class, new fx());
        ava.put(AdProductInfo.class, new ak());
        ava.put(AdTemplate.class, new ar());
        ava.put(ABParams.class, new a());
        ava.put(WebViewCommercialMsg.class, new ky());
        ava.put(AdMatrixInfo.ActionBarInfoNew.class, new d());
        ava.put(AdMatrixInfo.ActivityMiddlePageInfo.class, new g());
        ava.put(AdInfo.AdAggregateInfo.class, new h());
        ava.put(AdInfo.AdFeedInfo.class, new r());
        ava.put(AdMatrixInfo.SplashInfo.class, new jc());
        ava.put(AdMatrixInfo.BottomBannerInfo.class, new bu());
        ava.put(AdInfo.CallBackStrategyInfo.class, new bw());
        ava.put(CouponInfo.class, new cp());
        ava.put(WebCloseStatus.class, new kx());
        ava.put(AdInfo.PlayableStyleInfo.class, new ht());
        ava.put(AdStyleInfo.AdBrowseInfo.class, new k());
        ava.put(PhotoInfo.BaseInfo.class, new bo());
        ava.put(AdMatrixInfo.FeedInfo.class, new du());
        ava.put(com.kwad.sdk.commercial.d.b.class, new m());
        ava.put(k.a.C0718a.class, new jm());
        ava.put(AdInfo.AdRewardInfo.class, new al());
        ava.put(AdInfo.ComplianceInfo.class, new cf());
        ava.put(AdInfo.DownloadSafeInfo.class, new dd());
        ava.put(AdMatrixInfo.BaseMatrixTemplate.class, new bq());
        ava.put(com.kwad.sdk.core.threads.b.class, new kb());
        ava.put(StatusInfo.NativeAdStyleControl.class, new gs());
        ava.put(com.kwad.sdk.core.request.model.d.class, new gx());
        ava.put(AdInfo.SmallAppJumpInfo.class, new iv());
        ava.put(AdMatrixInfo.CycleAggregateInfo.class, new ct());
        ava.put(StatusInfo.class, new jq());
        ava.put(com.kwad.sdk.commercial.c.a.class, new bp());
        ava.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new cz());
        ava.put(StatusInfo.SplashAdInfo.class, new iz());
        ava.put(com.kwad.sdk.commercial.g.b.class, new es());
        ava.put(com.kwad.sdk.commercial.e.b.class, new o());
        ava.put(com.kwad.sdk.core.network.j.class, new gz());
        ava.put(AdInfo.AdTrackInfo.class, new as());
        ava.put(AdInfo.CutRuleInfo.class, new cs());
        ava.put(AdMatrixInfo.InstalledActivateInfo.class, new fh());
        ava.put(com.kwad.sdk.commercial.j.b.class, new au());
        ava.put(AdInfo.AdvertiserInfo.class, new ax());
        ava.put(PageInfo.class, new hh());
        ava.put(k.a.class, new lb());
        ava.put(AdStyleInfo.ExtraDisplayInfo.class, new dq());
        ava.put(AdMatrixInfo.MatrixTag.class, new gi());
        ava.put(AdInfo.MaterialSize.class, new gh());
        ava.put(AdInfo.AdConversionInfo.DeeplinkItemInfo.class, new cv());
        ava.put(AdVideoPreCacheConfig.class, new av());
        ava.put(AdMatrixInfo.AggregationCardInfo.class, new ay());
        ava.put(AdMatrixInfo.DownloadTexts.class, new df());
        ava.put(SceneImpl.class, new io());
        ava.put(TKAdLiveShopItemInfo.class, new ju());
        ava.put(AdMatrixInfo.ShakeInfo.class, new ip());
        ava.put(AdMatrixInfo.RewardVideoTaskInfo.class, new ig());
        ava.put(AdMatrixInfo.AdInteractionInfo.class, new x());
        ava.put(AdInfo.AdInsertScreenInfo.class, new w());
        ava.put(StatusInfo.NativeAdRequestInfo.class, new gq());
        ava.put(SplashExtraDataImpl.class, new jb());
        ava.put(AdStyleInfo.ExposeTagInfo.class, new Cdo());
        ava.put(com.kwad.sdk.commercial.i.b.class, new iw());
        ava.put(AdStyleInfo.PlayEndInfo.class, new hp());
        ava.put(HybridLoadMsg.class, new ex());
        ava.put(PhotoInfo.class, new hm());
        ava.put(com.kwad.sdk.core.report.j.class, new dl());
        ava.put(AdLabelImpl.class, new y());
        ava.put(AdMatrixInfo.StyleInfo.class, new js());
        ava.put(AdInfo.AdStyleConfInfo.class, new ap());
        ava.put(a.C0686a.class, new kf());
        ava.put(AdInfo.AdConversionInfo.class, new l());
        ava.put(AdInfo.UnDownloadRegionConf.class, new ki());
        ava.put(AdStyleInfo.FeedAdInfo.class, new ds());
        ava.put(WebViewLoadMsg.class, new kz());
        ava.put(AdProductInfo.SpikeInfo.class, new ix());
        ava.put(AdMatrixInfo.PreLandingPageTKInfo.class, new hv());
        ava.put(AdMatrixInfo.RotateDegreeInfo.class, new ij());
        ava.put(AdMatrixInfo.SplashEndCardTKInfo.class, new ja());
        ava.put(com.kwad.sdk.commercial.e.c.class, new p());
        ava.put(com.kwad.sdk.core.request.model.b.class, new da());
        ava.put(HttpDnsInfo.IpInfo.class, new fo());
        ava.put(PhotoInfo.VideoInfo.class, new ko());
        ava.put(AdStyleInfo.PlayDetailInfo.PatchEcInfo.class, new hl());
        ava.put(AdMatrixInfo.AdDataV2.class, new q());
        ava.put(SDKInitMsg.class, new il());
        ava.put(AdInfo.AdShowVideoH5Info.class, new am());
        ava.put(AdMatrixInfo.SplashActionBarInfo.class, new iy());
        ava.put(AdMatrixInfo.SplashSlideInfo.class, new jj());
        ava.put(AdMatrixInfo.EndCardInfo.class, new dj());
        ava.put(AdMatrixInfo.NeoVideoInfo.class, new gw());
        ava.put(AdMatrixInfo.RotateInfo.class, new ik());
        ava.put(AdInfo.NativeAdShakeInfo.class, new gr());
        ava.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new c());
        ava.put(AdMatrixInfo.InterstitialCardInfo.class, new fk());
        ava.put(AdGlobalConfigInfo.NeoScanAggregationSceneInfo.class, new gu());
        ava.put(com.kwad.sdk.commercial.f.b.class, new cw());
        ava.put(AdMatrixInfo.SplashPlayCardTKInfo.class, new jf());
        ava.put(AdMatrixInfo.MerchantLiveReservationInfo.class, new gk());
        ava.put(VideoPlayerStatus.class, new ks());
        ava.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new la());
        ava.put(AdInfo.AdPreloadInfo.class, new aj());
        ava.put(com.kwad.sdk.core.network.i.class, new gy());
        ava.put(AdInfo.AdMaterialInfo.class, new ag());
        ava.put(AdMatrixInfo.class, new ah());
        Dz();
    }

    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> DA() {
        return ava;
    }

    @ForInvoker(methodId = "registerHolder")
    private static void Dz() {
        cg.Dz();
        ch.Dz();
        ci.Dz();
        cj.Dz();
        ck.Dz();
        cl.Dz();
        cm.Dz();
        cn.Dz();
        dy.Dz();
        dz.Dz();
        ea.Dz();
        eb.Dz();
        ec.Dz();
        ed.Dz();
    }

    public static com.kwad.sdk.core.d getHolder(Class<? extends com.kwad.sdk.core.response.a.a> cls) {
        return ava.get(cls);
    }
}
