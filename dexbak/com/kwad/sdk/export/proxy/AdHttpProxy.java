package com.kwad.sdk.export.proxy;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.C10415c;
import java.io.OutputStream;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface AdHttpProxy {
    C10415c doGet(String str, Map<String, String> map);

    C10415c doGetWithoutResponse(String str, Map<String, String> map);

    C10415c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder);

    C10415c doPost(String str, Map<String, String> map, Map<String, String> map2);

    C10415c doPost(String str, Map<String, String> map, JSONObject jSONObject);

    boolean downloadUrlToStream(String str, OutputStream outputStream, long j, @Nullable AdHttpResponseListener adHttpResponseListener);
}
