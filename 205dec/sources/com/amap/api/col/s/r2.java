package com.amap.api.col.s;

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
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class r2 implements Closeable {

    /* renamed from: o  reason: collision with root package name */
    static final Pattern f10147o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: p  reason: collision with root package name */
    public static final Charset f10148p = Charset.forName("US-ASCII");

    /* renamed from: q  reason: collision with root package name */
    static final Charset f10149q = Charset.forName("UTF-8");

    /* renamed from: r  reason: collision with root package name */
    private static final ThreadFactory f10150r;

    /* renamed from: s  reason: collision with root package name */
    static ThreadPoolExecutor f10151s;

    /* renamed from: t  reason: collision with root package name */
    private static final OutputStream f10152t;

    /* renamed from: a  reason: collision with root package name */
    private final File f10153a;

    /* renamed from: b  reason: collision with root package name */
    private final File f10154b;

    /* renamed from: c  reason: collision with root package name */
    private final File f10155c;

    /* renamed from: d  reason: collision with root package name */
    private final File f10156d;

    /* renamed from: f  reason: collision with root package name */
    private long f10158f;

    /* renamed from: i  reason: collision with root package name */
    private Writer f10161i;

    /* renamed from: l  reason: collision with root package name */
    private int f10164l;

    /* renamed from: h  reason: collision with root package name */
    private long f10160h = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f10162j = 1000;

    /* renamed from: k  reason: collision with root package name */
    private final LinkedHashMap<String, f> f10163k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m  reason: collision with root package name */
    private long f10165m = 0;

    /* renamed from: n  reason: collision with root package name */
    private final Callable<Void> f10166n = new b();

    /* renamed from: e  reason: collision with root package name */
    private final int f10157e = 1;

    /* renamed from: g  reason: collision with root package name */
    private final int f10159g = 1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DiskLruCache.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f10167a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f10167a.getAndIncrement());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DiskLruCache.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Callable<Void> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (r2.this) {
                if (r2.this.f10161i == null) {
                    return null;
                }
                r2.this.G();
                if (r2.this.E()) {
                    r2.this.D();
                    r2.w(r2.this);
                }
                return null;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DiskLruCache.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream
        public final void write(int i4) throws IOException {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DiskLruCache.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        private final f f10169a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f10170b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10171c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f10172d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: DiskLruCache.java */
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

        /* synthetic */ d(r2 r2Var, f fVar, byte b4) {
            this(fVar);
        }

        static /* synthetic */ boolean f(d dVar) {
            dVar.f10171c = true;
            return true;
        }

        public final OutputStream b() throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (r2.this.f10159g > 0) {
                synchronized (r2.this) {
                    if (this.f10169a.f10183d == this) {
                        if (!this.f10169a.f10182c) {
                            this.f10170b[0] = true;
                        }
                        File i4 = this.f10169a.i(0);
                        try {
                            fileOutputStream = new FileOutputStream(i4);
                        } catch (FileNotFoundException unused) {
                            r2.this.f10153a.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(i4);
                            } catch (FileNotFoundException unused2) {
                                return r2.f10152t;
                            }
                        }
                        aVar = new a(this, fileOutputStream, (byte) 0);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return aVar;
            }
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + r2.this.f10159g);
        }

        public final void c() throws IOException {
            if (this.f10171c) {
                r2.this.g(this, false);
                r2.this.s(this.f10169a.f10180a);
            } else {
                r2.this.g(this, true);
            }
            this.f10172d = true;
        }

        public final void e() throws IOException {
            r2.this.g(this, false);
        }

        private d(f fVar) {
            this.f10169a = fVar;
            this.f10170b = fVar.f10182c ? null : new boolean[r2.this.f10159g];
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DiskLruCache.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class e implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        private final String f10175a;

        /* renamed from: b  reason: collision with root package name */
        private final long f10176b;

        /* renamed from: c  reason: collision with root package name */
        private final InputStream[] f10177c;

        /* renamed from: d  reason: collision with root package name */
        private final long[] f10178d;

        /* synthetic */ e(r2 r2Var, String str, long j4, InputStream[] inputStreamArr, long[] jArr, byte b4) {
            this(str, j4, inputStreamArr, jArr);
        }

        public final InputStream b() {
            return this.f10177c[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f10177c) {
                r2.i(inputStream);
            }
        }

        private e(String str, long j4, InputStream[] inputStreamArr, long[] jArr) {
            this.f10175a = str;
            this.f10176b = j4;
            this.f10177c = inputStreamArr;
            this.f10178d = jArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DiskLruCache.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class f {

        /* renamed from: a  reason: collision with root package name */
        private final String f10180a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f10181b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10182c;

        /* renamed from: d  reason: collision with root package name */
        private d f10183d;

        /* renamed from: e  reason: collision with root package name */
        private long f10184e;

        /* synthetic */ f(r2 r2Var, String str, byte b4) {
            this(str);
        }

        private static IOException d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ void f(f fVar, String[] strArr) throws IOException {
            if (strArr.length == r2.this.f10159g) {
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    try {
                        fVar.f10181b[i4] = Long.parseLong(strArr[i4]);
                    } catch (NumberFormatException unused) {
                        throw d(strArr);
                    }
                }
                return;
            }
            throw d(strArr);
        }

        static /* synthetic */ boolean g(f fVar) {
            fVar.f10182c = true;
            return true;
        }

        public final File c(int i4) {
            File file = r2.this.f10153a;
            return new File(file, this.f10180a + "." + i4);
        }

        public final String e() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j4 : this.f10181b) {
                sb.append(' ');
                sb.append(j4);
            }
            return sb.toString();
        }

        public final File i(int i4) {
            File file = r2.this.f10153a;
            return new File(file, this.f10180a + "." + i4 + ".tmp");
        }

        private f(String str) {
            this.f10180a = str;
            this.f10181b = new long[r2.this.f10159g];
        }
    }

    static {
        a aVar = new a();
        f10150r = aVar;
        f10151s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
        f10152t = new c();
    }

    private r2(File file, long j4) {
        this.f10153a = file;
        this.f10154b = new File(file, "journal");
        this.f10155c = new File(file, "journal.tmp");
        this.f10156d = new File(file, "journal.bkp");
        this.f10158f = j4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ed, code lost:
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.r2.A():void");
    }

    private void C() throws IOException {
        j(this.f10155c);
        Iterator<f> it = this.f10163k.values().iterator();
        while (it.hasNext()) {
            f next = it.next();
            int i4 = 0;
            if (next.f10183d == null) {
                while (i4 < this.f10159g) {
                    this.f10160h += next.f10181b[i4];
                    i4++;
                }
            } else {
                next.f10183d = null;
                while (i4 < this.f10159g) {
                    j(next.c(i4));
                    j(next.i(i4));
                    i4++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void D() throws IOException {
        Writer writer = this.f10161i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10155c), f10148p));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f10157e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f10159g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (f fVar : this.f10163k.values()) {
            if (fVar.f10183d != null) {
                bufferedWriter.write("DIRTY " + fVar.f10180a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + fVar.f10180a + fVar.e() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f10154b.exists()) {
            k(this.f10154b, this.f10156d, true);
        }
        k(this.f10155c, this.f10154b, false);
        this.f10156d.delete();
        this.f10161i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10154b, true), f10148p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E() {
        int i4 = this.f10164l;
        return i4 >= 2000 && i4 >= this.f10163k.size();
    }

    private void F() {
        if (this.f10161i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() throws IOException {
        while (true) {
            if (this.f10160h <= this.f10158f && this.f10163k.size() <= this.f10162j) {
                return;
            }
            s(this.f10163k.entrySet().iterator().next().getKey());
        }
    }

    public static r2 b(File file, long j4) throws IOException {
        if (j4 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    k(file2, file3, false);
                }
            }
            r2 r2Var = new r2(file, j4);
            if (r2Var.f10154b.exists()) {
                try {
                    r2Var.A();
                    r2Var.C();
                    r2Var.f10161i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r2Var.f10154b, true), f10148p));
                    return r2Var;
                } catch (Throwable unused) {
                    r2Var.q();
                }
            }
            file.mkdirs();
            r2 r2Var2 = new r2(file, j4);
            r2Var2.D();
            return r2Var2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(d dVar, boolean z3) throws IOException {
        f fVar = dVar.f10169a;
        if (fVar.f10183d == dVar) {
            if (z3 && !fVar.f10182c) {
                for (int i4 = 0; i4 < this.f10159g; i4++) {
                    if (dVar.f10170b[i4]) {
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
            for (int i5 = 0; i5 < this.f10159g; i5++) {
                File i6 = fVar.i(i5);
                if (z3) {
                    if (i6.exists()) {
                        File c4 = fVar.c(i5);
                        i6.renameTo(c4);
                        long j4 = fVar.f10181b[i5];
                        long length = c4.length();
                        fVar.f10181b[i5] = length;
                        this.f10160h = (this.f10160h - j4) + length;
                    }
                } else {
                    j(i6);
                }
            }
            this.f10164l++;
            fVar.f10183d = null;
            if (fVar.f10182c | z3) {
                f.g(fVar);
                this.f10161i.write("CLEAN " + fVar.f10180a + fVar.e() + '\n');
                if (z3) {
                    long j5 = this.f10165m;
                    this.f10165m = 1 + j5;
                    fVar.f10184e = j5;
                }
            } else {
                this.f10163k.remove(fVar.f10180a);
                this.f10161i.write("REMOVE " + fVar.f10180a + '\n');
            }
            this.f10161i.flush();
            if (this.f10160h > this.f10158f || E()) {
                x().submit(this.f10166n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public static void i(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused) {
            }
        }
    }

    private static void j(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void k(File file, File file2, boolean z3) throws IOException {
        if (z3) {
            j(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private static void o(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    o(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }

    private synchronized d t(String str) throws IOException {
        F();
        y(str);
        f fVar = this.f10163k.get(str);
        if (fVar == null) {
            fVar = new f(this, str, (byte) 0);
            this.f10163k.put(str, fVar);
        } else if (fVar.f10183d != null) {
            return null;
        }
        d dVar = new d(this, fVar, (byte) 0);
        fVar.f10183d = dVar;
        Writer writer = this.f10161i;
        writer.write("DIRTY " + str + '\n');
        this.f10161i.flush();
        return dVar;
    }

    static /* synthetic */ int w(r2 r2Var) {
        r2Var.f10164l = 0;
        return 0;
    }

    private static ThreadPoolExecutor x() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f10151s;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f10151s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f10150r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f10151s;
    }

    private static void y(String str) {
        if (f10147o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public final synchronized e a(String str) throws IOException {
        F();
        y(str);
        f fVar = this.f10163k.get(str);
        if (fVar == null) {
            return null;
        }
        if (fVar.f10182c) {
            InputStream[] inputStreamArr = new InputStream[this.f10159g];
            for (int i4 = 0; i4 < this.f10159g; i4++) {
                try {
                    inputStreamArr[i4] = new FileInputStream(fVar.c(i4));
                } catch (FileNotFoundException unused) {
                    for (int i5 = 0; i5 < this.f10159g && inputStreamArr[i5] != null; i5++) {
                        i(inputStreamArr[i5]);
                    }
                    return null;
                }
            }
            this.f10164l++;
            this.f10161i.append((CharSequence) ("READ " + str + '\n'));
            if (E()) {
                x().submit(this.f10166n);
            }
            return new e(this, str, fVar.f10184e, inputStreamArr, fVar.f10181b, (byte) 0);
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.f10161i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f10163k.values()).iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.f10183d != null) {
                fVar.f10183d.e();
            }
        }
        G();
        this.f10161i.close();
        this.f10161i = null;
    }

    public final File d() {
        return this.f10153a;
    }

    public final void f(int i4) {
        if (i4 < 10) {
            i4 = 10;
        } else if (i4 > 10000) {
            i4 = 10000;
        }
        this.f10162j = i4;
    }

    public final d l(String str) throws IOException {
        return t(str);
    }

    public final synchronized void m() throws IOException {
        F();
        G();
        this.f10161i.flush();
    }

    public final void q() throws IOException {
        close();
        o(this.f10153a);
    }

    public final synchronized boolean s(String str) throws IOException {
        F();
        y(str);
        f fVar = this.f10163k.get(str);
        if (fVar != null && fVar.f10183d == null) {
            for (int i4 = 0; i4 < this.f10159g; i4++) {
                File c4 = fVar.c(i4);
                if (c4.exists() && !c4.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(c4)));
                }
                this.f10160h -= fVar.f10181b[i4];
                fVar.f10181b[i4] = 0;
            }
            this.f10164l++;
            this.f10161i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f10163k.remove(str);
            if (E()) {
                x().submit(this.f10166n);
            }
            return true;
        }
        return false;
    }
}
