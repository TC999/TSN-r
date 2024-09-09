package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ke implements com.kwad.sdk.core.d<BlockEvent.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aGy = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.aGz = jSONObject.optBoolean("runIdle");
        aVar.aGA = jSONObject.optString("stackTraceDetail");
        if (JSONObject.NULL.toString().equals(aVar.aGA)) {
            aVar.aGA = "";
        }
        aVar.aGB = jSONObject.optLong("startTimestamp");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = aVar.aGy;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "endTimestamp", j4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        boolean z3 = aVar.aGz;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "runIdle", z3);
        }
        String str = aVar.aGA;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "stackTraceDetail", aVar.aGA);
        }
        long j5 = aVar.aGB;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "startTimestamp", j5);
        }
        return jSONObject;
    }
}
