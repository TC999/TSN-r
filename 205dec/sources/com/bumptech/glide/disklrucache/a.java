package com.bumptech.glide.disklrucache;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DiskLruCache.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class a implements Closeable {

    /* renamed from: o  reason: collision with root package name */
    static final String f16591o = "journal";

    /* renamed from: p  reason: collision with root package name */
    static final String f16592p = "journal.tmp";

    /* renamed from: q  reason: collision with root package name */
    static final String f16593q = "journal.bkp";

    /* renamed from: r  reason: collision with root package name */
    static final String f16594r = "libcore.io.DiskLruCache";

    /* renamed from: s  reason: collision with root package name */
    static final String f16595s = "1";

    /* renamed from: t  reason: collision with root package name */
    static final long f16596t = -1;

    /* renamed from: u  reason: collision with root package name */
    private static final String f16597u = "CLEAN";

    /* renamed from: v  reason: collision with root package name */
    private static final String f16598v = "DIRTY";

    /* renamed from: w  reason: collision with root package name */
    private static final String f16599w = "REMOVE";

    /* renamed from: x  reason: collision with root package name */
    private static final String f16600x = "READ";

    /* renamed from: a  reason: collision with root package name */
    private final File f16601a;

    /* renamed from: b  reason: collision with root package name */
    private final File f16602b;

    /* renamed from: c  reason: collision with root package name */
    private final File f16603c;

    /* renamed from: d  reason: collision with root package name */
    private final File f16604d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16605e;

    /* renamed from: f  reason: collision with root package name */
    private long f16606f;

    /* renamed from: g  reason: collision with root package name */
    private final int f16607g;

    /* renamed from: i  reason: collision with root package name */
    private Writer f16609i;

    /* renamed from: k  reason: collision with root package name */
    private int f16611k;

    /* renamed from: h  reason: collision with root package name */
    private long f16608h = 0;

    /* renamed from: j  reason: collision with root package name */
    private final LinkedHashMap<String, d> f16610j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l  reason: collision with root package name */
    private long f16612l = 0;

    /* renamed from: m  reason: collision with root package name */
    final ThreadPoolExecutor f16613m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* renamed from: n  reason: collision with root package name */
    private final Callable<Void> f16614n = new CallableC0163a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.disklrucache.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class CallableC0163a implements Callable<Void> {
        CallableC0163a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f16609i == null) {
                    return null;
                }
                a.this.K();
                if (a.this.A()) {
                    a.this.F();
                    a.this.f16611k = 0;
                }
                return null;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskLruCache.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(CallableC0163a callableC0163a) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskLruCache.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        private final d f16616a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean[] f16617b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16618c;

        /* synthetic */ c(a aVar, d dVar, CallableC0163a callableC0163a) {
            this(dVar);
        }

        private InputStream h(int i4) throws IOException {
            synchronized (a.this) {
                if (this.f16616a.f16625f == this) {
                    if (this.f16616a.f16624e) {
                        try {
                            return new FileInputStream(this.f16616a.j(i4));
                        } catch (FileNotFoundException unused) {
                            return null;
                        }
                    }
                    return null;
                }
                throw new IllegalStateException();
            }
        }

        public void a() throws IOException {
            a.this.l(this, false);
        }

        public void b() {
            if (this.f16618c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() throws IOException {
            a.this.l(this, true);
            this.f16618c = true;
        }

        public File f(int i4) throws IOException {
            File k4;
            synchronized (a.this) {
                if (this.f16616a.f16625f == this) {
                    if (!this.f16616a.f16624e) {
                        this.f16617b[i4] = true;
                    }
                    k4 = this.f16616a.k(i4);
                    if (!a.this.f16601a.exists()) {
                        a.this.f16601a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return k4;
        }

        public String g(int i4) throws IOException {
            InputStream h4 = h(i4);
            if (h4 != null) {
                return a.s(h4);
            }
            return null;
        }

        public void i(int i4, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(f(i4)), com.bumptech.glide.disklrucache.c.f16642b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                com.bumptech.glide.disklrucache.c.a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                com.bumptech.glide.disklrucache.c.a(outputStreamWriter2);
                throw th;
            }
        }

        private c(d dVar) {
            this.f16616a = dVar;
            this.f16617b = dVar.f16624e ? null : new boolean[a.this.f16607g];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskLruCache.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f16620a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f16621b;

        /* renamed from: c  reason: collision with root package name */
        File[] f16622c;

        /* renamed from: d  reason: collision with root package name */
        File[] f16623d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f16624e;

        /* renamed from: f  reason: collision with root package name */
        private c f16625f;

        /* renamed from: g  reason: collision with root package name */
        private long f16626g;

        /* synthetic */ d(a aVar, String str, CallableC0163a callableC0163a) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.f16607g) {
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    try {
                        this.f16621b[i4] = Long.parseLong(strArr[i4]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i4) {
            return this.f16622c[i4];
        }

        public File k(int i4) {
            return this.f16623d[i4];
        }

        public String l() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j4 : this.f16621b) {
                sb.append(' ');
                sb.append(j4);
            }
            return sb.toString();
        }

        private d(String str) {
            this.f16620a = str;
            this.f16621b = new long[a.this.f16607g];
            this.f16622c = new File[a.this.f16607g];
            this.f16623d = new File[a.this.f16607g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i4 = 0; i4 < a.this.f16607g; i4++) {
                sb.append(i4);
                this.f16622c[i4] = new File(a.this.f16601a, sb.toString());
                sb.append(".tmp");
                this.f16623d[i4] = new File(a.this.f16601a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DiskLruCache.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public final class e {

        /* renamed from: a  reason: collision with root package name */
        private final String f16628a;

        /* renamed from: b  reason: collision with root package name */
        private final long f16629b;

        /* renamed from: c  reason: collision with root package name */
        private final long[] f16630c;

        /* renamed from: d  reason: collision with root package name */
        private final File[] f16631d;

        /* synthetic */ e(a aVar, String str, long j4, File[] fileArr, long[] jArr, CallableC0163a callableC0163a) {
            this(str, j4, fileArr, jArr);
        }

        public c a() throws IOException {
            return a.this.o(this.f16628a, this.f16629b);
        }

        public File b(int i4) {
            return this.f16631d[i4];
        }

        public long c(int i4) {
            return this.f16630c[i4];
        }

        public String d(int i4) throws IOException {
            return a.s(new FileInputStream(this.f16631d[i4]));
        }

        private e(String str, long j4, File[] fileArr, long[] jArr) {
            this.f16628a = str;
            this.f16629b = j4;
            this.f16631d = fileArr;
            this.f16630c = jArr;
        }
    }

    private a(File file, int i4, int i5, long j4) {
        this.f16601a = file;
        this.f16605e = i4;
        this.f16602b = new File(file, "journal");
        this.f16603c = new File(file, "journal.tmp");
        this.f16604d = new File(file, "journal.bkp");
        this.f16607g = i5;
        this.f16606f = j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        int i4 = this.f16611k;
        return i4 >= 2000 && i4 >= this.f16610j.size();
    }

    public static a B(File file, int i4, int i5, long j4) throws IOException {
        if (j4 > 0) {
            if (i5 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        H(file2, file3, false);
                    }
                }
                a aVar = new a(file, i4, i5, j4);
                if (aVar.f16602b.exists()) {
                    try {
                        aVar.D();
                        aVar.C();
                        return aVar;
                    } catch (IOException e4) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e4.getMessage() + ", removing");
                        aVar.delete();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i4, i5, j4);
                aVar2.F();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void C() throws IOException {
        m(this.f16603c);
        Iterator<d> it = this.f16610j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i4 = 0;
            if (next.f16625f == null) {
                while (i4 < this.f16607g) {
                    this.f16608h += next.f16621b[i4];
                    i4++;
                }
            } else {
                next.f16625f = null;
                while (i4 < this.f16607g) {
                    m(next.j(i4));
                    m(next.k(i4));
                    i4++;
                }
                it.remove();
            }
        }
    }

    private void D() throws IOException {
        com.bumptech.glide.disklrucache.b bVar = new com.bumptech.glide.disklrucache.b(new FileInputStream(this.f16602b), com.bumptech.glide.disklrucache.c.f16641a);
        try {
            String d4 = bVar.d();
            String d5 = bVar.d();
            String d6 = bVar.d();
            String d7 = bVar.d();
            String d8 = bVar.d();
            if (!"libcore.io.DiskLruCache".equals(d4) || !"1".equals(d5) || !Integer.toString(this.f16605e).equals(d6) || !Integer.toString(this.f16607g).equals(d7) || !"".equals(d8)) {
                throw new IOException("unexpected journal header: [" + d4 + ", " + d5 + ", " + d7 + ", " + d8 + "]");
            }
            int i4 = 0;
            while (true) {
                try {
                    E(bVar.d());
                    i4++;
                } catch (EOFException unused) {
                    this.f16611k = i4 - this.f16610j.size();
                    if (bVar.c()) {
                        F();
                    } else {
                        this.f16609i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16602b, true), com.bumptech.glide.disklrucache.c.f16641a));
                    }
                    com.bumptech.glide.disklrucache.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bumptech.glide.disklrucache.c.a(bVar);
            throw th;
        }
    }

    private void E(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i4 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i4);
            if (indexOf2 == -1) {
                substring = str.substring(i4);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f16610j.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i4, indexOf2);
            }
            d dVar = this.f16610j.get(substring);
            if (dVar == null) {
                dVar = new d(this, substring, null);
                this.f16610j.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f16624e = true;
                dVar.f16625f = null;
                dVar.n(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f16625f = new c(this, dVar, null);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void F() throws IOException {
        Writer writer = this.f16609i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16603c), com.bumptech.glide.disklrucache.c.f16641a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f16605e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f16607g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.f16610j.values()) {
            if (dVar.f16625f != null) {
                bufferedWriter.write("DIRTY " + dVar.f16620a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.f16620a + dVar.l() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f16602b.exists()) {
            H(this.f16602b, this.f16604d, true);
        }
        H(this.f16603c, this.f16602b, false);
        this.f16604d.delete();
        this.f16609i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16602b, true), com.bumptech.glide.disklrucache.c.f16641a));
    }

    private static void H(File file, File file2, boolean z3) throws IOException {
        if (z3) {
            m(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() throws IOException {
        while (this.f16608h > this.f16606f) {
            G(this.f16610j.entrySet().iterator().next().getKey());
        }
    }

    private void k() {
        if (this.f16609i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(c cVar, boolean z3) throws IOException {
        d dVar = cVar.f16616a;
        if (dVar.f16625f == cVar) {
            if (z3 && !dVar.f16624e) {
                for (int i4 = 0; i4 < this.f16607g; i4++) {
                    if (cVar.f16617b[i4]) {
                        if (!dVar.k(i4).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i4);
                    }
                }
            }
            for (int i5 = 0; i5 < this.f16607g; i5++) {
                File k4 = dVar.k(i5);
                if (z3) {
                    if (k4.exists()) {
                        File j4 = dVar.j(i5);
                        k4.renameTo(j4);
                        long j5 = dVar.f16621b[i5];
                        long length = j4.length();
                        dVar.f16621b[i5] = length;
                        this.f16608h = (this.f16608h - j5) + length;
                    }
                } else {
                    m(k4);
                }
            }
            this.f16611k++;
            dVar.f16625f = null;
            if (dVar.f16624e | z3) {
                dVar.f16624e = true;
                this.f16609i.append((CharSequence) "CLEAN");
                this.f16609i.append(' ');
                this.f16609i.append((CharSequence) dVar.f16620a);
                this.f16609i.append((CharSequence) dVar.l());
                this.f16609i.append('\n');
                if (z3) {
                    long j6 = this.f16612l;
                    this.f16612l = 1 + j6;
                    dVar.f16626g = j6;
                }
            } else {
                this.f16610j.remove(dVar.f16620a);
                this.f16609i.append((CharSequence) "REMOVE");
                this.f16609i.append(' ');
                this.f16609i.append((CharSequence) dVar.f16620a);
                this.f16609i.append('\n');
            }
            this.f16609i.flush();
            if (this.f16608h > this.f16606f || A()) {
                this.f16613m.submit(this.f16614n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static void m(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized c o(String str, long j4) throws IOException {
        k();
        d dVar = this.f16610j.get(str);
        if (j4 == -1 || (dVar != null && dVar.f16626g == j4)) {
            if (dVar == null) {
                dVar = new d(this, str, null);
                this.f16610j.put(str, dVar);
            } else if (dVar.f16625f != null) {
                return null;
            }
            c cVar = new c(this, dVar, null);
            dVar.f16625f = cVar;
            this.f16609i.append((CharSequence) "DIRTY");
            this.f16609i.append(' ');
            this.f16609i.append((CharSequence) str);
            this.f16609i.append('\n');
            this.f16609i.flush();
            return cVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(InputStream inputStream) throws IOException {
        return com.bumptech.glide.disklrucache.c.c(new InputStreamReader(inputStream, com.bumptech.glide.disklrucache.c.f16642b));
    }

    public synchronized boolean G(String str) throws IOException {
        k();
        d dVar = this.f16610j.get(str);
        if (dVar != null && dVar.f16625f == null) {
            for (int i4 = 0; i4 < this.f16607g; i4++) {
                File j4 = dVar.j(i4);
                if (j4.exists() && !j4.delete()) {
                    throw new IOException("failed to delete " + j4);
                }
                this.f16608h -= dVar.f16621b[i4];
                dVar.f16621b[i4] = 0;
            }
            this.f16611k++;
            this.f16609i.append((CharSequence) "REMOVE");
            this.f16609i.append(' ');
            this.f16609i.append((CharSequence) str);
            this.f16609i.append('\n');
            this.f16610j.remove(str);
            if (A()) {
                this.f16613m.submit(this.f16614n);
            }
            return true;
        }
        return false;
    }

    public synchronized void I(long j4) {
        this.f16606f = j4;
        this.f16613m.submit(this.f16614n);
    }

    public synchronized long J() {
        return this.f16608h;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f16609i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f16610j.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f16625f != null) {
                dVar.f16625f.a();
            }
        }
        K();
        this.f16609i.close();
        this.f16609i = null;
    }

    public void delete() throws IOException {
        close();
        com.bumptech.glide.disklrucache.c.b(this.f16601a);
    }

    public synchronized void flush() throws IOException {
        k();
        K();
        this.f16609i.flush();
    }

    public synchronized boolean isClosed() {
        return this.f16609i == null;
    }

    public c n(String str) throws IOException {
        return o(str, -1L);
    }

    public synchronized e p(String str) throws IOException {
        k();
        d dVar = this.f16610j.get(str);
        if (dVar == null) {
            return null;
        }
        if (dVar.f16624e) {
            for (File file : dVar.f16622c) {
                if (!file.exists()) {
                    return null;
                }
            }
            this.f16611k++;
            this.f16609i.append((CharSequence) "READ");
            this.f16609i.append(' ');
            this.f16609i.append((CharSequence) str);
            this.f16609i.append('\n');
            if (A()) {
                this.f16613m.submit(this.f16614n);
            }
            return new e(this, str, dVar.f16626g, dVar.f16622c, dVar.f16621b, null);
        }
        return null;
    }

    public File q() {
        return this.f16601a;
    }

    public synchronized long r() {
        return this.f16606f;
    }
}
