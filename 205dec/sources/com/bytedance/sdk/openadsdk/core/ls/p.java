package com.bytedance.sdk.openadsdk.core.ls;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.yu;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p {
    public static boolean c() {
        JSONObject xu = ls.w().xu();
        return xu != null && xu.optInt("video_cache", 0) == 1;
    }

    public static boolean w() {
        JSONObject xu = ls.w().xu();
        return xu != null && xu.optInt("pre_drop", 0) == 1;
    }

    public static boolean xv() {
        return com.bytedance.sdk.openadsdk.core.xv.ux.c().ck() == 1;
    }

    public static void c(final EventListener eventListener) {
        Bridge wv = com.bytedance.sdk.openadsdk.core.k.sr().wv();
        if (ls.w().fp()) {
            ValueSet l4 = b.b(1).i(0, "com.byted.csj.ext").l();
            Boolean bool = (Boolean) wv.call(6, l4, Boolean.class);
            com.bytedance.sdk.component.utils.a.w("lqmt", "ext pl install: " + bool);
            if (bool.booleanValue()) {
                if (!((Boolean) wv.call(7, l4, Boolean.class)).booleanValue()) {
                    com.bytedance.sdk.component.utils.a.w("lqmt", "ext pl load start");
                    boolean c4 = yu.c().c(wv, false);
                    com.bytedance.sdk.component.utils.a.w("lqmt", "ext pl load finish, result: " + c4);
                    if (!c4) {
                        return;
                    }
                }
                xv xvVar = (xv) AutoService.c(xv.class);
                if (xvVar != null) {
                    xvVar.c(ls.getContext(), new EventListener() { // from class: com.bytedance.sdk.openadsdk.core.ls.p.1
                        @Override // com.bykv.vk.openvk.api.proto.EventListener
                        public ValueSet onEvent(int i4, Result result) {
                            com.bytedance.sdk.component.utils.a.w("lqmt", "ext pl pty initStatus : " + i4);
                            EventListener eventListener2 = EventListener.this;
                            if (eventListener2 != null) {
                                eventListener2.onEvent(i4, result);
                                return null;
                            }
                            return null;
                        }
                    });
                }
            }
        }
    }
}
