package com.p518qq.p519e.mediation.interfaces;

import android.app.Activity;
import android.view.View;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.adevent.ADListener;

/* renamed from: com.qq.e.mediation.interfaces.BaseBannerAd */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class BaseBannerAd implements IBaseAd {
    public BaseBannerAd(Activity activity, String str, String str2, String str3) {
    }

    public abstract void destroy();

    public abstract View getAdView();

    public abstract boolean isValid();

    public abstract void loadAD();

    @Override // com.p518qq.p519e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i, int i2, String str) {
    }

    @Override // com.p518qq.p519e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i) {
    }

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setAdSize(int i, int i2);

    @Override // com.p518qq.p519e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    @Override // com.p518qq.p519e.mediation.interfaces.IBaseAd
    public void setPayload(String str) {
    }

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
