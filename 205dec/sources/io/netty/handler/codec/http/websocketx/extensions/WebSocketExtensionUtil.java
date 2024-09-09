package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class WebSocketExtensionUtil {
    private static final String EXTENSION_SEPARATOR = ",";
    private static final Pattern PARAMETER = Pattern.compile("^([^=]+)(=[\\\"]?([^\\\"]+)[\\\"]?)?$");
    private static final char PARAMETER_EQUAL = '=';
    private static final String PARAMETER_SEPARATOR = ";";

    private WebSocketExtensionUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String appendExtension(String str, String str2, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(str != null ? str.length() : str2.length() + 1);
        if (str != null && !str.trim().isEmpty()) {
            sb.append(str);
            sb.append(",");
        }
        sb.append(str2);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(";");
            sb.append(entry.getKey());
            if (entry.getValue() != null) {
                sb.append('=');
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    public static List<WebSocketExtensionData> extractExtensions(String str) {
        Map emptyMap;
        String[] split = str.split(",");
        if (split.length > 0) {
            ArrayList arrayList = new ArrayList(split.length);
            for (String str2 : split) {
                String[] split2 = str2.split(";");
                String trim = split2[0].trim();
                if (split2.length > 1) {
                    emptyMap = new HashMap(split2.length - 1);
                    for (int i4 = 1; i4 < split2.length; i4++) {
                        Matcher matcher = PARAMETER.matcher(split2[i4].trim());
                        if (matcher.matches() && matcher.group(1) != null) {
                            emptyMap.put(matcher.group(1), matcher.group(3));
                        }
                    }
                } else {
                    emptyMap = Collections.emptyMap();
                }
                arrayList.add(new WebSocketExtensionData(trim, emptyMap));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isWebsocketUpgrade(HttpHeaders httpHeaders) {
        return httpHeaders.containsValue(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE, true) && httpHeaders.contains((CharSequence) HttpHeaderNames.UPGRADE, (CharSequence) HttpHeaderValues.WEBSOCKET, true);
    }
}
