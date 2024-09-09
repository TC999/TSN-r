package com.kwad.sdk.core.network.idc;

import android.content.Context;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static void a(Context context, com.kwad.sdk.core.network.idc.a.b bVar) {
        y.a(context, "ksadsdk_idc", "idc_data", bVar == null ? "" : bVar.toJson().toString());
    }

    public static com.kwad.sdk.core.network.idc.a.b aZ(Context context) {
        try {
            return com.kwad.sdk.core.network.idc.a.b.dW(h.J(context, "ksad_idc.json"));
        } catch (IOException e4) {
            c.printStackTraceOnly(e4);
            return new com.kwad.sdk.core.network.idc.a.b();
        }
    }

    public static com.kwad.sdk.core.network.idc.a.b ba(Context context) {
        return com.kwad.sdk.core.network.idc.a.b.dW(y.b(context, "ksadsdk_idc", "idc_data", ""));
    }

    public static Map<String, String> bb(Context context) {
        return t.parseJSON2MapString(y.b(context, "ksadsdk_idc", "idc_current", ""));
    }

    public static void a(Context context, Map<String, String> map) {
        y.a(context, "ksadsdk_idc", "idc_current", (map == null || map.isEmpty()) ? "" : new JSONObject(map).toString());
    }
}
