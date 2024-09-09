package com.bytedance.sdk.openadsdk.live;

import android.app.Activity;
import java.io.Serializable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface ITTLiveTokenInjectionAuth extends Serializable {
    TTLiveToken getTokenInfo();

    boolean isLogin();

    void onTokenInvalid(TTLiveToken tTLiveToken, TTLiveAuthCallback tTLiveAuthCallback, Activity activity, Map<String, String> map);
}
