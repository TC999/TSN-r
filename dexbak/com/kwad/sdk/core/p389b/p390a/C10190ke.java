package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ke */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10190ke implements InterfaceC10273d<BlockEvent.C10699a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(BlockEvent.C10699a c10699a, JSONObject jSONObject) {
        m26708a(c10699a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(BlockEvent.C10699a c10699a, JSONObject jSONObject) {
        return m26707b(c10699a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26708a(BlockEvent.C10699a c10699a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10699a.aGy = jSONObject.optLong("endTimestamp");
        c10699a.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        c10699a.aGz = jSONObject.optBoolean("runIdle");
        c10699a.aGA = jSONObject.optString("stackTraceDetail");
        if (JSONObject.NULL.toString().equals(c10699a.aGA)) {
            c10699a.aGA = "";
        }
        c10699a.aGB = jSONObject.optLong("startTimestamp");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26707b(BlockEvent.C10699a c10699a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c10699a.aGy;
        if (j != 0) {
            C11126t.putValue(jSONObject, "endTimestamp", j);
        }
        C11126t.putValue(jSONObject, "repeatCount", c10699a.repeatCount);
        boolean z = c10699a.aGz;
        if (z) {
            C11126t.putValue(jSONObject, "runIdle", z);
        }
        String str = c10699a.aGA;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "stackTraceDetail", c10699a.aGA);
        }
        long j2 = c10699a.aGB;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "startTimestamp", j2);
        }
        return jSONObject;
    }
}
