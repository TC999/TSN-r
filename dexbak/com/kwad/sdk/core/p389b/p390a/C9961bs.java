package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.utils.C11126t;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bs */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9961bs implements InterfaceC10273d<BlockEvent> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(BlockEvent blockEvent, JSONObject jSONObject) {
        m27152a(blockEvent, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(BlockEvent blockEvent, JSONObject jSONObject) {
        return m27151b(blockEvent, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27152a(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        blockEvent.blockDuration = jSONObject.optLong("blockDuration");
        blockEvent.blockTimeThreshold = jSONObject.optLong("blockTimeThreshold", new Long(Constants.DEFAULT_UIN).longValue());
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
            for (int i = 0; i < optJSONArray.length(); i++) {
                BlockEvent.C10699a c10699a = new BlockEvent.C10699a();
                c10699a.parseJson(optJSONArray.optJSONObject(i));
                blockEvent.stackTraceSample.add(c10699a);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27151b(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = blockEvent.blockDuration;
        if (j != 0) {
            C11126t.putValue(jSONObject, "blockDuration", j);
        }
        C11126t.putValue(jSONObject, "blockTimeThreshold", blockEvent.blockTimeThreshold);
        C11126t.putValue(jSONObject, "blockLoopInterval", blockEvent.blockLoopInterval);
        long j2 = blockEvent.calcBlockOverhead;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "calcBlockOverhead", j2);
        }
        String str = blockEvent.currentActivity;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "currentActivity", blockEvent.currentActivity);
        }
        String str2 = blockEvent.processName;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "processName", blockEvent.processName);
        }
        C11126t.putValue(jSONObject, "stackTraceSample", blockEvent.stackTraceSample);
        return jSONObject;
    }
}
