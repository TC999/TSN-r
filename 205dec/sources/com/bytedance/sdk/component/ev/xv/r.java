package com.bytedance.sdk.component.ev.xv;

import android.content.Context;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static volatile r f29764c;

    /* renamed from: w  reason: collision with root package name */
    private static HashMap<Integer, ux> f29765w;
    private static HashMap<Integer, c> xv;

    private r() {
        f29765w = new HashMap<>();
        xv = new HashMap<>();
    }

    public static synchronized r c() {
        r rVar;
        synchronized (r.class) {
            if (f29764c == null) {
                synchronized (r.class) {
                    if (f29764c == null) {
                        f29764c = new r();
                    }
                }
            }
            rVar = f29764c;
        }
        return rVar;
    }

    public ux c(int i4) {
        ux uxVar = f29765w.get(Integer.valueOf(i4));
        if (uxVar == null) {
            ux uxVar2 = new ux(i4);
            f29765w.put(Integer.valueOf(i4), uxVar2);
            return uxVar2;
        }
        return uxVar;
    }

    public c c(int i4, Context context) {
        c cVar = xv.get(Integer.valueOf(i4));
        if (cVar == null) {
            c cVar2 = new c(context, i4);
            xv.put(Integer.valueOf(i4), cVar2);
            return cVar2;
        }
        return cVar;
    }
}
