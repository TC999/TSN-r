package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.p110vk.openvk.api.proto.ValueSet;
import p655w1.C16237a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class MediationCustomServiceConfig {

    /* renamed from: a */
    private String f22768a;

    /* renamed from: bl */
    private int f22769bl;

    /* renamed from: n */
    private String f22770n;

    /* renamed from: ok */
    private String f22771ok;

    /* renamed from: s */
    private int f22772s;

    public MediationCustomServiceConfig(String str, String str2, int i, int i2, String str3) {
        this.f22771ok = str;
        this.f22768a = str2;
        this.f22769bl = i;
        this.f22772s = i2;
        this.f22770n = str3;
    }

    public String getADNNetworkName() {
        return this.f22771ok;
    }

    public String getADNNetworkSlotId() {
        return this.f22768a;
    }

    public int getAdStyleType() {
        return this.f22769bl;
    }

    public String getCustomAdapterJson() {
        return this.f22770n;
    }

    public int getSubAdtype() {
        return this.f22772s;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.f22771ok + "', mADNNetworkSlotId='" + this.f22768a + "', mAdStyleType=" + this.f22769bl + ", mSubAdtype=" + this.f22772s + ", mCustomAdapterJson='" + this.f22770n + "'}";
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.f22771ok = valueSet.stringValue(C16237a.f47148e);
            this.f22768a = valueSet.stringValue(2);
            this.f22769bl = valueSet.intValue(8008);
            this.f22772s = valueSet.intValue(8094);
            this.f22770n = valueSet.stringValue(8547);
        }
    }
}
