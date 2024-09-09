package com.bytedance.sdk.openadsdk.core.ugeno.r;

import com.bytedance.sdk.openadsdk.core.q.w;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(JSONObject jSONObject);
    }

    public static void c(com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar, c cVar2) {
        if (cVar == null) {
            if (cVar2 != null) {
                cVar2.c(null);
                return;
            }
            return;
        }
        c(cVar.xv(), cVar.c(), cVar.w(), cVar2);
    }

    public static void c(String str, String str2, String str3, final c cVar) {
        JSONObject c4 = com.bytedance.sdk.openadsdk.core.ugeno.sr.c().c(str2, str3);
        if (c4 == null) {
            com.bytedance.sdk.openadsdk.core.q.w.c(str, str2, str3, new w.InterfaceC0506w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.ux.1
                @Override // com.bytedance.sdk.openadsdk.core.q.w.InterfaceC0506w
                public void c(JSONObject jSONObject) {
                    c cVar2 = c.this;
                    if (cVar2 != null) {
                        cVar2.c(jSONObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.q.w.InterfaceC0506w
                public void c() {
                    c cVar2 = c.this;
                    if (cVar2 != null) {
                        cVar2.c(null);
                    }
                }
            });
        } else if (cVar != null) {
            cVar.c(c4);
        }
    }
}
