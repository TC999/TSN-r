package com.qq.e.comm.pi;

import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.listeners.ADRewardListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface IReward {
    void setRewardListener(ADRewardListener aDRewardListener);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
