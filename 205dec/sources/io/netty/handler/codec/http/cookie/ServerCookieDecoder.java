package io.netty.handler.codec.http.cookie;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ServerCookieDecoder extends CookieDecoder {
    private static final String RFC2965_DOMAIN = "$Domain";
    private static final String RFC2965_PATH = "$Path";
    private static final String RFC2965_PORT = "$Port";
    private static final String RFC2965_VERSION = "$Version";
    public static final ServerCookieDecoder STRICT = new ServerCookieDecoder(true);
    public static final ServerCookieDecoder LAX = new ServerCookieDecoder(false);

    private ServerCookieDecoder(boolean z3) {
        super(z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0064, code lost:
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006a, code lost:
        r2 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006c, code lost:
        if (r2 != r0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006e, code lost:
        r9 = r6;
        r10 = 0;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0072, code lost:
        r7 = r14.indexOf(59, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0076, code lost:
        if (r7 <= 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0079, code lost:
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007a, code lost:
        r10 = r2;
        r9 = r6;
        r2 = r7;
        r11 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0093 -> B:9:0x002f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x009c -> B:9:0x002f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00a4 -> B:9:0x002f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x00ad -> B:9:0x002f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x00af -> B:9:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Set<io.netty.handler.codec.http.cookie.Cookie> decode(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "header"
            java.lang.Object r0 = io.netty.util.internal.ObjectUtil.checkNotNull(r14, r0)
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.length()
            if (r0 != 0) goto L13
            java.util.Set r14 = java.util.Collections.emptySet()
            return r14
        L13:
            java.util.TreeSet r1 = new java.util.TreeSet
            r1.<init>()
            r3 = 1
            r4 = 0
            r6 = 0
            r7 = 8
            java.lang.String r5 = "$Version"
            r2 = r14
            boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
            r3 = 59
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L31
            int r2 = r14.indexOf(r3)
            int r2 = r2 + r4
        L2f:
            r8 = r2
            goto L33
        L31:
            r4 = 0
            r8 = 0
        L33:
            if (r8 != r0) goto L36
            return r1
        L36:
            char r2 = r14.charAt(r8)
            r6 = 9
            if (r2 == r6) goto Lb4
            r6 = 10
            if (r2 == r6) goto Lb4
            r6 = 11
            if (r2 == r6) goto Lb4
            r6 = 12
            if (r2 == r6) goto Lb4
            r6 = 13
            if (r2 == r6) goto Lb4
            r6 = 32
            if (r2 == r6) goto Lb4
            r6 = 44
            if (r2 == r6) goto Lb4
            if (r2 != r3) goto L5a
            goto Lb4
        L5a:
            r2 = -1
            if (r8 == r0) goto L86
            r6 = r8
        L5e:
            char r7 = r14.charAt(r6)
            if (r7 != r3) goto L66
            r2 = r6
            goto L87
        L66:
            r9 = 61
            if (r7 != r9) goto L7f
            int r2 = r6 + 1
            if (r2 != r0) goto L72
            r9 = r6
            r10 = 0
            r11 = 0
            goto L8a
        L72:
            int r7 = r14.indexOf(r3, r2)
            if (r7 <= 0) goto L79
            goto L7a
        L79:
            r7 = r0
        L7a:
            r10 = r2
            r9 = r6
            r2 = r7
            r11 = r2
            goto L8a
        L7f:
            int r6 = r6 + 1
            if (r6 != r0) goto L5e
            r9 = r0
            r2 = r6
            goto L88
        L86:
            r2 = r8
        L87:
            r9 = r2
        L88:
            r10 = -1
            r11 = -1
        L8a:
            if (r4 == 0) goto La7
            java.lang.String r6 = "$Path"
            r7 = 5
            boolean r6 = r14.regionMatches(r8, r6, r5, r7)
            if (r6 != 0) goto L2f
            r6 = 7
            java.lang.String r12 = "$Domain"
            boolean r6 = r14.regionMatches(r8, r12, r5, r6)
            if (r6 != 0) goto L2f
            java.lang.String r6 = "$Port"
            boolean r6 = r14.regionMatches(r8, r6, r5, r7)
            if (r6 == 0) goto La7
            goto L2f
        La7:
            r6 = r13
            r7 = r14
            io.netty.handler.codec.http.cookie.DefaultCookie r6 = r6.initCookie(r7, r8, r9, r10, r11)
            if (r6 == 0) goto L2f
            r1.add(r6)
            goto L2f
        Lb4:
            int r8 = r8 + 1
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.cookie.ServerCookieDecoder.decode(java.lang.String):java.util.Set");
    }
}
