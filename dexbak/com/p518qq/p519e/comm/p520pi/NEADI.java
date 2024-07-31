package com.p518qq.p519e.comm.p520pi;

import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.NEADI */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface NEADI {
    String getAdNetWorkName();

    void loadAd(int i);

    void loadAd(int i, LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);
}
