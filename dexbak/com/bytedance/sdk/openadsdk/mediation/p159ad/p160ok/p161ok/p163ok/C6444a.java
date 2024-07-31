package com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p163ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a.C6437a;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.ok.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6444a implements MediationAdDislike {

    /* renamed from: ok */
    private final Bridge f22704ok;

    public C6444a(Bridge bridge) {
        this.f22704ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, new C6437a(iMediationDislikeCallback));
        this.f22704ok.call(270033, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationAdDislike
    public void showDislikeDialog() {
        this.f22704ok.call(270032, C5930a.m37924c(0).m37926a(), Void.class);
    }
}
