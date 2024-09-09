package xyz.adscope.amps.ad.reward;

import android.content.Context;
import java.util.Map;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSRewardVideoOpenApiManager extends AMPSBaseOpenApiManager implements AMPSRewardVideoAdAdapterListener {
    private AMPSRewardVideoLoadEventListener ampsRewardVideoLoadEventListener;

    public AMPSRewardVideoOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSRewardVideoLoadEventListener aMPSRewardVideoLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSRewardVideoLoadEventListener);
        this.ampsRewardVideoLoadEventListener = aMPSRewardVideoLoadEventListener;
    }

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdInteractionListener
    public void onRewardArrived(boolean z3, int i4, Map<String, Object> map) {
        AMPSRewardVideoLoadEventListener aMPSRewardVideoLoadEventListener = this.ampsRewardVideoLoadEventListener;
        if (aMPSRewardVideoLoadEventListener != null) {
            aMPSRewardVideoLoadEventListener.onAmpsAdRewardArrived(z3, i4, map);
        }
    }

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener
    public void onRewardVideoCached(AMPSBaseAdapter aMPSBaseAdapter) {
    }

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdInteractionListener
    public void onVideoComplete() {
        AMPSRewardVideoLoadEventListener aMPSRewardVideoLoadEventListener = this.ampsRewardVideoLoadEventListener;
        if (aMPSRewardVideoLoadEventListener != null) {
            aMPSRewardVideoLoadEventListener.onAmpsAdVideoComplete();
        }
    }

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdInteractionListener
    public void onVideoError() {
        AMPSRewardVideoLoadEventListener aMPSRewardVideoLoadEventListener = this.ampsRewardVideoLoadEventListener;
        if (aMPSRewardVideoLoadEventListener != null) {
            aMPSRewardVideoLoadEventListener.onAmpsAdVideoError();
        }
    }

    public void refreshLoadEventListener(AMPSRewardVideoLoadEventListener aMPSRewardVideoLoadEventListener) {
        this.ampsRewardVideoLoadEventListener = aMPSRewardVideoLoadEventListener;
        refreshListener(aMPSRewardVideoLoadEventListener);
    }
}
