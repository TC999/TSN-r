package com.kwad.sdk.core.p389b.p390a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.C9157k;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ff */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10056ff implements InterfaceC10273d<C9157k.C9160b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9157k.C9160b c9160b, JSONObject jSONObject) {
        m26976a(c9160b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9157k.C9160b c9160b, JSONObject jSONObject) {
        return m26975b(c9160b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26976a(C9157k.C9160b c9160b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9160b.status = jSONObject.optInt("status");
        c9160b.progress = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26975b(C9157k.C9160b c9160b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9160b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        int i2 = c9160b.progress;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, i2);
        }
        return jSONObject;
    }
}
