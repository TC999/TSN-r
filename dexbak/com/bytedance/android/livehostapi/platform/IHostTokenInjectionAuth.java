package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface IHostTokenInjectionAuth {
    TokenInfo getTokenInfo();

    boolean isLogin();

    void onTokenInvalid(TokenInfo tokenInfo, TokenRefreshCallback tokenRefreshCallback, Activity activity, Map<String, String> map);
}
