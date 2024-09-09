package com.qq.e.comm.plugin.n0.w;

import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends com.qq.e.comm.plugin.n0.c {
    public e(com.qq.e.comm.plugin.n0.c cVar) {
        super(cVar);
        a("wv_progress", (Object) 1);
        a("is_offline", (Object) 2);
    }

    public e a(long j4) {
        a("cost_time", Long.valueOf(j4));
        return this;
    }

    public e b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return this;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            a(next, jSONObject.opt(next));
        }
        return this;
    }

    public e c(int i4) {
        a("js_inject_scene", Integer.valueOf(i4));
        return this;
    }

    public e d(int i4) {
        a("origin_error_code", Integer.valueOf(i4));
        return this;
    }

    public e e(int i4) {
        a("lp_type", Integer.valueOf(i4));
        return this;
    }

    public e f(int i4) {
        a("click_req_type", Integer.valueOf(i4));
        return this;
    }
}
