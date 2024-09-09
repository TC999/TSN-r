package com.bytedance.sdk.component.xv.w.c;

import com.bytedance.sdk.component.xv.c.f;
import com.bytedance.sdk.component.xv.c.fz;
import com.bytedance.sdk.component.xv.c.ux;
import com.bytedance.sdk.component.xv.w.ck;
import com.bytedance.sdk.component.xv.w.i;
import com.bytedance.sdk.component.xv.w.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class xv {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f30940c;
    public static final ck sr;
    public static final y xv;

    /* renamed from: w  reason: collision with root package name */
    public static final String[] f30947w = new String[0];
    private static final f gd = f.w("efbbbf");

    /* renamed from: p  reason: collision with root package name */
    private static final f f30943p = f.w("feff");

    /* renamed from: k  reason: collision with root package name */
    private static final f f30942k = f.w("fffe");

    /* renamed from: a  reason: collision with root package name */
    private static final f f30939a = f.w("0000ffff");
    private static final f bk = f.w("ffff0000");
    public static final Charset ux = Charset.forName("UTF-8");

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f30941f = Charset.forName("ISO-8859-1");

    /* renamed from: t  reason: collision with root package name */
    private static final Charset f30946t = Charset.forName("UTF-16BE");
    private static final Charset ys = Charset.forName("UTF-16LE");
    private static final Charset fp = Charset.forName("UTF-32BE");
    private static final Charset ia = Charset.forName("UTF-32LE");

    /* renamed from: r  reason: collision with root package name */
    public static final TimeZone f30944r = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> ev = new Comparator<String>() { // from class: com.bytedance.sdk.component.xv.w.c.xv.1
        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };

    /* renamed from: s  reason: collision with root package name */
    private static final Pattern f30945s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        byte[] bArr = new byte[0];
        f30940c = bArr;
        xv = y.c(null, bArr);
        sr = ck.c((i) null, bArr);
    }

    public static int c(char c4) {
        if (c4 < '0' || c4 > '9') {
            char c5 = 'a';
            if (c4 < 'a' || c4 > 'f') {
                c5 = 'A';
                if (c4 < 'A' || c4 > 'F') {
                    return -1;
                }
            }
            return (c4 - c5) + 10;
        }
        return c4 - '0';
    }

    public static void c(long j4, long j5, long j6) {
        if ((j5 | j6) < 0 || j5 > j4 || j4 - j5 < j6) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private static boolean sr(String str) {
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt <= 31 || charAt >= '\u007f' || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean w(fz fzVar, int i4, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long A_ = fzVar.c().xv() ? fzVar.c().A_() - nanoTime : Long.MAX_VALUE;
        fzVar.c().c(Math.min(A_, timeUnit.toNanos(i4)) + nanoTime);
        try {
            com.bytedance.sdk.component.xv.c.xv xvVar = new com.bytedance.sdk.component.xv.c.xv();
            while (fzVar.c(xvVar, 8192L) != -1) {
                xvVar.s();
            }
            if (A_ == Long.MAX_VALUE) {
                fzVar.c().f();
            } else {
                fzVar.c().c(nanoTime + A_);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (A_ == Long.MAX_VALUE) {
                fzVar.c().f();
            } else {
                fzVar.c().c(nanoTime + A_);
            }
            return false;
        } catch (Throwable th) {
            if (A_ == Long.MAX_VALUE) {
                fzVar.c().f();
            } else {
                fzVar.c().c(nanoTime + A_);
            }
            throw th;
        }
    }

    public static String xv(String str, int i4, int i5) {
        int c4 = c(str, i4, i5);
        return str.substring(c4, w(str, c4, i5));
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress sr(java.lang.String r11, int r12, int r13) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
        L9:
            r7 = 0
            if (r12 >= r13) goto L7a
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r12 + 2
            if (r8 > r13) goto L27
            java.lang.String r9 = "::"
            r10 = 2
            boolean r9 = r11.regionMatches(r12, r9, r3, r10)
            if (r9 == 0) goto L27
            if (r5 == r2) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r13) goto L25
            goto L7a
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L4a
            java.lang.String r8 = ":"
            r9 = 1
            boolean r8 = r11.regionMatches(r12, r8, r3, r9)
            if (r8 == 0) goto L35
            int r12 = r12 + 1
            goto L4a
        L35:
            java.lang.String r8 = "."
            boolean r12 = r11.regionMatches(r12, r8, r3, r9)
            if (r12 == 0) goto L49
            int r12 = r4 + (-2)
            boolean r11 = c(r11, r6, r13, r1, r12)
            if (r11 != 0) goto L46
            return r7
        L46:
            int r4 = r4 + 2
            goto L7a
        L49:
            return r7
        L4a:
            r6 = r12
        L4b:
            r12 = r6
            r8 = 0
        L4d:
            if (r12 >= r13) goto L60
            char r9 = r11.charAt(r12)
            int r9 = c(r9)
            if (r9 != r2) goto L5a
            goto L60
        L5a:
            int r8 = r8 << 4
            int r8 = r8 + r9
            int r12 = r12 + 1
            goto L4d
        L60:
            int r9 = r12 - r6
            if (r9 == 0) goto L79
            r10 = 4
            if (r9 <= r10) goto L68
            goto L79
        L68:
            int r7 = r4 + 1
            int r9 = r8 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r1[r4] = r9
            int r4 = r7 + 1
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L79:
            return r7
        L7a:
            if (r4 == r0) goto L8b
            if (r5 != r2) goto L7f
            return r7
        L7f:
            int r11 = r4 - r5
            int r12 = 16 - r11
            java.lang.System.arraycopy(r1, r5, r1, r12, r11)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r3)
        L8b:
            java.net.InetAddress r11 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L90
            return r11
        L90:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            goto L97
        L96:
            throw r11
        L97:
            goto L96
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.w.c.xv.sr(java.lang.String, int, int):java.net.InetAddress");
    }

    public static boolean xv(String str) {
        return f30945s.matcher(str).matches();
    }

    public static void c(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e4) {
                if (!c(e4)) {
                    throw e4;
                }
            } catch (RuntimeException | Exception unused) {
            }
        }
    }

    public static boolean c(fz fzVar, int i4, TimeUnit timeUnit) {
        try {
            return w(fzVar, i4, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static <T> List<T> c(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> c(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory c(final String str, final boolean z3) {
        return new ThreadFactory() { // from class: com.bytedance.sdk.component.xv.w.c.xv.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.gd.sr.xv xvVar = new com.bytedance.sdk.component.gd.sr.xv(runnable, "csj_" + str);
                xvVar.setDaemon(z3);
                xvVar.setPriority(10);
                return xvVar;
            }
        };
    }

    public static String[] c(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i4]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i4++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean w(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String c(com.bytedance.sdk.component.xv.w.fz fzVar, boolean z3) {
        String r3;
        if (fzVar.r().contains(":")) {
            r3 = "[" + fzVar.r() + "]";
        } else {
            r3 = fzVar.r();
        }
        if (z3 || fzVar.ev() != com.bytedance.sdk.component.xv.w.fz.c(fzVar.xv())) {
            return r3 + ":" + fzVar.ev();
        }
        return r3;
    }

    public static int w(String str, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            char charAt = str.charAt(i6);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i6 + 1;
            }
        }
        return i4;
    }

    public static int w(String str) {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt <= 31 || charAt >= '\u007f') {
                return i4;
            }
        }
        return -1;
    }

    public static boolean c(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int c(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (comparator.compare(strArr[i4], str) == 0) {
                return i4;
            }
        }
        return -1;
    }

    public static String[] c(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int c(String str, int i4, int i5) {
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static int c(String str, int i4, int i5, String str2) {
        while (i4 < i5) {
            if (str2.indexOf(str.charAt(i4)) != -1) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static int c(String str, int i4, int i5, char c4) {
        while (i4 < i5) {
            if (str.charAt(i4) == c4) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static String c(String str) {
        InetAddress sr2;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                sr2 = sr(str, 1, str.length() - 1);
            } else {
                sr2 = sr(str, 0, str.length());
            }
            if (sr2 == null) {
                return null;
            }
            byte[] address = sr2.getAddress();
            if (address.length == 16) {
                return c(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (sr(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String c(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset c(ux uxVar, Charset charset) throws IOException {
        f fVar = gd;
        if (uxVar.c(0L, fVar)) {
            uxVar.ev(fVar.r());
            return ux;
        }
        f fVar2 = f30943p;
        if (uxVar.c(0L, fVar2)) {
            uxVar.ev(fVar2.r());
            return f30946t;
        }
        f fVar3 = f30942k;
        if (uxVar.c(0L, fVar3)) {
            uxVar.ev(fVar3.r());
            return ys;
        }
        f fVar4 = f30939a;
        if (uxVar.c(0L, fVar4)) {
            uxVar.ev(fVar4.r());
            return fp;
        }
        f fVar5 = bk;
        if (uxVar.c(0L, fVar5)) {
            uxVar.ev(fVar5.r());
            return ia;
        }
        return charset;
    }

    public static int c(String str, long j4, TimeUnit timeUnit) {
        if (j4 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j4);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || j4 <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public static AssertionError c(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    private static boolean c(String str, int i4, int i5, byte[] bArr, int i6) {
        int i7 = i6;
        while (i4 < i5) {
            if (i7 == bArr.length) {
                return false;
            }
            if (i7 != i6) {
                if (str.charAt(i4) != '.') {
                    return false;
                }
                i4++;
            }
            int i8 = i4;
            int i9 = 0;
            while (i8 < i5) {
                char charAt = str.charAt(i8);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i9 == 0 && i4 != i8) || (i9 = ((i9 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i8++;
                }
            }
            if (i8 - i4 == 0) {
                return false;
            }
            bArr[i7] = (byte) i9;
            i7++;
            i4 = i8;
        }
        return i7 == i6 + 4;
    }

    private static String c(byte[] bArr) {
        int i4 = 0;
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        while (i6 < bArr.length) {
            int i8 = i6;
            while (i8 < 16 && bArr[i8] == 0 && bArr[i8 + 1] == 0) {
                i8 += 2;
            }
            int i9 = i8 - i6;
            if (i9 > i7 && i9 >= 4) {
                i5 = i6;
                i7 = i9;
            }
            i6 = i8 + 2;
        }
        com.bytedance.sdk.component.xv.c.xv xvVar = new com.bytedance.sdk.component.xv.c.xv();
        while (i4 < bArr.length) {
            if (i4 == i5) {
                xvVar.gd(58);
                i4 += i7;
                if (i4 == 16) {
                    xvVar.gd(58);
                }
            } else {
                if (i4 > 0) {
                    xvVar.gd(58);
                }
                xvVar.k(((bArr[i4] & 255) << 8) | (bArr[i4 + 1] & 255));
                i4 += 2;
            }
        }
        return xvVar.ys();
    }
}
