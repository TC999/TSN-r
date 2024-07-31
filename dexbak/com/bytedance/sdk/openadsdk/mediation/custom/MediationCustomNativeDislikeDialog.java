package com.bytedance.sdk.openadsdk.mediation.custom;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationAdDislike;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface MediationCustomNativeDislikeDialog {
    void dislikeClick(String str, Map<String, Object> map);

    MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map);
}
