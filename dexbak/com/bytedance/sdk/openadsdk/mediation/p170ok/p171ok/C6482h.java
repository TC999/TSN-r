package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import android.app.Activity;
import android.content.Context;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.bytedance.sdk.openadsdk.mediation.init.p164ok.p165ok.p166ok.C6457bl;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a.C6477bl;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a.C6479ok;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p173ok.C6488a;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p141bl.C6342a;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p141bl.C6351s;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6482h extends C6488a {

    /* renamed from: ok */
    private Bridge f22850ok;

    public C6482h(Bridge bridge) {
        super(bridge);
        this.f22850ok = bridge;
    }

    /* renamed from: ok */
    private ValueSet m36219ok(AdSlot adSlot) {
        C5930a m37916k = C5930a.m37916k(C6342a.m36536a(adSlot));
        m37916k.m37919h(8302, MediationAdClassLoader.getInstance());
        if (adSlot != null && adSlot.getMediationAdSlot() != null) {
            m37916k.m37919h(260026, new C6486n(adSlot.getMediationAdSlot()));
        }
        return m37916k.m37926a();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p173ok.C6488a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        if (this.f22850ok != null) {
            C5930a m37924c = C5930a.m37924c(3);
            m37924c.m37919h(0, context);
            m37924c.m37919h(1, m36219ok(adSlot));
            m37924c.m37919h(2, new C6479ok(iMediationDrawAdTokenCallback));
            m37924c.m37919h(3, MediationAdClassLoader.getInstance());
            this.f22850ok.call(270022, m37924c.m37926a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p173ok.C6488a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        if (this.f22850ok != null) {
            C5930a m37924c = C5930a.m37924c(3);
            m37924c.m37919h(0, context);
            m37924c.m37919h(1, m36219ok(adSlot));
            m37924c.m37919h(2, new C6477bl(iMediationNativeAdTokenCallback));
            m37924c.m37919h(3, MediationAdClassLoader.getInstance());
            this.f22850ok.call(270021, m37924c.m37926a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p173ok.C6488a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i, int i2) {
        if (this.f22850ok != null) {
            C5930a m37924c = C5930a.m37924c(4);
            m37924c.m37919h(0, activity);
            if (list != null) {
                LinkedList linkedList = new LinkedList();
                for (IMediationPreloadRequestInfo iMediationPreloadRequestInfo : list) {
                    linkedList.add(new C6491p(iMediationPreloadRequestInfo));
                }
                m37924c.m37919h(1, linkedList);
            }
            m37924c.m37921f(2, i);
            m37924c.m37921f(3, i2);
            m37924c.m37919h(4, MediationAdClassLoader.getInstance());
            this.f22850ok.call(270013, m37924c.m37926a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p173ok.C6488a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        if (this.f22850ok != null) {
            C5930a m37924c = C5930a.m37924c(1);
            m37924c.m37919h(0, C6457bl.m36236ok(mediationConfigUserInfoForSegment));
            this.f22850ok.call(270014, m37924c.m37926a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p173ok.C6488a, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        if (this.f22850ok != null) {
            C5930a m37924c = C5930a.m37924c(1);
            m37924c.m37919h(0, C6351s.m36527ok(tTCustomController));
            this.f22850ok.call(270016, m37924c.m37926a(), Void.class);
        }
    }
}
