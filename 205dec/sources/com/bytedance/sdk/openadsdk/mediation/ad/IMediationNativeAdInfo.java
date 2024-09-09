package com.bytedance.sdk.openadsdk.mediation.ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface IMediationNativeAdInfo {
    String getActionText();

    int getAdImageMode();

    String getDescription();

    TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    MediationAdDislike getDislikeDialog(Activity activity);

    MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map);

    TTAdDislike getDislikeDialog2(Activity activity);

    DislikeInfo getDislikeInfo();

    String getIconUrl();

    List<String> getImageList();

    String getImageUrl();

    int getInteractionType();

    MediationNativeAdAppInfo getNativeAdAppInfo();

    String getSource();

    double getStarRating();

    String getTitle();

    boolean hasDislike();

    void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, IMediationViewBinder iMediationViewBinder);

    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);
}
