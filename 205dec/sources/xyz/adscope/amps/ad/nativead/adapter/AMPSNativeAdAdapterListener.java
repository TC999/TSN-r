package xyz.adscope.amps.ad.nativead.adapter;

import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface AMPSNativeAdAdapterListener<T> extends AMPSBaseAdAdapterListener {
    void onRender();

    void onRenderFail(AMPSError aMPSError);

    void onRenderSuccess();
}
