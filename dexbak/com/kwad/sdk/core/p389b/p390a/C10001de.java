package com.kwad.sdk.core.p389b.p390a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.p332a.C9006a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.de */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10001de implements InterfaceC10273d<C9006a.C9010b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9006a.C9010b c9010b, JSONObject jSONObject) {
        m27080a(c9010b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9006a.C9010b c9010b, JSONObject jSONObject) {
        return m27079b(c9010b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27080a(C9006a.C9010b c9010b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9010b.status = jSONObject.optInt("status");
        c9010b.progress = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27079b(C9006a.C9010b c9010b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9010b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        int i2 = c9010b.progress;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, i2);
        }
        return jSONObject;
    }
}
