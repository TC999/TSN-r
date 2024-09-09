package com.bytedance.msdk.sr.w;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private final ValueSet f28432c;

    private xv(ValueSet valueSet) {
        this.f28432c = valueSet;
    }

    public static xv c(ValueSet valueSet) {
        return new xv(valueSet);
    }

    private boolean w() {
        ValueSet valueSet = this.f28432c;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public Bridge c() {
        if (w()) {
            return (Bridge) this.f28432c.objectValue(8301, Bridge.class);
        }
        return null;
    }
}
