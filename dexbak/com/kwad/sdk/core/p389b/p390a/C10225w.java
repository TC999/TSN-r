package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.w */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10225w implements InterfaceC10273d<AdInfo.AdInsertScreenInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        m26638a(adInsertScreenInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        return m26637b(adInsertScreenInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26638a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInsertScreenInfo.cycleAggregateSwitch = jSONObject.optBoolean("cycleAggregateSwitch");
        adInsertScreenInfo.cycleAggregateDailyShowCount = jSONObject.optInt("cycleAggregateDailyShowCount", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
        adInsertScreenInfo.cycleAggregateStyle = jSONObject.optInt("cycleAggregateStyle");
        adInsertScreenInfo.cycleAggregateInterval = jSONObject.optInt("cycleAggregateInterval", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
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
    private static JSONObject m26637b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = adInsertScreenInfo.cycleAggregateSwitch;
        if (z) {
            C11126t.putValue(jSONObject, "cycleAggregateSwitch", z);
        }
        C11126t.putValue(jSONObject, "cycleAggregateDailyShowCount", adInsertScreenInfo.cycleAggregateDailyShowCount);
        int i = adInsertScreenInfo.cycleAggregateStyle;
        if (i != 0) {
            C11126t.putValue(jSONObject, "cycleAggregateStyle", i);
        }
        C11126t.putValue(jSONObject, "cycleAggregateInterval", adInsertScreenInfo.cycleAggregateInterval);
        int i2 = adInsertScreenInfo.autoCloseTime;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "autoCloseTime", i2);
        }
        int i3 = adInsertScreenInfo.retainWindowStyle;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "retainWindowStyle", i3);
        }
        String str = adInsertScreenInfo.retainWindowText;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "retainWindowText", adInsertScreenInfo.retainWindowText);
        }
        int i4 = adInsertScreenInfo.retainWindowBasedAdShowCount;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "retainWindowBasedAdShowCount", i4);
        }
        int i5 = adInsertScreenInfo.retainWindowDailyShowCount;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "retainWindowDailyShowCount", i5);
        }
        return jSONObject;
    }
}
