package com.kwad.sdk.collector.p370a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.collector.model.InterfaceC9811e;
import com.kwad.sdk.core.network.AbstractC10418d;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.collector.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9784b extends AbstractC10418d {
    public C9784b(Collection<InterfaceC9811e> collection) {
        putBody("collectData", m27781a(collection));
        putBody("collectType", 1);
        putBody("sdkVersion", BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    /* renamed from: a */
    private static JSONArray m27781a(Collection<InterfaceC9811e> collection) {
        JSONArray jSONArray = new JSONArray();
        for (InterfaceC9811e interfaceC9811e : collection) {
            JSONObject mo27721AC = interfaceC9811e.mo27721AC();
            if (mo27721AC != null) {
                jSONArray.put(mo27721AC);
            }
        }
        return jSONArray;
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final String getUrl() {
        return C10760g.m24885yf();
    }
}
