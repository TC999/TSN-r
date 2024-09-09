package com.bytedance.sdk.component.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.AnyThread;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.component.c.r;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    protected Context f29651c;

    /* renamed from: r  reason: collision with root package name */
    r f29653r;
    protected String ux;

    /* renamed from: w  reason: collision with root package name */
    protected bk f29654w;
    protected ev xv;
    protected Handler sr = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    protected volatile boolean f29652f = false;
    private final Map<String, r> ev = new HashMap();

    protected abstract String c();

    protected abstract void c(p pVar);

    @AnyThread
    protected abstract void c(String str);

    protected abstract Context getContext(p pVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeMethod(final String str) {
        if (this.f29652f) {
            return;
        }
        gd.c("Received call: " + str);
        this.sr.post(new Runnable() { // from class: com.bytedance.sdk.component.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f29652f) {
                    return;
                }
                ia iaVar = null;
                try {
                    iaVar = c.this.c(new JSONObject(str));
                } catch (Exception e4) {
                    gd.w("Exception thrown while parsing function.", e4);
                }
                if (ia.c(iaVar)) {
                    gd.c("By pass invalid call: " + iaVar);
                    if (iaVar != null) {
                        c.this.w(gb.c(new fz(iaVar.f29666c, "Failed to parse invocation.")), iaVar);
                        return;
                    }
                    return;
                }
                c.this.c(iaVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        this.f29653r.c();
        for (r rVar : this.ev.values()) {
            rVar.c();
        }
        this.sr.removeCallbacksAndMessages(null);
        this.f29652f = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str, ia iaVar) {
        c(str);
    }

    @MainThread
    protected final void c(ia iaVar) {
        String c4;
        if (this.f29652f || (c4 = c()) == null) {
            return;
        }
        r w3 = w(iaVar.f29668r);
        if (w3 == null) {
            gd.w("Received call with unknown namespace, " + iaVar);
            bk bkVar = this.f29654w;
            if (bkVar != null) {
                bkVar.c(c(), iaVar.sr, 2);
            }
            w(gb.c(new fz(-4, "Namespace " + iaVar.f29668r + " unknown.")), iaVar);
            return;
        }
        f fVar = new f();
        fVar.f29659w = c4;
        fVar.f29658c = this.f29651c;
        fVar.xv = w3;
        try {
            r.c c5 = w3.c(iaVar, fVar);
            if (c5 == null) {
                gd.w("Received call but not registered, " + iaVar);
                bk bkVar2 = this.f29654w;
                if (bkVar2 != null) {
                    bkVar2.c(c(), iaVar.sr, 2);
                }
                w(gb.c(new fz(-2, "Function " + iaVar.sr + " is not registered.")), iaVar);
                return;
            }
            if (c5.f29706c) {
                w(c5.f29707w, iaVar);
            }
            bk bkVar3 = this.f29654w;
            if (bkVar3 != null) {
                bkVar3.c(c(), iaVar.sr);
            }
        } catch (Exception e4) {
            gd.c("call finished with error, " + iaVar, e4);
            w(gb.c(e4), iaVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w(String str, ia iaVar) {
        JSONObject jSONObject;
        if (this.f29652f) {
            return;
        }
        if (TextUtils.isEmpty(iaVar.f29667f)) {
            gd.c("By passing js callback due to empty callback: " + str);
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            gd.c(new IllegalArgumentException("Illegal callback data: " + str));
        }
        gd.c("Invoking js callback: " + iaVar.f29667f);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        c(fp.c().c("__msg_type", "callback").c("__callback_id", iaVar.f29667f).c("__params", jSONObject).w(), iaVar);
    }

    private r w(String str) {
        if (!TextUtils.equals(str, this.ux) && !TextUtils.isEmpty(str)) {
            return this.ev.get(str);
        }
        return this.f29653r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(p pVar, q qVar) {
        this.f29651c = getContext(pVar);
        this.xv = pVar.sr;
        this.f29654w = pVar.gd;
        this.f29653r = new r(pVar, this, qVar);
        this.ux = pVar.f29684k;
        c(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> void c(String str, T t3) {
        if (this.f29652f) {
            return;
        }
        String c4 = this.xv.c((ev) t3);
        gd.c("Sending js event: " + str);
        c("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + c4 + "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ia c(JSONObject jSONObject) {
        if (this.f29652f) {
            return null;
        }
        String optString = jSONObject.optString("__callback_id");
        String optString2 = jSONObject.optString("func");
        String c4 = c();
        if (c4 == null) {
            bk bkVar = this.f29654w;
            if (bkVar != null) {
                bkVar.c(null, null, 3);
            }
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String str = "";
            Object opt = jSONObject.opt(EventMonitor.V3_PARAMS);
            if (opt != null) {
                if (opt instanceof JSONObject) {
                    str = String.valueOf((JSONObject) opt);
                } else if (opt instanceof String) {
                    str = (String) opt;
                } else {
                    str = String.valueOf(opt);
                }
            }
            String string2 = jSONObject.getString("JSSDK");
            String optString3 = jSONObject.optString("namespace");
            return ia.c().c(string2).w(string).xv(optString2).sr(str).ux(optString).f(optString3).r(jSONObject.optString("__iframe_url")).c();
        } catch (JSONException e4) {
            gd.w("Failed to create call.", e4);
            bk bkVar2 = this.f29654w;
            if (bkVar2 != null) {
                bkVar2.c(c4, optString2, 1);
            }
            return ia.c(optString, -1);
        }
    }
}
