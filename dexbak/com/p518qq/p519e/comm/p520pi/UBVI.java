package com.p518qq.p519e.comm.p520pi;

import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.UBVI */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface UBVI extends LADI {
    void destroy();

    void fetchAd();

    String getAdNetWorkName();

    void onWindowFocusChanged(boolean z);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setRefresh(int i);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
