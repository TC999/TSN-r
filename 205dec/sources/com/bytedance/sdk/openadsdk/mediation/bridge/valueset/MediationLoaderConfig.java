package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationLoaderConfig {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36094c;

    private MediationLoaderConfig(ValueSet valueSet) {
        if (valueSet != null) {
            ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8424, ValueSet.class);
            if (valueSet2 != null) {
                this.f36094c = valueSet2;
            } else {
                this.f36094c = valueSet;
            }
        }
    }

    private boolean c() {
        ValueSet valueSet = this.f36094c;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    public String getADNName() {
        return c() ? this.f36094c.stringValue(8003) : "";
    }

    public ValueSet getAdSlotValueSet() {
        if (c()) {
            return (ValueSet) this.f36094c.objectValue(8548, ValueSet.class);
        }
        return null;
    }

    public int getAdType() {
        if (c()) {
            return this.f36094c.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
        }
        return 0;
    }

    public String getClassName() {
        return c() ? this.f36094c.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public Context getContext() {
        if (c()) {
            return (Context) this.f36094c.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class);
        }
        return null;
    }

    public Bridge getGMCustomAdLoader() {
        if (c()) {
            return (Bridge) this.f36094c.objectValue(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, Bridge.class);
        }
        return null;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (c()) {
            return (ValueSet) this.f36094c.objectValue(8546, ValueSet.class);
        }
        return null;
    }
}
