package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.model.C8027b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bk */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9953bk implements InterfaceC10273d<C8027b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C8027b c8027b, JSONObject jSONObject) {
        m27168a(c8027b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C8027b c8027b, JSONObject jSONObject) {
        return m27167b(c8027b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27168a(C8027b c8027b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c8027b.f26767jD = jSONObject.optLong("lastShowCardTimeStamp");
        c8027b.f26768jE = jSONObject.optInt("cardShowCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27167b(C8027b c8027b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c8027b.f26767jD;
        if (j != 0) {
            C11126t.putValue(jSONObject, "lastShowCardTimeStamp", j);
        }
        int i = c8027b.f26768jE;
        if (i != 0) {
            C11126t.putValue(jSONObject, "cardShowCount", i);
        }
        return jSONObject;
    }
}
