package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class w implements com.kwad.sdk.core.d<AdInfo.AdInsertScreenInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        a2(adInsertScreenInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        return b2(adInsertScreenInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInsertScreenInfo.cycleAggregateSwitch = jSONObject.optBoolean("cycleAggregateSwitch");
        adInsertScreenInfo.cycleAggregateDailyShowCount = jSONObject.optInt("cycleAggregateDailyShowCount", new Integer("10").intValue());
        adInsertScreenInfo.cycleAggregateStyle = jSONObject.optInt("cycleAggregateStyle");
        adInsertScreenInfo.cycleAggregateInterval = jSONObject.optInt("cycleAggregateInterval", new Integer("10").intValue());
        adInsertScreenInfo.autoCloseTime = jSONObject.optInt("autoCloseTime");
        adInsertScreenInfo.retainWindowStyle = jSONObject.optInt("retainWindowStyle");
        adInsertScreenInfo.retainWindowText = jSONObject.optString("retainWindowText");
        if (JSONObject.NULL.toString().equals(adInsertScreenInfo.retainWindowText)) {
            adInsertScreenInfo.retainWindowText = "";
        }
        adInsertScreenInfo.retainWindowBasedAdShowCount = jSONObject.optInt("retainWindowBasedAdShowCount");
        adInsertScreenInfo.retainWindowDailyShowCount = jSONObject.optInt("retainWindowDailyShowCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = adInsertScreenInfo.cycleAggregateSwitch;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateSwitch", z3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateDailyShowCount", adInsertScreenInfo.cycleAggregateDailyShowCount);
        int i4 = adInsertScreenInfo.cycleAggregateStyle;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateStyle", i4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateInterval", adInsertScreenInfo.cycleAggregateInterval);
        int i5 = adInsertScreenInfo.autoCloseTime;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "autoCloseTime", i5);
        }
        int i6 = adInsertScreenInfo.retainWindowStyle;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowStyle", i6);
        }
        String str = adInsertScreenInfo.retainWindowText;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowText", adInsertScreenInfo.retainWindowText);
        }
        int i7 = adInsertScreenInfo.retainWindowBasedAdShowCount;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowBasedAdShowCount", i7);
        }
        int i8 = adInsertScreenInfo.retainWindowDailyShowCount;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowDailyShowCount", i8);
        }
        return jSONObject;
    }
}
