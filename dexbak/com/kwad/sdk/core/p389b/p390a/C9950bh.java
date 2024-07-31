package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p333a.C9232x;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bh */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9950bh implements InterfaceC10273d<C9232x.C9234a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9232x.C9234a c9234a, JSONObject jSONObject) {
        m27174a(c9234a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9232x.C9234a c9234a, JSONObject jSONObject) {
        return m27173b(c9234a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27174a(C9232x.C9234a c9234a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9234a.f29312ZZ = jSONObject.optBoolean("hasLoseAudioFocus");
        c9234a.aaa = jSONObject.optInt("audioFocusStatus");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27173b(C9232x.C9234a c9234a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = c9234a.f29312ZZ;
        if (z) {
            C11126t.putValue(jSONObject, "hasLoseAudioFocus", z);
        }
        int i = c9234a.aaa;
        if (i != 0) {
            C11126t.putValue(jSONObject, "audioFocusStatus", i);
        }
        return jSONObject;
    }
}
