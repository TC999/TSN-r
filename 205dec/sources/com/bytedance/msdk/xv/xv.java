package com.bytedance.msdk.xv;

import android.content.Context;
import android.util.Log;
import com.bytedance.msdk.f.eq;
import com.bytedance.msdk.xv.w;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f28589c;

    /* renamed from: w  reason: collision with root package name */
    private static final AtomicLong f28590w = new AtomicLong(0);

    public static void c() {
        f28589c = true;
        c(com.bytedance.msdk.core.c.getContext());
    }

    public static boolean w() {
        return f28589c;
    }

    public static void c(Context context, sr srVar, Map<String, Object> map) {
        if (com.bytedance.msdk.core.c.w().p()) {
            Context context2 = context == null ? com.bytedance.msdk.core.c.getContext() : context;
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException unused) {
                }
            }
            jSONObject.put("eventIndex", f28590w.getAndIncrement());
            jSONObject.put("is_main_process", eq.c(context));
            if (com.bytedance.msdk.core.w.k().gd()) {
                jSONObject.put("e2e_test_flag", "1");
            }
            if (srVar != null) {
                srVar.c("event_id", UUID.randomUUID().toString());
            }
            JSONObject c4 = c.c(context2, srVar, jSONObject);
            if (!f28589c) {
                Log.d("TTMediationSDK", "--==-- event \u8fd8\u672a\u8fdb\u884csdk\u521d\u59cb\u5316");
                w.c().c(srVar, c4);
                return;
            }
            c(context2, srVar, c4);
        }
    }

    private static void c(Context context) {
        try {
            List<w.c> w3 = w.c().w();
            if (w3 != null) {
                for (w.c cVar : w3) {
                    if (cVar != null) {
                        c(context, cVar.c(), cVar.w());
                    }
                }
            }
            w.c().xv();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void c(Context context, sr srVar, JSONObject jSONObject) {
        p.c(context, srVar, jSONObject);
    }
}
