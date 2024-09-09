package xyz.adscope.amps.ad.banner;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdAdapterListener;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;
import xyz.adscope.amps.report.AMPSEventReportCode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSBannerOpenApiManager extends AMPSBaseOpenApiManager implements AMPSBannerAdAdapterListener {
    private AMPSBannerLoadEventListener ampsBannerLoadEventListener;
    private List<String> callBackResults;

    public AMPSBannerOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSBannerLoadEventListener aMPSBannerLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSBannerLoadEventListener);
        this.callBackResults = new ArrayList();
        this.ampsBannerLoadEventListener = aMPSBannerLoadEventListener;
    }

    @Override // xyz.adscope.amps.manager.AMPSBaseOpenApiManager
    public void destroy() {
        super.destroy();
        this.callBackResults.clear();
    }

    @Override // xyz.adscope.amps.manager.AMPSBaseOpenApiManager, xyz.adscope.amps.inner.AMPSBaseAdAdapterListener
    public void onAdFailed(AMPSBaseAdapter aMPSBaseAdapter, AMPSError aMPSError) {
        if (aMPSBaseAdapter == null) {
            return;
        }
        String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
        if (!this.callBackResults.contains(networkSpaceId)) {
            this.callBackResults.add(networkSpaceId);
            super.onAdFailed(aMPSBaseAdapter, aMPSError);
        } else if (isWinAdSource(aMPSBaseAdapter)) {
            uploadLog(getWinAdSourceModel(), AMPSEventReportCode.EVENT_ADSOURCE_LOAD_FAIL_CODE, aMPSError != null ? aMPSError.getCode() : "", aMPSError != null ? aMPSError.getMessage() : "", 0L);
        }
    }

    @Override // xyz.adscope.amps.manager.AMPSBaseOpenApiManager, xyz.adscope.amps.inner.AMPSBaseAdAdapterListener
    public void onAdLoaded(AMPSBaseAdapter aMPSBaseAdapter) {
        if (aMPSBaseAdapter == null) {
            return;
        }
        String networkSpaceId = aMPSBaseAdapter.getNetworkSpaceId();
        if (!this.callBackResults.contains(networkSpaceId)) {
            this.callBackResults.add(networkSpaceId);
            super.onAdLoaded(aMPSBaseAdapter);
        } else if (isWinAdSource(aMPSBaseAdapter)) {
            uploadLog(getWinAdSourceModel(), AMPSEventReportCode.EVENT_ADSOURCE_LOAD_SUCCESS_CODE, "", "", 0L);
        }
    }
}
