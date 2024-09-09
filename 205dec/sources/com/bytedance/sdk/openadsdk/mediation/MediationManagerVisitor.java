package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.mediation.c.c.c.w;
import com.bytedance.sdk.openadsdk.mediation.c.c.r;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationManagerVisitor {

    /* renamed from: c  reason: collision with root package name */
    private static volatile MediationManagerVisitor f35982c;

    /* renamed from: w  reason: collision with root package name */
    private static volatile Bridge f35983w;
    private w xv;

    private MediationManagerVisitor() {
    }

    public static MediationManagerVisitor getInstance() {
        if (f35982c == null) {
            synchronized (MediationManagerVisitor.class) {
                if (f35982c == null) {
                    f35982c = new MediationManagerVisitor();
                }
            }
        }
        return f35982c;
    }

    public synchronized IMediationManager getMediationManager() {
        Bundle bundle = new Bundle();
        bundle.putString("mediation_manager", "mediation_manager");
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            f35983w = (Bridge) adManager.getExtra(null, bundle);
        }
        if (f35983w != null) {
            if (this.xv == null) {
                this.xv = new r(f35983w);
            }
            return this.xv;
        }
        return null;
    }
}
