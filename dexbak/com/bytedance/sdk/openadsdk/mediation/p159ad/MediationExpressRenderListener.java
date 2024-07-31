package com.bytedance.sdk.openadsdk.mediation.p159ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface MediationExpressRenderListener extends TTNativeAd.ExpressRenderListener {
    void onAdClick();

    void onAdShow();

    void onRenderFail(View view, String str, int i);
}
