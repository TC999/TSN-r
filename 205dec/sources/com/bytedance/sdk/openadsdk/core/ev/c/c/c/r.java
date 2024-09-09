package com.bytedance.sdk.openadsdk.core.ev.c.c.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements com.bytedance.sdk.openadsdk.core.ev.c.c.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ev.c.c.c f33402c;

    /* renamed from: f  reason: collision with root package name */
    private Bridge f33403f = k.sr().u();

    /* renamed from: r  reason: collision with root package name */
    private me f33404r;
    private String sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.sr f33405w;
    private Context xv;

    public r(com.bytedance.sdk.openadsdk.core.u.sr srVar, Context context, String str) {
        this.f33405w = srVar;
        this.xv = context;
        this.sr = str;
    }

    private boolean w(String str) {
        try {
            Intent w3 = wv.w(this.xv, str);
            if (w3 == null) {
                return false;
            }
            w3.putExtra("START_ONLY_FOR_ANDROID", true);
            this.xv.startActivity(w3);
            if (this.ux) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(this.f33404r, this.sr, "lp_openurl");
            }
            if (this.ux) {
                com.bytedance.sdk.openadsdk.core.a.f.c().c(this.f33404r, this.sr, true);
            }
            return true;
        } catch (Exception unused) {
            if (this.ux) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(this.f33404r, this.sr, "lp_openurl_failed");
            }
            return false;
        }
    }

    public void c(me meVar) {
        this.f33404r = meVar;
    }

    public void c(boolean z3) {
        this.ux = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c
    public boolean c(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.u.sr srVar = this.f33405w;
        if (srVar == null) {
            com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar = this.f33402c;
            return cVar != null && cVar.c(map);
        }
        String sr = srVar.sr();
        if (TextUtils.isEmpty(sr)) {
            com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar2 = this.f33402c;
            return cVar2 != null && cVar2.c(map);
        } else if (c(sr)) {
            if (!c(this.sr, "click_open", this.f33404r)) {
                com.bytedance.sdk.openadsdk.core.a.xv.gd(this.f33404r, this.sr, wv.r(this.f33404r), null);
            }
            return true;
        } else {
            com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar3 = this.f33402c;
            return cVar3 != null && cVar3.c(map);
        }
    }

    public r(com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar, com.bytedance.sdk.openadsdk.core.u.sr srVar, Context context, String str) {
        this.f33402c = cVar;
        this.f33405w = srVar;
        this.xv = context;
        this.sr = str;
    }

    private boolean c(String str, String str2, me meVar) {
        if (this.f33403f == null) {
            return false;
        }
        return ((Boolean) this.f33403f.call(2, b.a().h(0, new y().c("tagIntercept", str).c("label", str2).c("meta", meVar.mo().toString())).l(), Boolean.class)).booleanValue();
    }

    public boolean c(String str) {
        if (this.xv != null && !TextUtils.isEmpty(str)) {
            if (this.ux) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(this.f33404r, this.sr, "lp_open_dpl", str);
            }
            if (!wv.f(this.xv)) {
                return w(str);
            }
            try {
                if (wv.xv(this.xv, str)) {
                    return w(str);
                }
                if (this.ux) {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(this.f33404r, this.sr, "lp_openurl_failed");
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
