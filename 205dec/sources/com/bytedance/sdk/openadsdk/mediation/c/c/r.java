package com.bytedance.sdk.openadsdk.mediation.c.c;

import android.app.Activity;
import android.content.Context;
import com.bykv.c.c.c.c.b;
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

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class r extends com.bytedance.sdk.openadsdk.mediation.c.c.c.w {

    /* renamed from: c  reason: collision with root package name */
    private Bridge f36107c;

    public r(Bridge bridge) {
        super(bridge);
        this.f36107c = bridge;
    }

    private ValueSet c(AdSlot adSlot) {
        b k4 = b.k(com.bytedance.sdk.openadsdk.ys.c.xv.w.w(adSlot));
        k4.h(8302, MediationAdClassLoader.getInstance());
        if (adSlot != null && adSlot.getMediationAdSlot() != null) {
            k4.h(8260028, new ux(adSlot.getMediationAdSlot()));
        }
        return k4.l();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.c.c.w, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        if (this.f36107c != null) {
            b b4 = b.b(3);
            b4.h(0, context);
            b4.h(1, c(adSlot));
            b4.h(2, new com.bytedance.sdk.openadsdk.mediation.c.c.w.c(iMediationDrawAdTokenCallback));
            b4.h(3, MediationAdClassLoader.getInstance());
            this.f36107c.call(270022, b4.l(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.c.c.w, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        if (this.f36107c != null) {
            b b4 = b.b(3);
            b4.h(0, context);
            b4.h(1, c(adSlot));
            b4.h(2, new com.bytedance.sdk.openadsdk.mediation.c.c.w.xv(iMediationNativeAdTokenCallback));
            b4.h(3, MediationAdClassLoader.getInstance());
            this.f36107c.call(270021, b4.l(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.c.c.w, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i4, int i5) {
        if (this.f36107c != null) {
            b b4 = b.b(4);
            b4.h(0, activity);
            if (list != null) {
                LinkedList linkedList = new LinkedList();
                for (IMediationPreloadRequestInfo iMediationPreloadRequestInfo : list) {
                    linkedList.add(new ev(iMediationPreloadRequestInfo));
                }
                b4.h(1, linkedList);
            }
            b4.e(2, i4);
            b4.e(3, i5);
            b4.h(4, MediationAdClassLoader.getInstance());
            this.f36107c.call(270013, b4.l(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.c.c.w, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        if (this.f36107c != null) {
            b b4 = b.b(1);
            b4.h(0, com.bytedance.sdk.openadsdk.mediation.init.c.c.c.xv.c(mediationConfigUserInfoForSegment));
            this.f36107c.call(270014, b4.l(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.c.c.w, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        if (this.f36107c != null) {
            b b4 = b.b(1);
            b4.h(0, com.bytedance.sdk.openadsdk.ys.c.xv.sr.c(tTCustomController));
            this.f36107c.call(270016, b4.l(), Void.class);
        }
    }
}
