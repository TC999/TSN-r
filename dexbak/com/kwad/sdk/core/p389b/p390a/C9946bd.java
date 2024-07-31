package com.kwad.sdk.core.p389b.p390a;

import androidx.core.app.NotificationCompat;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.components.core.webview.jshandler.C9098as;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9946bd implements InterfaceC10273d<C9098as.C9100a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9098as.C9100a c9100a, JSONObject jSONObject) {
        m27182a(c9100a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9098as.C9100a c9100a, JSONObject jSONObject) {
        return m27181b(c9100a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27182a(C9098as.C9100a c9100a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9100a.f29194XI = jSONObject.optDouble(NotificationCompat.CATEGORY_PROGRESS);
        c9100a.status = jSONObject.optInt("status");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27181b(C9098as.C9100a c9100a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = c9100a.f29194XI;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, d);
        }
        int i = c9100a.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        return jSONObject;
    }
}
