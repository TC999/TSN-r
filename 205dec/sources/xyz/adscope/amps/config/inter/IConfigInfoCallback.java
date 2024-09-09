package xyz.adscope.amps.config.inter;

import xyz.adscope.amps.common.AMPSError;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IConfigInfoCallback {
    void failCallBack(AMPSError aMPSError);

    void successCallBack();
}
