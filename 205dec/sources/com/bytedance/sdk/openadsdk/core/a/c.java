package com.bytedance.sdk.openadsdk.core.a;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.r.w.sr.c.w {
    private static final AtomicLong xv = new AtomicLong(0);

    /* renamed from: a  reason: collision with root package name */
    private long f31660a;
    private long bk;

    /* renamed from: c  reason: collision with root package name */
    public final String f31661c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private String f31662f;
    private String gd;

    /* renamed from: k  reason: collision with root package name */
    private String f31663k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ux.c.c f31664p;

    /* renamed from: r  reason: collision with root package name */
    private String f31665r;
    private JSONObject sr;

    /* renamed from: t  reason: collision with root package name */
    private AtomicBoolean f31666t = new AtomicBoolean(false);
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    protected final JSONObject f31667w;

    /* renamed from: com.bytedance.sdk.openadsdk.core.a.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class C0472c {

        /* renamed from: c  reason: collision with root package name */
        private String f31668c;
        private JSONObject ev;

        /* renamed from: f  reason: collision with root package name */
        private String f31669f;
        private com.bytedance.sdk.openadsdk.ux.c.w gd;

        /* renamed from: p  reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.ux.c.c f31670p;

        /* renamed from: r  reason: collision with root package name */
        private String f31671r;
        private String sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        private String f31672w;
        private String xv;

        public C0472c f(String str) {
            this.f31671r = str;
            return this;
        }

        public C0472c sr(String str) {
            this.ux = str;
            return this;
        }

        public C0472c ux(String str) {
            this.f31669f = str;
            return this;
        }

        public C0472c w(String str) {
            this.xv = str;
            return this;
        }

        public C0472c xv(String str) {
            this.sr = str;
            return this;
        }

        public C0472c c(String str) {
            this.f31672w = str;
            return this;
        }

        public C0472c c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.ev = jSONObject;
            return this;
        }

        public void c(com.bytedance.sdk.openadsdk.ux.c.c cVar) {
            this.f31670p = cVar;
            c cVar2 = new c(this);
            try {
                com.bytedance.sdk.openadsdk.ux.c.w wVar = this.gd;
                if (wVar != null) {
                    wVar.c(cVar2.f31667w);
                } else {
                    new com.bytedance.sdk.openadsdk.ux.c.xv().c(cVar2.f31667w);
                }
            } catch (Throwable th) {
                a.xv("AdEvent", th);
            }
            com.bytedance.sdk.openadsdk.core.fz.w.c(cVar2, this.xv);
        }
    }

    c(C0472c c0472c) {
        this.sr = new JSONObject();
        this.f31661c = TextUtils.isEmpty(c0472c.f31668c) ? UUID.randomUUID().toString() : c0472c.f31668c;
        this.f31664p = c0472c.f31670p;
        this.f31663k = c0472c.ux;
        this.ux = c0472c.f31672w;
        this.f31662f = c0472c.xv;
        if (!TextUtils.isEmpty(c0472c.sr)) {
            this.f31665r = c0472c.sr;
        } else {
            this.f31665r = "app_union";
        }
        this.ev = c0472c.f31669f;
        this.gd = c0472c.f31671r;
        this.sr = c0472c.ev = c0472c.ev != null ? c0472c.ev : new JSONObject();
        this.bk = System.currentTimeMillis();
        this.f31667w = new JSONObject();
        try {
            r();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void ev() throws JSONException {
        this.f31667w.putOpt("tag", this.ux);
        this.f31667w.putOpt("label", this.f31662f);
        this.f31667w.putOpt("category", this.f31665r);
        if (!TextUtils.isEmpty(this.ev)) {
            try {
                this.f31667w.putOpt("value", Long.valueOf(Long.parseLong(this.ev)));
            } catch (NumberFormatException unused) {
                this.f31667w.putOpt("value", 0L);
            }
        }
        if (!TextUtils.isEmpty(this.gd)) {
            this.f31667w.putOpt("ext_value", this.gd);
        }
        if (!TextUtils.isEmpty(this.f31663k)) {
            this.f31667w.putOpt("log_extra", this.f31663k);
        }
        this.f31667w.putOpt("is_ad_event", "1");
        this.f31667w.putOpt("nt", Integer.valueOf(ys.xv(ls.getContext())));
        this.f31667w.putOpt("tob_ab_sdk_version", k.sr().ck());
        Iterator<String> keys = this.sr.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.f31667w.putOpt(next, this.sr.opt(next));
        }
    }

    private void r() {
        this.f31660a = xv.incrementAndGet();
    }

    @Override // com.bytedance.sdk.component.r.w.sr.c.w
    public long c() {
        return this.bk;
    }

    public boolean f() {
        JSONObject jSONObject = this.f31667w;
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("label");
        if (TextUtils.isEmpty(optString)) {
            if (TextUtils.isEmpty(this.f31662f)) {
                return false;
            }
            return w.f31761c.contains(this.f31662f);
        }
        return w.f31761c.contains(optString);
    }

    public String sr() {
        return this.f31661c;
    }

    public JSONObject ux() {
        if (this.f31666t.get()) {
            return this.f31667w;
        }
        try {
            ev();
            com.bytedance.sdk.openadsdk.ux.c.c cVar = this.f31664p;
            if (cVar != null) {
                cVar.c(this.f31667w);
            }
            c(this.f31667w);
            this.f31666t.set(true);
        } catch (Throwable th) {
            a.xv("AdEvent", th);
        }
        return this.f31667w;
    }

    @Override // com.bytedance.sdk.component.r.w.sr.c.w
    public long w() {
        return this.f31660a;
    }

    public String xv() {
        if (TextUtils.isEmpty(this.f31662f)) {
            JSONObject jSONObject = this.f31667w;
            return jSONObject != null ? jSONObject.optString("label") : "";
        }
        return this.f31662f;
    }

    @Override // com.bytedance.sdk.component.r.w.sr.c.w
    public JSONObject c(String str) {
        JSONObject jSONObject;
        JSONObject ux = ux();
        try {
            String optString = ux.optString("ad_extra_data");
            if (TextUtils.isEmpty(optString)) {
                jSONObject = new JSONObject();
                if (ls.w().bk() && !TextUtils.isEmpty(str)) {
                    jSONObject.put(EventMonitor.WILL_SAVE_LABELS, str);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (ls.w().bk() && TextUtils.isEmpty(jSONObject2.optString(EventMonitor.WILL_SAVE_LABELS)) && !TextUtils.isEmpty(str)) {
                    jSONObject2.put(EventMonitor.WILL_SAVE_LABELS, str);
                }
                jSONObject = jSONObject2;
            }
            String livePluginVersion = TTLiveCommerceHelper.getInstance().getLivePluginVersion();
            if (livePluginVersion != null) {
                jSONObject.putOpt("live_plugin_version", livePluginVersion.replaceAll("\\.", ""));
            }
            ux.put("ad_extra_data", jSONObject.toString());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return ux;
    }

    private void c(JSONObject jSONObject) {
        try {
            if (this.f31660a != 0) {
                String optString = jSONObject.optString("ad_extra_data");
                int i4 = 1;
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    if (jSONObject2.optInt(EventMonitor.KEY_SDK_EVENT_INDEX) == 0) {
                        jSONObject2.put(EventMonitor.KEY_SDK_EVENT_INDEX, this.f31660a);
                    }
                    if (jSONObject2.optInt(EventMonitor.SDK_EVENT_SELF_COUNT) == 0) {
                        jSONObject2.put(EventMonitor.SDK_EVENT_SELF_COUNT, com.bytedance.sdk.component.r.w.xv.c.c(this.f31662f));
                    }
                    if (!k.sr().j()) {
                        i4 = 0;
                    }
                    jSONObject2.put("csj_type", i4);
                    jSONObject2.put(EventMonitor.KEY_SDK_SESSION_ID, com.bytedance.sdk.openadsdk.core.fz.w.f33686c);
                    if (!TextUtils.isEmpty(wv.gd)) {
                        jSONObject2.put("wrong_stats_url", wv.gd);
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(EventMonitor.KEY_SDK_EVENT_INDEX, this.f31660a);
                jSONObject3.put(EventMonitor.SDK_EVENT_SELF_COUNT, com.bytedance.sdk.component.r.w.xv.c.c(this.f31662f));
                jSONObject3.put(EventMonitor.KEY_SDK_SESSION_ID, com.bytedance.sdk.openadsdk.core.fz.w.f33686c);
                if (!k.sr().j()) {
                    i4 = 0;
                }
                jSONObject3.put("csj_type", i4);
                if (!TextUtils.isEmpty(wv.gd)) {
                    jSONObject3.put("wrong_stats_url", wv.gd);
                }
                jSONObject.put("ad_extra_data", jSONObject3.toString());
            }
        } catch (Exception unused) {
        }
    }
}
