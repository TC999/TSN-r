package xyz.adscope.amps.ad.nativead;

import android.content.Context;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;
import xyz.adscope.amps.model.config.response.AdSourceModel;
import xyz.adscope.amps.report.AMPSEventReportCode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSNativeOpenApiManager extends AMPSBaseOpenApiManager implements AMPSNativeAdAdapterListener<AMPSNativeAdExpressInfo> {
    private AMPSNativeLoadEventListener ampsNativeLoadEventListener;

    public AMPSNativeOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSNativeLoadEventListener aMPSNativeLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSNativeLoadEventListener);
        this.ampsNativeLoadEventListener = aMPSNativeLoadEventListener;
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener
    public void onRender() {
        uploadLog(getWinAdSourceModel(), AMPSEventReportCode.EVENT_ADSOURCE_NATIVE_AD_RENDER, "", "", 0L);
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener
    public void onRenderFail(AMPSError aMPSError) {
        AdSourceModel winAdSourceModel = getWinAdSourceModel();
        uploadLog(winAdSourceModel, AMPSEventReportCode.EVENT_ADSOURCE_NATIVE_AD_RENDER_FAIL, winAdSourceModel != null ? winAdSourceModel.getErrorCode() : "", winAdSourceModel != null ? winAdSourceModel.getErrorMsg() : "", 0L);
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener
    public void onRenderSuccess() {
        uploadLog(getWinAdSourceModel(), AMPSEventReportCode.EVENT_ADSOURCE_NATIVE_AD_RENDER_SUCCESS, "", "", 0L);
    }
}
