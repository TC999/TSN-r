package com.kwad.sdk.core.network.p406c;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.core.network.p404a.C10407c;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import java.io.OutputStream;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.network.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10417b implements AdHttpProxy {
    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final C10415c doGet(String str, Map<String, String> map) {
        return C10407c.doGet(str, map);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final C10415c doGetWithoutResponse(String str, Map<String, String> map) {
        return C10407c.m26163a(str, map, false);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final C10415c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return C10407c.doPost(str, map, jSONObject);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final boolean downloadUrlToStream(String str, OutputStream outputStream, long j, @Nullable AdHttpResponseListener adHttpResponseListener) {
        return C10407c.downloadUrlToStream(str, outputStream, j, adHttpResponseListener);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final C10415c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        return C10407c.doPost(str, map, map2);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final C10415c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        return C10407c.doPost(str, map, adHttpBodyBuilder);
    }
}
