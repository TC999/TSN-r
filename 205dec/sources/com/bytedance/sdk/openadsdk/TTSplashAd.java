package com.bytedance.sdk.openadsdk;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface TTSplashAd extends TTClientBidding {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface AdInteractionListener {
        void onAdClicked(View view, int i4);

        void onAdShow(View view, int i4);

        void onAdSkip();

        void onAdTimeOver();
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    MediationSplashManager getMediationManager();

    int[] getSplashClickEyeSizeToDp();

    View getSplashView();

    void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setNotAllowSdkCountdown();

    void setSplashCardListener(ISplashCardListener iSplashCardListener);

    void setSplashClickEyeListener(ISplashClickEyeListener iSplashClickEyeListener);

    void setSplashInteractionListener(AdInteractionListener adInteractionListener);

    void splashClickEyeAnimationFinish();

    void startClickEye();

    void startClickEye(boolean z3);
}
