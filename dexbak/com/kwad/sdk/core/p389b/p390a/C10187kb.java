package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.threads.C10511b;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10187kb implements InterfaceC10273d<C10511b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10511b c10511b, JSONObject jSONObject) {
        m26714a(c10511b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10511b c10511b, JSONObject jSONObject) {
        return m26713b(c10511b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26714a(C10511b c10511b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10511b.aAC = jSONObject.optString("pool_name");
        if (JSONObject.NULL.toString().equals(c10511b.aAC)) {
            c10511b.aAC = "";
        }
        c10511b.aAD = jSONObject.optInt("core_pool_size");
        c10511b.aAE = jSONObject.optInt("max_pool_size");
        c10511b.aAF = jSONObject.optInt("current_pool_size");
        c10511b.aAG = jSONObject.optInt("active_count");
        c10511b.aAH = jSONObject.optLong("task_wait_avg_ms");
        c10511b.aAI = jSONObject.optLong("task_succ_count");
        c10511b.interval = jSONObject.optLong("interval_ms");
        c10511b.aAJ = jSONObject.optInt("queue_size");
        c10511b.aAK = jSONObject.optLong("pass_timestamp");
        c10511b.aAL = jSONObject.optInt("func_ratio_count");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26713b(C10511b c10511b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10511b.aAC;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "pool_name", c10511b.aAC);
        }
        int i = c10511b.aAD;
        if (i != 0) {
            C11126t.putValue(jSONObject, "core_pool_size", i);
        }
        int i2 = c10511b.aAE;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "max_pool_size", i2);
        }
        int i3 = c10511b.aAF;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "current_pool_size", i3);
        }
        int i4 = c10511b.aAG;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "active_count", i4);
        }
        long j = c10511b.aAH;
        if (j != 0) {
            C11126t.putValue(jSONObject, "task_wait_avg_ms", j);
        }
        long j2 = c10511b.aAI;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "task_succ_count", j2);
        }
        long j3 = c10511b.interval;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "interval_ms", j3);
        }
        int i5 = c10511b.aAJ;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "queue_size", i5);
        }
        long j4 = c10511b.aAK;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "pass_timestamp", j4);
        }
        int i6 = c10511b.aAL;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "func_ratio_count", i6);
        }
        return jSONObject;
    }
}
