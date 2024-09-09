package xyz.adscope.amps.ad.reward.adapter;

import java.util.Map;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface AMPSRewardVideoAdInteractionListener {
    void onRewardArrived(boolean z3, int i4, Map<String, Object> map);

    void onVideoComplete();

    void onVideoError();
}
