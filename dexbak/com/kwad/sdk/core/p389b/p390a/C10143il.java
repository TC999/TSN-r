package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.il */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10143il implements InterfaceC10273d<SDKInitMsg> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        m26802a(sDKInitMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        return m26801b(sDKInitMsg, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26802a(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sDKInitMsg.launchIntervalTime = jSONObject.optLong("init_launch_interval_time");
        sDKInitMsg.totalDurationTime = jSONObject.optLong("init_total_duration_time");
        sDKInitMsg.initStatus = jSONObject.optInt("init_status", new Integer("0").intValue());
        sDKInitMsg.errorReason = jSONObject.optString("error_reason");
        if (JSONObject.NULL.toString().equals(sDKInitMsg.errorReason)) {
            sDKInitMsg.errorReason = "";
        }
        sDKInitMsg.initCount = jSONObject.optInt("init_count");
        sDKInitMsg.initProcess = jSONObject.optInt("init_process");
        sDKInitMsg.initThread = jSONObject.optInt("init_thread");
        sDKInitMsg.intDynamicSDK = jSONObject.optInt("init_dynamic_sdk");
        sDKInitMsg.intBuildNumber = jSONObject.optInt("init_build_number");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26801b(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = sDKInitMsg.launchIntervalTime;
        if (j != 0) {
            C11126t.putValue(jSONObject, "init_launch_interval_time", j);
        }
        long j2 = sDKInitMsg.totalDurationTime;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "init_total_duration_time", j2);
        }
        C11126t.putValue(jSONObject, "init_status", sDKInitMsg.initStatus);
        String str = sDKInitMsg.errorReason;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "error_reason", sDKInitMsg.errorReason);
        }
        int i = sDKInitMsg.initCount;
        if (i != 0) {
            C11126t.putValue(jSONObject, "init_count", i);
        }
        int i2 = sDKInitMsg.initProcess;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "init_process", i2);
        }
        int i3 = sDKInitMsg.initThread;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "init_thread", i3);
        }
        int i4 = sDKInitMsg.intDynamicSDK;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "init_dynamic_sdk", i4);
        }
        int i5 = sDKInitMsg.intBuildNumber;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "init_build_number", i5);
        }
        return jSONObject;
    }
}
