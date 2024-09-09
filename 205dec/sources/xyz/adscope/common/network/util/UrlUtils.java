package xyz.adscope.common.network.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class UrlUtils {
    public static String urlDecode(String str, String str2) {
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String urlDecode(String str, Charset charset) {
        return urlDecode(str, charset.name());
    }

    public static String urlEncode(String str, String str2) {
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String urlEncode(String str, Charset charset) {
        return urlEncode(str, charset.name());
    }
}
