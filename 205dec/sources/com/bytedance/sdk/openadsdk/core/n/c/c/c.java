package com.bytedance.sdk.openadsdk.core.n.c.c;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements EventListener {
    public void handleComplianceDialog(boolean z3) {
    }

    public void handleMarketFailedComplianceDialog() {
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i4, Result result) {
        if (i4 != 223100) {
            if (i4 != 223110) {
                return null;
            }
            handleMarketFailedComplianceDialog();
            return null;
        } else if (result == null || result.values() == null) {
            return null;
        } else {
            handleComplianceDialog(result.values().booleanValue(223101));
            return null;
        }
    }
}
