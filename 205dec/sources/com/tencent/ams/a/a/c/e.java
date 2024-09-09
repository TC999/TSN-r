package com.tencent.ams.a.a.c;

import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02b9, code lost:
        if (r13 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02bb, code lost:
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02c0, code lost:
        if (r13 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02c3, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.ams.a.a.b.g a(java.io.InputStream r13) {
        /*
            Method dump skipped, instructions count: 708
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ams.a.a.c.e.a(java.io.InputStream):com.tencent.ams.a.a.b.g");
    }

    public static boolean a(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}
