package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Cookie.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class l {

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f1322j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f1323k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f1324l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f1325m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    private final String f1326a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1327b;

    /* renamed from: c  reason: collision with root package name */
    private final long f1328c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1329d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1330e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1331f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f1332g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f1333h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f1334i;

    private l(String str, String str2, long j4, String str3, String str4, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f1326a = str;
        this.f1327b = str2;
        this.f1328c = j4;
        this.f1329d = str3;
        this.f1330e = str4;
        this.f1331f = z3;
        this.f1332g = z4;
        this.f1334i = z5;
        this.f1333h = z6;
    }

    public String a() {
        return this.f1326a;
    }

    public String b() {
        return this.f1327b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            return lVar.f1326a.equals(this.f1326a) && lVar.f1327b.equals(this.f1327b) && lVar.f1329d.equals(this.f1329d) && lVar.f1330e.equals(this.f1330e) && lVar.f1328c == this.f1328c && lVar.f1331f == this.f1331f && lVar.f1332g == this.f1332g && lVar.f1333h == this.f1333h && lVar.f1334i == this.f1334i;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f1328c;
        return ((((((((((((((((this.f1326a.hashCode() + 527) * 31) + this.f1327b.hashCode()) * 31) + this.f1329d.hashCode()) * 31) + this.f1330e.hashCode()) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (!this.f1331f ? 1 : 0)) * 31) + (!this.f1332g ? 1 : 0)) * 31) + (!this.f1333h ? 1 : 0)) * 31) + (!this.f1334i ? 1 : 0);
    }

    public String toString() {
        return a(false);
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.d(str);
    }

    private static long b(String str) {
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

    public static l a(s sVar, String str) {
        return a(System.currentTimeMillis(), sVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l a(long r23, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l.a(long, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s, java.lang.String):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l");
    }

    private static long a(String str, int i4, int i5) {
        int a4 = a(str, i4, i5, false);
        Matcher matcher = f1325m.matcher(str);
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        while (a4 < i5) {
            int a5 = a(str, a4 + 1, i5, true);
            matcher.region(a4, a5);
            if (i7 == -1 && matcher.usePattern(f1325m).matches()) {
                i7 = Integer.parseInt(matcher.group(1));
                i10 = Integer.parseInt(matcher.group(2));
                i11 = Integer.parseInt(matcher.group(3));
            } else if (i8 == -1 && matcher.usePattern(f1324l).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
            } else {
                if (i9 == -1) {
                    Pattern pattern = f1323k;
                    if (matcher.usePattern(pattern).matches()) {
                        i9 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i6 == -1 && matcher.usePattern(f1322j).matches()) {
                    i6 = Integer.parseInt(matcher.group(1));
                }
            }
            a4 = a(str, a5 + 1, i5, false);
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
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1239n);
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

    private static int a(String str, int i4, int i5, boolean z3) {
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (((charAt < ' ' && charAt != '\t') || charAt >= '\u007f' || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z3)) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    private static String a(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str);
            if (a4 != null) {
                return a4;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static List<l> a(s sVar, r rVar) {
        List<String> b4 = rVar.b("Set-Cookie");
        int size = b4.size();
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < size; i4++) {
            l a4 = a(sVar, b4.get(i4));
            if (a4 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a4);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    String a(boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1326a);
        sb.append('=');
        sb.append(this.f1327b);
        if (this.f1333h) {
            if (this.f1328c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.d.a(new Date(this.f1328c)));
            }
        }
        if (!this.f1334i) {
            sb.append("; domain=");
            if (z3) {
                sb.append(".");
            }
            sb.append(this.f1329d);
        }
        sb.append("; path=");
        sb.append(this.f1330e);
        if (this.f1331f) {
            sb.append("; secure");
        }
        if (this.f1332g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
