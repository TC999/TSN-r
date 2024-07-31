package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationDislikeCallback;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationDislikeCallbackImpl implements Bridge, IMediationDislikeCallback {

    /* renamed from: ok */
    private IMediationDislikeCallback f22617ok;

    public MediationDislikeCallbackImpl(IMediationDislikeCallback iMediationDislikeCallback) {
        this.f22617ok = iMediationDislikeCallback;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8188) {
            onSelected(valueSet.intValue(8038), valueSet.stringValue(8039));
            return null;
        } else if (i == 8189) {
            onCancel();
            return null;
        } else if (i == 8190) {
            onShow();
            return null;
        } else {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationDislikeCallback
    public void onCancel() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationDislikeCallback
    public void onSelected(int i, String str) {
        IMediationDislikeCallback iMediationDislikeCallback = this.f22617ok;
        if (iMediationDislikeCallback != null) {
            iMediationDislikeCallback.onSelected(i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationDislikeCallback
    public void onShow() {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
