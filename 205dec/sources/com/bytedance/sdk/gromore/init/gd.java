package com.bytedance.sdk.gromore.init;

import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private Bridge f31258c;

    /* renamed from: w  reason: collision with root package name */
    private k f31259w;

    public gd(Bridge bridge) {
        this.f31258c = bridge;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 6) {
            Bundle bundle = valueSet != null ? (Bundle) valueSet.objectValue(10, Bundle.class) : null;
            Class cls2 = valueSet != null ? (Class) valueSet.objectValue(9, Class.class) : null;
            if (bundle != null && TextUtils.equals(bundle.getString("mediation_manager"), "mediation_manager")) {
                if (this.f31259w == null) {
                    this.f31259w = new k();
                }
                return (T) this.f31259w;
            } else if (cls2 == ITTProvider.class) {
                Bridge bridge = this.f31258c;
                if (bridge != null) {
                    Object call = bridge.call(i4, valueSet, cls);
                    if (call instanceof ITTProvider) {
                        return (T) new bk((ITTProvider) call);
                    }
                }
                return null;
            } else {
                Bridge bridge2 = this.f31258c;
                if (bridge2 != null) {
                    return (T) bridge2.call(i4, valueSet, cls);
                }
            }
        } else {
            Bridge bridge3 = this.f31258c;
            if (bridge3 != null) {
                return (T) bridge3.call(i4, valueSet, cls);
            }
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        Bridge bridge = this.f31258c;
        if (bridge != null) {
            return bridge.values();
        }
        return null;
    }
}
