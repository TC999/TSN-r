package com.amap.api.col.p0463l;

import com.clj.fastble.BleManager;
import com.snail.antifake.deviceid.ShellAdbUtils;
import io.netty.handler.codec.http.HttpConstants;
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

/* renamed from: com.amap.api.col.3l.m6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DiskLruCache implements Closeable {

    /* renamed from: o */
    static final Pattern f4682o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: p */
    public static final Charset f4683p = Charset.forName("US-ASCII");

    /* renamed from: q */
    static final Charset f4684q = Charset.forName("UTF-8");

    /* renamed from: r */
    private static final ThreadFactory f4685r;

    /* renamed from: s */
    static ThreadPoolExecutor f4686s;

    /* renamed from: t */
    private static final OutputStream f4687t;

    /* renamed from: a */
    private final File f4688a;

    /* renamed from: b */
    private final File f4689b;

    /* renamed from: c */
    private final File f4690c;

    /* renamed from: d */
    private final File f4691d;

    /* renamed from: f */
    private long f4693f;

    /* renamed from: i */
    private Writer f4696i;

    /* renamed from: l */
    private int f4699l;

    /* renamed from: h */
    private long f4695h = 0;

    /* renamed from: j */
    private int f4697j = 1000;

    /* renamed from: k */
    private final LinkedHashMap<String, C1859f> f4698k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m */
    private long f4700m = 0;

    /* renamed from: n */
    private final Callable<Void> f4701n = new CallableC1854b();

    /* renamed from: e */
    private final int f4692e = 1;

    /* renamed from: g */
    private final int f4694g = 1;

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class ThreadFactoryC1853a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f4702a = new AtomicInteger(1);

        ThreadFactoryC1853a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f4702a.getAndIncrement());
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class CallableC1854b implements Callable<Void> {
        CallableC1854b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.f4696i == null) {
                    return null;
                }
                DiskLruCache.this.m54505N();
                if (DiskLruCache.this.m54507L()) {
                    DiskLruCache.this.m54508K();
                    DiskLruCache.m54516C(DiskLruCache.this);
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C1855c extends OutputStream {
        C1855c() {
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1856d {

        /* renamed from: a */
        private final C1859f f4704a;

        /* renamed from: b */
        private final boolean[] f4705b;

        /* renamed from: c */
        private boolean f4706c;

        /* renamed from: d */
        private boolean f4707d;

        /* compiled from: DiskLruCache.java */
        /* renamed from: com.amap.api.col.3l.m6$d$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        private class C1857a extends FilterOutputStream {
            /* synthetic */ C1857a(C1856d c1856d, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C1856d.m54480f(C1856d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C1856d.m54480f(C1856d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C1856d.m54480f(C1856d.this);
                }
            }

            private C1857a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C1856d.m54480f(C1856d.this);
                }
            }
        }

        /* synthetic */ C1856d(DiskLruCache diskLruCache, C1859f c1859f, byte b) {
            this(c1859f);
        }

        /* renamed from: f */
        static /* synthetic */ boolean m54480f(C1856d c1856d) {
            c1856d.f4706c = true;
            return true;
        }

        /* renamed from: b */
        public final OutputStream m54484b() throws IOException {
            FileOutputStream fileOutputStream;
            C1857a c1857a;
            if (DiskLruCache.this.f4694g > 0) {
                synchronized (DiskLruCache.this) {
                    if (this.f4704a.f4718d == this) {
                        if (!this.f4704a.f4717c) {
                            this.f4705b[0] = true;
                        }
                        File m54470i = this.f4704a.m54470i(0);
                        try {
                            fileOutputStream = new FileOutputStream(m54470i);
                        } catch (FileNotFoundException unused) {
                            DiskLruCache.this.f4688a.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(m54470i);
                            } catch (FileNotFoundException unused2) {
                                return DiskLruCache.f4687t;
                            }
                        }
                        c1857a = new C1857a(this, fileOutputStream, (byte) 0);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return c1857a;
            }
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + DiskLruCache.this.f4694g);
        }

        /* renamed from: c */
        public final void m54483c() throws IOException {
            if (this.f4706c) {
                DiskLruCache.this.m54499f(this, false);
                DiskLruCache.this.m54488r(this.f4704a.f4715a);
            } else {
                DiskLruCache.this.m54499f(this, true);
            }
            this.f4707d = true;
        }

        /* renamed from: e */
        public final void m54481e() throws IOException {
            DiskLruCache.this.m54499f(this, false);
        }

        private C1856d(C1859f c1859f) {
            this.f4704a = c1859f;
            this.f4705b = c1859f.f4717c ? null : new boolean[DiskLruCache.this.f4694g];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1858e implements Closeable {

        /* renamed from: a */
        private final String f4710a;

        /* renamed from: b */
        private final long f4711b;

        /* renamed from: c */
        private final InputStream[] f4712c;

        /* renamed from: d */
        private final long[] f4713d;

        /* synthetic */ C1858e(DiskLruCache diskLruCache, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
        }

        /* renamed from: a */
        public final InputStream m54479a() {
            return this.f4712c[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f4712c) {
                DiskLruCache.m54497h(inputStream);
            }
        }

        private C1858e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f4710a = str;
            this.f4711b = j;
            this.f4712c = inputStreamArr;
            this.f4713d = jArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.3l.m6$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1859f {

        /* renamed from: a */
        private final String f4715a;

        /* renamed from: b */
        private final long[] f4716b;

        /* renamed from: c */
        private boolean f4717c;

        /* renamed from: d */
        private C1856d f4718d;

        /* renamed from: e */
        private long f4719e;

        /* synthetic */ C1859f(DiskLruCache diskLruCache, String str, byte b) {
            this(str);
        }

        /* renamed from: d */
        private static IOException m54475d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: f */
        static /* synthetic */ void m54473f(C1859f c1859f, String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.f4694g) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        c1859f.f4716b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw m54475d(strArr);
                    }
                }
                return;
            }
            throw m54475d(strArr);
        }

        /* renamed from: g */
        static /* synthetic */ boolean m54472g(C1859f c1859f) {
            c1859f.f4717c = true;
            return true;
        }

        /* renamed from: c */
        public final File m54476c(int i) {
            File file = DiskLruCache.this.f4688a;
            return new File(file, this.f4715a + "." + i);
        }

        /* renamed from: e */
        public final String m54474e() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f4716b) {
                sb.append(HttpConstants.SP_CHAR);
                sb.append(j);
            }
            return sb.toString();
        }

        /* renamed from: i */
        public final File m54470i(int i) {
            File file = DiskLruCache.this.f4688a;
            return new File(file, this.f4715a + "." + i + ".tmp");
        }

        private C1859f(String str) {
            this.f4715a = str;
            this.f4716b = new long[DiskLruCache.this.f4694g];
        }
    }

    static {
        ThreadFactoryC1853a threadFactoryC1853a = new ThreadFactoryC1853a();
        f4685r = threadFactoryC1853a;
        f4686s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactoryC1853a);
        f4687t = new C1855c();
    }

    private DiskLruCache(File file, long j) {
        this.f4688a = file;
        this.f4689b = new File(file, "journal");
        this.f4690c = new File(file, "journal.tmp");
        this.f4691d = new File(file, "journal.bkp");
        this.f4693f = j;
    }

    /* renamed from: C */
    static /* synthetic */ int m54516C(DiskLruCache diskLruCache) {
        diskLruCache.f4699l = 0;
        return 0;
    }

    /* renamed from: E */
    private static void m54514E(String str) {
        if (f4682o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    /* renamed from: G */
    private static ThreadPoolExecutor m54512G() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f4686s;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f4686s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f4685r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f4686s;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ed, code lost:
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /* renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m54510I() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.DiskLruCache.m54510I():void");
    }

    /* renamed from: J */
    private void m54509J() throws IOException {
        m54496i(this.f4690c);
        Iterator<C1859f> it = this.f4698k.values().iterator();
        while (it.hasNext()) {
            C1859f next = it.next();
            int i = 0;
            if (next.f4718d == null) {
                while (i < this.f4694g) {
                    this.f4695h += next.f4716b[i];
                    i++;
                }
            } else {
                next.f4718d = null;
                while (i < this.f4694g) {
                    m54496i(next.m54476c(i));
                    m54496i(next.m54470i(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public synchronized void m54508K() throws IOException {
        Writer writer = this.f4696i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4690c), f4683p));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write("1");
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(Integer.toString(this.f4692e));
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(Integer.toString(this.f4694g));
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(ShellAdbUtils.f33810d);
        for (C1859f c1859f : this.f4698k.values()) {
            if (c1859f.f4718d != null) {
                bufferedWriter.write("DIRTY " + c1859f.f4715a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c1859f.f4715a + c1859f.m54474e() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f4689b.exists()) {
            m54495j(this.f4689b, this.f4691d, true);
        }
        m54495j(this.f4690c, this.f4689b, false);
        this.f4691d.delete();
        this.f4696i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4689b, true), f4683p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public boolean m54507L() {
        int i = this.f4699l;
        return i >= 2000 && i >= this.f4698k.size();
    }

    /* renamed from: M */
    private void m54506M() {
        if (this.f4696i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public void m54505N() throws IOException {
        while (true) {
            if (this.f4695h <= this.f4693f && this.f4698k.size() <= this.f4697j) {
                return;
            }
            m54488r(this.f4698k.entrySet().iterator().next().getKey());
        }
    }

    /* renamed from: b */
    public static DiskLruCache m54503b(File file, long j) throws IOException {
        if (j > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m54495j(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, j);
            if (diskLruCache.f4689b.exists()) {
                try {
                    diskLruCache.m54510I();
                    diskLruCache.m54509J();
                    diskLruCache.f4696i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.f4689b, true), f4683p));
                    return diskLruCache;
                } catch (Throwable unused) {
                    diskLruCache.m54518A();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, j);
            diskLruCache2.m54508K();
            return diskLruCache2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* renamed from: d */
    public static void m54501d() {
        ThreadPoolExecutor threadPoolExecutor = f4686s;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        f4686s.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public synchronized void m54499f(C1856d c1856d, boolean z) throws IOException {
        C1859f c1859f = c1856d.f4704a;
        if (c1859f.f4718d == c1856d) {
            if (z && !c1859f.f4717c) {
                for (int i = 0; i < this.f4694g; i++) {
                    if (c1856d.f4705b[i]) {
                        if (!c1859f.m54470i(i).exists()) {
                            c1856d.m54481e();
                            return;
                        }
                    } else {
                        c1856d.m54481e();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                    }
                }
            }
            for (int i2 = 0; i2 < this.f4694g; i2++) {
                File m54470i = c1859f.m54470i(i2);
                if (z) {
                    if (m54470i.exists()) {
                        File m54476c = c1859f.m54476c(i2);
                        m54470i.renameTo(m54476c);
                        long j = c1859f.f4716b[i2];
                        long length = m54476c.length();
                        c1859f.f4716b[i2] = length;
                        this.f4695h = (this.f4695h - j) + length;
                    }
                } else {
                    m54496i(m54470i);
                }
            }
            this.f4699l++;
            c1859f.f4718d = null;
            if (c1859f.f4717c | z) {
                C1859f.m54472g(c1859f);
                this.f4696i.write("CLEAN " + c1859f.f4715a + c1859f.m54474e() + '\n');
                if (z) {
                    long j2 = this.f4700m;
                    this.f4700m = 1 + j2;
                    c1859f.f4719e = j2;
                }
            } else {
                this.f4698k.remove(c1859f.f4715a);
                this.f4696i.write("REMOVE " + c1859f.f4715a + '\n');
            }
            this.f4696i.flush();
            if (this.f4695h > this.f4693f || m54507L()) {
                m54512G().submit(this.f4701n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: h */
    public static void m54497h(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: i */
    private static void m54496i(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: j */
    private static void m54495j(File file, File file2, boolean z) throws IOException {
        if (z) {
            m54496i(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: n */
    private static void m54491n(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m54491n(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                }
            }
            return;
        }
        throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
    }

    /* renamed from: s */
    private synchronized C1856d m54487s(String str) throws IOException {
        m54506M();
        m54514E(str);
        C1859f c1859f = this.f4698k.get(str);
        if (c1859f == null) {
            c1859f = new C1859f(this, str, (byte) 0);
            this.f4698k.put(str, c1859f);
        } else if (c1859f.f4718d != null) {
            return null;
        }
        C1856d c1856d = new C1856d(this, c1859f, (byte) 0);
        c1859f.f4718d = c1856d;
        Writer writer = this.f4696i;
        writer.write("DIRTY " + str + '\n');
        this.f4696i.flush();
        return c1856d;
    }

    /* renamed from: A */
    public final void m54518A() throws IOException {
        close();
        m54491n(this.f4688a);
    }

    /* renamed from: a */
    public final synchronized C1858e m54504a(String str) throws IOException {
        m54506M();
        m54514E(str);
        C1859f c1859f = this.f4698k.get(str);
        if (c1859f == null) {
            return null;
        }
        if (c1859f.f4717c) {
            InputStream[] inputStreamArr = new InputStream[this.f4694g];
            for (int i = 0; i < this.f4694g; i++) {
                try {
                    inputStreamArr[i] = new FileInputStream(c1859f.m54476c(i));
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < this.f4694g && inputStreamArr[i2] != null; i2++) {
                        m54497h(inputStreamArr[i2]);
                    }
                    return null;
                }
            }
            this.f4699l++;
            this.f4696i.append((CharSequence) ("READ " + str + '\n'));
            if (m54507L()) {
                m54512G().submit(this.f4701n);
            }
            return new C1858e(this, str, c1859f.f4719e, inputStreamArr, c1859f.f4716b, (byte) 0);
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.f4696i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f4698k.values()).iterator();
        while (it.hasNext()) {
            C1859f c1859f = (C1859f) it.next();
            if (c1859f.f4718d != null) {
                c1859f.f4718d.m54481e();
            }
        }
        m54505N();
        this.f4696i.close();
        this.f4696i = null;
    }

    /* renamed from: e */
    public final void m54500e(int i) {
        if (i < 10) {
            i = 10;
        } else if (i > 10000) {
            i = BleManager.f22896l;
        }
        this.f4697j = i;
    }

    /* renamed from: k */
    public final C1856d m54494k(String str) throws IOException {
        return m54487s(str);
    }

    /* renamed from: l */
    public final File m54493l() {
        return this.f4688a;
    }

    /* renamed from: p */
    public final synchronized void m54490p() throws IOException {
        m54506M();
        m54505N();
        this.f4696i.flush();
    }

    /* renamed from: r */
    public final synchronized boolean m54488r(String str) throws IOException {
        m54506M();
        m54514E(str);
        C1859f c1859f = this.f4698k.get(str);
        if (c1859f != null && c1859f.f4718d == null) {
            for (int i = 0; i < this.f4694g; i++) {
                File m54476c = c1859f.m54476c(i);
                if (m54476c.exists() && !m54476c.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(m54476c)));
                }
                this.f4695h -= c1859f.f4716b[i];
                c1859f.f4716b[i] = 0;
            }
            this.f4699l++;
            this.f4696i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f4698k.remove(str);
            if (m54507L()) {
                m54512G().submit(this.f4701n);
            }
            return true;
        }
        return false;
    }
}
