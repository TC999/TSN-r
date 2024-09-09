package com.bytedance.sdk.openadsdk.core.eq;

import android.content.Intent;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk {

    /* renamed from: c  reason: collision with root package name */
    private static volatile bk f33198c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.component.f.c f33199w;

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.f.c w() {
        if (this.f33199w == null) {
            this.f33199w = ba.c("hide_recent_activity_recorder");
        }
        return this.f33199w;
    }

    public static bk c() {
        if (f33198c == null) {
            synchronized (bk.class) {
                if (f33198c == null) {
                    f33198c = new bk();
                }
            }
        }
        return f33198c;
    }

    public void c(Intent intent) {
        final boolean z3 = (intent.getFlags() & 8388608) == 8388608;
        com.bytedance.sdk.component.utils.ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.bk.1
            @Override // java.lang.Runnable
            public void run() {
                int i4 = 0;
                int w3 = bk.this.w().w("all_activity_count", 0) + 1;
                if (z3) {
                    int w4 = bk.this.w().w("hide_activity_count", 0) + 1;
                    if (w4 >= 10) {
                        bk.this.c(w3);
                        w3 = 0;
                    } else {
                        i4 = w4;
                    }
                    bk.this.w().c("hide_activity_count", i4);
                }
                bk.this.w().c("all_activity_count", w3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i4) {
        try {
            com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.eq.bk.2
                @Override // com.bytedance.sdk.openadsdk.p.c.c
                public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ac", i4);
                    return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("hide_activity_record").w(jSONObject.toString());
                }
            }, "hide_activity_record");
        } catch (Throwable unused) {
        }
    }
}
