package com.bytedance.msdk.api.base;

import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import com.bytedance.msdk.api.AdLoadInfo;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class TTLoadBase {
    public abstract List<AdLoadInfo> getAdLoadInfoList();

    public abstract int getAdNetworkPlatformId();

    public abstract String getAdNetworkRitId();

    public abstract String getPreEcpm();

    public boolean hasPlatFormPermission() {
        return InternalContainer.m59943f().m59734m();
    }
}
