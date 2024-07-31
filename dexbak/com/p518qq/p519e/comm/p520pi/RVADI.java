package com.p518qq.p519e.comm.p520pi;

import android.app.Activity;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.RVADI */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface RVADI extends LADI {
    String getAdNetWorkName();

    @Deprecated
    long getExpireTimestamp();

    int getRewardAdType();

    int getVideoDuration();

    boolean hasShown();

    void loadAD();

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVolumeOn(boolean z);

    void showAD();

    void showAD(Activity activity);
}
