package com.bytedance.msdk.api.base;

import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import com.bytedance.msdk.api.AdLoadInfo;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class TTLoadBase {
    public abstract List<AdLoadInfo> getAdLoadInfoList();

    public abstract int getAdNetworkPlatformId();

    public abstract String getAdNetworkRitId();

    public abstract String getPreEcpm();

    public boolean hasPlatFormPermission() {
        return a.f().m();
    }
}
