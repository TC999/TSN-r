package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.SDKInitMsg;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class il implements com.kwad.sdk.core.d<SDKInitMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        a2(sDKInitMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        return b2(sDKInitMsg, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
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
    private static JSONObject b2(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = sDKInitMsg.launchIntervalTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_launch_interval_time", j4);
        }
        long j5 = sDKInitMsg.totalDurationTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_total_duration_time", j5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "init_status", sDKInitMsg.initStatus);
        String str = sDKInitMsg.errorReason;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_reason", sDKInitMsg.errorReason);
        }
        int i4 = sDKInitMsg.initCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_count", i4);
        }
        int i5 = sDKInitMsg.initProcess;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_process", i5);
        }
        int i6 = sDKInitMsg.initThread;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_thread", i6);
        }
        int i7 = sDKInitMsg.intDynamicSDK;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_dynamic_sdk", i7);
        }
        int i8 = sDKInitMsg.intBuildNumber;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_build_number", i8);
        }
        return jSONObject;
    }
}
