package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationInitCLassLoader implements Bridge {
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        Class<?> cls2;
        if (i4 == 8100) {
            MediationInitConfig create = MediationInitConfig.create(valueSet);
            try {
                if (create.isCustom() && create.getCustomInitConfigValueSet() != null) {
                    cls2 = Class.forName(create.getCustomInitConfigValueSet().stringValue(8536));
                } else {
                    cls2 = Class.forName(create.getClassName());
                }
                Object newInstance = cls2.newInstance();
                if (newInstance instanceof Bridge) {
                    MediationValueSetBuilder create2 = MediationValueSetBuilder.create();
                    create2.add(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, TTAppContextHolder.getContext());
                    create2.add(8424, valueSet);
                    ((Bridge) newInstance).call(8240, create2.build(), null);
                }
            } catch (ClassNotFoundException e4) {
                e4.printStackTrace();
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
            } catch (InstantiationException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
