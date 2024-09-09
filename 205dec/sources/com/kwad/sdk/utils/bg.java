package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bg {
    private static final SimpleDateFormat aQb;
    private static final SimpleDateFormat aQc;
    private static final SimpleDateFormat aQd;
    private static final SimpleDateFormat aQe;
    private static final SimpleDateFormat aQf;
    private static final SimpleDateFormat aQg;
    private static final SimpleDateFormat aQh;

    static {
        Locale locale = Locale.US;
        aQb = new SimpleDateFormat("MM/dd", locale);
        aQc = new SimpleDateFormat("yyyy/MM/dd", locale);
        aQd = new SimpleDateFormat("MM\u6708dd\u65e5", locale);
        aQe = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5", locale);
        aQf = new SimpleDateFormat("HH:mm", locale);
        aQg = new SimpleDateFormat("MM-dd", locale);
        aQh = new SimpleDateFormat("yyyy-MM-dd", locale);
    }

    public static boolean gP(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean gQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }
}
