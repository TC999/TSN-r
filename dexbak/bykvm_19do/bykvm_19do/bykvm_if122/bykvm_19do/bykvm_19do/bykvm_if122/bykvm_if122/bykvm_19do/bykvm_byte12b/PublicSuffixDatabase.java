package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_byte12b;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.GzipSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Okio;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_byte12b.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e */
    private static final byte[] f912e = {42};

    /* renamed from: f */
    private static final String[] f913f = new String[0];

    /* renamed from: g */
    private static final String[] f914g = {"*"};

    /* renamed from: h */
    private static final PublicSuffixDatabase f915h = new PublicSuffixDatabase();

    /* renamed from: a */
    private final AtomicBoolean f916a = new AtomicBoolean(false);

    /* renamed from: b */
    private final CountDownLatch f917b = new CountDownLatch(1);

    /* renamed from: c */
    private byte[] f918c;

    /* renamed from: d */
    private byte[] f919d;

    /* renamed from: a */
    public static PublicSuffixDatabase m58796a() {
        return f915h;
    }

    /* renamed from: b */
    private void m58792b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource m58926a = Okio.m58926a(new GzipSource(Okio.m58925a(resourceAsStream)));
        try {
            byte[] bArr = new byte[m58926a.readInt()];
            m58926a.readFully(bArr);
            byte[] bArr2 = new byte[m58926a.readInt()];
            m58926a.readFully(bArr2);
            synchronized (this) {
                this.f918c = bArr;
                this.f919d = bArr2;
            }
            this.f917b.countDown();
        } finally {
            C1061c.m58475a(m58926a);
        }
    }

    /* renamed from: c */
    private void m58791c() {
        boolean z = false;
        while (true) {
            try {
                try {
                    m58792b();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e) {
                    Platform.m58485b().mo58493a(5, "Failed to read public suffix list", e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* renamed from: a */
    public String m58795a(String str) {
        int length;
        int length2;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split("\\.");
            String[] m58793a = m58793a(split);
            if (split.length != m58793a.length || m58793a[0].charAt(0) == '!') {
                if (m58793a[0].charAt(0) == '!') {
                    length = split.length;
                    length2 = m58793a.length;
                } else {
                    length = split.length;
                    length2 = m58793a.length + 1;
                }
                StringBuilder sb = new StringBuilder();
                String[] split2 = str.split("\\.");
                for (int i = length - length2; i < split2.length; i++) {
                    sb.append(split2[i]);
                    sb.append('.');
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return null;
        }
        throw new NullPointerException("domain == null");
    }

    /* renamed from: a */
    private String[] m58793a(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i = 0;
        if (!this.f916a.get() && this.f916a.compareAndSet(false, true)) {
            m58791c();
        } else {
            try {
                this.f917b.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.f918c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(C1061c.f1241i);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                str2 = null;
                break;
            }
            str2 = m58794a(this.f918c, bArr, i3);
            if (str2 != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = f912e;
                str3 = m58794a(this.f918c, bArr2, i4);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                String m58794a = m58794a(this.f919d, bArr, i);
                if (m58794a != null) {
                    str = m58794a;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        } else if (str2 == null && str3 == null) {
            return f914g;
        } else {
            String[] split = str2 != null ? str2.split("\\.") : f913f;
            String[] split2 = str3 != null ? str3.split("\\.") : f913f;
            return split.length > split2.length ? split : split2;
        }
    }

    /* renamed from: a */
    private static String m58794a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & UByte.f41242c;
                }
                i4 = i3 - (bArr[i7 + i12] & UByte.f41242c);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    } else if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else if (i10 == bArr2.length - 1) {
                        break;
                    } else {
                        i10++;
                        z2 = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, C1061c.f1241i);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }
}
