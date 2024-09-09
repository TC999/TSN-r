package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class PreJava9DateFormatProvider {
    private static String getDateFormatPattern(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        return "M/d/yy";
                    }
                    throw new IllegalArgumentException("Unknown DateFormat style: " + i4);
                }
                return "MMM d, y";
            }
            return "MMMM d, y";
        }
        return "EEEE, MMMM d, y";
    }

    private static String getDatePartOfDateTimePattern(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        return "M/d/yy";
                    }
                    throw new IllegalArgumentException("Unknown DateFormat style: " + i4);
                }
                return "MMM d, yyyy";
            }
            return "MMMM d, yyyy";
        }
        return "EEEE, MMMM d, yyyy";
    }

    private static String getTimePartOfDateTimePattern(int i4) {
        if (i4 == 0 || i4 == 1) {
            return "h:mm:ss a z";
        }
        if (i4 != 2) {
            if (i4 == 3) {
                return "h:mm a";
            }
            throw new IllegalArgumentException("Unknown DateFormat style: " + i4);
        }
        return "h:mm:ss a";
    }

    public static DateFormat getUSDateFormat(int i4) {
        return new SimpleDateFormat(getDateFormatPattern(i4), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int i4, int i5) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(i4) + " " + getTimePartOfDateTimePattern(i5), Locale.US);
    }
}
