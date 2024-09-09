package com.bytedance.sdk.component.xv.w;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f30709a;
    private final boolean bk;
    private final String ev;

    /* renamed from: f  reason: collision with root package name */
    private final String f30710f;
    private final String gd;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f30711k;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f30712p;

    /* renamed from: r  reason: collision with root package name */
    private final long f30713r;
    private final String ux;

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f30707c = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: w  reason: collision with root package name */
    private static final Pattern f30708w = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern xv = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern sr = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private a(String str, String str2, long j4, String str3, String str4, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.ux = str;
        this.f30710f = str2;
        this.f30713r = j4;
        this.ev = str3;
        this.gd = str4;
        this.f30712p = z3;
        this.f30711k = z4;
        this.bk = z5;
        this.f30709a = z6;
    }

    public String c() {
        return this.ux;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return aVar.ux.equals(this.ux) && aVar.f30710f.equals(this.f30710f) && aVar.ev.equals(this.ev) && aVar.gd.equals(this.gd) && aVar.f30713r == this.f30713r && aVar.f30712p == this.f30712p && aVar.f30711k == this.f30711k && aVar.f30709a == this.f30709a && aVar.bk == this.bk;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f30713r;
        return ((((((((((((((((527 + this.ux.hashCode()) * 31) + this.f30710f.hashCode()) * 31) + this.ev.hashCode()) * 31) + this.gd.hashCode()) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (!this.f30712p ? 1 : 0)) * 31) + (!this.f30711k ? 1 : 0)) * 31) + (!this.f30709a ? 1 : 0)) * 31) + (!this.bk ? 1 : 0);
    }

    public String toString() {
        return c(false);
    }

    public String w() {
        return this.f30710f;
    }

    private static boolean c(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.bytedance.sdk.component.xv.w.c.xv.xv(str);
    }

    private static String w(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String c4 = com.bytedance.sdk.component.xv.w.c.xv.c(str);
            if (c4 != null) {
                return c4;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static a c(fz fzVar, String str) {
        return c(System.currentTimeMillis(), fzVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.bytedance.sdk.component.xv.w.a c(long r23, com.bytedance.sdk.component.xv.w.fz r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.w.a.c(long, com.bytedance.sdk.component.xv.w.fz, java.lang.String):com.bytedance.sdk.component.xv.w.a");
    }

    private static long c(String str, int i4, int i5) {
        int c4 = c(str, i4, i5, false);
        Matcher matcher = sr.matcher(str);
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        while (c4 < i5) {
            int c5 = c(str, c4 + 1, i5, true);
            matcher.region(c4, c5);
            if (i7 == -1 && matcher.usePattern(sr).matches()) {
                i7 = Integer.parseInt(matcher.group(1));
                i10 = Integer.parseInt(matcher.group(2));
                i11 = Integer.parseInt(matcher.group(3));
            } else if (i8 == -1 && matcher.usePattern(xv).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
            } else {
                if (i9 == -1) {
                    Pattern pattern = f30708w;
                    if (matcher.usePattern(pattern).matches()) {
                        i9 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i6 == -1 && matcher.usePattern(f30707c).matches()) {
                    i6 = Integer.parseInt(matcher.group(1));
                }
            }
            c4 = c(str, c5 + 1, i5, false);
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
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(com.bytedance.sdk.component.xv.w.c.xv.f30944r);
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

    private static int c(String str, int i4, int i5, boolean z3) {
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (((charAt < ' ' && charAt != '\t') || charAt >= '\u007f' || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z3)) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    private static long c(String str) {
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

    public static List<a> c(fz fzVar, s sVar) {
        List<String> w3 = sVar.w("Set-Cookie");
        int size = w3.size();
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < size; i4++) {
            a c4 = c(fzVar, w3.get(i4));
            if (c4 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c4);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    String c(boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.ux);
        sb.append('=');
        sb.append(this.f30710f);
        if (this.f30709a) {
            if (this.f30713r == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(com.bytedance.sdk.component.xv.w.c.xv.sr.c(new Date(this.f30713r)));
            }
        }
        if (!this.bk) {
            sb.append("; domain=");
            if (z3) {
                sb.append(".");
            }
            sb.append(this.ev);
        }
        sb.append("; path=");
        sb.append(this.gd);
        if (this.f30712p) {
            sb.append("; secure");
        }
        if (this.f30711k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
