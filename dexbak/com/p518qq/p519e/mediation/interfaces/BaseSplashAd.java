package com.p518qq.p519e.mediation.interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.adevent.ADListener;
import com.p518qq.p519e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.mediation.interfaces.BaseSplashAd */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class BaseSplashAd implements IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;

    public BaseSplashAd(Context context, String str, String str2, String str3) {
    }

    public abstract void fetchAdOnly();

    public abstract void fetchFullScreenAdOnly();

    public int getAdapterPriority() {
        return -1;
    }

    public abstract String getECPMLevel();

    public abstract Bitmap getZoomOutBitmap();

    public abstract boolean isValid();

    @Override // com.p518qq.p519e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i, int i2, String str) {
    }

    @Override // com.p518qq.p519e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i) {
    }

    public abstract void setADListener(ADListener aDListener);

    @Override // com.p518qq.p519e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    public abstract void setDeveloperLogo(int i);

    public abstract void setDeveloperLogo(byte[] bArr);

    public abstract void setFetchDelay(int i);

    public abstract void setLoadAdParams(LoadAdParams loadAdParams);

    @Override // com.p518qq.p519e.mediation.interfaces.IBaseAd
    public void setPayload(String str) {
    }

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void setSkipView(View view);

    public abstract void setSupportZoomOut(boolean z);

    public abstract void showAd(ViewGroup viewGroup);

    public abstract void showFullScreenAd(ViewGroup viewGroup);

    public abstract void zoomOutAnimationFinish();
}
