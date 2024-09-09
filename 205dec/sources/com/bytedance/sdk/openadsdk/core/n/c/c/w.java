package com.bytedance.sdk.openadsdk.core.n.c.c;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements EventListener {
    public void c() {
    }

    public void c(Bridge bridge) {
    }

    public void c(Bridge bridge, int i4) {
    }

    public void c(Bridge bridge, Bridge bridge2) {
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i4, Result result) {
        switch (i4) {
            case 223600:
                c();
                return null;
            case 223601:
                if (result == null || result.values() == null) {
                    return null;
                }
                ValueSet values = result.values();
                c((Bridge) values.objectValue(223201, Bridge.class), (Bridge) values.objectValue(223203, Bridge.class));
                return null;
            case 223602:
                if (result == null || result.values() == null) {
                    return null;
                }
                ValueSet values2 = result.values();
                c((Bridge) values2.objectValue(223607, Bridge.class), ((Integer) values2.objectValue(223608, Integer.class)).intValue());
                return null;
            case 223603:
                if (result == null || result.values() == null) {
                    return null;
                }
                ValueSet values3 = result.values();
                w((Bridge) values3.objectValue(223607, Bridge.class), ((Integer) values3.objectValue(223608, Integer.class)).intValue());
                return null;
            case 223604:
                if (result == null || result.values() == null) {
                    return null;
                }
                c((Bridge) result.values().objectValue(223607, Bridge.class));
                return null;
            case 223605:
                if (result == null || result.values() == null) {
                    return null;
                }
                w((Bridge) result.values().objectValue(223607, Bridge.class));
                return null;
            case 223606:
                if (result == null || result.values() == null) {
                    return null;
                }
                xv((Bridge) result.values().objectValue(223607, Bridge.class));
                return null;
            default:
                return null;
        }
    }

    public void w(Bridge bridge) {
    }

    public void w(Bridge bridge, int i4) {
    }

    public void xv(Bridge bridge) {
    }
}
