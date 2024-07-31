package com.kwad.sdk.core.p389b.p390a;

import androidx.core.app.NotificationCompat;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.components.core.webview.jshandler.C9085an;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10067fq implements InterfaceC10273d<C9085an.C9088b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9085an.C9088b c9088b, JSONObject jSONObject) {
        m26954a(c9088b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9085an.C9088b c9088b, JSONObject jSONObject) {
        return m26953b(c9088b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26954a(C9085an.C9088b c9088b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9088b.f29179XI = jSONObject.optDouble(NotificationCompat.CATEGORY_PROGRESS);
        c9088b.status = jSONObject.optInt("status");
        c9088b.totalBytes = jSONObject.optLong("totalBytes");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26953b(C9085an.C9088b c9088b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = c9088b.f29179XI;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, d);
        }
        int i = c9088b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        long j = c9088b.totalBytes;
        if (j != 0) {
            C11126t.putValue(jSONObject, "totalBytes", j);
        }
        return jSONObject;
    }
}
