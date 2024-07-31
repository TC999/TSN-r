package com.mbridge.msdk.mbjscommon.windvane;

import android.net.Uri;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.mbridge.msdk.mbjscommon.windvane.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class WindVaneUtil {

    /* renamed from: a */
    private static final String[] f31585a = {"wv_hybrid:", "mraid:", "ssp:", "mvb_hybrid:"};

    /* renamed from: b */
    private static final Pattern f31586b = Pattern.compile("hybrid://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: c */
    private static final Pattern f31587c = Pattern.compile("mraid://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: d */
    private static final Pattern f31588d = Pattern.compile("ssp://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: e */
    private static final Pattern f31589e = Pattern.compile("mv://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: f */
    private static Map<String, String> f31590f = new HashMap();

    static {
        MimeTypeEnum[] values;
        for (MimeTypeEnum mimeTypeEnum : MimeTypeEnum.values()) {
            f31590f.put(mimeTypeEnum.m21394a(), mimeTypeEnum.m21393b());
        }
    }

    /* renamed from: a */
    public static boolean m21378a(String str) {
        for (String str2 : f31585a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static Pattern m21377b(String str) {
        if ("wv_hybrid:".equals(str)) {
            return f31589e;
        }
        if ("mraid:".equals(str)) {
            return f31587c;
        }
        if ("ssp:".equals(str)) {
            return f31588d;
        }
        if ("mvb_hybrid:".equals(str)) {
            return f31589e;
        }
        return null;
    }

    /* renamed from: c */
    public static String m21376c(String str) {
        char[] cArr = {'\'', '\\'};
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.setLength(0);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            boolean z = true;
            if (charAt > 255) {
                stringBuffer.append("\\u");
                String upperCase = Integer.toHexString(charAt >>> '\b').toUpperCase();
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                String upperCase2 = Integer.toHexString(charAt & 255).toUpperCase();
                if (upperCase2.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase2);
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= 2) {
                        z = false;
                        break;
                    } else if (cArr[i2] == charAt) {
                        stringBuffer.append("\\" + charAt);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    stringBuffer.append(charAt);
                }
            }
        }
        return new String(stringBuffer);
    }

    /* renamed from: d */
    public static boolean m21375d(String str) {
        return m21374e(str).startsWith(SocializeProtocolConstants.IMAGE);
    }

    /* renamed from: e */
    public static String m21374e(String str) {
        String str2 = f31590f.get(m21373f(str));
        return str2 == null ? "" : str2;
    }

    /* renamed from: f */
    private static String m21373f(String str) {
        String path;
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (path = Uri.parse(str).getPath()) == null || (lastIndexOf = path.lastIndexOf(".")) == -1) ? "" : path.substring(lastIndexOf + 1);
    }
}
