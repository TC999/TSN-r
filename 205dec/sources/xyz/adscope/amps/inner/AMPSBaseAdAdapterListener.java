package xyz.adscope.amps.inner;

import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSError;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface AMPSBaseAdAdapterListener<T> {
    void onAdClicked(AMPSBaseAdapter aMPSBaseAdapter);

    void onAdDismiss(AMPSBaseAdapter aMPSBaseAdapter);

    void onAdFailed(AMPSBaseAdapter aMPSBaseAdapter, AMPSError aMPSError);

    void onAdLoaded(AMPSBaseAdapter aMPSBaseAdapter);

    void onAdShow(AMPSBaseAdapter aMPSBaseAdapter);

    void onAdShowFailed(AMPSBaseAdapter aMPSBaseAdapter, AMPSError aMPSError);
}
