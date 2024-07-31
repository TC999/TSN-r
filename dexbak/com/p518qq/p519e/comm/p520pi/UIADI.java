package com.p518qq.p519e.comm.p520pi;

import android.app.Activity;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.UIADI */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface UIADI extends LADI {
    void close();

    void destroy();

    String getAdNetWorkName();

    int getAdPatternType();

    int getVideoDuration();

    void loadAd();

    void loadFullScreenAD();

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);

    void show();

    void show(Activity activity);

    void showFullScreenAD(Activity activity);
}
