package com.bytedance.sdk.openadsdk.core.n.c.c;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements EventListener {
    public void c(Bridge bridge, Bridge bridge2, Bridge bridge3) {
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i4, Result result) {
        if (i4 != 223200 || result == null || result.values() == null) {
            return null;
        }
        ValueSet values = result.values();
        c((Bridge) values.objectValue(223201, Bridge.class), (Bridge) values.objectValue(223202, Bridge.class), (Bridge) values.objectValue(223203, Bridge.class));
        return null;
    }
}
