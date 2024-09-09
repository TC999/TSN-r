package com.bytedance.sdk.component.xv.w.c.xv;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr {

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f30964c = new ThreadLocal<DateFormat>() { // from class: com.bytedance.sdk.component.xv.w.c.xv.sr.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: c */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(com.bytedance.sdk.component.xv.w.c.xv.f30944r);
            return simpleDateFormat;
        }
    };

    /* renamed from: w  reason: collision with root package name */
    private static final String[] f30965w;
    private static final DateFormat[] xv;

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f30965w = strArr;
        xv = new DateFormat[strArr.length];
    }

    public static Date c(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f30964c.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        String[] strArr = f30965w;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                DateFormat[] dateFormatArr = xv;
                DateFormat dateFormat = dateFormatArr[i4];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f30965w[i4], Locale.US);
                    dateFormat.setTimeZone(com.bytedance.sdk.component.xv.w.c.xv.f30944r);
                    dateFormatArr[i4] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    public static String c(Date date) {
        return f30964c.get().format(date);
    }
}
