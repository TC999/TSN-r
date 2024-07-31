package com.kwad.sdk.core.network.idc;

import android.content.Context;
import com.kwad.sdk.core.network.idc.p407a.C10432b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10747h;
import com.kwad.sdk.utils.C11126t;
import com.kwad.sdk.utils.C11137y;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.network.idc.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10433b {
    /* renamed from: a */
    public static void m26073a(Context context, C10432b c10432b) {
        C11137y.m23614a(context, "ksadsdk_idc", "idc_data", c10432b == null ? "" : c10432b.toJson().toString());
    }

    /* renamed from: aZ */
    public static C10432b m26071aZ(Context context) {
        try {
            return C10432b.m26074dW(C10747h.m24956J(context, "ksad_idc.json"));
        } catch (IOException e) {
            C10331c.printStackTraceOnly(e);
            return new C10432b();
        }
    }

    /* renamed from: ba */
    public static C10432b m26070ba(Context context) {
        return C10432b.m26074dW(C11137y.m23592b(context, "ksadsdk_idc", "idc_data", ""));
    }

    /* renamed from: bb */
    public static Map<String, String> m26069bb(Context context) {
        return C11126t.parseJSON2MapString(C11137y.m23592b(context, "ksadsdk_idc", "idc_current", ""));
    }

    /* renamed from: a */
    public static void m26072a(Context context, Map<String, String> map) {
        C11137y.m23614a(context, "ksadsdk_idc", "idc_current", (map == null || map.isEmpty()) ? "" : new JSONObject(map).toString());
    }
}
