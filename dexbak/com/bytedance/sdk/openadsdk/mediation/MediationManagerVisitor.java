package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.C6482h;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p173ok.C6488a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationManagerVisitor {

    /* renamed from: a */
    private static volatile Bridge f22619a;

    /* renamed from: ok */
    private static volatile MediationManagerVisitor f22620ok;

    /* renamed from: bl */
    private C6488a f22621bl;

    private MediationManagerVisitor() {
    }

    public static MediationManagerVisitor getInstance() {
        if (f22620ok == null) {
            synchronized (MediationManagerVisitor.class) {
                if (f22620ok == null) {
                    f22620ok = new MediationManagerVisitor();
                }
            }
        }
        return f22620ok;
    }

    public synchronized IMediationManager getMediationManager() {
        if (f22619a == null) {
            Bundle bundle = new Bundle();
            bundle.putString("mediation_manager", "mediation_manager");
            TTAdManager adManager = TTAdSdk.getAdManager();
            if (adManager != null) {
                f22619a = (Bridge) adManager.getExtra(null, bundle);
            }
        }
        if (f22619a != null) {
            if (this.f22621bl == null) {
                this.f22621bl = new C6482h(f22619a);
            }
            return this.f22621bl;
        }
        return null;
    }
}
