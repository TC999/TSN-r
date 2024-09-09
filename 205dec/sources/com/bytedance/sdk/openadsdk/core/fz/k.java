package com.bytedance.sdk.openadsdk.core.fz;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k implements com.bytedance.sdk.openadsdk.core.fz.xv.c {

    /* renamed from: c  reason: collision with root package name */
    public static final k f33678c = new k();

    private k() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.fz.xv.c
    public void c(final com.bytedance.sdk.openadsdk.p.c.c cVar, final String str, final boolean z3) {
        com.bytedance.sdk.openadsdk.n.f.w(new com.bytedance.sdk.component.gd.p("uploadLogEvent") { // from class: com.bytedance.sdk.openadsdk.core.fz.k.1
            @Override // java.lang.Runnable
            public void run() {
                if (bk.c(str, 1.0d) || !z3) {
                    k.this.c(cVar, z3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.p.c.c cVar, boolean z3) {
        JSONObject jSONObject;
        try {
            JSONObject c4 = cVar.c().c();
            if (c4 != null) {
                String optString = c4.optString(EventMonitor.EVENT_EXTRA);
                if (TextUtils.isEmpty(optString)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(optString);
                }
                int incrementAndGet = w.f33687w.incrementAndGet();
                jSONObject.put(EventMonitor.STATS_INDEX, incrementAndGet);
                jSONObject.put(EventMonitor.KEY_SDK_SESSION_ID, w.f33686c);
                jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.k.sr().j() ? 1 : 0);
                if (!TextUtils.isEmpty(wv.gd)) {
                    jSONObject.put("wrong_stats_url", wv.gd);
                }
                c4.put(EventMonitor.EVENT_EXTRA, jSONObject.toString());
                com.bytedance.sdk.component.r.w.sr.c.c cVar2 = new com.bytedance.sdk.component.r.w.sr.c.c(UUID.randomUUID().toString(), c4);
                cVar2.xv((byte) 0);
                cVar2.w((byte) 3);
                cVar2.c((byte) 1);
                w.c(cVar2, c4.optString("type"), incrementAndGet);
            }
        } catch (Throwable unused) {
        }
    }
}
