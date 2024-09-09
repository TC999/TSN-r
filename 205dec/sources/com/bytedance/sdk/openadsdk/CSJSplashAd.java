package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface CSJSplashAd extends TTClientBidding {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface SplashAdListener {
        void onSplashAdClick(CSJSplashAd cSJSplashAd);

        void onSplashAdClose(CSJSplashAd cSJSplashAd, int i4);

        void onSplashAdShow(CSJSplashAd cSJSplashAd);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface SplashCardListener {
        void onSplashCardClick();

        void onSplashCardClose();

        void onSplashCardReadyToShow(CSJSplashAd cSJSplashAd);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface SplashClickEyeListener {
        void onSplashClickEyeClick();

        void onSplashClickEyeClose();

        void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd);
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    MediationSplashManager getMediationManager();

    View getSplashCardView();

    int[] getSplashClickEyeSizeToDp();

    View getSplashClickEyeView();

    View getSplashView();

    void hideSkipButton();

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setSplashAdListener(SplashAdListener splashAdListener);

    void setSplashCardListener(SplashCardListener splashCardListener);

    void setSplashClickEyeListener(SplashClickEyeListener splashClickEyeListener);

    void showSplashCardView(ViewGroup viewGroup, Activity activity);

    void showSplashClickEyeView(ViewGroup viewGroup);

    void showSplashView(ViewGroup viewGroup);

    void startClickEye();
}
