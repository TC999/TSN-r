package com.bytedance.sdk.openadsdk.core.a;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: w  reason: collision with root package name */
    private final me f31759w;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f31754c = false;
    private String xv = "landingpage";
    private long sr = 0;
    private long ux = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f31755f = 0;

    /* renamed from: r  reason: collision with root package name */
    private long f31758r = 0;
    private long ev = 0;
    private long gd = 0;

    /* renamed from: p  reason: collision with root package name */
    private AtomicInteger f31757p = new AtomicInteger(0);

    /* renamed from: k  reason: collision with root package name */
    private boolean f31756k = false;

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f31753a = new AtomicBoolean(false);

    public ux(me meVar) {
        this.f31759w = meVar;
    }

    public void sr() {
        a.w("NativeLandingPageLog", "onDestroy");
        if (this.f31753a.get() || !this.f31754c) {
            return;
        }
        xv.c(this.f31759w, this.xv, "load", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.ux.1
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "ugen");
                if (ux.this.f31759w != null && com.bytedance.sdk.openadsdk.core.ugeno.f.ev(ux.this.f31759w)) {
                    jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(ux.this.f31759w.r()));
                }
                jSONObject.putOpt("ad_extra_data", jSONObject2);
                jSONObject.put("duration", Math.min(System.currentTimeMillis() - ux.this.gd, 600000L));
            }
        });
    }

    public void xv() {
        a.w("NativeLandingPageLog", "onResume");
        this.f31755f = System.currentTimeMillis();
        this.sr = System.currentTimeMillis();
    }

    public ux c(boolean z3) {
        this.f31756k = z3;
        return this;
    }

    public void w() {
        if (this.f31754c) {
            return;
        }
        this.f31758r = System.currentTimeMillis();
        this.gd = System.currentTimeMillis();
        this.f31754c = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            me meVar = this.f31759w;
            if (meVar != null && com.bytedance.sdk.openadsdk.core.ugeno.f.ev(meVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.f31759w.r()));
            }
        } catch (Exception unused) {
        }
        c("load_start", jSONObject);
    }

    public void c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            me meVar = this.f31759w;
            if (meVar != null && com.bytedance.sdk.openadsdk.core.ugeno.f.ev(meVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.f31759w.r()));
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        c("open_url_h5", jSONObject);
    }

    public void c(int i4, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            me meVar = this.f31759w;
            if (meVar != null && com.bytedance.sdk.openadsdk.core.ugeno.f.ev(meVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.f31759w.r()));
            }
            jSONObject.putOpt("code", Integer.valueOf(i4));
            jSONObject.putOpt("msg", str);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        c("load_fail", jSONObject);
    }

    public void c(long j4) {
        if (this.f31753a.get()) {
            return;
        }
        this.f31753a.set(true);
        this.ev = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long j5 = this.ev - this.f31758r;
        Log.d("NativeLandingPageLog", "onLoadFinish: duration=" + j5);
        try {
            jSONObject.putOpt("render_type", "ugen");
            jSONObject.put("net_work_duration", j4);
            me meVar = this.f31759w;
            if (meVar != null && com.bytedance.sdk.openadsdk.core.ugeno.f.ev(meVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.f31759w.r()));
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        c("load_finish", jSONObject, Math.min(j5, 600000L));
    }

    public void c(int i4) {
        a.w("NativeLandingPageLog", "onStop");
        long currentTimeMillis = System.currentTimeMillis();
        this.ux = currentTimeMillis;
        long max = currentTimeMillis - Math.max(this.sr, this.f31755f);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", 2);
            jSONObject.put("max_scroll_percent", this.f31757p.get());
            jSONObject.put("is_slide", i4);
            jSONObject.putOpt("render_type", "ugen");
            me meVar = this.f31759w;
            if (meVar != null && com.bytedance.sdk.openadsdk.core.ugeno.f.ev(meVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.f31759w.r()));
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        c("stay_page", jSONObject, Math.min(max, 600000L));
    }

    private void c(String str, JSONObject jSONObject) {
        c(str, jSONObject, -1L);
    }

    private void c(String str, JSONObject jSONObject, long j4) {
        JSONObject jSONObject2;
        if (!this.f31756k || this.f31759w == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject3 = null;
        if (jSONObject != null) {
            try {
                int i4 = 1;
                jSONObject.put("is_playable", u.xv(this.f31759w) ? 1 : 0);
                if (!com.bytedance.sdk.openadsdk.core.playable.c.c().c(this.f31759w)) {
                    i4 = 0;
                }
                jSONObject.put("usecache", i4);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            try {
                jSONObject2 = new JSONObject();
            } catch (JSONException e5) {
                e = e5;
            }
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
                if (j4 > 0) {
                    jSONObject2.put("duration", j4);
                }
                jSONObject3 = jSONObject2;
            } catch (JSONException e6) {
                e = e6;
                jSONObject3 = jSONObject2;
                e.printStackTrace();
                a.w("NativeLandingPageLog", "sendEvent: " + this.xv + ", " + str + ", ext=" + jSONObject3);
                xv.sr(this.f31759w, this.xv, str, jSONObject3);
            }
        }
        a.w("NativeLandingPageLog", "sendEvent: " + this.xv + ", " + str + ", ext=" + jSONObject3);
        xv.sr(this.f31759w, this.xv, str, jSONObject3);
    }
}
