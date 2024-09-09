package com.bytedance.adsdk.w.w.w.c;

import com.bytedance.adsdk.w.w.sr.xv;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class q extends j {
    public q() {
        super(xv.NOT_EQ);
    }

    public Object c(Map<String, JSONObject> map) {
        Object c4 = this.f26454a.c(map);
        Object c5 = this.f26455b.c(map);
        if (c4 == null && c5 == null) {
            return Boolean.FALSE;
        }
        if (c4 != null || c5 == null) {
            if (c4 != null && c5 == null) {
                return Boolean.TRUE;
            }
            if ((c4 instanceof Number) && (c5 instanceof Number)) {
                return Boolean.valueOf(!q0.g.e((Number) c4, (Number) c5));
            }
            return Boolean.valueOf(!c4.equals(c5));
        }
        return Boolean.TRUE;
    }
}
