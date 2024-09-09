package com.mbridge.msdk.thrid.okhttp;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class Builder {
        @Nullable
        String domain;
        boolean hostOnly;
        boolean httpOnly;
        @Nullable
        String name;
        boolean persistent;
        boolean secure;
        @Nullable
        String value;
        long expiresAt = 253402300799999L;
        String path = TTPathConst.sSeparator;

        public Cookie build() {
            return new Cookie(this);
        }

        public Builder domain(String str) {
            return domain(str, false);
        }

        public Builder expiresAt(long j4) {
            if (j4 <= 0) {
                j4 = Long.MIN_VALUE;
            }
            if (j4 > 253402300799999L) {
                j4 = 253402300799999L;
            }
            this.expiresAt = j4;
            this.persistent = true;
            return this;
        }

        public Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Builder name(String str) {
            if (str != null) {
                if (str.trim().equals(str)) {
                    this.name = str;
                    return this;
                }
                throw new IllegalArgumentException("name is not trimmed");
            }
            throw new NullPointerException("name == null");
        }

        public Builder path(String str) {
            if (str.startsWith(TTPathConst.sSeparator)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder value(String str) {
            if (str != null) {
                if (str.trim().equals(str)) {
                    this.value = str;
                    return this;
                }
                throw new IllegalArgumentException("value is not trimmed");
            }
            throw new NullPointerException("value == null");
        }

        private Builder domain(String str, boolean z3) {
            if (str != null) {
                String canonicalizeHost = Util.canonicalizeHost(str);
                if (canonicalizeHost != null) {
                    this.domain = canonicalizeHost;
                    this.hostOnly = z3;
                    return this;
                }
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            throw new NullPointerException("domain == null");
        }
    }

    private Cookie(String str, String str2, long j4, String str3, String str4, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j4;
        this.domain = str3;
        this.path = str4;
        this.secure = z3;
        this.httpOnly = z4;
        this.hostOnly = z5;
        this.persistent = z6;
    }

    private static int dateCharacterOffset(String str, int i4, int i5, boolean z3) {
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (((charAt < ' ' && charAt != '\t') || charAt >= '\u007f' || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z3)) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    private static boolean domainMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.verifyAsIpAddress(str);
    }

    @Nullable
    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> values = headers.values("Set-Cookie");
        int size = values.size();
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < size; i4++) {
            Cookie parse = parse(httpUrl, values.get(i4));
            if (parse != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(parse);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    private static String parseDomain(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String canonicalizeHost = Util.canonicalizeHost(str);
            if (canonicalizeHost != null) {
                return canonicalizeHost;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static long parseExpires(String str, int i4, int i5) {
        int dateCharacterOffset = dateCharacterOffset(str, i4, i5, false);
        Matcher matcher = TIME_PATTERN.matcher(str);
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        while (dateCharacterOffset < i5) {
            int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i5, true);
            matcher.region(dateCharacterOffset, dateCharacterOffset2);
            if (i7 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                i7 = Integer.parseInt(matcher.group(1));
                i10 = Integer.parseInt(matcher.group(2));
                i11 = Integer.parseInt(matcher.group(3));
            } else if (i8 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
            } else {
                if (i9 == -1) {
                    Pattern pattern = MONTH_PATTERN;
                    if (matcher.usePattern(pattern).matches()) {
                        i9 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i6 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                    i6 = Integer.parseInt(matcher.group(1));
                }
            }
            dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i5, false);
        }
        if (i6 >= 70 && i6 <= 99) {
            i6 += 1900;
        }
        if (i6 >= 0 && i6 <= 69) {
            i6 += 2000;
        }
        if (i6 >= 1601) {
            if (i9 != -1) {
                if (i8 < 1 || i8 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i7 < 0 || i7 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i10 < 0 || i10 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i11 >= 0 && i11 <= 59) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, i6);
                    gregorianCalendar.set(2, i9 - 1);
                    gregorianCalendar.set(5, i8);
                    gregorianCalendar.set(11, i7);
                    gregorianCalendar.set(12, i10);
                    gregorianCalendar.set(13, i11);
                    gregorianCalendar.set(14, 0);
                    return gregorianCalendar.getTimeInMillis();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static long parseMaxAge(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e4) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e4;
        }
    }

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (encodedPath.startsWith(str)) {
            return str.endsWith(TTPathConst.sSeparator) || encodedPath.charAt(str.length()) == '/';
        }
        return false;
    }

    public String domain() {
        return this.domain;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            return cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
        }
        return false;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        long j4 = this.expiresAt;
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (!this.secure ? 1 : 0)) * 31) + (!this.httpOnly ? 1 : 0)) * 31) + (!this.persistent ? 1 : 0)) * 31) + (!this.hostOnly ? 1 : 0);
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean matches(HttpUrl httpUrl) {
        boolean domainMatch;
        if (this.hostOnly) {
            domainMatch = httpUrl.host().equals(this.domain);
        } else {
            domainMatch = domainMatch(httpUrl.host(), this.domain);
        }
        if (domainMatch && pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    public String name() {
        return this.name;
    }

    public String path() {
        return this.path;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString(false);
    }

    public String value() {
        return this.value;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0128  */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.mbridge.msdk.thrid.okhttp.Cookie parse(long r23, com.mbridge.msdk.thrid.okhttp.HttpUrl r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.Cookie.parse(long, com.mbridge.msdk.thrid.okhttp.HttpUrl, java.lang.String):com.mbridge.msdk.thrid.okhttp.Cookie");
    }

    String toString(boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z3) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    Cookie(Builder builder) {
        String str = builder.name;
        if (str != null) {
            String str2 = builder.value;
            if (str2 != null) {
                String str3 = builder.domain;
                if (str3 != null) {
                    this.name = str;
                    this.value = str2;
                    this.expiresAt = builder.expiresAt;
                    this.domain = str3;
                    this.path = builder.path;
                    this.secure = builder.secure;
                    this.httpOnly = builder.httpOnly;
                    this.persistent = builder.persistent;
                    this.hostOnly = builder.hostOnly;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
