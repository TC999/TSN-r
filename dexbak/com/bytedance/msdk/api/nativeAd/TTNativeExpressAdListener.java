package com.bytedance.msdk.api.nativeAd;

import android.view.View;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TTNativeExpressAdListener extends TTNativeAdListener {
    void onRenderFail(View view, String str, int i);

    void onRenderSuccess(float f, float f2);
}
