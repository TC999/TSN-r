package com.kwai.adclient.kscommerciallogger;

import android.text.TextUtils;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private static final String[] aTA = {"cache_limit", "cache_num", "segment_name_top1", "segment_count_top1"};

    public static boolean hk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^[a-z][a-z0-9]*(_{1}[a-z0-9]+)+$", str);
    }

    public static String z(JSONObject jSONObject) {
        return jSONObject == null ? "" : jSONObject.toString();
    }
}
