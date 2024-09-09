package com.bytedance.sdk.openadsdk.core.ls.w;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.ls.p;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static void c() {
        try {
            com.bytedance.sdk.openadsdk.core.ls.xv.c.xv().ux();
            com.bytedance.sdk.openadsdk.core.ls.c.c.w().ux();
            p.c(new EventListener() { // from class: com.bytedance.sdk.openadsdk.core.ls.w.c.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i4, Result result) {
                    if (i4 == 0) {
                        com.bytedance.sdk.openadsdk.core.ls.sr.c.f();
                        return null;
                    }
                    return null;
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void w() {
        if (ls.w().zb()) {
            try {
                String c4 = com.bytedance.sdk.openadsdk.core.ls.xv.c.xv().c(com.bytedance.sdk.openadsdk.core.ls.xv.c.sr());
                if (TextUtils.isEmpty(c4) || "-1".equalsIgnoreCase(c4)) {
                    ev.w(new com.bytedance.sdk.component.gd.p("") { // from class: com.bytedance.sdk.openadsdk.core.ls.w.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.openadsdk.core.ls.xv.c.xv().ux();
                        }
                    });
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
