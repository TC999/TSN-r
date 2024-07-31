package com.kwai.adclient.kscommerciallogger;

import android.text.TextUtils;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.kwai.adclient.kscommerciallogger.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11159b {
    private static final String[] aTA = {"cache_limit", "cache_num", "segment_name_top1", "segment_count_top1"};

    /* renamed from: hk */
    public static boolean m23517hk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^[a-z][a-z0-9]*(_{1}[a-z0-9]+)+$", str);
    }

    /* renamed from: z */
    public static String m23516z(JSONObject jSONObject) {
        return jSONObject == null ? "" : jSONObject.toString();
    }
}
