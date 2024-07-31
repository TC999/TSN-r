package com.bytedance.sdk.openadsdk.p138bl.p139ok.p141bl;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.bl.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6346bl {
    /* renamed from: ok */
    public static final ValueSet m36532ok(LocationProvider locationProvider) {
        C5930a m37925b = C5930a.m37925b();
        if (locationProvider == null) {
            return null;
        }
        m37925b.m37923d(262001, locationProvider.getLatitude());
        m37925b.m37923d(262002, locationProvider.getLongitude());
        return m37925b.m37926a();
    }
}
