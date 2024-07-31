package com.amap.api.col.p047s;

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

/* compiled from: DiskLruCache.java */
/* renamed from: com.amap.api.col.s.r2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2129r2 implements Closeable {

    /* renamed from: o */
    static final Pattern f6419o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: p */
    public static final Charset f6420p = Charset.forName("US-ASCII");

    /* renamed from: q */
    static final Charset f6421q = Charset.forName("UTF-8");

    /* renamed from: r */
    private static final ThreadFactory f6422r;

    /* renamed from: s */
    static ThreadPoolExecutor f6423s;

    /* renamed from: t */
    private static final OutputStream f6424t;

    /* renamed from: a */
    private final File f6425a;

    /* renamed from: b */
    private final File f6426b;

    /* renamed from: c */
    private final File f6427c;

    /* renamed from: d */
    private final File f6428d;

    /* renamed from: f */
    private long f6430f;

    /* renamed from: i */
    private Writer f6433i;

    /* renamed from: l */
    private int f6436l;

    /* renamed from: h */
    private long f6432h = 0;

    /* renamed from: j */
    private int f6434j = 1000;

    /* renamed from: k */
    private final LinkedHashMap<String, C2136f> f6435k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m */
    private long f6437m = 0;

    /* renamed from: n */
    private final Callable<Void> f6438n = new CallableC2131b();

    /* renamed from: e */
    private final int f6429e = 1;

    /* renamed from: g */
    private final int f6431g = 1;

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.s.r2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class ThreadFactoryC2130a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f6439a = new AtomicInteger(1);

        ThreadFactoryC2130a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f6439a.getAndIncrement());
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.s.r2$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class CallableC2131b implements Callable<Void> {
        CallableC2131b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            synchronized (C2129r2.this) {
                if (C2129r2.this.f6433i == null) {
                    return null;
                }
                C2129r2.this.m52617M();
                if (C2129r2.this.m52619K()) {
                    C2129r2.this.m52620J();
                    C2129r2.m52627C(C2129r2.this);
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.s.r2$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class C2132c extends OutputStream {
        C2132c() {
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.s.r2$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2133d {

        /* renamed from: a */
        private final C2136f f6441a;

        /* renamed from: b */
        private final boolean[] f6442b;

        /* renamed from: c */
        private boolean f6443c;

        /* renamed from: d */
        private boolean f6444d;

        /* compiled from: DiskLruCache.java */
        /* renamed from: com.amap.api.col.s.r2$d$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        private class C2134a extends FilterOutputStream {
            /* synthetic */ C2134a(C2133d c2133d, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C2133d.m52592f(C2133d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C2133d.m52592f(C2133d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C2133d.m52592f(C2133d.this);
                }
            }

            private C2134a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C2133d.m52592f(C2133d.this);
                }
            }
        }

        /* synthetic */ C2133d(C2129r2 c2129r2, C2136f c2136f, byte b) {
            this(c2136f);
        }

        /* renamed from: f */
        static /* synthetic */ boolean m52592f(C2133d c2133d) {
            c2133d.f6443c = true;
            return true;
        }

        /* renamed from: b */
        public final OutputStream m52596b() throws IOException {
            FileOutputStream fileOutputStream;
            C2134a c2134a;
            if (C2129r2.this.f6431g > 0) {
                synchronized (C2129r2.this) {
                    if (this.f6441a.f6455d == this) {
                        if (!this.f6441a.f6454c) {
                            this.f6442b[0] = true;
                        }
                        File m52582i = this.f6441a.m52582i(0);
                        try {
                            fileOutputStream = new FileOutputStream(m52582i);
                        } catch (FileNotFoundException unused) {
                            C2129r2.this.f6425a.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(m52582i);
                            } catch (FileNotFoundException unused2) {
                                return C2129r2.f6424t;
                            }
                        }
                        c2134a = new C2134a(this, fileOutputStream, (byte) 0);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return c2134a;
            }
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + C2129r2.this.f6431g);
        }

        /* renamed from: c */
        public final void m52595c() throws IOException {
            if (this.f6443c) {
                C2129r2.this.m52611f(this, false);
                C2129r2.this.m52600r(this.f6441a.f6452a);
            } else {
                C2129r2.this.m52611f(this, true);
            }
            this.f6444d = true;
        }

        /* renamed from: e */
        public final void m52593e() throws IOException {
            C2129r2.this.m52611f(this, false);
        }

        private C2133d(C2136f c2136f) {
            this.f6441a = c2136f;
            this.f6442b = c2136f.f6454c ? null : new boolean[C2129r2.this.f6431g];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.s.r2$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2135e implements Closeable {

        /* renamed from: a */
        private final String f6447a;

        /* renamed from: b */
        private final long f6448b;

        /* renamed from: c */
        private final InputStream[] f6449c;

        /* renamed from: d */
        private final long[] f6450d;

        /* synthetic */ C2135e(C2129r2 c2129r2, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
        }

        /* renamed from: a */
        public final InputStream m52591a() {
            return this.f6449c[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f6449c) {
                C2129r2.m52609h(inputStream);
            }
        }

        private C2135e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f6447a = str;
            this.f6448b = j;
            this.f6449c = inputStreamArr;
            this.f6450d = jArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.amap.api.col.s.r2$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2136f {

        /* renamed from: a */
        private final String f6452a;

        /* renamed from: b */
        private final long[] f6453b;

        /* renamed from: c */
        private boolean f6454c;

        /* renamed from: d */
        private C2133d f6455d;

        /* renamed from: e */
        private long f6456e;

        /* synthetic */ C2136f(C2129r2 c2129r2, String str, byte b) {
            this(str);
        }

        /* renamed from: d */
        private static IOException m52587d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: f */
        static /* synthetic */ void m52585f(C2136f c2136f, String[] strArr) throws IOException {
            if (strArr.length == C2129r2.this.f6431g) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        c2136f.f6453b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw m52587d(strArr);
                    }
                }
                return;
            }
            throw m52587d(strArr);
        }

        /* renamed from: g */
        static /* synthetic */ boolean m52584g(C2136f c2136f) {
            c2136f.f6454c = true;
            return true;
        }

        /* renamed from: c */
        public final File m52588c(int i) {
            File file = C2129r2.this.f6425a;
            return new File(file, this.f6452a + "." + i);
        }

        /* renamed from: e */
        public final String m52586e() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f6453b) {
                sb.append(HttpConstants.SP_CHAR);
                sb.append(j);
            }
            return sb.toString();
        }

        /* renamed from: i */
        public final File m52582i(int i) {
            File file = C2129r2.this.f6425a;
            return new File(file, this.f6452a + "." + i + ".tmp");
        }

        private C2136f(String str) {
            this.f6452a = str;
            this.f6453b = new long[C2129r2.this.f6431g];
        }
    }

    static {
        ThreadFactoryC2130a threadFactoryC2130a = new ThreadFactoryC2130a();
        f6422r = threadFactoryC2130a;
        f6423s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactoryC2130a);
        f6424t = new C2132c();
    }

    private C2129r2(File file, long j) {
        this.f6425a = file;
        this.f6426b = new File(file, "journal");
        this.f6427c = new File(file, "journal.tmp");
        this.f6428d = new File(file, "journal.bkp");
        this.f6430f = j;
    }

    /* renamed from: C */
    static /* synthetic */ int m52627C(C2129r2 c2129r2) {
        c2129r2.f6436l = 0;
        return 0;
    }

    /* renamed from: D */
    private static ThreadPoolExecutor m52626D() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f6423s;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f6423s = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f6422r);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f6423s;
    }

    /* renamed from: E */
    private static void m52625E(String str) {
        if (f6419o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ed, code lost:
        throw new java.io.IOException("unexpected journal line: ".concat(r3));
     */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m52623G() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.C2129r2.m52623G():void");
    }

    /* renamed from: I */
    private void m52621I() throws IOException {
        m52608i(this.f6427c);
        Iterator<C2136f> it = this.f6435k.values().iterator();
        while (it.hasNext()) {
            C2136f next = it.next();
            int i = 0;
            if (next.f6455d == null) {
                while (i < this.f6431g) {
                    this.f6432h += next.f6453b[i];
                    i++;
                }
            } else {
                next.f6455d = null;
                while (i < this.f6431g) {
                    m52608i(next.m52588c(i));
                    m52608i(next.m52582i(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public synchronized void m52620J() throws IOException {
        Writer writer = this.f6433i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f6427c), f6420p));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write("1");
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(Integer.toString(this.f6429e));
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(Integer.toString(this.f6431g));
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(ShellAdbUtils.f33810d);
        for (C2136f c2136f : this.f6435k.values()) {
            if (c2136f.f6455d != null) {
                bufferedWriter.write("DIRTY " + c2136f.f6452a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c2136f.f6452a + c2136f.m52586e() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f6426b.exists()) {
            m52607j(this.f6426b, this.f6428d, true);
        }
        m52607j(this.f6427c, this.f6426b, false);
        this.f6428d.delete();
        this.f6433i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f6426b, true), f6420p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public boolean m52619K() {
        int i = this.f6436l;
        return i >= 2000 && i >= this.f6435k.size();
    }

    /* renamed from: L */
    private void m52618L() {
        if (this.f6433i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public void m52617M() throws IOException {
        while (true) {
            if (this.f6432h <= this.f6430f && this.f6435k.size() <= this.f6434j) {
                return;
            }
            m52600r(this.f6435k.entrySet().iterator().next().getKey());
        }
    }

    /* renamed from: b */
    public static C2129r2 m52615b(File file, long j) throws IOException {
        if (j > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m52607j(file2, file3, false);
                }
            }
            C2129r2 c2129r2 = new C2129r2(file, j);
            if (c2129r2.f6426b.exists()) {
                try {
                    c2129r2.m52623G();
                    c2129r2.m52621I();
                    c2129r2.f6433i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c2129r2.f6426b, true), f6420p));
                    return c2129r2;
                } catch (Throwable unused) {
                    c2129r2.m52602p();
                }
            }
            file.mkdirs();
            C2129r2 c2129r22 = new C2129r2(file, j);
            c2129r22.m52620J();
            return c2129r22;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public synchronized void m52611f(C2133d c2133d, boolean z) throws IOException {
        C2136f c2136f = c2133d.f6441a;
        if (c2136f.f6455d == c2133d) {
            if (z && !c2136f.f6454c) {
                for (int i = 0; i < this.f6431g; i++) {
                    if (c2133d.f6442b[i]) {
                        if (!c2136f.m52582i(i).exists()) {
                            c2133d.m52593e();
                            return;
                        }
                    } else {
                        c2133d.m52593e();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                    }
                }
            }
            for (int i2 = 0; i2 < this.f6431g; i2++) {
                File m52582i = c2136f.m52582i(i2);
                if (z) {
                    if (m52582i.exists()) {
                        File m52588c = c2136f.m52588c(i2);
                        m52582i.renameTo(m52588c);
                        long j = c2136f.f6453b[i2];
                        long length = m52588c.length();
                        c2136f.f6453b[i2] = length;
                        this.f6432h = (this.f6432h - j) + length;
                    }
                } else {
                    m52608i(m52582i);
                }
            }
            this.f6436l++;
            c2136f.f6455d = null;
            if (c2136f.f6454c | z) {
                C2136f.m52584g(c2136f);
                this.f6433i.write("CLEAN " + c2136f.f6452a + c2136f.m52586e() + '\n');
                if (z) {
                    long j2 = this.f6437m;
                    this.f6437m = 1 + j2;
                    c2136f.f6456e = j2;
                }
            } else {
                this.f6435k.remove(c2136f.f6452a);
                this.f6433i.write("REMOVE " + c2136f.f6452a + '\n');
            }
            this.f6433i.flush();
            if (this.f6432h > this.f6430f || m52619K()) {
                m52626D().submit(this.f6438n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: h */
    public static void m52609h(Closeable closeable) {
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
    private static void m52608i(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: j */
    private static void m52607j(File file, File file2, boolean z) throws IOException {
        if (z) {
            m52608i(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: n */
    private static void m52603n(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m52603n(file2);
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
    private synchronized C2133d m52599s(String str) throws IOException {
        m52618L();
        m52625E(str);
        C2136f c2136f = this.f6435k.get(str);
        if (c2136f == null) {
            c2136f = new C2136f(this, str, (byte) 0);
            this.f6435k.put(str, c2136f);
        } else if (c2136f.f6455d != null) {
            return null;
        }
        C2133d c2133d = new C2133d(this, c2136f, (byte) 0);
        c2136f.f6455d = c2133d;
        Writer writer = this.f6433i;
        writer.write("DIRTY " + str + '\n');
        this.f6433i.flush();
        return c2133d;
    }

    /* renamed from: a */
    public final synchronized C2135e m52616a(String str) throws IOException {
        m52618L();
        m52625E(str);
        C2136f c2136f = this.f6435k.get(str);
        if (c2136f == null) {
            return null;
        }
        if (c2136f.f6454c) {
            InputStream[] inputStreamArr = new InputStream[this.f6431g];
            for (int i = 0; i < this.f6431g; i++) {
                try {
                    inputStreamArr[i] = new FileInputStream(c2136f.m52588c(i));
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < this.f6431g && inputStreamArr[i2] != null; i2++) {
                        m52609h(inputStreamArr[i2]);
                    }
                    return null;
                }
            }
            this.f6436l++;
            this.f6433i.append((CharSequence) ("READ " + str + '\n'));
            if (m52619K()) {
                m52626D().submit(this.f6438n);
            }
            return new C2135e(this, str, c2136f.f6456e, inputStreamArr, c2136f.f6453b, (byte) 0);
        }
        return null;
    }

    /* renamed from: c */
    public final File m52614c() {
        return this.f6425a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.f6433i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f6435k.values()).iterator();
        while (it.hasNext()) {
            C2136f c2136f = (C2136f) it.next();
            if (c2136f.f6455d != null) {
                c2136f.f6455d.m52593e();
            }
        }
        m52617M();
        this.f6433i.close();
        this.f6433i = null;
    }

    /* renamed from: e */
    public final void m52612e(int i) {
        if (i < 10) {
            i = 10;
        } else if (i > 10000) {
            i = BleManager.f22896l;
        }
        this.f6434j = i;
    }

    /* renamed from: k */
    public final C2133d m52606k(String str) throws IOException {
        return m52599s(str);
    }

    /* renamed from: l */
    public final synchronized void m52605l() throws IOException {
        m52618L();
        m52617M();
        this.f6433i.flush();
    }

    /* renamed from: p */
    public final void m52602p() throws IOException {
        close();
        m52603n(this.f6425a);
    }

    /* renamed from: r */
    public final synchronized boolean m52600r(String str) throws IOException {
        m52618L();
        m52625E(str);
        C2136f c2136f = this.f6435k.get(str);
        if (c2136f != null && c2136f.f6455d == null) {
            for (int i = 0; i < this.f6431g; i++) {
                File m52588c = c2136f.m52588c(i);
                if (m52588c.exists() && !m52588c.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(m52588c)));
                }
                this.f6432h -= c2136f.f6453b[i];
                c2136f.f6453b[i] = 0;
            }
            this.f6436l++;
            this.f6433i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f6435k.remove(str);
            if (m52619K()) {
                m52626D().submit(this.f6438n);
            }
            return true;
        }
        return false;
    }
}
