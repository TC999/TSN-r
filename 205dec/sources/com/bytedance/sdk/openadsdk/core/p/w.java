package com.bytedance.sdk.openadsdk.core.p;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.core.eq.c;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.yu;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.pr;
import com.bytedance.sdk.openadsdk.core.u.bw;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ys;
import com.bytedance.sdk.openadsdk.core.u.z;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private me f34251c;

    /* renamed from: w  reason: collision with root package name */
    private String f34252w;
    private Context xv;

    public w(me meVar, String str, Context context) {
        this.f34251c = meVar;
        this.f34252w = str;
        this.xv = context;
    }

    private ys w() {
        me meVar = this.f34251c;
        if (meVar == null) {
            return new ys();
        }
        return meVar.qu();
    }

    public Boolean c(final int i4, final Map<String, Object> map) {
        boolean c4;
        a.w("deepLink", "WebHelper \u542b\u6709deeplink\u94fe\u63a5\u5c1d\u8bd5deeplink\u8c03\u8d77 deepLink != null ");
        ys w3 = w();
        if (!TextUtils.isEmpty(w3.c())) {
            String c5 = c(this.f34251c, w3.c());
            ys.c((String) null);
            Uri parse = Uri.parse(c5);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            wv.w(intent);
            boolean z3 = false;
            if (wv.f(this.xv)) {
                if (wv.c(this.xv, intent)) {
                    wv.c(false, false, this.f34251c, this.f34252w);
                    c(intent, System.currentTimeMillis());
                    com.bytedance.sdk.component.utils.w.c(this.xv, intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.p.w.1
                        @Override // com.bytedance.sdk.component.utils.w.c
                        public void c() {
                            com.bytedance.sdk.openadsdk.core.a.xv.xv(w.this.f34251c, w.this.f34252w, "deeplink_success_realtime");
                        }

                        @Override // com.bytedance.sdk.component.utils.w.c
                        public void c(Throwable th) {
                            if (w.this.f34251c != null && !w.this.f34251c.ds()) {
                                pr.c(w.this.xv, w.this.f34251c.pu(), w.this.f34251c, i4, w.this.f34252w, map);
                                a.xv("WebHelper", "openDetailPage() -> mContext.startActivity(intent) fail :", th);
                            }
                            com.bytedance.sdk.openadsdk.core.a.xv.xv(w.this.f34251c, w.this.f34252w, "deeplink_fail_realtime");
                        }
                    });
                    com.bytedance.sdk.openadsdk.core.a.xv.ev(this.f34251c, this.f34252w, "open_url_app", null);
                    com.bytedance.sdk.openadsdk.core.a.f.c().c(this.f34251c, this.f34252w, false);
                    return Boolean.TRUE;
                }
                com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f34251c, this.f34252w, "deeplink_fail_realtime");
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    com.bytedance.sdk.openadsdk.core.a.xv.ev(this.f34251c, this.f34252w, "open_url_app", null);
                    c4 = wv.c(false, false, this.f34251c, this.f34252w);
                } catch (Throwable unused) {
                }
                try {
                    this.xv.startActivity(intent);
                    c(intent, currentTimeMillis);
                    com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f34251c, this.f34252w, "deeplink_success_realtime");
                    com.bytedance.sdk.openadsdk.core.a.f.c().c(this.f34251c, this.f34252w, false);
                    return Boolean.TRUE;
                } catch (Throwable unused2) {
                    z3 = c4;
                    com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f34251c, this.f34252w, "deeplink_fail_realtime");
                    if (z3) {
                        return Boolean.FALSE;
                    }
                    return null;
                }
            }
        }
        return null;
    }

    public void c(final Intent intent, final long j4) {
        final com.bytedance.sdk.openadsdk.core.eq.c xv;
        me meVar = this.f34251c;
        if (meVar == null || intent == null || this.xv == null || !meVar.em() || (xv = k.sr().xv()) == null) {
            return;
        }
        xv.c(new c.InterfaceC0491c() { // from class: com.bytedance.sdk.openadsdk.core.p.w.2
            @Override // com.bytedance.sdk.openadsdk.core.eq.c.InterfaceC0491c
            public void c() {
                long currentTimeMillis = System.currentTimeMillis();
                a.w("WebHelper", "\u95f4\u9694\u65f6\u95f4 onActivityResumed intervalTime " + (currentTimeMillis - j4));
                if (currentTimeMillis - j4 <= 3000) {
                    w.this.c(intent);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Intent intent) {
        String str;
        me meVar = this.f34251c;
        if (meVar == null || this.xv == null || intent == null) {
            return;
        }
        String xv = meVar.ix() != null ? this.f34251c.ix().xv() : "";
        if (TextUtils.isEmpty(xv)) {
            str = "\u662f\u5426\u7acb\u5373\u6253\u5f00\u5e94\u7528";
        } else {
            str = "\u662f\u5426\u7acb\u5373\u6253\u5f00" + xv;
        }
        com.bytedance.sdk.openadsdk.core.eq.f.c(this.xv, this.f34251c.jr(), xv, str, "\u7acb\u5373\u6253\u5f00", "\u9000\u51fa", new f.c() { // from class: com.bytedance.sdk.openadsdk.core.p.w.3
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                com.bytedance.sdk.openadsdk.core.a.xv.ev(w.this.f34251c, w.this.f34252w, "open_url_app", null);
                com.bytedance.sdk.component.utils.w.c(w.this.xv, intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.p.w.3.1
                    @Override // com.bytedance.sdk.component.utils.w.c
                    public void c() {
                        com.bytedance.sdk.openadsdk.core.a.f.c().c(w.this.f34251c, w.this.f34252w, false);
                        com.bytedance.sdk.openadsdk.core.a.xv.xv(w.this.f34251c, w.this.f34252w, "deeplink_success_realtime");
                    }

                    @Override // com.bytedance.sdk.component.utils.w.c
                    public void c(Throwable th) {
                        com.bytedance.sdk.openadsdk.core.a.xv.xv(w.this.f34251c, w.this.f34252w, "deeplink_fail_realtime");
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

    public static String c(me meVar, String str) {
        z ed;
        if (TextUtils.isEmpty(str) || meVar == null || !bw.c(meVar) || (ed = meVar.ed()) == null) {
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

    public boolean c(com.bytedance.sdk.openadsdk.core.p.w.xv xvVar, boolean z3) {
        if (w().xv() == 2 && !me.w(this.f34251c) && xvVar != null) {
            boolean gd = xvVar.gd();
            boolean z4 = true;
            if (!gd && xvVar.ev() && xvVar.c(z3)) {
                gd = true;
            }
            if (gd || !xvVar.xv(me.ux(this.f34251c))) {
                z4 = gd;
            }
            com.bytedance.sdk.openadsdk.core.a.xv.ev(this.f34251c, this.f34252w, "open_fallback_url", null);
            return z4;
        }
        com.bytedance.sdk.openadsdk.core.a.xv.ev(this.f34251c, this.f34252w, "open_fallback_url", null);
        return false;
    }

    public String c() {
        ys w3 = w();
        if (w3.xv() == 1) {
            return w3.w();
        }
        return this.f34251c.pu();
    }
}
