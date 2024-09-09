package com.bytedance.sdk.openadsdk.core.w.c.xv;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends w {
    private Double ev;

    /* renamed from: f  reason: collision with root package name */
    private String f35360f;

    /* renamed from: r  reason: collision with root package name */
    private Map<String, Object> f35361r;
    c ux;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        boolean c();
    }

    public sr() {
    }

    public void c(c cVar) {
        this.ux = cVar;
    }

    public void w(Map<String, Object> map) {
        Map<String, Object> map2 = this.f35361r;
        if (map2 == null) {
            this.f35361r = map;
        } else {
            map2.putAll(map);
        }
    }

    public sr(me meVar, Context context) {
        this.f35278c = meVar;
        this.f35279w = context;
        this.f35361r = new HashMap();
    }

    public void c(String str) {
        this.f35360f = str;
    }

    public void c(Double d4) {
        this.ev = d4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.xv.w, com.bytedance.sdk.openadsdk.core.w.c.c
    public boolean c(Map<String, Object> map) {
        c cVar;
        me meVar = this.f35278c;
        if (meVar == null || meVar.of() == 0 || (cVar = this.ux) == null || cVar.c()) {
            return false;
        }
        this.f35361r.put("show_send_type", 1);
        com.bytedance.sdk.openadsdk.core.a.xv.c(this.f35278c, this.f35360f, this.f35361r, this.ev);
        return false;
    }
}
