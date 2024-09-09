package com.bytedance.sdk.openadsdk.core.p.xv.w;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static void c(int i4) {
        Bridge u3 = k.sr().u();
        if (u3 == null) {
            return;
        }
        u3.call(26, b.a().h(0, new y().c("downloadMode", Integer.valueOf(i4))).l(), Void.class);
    }

    public static void w(int i4) {
        Bridge u3 = k.sr().u();
        if (u3 == null) {
            return;
        }
        u3.call(30, b.a().h(0, new y().c("downloadScene", Integer.valueOf(i4))).l(), Void.class);
    }

    public static int c(Bridge bridge) {
        if (bridge == null) {
            return 0;
        }
        return ((Integer) bridge.call(27, b.f24740c, Integer.class)).intValue();
    }

    public static void c(boolean z3) {
        Bridge u3 = k.sr().u();
        if (u3 == null) {
            return;
        }
        u3.call(28, b.b(1).h(0, new y().c("isEnableOppoAutoDownload", Boolean.valueOf(z3))).l(), Void.class);
    }

    public static void c(String str, String str2, JSONObject jSONObject) {
        Bridge u3 = k.sr().u();
        if (u3 == null || jSONObject == null) {
            return;
        }
        u3.call(29, b.a().h(0, new y().c("clickButtonTag", str).c("clickItemTag", str2).c("clickStartLabel", "click_start").c("clickContinueLabel", "click_continue").c("clickPauseLabel", "click_pause").c("storageDenyLabel", "download_failed").c("clickInstallLabel", "click_install").c("isEnableClickEvent", Boolean.TRUE).c("isEnableV3Event", Boolean.FALSE).c("extraEventObject", jSONObject)).l(), Void.class);
    }

    public static void c(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.n.c.c.c cVar) {
        if (eq.f33190w < 4400 || map == null || cVar == null || map.get("downloadButtonClickListener") != null) {
            return;
        }
        map.put("downloadButtonClickListener", cVar);
    }

    public static boolean c(Context context, String str, me meVar, String str2, boolean z3) {
        if (context == null) {
            return false;
        }
        try {
            wv.c(z3, false, meVar, str2);
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
