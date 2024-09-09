package com.amap.api.col.p0003l;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: XXTEA.java */
/* renamed from: com.amap.api.col.3l.m6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class m6 {

    /* renamed from: a  reason: collision with root package name */
    private static int f8337a = 4;

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f8338a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f8338a.getAndIncrement());
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$b */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class b implements Callable<Void> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (m6.this) {
                if (m6.c(m6.this) == null) {
                    return null;
                }
                m6.m(m6.this);
                if (m6.q(m6.this)) {
                    m6.B(m6.this);
                    m6.C(m6.this);
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$c */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream
        public final void write(int i4) throws IOException {
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$d */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        private final f f8340a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f8341b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8342c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8343d;

        /* compiled from: DiskLruCache.java */
        /* renamed from: com.amap.api.col.3l.m6$d$a */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        private class a extends FilterOutputStream {
            /* synthetic */ a(d dVar, OutputStream outputStream, byte b4) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i4) {
                try {
                    ((FilterOutputStream) this).out.write(i4);
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            private a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i4, int i5) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i4, i5);
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }
        }

        /* synthetic */ d(m6 m6Var, f fVar, byte b4) {
            this(fVar);
        }

        static /* synthetic */ boolean f(d dVar) {
            dVar.f8342c = true;
            return true;
        }

        public final OutputStream b() throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (m6.F(m6.this) > 0) {
                synchronized (m6.this) {
                    if (this.f8340a.f8354d == this) {
                        if (!this.f8340a.f8353c) {
                            this.f8341b[0] = true;
                        }
                        File i4 = this.f8340a.i(0);
                        try {
                            fileOutputStream = new FileOutputStream(i4);
                        } catch (FileNotFoundException unused) {
                            m6.H(m6.this).mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(i4);
                            } catch (FileNotFoundException unused2) {
                                return m6.D();
                            }
                        }
                        aVar = new a(this, fileOutputStream, (byte) 0);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return aVar;
            }
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + m6.F(m6.this));
        }

        public final void c() throws IOException {
            if (this.f8342c) {
                m6.g(m6.this, this, false);
                m6.this.r(this.f8340a.f8351a);
            } else {
                m6.g(m6.this, this, true);
            }
            this.f8343d = true;
        }

        public final void e() throws IOException {
            m6.g(m6.this, this, false);
        }

        private d(f fVar) {
            this.f8340a = fVar;
            this.f8341b = fVar.f8353c ? null : new boolean[m6.F(m6.this)];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$e */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public final class e implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private final String f8346a;

        /* renamed from: b  reason: collision with root package name */
        private final long f8347b;

        /* renamed from: c  reason: collision with root package name */
        private final InputStream[] f8348c;

        /* renamed from: d  reason: collision with root package name */
        private final long[] f8349d;

        /* synthetic */ e(m6 m6Var, String str, long j4, InputStream[] inputStreamArr, long[] jArr, byte b4) {
            this(str, j4, inputStreamArr, jArr);
        }

        public final InputStream a() {
            return this.f8348c[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f8348c) {
                m6.h(inputStream);
            }
        }

        private e(String str, long j4, InputStream[] inputStreamArr, long[] jArr) {
            this.f8346a = str;
            this.f8347b = j4;
            this.f8348c = inputStreamArr;
            this.f8349d = jArr;
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$f */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private final class f {

        /* renamed from: a  reason: collision with root package name */
        private final String f8351a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f8352b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8353c;

        /* renamed from: d  reason: collision with root package name */
        private d f8354d;

        /* renamed from: e  reason: collision with root package name */
        private long f8355e;

        /* synthetic */ f(m6 m6Var, String str, byte b4) {
            this(str);
        }

        private static IOException d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ void f(f fVar, String[] strArr) throws IOException {
            if (strArr.length == m6.F(m6.this)) {
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    try {
                        fVar.f8352b[i4] = Long.parseLong(strArr[i4]);
                    } catch (NumberFormatException unused) {
                        throw d(strArr);
                    }
                }
                return;
            }
            throw d(strArr);
        }

        static /* synthetic */ boolean g(f fVar) {
            fVar.f8353c = true;
            return true;
        }

        public final File c(int i4) {
            File H = m6.H(m6.this);
            return new File(H, this.f8351a + "." + i4);
        }

        public final String e() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j4 : this.f8352b) {
                sb.append(' ');
                sb.append(j4);
            }
            return sb.toString();
        }

        public final File i(int i4) {
            File H = m6.H(m6.this);
            return new File(H, this.f8351a + "." + i4 + ".tmp");
        }

        private f(String str) {
            this.f8351a = str;
            this.f8352b = new long[m6.F(m6.this)];
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i4 = f8337a;
        int i5 = i4 - (length % i4);
        int i6 = ((length / i4) + 1) * i4;
        byte[] bArr3 = new byte[i6];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        while (length < i6) {
            bArr3[length] = (byte) i5;
            length++;
        }
        int[] b4 = b(bArr3);
        int[] b5 = b(bArr2);
        int length2 = b4.length - 1;
        if (length2 > 0) {
            if (b5.length < 4) {
                int[] iArr = new int[4];
                System.arraycopy(b5, 0, iArr, 0, b5.length);
                b5 = iArr;
            }
            int i7 = b4[length2];
            int i8 = (52 / (length2 + 1)) + 6;
            int i9 = 0;
            while (true) {
                int i10 = i8 - 1;
                if (i8 <= 0) {
                    break;
                }
                i9 -= 1640531527;
                int i11 = (i9 >>> 2) & 3;
                int i12 = 0;
                while (i12 < length2) {
                    int i13 = i12 + 1;
                    int i14 = b4[i13];
                    i7 = ((((i7 >>> 5) ^ (i14 << 2)) + ((i14 >>> 3) ^ (i7 << 4))) ^ ((i14 ^ i9) + (i7 ^ b5[(i12 & 3) ^ i11]))) + b4[i12];
                    b4[i12] = i7;
                    i12 = i13;
                }
                int i15 = b4[0];
                i7 = ((((i7 >>> 5) ^ (i15 << 2)) + ((i15 >>> 3) ^ (i7 << 4))) ^ ((i15 ^ i9) + (i7 ^ b5[i11 ^ (i12 & 3)]))) + b4[length2];
                b4[length2] = i7;
                i8 = i10;
            }
        }
        int length3 = b4.length << 2;
        byte[] bArr4 = new byte[length3];
        for (int i16 = 0; i16 < length3; i16++) {
            bArr4[i16] = (byte) ((b4[i16 >>> 2] >>> ((i16 & 3) << 3)) & 255);
        }
        return bArr4;
    }

    private static int[] b(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 >>> 2;
            iArr[i5] = iArr[i5] | ((bArr[i4] & 255) << ((i4 & 3) << 3));
        }
        return iArr;
    }
}
