package com.bytedance.sdk.openadsdk.core.live;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    public static String c(Uri uri, String str) {
        return (uri == null || !uri.isHierarchical() || str == null) ? "" : uri.getQueryParameter(str);
    }

    public static Uri c(Uri uri, Map<String, String> map) {
        if (uri != null && map != null && map.size() > 0) {
            try {
                Uri.Builder buildUpon = uri.buildUpon();
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        buildUpon.appendQueryParameter(str, map.get(str));
                    }
                }
                return buildUpon.build();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return uri;
    }
}
