package xyz.adscope.amps.init.inter;

import xyz.adscope.amps.common.AMPSError;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IAMPSInitCallback {
    void failCallback(AMPSError aMPSError);

    void successCallback();
}
