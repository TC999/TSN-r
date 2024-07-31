package com.kwad.components.offline.api.core.utils;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class LiveRequestDataUtils {
    public static String appendUrl(@NonNull String str, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (map.get(next) != null) {
                sb.append(next);
                sb.append("=");
                sb.append(map.get(next));
                sb.append("&");
            }
        }
        String sb2 = sb.toString();
        String substring = sb2.substring(0, sb2.length() - 1);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(str.contains("?") ? "&" : "?");
        String sb4 = sb3.toString();
        return sb4 + substring;
    }
}
