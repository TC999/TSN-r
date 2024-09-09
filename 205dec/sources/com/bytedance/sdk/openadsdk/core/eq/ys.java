package com.bytedance.sdk.openadsdk.core.eq;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ys {
    public static String c(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return map.get(TextUtils.isEmpty(map.get("content-type")) ? "Content-Type" : "content-type");
    }
}
