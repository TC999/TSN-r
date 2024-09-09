package com.bytedance.sdk.openadsdk.core.fz;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements com.bytedance.sdk.component.r.c.sr {
    @Override // com.bytedance.sdk.component.r.c.sr
    public com.bytedance.sdk.component.r.c.ev a() {
        return c.f33662c;
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public void bk() {
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public com.bytedance.sdk.component.r.c.w c(JSONObject jSONObject) {
        try {
            jSONObject.put("is_new", true);
            jSONObject.put(EventMonitor.KEY_SDK_SESSION_ID, w.f33686c);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        com.bytedance.sdk.component.r.w.sr.c.c cVar = new com.bytedance.sdk.component.r.w.sr.c.c(UUID.randomUUID().toString(), com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("new_adlog_monitor").w(jSONObject.toString()).c());
        cVar.xv((byte) 0);
        cVar.w((byte) 2);
        cVar.c((byte) 1);
        return cVar;
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public void c(boolean z3) {
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public void c(boolean z3, int i4, String str, String str2, long j4) {
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public boolean f() {
        return true;
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    /* renamed from: fp */
    public ExecutorService ev() {
        return com.bytedance.sdk.component.gd.ev.w();
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public Executor gd() {
        return com.bytedance.sdk.component.gd.ev.c();
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public com.bytedance.sdk.component.r.w.xv k() {
        return null;
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public int p() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public com.bytedance.sdk.component.r.c.c.w r() {
        return new ev(com.bytedance.sdk.openadsdk.core.q.ux.c().w().xv());
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public boolean sr() {
        return com.bytedance.sdk.openadsdk.core.z.f.c();
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public boolean t() {
        return false;
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public String ux() {
        return wv.f();
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public String w() {
        return "csj_";
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public String w(String str) {
        return com.bytedance.sdk.component.utils.c.w(str);
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public boolean xv() {
        return true;
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public boolean ys() {
        return ls.w().bk();
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public boolean c(Context context) {
        return ys.c(context);
    }

    @Override // com.bytedance.sdk.component.r.c.sr
    public String c(String str) {
        return com.bytedance.sdk.component.utils.c.xv(str);
    }
}
