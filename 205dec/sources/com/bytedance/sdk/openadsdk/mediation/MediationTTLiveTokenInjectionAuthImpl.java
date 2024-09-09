package com.bytedance.sdk.openadsdk.mediation;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationTTLiveTokenInjectionAuthImpl implements Bridge, ITTLiveTokenInjectionAuth {

    /* renamed from: c  reason: collision with root package name */
    private ITTLiveTokenInjectionAuth f35989c;

    public MediationTTLiveTokenInjectionAuthImpl(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f35989c = iTTLiveTokenInjectionAuth;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        ValueSet valueSet2;
        if (i4 == 8518) {
            return (T) Boolean.valueOf(isLogin());
        }
        if (i4 != 8519) {
            if (i4 != 8525 || (valueSet2 = (ValueSet) valueSet.objectValue(8526, ValueSet.class)) == null) {
                return null;
            }
            onTokenInvalid(new TTLiveToken(valueSet2.stringValue(8520), valueSet2.stringValue(8521), valueSet2.stringValue(8522), valueSet2.longValue(8523), valueSet2.stringValue(8524)), new MediationTTLiveAuthCallBackImpl((Bridge) valueSet2.objectValue(8319, Bridge.class)), (Activity) valueSet2.objectValue(20033, Activity.class), (Map) valueSet2.objectValue(8075, Map.class));
            return null;
        }
        TTLiveToken tokenInfo = getTokenInfo();
        if (tokenInfo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8520, tokenInfo.name);
            create.add(8521, tokenInfo.accessToken);
            create.add(8522, tokenInfo.openId);
            create.add(8523, tokenInfo.expireAt);
            create.add(8524, tokenInfo.refreshToken);
            return (T) create.build();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
    public TTLiveToken getTokenInfo() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f35989c;
        if (iTTLiveTokenInjectionAuth != null) {
            return iTTLiveTokenInjectionAuth.getTokenInfo();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
    public boolean isLogin() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f35989c;
        if (iTTLiveTokenInjectionAuth != null) {
            return iTTLiveTokenInjectionAuth.isLogin();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
    public void onTokenInvalid(TTLiveToken tTLiveToken, TTLiveAuthCallback tTLiveAuthCallback, Activity activity, Map<String, String> map) {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f35989c;
        if (iTTLiveTokenInjectionAuth != null) {
            iTTLiveTokenInjectionAuth.onTokenInvalid(tTLiveToken, tTLiveAuthCallback, activity, map);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
