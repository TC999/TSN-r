package com.bytedance.msdk.adapter.xv.c.sr;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends com.bytedance.msdk.api.sr.c.r.w {
    public sr(Bridge bridge) {
        ValueSet values;
        if (bridge == null || (values = bridge.values()) == null) {
            return;
        }
        w(values.stringValue(8505));
        xv(values.stringValue(8506));
        c(values.longValue(8507));
        sr(values.stringValue(8508));
        c((Map) values.objectValue(8509, Map.class));
        ux(values.stringValue(8510));
        f(values.stringValue(8511));
        w((Map) values.objectValue(8512, Map.class));
        c(values.stringValue(8551));
    }
}
