package com.bytedance.sdk.component.p.c;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.adsdk.w.w.a;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.p.sr.f;
import com.bytedance.sdk.component.p.sr.sr;
import com.bytedance.sdk.component.p.sr.ux;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f29945c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private sr f29946f;
    private Map<String, Object> gd;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.sdk.component.p.sr.w f29947k;

    /* renamed from: p  reason: collision with root package name */
    private int f29948p = 1;

    /* renamed from: r  reason: collision with root package name */
    private sr f29949r;
    private String sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private Map<String, Object> f29950w;
    private com.bytedance.sdk.component.p.xv.c xv;

    public c(com.bytedance.sdk.component.p.xv.c cVar, JSONObject jSONObject, Map<String, Object> map) {
        this.xv = cVar;
        this.f29945c = jSONObject;
        this.f29950w = map;
    }

    private void a() {
        f w3;
        f w4;
        sr srVar = this.f29946f;
        if (srVar != null && (w4 = srVar.w()) != null) {
            w4.c(this.f29950w, this);
        }
        sr srVar2 = this.f29949r;
        if (srVar2 == null || (w3 = srVar2.w()) == null) {
            return;
        }
        w3.c(this.f29950w, this);
    }

    private void ev() {
        if (this.f29948p != 2) {
            com.bytedance.sdk.component.p.xv.c cVar = this.xv;
            if (cVar == null) {
                return;
            }
            this.ev = cVar.w();
        }
        if (!TextUtils.isEmpty(this.ev)) {
            this.sr = Uri.parse(this.ev).getHost();
        }
        if (!TextUtils.isEmpty(this.sr)) {
            String str = this.sr.split(TTPathConst.sSeparator)[0];
            this.sr = str;
            int indexOf = str.indexOf(":");
            if (indexOf == -1) {
                indexOf = this.sr.length();
            }
            this.sr = this.sr.substring(0, indexOf);
        }
        w(this.ev);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd() {
        ux xv;
        ux xv2;
        sr srVar = this.f29946f;
        if (srVar != null && (xv2 = srVar.xv()) != null) {
            xv2.c(this);
        }
        sr srVar2 = this.f29949r;
        if (srVar2 == null || (xv = srVar2.xv()) == null) {
            return;
        }
        xv.c(this);
    }

    private void k() {
        f w3;
        f w4;
        sr srVar = this.f29946f;
        if (srVar != null && (w4 = srVar.w()) != null) {
            w4.c(this.f29945c, this);
        }
        sr srVar2 = this.f29949r;
        if (srVar2 == null || (w3 = srVar2.w()) == null) {
            return;
        }
        w3.c(this.f29945c, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        ux xv;
        ux xv2;
        sr srVar = this.f29946f;
        if (srVar != null && (xv2 = srVar.xv()) != null) {
            xv2.c(this, "\u6253\u5f00\u539f\u5b50\u4e8b\u4ef6\u5931\u8d25");
        }
        sr srVar2 = this.f29949r;
        if (srVar2 == null || (xv = srVar2.xv()) == null) {
            return;
        }
        xv.c(this, "\u6253\u5f00\u539f\u5b50\u4e8b\u4ef6\u5931\u8d25");
    }

    public void f() {
        ev();
        a();
        com.bytedance.sdk.component.p.sr.w wVar = this.f29947k;
        if (wVar != null) {
            wVar.c();
        } else {
            com.bytedance.sdk.component.p.r.c.c().c(this.sr, this, new com.bytedance.sdk.component.p.sr.c() { // from class: com.bytedance.sdk.component.p.c.c.1
                @Override // com.bytedance.sdk.component.p.sr.c
                public void c() {
                    c.this.gd();
                }

                @Override // com.bytedance.sdk.component.p.sr.c
                public void w() {
                    c.this.p();
                }
            });
        }
    }

    public com.bytedance.sdk.component.p.xv.c r() {
        return this.xv;
    }

    public String sr() {
        return this.ux;
    }

    public sr ux() {
        return this.f29946f;
    }

    public JSONObject xv() {
        return this.f29945c;
    }

    private void xv(String str) {
        f w3;
        f w4;
        sr srVar = this.f29946f;
        if (srVar != null && (w4 = srVar.w()) != null) {
            w4.c(str, this);
        }
        sr srVar2 = this.f29949r;
        if (srVar2 == null || (w3 = srVar2.w()) == null) {
            return;
        }
        w3.c(str, this);
    }

    public Map<String, Object> c() {
        return this.f29950w;
    }

    public Map<String, Object> w() {
        return this.gd;
    }

    private void w(String str) {
        xv(str);
        JSONObject c4 = com.bytedance.sdk.component.p.ev.w.c(str);
        if (c4 == null) {
            return;
        }
        k();
        Iterator<String> keys = c4.keys();
        this.gd = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                Object opt = c4.opt(next);
                if (opt instanceof String) {
                    opt = c((String) opt, this.f29945c);
                }
                this.gd.put(next, opt);
            }
        }
    }

    public void c(String str) {
        this.ux = str;
    }

    public void c(sr srVar) {
        if (srVar instanceof w) {
            this.f29946f = srVar;
        } else {
            this.f29949r = srVar;
        }
    }

    public c(StringBuilder sb, JSONObject jSONObject, Map<String, Object> map) {
        this.f29945c = jSONObject;
        this.f29950w = map;
    }

    private static Object c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (jSONObject != null) {
            try {
                if (!str.startsWith("${") || !str.endsWith("}")) {
                    return str;
                }
            } catch (Throwable unused) {
                return str;
            }
        }
        return a.a(str.substring(2, str.length() - 1)).c(jSONObject);
    }

    public void c(com.bytedance.sdk.component.p.sr.w wVar) {
        this.f29947k = wVar;
    }

    public void c(Map<String, Object> map) {
        ux xv;
        ux xv2;
        sr srVar = this.f29946f;
        if (srVar != null && (xv2 = srVar.xv()) != null) {
            xv2.c(this, map);
        }
        sr srVar2 = this.f29949r;
        if (srVar2 == null || (xv = srVar2.xv()) == null) {
            return;
        }
        xv.c(this, map);
    }

    public void w(Map<String, Object> map) {
        ux xv;
        ux xv2;
        sr srVar = this.f29946f;
        if (srVar != null && (xv2 = srVar.xv()) != null) {
            xv2.w(this, this.f29950w);
        }
        sr srVar2 = this.f29949r;
        if (srVar2 == null || (xv = srVar2.xv()) == null) {
            return;
        }
        xv.w(this, map);
    }
}
