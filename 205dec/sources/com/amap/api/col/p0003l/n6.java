package com.amap.api.col.p0003l;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DiskLruCache.java */
/* renamed from: com.amap.api.col.3l.n6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class n6 implements Closeable {

    /* renamed from: o  reason: collision with root package name */
    static final Pattern f8391o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: p  reason: collision with root package name */
    public static final Charset f8392p = Charset.forName("US-ASCII");

    /* renamed from: q  reason: collision with root package name */
    static final Charset f8393q = Charset.forName("UTF-8");

    /* renamed from: r  reason: collision with root package name */
    private static final ThreadFactory f8394r;

    /* renamed from: s  reason: collision with root package name */
    static ThreadPoolExecutor f8395s;

    /* renamed from: t  reason: collision with root package name */
    private static final OutputStream f8396t;

    /* renamed from: a  reason: collision with root package name */
    private final File f8397a;

    /* renamed from: b  reason: collision with root package name */
    private final File f8398b;

    /* renamed from: c  reason: collision with root package name */
    private final File f8399c;

    /* renamed from: d  reason: collision with root package name */
    private final File f8400d;

    /* renamed from: f  reason: collision with root package name */
    private long f8402f;

    /* renamed from: i  reason: collision with root package name */
    private Writer f8405i;

    /* renamed from: l  reason: collision with root package name */
    private int f8408l;

    /* renamed from: h  reason: collision with root package name */
    private long f8404h = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f8406j = 1000;

    /* renamed from: k  reason: collision with root package name */
    private final LinkedHashMap<String, f> f8407k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m  reason: collision with root package name */
    private long f8409m = 0;

    /* renamed from: n  reason: collision with root package name */
    private final Callable<Void> f8410n = new b();

    /* renamed from: e  reason: collision with root package name */
    private final int f8401e = 1;

    /* renamed from: g  reason: collision with root package name */
    private final int f8403g = 1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.n6$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f8411a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f8411a.getAndIncrement());
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.n6$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Callable<Void> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (n6.this) {
                if (n6.this.f8405i == null) {
                    return null;
                }
                n6.this.G();
                if (n6.this.E()) {
                    n6.this.D();
                    n6.u(n6.this);
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.n6$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream
        public final void write(int i4) throws IOException {
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.n6$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        private final f f8413a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f8414b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8415c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8416d;

        /* compiled from: DiskLruCache.java */
        /* renamed from: com.amap.api.col.3l.n6$d$a */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
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

        /* synthetic */ d(n6 n6Var, f fVar, byte b4) {
            this(fVar);
        }

        static /* synthetic */ boolean f(d dVar) {
            dVar.f8415c = true;
            return true;
        }

        public final OutputStream b() throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (n6.this.f8403g > 0) {
                synchronized (n6.this) {
                    if (this.f8413a.f8427d == this) {
                        if (!this.f8413a.f8426c) {
                            this.f8414b[0] = true;
                        }
                        File i4 = this.f8413a.i(0);
                        try {
                            fileOutputStream = new FileOutputStream(i4);
                        } catch (FileNotFoundException unused) {
                            n6.this.f8397a.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(i4);
                            } catch (FileNotFoundException unused2) {
                                return n6.f8396t;
                            }
                        }
                        aVar = new a(this, fileOutputStream, (byte) 0);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return aVar;
            }
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + n6.this.f8403g);
        }

        public final void c() throws IOException {
            if (this.f8415c) {
                n6.this.f(this, false);
                n6.this.q(this.f8413a.f8424a);
            } else {
                n6.this.f(this, true);
            }
            this.f8416d = true;
        }

        public final void e() throws IOException {
            n6.this.f(this, false);
        }

        private d(f fVar) {
            this.f8413a = fVar;
            this.f8414b = fVar.f8426c ? null : new boolean[n6.this.f8403g];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.n6$e */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class e implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private final String f8419a;

        /* renamed from: b  reason: collision with root package name */
        private final long f8420b;

        /* renamed from: c  reason: collision with root package name */
        private final InputStream[] f8421c;

        /* renamed from: d  reason: collision with root package name */
        private final long[] f8422d;

        /* synthetic */ e(n6 n6Var, String str, long j4, InputStream[] inputStreamArr, long[] jArr, byte b4) {
            this(str, j4, inputStreamArr, jArr);
        }

        public final InputStream b() {
            return this.f8421c[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f8421c) {
                n6.h(inputStream);
            }
        }

        private e(String str, long j4, InputStream[] inputStreamArr, long[] jArr) {
            this.f8419a = str;
            this.f8420b = j4;
            this.f8421c = inputStreamArr;
            this.f8422d = jArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.n6$f */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class f {

        /* renamed from: a  reason: collision with root package name */
        private final String f8424a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f8425b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8426c;

        /* renamed from: d  reason: collision with root package name */
        private d f8427d;

        /* renamed from: e  reason: collision with root package name */
        private long f8428e;

        /* synthetic */ f(n6 n6Var, String str, byte b4) {
            this(str);
        }

        private static IOException d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ void f(f fVar, String[] strArr) throws IOException {
            if (strArr.length == n6.this.f8403g) {
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    try {
                        fVar.f8425b[i4] = Long.parseLong(strArr[i4]);
                    } catch (NumberFormatException unused) {
                        throw d(strArr);
                    }
                }
                return;
            }
            throw d(strArr);
        }

        static /* synthetic */ boolean g(f fVar) {
            fVar.f8426c = true;
            return true;
        }

        public final File c(int i4) {
            File file = n6.this.f8397a;
            return new File(file, this.f8424a + "." + i4);
        }

        public final String e() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j4 : this.f8425b) {
                sb.append(' ');
                sb.append(j4);
            }
            return sb.toString();
        }

        public final File i(int i4) {
            File file = n6.this.f8397a;
            return new File(file, this.f8424a + "." + i4 + ".tmp");
        }

        private f(String str) {
            this.f8424a = str;
            this.f8425b = new long[n6.this.f8403g];
        }
    }

    static {
        a aVar = new a();
        f8394r = aVar;
        f8395s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
        f8396t = new c();
    }

    private n6(File file, long j4) {
        this.f8397a = file;
        this.f8398b = new File(file, "journal");
        this.f8399c = new File(file, "journal.tmp");
        this.f8400d = new File(file, "journal.bkp");
        this.f8402f = j4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ee, code lost:
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.n6.B():void");
    }

    private void C() throws IOException {
        i(this.f8399c);
        Iterator<f> it = this.f8407k.values().iterator();
        while (it.hasNext()) {
            f next = it.next();
            int i4 = 0;
            if (next.f8427d == null) {
                while (i4 < this.f8403g) {
                    this.f8404h += next.f8425b[i4];
                    i4++;
                }
            } else {
                next.f8427d = null;
                while (i4 < this.f8403g) {
                    i(next.c(i4));
                    i(next.i(i4));
                    i4++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void D() throws IOException {
        Writer writer = this.f8405i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8399c), f8392p));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f8401e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f8403g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (f fVar : this.f8407k.values()) {
            if (fVar.f8427d != null) {
                bufferedWriter.write("DIRTY " + fVar.f8424a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + fVar.f8424a + fVar.e() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f8398b.exists()) {
            j(this.f8398b, this.f8400d, true);
        }
        j(this.f8399c, this.f8398b, false);
        this.f8400d.delete();
        this.f8405i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f8398b, true), f8392p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E() {
        int i4 = this.f8408l;
        return i4 >= 2000 && i4 >= this.f8407k.size();
    }

    private void F() {
        if (this.f8405i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() throws IOException {
        while (true) {
            if (this.f8404h <= this.f8402f && this.f8407k.size() <= this.f8406j) {
                return;
            }
            q(this.f8407k.entrySet().iterator().next().getKey());
        }
    }

    public static n6 b(File file, long j4) throws IOException {
        if (j4 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    j(file2, file3, false);
                }
            }
            n6 n6Var = new n6(file, j4);
            if (n6Var.f8398b.exists()) {
                try {
                    n6Var.B();
                    n6Var.C();
                    n6Var.f8405i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(n6Var.f8398b, true), f8392p));
                    return n6Var;
                } catch (Throwable unused) {
                    n6Var.s();
                }
            }
            file.mkdirs();
            n6 n6Var2 = new n6(file, j4);
            n6Var2.D();
            return n6Var2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void d() {
        ThreadPoolExecutor threadPoolExecutor = f8395s;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        f8395s.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f(d dVar, boolean z3) throws IOException {
        f fVar = dVar.f8413a;
        if (fVar.f8427d == dVar) {
            if (z3 && !fVar.f8426c) {
                for (int i4 = 0; i4 < this.f8403g; i4++) {
                    if (dVar.f8414b[i4]) {
                        if (!fVar.i(i4).exists()) {
                            dVar.e();
                            return;
                        }
                    } else {
                        dVar.e();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i4)));
                    }
                }
            }
            for (int i5 = 0; i5 < this.f8403g; i5++) {
                File i6 = fVar.i(i5);
                if (z3) {
                    if (i6.exists()) {
                        File c4 = fVar.c(i5);
                        i6.renameTo(c4);
                        long j4 = fVar.f8425b[i5];
                        long length = c4.length();
                        fVar.f8425b[i5] = length;
                        this.f8404h = (this.f8404h - j4) + length;
                    }
                } else {
                    i(i6);
                }
            }
            this.f8408l++;
            fVar.f8427d = null;
            if (fVar.f8426c | z3) {
                f.g(fVar);
                this.f8405i.write("CLEAN " + fVar.f8424a + fVar.e() + '\n');
                if (z3) {
                    long j5 = this.f8409m;
                    this.f8409m = 1 + j5;
                    fVar.f8428e = j5;
                }
            } else {
                this.f8407k.remove(fVar.f8424a);
                this.f8405i.write("REMOVE " + fVar.f8424a + '\n');
            }
            this.f8405i.flush();
            if (this.f8404h > this.f8402f || E()) {
                z().submit(this.f8410n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public static void h(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused) {
            }
        }
    }

    private static void i(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void j(File file, File file2, boolean z3) throws IOException {
        if (z3) {
            i(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private static void n(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    n(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }

    private synchronized d r(String str) throws IOException {
        F();
        x(str);
        f fVar = this.f8407k.get(str);
        if (fVar == null) {
            fVar = new f(this, str, (byte) 0);
            this.f8407k.put(str, fVar);
        } else if (fVar.f8427d != null) {
            return null;
        }
        d dVar = new d(this, fVar, (byte) 0);
        fVar.f8427d = dVar;
        Writer writer = this.f8405i;
        writer.write("DIRTY " + str + '\n');
        this.f8405i.flush();
        return dVar;
    }

    static /* synthetic */ int u(n6 n6Var) {
        n6Var.f8408l = 0;
        return 0;
    }

    private static void x(String str) {
        if (f8391o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private static ThreadPoolExecutor z() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f8395s;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f8395s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f8394r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f8395s;
    }

    public final synchronized e a(String str) throws IOException {
        F();
        x(str);
        f fVar = this.f8407k.get(str);
        if (fVar == null) {
            return null;
        }
        if (fVar.f8426c) {
            InputStream[] inputStreamArr = new InputStream[this.f8403g];
            for (int i4 = 0; i4 < this.f8403g; i4++) {
                try {
                    inputStreamArr[i4] = new FileInputStream(fVar.c(i4));
                } catch (FileNotFoundException unused) {
                    for (int i5 = 0; i5 < this.f8403g && inputStreamArr[i5] != null; i5++) {
                        h(inputStreamArr[i5]);
                    }
                    return null;
                }
            }
            this.f8408l++;
            this.f8405i.append((CharSequence) ("READ " + str + '\n'));
            if (E()) {
                z().submit(this.f8410n);
            }
            return new e(this, str, fVar.f8428e, inputStreamArr, fVar.f8425b, (byte) 0);
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.f8405i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f8407k.values()).iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.f8427d != null) {
                fVar.f8427d.e();
            }
        }
        G();
        this.f8405i.close();
        this.f8405i = null;
    }

    public final void e(int i4) {
        if (i4 < 10) {
            i4 = 10;
        } else if (i4 > 10000) {
            i4 = 10000;
        }
        this.f8406j = i4;
    }

    public final d k(String str) throws IOException {
        return r(str);
    }

    public final File l() {
        return this.f8397a;
    }

    public final synchronized void o() throws IOException {
        F();
        G();
        this.f8405i.flush();
    }

    public final synchronized boolean q(String str) throws IOException {
        F();
        x(str);
        f fVar = this.f8407k.get(str);
        if (fVar != null && fVar.f8427d == null) {
            for (int i4 = 0; i4 < this.f8403g; i4++) {
                File c4 = fVar.c(i4);
                if (c4.exists() && !c4.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(c4)));
                }
                this.f8404h -= fVar.f8425b[i4];
                fVar.f8425b[i4] = 0;
            }
            this.f8408l++;
            this.f8405i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f8407k.remove(str);
            if (E()) {
                z().submit(this.f8410n);
            }
            return true;
        }
        return false;
    }

    public final void s() throws IOException {
        close();
        n(this.f8397a);
    }
}
