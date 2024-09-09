package com.bytedance.adsdk.w.w.w.c;

import com.bytedance.adsdk.w.w.sr.xv;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d extends j {
    public d() {
        super(xv.LT_EQ);
    }

    public Object c(Map<String, JSONObject> map) {
        Object c4;
        Object c5 = this.f26454a.c(map);
        if (c5 == null || (c4 = this.f26455b.c(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) q0.h.e((Number) c5, (Number) c4)).booleanValue());
    }
}
