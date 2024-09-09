package com.bytedance.sdk.openadsdk.core.w.c.c;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class xv {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Integer, w> f35298c = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    private static final Map<Integer, Class> f35299w;

    static {
        HashMap hashMap = new HashMap();
        f35299w = hashMap;
        hashMap.put(-1, w.class);
        hashMap.put(4, r.class);
        hashMap.put(5, f.class);
        hashMap.put(3, ev.class);
        hashMap.put(2, c.class);
    }

    public static w c(me meVar, Context context) {
        return c(meVar, context, 0);
    }

    private static w w(me meVar, Context context) {
        Map<Integer, w> map = f35298c;
        map.put(-1, new w());
        map.put(4, new r());
        map.put(5, new f());
        map.put(3, new ev());
        map.put(2, new c());
        if (meVar == null) {
            return new w();
        }
        w wVar = map.get(Integer.valueOf(meVar.v()));
        if (wVar == null) {
            return new w();
        }
        wVar.c(meVar);
        wVar.c(context);
        return wVar;
    }

    public static w c(me meVar, Context context, int i4) {
        if (meVar == null) {
            return w(null, context);
        }
        Map<Integer, Class> map = f35299w;
        Class cls = map.get(Integer.valueOf(i4));
        if (cls == null) {
            cls = map.get(Integer.valueOf(meVar.v()));
        }
        try {
            w wVar = (w) cls.newInstance();
            wVar.c(meVar);
            wVar.c(context);
            return wVar;
        } catch (Throwable unused) {
            return w(meVar, context);
        }
    }
}
