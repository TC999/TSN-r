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
  E:\TSN-r\205dec\6520572.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class fr {
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> awm;

    static {
        HashMap hashMap = new HashMap();
        awm = hashMap;
        hashMap.put(AdMatrixInfo.SplashSlideInfo.class, new ji());
        awm.put(PhotoInfo.BaseInfo.class, new bo());
        awm.put(VideoPlayerStatus.class, new kr());
        awm.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new aw());
        awm.put(AdStatusInfo.class, new ao());
        awm.put(com.kwad.sdk.g.a.b.class, new he());
        awm.put(AdMatrixInfo.RotateInfo.class, new ij());
        awm.put(NativeAdExtraDataImpl.class, new gn());
        awm.put(FeedSlideConf.class, new du());
        awm.put(com.kwad.sdk.utils.b.a.class, new fv());
        awm.put(com.kwad.sdk.g.a.a.class, new hd());
        awm.put(AdInfo.AdPreloadInfo.class, new aj());
        awm.put(AdMatrixInfo.InstalledActivateInfo.class, new ff());
        awm.put(AdInfo.AdvertiserInfo.class, new ax());
        awm.put(AdTemplate.class, new ar());
        awm.put(AdInfo.NativeAdInfo.class, new go());
        awm.put(StatusInfo.NativeAdRequestInfo.class, new gp());
        awm.put(AdStyleInfo.FeedAdInfo.class, new dq());
        awm.put(AdMatrixInfo.Styles.class, new js());
        awm.put(AdInfo.MaterialSize.class, new gg());
        awm.put(k.a.C0718a.class, new jl());
        awm.put(AdMatrixInfo.MatrixTag.class, new gh());
        awm.put(AdStyleInfo.PlayEndInfo.class, new ho());
        awm.put(AdGlobalConfigInfo.NeoScanAggregationSceneInfo.class, new gt());
        awm.put(PhotoInfo.VideoInfo.class, new kn());
        awm.put(AdMatrixInfo.RotateDegreeInfo.class, new ii());
        awm.put(AdMatrixInfo.MerchantLiveReservationInfo.class, new gj());
        awm.put(PageInfo.class, new hg());
        awm.put(AdStyleInfo.ExtraDisplayInfo.class, new Cdo());
        awm.put(HttpDnsInfo.class, new eu());
        awm.put(TKAdLiveShopItemInfo.class, new jt());
        awm.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new cy());
        awm.put(AdMatrixInfo.ActivityMiddlePageInfo.class, new g());
        awm.put(AdMatrixInfo.StyleInfo.class, new jr());
        awm.put(StatusInfo.NativeAdStyleControl.class, new gr());
        awm.put(AdInfo.AdConversionInfo.class, new l());
        awm.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new ge());
        awm.put(com.kwad.sdk.core.request.model.b.class, new da());
        awm.put(AdInfo.UnDownloadConf.class, new kg());
        awm.put(com.kwad.sdk.core.network.j.class, new gy());
        awm.put(AdInfo.AdBaseInfo.class, new i());
        awm.put(AdInfo.AdInsertScreenInfo.class, new w());
        awm.put(TemplateConfig.class, new jx());
        awm.put(k.a.class, new la());
        awm.put(AdGlobalConfigInfo.class, new t());
        awm.put(AdMatrixInfo.AdDataV2.class, new q());
        awm.put(com.kwad.sdk.core.report.j.class, new dj());
        awm.put(AdInfo.AdTrackInfo.class, new as());
        awm.put(AdMatrixInfo.NeoVideoInfo.class, new gv());
        awm.put(com.kwad.sdk.commercial.j.b.class, new au());
        awm.put(AdMatrixInfo.AggregationCardInfo.class, new ay());
        awm.put(AdMatrixInfo.FullScreenInfo.class, new ec());
        awm.put(AdInfo.CutRuleInfo.class, new cs());
        awm.put(com.kwad.sdk.commercial.f.b.class, new cw());
        awm.put(StatusInfo.class, new jp());
        awm.put(AdInfo.class, new v());
        awm.put(AdMatrixInfo.FeedInfo.class, new ds());
        awm.put(AdStyleInfo.class, new aq());
        awm.put(AdStyleInfo.PlayDetailInfo.DrawAdInfo.class, new dg());
        awm.put(SceneImpl.class, new in());
        awm.put(AdMatrixInfo.AdInteractionInfo.class, new x());
        awm.put(StatusInfo.SplashStyleControl.class, new jj());
        awm.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new kz());
        awm.put(AdInfo.UnDownloadRegionConf.class, new kh());
        awm.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new hj());
        awm.put(HybridLoadMsg.class, new ev());
        awm.put(com.kwad.sdk.core.request.model.f.class, new jv());
        awm.put(AdMatrixInfo.RewardVideoTaskInfo.class, new Cif());
        awm.put(com.kwad.sdk.commercial.g.b.class, new eq());
        awm.put(AdInfo.SmallAppJumpInfo.class, new iu());
        awm.put(AdStyleInfo.PlayDetailInfo.class, new hm());
        awm.put(com.kwad.sdk.core.threads.d.class, new kb());
        awm.put(AdProductInfo.SpikeInfo.class, new iw());
        awm.put(AdStyleInfo.PlayDetailInfo.PatchEcInfo.class, new hk());
        awm.put(URLPackage.class, new kf());
        awm.put(AdInfo.CallBackStrategyInfo.class, new bw());
        awm.put(AdMatrixInfo.RewardWebTaskCloseInfo.class, new ig());
        awm.put(AdMatrixInfo.CycleAggregateInfo.class, new ct());
        awm.put(CouponInfo.class, new cp());
        awm.put(AdInfo.AdAggregateInfo.class, new h());
        awm.put(AdMatrixInfo.SplashActionBarInfo.class, new ix());
        awm.put(AdMatrixInfo.DownloadTexts.class, new df());
        awm.put(com.kwad.sdk.commercial.e.b.class, new o());
        awm.put(com.kwad.sdk.commercial.smallApp.b.class, new iv());
        awm.put(AdMatrixInfo.RewardVideoInteractInfo.class, new ie());
        awm.put(AdInfo.AdSplashInfo.class, new an());
        awm.put(AdVideoPreCacheConfig.class, new av());
        awm.put(AdInfo.ComplianceInfo.class, new cf());
        awm.put(AdInfo.AdStyleConfInfo.class, new ap());
        awm.put(AdInfo.AdMaterialInfo.class, new ag());
        awm.put(com.kwad.sdk.commercial.d.b.class, new m());
        awm.put(StatusInfo.SplashAdInfo.class, new iy());
        awm.put(com.kwad.sdk.core.threads.b.class, new ka());
        awm.put(HttpDnsInfo.IpInfo.class, new fm());
        awm.put(AdLabelImpl.class, new y());
        awm.put(com.kwad.sdk.commercial.a.b.class, new bc());
        awm.put(AdProductInfo.class, new ak());
        awm.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new c());
        awm.put(SDKInitMsg.class, new ik());
        awm.put(AdMatrixInfo.SplashInfo.class, new jb());
        awm.put(AdMatrixInfo.BaseMatrixTemplate.class, new bq());
        awm.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new cz());
        awm.put(AdMatrixInfo.SplashEndCardTKInfo.class, new iz());
        awm.put(ImageLoaderInfo.class, new ey());
        awm.put(AdInfo.AdFeedInfo.class, new r());
        awm.put(AdMatrixInfo.SplashPlayCardTKInfo.class, new je());
        awm.put(com.kwad.sdk.commercial.e.c.class, new p());
        awm.put(AdMatrixInfo.MatrixTemplate.class, new gi());
        awm.put(AdMatrixInfo.TemplateData.class, new jz());
        awm.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new cx());
        awm.put(AdStyleInfo.AdBrowseInfo.class, new k());
        awm.put(AdInfo.AdShowVideoH5Info.class, new am());
        awm.put(AdMatrixInfo.BottomBannerInfo.class, new bu());
        awm.put(com.kwad.sdk.commercial.i.a.class, new gc());
        awm.put(com.kwad.sdk.core.network.i.class, new gx());
        awm.put(AdInfo.NativeAdShakeInfo.class, new gq());
        awm.put(WebViewLoadMsg.class, new ky());
        awm.put(AdMatrixInfo.class, new ah());
        awm.put(WebViewCommercialMsg.class, new kx());
        awm.put(ABParams.class, new a());
        awm.put(AdMatrixInfo.PreLandingPageTKInfo.class, new hu());
        awm.put(AdMatrixInfo.ActionBarInfoNew.class, new d());
        awm.put(AdStyleInfo.ExposeTagInfo.class, new dm());
        awm.put(a.C0686a.class, new ke());
        awm.put(AdMatrixInfo.ShakeInfo.class, new io());
        awm.put(AdInfo.FullScreenVideoInfo.class, new ed());
        awm.put(com.kwad.sdk.core.request.model.d.class, new gw());
        awm.put(AdMatrixInfo.EndCardInfo.class, new dh());
        awm.put(PhotoInfo.class, new hl());
        awm.put(AdInfo.H5Config.class, new en());
        awm.put(AdInfo.PlayableStyleInfo.class, new hs());
        awm.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new di());
        awm.put(AdMatrixInfo.InterstitialCardInfo.class, new fi());
        awm.put(WebCloseStatus.class, new kw());
        awm.put(com.kwad.sdk.commercial.b.b.class, new bg());
        awm.put(SplashExtraDataImpl.class, new ja());
        awm.put(AdInfo.DownloadSafeInfo.class, new dd());
        awm.put(com.kwad.sdk.core.request.model.g.class, new kl());
        awm.put(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo.class, new fy());
        awm.put(AdInfo.AdConversionInfo.DeeplinkItemInfo.class, new cv());
        awm.put(com.kwad.sdk.commercial.c.a.class, new bp());
        awm.put(AdInfo.AdRewardInfo.class, new al());
        Ej();
    }

    @ForInvoker(methodId = "registerHolder")
    private static void Ej() {
        cg.Ej();
        ch.Ej();
        ci.Ej();
        cj.Ej();
        ck.Ej();
        cl.Ej();
        cm.Ej();
        cn.Ej();
        dw.Ej();
        dx.Ej();
        dy.Ej();
        dz.Ej();
        ea.Ej();
        eb.Ej();
    }

    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> Ek() {
        return awm;
    }

    public static com.kwad.sdk.core.d getHolder(Class<? extends com.kwad.sdk.core.response.a.a> cls) {
        return awm.get(cls);
    }
}
