package io.netty.handler.codec.http.cookie;

import io.netty.handler.codec.http.HttpHeaderDateFormat;
import java.text.ParsePosition;
import java.util.Date;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class ClientCookieDecoder extends CookieDecoder {
    public static final ClientCookieDecoder STRICT = new ClientCookieDecoder(true);
    public static final ClientCookieDecoder LAX = new ClientCookieDecoder(false);

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class CookieBuilder {
        private final DefaultCookie cookie;
        private String domain;
        private int expiresEnd;
        private int expiresStart;
        private final String header;
        private boolean httpOnly;
        private long maxAge = Long.MIN_VALUE;
        private String path;
        private boolean secure;

        public CookieBuilder(DefaultCookie defaultCookie, String str) {
            this.cookie = defaultCookie;
            this.header = str;
        }

        private String computeValue(int i, int i2) {
            if (i == -1 || i == i2) {
                return null;
            }
            return this.header.substring(i, i2);
        }

        private long mergeMaxAgeAndExpires() {
            long j = this.maxAge;
            if (j != Long.MIN_VALUE) {
                return j;
            }
            String computeValue = computeValue(this.expiresStart, this.expiresEnd);
            if (computeValue != null) {
                Date parse = HttpHeaderDateFormat.get().parse(computeValue, new ParsePosition(0));
                if (parse != null) {
                    long time = parse.getTime() - System.currentTimeMillis();
                    return (time / 1000) + (time % 1000 != 0 ? 1 : 0);
                }
            }
            return Long.MIN_VALUE;
        }

        private void parse4(int i, int i2, int i3) {
            if (this.header.regionMatches(true, i, CookieHeaderNames.PATH, 0, 4)) {
                this.path = computeValue(i2, i3);
            }
        }

        private void parse6(int i, int i2, int i3) {
            if (this.header.regionMatches(true, i, CookieHeaderNames.DOMAIN, 0, 5)) {
                this.domain = computeValue(i2, i3);
            } else if (this.header.regionMatches(true, i, CookieHeaderNames.SECURE, 0, 5)) {
                this.secure = true;
            }
        }

        private void parse7(int i, int i2, int i3) {
            if (this.header.regionMatches(true, i, "Expires", 0, 7)) {
                this.expiresStart = i2;
                this.expiresEnd = i3;
            } else if (this.header.regionMatches(true, i, CookieHeaderNames.MAX_AGE, 0, 7)) {
                setMaxAge(computeValue(i2, i3));
            }
        }

        private void parse8(int i, int i2, int i3) {
            if (this.header.regionMatches(true, i, CookieHeaderNames.HTTPONLY, 0, 8)) {
                this.httpOnly = true;
            }
        }

        private void setMaxAge(String str) {
            try {
                this.maxAge = Math.max(Long.parseLong(str), 0L);
            } catch (NumberFormatException unused) {
            }
        }

        public void appendAttribute(int i, int i2, int i3, int i4) {
            int i5 = i2 - i;
            if (i5 == 4) {
                parse4(i, i3, i4);
            } else if (i5 == 6) {
                parse6(i, i3, i4);
            } else if (i5 == 7) {
                parse7(i, i3, i4);
            } else if (i5 == 8) {
                parse8(i, i3, i4);
            }
        }

        public Cookie cookie() {
            this.cookie.setDomain(this.domain);
            this.cookie.setPath(this.path);
            this.cookie.setMaxAge(mergeMaxAgeAndExpires());
            this.cookie.setSecure(this.secure);
            this.cookie.setHttpOnly(this.httpOnly);
            return this.cookie;
        }
    }

    private ClientCookieDecoder(boolean z) {
        super(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.netty.handler.codec.http.cookie.Cookie decode(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "header"
            java.lang.Object r0 = io.netty.util.internal.ObjectUtil.checkNotNull(r12, r0)
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.length()
            r1 = 0
            if (r0 != 0) goto L10
            return r1
        L10:
            r2 = 0
            r3 = r1
            r5 = 0
        L13:
            if (r5 != r0) goto L16
            goto L1e
        L16:
            char r4 = r12.charAt(r5)
            r6 = 44
            if (r4 != r6) goto L23
        L1e:
            io.netty.handler.codec.http.cookie.Cookie r12 = r3.cookie()
            return r12
        L23:
            r7 = 9
            if (r4 == r7) goto L95
            r7 = 10
            if (r4 == r7) goto L95
            r7 = 11
            if (r4 == r7) goto L95
            r7 = 12
            if (r4 == r7) goto L95
            r7 = 13
            if (r4 == r7) goto L95
            r7 = 32
            if (r4 == r7) goto L95
            r7 = 59
            if (r4 != r7) goto L41
            goto L95
        L41:
            r4 = -1
            r8 = r5
            if (r5 == r0) goto L6c
        L45:
            char r9 = r12.charAt(r8)
            if (r9 != r7) goto L4c
            goto L6c
        L4c:
            r10 = 61
            if (r9 != r10) goto L64
            int r4 = r8 + 1
            if (r4 != r0) goto L58
            r9 = r4
            r4 = 0
            r7 = 0
            goto L6e
        L58:
            int r7 = r12.indexOf(r7, r4)
            if (r7 <= 0) goto L5f
            goto L60
        L5f:
            r7 = r0
        L60:
            r9 = r7
            r7 = r4
            r4 = r9
            goto L6e
        L64:
            int r8 = r8 + 1
            if (r8 != r0) goto L45
            r9 = r8
            r7 = -1
            r8 = r0
            goto L6e
        L6c:
            r9 = r8
            r7 = -1
        L6e:
            if (r4 <= 0) goto L7a
            int r10 = r4 + (-1)
            char r10 = r12.charAt(r10)
            if (r10 != r6) goto L7a
            int r4 = r4 + (-1)
        L7a:
            r10 = r4
            if (r3 != 0) goto L8f
            r3 = r11
            r4 = r12
            r6 = r8
            r8 = r10
            io.netty.handler.codec.http.cookie.DefaultCookie r3 = r3.initCookie(r4, r5, r6, r7, r8)
            if (r3 != 0) goto L88
            return r1
        L88:
            io.netty.handler.codec.http.cookie.ClientCookieDecoder$CookieBuilder r4 = new io.netty.handler.codec.http.cookie.ClientCookieDecoder$CookieBuilder
            r4.<init>(r3, r12)
            r3 = r4
            goto L92
        L8f:
            r3.appendAttribute(r5, r8, r7, r10)
        L92:
            r5 = r9
            goto L13
        L95:
            int r5 = r5 + 1
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.cookie.ClientCookieDecoder.decode(java.lang.String):io.netty.handler.codec.http.cookie.Cookie");
    }
}
