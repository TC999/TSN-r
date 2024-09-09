package com.bytedance.sdk.openadsdk.core.ls;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class gd {
    public abstract void c(int i4, ev evVar);

    public void c(Context context) {
        xv xvVar;
        com.bytedance.sdk.component.utils.a.w("pit_render", "predict begin");
        if (w() && (xvVar = (xv) AutoService.c(xv.class)) != null && xvVar.xv()) {
            final JSONObject w3 = w(context);
            xvVar.c("common", w3, new EventListener() { // from class: com.bytedance.sdk.openadsdk.core.ls.gd.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i4, Result result) {
                    com.bytedance.sdk.openadsdk.core.fz.a.c();
                    com.bytedance.sdk.openadsdk.core.fz.a.c(result, w3);
                    gd.this.c(i4, new ev(result, i4));
                    return null;
                }
            });
        }
    }

    public abstract JSONObject w(Context context);

    public abstract boolean w();
}
