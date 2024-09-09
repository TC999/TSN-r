package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class MediationCustomServiceConfig {

    /* renamed from: c  reason: collision with root package name */
    private String f36140c;
    private int sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f36141w;
    private int xv;

    public MediationCustomServiceConfig(String str, String str2, int i4, int i5, String str3) {
        this.f36140c = str;
        this.f36141w = str2;
        this.xv = i4;
        this.sr = i5;
        this.ux = str3;
    }

    public String getADNNetworkName() {
        return this.f36140c;
    }

    public String getADNNetworkSlotId() {
        return this.f36141w;
    }

    public int getAdStyleType() {
        return this.xv;
    }

    public String getCustomAdapterJson() {
        return this.ux;
    }

    public int getSubAdtype() {
        return this.sr;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.f36140c + "', mADNNetworkSlotId='" + this.f36141w + "', mAdStyleType=" + this.xv + ", mSubAdtype=" + this.sr + ", mCustomAdapterJson='" + this.ux + "'}";
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.f36140c = valueSet.stringValue(8003);
            this.f36141w = valueSet.stringValue(2);
            this.xv = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.sr = valueSet.intValue(8094);
            this.ux = valueSet.stringValue(8547);
        }
    }
}
