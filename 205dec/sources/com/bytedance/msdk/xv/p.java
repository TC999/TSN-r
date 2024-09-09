package com.bytedance.msdk.xv;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.AdLogConfig;
import com.bytedance.pangle.sdk.component.log.impl.AdLogManager;
import com.bytedance.pangle.sdk.component.log.impl.event.ad.AdLogEvent;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.bytedance.sdk.component.r.c.c;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p {

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f28492c;

    /* renamed from: w  reason: collision with root package name */
    private static volatile boolean f28493w;

    public static boolean c() {
        xv();
        return f28492c;
    }

    public static void w() {
        xv();
        if (f28492c) {
            com.bytedance.sdk.component.r.w.c.f("csj_mediation");
        } else {
            AdLogManager.flushMemoryAndDB();
        }
    }

    private static void xv() {
        if (f28493w) {
            return;
        }
        synchronized (p.class) {
            if (!f28493w) {
                boolean z3 = true;
                f28493w = true;
                if (com.bytedance.msdk.core.c.w().xv() != 1) {
                    z3 = false;
                }
                f28492c = z3;
            }
        }
    }

    public static void c(Context context) {
        xv();
        int i4 = com.bytedance.msdk.core.c.w().i();
        if (f28492c) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- ad log init new");
            com.bytedance.sdk.component.r.w.c.c(new c.C0450c().c(new k()).w(com.bytedance.sdk.component.r.w.sr.w.c.c(i4, i4, 172800000L)).w(com.bytedance.msdk.core.w.k().bk()).c(new a()).c(bk.f28469c).c("csj_mediation").c(context).c());
            com.bytedance.sdk.component.r.w.c.w("csj_mediation");
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- ad log init new end");
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--- ad log init old");
        AdLogManager.init(new AdLogConfig.Builder().uploader(new com.bytedance.msdk.xv.xv.xv()).normalPolicyConfig(PolicyConfig.create(i4, i4, 172800000L)).supportMultiProcess(com.bytedance.msdk.core.w.k().bk()).adLogDepend(new com.bytedance.msdk.xv.xv.sr()).setDBCallback(com.bytedance.msdk.xv.xv.ux.f28593c).build(), context);
        AdLogManager.start();
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- ad log init old end");
    }

    public static void c(Context context, sr srVar, JSONObject jSONObject) {
        xv();
        if (f28492c) {
            if (com.bytedance.sdk.component.r.w.c.c("csj_mediation")) {
                c(context);
            }
            ev w3 = ev.w(context, srVar, jSONObject);
            com.bytedance.msdk.f.sr.w.c((c) w3, true);
            com.bytedance.sdk.component.r.w.sr.c.c cVar = new com.bytedance.sdk.component.r.w.sr.c.c(w3.f28471c, w3);
            cVar.c((byte) 3);
            cVar.w((byte) 2);
            com.bytedance.sdk.component.r.w.c.c(cVar, "csj_mediation");
            return;
        }
        com.bytedance.msdk.xv.xv.w c4 = com.bytedance.msdk.xv.xv.w.c(context, srVar, jSONObject);
        com.bytedance.msdk.f.sr.w.c((com.bytedance.msdk.xv.xv.c) c4, true);
        AdLogEvent adLogEvent = new AdLogEvent(c4.f28591c, c4);
        adLogEvent.setAdType((byte) 3);
        adLogEvent.setPriority((byte) 2);
        AdLogManager.reportEvent(adLogEvent);
    }
}
