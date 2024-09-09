package xyz.adscope.ad.advertisings.inter;

import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.AdResponseModel;
import xyz.adscope.ad.tool.request.inter.IHttpResponseCallback;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IAdvertising<T> {
    boolean checkAdvertisingData();

    void destroyAd();

    void httpRequestAds(IHttpResponseCallback iHttpResponseCallback);

    void needUpdateConfigure();

    boolean renderAd(AdResponseModel adResponseModel);

    void requestAd();

    boolean requestMonitoringControl(AdScopeCycleModel adScopeCycleModel);

    void showAdInRootViewController();
}
