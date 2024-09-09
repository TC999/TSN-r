package xyz.adscope.amps.inner;

import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.base.AMPSBaseBiddingResult;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface AMPSAdBiddingListener {
    void onC2SBiddingFail(AMPSBaseAdapter aMPSBaseAdapter, AMPSBaseBiddingResult aMPSBaseBiddingResult);

    void onC2SBiddingSuccess(AMPSBaseAdapter aMPSBaseAdapter, AMPSBaseBiddingResult aMPSBaseBiddingResult);
}
