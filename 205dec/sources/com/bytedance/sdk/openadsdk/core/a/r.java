package com.bytedance.sdk.openadsdk.core.a;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements com.bytedance.sdk.openadsdk.ux.c {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f31682a;
    private volatile int bk;

    /* renamed from: c  reason: collision with root package name */
    private String f31683c;
    private JSONArray ev;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f31684f;
    private boolean gd;

    /* renamed from: k  reason: collision with root package name */
    private AtomicLong f31685k;

    /* renamed from: p  reason: collision with root package name */
    private int f31686p;

    /* renamed from: r  reason: collision with root package name */
    private JSONArray f31687r;
    private Boolean sr;

    /* renamed from: t  reason: collision with root package name */
    private volatile boolean f31688t;
    private Boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private me f31689w;
    private Boolean xv;

    public r(String str, me meVar, JSONObject jSONObject) {
        this.f31683c = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.xv = bool;
        this.sr = bool;
        this.ux = bool;
        this.gd = false;
        this.f31685k = new AtomicLong();
        this.bk = 0;
        this.f31688t = false;
        this.f31683c = str;
        this.f31689w = meVar;
        this.f31684f = jSONObject;
        this.f31687r = new JSONArray();
        this.ev = new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ia() {
        return this.ux.booleanValue() || (this.sr.booleanValue() && this.xv.booleanValue());
    }

    public void a() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.15
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r.this.c(jSONObject, "type", "native_enterForeground");
                    r rVar = r.this;
                    rVar.c(rVar.f31687r, jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.w
    public void bk() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.20
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "no_native_render", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.c
    public void fp() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.24
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.ia() && !r.this.gd) {
                        if (r.this.f31687r != null && r.this.f31687r.length() != 0) {
                            try {
                                r.this.f31684f.put("native_switchBackgroundAndForeground", r.this.f31687r);
                            } catch (Exception unused) {
                            }
                        }
                        if (r.this.ev != null && r.this.ev.length() != 0) {
                            try {
                                r.this.f31684f.put("intercept_source", r.this.ev);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("webview_time_track", r.this.f31684f);
                        if (k.sr().z() && r.this.f31684f != null) {
                            a.w("WebviewTimeTrack", r.this.f31684f.toString());
                        }
                        xv.r(r.this.f31689w, r.this.f31683c, "webview_time_track", hashMap);
                        r.this.gd = true;
                    }
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    public void k() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.14
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r.this.c(jSONObject, "type", "native_enterBackground");
                    r rVar = r.this;
                    rVar.c(rVar.f31687r, jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    public void p() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.13
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "native_endcard_close", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.xv
    public void t() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.21
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "render_failed", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.c
    public void ys() {
        this.xv = Boolean.TRUE;
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.sr
    public void ev() {
        c((JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.sr
    public void f() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.8
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "webview_load_start", (Object) jSONObject, false);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    public void gd() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.11
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "native_endcard_show", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.sr
    public void r() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.9
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "webview_load_success", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.c
    public void sr(final String str) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.2
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.c
    public void ux(final String str) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.3
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.xv
    public void w() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.12
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "render_success", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.w
    public void xv() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.26
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "native_render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.sr
    public void f(final String str) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.18
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r.this.c(jSONObject, "jsb", str);
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "webview_jsb_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.sr
    public void r(final String str) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.19
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r.this.c(jSONObject, "jsb", str);
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "webview_jsb_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    public void sr() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.6
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "native_render_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.w
    public void ux() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.7
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "native_render_end", jSONObject);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    JSONObject jSONObject2 = new JSONObject();
                    r.this.c(jSONObject2, "ts", Long.valueOf(currentTimeMillis2));
                    r rVar2 = r.this;
                    rVar2.c(rVar2.f31684f, "render_success", jSONObject2);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.c
    public void w(final String str) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.28
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.c
    public void xv(final String str) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.29
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.xv
    public void c() {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.1
                @Override // java.lang.Runnable
                public void run() {
                    r.this.f31685k.set(System.currentTimeMillis());
                    JSONObject jSONObject = new JSONObject();
                    r rVar = r.this;
                    rVar.c(jSONObject, "ts", Long.valueOf(rVar.f31685k.get()));
                    r rVar2 = r.this;
                    rVar2.c(jSONObject, "render_sequence", Integer.valueOf(rVar2.f31689w.ld()));
                    r rVar3 = r.this;
                    rVar3.c(jSONObject, "render_timeout", Integer.valueOf(rVar3.f31686p));
                    r.this.c(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ux.ux.c().ux()));
                    r.this.c(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ux.ux.c().xv()));
                    r rVar4 = r.this;
                    rVar4.c(rVar4.f31684f, "render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.c
    public void w(final int i4, final String str) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.30
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r.this.c(jSONObject, "code", Integer.valueOf(i4));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.c
    public void xv(final int i4, final String str) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.4
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r.this.c(jSONObject, "code", Integer.valueOf(i4));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.xv
    public void c(final int i4) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.23
                @Override // java.lang.Runnable
                public void run() {
                    r.this.c(i4, (String) null);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.sr
    public void w(final int i4) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.5
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r.this.c(jSONObject, "isWebViewCache", Integer.valueOf(i4));
                    if (r.this.f31689w != null && r.this.f31689w.rh() != null) {
                        if (r.this.f31689w.rh().a()) {
                            r rVar = r.this;
                            rVar.c(jSONObject, "engine_version", rVar.f31689w.rh().k());
                        } else {
                            r.this.c(jSONObject, "engine_version", EventMonitor.V1_STAGING_ADLOG);
                        }
                    }
                    r rVar2 = r.this;
                    rVar2.c(rVar2.f31684f, "before_webview_request", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    public void xv(int i4) {
        this.f31686p = i4;
    }

    public void c(final int i4, final String str) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.25
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r.this.c(jSONObject, "code", Integer.valueOf(i4));
                    String str2 = str;
                    if (str2 != null) {
                        r.this.c(jSONObject, "msg", str2);
                    }
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "render_error", jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.sr
    public void w(final String str, final long j4, final long j5, final int i4) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.17
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j5 < j4) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "start_ts", Long.valueOf(j4));
                    r.this.c(jSONObject, "end_ts", Long.valueOf(j5));
                    r.this.c(jSONObject, "intercept_type", Integer.valueOf(i4));
                    r.this.c(jSONObject, "type", "intercept_js");
                    r.this.c(jSONObject, "url", str);
                    r.this.c(jSONObject, "duration", Long.valueOf(j5 - j4));
                    r rVar = r.this;
                    rVar.c(rVar.ev, jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.c
    public void c(final String str) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.27
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.c
    public void w(final JSONObject jSONObject) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.22
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    if (r.this.f31684f == null || (jSONObject2 = jSONObject) == null) {
                        return;
                    }
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        r rVar = r.this;
                        rVar.c(rVar.f31684f, next, jSONObject.opt(next));
                    }
                    r.this.sr = Boolean.TRUE;
                    r.this.fp();
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    public void c(final JSONObject jSONObject) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.10
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    r.this.c(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                    r rVar = r.this;
                    rVar.c(rVar.f31684f, "webview_load_error", jSONObject2);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.c
    public void w(boolean z3) {
        try {
            if (!this.f31688t && this.f31689w != null) {
                this.f31688t = true;
                if (this.f31689w.ld() == 0 && this.bk != 0) {
                    if (this.f31682a == null) {
                        this.f31682a = new JSONObject();
                    }
                    this.f31682a.put("render_sequence", this.f31689w.ld());
                    this.f31682a.put("render_control", this.f31689w.y());
                    this.f31682a.put("fetch_tpl_time_out", ls.w().o());
                    this.f31682a.put("req_id", this.f31689w.xq());
                    this.f31682a.put("ad_id", this.f31689w.jr());
                    this.f31682a.put("ad_slot_type", wv.ev(this.f31689w));
                    if (z3) {
                        this.f31682a.put("webview_time_cost", System.currentTimeMillis() - this.f31685k.get());
                        this.f31682a.put("webview_result", 2);
                    }
                    com.bytedance.sdk.openadsdk.core.fz.a.c().c(this.f31682a);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    protected r() {
        this.f31683c = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.xv = bool;
        this.sr = bool;
        this.ux = bool;
        this.gd = false;
        this.f31685k = new AtomicLong();
        this.bk = 0;
        this.f31688t = false;
    }

    @Override // com.bytedance.sdk.openadsdk.ux.sr.sr
    public void c(final String str, final long j4, final long j5, final int i4) {
        try {
            ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.r.16
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j5 < j4) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    r.this.c(jSONObject, "start_ts", Long.valueOf(j4));
                    r.this.c(jSONObject, "end_ts", Long.valueOf(j5));
                    r.this.c(jSONObject, "intercept_type", Integer.valueOf(i4));
                    r.this.c(jSONObject, "type", "intercept_html");
                    r.this.c(jSONObject, "url", str);
                    r.this.c(jSONObject, "duration", Long.valueOf(j5 - j4));
                    r rVar = r.this;
                    rVar.c(rVar.ev, jSONObject);
                }
            });
        } catch (Throwable th) {
            a.sr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.c
    public void c(boolean z3) {
        this.ux = Boolean.valueOf(z3);
    }

    @Override // com.bytedance.sdk.openadsdk.ux.c
    public void c(boolean z3, int i4) {
        try {
            if (this.f31682a == null) {
                this.f31682a = new JSONObject();
            }
            this.f31682a.put("error_code", i4);
            this.f31682a.put("webview_time_cost", System.currentTimeMillis() - this.f31685k.get());
            this.f31682a.put("webview_result", z3 ? 0 : 1);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ux.c
    public void c(int i4, int i5, String str) {
        try {
            this.bk = i4;
            if (this.f31682a == null) {
                this.f31682a = new JSONObject();
            }
            this.f31682a.put("render_type", i4);
            this.f31682a.put("error_code", i5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject, String str, Object obj, boolean z3) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z3) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception e4) {
                a.sr("WebviewTimeTrack", e4.getMessage());
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    public void c(JSONObject jSONObject, String str, Object obj) {
        c(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception e4) {
            a.sr("WebviewTimeTrack", e4.getMessage());
        }
    }
}
