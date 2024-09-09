package com.bytedance.sdk.openadsdk.core.ba;

import com.bytedance.sdk.component.gd.a;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.openadsdk.core.ls;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static void c() {
        JSONObject gw = ls.w().gw();
        if (gw == null) {
            return;
        }
        int optInt = gw.optInt("big_max_mum", 0);
        if (optInt > 0) {
            a.f29806w.xv(optInt);
        }
        int optInt2 = gw.optInt("core_count", 0);
        if (optInt2 > 0) {
            a.f29806w.w(optInt2);
        }
        int optInt3 = gw.optInt("big_keep_alive", 0);
        if (optInt3 > 0) {
            a.f29806w.c(optInt3);
        }
        boolean optBoolean = gw.optBoolean("big_priority", false);
        a aVar = a.f29806w;
        aVar.xv(optBoolean);
        aVar.w(gw.optBoolean("catch_oom", true));
        aVar.c(gw.optBoolean("forbid_autosize_oom", true));
        aVar.sr(gw.optBoolean("enable_proxy", true));
        ev.c(gw.optBoolean("autosize", true));
    }
}
