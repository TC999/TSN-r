package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpDate;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Cookie {

    /* renamed from: j */
    private static final Pattern f1329j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k */
    private static final Pattern f1330k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l */
    private static final Pattern f1331l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m */
    private static final Pattern f1332m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a */
    private final String f1333a;

    /* renamed from: b */
    private final String f1334b;

    /* renamed from: c */
    private final long f1335c;

    /* renamed from: d */
    private final String f1336d;

    /* renamed from: e */
    private final String f1337e;

    /* renamed from: f */
    private final boolean f1338f;

    /* renamed from: g */
    private final boolean f1339g;

    /* renamed from: h */
    private final boolean f1340h;

    /* renamed from: i */
    private final boolean f1341i;

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f1333a = str;
        this.f1334b = str2;
        this.f1335c = j;
        this.f1336d = str3;
        this.f1337e = str4;
        this.f1338f = z;
        this.f1339g = z2;
        this.f1341i = z3;
        this.f1340h = z4;
    }

    /* renamed from: a */
    public String m58390a() {
        return this.f1333a;
    }

    /* renamed from: b */
    public String m58381b() {
        return this.f1334b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            return cookie.f1333a.equals(this.f1333a) && cookie.f1334b.equals(this.f1334b) && cookie.f1336d.equals(this.f1336d) && cookie.f1337e.equals(this.f1337e) && cookie.f1335c == this.f1335c && cookie.f1338f == this.f1338f && cookie.f1339g == this.f1339g && cookie.f1340h == this.f1340h && cookie.f1341i == this.f1341i;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f1335c;
        return ((((((((((((((((this.f1333a.hashCode() + 527) * 31) + this.f1334b.hashCode()) * 31) + this.f1336d.hashCode()) * 31) + this.f1337e.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (!this.f1338f ? 1 : 0)) * 31) + (!this.f1339g ? 1 : 0)) * 31) + (!this.f1340h ? 1 : 0)) * 31) + (!this.f1341i ? 1 : 0);
    }

    public String toString() {
        return m58382a(false);
    }

    /* renamed from: a */
    private static boolean m58383a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !C1061c.m58450d(str);
    }

    /* renamed from: b */
    private static long m58380b(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    /* renamed from: a */
    public static Cookie m58387a(HttpUrl httpUrl, String str) {
        return m58389a(System.currentTimeMillis(), httpUrl, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0128  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Cookie m58389a(long r23, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.HttpUrl r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Cookie.m58389a(long, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s, java.lang.String):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l");
    }

    /* renamed from: a */
    private static long m58385a(String str, int i, int i2) {
        int m58384a = m58384a(str, i, i2, false);
        Matcher matcher = f1332m.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (m58384a < i2) {
            int m58384a2 = m58384a(str, m58384a + 1, i2, true);
            matcher.region(m58384a, m58384a2);
            if (i4 == -1 && matcher.usePattern(f1332m).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(f1331l).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else {
                if (i6 == -1) {
                    Pattern pattern = f1330k;
                    if (matcher.usePattern(pattern).matches()) {
                        i6 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i3 == -1 && matcher.usePattern(f1329j).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            }
            m58384a = m58384a(str, m58384a2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 >= 1601) {
            if (i6 != -1) {
                if (i5 < 1 || i5 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i4 < 0 || i4 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i7 < 0 || i7 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i8 >= 0 && i8 <= 59) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(C1061c.f1246n);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, i3);
                    gregorianCalendar.set(2, i6 - 1);
                    gregorianCalendar.set(5, i5);
                    gregorianCalendar.set(11, i4);
                    gregorianCalendar.set(12, i7);
                    gregorianCalendar.set(13, i8);
                    gregorianCalendar.set(14, 0);
                    return gregorianCalendar.getTimeInMillis();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    private static int m58384a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    private static String m58386a(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String m58472a = C1061c.m58472a(str);
            if (m58472a != null) {
                return m58472a;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static List<Cookie> m58388a(HttpUrl httpUrl, Headers headers) {
        List<String> m58336b = headers.m58336b(HttpHeaders.Names.SET_COOKIE);
        int size = m58336b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Cookie m58387a = m58387a(httpUrl, m58336b.get(i));
            if (m58387a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(m58387a);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: a */
    String m58382a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1333a);
        sb.append('=');
        sb.append(this.f1334b);
        if (this.f1340h) {
            if (this.f1335c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.m58772a(new Date(this.f1335c)));
            }
        }
        if (!this.f1341i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f1336d);
        }
        sb.append("; path=");
        sb.append(this.f1337e);
        if (this.f1338f) {
            sb.append("; secure");
        }
        if (this.f1339g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
