package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationDislikeCallbackImpl implements Bridge, IMediationDislikeCallback {

    /* renamed from: c  reason: collision with root package name */
    private IMediationDislikeCallback f35980c;

    public MediationDislikeCallbackImpl(IMediationDislikeCallback iMediationDislikeCallback) {
        this.f35980c = iMediationDislikeCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8188) {
            onSelected(valueSet.intValue(8038), valueSet.stringValue(8039));
            return null;
        } else if (i4 == 8189) {
            onCancel();
            return null;
        } else if (i4 == 8190) {
            onShow();
            return null;
        } else {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onCancel() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onSelected(int i4, String str) {
        IMediationDislikeCallback iMediationDislikeCallback = this.f35980c;
        if (iMediationDislikeCallback != null) {
            iMediationDislikeCallback.onSelected(i4, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onShow() {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
