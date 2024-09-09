package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class h extends com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a {
    private Bridge ok;

    public h(Bridge bridge) {
        super(bridge);
        this.ok = bridge;
    }

    private ValueSet ok(AdSlot adSlot) {
        com.bykv.ok.ok.ok.ok.a k4 = com.bykv.ok.ok.ok.ok.a.k(com.bytedance.sdk.openadsdk.bl.ok.bl.a.a(adSlot));
        k4.h(8302, MediationAdClassLoader.getInstance());
        if (adSlot != null && adSlot.getMediationAdSlot() != null) {
            k4.h(260026, new n(adSlot.getMediationAdSlot()));
        }
        return k4.a();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        if (this.ok != null) {
            com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(3);
            c4.h(0, context);
            c4.h(1, ok(adSlot));
            c4.h(2, new com.bytedance.sdk.openadsdk.mediation.ok.ok.a.ok(iMediationDrawAdTokenCallback));
            c4.h(3, MediationAdClassLoader.getInstance());
            this.ok.call(270022, c4.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        if (this.ok != null) {
            com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(3);
            c4.h(0, context);
            c4.h(1, ok(adSlot));
            c4.h(2, new com.bytedance.sdk.openadsdk.mediation.ok.ok.a.bl(iMediationNativeAdTokenCallback));
            c4.h(3, MediationAdClassLoader.getInstance());
            this.ok.call(270021, c4.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i4, int i5) {
        if (this.ok != null) {
            com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(4);
            c4.h(0, activity);
            if (list != null) {
                LinkedList linkedList = new LinkedList();
                for (IMediationPreloadRequestInfo iMediationPreloadRequestInfo : list) {
                    linkedList.add(new p(iMediationPreloadRequestInfo));
                }
                c4.h(1, linkedList);
            }
            c4.f(2, i4);
            c4.f(3, i5);
            c4.h(4, MediationAdClassLoader.getInstance());
            this.ok.call(270013, c4.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        if (this.ok != null) {
            com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
            c4.h(0, com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.bl.ok(mediationConfigUserInfoForSegment));
            this.ok.call(270014, c4.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        if (this.ok != null) {
            com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
            c4.h(0, com.bytedance.sdk.openadsdk.bl.ok.bl.s.ok(tTCustomController));
            this.ok.call(270016, c4.a(), Void.class);
        }
    }
}
