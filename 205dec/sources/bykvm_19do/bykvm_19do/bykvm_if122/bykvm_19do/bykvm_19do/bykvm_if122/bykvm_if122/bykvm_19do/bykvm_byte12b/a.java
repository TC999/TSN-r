package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_byte12b;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PublicSuffixDatabase.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f905e = {42};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f906f = new String[0];

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f907g = {"*"};

    /* renamed from: h  reason: collision with root package name */
    private static final a f908h = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f909a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f910b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    private byte[] f911c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f912d;

    public static a a() {
        return f908h;
    }

    private void b() throws IOException {
        InputStream resourceAsStream = a.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        e a4 = l.a(new j(l.a(resourceAsStream)));
        try {
            byte[] bArr = new byte[a4.readInt()];
            a4.readFully(bArr);
            byte[] bArr2 = new byte[a4.readInt()];
            a4.readFully(bArr2);
            synchronized (this) {
                this.f911c = bArr;
                this.f912d = bArr2;
            }
            this.f910b.countDown();
        } finally {
            c.a(a4);
        }
    }

    private void c() {
        boolean z3 = false;
        while (true) {
            try {
                try {
                    b();
                    break;
                } catch (InterruptedIOException unused) {
                    z3 = true;
                } catch (IOException e4) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(5, "Failed to read public suffix list", e4);
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

    public String a(String str) {
        int length;
        int length2;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] a4 = a(split);
            if (split.length != a4.length || a4[0].charAt(0) == '!') {
                if (a4[0].charAt(0) == '!') {
                    length = split.length;
                    length2 = a4.length;
                } else {
                    length = split.length;
                    length2 = a4.length + 1;
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

    private String[] a(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i4 = 0;
        if (!this.f909a.get() && this.f909a.compareAndSet(false, true)) {
            c();
        } else {
            try {
                this.f910b.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.f911c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length];
        for (int i5 = 0; i5 < strArr.length; i5++) {
            bArr[i5] = strArr[i5].getBytes(c.f1234i);
        }
        int i6 = 0;
        while (true) {
            str = null;
            if (i6 >= length) {
                str2 = null;
                break;
            }
            str2 = a(this.f911c, bArr, i6);
            if (str2 != null) {
                break;
            }
            i6++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i7 = 0; i7 < bArr2.length - 1; i7++) {
                bArr2[i7] = f905e;
                str3 = a(this.f911c, bArr2, i7);
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
                String a4 = a(this.f912d, bArr, i4);
                if (a4 != null) {
                    str = a4;
                    break;
                }
                i4++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        } else if (str2 == null && str3 == null) {
            return f907g;
        } else {
            String[] split = str2 != null ? str2.split("\\.") : f906f;
            String[] split2 = str3 != null ? str3.split("\\.") : f906f;
            return split.length > split2.length ? split : split2;
        }
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i4) {
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
                            return new String(bArr, i10, i12, c.f1234i);
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
