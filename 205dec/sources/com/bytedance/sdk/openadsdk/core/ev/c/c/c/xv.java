package com.bytedance.sdk.openadsdk.core.ev.c.c.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.core.eq.c;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.eq.yu;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.u.bw;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ys;
import com.bytedance.sdk.openadsdk.core.u.z;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements com.bytedance.sdk.openadsdk.core.ev.c.c.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ev.c.c.c f33420c;
    private boolean gd;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p.w.xv f33422k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f33423p;
    private Context sr;
    private ys ux;

    /* renamed from: w  reason: collision with root package name */
    private me f33425w;
    private String xv;

    /* renamed from: f  reason: collision with root package name */
    private boolean f33421f = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f33424r = false;
    private Bridge ev = k.sr().u();

    public xv(com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar, me meVar, String str, ys ysVar, Context context) {
        this.f33420c = cVar;
        this.f33425w = meVar;
        this.xv = str;
        this.sr = context;
        this.ux = ysVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr(boolean z3) {
        if (this.f33424r && !z3) {
            com.bytedance.sdk.openadsdk.core.a.xv.w(this.f33425w, this.xv, "open_fallback_download");
        }
        if (this.f33424r) {
            com.bytedance.sdk.openadsdk.core.a.xv.w(this.f33425w, this.xv, "lp_openurl_failed");
            if (!this.f33423p && !c(this.xv, "open_fallback_url", this.f33425w)) {
                this.f33423p = true;
                com.bytedance.sdk.openadsdk.core.a.xv.ev(this.f33425w, this.xv, "open_fallback_url", null);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.a.xv.ev(this.f33425w, this.xv, "open_fallback_url", null);
        }
        if (this.gd) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f33425w, this.xv, (this.f33424r && this.f33421f) ? "lp_deeplink_fail_realtime" : "deeplink_fail_realtime");
    }

    public void w(boolean z3) {
        this.f33424r = z3;
    }

    public void xv(boolean z3) {
        this.gd = z3;
    }

    public Boolean w(Map<String, Object> map) {
        ys c4 = c();
        String c5 = c4.c();
        if (TextUtils.isEmpty(c5)) {
            return null;
        }
        String w3 = w(c4.c());
        ys.c((String) null);
        Uri parse = Uri.parse(w3);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        if (this.f33421f) {
            com.bytedance.sdk.openadsdk.core.a.xv.w(this.f33425w, this.xv, "lp_open_dpl", c(c5));
        }
        if (wv.f(this.sr)) {
            if (wv.c(this.sr, intent)) {
                return c(map, intent, true);
            }
            sr(true);
            return null;
        }
        return c(map, intent, false);
    }

    public void c(boolean z3) {
        this.f33421f = z3;
    }

    private ys c() {
        ys ysVar = this.ux;
        return ysVar == null ? new ys() : ysVar;
    }

    private Boolean c(Map<String, Object> map, Intent intent, final boolean z3) {
        wv.w(intent);
        c(intent);
        if (this.f33424r) {
            if (!c(this.xv, "open_fallback_url", this.f33425w)) {
                com.bytedance.sdk.openadsdk.core.a.xv.ev(this.f33425w, this.xv, "open_url_app", null);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.a.xv.ev(this.f33425w, this.xv, "open_url_app", null);
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.w.c(this.sr, intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.xv.1
            @Override // com.bytedance.sdk.component.utils.w.c
            public void c() {
                atomicBoolean.set(true);
                if (xv.this.f33421f) {
                    com.bytedance.sdk.openadsdk.core.a.xv.xv(xv.this.f33425w, xv.this.xv, "lp_openurl");
                    com.bytedance.sdk.openadsdk.core.a.xv.xv(xv.this.f33425w, xv.this.xv, "lp_deeplink_success_realtime");
                } else {
                    com.bytedance.sdk.openadsdk.core.a.xv.xv(xv.this.f33425w, xv.this.xv, "deeplink_success_realtime");
                }
                com.bytedance.sdk.openadsdk.core.a.f.c().c(xv.this.f33425w, xv.this.xv, xv.this.f33421f);
            }

            @Override // com.bytedance.sdk.component.utils.w.c
            public void c(Throwable th) {
                atomicBoolean.set(false);
                xv.this.sr(z3);
            }
        });
        return Boolean.valueOf(atomicBoolean.get());
    }

    private boolean c(String str, String str2, me meVar) {
        if (this.ev == null) {
            return false;
        }
        return ((Boolean) this.ev.call(2, b.a().h(0, new y().c("tagIntercept", str).c("label", str2).c("meta", meVar.mo().toString())).l(), Boolean.class)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final Intent intent) {
        String str;
        me meVar = this.f33425w;
        if (meVar == null || this.sr == null || intent == null) {
            return;
        }
        String xv = meVar.ix() != null ? this.f33425w.ix().xv() : "";
        if (TextUtils.isEmpty(xv)) {
            str = "\u662f\u5426\u7acb\u5373\u6253\u5f00\u5e94\u7528";
        } else {
            str = "\u662f\u5426\u7acb\u5373\u6253\u5f00" + xv;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.c(this.sr, this.f33425w.jr(), xv, str, "\u7acb\u5373\u6253\u5f00", "\u9000\u51fa", new f.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.xv.3
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                com.bytedance.sdk.openadsdk.core.a.xv.ev(xv.this.f33425w, xv.this.xv, "open_url_app", null);
                com.bytedance.sdk.component.utils.w.c(xv.this.sr, intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.xv.3.1
                    @Override // com.bytedance.sdk.component.utils.w.c
                    public void c() {
                        com.bytedance.sdk.openadsdk.core.a.f.c().c(xv.this.f33425w, xv.this.xv, false);
                        com.bytedance.sdk.openadsdk.core.a.xv.xv(xv.this.f33425w, xv.this.xv, "deeplink_success_realtime");
                    }

                    @Override // com.bytedance.sdk.component.utils.w.c
                    public void c(Throwable th) {
                        com.bytedance.sdk.openadsdk.core.a.xv.xv(xv.this.f33425w, xv.this.xv, "deeplink_fail_realtime");
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
            }
        });
    }

    protected String c(String str) {
        Uri parse;
        return (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) ? "" : parse.getScheme().toLowerCase(Locale.US);
    }

    private String w(String str) {
        me meVar;
        z ed;
        if (TextUtils.isEmpty(str) || (meVar = this.f33425w) == null || !bw.c(meVar) || (ed = this.f33425w.ed()) == null) {
            return str;
        }
        try {
            String xv = ed.xv();
            String sr = ed.sr();
            Map<String, String> c4 = yu.c(str);
            c4.put("live_short_touch_params", xv);
            c4.put("extra_pangle_scheme_params", sr);
            String c5 = yu.c(str, c4);
            com.bytedance.sdk.openadsdk.core.xv.c().c("is_reward_deep_link_to_live", true);
            return c5;
        } catch (Exception unused) {
            return str;
        }
    }

    public void c(final Intent intent) {
        final com.bytedance.sdk.openadsdk.core.eq.c xv;
        final long currentTimeMillis = System.currentTimeMillis();
        me meVar = this.f33425w;
        if (meVar == null || intent == null || this.sr == null || !meVar.em() || (xv = k.sr().xv()) == null) {
            return;
        }
        xv.c(new c.InterfaceC0491c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.c.xv.2
            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void c() {
                if (System.currentTimeMillis() - currentTimeMillis <= 3000) {
                    xv.this.w(intent);
                }
                com.bytedance.sdk.openadsdk.core.eq.c cVar = xv;
                if (cVar != null) {
                    cVar.w();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void f() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void sr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void ux() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void xv() {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c
    public boolean c(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar;
        ys qu = this.f33425w.qu();
        if (qu == null) {
            com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar2 = this.f33420c;
            return cVar2 != null && cVar2.c(map);
        }
        Boolean w3 = w(map);
        if (qu.xv() == 2 && this.f33422k != null && !this.f33424r && !w3.booleanValue()) {
            this.f33422k.w(me.ux(this.f33425w));
            return true;
        } else if (w3 == null || this.f33424r) {
            return this.f33424r && !w3.booleanValue() && (cVar = this.f33420c) != null && cVar.c(map);
        } else {
            return w3.booleanValue();
        }
    }
}
