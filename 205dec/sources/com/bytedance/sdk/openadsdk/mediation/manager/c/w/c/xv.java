package com.bytedance.sdk.openadsdk.mediation.manager.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36233c;

    private ValueSet c() {
        return b.a().l();
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 270001:
                return (T) Boolean.class.cast(Boolean.valueOf(isReady()));
            case 270002:
                return (T) getAdLoadInfo();
            case 270003:
                return (T) getMultiBiddingEcpm();
            case 270004:
                return (T) getBestEcpm();
            case 270005:
                return (T) getCacheList();
            case 270006:
                return (T) getShowEcpm();
            default:
                c(i4, valueSet, cls);
                return null;
        }
    }

    public abstract List<w> getAdLoadInfo();

    public abstract c getBestEcpm();

    public abstract List<c> getCacheList();

    public abstract List<c> getMultiBiddingEcpm();

    public abstract c getShowEcpm();

    public abstract boolean isReady();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36233c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet c4 = c();
        this.f36233c = c4;
        return c4;
    }
}
