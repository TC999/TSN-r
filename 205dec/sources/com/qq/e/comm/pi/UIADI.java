package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface UIADI extends LADI {
    void close();

    void destroy();

    String getAdNetWorkName();

    int getAdPatternType();

    int getVideoDuration();

    void loadAd();

    void loadFullScreenAD();

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i4);

    void setMinVideoDuration(int i4);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);

    void show();

    void show(Activity activity);

    void showFullScreenAD(Activity activity);
}
