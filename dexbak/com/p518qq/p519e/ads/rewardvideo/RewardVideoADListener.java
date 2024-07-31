package com.p518qq.p519e.ads.rewardvideo;

import com.p518qq.p519e.comm.util.AdError;
import java.util.Map;

/* renamed from: com.qq.e.ads.rewardvideo.RewardVideoADListener */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface RewardVideoADListener {
    void onADClick();

    void onADClose();

    void onADExpose();

    void onADLoad();

    void onADShow();

    void onError(AdError adError);

    void onReward(Map<String, Object> map);

    void onVideoCached();

    void onVideoComplete();
}
