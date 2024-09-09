package com.bytedance.msdk.core.f;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.c.xv;
import com.bytedance.msdk.adapter.sr.sr;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, com.bytedance.msdk.api.sr.c.w.f.c> f27925c = new ConcurrentHashMap();

    public void c(String str, com.bytedance.msdk.api.sr.c.w.f.c cVar) {
        this.f27925c.put(str, cVar);
    }

    public Map<String, Object> w(Context context, Map<String, Object> map, String str) {
        sr.c(context);
        com.bytedance.msdk.api.sr.c.w.f.c c4 = c(str);
        if (c4 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("buyerId", c4.c(context, map));
            hashMap.put("sdkInfo", c4.w(context, map));
            return hashMap;
        }
        xv w3 = w(str);
        if (w3 == null) {
            return null;
        }
        return w3.w(context, map);
    }

    public com.bytedance.msdk.api.sr.c.w.f.c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f27925c.get(str);
    }

    public String c(Context context, Map<String, Object> map, String str) {
        sr.c(context);
        com.bytedance.msdk.api.sr.c.w.f.c c4 = c(str);
        if (c4 != null) {
            return c4.c(null, null);
        }
        xv w3 = w(str);
        if (w3 == null) {
            return null;
        }
        return w3.c(context, map);
    }

    public xv w(String str) {
        return com.bytedance.msdk.sr.w.w.c().c(str);
    }
}
