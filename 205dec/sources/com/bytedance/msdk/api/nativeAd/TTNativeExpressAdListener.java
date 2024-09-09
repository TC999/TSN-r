package com.bytedance.msdk.api.nativeAd;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTNativeExpressAdListener extends TTNativeAdListener {
    void onRenderFail(View view, String str, int i4);

    void onRenderSuccess(float f4, float f5);
}
