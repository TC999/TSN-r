package com.bumptech.glide.disklrucache;

import com.snail.antifake.deviceid.ShellAdbUtils;
import io.netty.handler.codec.http.HttpConstants;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* renamed from: com.bumptech.glide.disklrucache.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C3541a implements Closeable {

    /* renamed from: o */
    static final String f13247o = "journal";

    /* renamed from: p */
    static final String f13248p = "journal.tmp";

    /* renamed from: q */
    static final String f13249q = "journal.bkp";

    /* renamed from: r */
    static final String f13250r = "libcore.io.DiskLruCache";

    /* renamed from: s */
    static final String f13251s = "1";

    /* renamed from: t */
    static final long f13252t = -1;

    /* renamed from: u */
    private static final String f13253u = "CLEAN";

    /* renamed from: v */
    private static final String f13254v = "DIRTY";

    /* renamed from: w */
    private static final String f13255w = "REMOVE";

    /* renamed from: x */
    private static final String f13256x = "READ";

    /* renamed from: a */
    private final File f13257a;

    /* renamed from: b */
    private final File f13258b;

    /* renamed from: c */
    private final File f13259c;

    /* renamed from: d */
    private final File f13260d;

    /* renamed from: e */
    private final int f13261e;

    /* renamed from: f */
    private long f13262f;

    /* renamed from: g */
    private final int f13263g;

    /* renamed from: i */
    private Writer f13265i;

    /* renamed from: k */
    private int f13267k;

    /* renamed from: h */
    private long f13264h = 0;

    /* renamed from: j */
    private final LinkedHashMap<String, C3545d> f13266j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l */
    private long f13268l = 0;

    /* renamed from: m */
    final ThreadPoolExecutor f13269m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC3543b(null));

    /* renamed from: n */
    private final Callable<Void> f13270n = new CallableC3542a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.disklrucache.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class CallableC3542a implements Callable<Void> {
        CallableC3542a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (C3541a.this) {
                if (C3541a.this.f13265i == null) {
                    return null;
                }
                C3541a.this.m45711K();
                if (C3541a.this.m45721A()) {
                    C3541a.this.m45716F();
                    C3541a.this.f13267k = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.disklrucache.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class ThreadFactoryC3543b implements ThreadFactory {
        private ThreadFactoryC3543b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ ThreadFactoryC3543b(CallableC3542a callableC3542a) {
            this();
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.disklrucache.a$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C3544c {

        /* renamed from: a */
        private final C3545d f13272a;

        /* renamed from: b */
        private final boolean[] f13273b;

        /* renamed from: c */
        private boolean f13274c;

        /* synthetic */ C3544c(C3541a c3541a, C3545d c3545d, CallableC3542a callableC3542a) {
            this(c3545d);
        }

        /* renamed from: h */
        private InputStream m45684h(int i) throws IOException {
            synchronized (C3541a.this) {
                if (this.f13272a.f13281f == this) {
                    if (this.f13272a.f13280e) {
                        try {
                            return new FileInputStream(this.f13272a.m45673j(i));
                        } catch (FileNotFoundException unused) {
                            return null;
                        }
                    }
                    return null;
                }
                throw new IllegalStateException();
            }
        }

        /* renamed from: a */
        public void m45691a() throws IOException {
            C3541a.this.m45699l(this, false);
        }

        /* renamed from: b */
        public void m45690b() {
            if (this.f13274c) {
                return;
            }
            try {
                m45691a();
            } catch (IOException unused) {
            }
        }

        /* renamed from: e */
        public void m45687e() throws IOException {
            C3541a.this.m45699l(this, true);
            this.f13274c = true;
        }

        /* renamed from: f */
        public File m45686f(int i) throws IOException {
            File m45672k;
            synchronized (C3541a.this) {
                if (this.f13272a.f13281f == this) {
                    if (!this.f13272a.f13280e) {
                        this.f13273b[i] = true;
                    }
                    m45672k = this.f13272a.m45672k(i);
                    if (!C3541a.this.f13257a.exists()) {
                        C3541a.this.f13257a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return m45672k;
        }

        /* renamed from: g */
        public String m45685g(int i) throws IOException {
            InputStream m45684h = m45684h(i);
            if (m45684h != null) {
                return C3541a.m45692s(m45684h);
            }
            return null;
        }

        /* renamed from: i */
        public void m45683i(int i, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(m45686f(i)), C3549c.f13298b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                C3549c.m45660a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                C3549c.m45660a(outputStreamWriter2);
                throw th;
            }
        }

        private C3544c(C3545d c3545d) {
            this.f13272a = c3545d;
            this.f13273b = c3545d.f13280e ? null : new boolean[C3541a.this.f13263g];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.disklrucache.a$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C3545d {

        /* renamed from: a */
        private final String f13276a;

        /* renamed from: b */
        private final long[] f13277b;

        /* renamed from: c */
        File[] f13278c;

        /* renamed from: d */
        File[] f13279d;

        /* renamed from: e */
        private boolean f13280e;

        /* renamed from: f */
        private C3544c f13281f;

        /* renamed from: g */
        private long f13282g;

        /* synthetic */ C3545d(C3541a c3541a, String str, CallableC3542a callableC3542a) {
            this(str);
        }

        /* renamed from: m */
        private IOException m45670m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public void m45669n(String[] strArr) throws IOException {
            if (strArr.length == C3541a.this.f13263g) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.f13277b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw m45670m(strArr);
                    }
                }
                return;
            }
            throw m45670m(strArr);
        }

        /* renamed from: j */
        public File m45673j(int i) {
            return this.f13278c[i];
        }

        /* renamed from: k */
        public File m45672k(int i) {
            return this.f13279d[i];
        }

        /* renamed from: l */
        public String m45671l() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f13277b) {
                sb.append(HttpConstants.SP_CHAR);
                sb.append(j);
            }
            return sb.toString();
        }

        private C3545d(String str) {
            this.f13276a = str;
            this.f13277b = new long[C3541a.this.f13263g];
            this.f13278c = new File[C3541a.this.f13263g];
            this.f13279d = new File[C3541a.this.f13263g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < C3541a.this.f13263g; i++) {
                sb.append(i);
                this.f13278c[i] = new File(C3541a.this.f13257a, sb.toString());
                sb.append(".tmp");
                this.f13279d[i] = new File(C3541a.this.f13257a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.disklrucache.a$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C3546e {

        /* renamed from: a */
        private final String f13284a;

        /* renamed from: b */
        private final long f13285b;

        /* renamed from: c */
        private final long[] f13286c;

        /* renamed from: d */
        private final File[] f13287d;

        /* synthetic */ C3546e(C3541a c3541a, String str, long j, File[] fileArr, long[] jArr, CallableC3542a callableC3542a) {
            this(str, j, fileArr, jArr);
        }

        /* renamed from: a */
        public C3544c m45668a() throws IOException {
            return C3541a.this.m45696o(this.f13284a, this.f13285b);
        }

        /* renamed from: b */
        public File m45667b(int i) {
            return this.f13287d[i];
        }

        /* renamed from: c */
        public long m45666c(int i) {
            return this.f13286c[i];
        }

        /* renamed from: d */
        public String m45665d(int i) throws IOException {
            return C3541a.m45692s(new FileInputStream(this.f13287d[i]));
        }

        private C3546e(String str, long j, File[] fileArr, long[] jArr) {
            this.f13284a = str;
            this.f13285b = j;
            this.f13287d = fileArr;
            this.f13286c = jArr;
        }
    }

    private C3541a(File file, int i, int i2, long j) {
        this.f13257a = file;
        this.f13261e = i;
        this.f13258b = new File(file, f13247o);
        this.f13259c = new File(file, f13248p);
        this.f13260d = new File(file, f13249q);
        this.f13263g = i2;
        this.f13262f = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public boolean m45721A() {
        int i = this.f13267k;
        return i >= 2000 && i >= this.f13266j.size();
    }

    /* renamed from: B */
    public static C3541a m45720B(File file, int i, int i2, long j) throws IOException {
        if (j > 0) {
            if (i2 > 0) {
                File file2 = new File(file, f13249q);
                if (file2.exists()) {
                    File file3 = new File(file, f13247o);
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        m45714H(file2, file3, false);
                    }
                }
                C3541a c3541a = new C3541a(file, i, i2, j);
                if (c3541a.f13258b.exists()) {
                    try {
                        c3541a.m45718D();
                        c3541a.m45719C();
                        return c3541a;
                    } catch (IOException e) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                        c3541a.delete();
                    }
                }
                file.mkdirs();
                C3541a c3541a2 = new C3541a(file, i, i2, j);
                c3541a2.m45716F();
                return c3541a2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* renamed from: C */
    private void m45719C() throws IOException {
        m45698m(this.f13259c);
        Iterator<C3545d> it = this.f13266j.values().iterator();
        while (it.hasNext()) {
            C3545d next = it.next();
            int i = 0;
            if (next.f13281f == null) {
                while (i < this.f13263g) {
                    this.f13264h += next.f13277b[i];
                    i++;
                }
            } else {
                next.f13281f = null;
                while (i < this.f13263g) {
                    m45698m(next.m45673j(i));
                    m45698m(next.m45672k(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* renamed from: D */
    private void m45718D() throws IOException {
        C3547b c3547b = new C3547b(new FileInputStream(this.f13258b), C3549c.f13297a);
        try {
            String m45661d = c3547b.m45661d();
            String m45661d2 = c3547b.m45661d();
            String m45661d3 = c3547b.m45661d();
            String m45661d4 = c3547b.m45661d();
            String m45661d5 = c3547b.m45661d();
            if (!f13250r.equals(m45661d) || !"1".equals(m45661d2) || !Integer.toString(this.f13261e).equals(m45661d3) || !Integer.toString(this.f13263g).equals(m45661d4) || !"".equals(m45661d5)) {
                throw new IOException("unexpected journal header: [" + m45661d + ", " + m45661d2 + ", " + m45661d4 + ", " + m45661d5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m45717E(c3547b.m45661d());
                    i++;
                } catch (EOFException unused) {
                    this.f13267k = i - this.f13266j.size();
                    if (c3547b.m45662c()) {
                        m45716F();
                    } else {
                        this.f13265i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13258b, true), C3549c.f13297a));
                    }
                    C3549c.m45660a(c3547b);
                    return;
                }
            }
        } catch (Throwable th) {
            C3549c.m45660a(c3547b);
            throw th;
        }
    }

    /* renamed from: E */
    private void m45717E(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith(f13255w)) {
                    this.f13266j.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            C3545d c3545d = this.f13266j.get(substring);
            if (c3545d == null) {
                c3545d = new C3545d(this, substring, null);
                this.f13266j.put(substring, c3545d);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(f13253u)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                c3545d.f13280e = true;
                c3545d.f13281f = null;
                c3545d.m45669n(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(f13254v)) {
                c3545d.f13281f = new C3544c(this, c3545d, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith(f13256x)) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public synchronized void m45716F() throws IOException {
        Writer writer = this.f13265i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13259c), C3549c.f13297a));
        bufferedWriter.write(f13250r);
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write("1");
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(Integer.toString(this.f13261e));
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(Integer.toString(this.f13263g));
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(ShellAdbUtils.f33810d);
        for (C3545d c3545d : this.f13266j.values()) {
            if (c3545d.f13281f != null) {
                bufferedWriter.write("DIRTY " + c3545d.f13276a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c3545d.f13276a + c3545d.m45671l() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f13258b.exists()) {
            m45714H(this.f13258b, this.f13260d, true);
        }
        m45714H(this.f13259c, this.f13258b, false);
        this.f13260d.delete();
        this.f13265i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13258b, true), C3549c.f13297a));
    }

    /* renamed from: H */
    private static void m45714H(File file, File file2, boolean z) throws IOException {
        if (z) {
            m45698m(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m45711K() throws IOException {
        while (this.f13264h > this.f13262f) {
            m45715G(this.f13266j.entrySet().iterator().next().getKey());
        }
    }

    /* renamed from: k */
    private void m45700k() {
        if (this.f13265i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public synchronized void m45699l(C3544c c3544c, boolean z) throws IOException {
        C3545d c3545d = c3544c.f13272a;
        if (c3545d.f13281f == c3544c) {
            if (z && !c3545d.f13280e) {
                for (int i = 0; i < this.f13263g; i++) {
                    if (c3544c.f13273b[i]) {
                        if (!c3545d.m45672k(i).exists()) {
                            c3544c.m45691a();
                            return;
                        }
                    } else {
                        c3544c.m45691a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.f13263g; i2++) {
                File m45672k = c3545d.m45672k(i2);
                if (z) {
                    if (m45672k.exists()) {
                        File m45673j = c3545d.m45673j(i2);
                        m45672k.renameTo(m45673j);
                        long j = c3545d.f13277b[i2];
                        long length = m45673j.length();
                        c3545d.f13277b[i2] = length;
                        this.f13264h = (this.f13264h - j) + length;
                    }
                } else {
                    m45698m(m45672k);
                }
            }
            this.f13267k++;
            c3545d.f13281f = null;
            if (c3545d.f13280e | z) {
                c3545d.f13280e = true;
                this.f13265i.append((CharSequence) f13253u);
                this.f13265i.append(HttpConstants.SP_CHAR);
                this.f13265i.append((CharSequence) c3545d.f13276a);
                this.f13265i.append((CharSequence) c3545d.m45671l());
                this.f13265i.append('\n');
                if (z) {
                    long j2 = this.f13268l;
                    this.f13268l = 1 + j2;
                    c3545d.f13282g = j2;
                }
            } else {
                this.f13266j.remove(c3545d.f13276a);
                this.f13265i.append((CharSequence) f13255w);
                this.f13265i.append(HttpConstants.SP_CHAR);
                this.f13265i.append((CharSequence) c3545d.f13276a);
                this.f13265i.append('\n');
            }
            this.f13265i.flush();
            if (this.f13264h > this.f13262f || m45721A()) {
                this.f13269m.submit(this.f13270n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: m */
    private static void m45698m(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public synchronized C3544c m45696o(String str, long j) throws IOException {
        m45700k();
        C3545d c3545d = this.f13266j.get(str);
        if (j == -1 || (c3545d != null && c3545d.f13282g == j)) {
            if (c3545d == null) {
                c3545d = new C3545d(this, str, null);
                this.f13266j.put(str, c3545d);
            } else if (c3545d.f13281f != null) {
                return null;
            }
            C3544c c3544c = new C3544c(this, c3545d, null);
            c3545d.f13281f = c3544c;
            this.f13265i.append((CharSequence) f13254v);
            this.f13265i.append(HttpConstants.SP_CHAR);
            this.f13265i.append((CharSequence) str);
            this.f13265i.append('\n');
            this.f13265i.flush();
            return c3544c;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static String m45692s(InputStream inputStream) throws IOException {
        return C3549c.m45658c(new InputStreamReader(inputStream, C3549c.f13298b));
    }

    /* renamed from: G */
    public synchronized boolean m45715G(String str) throws IOException {
        m45700k();
        C3545d c3545d = this.f13266j.get(str);
        if (c3545d != null && c3545d.f13281f == null) {
            for (int i = 0; i < this.f13263g; i++) {
                File m45673j = c3545d.m45673j(i);
                if (m45673j.exists() && !m45673j.delete()) {
                    throw new IOException("failed to delete " + m45673j);
                }
                this.f13264h -= c3545d.f13277b[i];
                c3545d.f13277b[i] = 0;
            }
            this.f13267k++;
            this.f13265i.append((CharSequence) f13255w);
            this.f13265i.append(HttpConstants.SP_CHAR);
            this.f13265i.append((CharSequence) str);
            this.f13265i.append('\n');
            this.f13266j.remove(str);
            if (m45721A()) {
                this.f13269m.submit(this.f13270n);
            }
            return true;
        }
        return false;
    }

    /* renamed from: I */
    public synchronized void m45713I(long j) {
        this.f13262f = j;
        this.f13269m.submit(this.f13270n);
    }

    /* renamed from: J */
    public synchronized long m45712J() {
        return this.f13264h;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f13265i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f13266j.values()).iterator();
        while (it.hasNext()) {
            C3545d c3545d = (C3545d) it.next();
            if (c3545d.f13281f != null) {
                c3545d.f13281f.m45691a();
            }
        }
        m45711K();
        this.f13265i.close();
        this.f13265i = null;
    }

    public void delete() throws IOException {
        close();
        C3549c.m45659b(this.f13257a);
    }

    public synchronized void flush() throws IOException {
        m45700k();
        m45711K();
        this.f13265i.flush();
    }

    public synchronized boolean isClosed() {
        return this.f13265i == null;
    }

    /* renamed from: n */
    public C3544c m45697n(String str) throws IOException {
        return m45696o(str, -1L);
    }

    /* renamed from: p */
    public synchronized C3546e m45695p(String str) throws IOException {
        m45700k();
        C3545d c3545d = this.f13266j.get(str);
        if (c3545d == null) {
            return null;
        }
        if (c3545d.f13280e) {
            for (File file : c3545d.f13278c) {
                if (!file.exists()) {
                    return null;
                }
            }
            this.f13267k++;
            this.f13265i.append((CharSequence) f13256x);
            this.f13265i.append(HttpConstants.SP_CHAR);
            this.f13265i.append((CharSequence) str);
            this.f13265i.append('\n');
            if (m45721A()) {
                this.f13269m.submit(this.f13270n);
            }
            return new C3546e(this, str, c3545d.f13282g, c3545d.f13278c, c3545d.f13277b, null);
        }
        return null;
    }

    /* renamed from: q */
    public File m45694q() {
        return this.f13257a;
    }

    /* renamed from: r */
    public synchronized long m45693r() {
        return this.f13262f;
    }
}
