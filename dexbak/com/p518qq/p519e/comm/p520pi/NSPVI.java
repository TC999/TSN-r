package com.p518qq.p519e.comm.p520pi;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.adevent.ADListener;
import com.p518qq.p519e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.NSPVI */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface NSPVI extends LADI {
    void fetchAdOnly();

    void fetchAndShowIn(ViewGroup viewGroup);

    void fetchFullScreenAdOnly();

    void fetchFullScreenAndShowIn(ViewGroup viewGroup);

    String getAdNetWorkName();

    @Deprecated
    Bitmap getZoomOutBitmap();

    void preload();

    void setAdListener(ADListener aDListener);

    void setDeveloperLogo(int i);

    void setDeveloperLogo(byte[] bArr);

    void setFetchDelay(int i);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    @Deprecated
    void setSkipView(View view);

    @Deprecated
    void setSupportZoomOut(boolean z);

    void showAd(ViewGroup viewGroup);

    void showFullScreenAd(ViewGroup viewGroup);

    @Deprecated
    void zoomOutAnimationFinish();
}
