package com.bytedance.sdk.openadsdk.core.ev.c.c.w;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.multipro.w.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ugeno.f;
import com.bytedance.sdk.openadsdk.ys.w.w.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.openadsdk.core.ev.c.c.c {
    private boolean ev;
    private String gd;

    /* renamed from: p  reason: collision with root package name */
    private int f33436p;

    /* renamed from: r  reason: collision with root package name */
    private Map<String, Object> f33437r;
    private me sr;
    private Object ux;
    private Context xv;

    /* renamed from: c  reason: collision with root package name */
    private boolean f33433c = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f33438w = false;

    /* renamed from: f  reason: collision with root package name */
    private int f33434f = Integer.MIN_VALUE;

    /* renamed from: k  reason: collision with root package name */
    private boolean f33435k = false;

    public c(me meVar, Context context, String str, int i4) {
        this.sr = meVar;
        this.xv = context;
        this.gd = str;
        this.f33436p = i4;
    }

    public void c(boolean z3) {
        this.f33433c = z3;
    }

    public void sr(boolean z3) {
        this.f33435k = z3;
    }

    public void w(boolean z3) {
        this.f33438w = z3;
    }

    public void xv(boolean z3) {
        this.ev = z3;
    }

    private com.bytedance.sdk.openadsdk.core.multipro.w.c sr() {
        Object obj;
        if (me.w(this.sr) && (obj = this.ux) != null) {
            com.bytedance.sdk.openadsdk.core.multipro.w.c eq = obj instanceof c.InterfaceC0499c ? ((c.InterfaceC0499c) obj).eq() : null;
            if (eq != null) {
                this.f33437r.put("multi_process_data", eq.c().toString());
            }
            Object obj2 = this.ux;
            if (obj2 instanceof w) {
                com.bytedance.sdk.openadsdk.core.multipro.w.c p3 = ((w) obj2).p();
                if (p3 != null) {
                    this.f33437r.put("multi_process_data", p3.c().toString());
                }
                return p3;
            }
            return eq;
        }
        return null;
    }

    private void xv() {
        if (this.f33435k && this.sr != null) {
            if (this.f33437r == null) {
                this.f33437r = new HashMap();
            }
            this.f33437r.put("url", this.sr.pu());
            this.f33437r.put("gecko_id", this.sr.jd());
            this.f33437r.put("web_title", this.sr.ny());
            this.f33437r.put("sdk_version", Integer.valueOf(eq.f33190w));
            this.f33437r.put("adid", this.sr.jr());
            this.f33437r.put("log_extra", this.sr.cf());
            this.f33437r.put(CampaignEx.JSON_KEY_ICON_URL, this.sr.kr() == null ? null : this.sr.kr().c());
            this.f33437r.put("event_tag", this.gd);
            this.f33437r.put("source", Integer.valueOf(this.f33436p));
            this.f33437r.put("is_outer_click", Boolean.TRUE);
            wv.c(this.f33437r, this.sr);
        }
    }

    public int c() {
        return this.f33434f;
    }

    public Class<?> w() {
        boolean z3 = this.f33433c;
        this.f33433c = false;
        if (this.f33438w) {
            return TTPlayableWebPageActivity.class;
        }
        if (f.f(this.sr)) {
            return TTNativePageActivity.class;
        }
        if ((this.ux instanceof p) || !me.w(this.sr) || z3 || c(this.ux) || !wv.xv(this.sr)) {
            return TTWebPageActivity.class;
        }
        return w(TTVideoWebPageActivity.class);
    }

    private static boolean c(Object obj) {
        if (obj != null && (obj instanceof c.InterfaceC0499c)) {
            try {
                return ((c.InterfaceC0499c) obj).ba();
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public boolean c(Class cls) {
        if (this.sr.v() == 2) {
            return c(this.sr.pu());
        }
        Intent intent = new Intent(this.xv, cls);
        if (!(this.xv instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("is_outer_click", true);
        xv();
        if (this.f33437r == null) {
            this.f33437r = new HashMap();
        }
        for (Map.Entry<String, Object> entry : this.f33437r.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.w.c(this.xv, intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.c.w.c.1
            @Override // com.bytedance.sdk.component.utils.w.c
            public void c() {
            }

            @Override // com.bytedance.sdk.component.utils.w.c
            public void c(Throwable th) {
            }
        });
        return true;
    }

    public void w(Map<String, Object> map) {
        this.f33437r = map;
    }

    private Class w(Class cls) {
        int i4;
        com.bytedance.sdk.openadsdk.core.multipro.w.c sr = sr();
        if (sr == null) {
            this.f33437r.put("video_is_auto_play", Boolean.valueOf(sr.sr));
        }
        if (TTVideoWebPageActivity.class.equals(cls)) {
            if (sr != null || this.ev) {
                try {
                    if (sr != null) {
                        i4 = (int) ((((float) sr.f33979r) / ((float) sr.ux)) * 100.0f);
                    } else {
                        i4 = 100;
                        com.bytedance.sdk.openadsdk.core.multipro.w.c cVar = new com.bytedance.sdk.openadsdk.core.multipro.w.c();
                        cVar.f33979r = 100L;
                        cVar.f33977c = true;
                        cVar.sr = wv.s(this.sr);
                        this.f33437r.put("multi_process_data", cVar.c().toString());
                    }
                    this.f33434f = i4;
                } catch (Throwable unused) {
                }
                if (this.sr.pb() == 0) {
                    return TTVideoScrollWebPageActivity.class;
                }
                if (this.sr.pb() > 0 && i4 > this.sr.pb()) {
                    if (wv.s(this.sr)) {
                        return TTVideoScrollWebPageActivity.class;
                    }
                }
                return cls;
            }
            return cls;
        }
        return cls;
    }

    private boolean c(String str) {
        if (ys.c(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                intent.setData(Uri.parse(str));
                if (!(this.xv instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                com.bytedance.sdk.component.utils.w.c(this.xv, intent, null);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c
    public boolean c(Map<String, Object> map) {
        if (this.sr == null) {
            return false;
        }
        return c((Class) w());
    }
}
