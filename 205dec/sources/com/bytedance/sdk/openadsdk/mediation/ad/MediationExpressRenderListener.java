package com.bytedance.sdk.openadsdk.mediation.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface MediationExpressRenderListener extends TTNativeAd.ExpressRenderListener {
    void onAdClick();

    void onAdShow();

    void onRenderFail(View view, String str, int i4);
}
