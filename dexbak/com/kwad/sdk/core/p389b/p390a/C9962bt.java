package com.kwad.sdk.core.p389b.p390a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.crash.online.monitor.block.C10705d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bt */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9962bt implements InterfaceC10273d<C10705d> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10705d c10705d, JSONObject jSONObject) {
        m27150a(c10705d, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10705d c10705d, JSONObject jSONObject) {
        return m27149b(c10705d, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27150a(C10705d c10705d, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10705d.aGG = jSONObject.optString("printerName");
        if (JSONObject.NULL.toString().equals(c10705d.aGG)) {
            c10705d.aGG = "";
        }
        c10705d.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (JSONObject.NULL.toString().equals(c10705d.errorMsg)) {
            c10705d.errorMsg = "";
        }
        c10705d.aGH = jSONObject.optBoolean("isDisable");
        c10705d.aGI = jSONObject.optBoolean("hasMatrix");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27149b(C10705d c10705d, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10705d.aGG;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "printerName", c10705d.aGG);
        }
        String str2 = c10705d.errorMsg;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, c10705d.errorMsg);
        }
        boolean z = c10705d.aGH;
        if (z) {
            C11126t.putValue(jSONObject, "isDisable", z);
        }
        boolean z2 = c10705d.aGI;
        if (z2) {
            C11126t.putValue(jSONObject, "hasMatrix", z2);
        }
        return jSONObject;
    }
}
