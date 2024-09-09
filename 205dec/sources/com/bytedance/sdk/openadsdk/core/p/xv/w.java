package com.bytedance.sdk.openadsdk.core.p.xv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ys;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends ev {
    public w(Context context, me meVar, String str) {
        super(context, meVar, str);
    }

    private boolean w(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                try {
                    Intent w3 = wv.w(context, str);
                    if (w3 == null) {
                        return false;
                    }
                    if (this.f34276p) {
                        com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_open_dpl", str);
                    }
                    wv.c(this.f34276p, TTMiddlePageActivity.c(this.xv), this.xv, this.sr);
                    w3.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(w3);
                    if (this.f34276p) {
                        com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl");
                    }
                    if (this.f34276p) {
                        com.bytedance.sdk.openadsdk.core.a.f.c().c(this.xv, this.sr, true);
                    }
                    return true;
                } catch (Exception unused) {
                    if (this.f34276p) {
                        com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl_failed");
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.ev, com.bytedance.sdk.openadsdk.core.p.w.xv
    public boolean gd() {
        com.bytedance.sdk.openadsdk.core.u.sr srVar = this.f34281w;
        boolean z3 = false;
        if (srVar == null) {
            return false;
        }
        String sr = srVar.sr();
        if (!TextUtils.isEmpty(sr) && w(getContext(), sr)) {
            z3 = true;
            this.f34271f.set(true);
            if (!c(this.sr, "click_open", this.xv)) {
                com.bytedance.sdk.openadsdk.core.a.xv.gd(this.xv, this.sr, wv.r(this.xv), null);
            }
        }
        return z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.ev
    public boolean k() {
        if (this.xv.qu() != null) {
            String c4 = this.xv.qu().c();
            if (!TextUtils.isEmpty(c4)) {
                ys.c((String) null);
                Uri parse = Uri.parse(c4);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (this.f34276p) {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_open_dpl", c(c4));
                }
                try {
                    Context context = getContext();
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    if (!c(this.sr, "open_url_app", this.xv)) {
                        com.bytedance.sdk.openadsdk.core.a.xv.ev(this.xv, this.sr, "open_url_app", null);
                    }
                    wv.c(this.f34276p, TTMiddlePageActivity.c(this.xv), this.xv, this.sr);
                    context.startActivity(intent);
                    com.bytedance.sdk.openadsdk.core.a.f.c().c(this.xv, this.sr, this.f34276p);
                    if (this.f34276p) {
                        com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl");
                        com.bytedance.sdk.openadsdk.core.a.xv.xv(this.xv, this.sr, "lp_deeplink_success_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.core.a.xv.xv(this.xv, this.sr, "deeplink_success_realtime");
                    }
                    return true;
                } catch (Throwable unused) {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "open_fallback_download");
                    if (this.f34276p) {
                        com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, this.sr, "lp_openurl_failed");
                        c(this.xv, this.sr, "lp_deeplink_fail_realtime");
                    } else {
                        c(this.xv, this.sr, "deeplink_fail_realtime");
                    }
                }
            }
            if (this.ux.get() == 4 || this.ux.get() == 3) {
                return false;
            }
            if (!this.gd || this.f34271f.get()) {
                this.gd = true;
                if (c(this.sr, "open_fallback_url", this.xv)) {
                    return false;
                }
                com.bytedance.sdk.openadsdk.core.a.xv.ev(this.xv, this.sr, "open_fallback_url", null);
                return false;
            }
            return false;
        }
        return false;
    }
}
