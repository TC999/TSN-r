package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.request.model.C10480f;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10181jw implements InterfaceC10273d<C10480f> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10480f c10480f, JSONObject jSONObject) {
        m26726a(c10480f, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10480f c10480f, JSONObject jSONObject) {
        return m26725b(c10480f, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26726a(C10480f c10480f, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10480f.adStyle = jSONObject.optInt("adStyle");
        c10480f.taskType = jSONObject.optInt("taskType");
        c10480f.count = jSONObject.optInt("count");
        c10480f.azP = jSONObject.optLong("lastModifiedTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26725b(C10480f c10480f, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c10480f.adStyle;
        if (i != 0) {
            C11126t.putValue(jSONObject, "adStyle", i);
        }
        int i2 = c10480f.taskType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "taskType", i2);
        }
        int i3 = c10480f.count;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "count", i3);
        }
        long j = c10480f.azP;
        if (j != 0) {
            C11126t.putValue(jSONObject, "lastModifiedTime", j);
        }
        return jSONObject;
    }
}
