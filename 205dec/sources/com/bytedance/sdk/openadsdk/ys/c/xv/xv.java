package com.bytedance.sdk.openadsdk.ys.c.xv;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv {
    public static final ValueSet c(LocationProvider locationProvider) {
        b a4 = b.a();
        if (locationProvider == null) {
            return null;
        }
        a4.c(262001, locationProvider.getLatitude());
        a4.c(262002, locationProvider.getLongitude());
        return a4.l();
    }
}
