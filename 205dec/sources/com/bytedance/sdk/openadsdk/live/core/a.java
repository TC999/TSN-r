package com.bytedance.sdk.openadsdk.live.core;

import android.app.Activity;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import com.bytedance.android.livehostapi.platform.TokenInfo;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements IHostTokenInjectionAuth {
    private ITTLiveTokenInjectionAuth ok;

    public a(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.ok = iTTLiveTokenInjectionAuth;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public TokenInfo getTokenInfo() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.ok;
        if (iTTLiveTokenInjectionAuth == null) {
            return null;
        }
        TTLiveToken tokenInfo = iTTLiveTokenInjectionAuth.getTokenInfo();
        if (tokenInfo == null) {
            return new TokenInfo("", "", "", 0L);
        }
        return new TokenInfo(tokenInfo.name, tokenInfo.openId, tokenInfo.accessToken, tokenInfo.expireAt);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public boolean isLogin() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.ok;
        return iTTLiveTokenInjectionAuth != null && iTTLiveTokenInjectionAuth.isLogin();
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public void onTokenInvalid(TokenInfo tokenInfo, final TokenRefreshCallback tokenRefreshCallback, Activity activity, Map<String, String> map) {
        if (this.ok == null) {
            return;
        }
        this.ok.onTokenInvalid(tokenInfo == null ? null : new TTLiveToken("Venv Test", tokenInfo.getAccessToken(), tokenInfo.getOpenId(), tokenInfo.getExpireAt(), tokenInfo.getName()), new TTLiveAuthCallback() { // from class: com.bytedance.sdk.openadsdk.live.core.a.1
            @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
            public void onAuth(TTLiveToken tTLiveToken) {
                tokenRefreshCallback.onSuccess(new TokenInfo(tTLiveToken.name, tTLiveToken.openId, tTLiveToken.accessToken, tTLiveToken.expireAt));
            }

            @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
            public void onFailed(Throwable th) {
                tokenRefreshCallback.onFailed(th);
            }
        }, activity, map);
    }
}
