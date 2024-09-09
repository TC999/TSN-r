package com.bytedance.sdk.component.p.ev;

import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static JSONObject c(String str) {
        String decode;
        int indexOf;
        JSONObject jSONObject = new JSONObject();
        try {
            decode = URLDecoder.decode(str, "UTF-8");
            indexOf = decode.indexOf(63);
        } catch (Throwable th) {
            th.toString();
        }
        if (indexOf == -1) {
            return jSONObject;
        }
        Matcher matcher = Pattern.compile("([^&=]+)=(\\$\\{[^}]+\\})").matcher(decode.substring(indexOf + 1));
        while (matcher.find()) {
            jSONObject.put(matcher.group(1), matcher.group(2));
        }
        return jSONObject;
    }
}
