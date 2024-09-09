package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationResultBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class MediationInitImpl implements IMediationInit {
    public MediationInitConfig mInitConfig;

    private void c() {
        Bridge initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(AVMDLDataLoader.KeyIsLiveContainerString, this);
            initCallback.call(8266, create.build(), Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 8240) {
            initAdn((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        }
        return (T) callFunction(i4, valueSet, cls);
    }

    public <T> T callFunction(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.IMediationInit
    public final void initAdn(Context context, ValueSet valueSet) {
        this.mInitConfig = MediationInitConfig.create(valueSet);
        c();
        realInitAdn(context, this.mInitConfig);
    }

    public void notifyFail(int i4, String str) {
        Bridge initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            MediationResultBuilder create = MediationResultBuilder.create();
            create.setSuccess(false);
            create.setCode(i4);
            create.setMessage(str);
            MediationValueSetBuilder create2 = MediationValueSetBuilder.create();
            create2.add(8022, create);
            initCallback.call(8123, create2.build(), Void.class);
        }
    }

    public void notifySuccess() {
        Bridge initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(AVMDLDataLoader.KeyIsLiveContainerString, this);
            initCallback.call(8122, create.build(), Void.class);
        }
    }

    public abstract void realInitAdn(Context context, MediationInitConfig mediationInitConfig);

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public void notifyFail(String str) {
        notifyFail(80000, str);
    }
}
