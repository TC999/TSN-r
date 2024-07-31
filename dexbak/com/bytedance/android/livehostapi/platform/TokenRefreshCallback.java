package com.bytedance.android.livehostapi.platform;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TokenRefreshCallback {
    void onFailed(Throwable th);

    void onSuccess(TokenInfo tokenInfo);
}
