package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bs implements com.kwad.sdk.core.d<BlockEvent> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent blockEvent, JSONObject jSONObject) {
        a2(blockEvent, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent blockEvent, JSONObject jSONObject) {
        return b2(blockEvent, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        blockEvent.blockDuration = jSONObject.optLong("blockDuration");
        blockEvent.blockTimeThreshold = jSONObject.optLong("blockTimeThreshold", new Long("1000").longValue());
        blockEvent.blockLoopInterval = jSONObject.optLong("blockLoopInterval", new Long("100").longValue());
        blockEvent.calcBlockOverhead = jSONObject.optLong("calcBlockOverhead");
        blockEvent.currentActivity = jSONObject.optString("currentActivity");
        if (JSONObject.NULL.toString().equals(blockEvent.currentActivity)) {
            blockEvent.currentActivity = "";
        }
        blockEvent.processName = jSONObject.optString("processName");
        if (JSONObject.NULL.toString().equals(blockEvent.processName)) {
            blockEvent.processName = "";
        }
        blockEvent.stackTraceSample = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("stackTraceSample");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                BlockEvent.a aVar = new BlockEvent.a();
                aVar.parseJson(optJSONArray.optJSONObject(i4));
                blockEvent.stackTraceSample.add(aVar);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = blockEvent.blockDuration;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockDuration", j4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "blockTimeThreshold", blockEvent.blockTimeThreshold);
        com.kwad.sdk.utils.t.putValue(jSONObject, "blockLoopInterval", blockEvent.blockLoopInterval);
        long j5 = blockEvent.calcBlockOverhead;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "calcBlockOverhead", j5);
        }
        String str = blockEvent.currentActivity;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentActivity", blockEvent.currentActivity);
        }
        String str2 = blockEvent.processName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "processName", blockEvent.processName);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "stackTraceSample", blockEvent.stackTraceSample);
        return jSONObject;
    }
}
