package com.bytedance.msdk.api.nativeAd;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.TTAdDislike;
import com.bytedance.msdk.api.TTDislikeCallback;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TTNativeAd {
    void destroy();

    String getActionText();

    int getAdImageMode();

    View getAdLogoView();

    int getAdNetworkPlatformId();

    String getAdNetworkRitId();

    String getDescription();

    TTAdDislike getDislikeDialog(Activity activity);

    View getExpressView();

    String getIconUrl();

    int getImageHeight();

    List<String> getImageList();

    String getImageUrl();

    int getImageWidth();

    int getInteractionType();

    TTNativeAdAppInfo getNativeAdAppInfo();

    String getPackageName();

    String getPreEcpm();

    @Deprecated
    int getSdkNumType();

    String getSource();

    double getStarRating();

    String getTitle();

    boolean hasDislike();

    boolean isExpressAd();

    boolean isHasShown();

    boolean isServerBidding();

    void onPause();

    void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTViewBinder tTViewBinder);

    void registerView(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTViewBinder tTViewBinder);

    void render();

    void resume();

    void setDislikeCallback(Activity activity, TTDislikeCallback tTDislikeCallback);

    void setHasShown(boolean z);

    void setTTAdatperCallback(ITTAdatperCallback iTTAdatperCallback);

    void setTTNativeAdListener(TTNativeAdListener tTNativeAdListener);

    void setTTVideoListener(TTVideoListener tTVideoListener);

    void unregisterView();
}
