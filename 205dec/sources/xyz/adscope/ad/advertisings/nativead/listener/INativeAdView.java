package xyz.adscope.ad.advertisings.nativead.listener;

import android.view.View;
import xyz.adscope.ad.advertisings.nativead.config.NativeViewItemType;
import xyz.adscope.ad.bidding.inter.IAdBidding;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface INativeAdView {
    View getExpressAdView();

    IAdBidding getIAdBidding();

    NativeViewItemType getItemModel();

    void render();

    void setAdScopeCycleModel(AdScopeCycleModel adScopeCycleModel);

    void setBidModel(BidModel bidModel);

    void setINativeDislikeListener(INativeDislikeListener iNativeDislikeListener);

    void setINativeExpressAdListener(INativeExpressAdListener iNativeExpressAdListener);
}
