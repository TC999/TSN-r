package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class MediationCustomNativeLoader extends MediationCustomAdBaseLoader {
    public final void callLoadSuccess(List<? extends MediationCustomNativeAd> list) {
        if (this.mGmAdLoader != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8303, list);
            this.mGmAdLoader.call(8107, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public final boolean isExpressRender() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return ((Boolean) bridge.call(8222, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public final boolean isNativeAd() {
        Bridge bridge = this.mGmAdLoader;
        if (bridge != null) {
            return ((Boolean) bridge.call(8223, null, Boolean.class)).booleanValue();
        }
        return false;
    }
}
