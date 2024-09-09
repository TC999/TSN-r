package com.bytedance.sdk.openadsdk.bl.ok.bl;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl {
    public static final ValueSet ok(LocationProvider locationProvider) {
        com.bykv.ok.ok.ok.ok.a b4 = com.bykv.ok.ok.ok.ok.a.b();
        if (locationProvider == null) {
            return null;
        }
        b4.d(262001, locationProvider.getLatitude());
        b4.d(262002, locationProvider.getLongitude());
        return b4.a();
    }
}
