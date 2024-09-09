package com.bytedance.sdk.openadsdk.core.live.xv;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.a.f;
import com.bytedance.sdk.openadsdk.core.a.xv;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private String f33861c = "";

    public static boolean w(Context context, me meVar) {
        if (1 != TTLiveCommerceHelper.getInstance().getLiveAuthStatus()) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.live.sr.c.c(context, meVar);
    }

    private static boolean xv(Context context, me meVar) {
        if (7 == meVar.kp() && 2 == TTLiveCommerceHelper.getInstance().getLiveSdkStatus()) {
            return w(context, meVar);
        }
        return false;
    }

    public c c(String str) {
        this.f33861c = str;
        return this;
    }

    private static boolean w(Context context, me meVar, boolean z3) {
        if (z3) {
            return com.bytedance.sdk.openadsdk.core.live.sr.c.c(context, meVar);
        }
        return false;
    }

    public void c(final Context context, final me meVar) {
        q.f().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.xv.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(meVar.qu().c()));
                    intent.addFlags(268435456);
                    if (com.bytedance.sdk.component.utils.w.c(context, intent, null)) {
                        xv.xv(meVar, c.this.f33861c, "deeplink_success_realtime");
                    } else {
                        xv.xv(meVar, c.this.f33861c, "deeplink_fail_realtime");
                    }
                    xv.ev(meVar, c.this.f33861c, "open_url_app", null);
                    f.c().c(meVar, c.this.f33861c, false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, 50L);
    }

    public static boolean c(Context context, me meVar, boolean z3) {
        return xv(context, meVar) || w(context, meVar, z3);
    }
}
