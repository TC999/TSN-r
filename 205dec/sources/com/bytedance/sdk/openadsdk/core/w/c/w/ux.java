package com.bytedance.sdk.openadsdk.core.w.c.w;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.pr;
import com.bytedance.sdk.openadsdk.core.u.fz;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.u;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends com.bytedance.sdk.openadsdk.core.w.c.c {
    private Map<String, Object> ev;

    /* renamed from: f  reason: collision with root package name */
    private String f35347f;
    private com.bytedance.sdk.openadsdk.core.w.sr gd;

    /* renamed from: r  reason: collision with root package name */
    private int f35348r;
    private u ux;

    public ux() {
    }

    public ux(me meVar, Context context, com.bytedance.sdk.openadsdk.core.w.sr srVar) {
        this.gd = srVar;
        this.f35278c = meVar;
        this.f35279w = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.c
    public boolean c(Map<String, Object> map) {
        boolean w3;
        u uVar = this.ux;
        if (uVar == null || TextUtils.isEmpty(uVar.ia) || !fz.c(this.f35278c, this.ux.ia)) {
            return false;
        }
        if (fz.w(this.f35278c, this.ux.ia) != 1) {
            w3 = c();
        } else {
            w3 = w();
        }
        if (w3 && !((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.gd.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c(map)) {
            ((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) this.gd.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class)).c(map);
        }
        return w3;
    }

    public boolean w() {
        return pr.c(this.f35279w, fz.xv(this.f35278c, this.ux.ia), this.f35278c, this.f35348r, this.f35347f, this.ev);
    }

    public void w(Map<String, Object> map) {
        this.ev = map;
    }

    public void c(u uVar) {
        this.ux = uVar;
    }

    public boolean c() {
        String xv = fz.xv(this.f35278c, this.ux.ia);
        if (TextUtils.isEmpty(xv)) {
            return false;
        }
        Uri parse = Uri.parse(com.bytedance.sdk.openadsdk.core.p.w.c(this.f35278c, xv));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        wv.w(intent);
        if (wv.f(this.f35279w)) {
            if (wv.c(this.f35279w, intent)) {
                com.bytedance.sdk.component.utils.w.c(this.f35279w, intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.ux.1
                    @Override // com.bytedance.sdk.component.utils.w.c
                    public void c() {
                        com.bytedance.sdk.openadsdk.core.a.xv.xv(((com.bytedance.sdk.openadsdk.core.w.c.c) ux.this).f35278c, ux.this.f35347f, "deeplink_success_realtime");
                    }

                    @Override // com.bytedance.sdk.component.utils.w.c
                    public void c(Throwable th) {
                        com.bytedance.sdk.openadsdk.core.a.xv.xv(((com.bytedance.sdk.openadsdk.core.w.c.c) ux.this).f35278c, ux.this.f35347f, "deeplink_fail_realtime");
                    }
                });
                com.bytedance.sdk.openadsdk.core.a.xv.ev(this.f35278c, this.f35347f, "open_url_app", null);
                com.bytedance.sdk.openadsdk.core.a.f.c().c(this.f35278c, this.f35347f, false);
                return true;
            }
            return false;
        }
        try {
            com.bytedance.sdk.openadsdk.core.a.xv.ev(this.f35278c, this.f35347f, "open_url_app", null);
            this.f35279w.startActivity(intent);
            com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f35278c, this.f35347f, "deeplink_success_realtime");
            com.bytedance.sdk.openadsdk.core.a.f.c().c(this.f35278c, this.f35347f, false);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void c(String str) {
        this.f35347f = str;
    }

    public void c(int i4) {
        this.f35348r = i4;
    }
}
