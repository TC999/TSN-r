package com.bytedance.sdk.component.xv.w.c.ev;

import com.bytedance.sdk.component.xv.c.a;
import com.bytedance.sdk.component.xv.c.p;
import com.bytedance.sdk.component.xv.w.c.r.ux;
import com.bytedance.sdk.component.xv.w.c.xv;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {
    private byte[] ev;

    /* renamed from: r  reason: collision with root package name */
    private byte[] f30775r;

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f30772c = {42};

    /* renamed from: w  reason: collision with root package name */
    private static final String[] f30773w = new String[0];
    private static final String[] xv = {"*"};
    private static final c sr = new c();
    private final AtomicBoolean ux = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final CountDownLatch f30774f = new CountDownLatch(1);

    public static c c() {
        return sr;
    }

    private void w() {
        boolean z3 = false;
        while (true) {
            try {
                try {
                    xv();
                    break;
                } catch (InterruptedIOException unused) {
                    z3 = true;
                } catch (IOException e4) {
                    ux.w().c(5, "Failed to read public suffix list", e4);
                    if (z3) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z3) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
    }

    private void xv() throws IOException {
        InputStream resourceAsStream = c.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        com.bytedance.sdk.component.xv.c.ux c4 = a.c(new p(a.c(resourceAsStream)));
        try {
            byte[] bArr = new byte[c4.p()];
            c4.c(bArr);
            byte[] bArr2 = new byte[c4.p()];
            c4.c(bArr2);
            synchronized (this) {
                this.f30775r = bArr;
                this.ev = bArr2;
            }
            this.f30774f.countDown();
        } finally {
            xv.c(c4);
        }
    }

    public String c(String str) {
        int length;
        int length2;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] c4 = c(split);
            if (split.length != c4.length || c4[0].charAt(0) == '!') {
                if (c4[0].charAt(0) == '!') {
                    length = split.length;
                    length2 = c4.length;
                } else {
                    length = split.length;
                    length2 = c4.length + 1;
                }
                StringBuilder sb = new StringBuilder();
                String[] split2 = str.split("\\.");
                for (int i4 = length - length2; i4 < split2.length; i4++) {
                    sb.append(split2[i4]);
                    sb.append('.');
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return null;
        }
        throw new NullPointerException("domain == null");
    }

    private String[] c(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i4 = 0;
        if (!this.ux.get() && this.ux.compareAndSet(false, true)) {
            w();
        } else {
            try {
                this.f30774f.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.f30775r == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length];
        for (int i5 = 0; i5 < strArr.length; i5++) {
            bArr[i5] = strArr[i5].getBytes(xv.ux);
        }
        int i6 = 0;
        while (true) {
            str = null;
            if (i6 >= length) {
                str2 = null;
                break;
            }
            str2 = c(this.f30775r, bArr, i6);
            if (str2 != null) {
                break;
            }
            i6++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i7 = 0; i7 < bArr2.length - 1; i7++) {
                bArr2[i7] = f30772c;
                str3 = c(this.f30775r, bArr2, i7);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i4 >= length - 1) {
                    break;
                }
                String c4 = c(this.ev, bArr, i4);
                if (c4 != null) {
                    str = c4;
                    break;
                }
                i4++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        } else if (str2 == null && str3 == null) {
            return xv;
        } else {
            String[] split = str2 != null ? str2.split("\\.") : f30773w;
            String[] split2 = str3 != null ? str3.split("\\.") : f30773w;
            return split.length > split2.length ? split : split2;
        }
    }

    private static String c(byte[] bArr, byte[][] bArr2, int i4) {
        int i5;
        boolean z3;
        int i6;
        int i7;
        int length = bArr.length;
        int i8 = 0;
        while (i8 < length) {
            int i9 = (i8 + length) / 2;
            while (i9 > -1 && bArr[i9] != 10) {
                i9--;
            }
            int i10 = i9 + 1;
            int i11 = 1;
            while (true) {
                i5 = i10 + i11;
                if (bArr[i5] == 10) {
                    break;
                }
                i11++;
            }
            int i12 = i5 - i10;
            int i13 = i4;
            boolean z4 = false;
            int i14 = 0;
            int i15 = 0;
            while (true) {
                if (z4) {
                    i6 = 46;
                    z3 = false;
                } else {
                    z3 = z4;
                    i6 = bArr2[i13][i14] & 255;
                }
                i7 = i6 - (bArr[i10 + i15] & 255);
                if (i7 == 0) {
                    i15++;
                    i14++;
                    if (i15 == i12) {
                        break;
                    } else if (bArr2[i13].length != i14) {
                        z4 = z3;
                    } else if (i13 == bArr2.length - 1) {
                        break;
                    } else {
                        i13++;
                        z4 = true;
                        i14 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i7 >= 0) {
                if (i7 <= 0) {
                    int i16 = i12 - i15;
                    int length2 = bArr2[i13].length - i14;
                    while (true) {
                        i13++;
                        if (i13 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i13].length;
                    }
                    if (length2 >= i16) {
                        if (length2 <= i16) {
                            return new String(bArr, i10, i12, xv.ux);
                        }
                    }
                }
                i8 = i5 + 1;
            }
            length = i10 - 1;
        }
        return null;
    }
}
