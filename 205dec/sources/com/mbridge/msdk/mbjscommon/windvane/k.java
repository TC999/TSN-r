package com.mbridge.msdk.mbjscommon.windvane;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: WindVaneUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f40357a = {"wv_hybrid:", "mraid:", "ssp:", "mvb_hybrid:"};

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f40358b = Pattern.compile("hybrid://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f40359c = Pattern.compile("mraid://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f40360d = Pattern.compile("ssp://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f40361e = Pattern.compile("mv://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: f  reason: collision with root package name */
    private static Map<String, String> f40362f = new HashMap();

    static {
        f[] values;
        for (f fVar : f.values()) {
            f40362f.put(fVar.a(), fVar.b());
        }
    }

    public static boolean a(String str) {
        for (String str2 : f40357a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Pattern b(String str) {
        if ("wv_hybrid:".equals(str)) {
            return f40361e;
        }
        if ("mraid:".equals(str)) {
            return f40359c;
        }
        if ("ssp:".equals(str)) {
            return f40360d;
        }
        if ("mvb_hybrid:".equals(str)) {
            return f40361e;
        }
        return null;
    }

    public static String c(String str) {
        char[] cArr = {'\'', '\\'};
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.setLength(0);
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            boolean z3 = true;
            if (charAt > '\u00ff') {
                stringBuffer.append("\\u");
                String upperCase = Integer.toHexString(charAt >>> '\b').toUpperCase();
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                String upperCase2 = Integer.toHexString(charAt & '\u00ff').toUpperCase();
                if (upperCase2.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase2);
            } else {
                int i5 = 0;
                while (true) {
                    if (i5 >= 2) {
                        z3 = false;
                        break;
                    } else if (cArr[i5] == charAt) {
                        stringBuffer.append("\\" + charAt);
                        break;
                    } else {
                        i5++;
                    }
                }
                if (!z3) {
                    stringBuffer.append(charAt);
                }
            }
        }
        return new String(stringBuffer);
    }

    public static boolean d(String str) {
        return e(str).startsWith("image");
    }

    public static String e(String str) {
        String str2 = f40362f.get(f(str));
        return str2 == null ? "" : str2;
    }

    private static String f(String str) {
        String path;
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (path = Uri.parse(str).getPath()) == null || (lastIndexOf = path.lastIndexOf(".")) == -1) ? "" : path.substring(lastIndexOf + 1);
    }
}
