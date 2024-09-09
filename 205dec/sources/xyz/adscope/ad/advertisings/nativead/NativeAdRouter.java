package xyz.adscope.ad.advertisings.nativead;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.advertisings.AdResponseManager;
import xyz.adscope.ad.advertisings.BaseAdvertisingRouter;
import xyz.adscope.ad.advertisings.base.IBaseAdListener;
import xyz.adscope.ad.advertisings.nativead.listener.INativeAdListener;
import xyz.adscope.ad.advertisings.nativead.listener.INativeAdView;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.AdResponseModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class NativeAdRouter extends BaseAdvertisingRouter {
    private Context context;

    public NativeAdRouter(Context context) {
        super(context);
        this.context = context;
    }

    private AdScopeCycleModel cloneAdScopeCycleModel(AdScopeCycleModel adScopeCycleModel, Map.Entry<String, BidModel> entry) {
        AdScopeCycleModel adScopeCycleModel2 = new AdScopeCycleModel();
        adScopeCycleModel2.setAdResponseModel(adScopeCycleModel.getAdResponseModel());
        adScopeCycleModel2.setSpaceId(adScopeCycleModel.getSpaceId());
        adScopeCycleModel2.setSessionId(adScopeCycleModel.getSessionId());
        adScopeCycleModel2.setTimeoutInterval(adScopeCycleModel.getTimeoutInterval());
        adScopeCycleModel2.setAdCount(adScopeCycleModel.getAdCount());
        adScopeCycleModel2.setBidToken(adScopeCycleModel.getBidToken());
        adScopeCycleModel2.setNativeAdViewHeight(adScopeCycleModel.getNativeAdViewHeight());
        adScopeCycleModel2.setNativeAdViewWidth(adScopeCycleModel.getNativeAdViewWidth());
        adScopeCycleModel2.setApiKey(adScopeCycleModel.getApiKey());
        adScopeCycleModel2.setSpaceType(adScopeCycleModel.getSpaceType());
        adScopeCycleModel2.setDspId(AdResponseManager.getDSPId(entry.getKey()));
        adScopeCycleModel2.setPrice(entry.getValue().getPrice() + "");
        adScopeCycleModel2.setRenderPlanId(AdResponseManager.getRenderPlanId(entry.getValue()));
        adScopeCycleModel2.setInteractPlanId(AdResponseManager.getInteractPlanId(entry.getValue()));
        adScopeCycleModel2.setOrderId(AdResponseManager.getOrderId(entry.getValue()));
        adScopeCycleModel2.setCreateId(AdResponseManager.getCreateId(entry.getValue()));
        adScopeCycleModel2.setMaterialId(AdResponseManager.getMaterialId(entry.getValue()));
        adScopeCycleModel2.setMaterialMd5Value(AdResponseManager.getMaterialMd5Value(entry.getValue()));
        adScopeCycleModel2.setComplainContent(adScopeCycleModel.getComplainContent());
        adScopeCycleModel2.setTestAd(adScopeCycleModel.getTestAd());
        adScopeCycleModel2.setCountryCN(adScopeCycleModel.getCountryCN());
        adScopeCycleModel2.setIsWin(adScopeCycleModel.getIsWin());
        adScopeCycleModel2.setCurrency(adScopeCycleModel.getCurrency());
        adScopeCycleModel2.setWinPrice(adScopeCycleModel.getWinPrice());
        return adScopeCycleModel2;
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void adnTrackClick() {
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void adnTrackDidShow() {
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void adnTrackExposured() {
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionExecute
    public void customClick() {
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionExecute
    public void customClose() {
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionExecute
    public void customDislike() {
    }

    @Override // xyz.adscope.ad.advertisings.BaseAdvertisingRouter
    public List<INativeAdView> getINativeAdView(AdResponseModel adResponseModel, AdScopeCycleModel adScopeCycleModel) {
        ArrayList arrayList = new ArrayList();
        List<Map<String, BidModel>> bidModelListByResponse = AdResponseManager.getBidModelListByResponse(adResponseModel);
        if (bidModelListByResponse == null || bidModelListByResponse.size() < 1) {
            return null;
        }
        for (Map<String, BidModel> map : bidModelListByResponse) {
            for (Map.Entry<String, BidModel> entry : map.entrySet()) {
                RenderView renderView = new RenderView();
                AdScopeCycleModel cloneAdScopeCycleModel = cloneAdScopeCycleModel(adScopeCycleModel, entry);
                NativeAdView nativeAdView = new NativeAdView(this.context, renderView);
                nativeAdView.setAdScopeCycleModel(cloneAdScopeCycleModel);
                nativeAdView.setBidModel(entry.getValue());
                arrayList.add(nativeAdView);
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.ad.advertisings.BaseAdvertisingRouter
    public void loadAdResult() {
        IBaseAdListener iBaseAdListener;
        AdResponseModel adResponseModel = this.adResponseModel;
        if (adResponseModel == null || (iBaseAdListener = this.iBaseLoadAdListener) == null || !(iBaseAdListener instanceof INativeAdListener)) {
            return;
        }
        ((INativeAdListener) iBaseAdListener).onAdLoad(getINativeAdView(adResponseModel, this.adScopeCycleModel));
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void saveEventCodeClick() {
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void saveEventCodeExposured() {
    }

    @Override // xyz.adscope.ad.advertisings.inter.IAdvertising
    public void showAdInRootViewController() {
    }
}
