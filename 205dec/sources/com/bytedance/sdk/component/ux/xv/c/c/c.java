package com.bytedance.sdk.component.ux.xv.c.c;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    static final Pattern f30258c = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream xv = new OutputStream() { // from class: com.bytedance.sdk.component.ux.xv.c.c.c.2
        @Override // java.io.OutputStream
        public void write(int i4) throws IOException {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private Writer f30259a;
    private final int ev;

    /* renamed from: f  reason: collision with root package name */
    private final File f30260f;
    private long gd;

    /* renamed from: p  reason: collision with root package name */
    private final int f30262p;

    /* renamed from: r  reason: collision with root package name */
    private final File f30263r;
    private final File sr;

    /* renamed from: t  reason: collision with root package name */
    private int f30264t;
    private final File ux;

    /* renamed from: w  reason: collision with root package name */
    final ExecutorService f30265w;

    /* renamed from: k  reason: collision with root package name */
    private long f30261k = 0;
    private final LinkedHashMap<String, w> bk = new LinkedHashMap<>(0, 0.75f, true);
    private long ys = -1;
    private long fp = 0;
    private final Callable<Void> ia = new Callable<Void>() { // from class: com.bytedance.sdk.component.ux.xv.c.c.c.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (c.this) {
                if (c.this.f30259a == null) {
                    return null;
                }
                c.this.r();
                if (c.this.ux()) {
                    c.this.sr();
                    c.this.f30264t = 0;
                }
                return null;
            }
        }
    };

    /* renamed from: com.bytedance.sdk.component.ux.xv.c.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class C0453c {
        private boolean sr;
        private boolean ux;

        /* renamed from: w  reason: collision with root package name */
        private final w f30268w;
        private final boolean[] xv;

        /* renamed from: com.bytedance.sdk.component.ux.xv.c.c.c$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        private class C0454c extends FilterOutputStream {
            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0453c.this.sr = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0453c.this.sr = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i4) {
                try {
                    ((FilterOutputStream) this).out.write(i4);
                } catch (IOException unused) {
                    C0453c.this.sr = true;
                }
            }

            private C0454c(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i4, int i5) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i4, i5);
                } catch (IOException unused) {
                    C0453c.this.sr = true;
                }
            }
        }

        private C0453c(w wVar) {
            this.f30268w = wVar;
            this.xv = wVar.sr ? null : new boolean[c.this.f30262p];
        }

        public void w() throws IOException {
            c.this.c(this, false);
        }

        public OutputStream c(int i4) throws IOException {
            FileOutputStream fileOutputStream;
            C0454c c0454c;
            if (i4 < 0 || i4 >= c.this.f30262p) {
                throw new IllegalArgumentException("Expected index " + i4 + " to be greater than 0 and less than the maximum value count of " + c.this.f30262p);
            }
            synchronized (c.this) {
                if (this.f30268w.ux == this) {
                    if (!this.f30268w.sr) {
                        this.xv[i4] = true;
                    }
                    File w3 = this.f30268w.w(i4);
                    try {
                        fileOutputStream = new FileOutputStream(w3);
                    } catch (FileNotFoundException unused) {
                        c.this.sr.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(w3);
                        } catch (FileNotFoundException unused2) {
                            return c.xv;
                        }
                    }
                    c0454c = new C0454c(fileOutputStream);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0454c;
        }

        public void c() throws IOException {
            if (this.sr) {
                c.this.c(this, false);
                c.this.xv(this.f30268w.f30272w);
            } else {
                c.this.c(this, true);
            }
            this.ux = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class w {

        /* renamed from: f  reason: collision with root package name */
        private long f30271f;
        private boolean sr;
        private C0453c ux;

        /* renamed from: w  reason: collision with root package name */
        private final String f30272w;
        private final long[] xv;

        private w(String str) {
            this.f30272w = str;
            this.xv = new long[c.this.f30262p];
        }

        private IOException w(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File w(int i4) {
            File file = c.this.sr;
            return new File(file, this.f30272w + "." + i4 + ".tmp");
        }

        public String c() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j4 : this.xv) {
                sb.append(' ');
                sb.append(j4);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String[] strArr) throws IOException {
            if (strArr.length == c.this.f30262p) {
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    try {
                        this.xv[i4] = Long.parseLong(strArr[i4]);
                    } catch (NumberFormatException unused) {
                        throw w(strArr);
                    }
                }
                return;
            }
            throw w(strArr);
        }

        public File c(int i4) {
            File file = c.this.sr;
            return new File(file, this.f30272w + "." + i4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class xv implements Closeable {
        private final InputStream[] sr;
        private final long[] ux;

        /* renamed from: w  reason: collision with root package name */
        private final String f30274w;
        private final long xv;

        public InputStream c(int i4) {
            return this.sr[i4];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.sr) {
                com.bytedance.sdk.component.ux.xv.xv.w.c(inputStream);
            }
        }

        private xv(String str, long j4, InputStream[] inputStreamArr, long[] jArr) {
            this.f30274w = str;
            this.xv = j4;
            this.sr = inputStreamArr;
            this.ux = jArr;
        }
    }

    private c(File file, int i4, int i5, long j4, ExecutorService executorService) {
        this.sr = file;
        this.ev = i4;
        this.ux = new File(file, "journal");
        this.f30260f = new File(file, "journal.tmp");
        this.f30263r = new File(file, "journal.bkp");
        this.f30262p = i5;
        this.gd = j4;
        this.f30265w = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() throws IOException {
        long j4 = this.gd;
        long j5 = this.ys;
        if (j5 >= 0) {
            j4 = j5;
        }
        while (this.f30261k > j4) {
            xv(this.bk.entrySet().iterator().next().getKey());
        }
        this.ys = -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f30259a == null) {
            return;
        }
        Iterator it = new ArrayList(this.bk.values()).iterator();
        while (it.hasNext()) {
            w wVar = (w) it.next();
            if (wVar.ux != null) {
                wVar.ux.w();
            }
        }
        r();
        this.f30259a.close();
        this.f30259a = null;
    }

    public void delete() throws IOException {
        close();
        sr.c(this.sr);
    }

    private void f() {
        if (this.f30259a == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void sr(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i4 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i4);
            if (indexOf2 == -1) {
                substring = str.substring(i4);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.bk.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i4, indexOf2);
            }
            w wVar = this.bk.get(substring);
            if (wVar == null) {
                wVar = new w(substring);
                this.bk.put(substring, wVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                wVar.sr = true;
                wVar.ux = null;
                wVar.c(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                wVar.ux = new C0453c(wVar);
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
    public boolean ux() {
        int i4 = this.f30264t;
        return i4 >= 2000 && i4 >= this.bk.size();
    }

    private void w() throws IOException {
        com.bytedance.sdk.component.ux.xv.c.c.xv xvVar = new com.bytedance.sdk.component.ux.xv.c.c.xv(new FileInputStream(this.ux), sr.f30275c);
        try {
            String c4 = xvVar.c();
            String c5 = xvVar.c();
            String c6 = xvVar.c();
            String c7 = xvVar.c();
            String c8 = xvVar.c();
            if (!"libcore.io.DiskLruCache".equals(c4) || !"1".equals(c5) || !Integer.toString(this.ev).equals(c6) || !Integer.toString(this.f30262p).equals(c7) || !"".equals(c8)) {
                throw new IOException("unexpected journal header: [" + c4 + ", " + c5 + ", " + c7 + ", " + c8 + "]");
            }
            int i4 = 0;
            while (true) {
                try {
                    sr(xvVar.c());
                    i4++;
                } catch (EOFException unused) {
                    this.f30264t = i4 - this.bk.size();
                    if (xvVar.w()) {
                        sr();
                    } else {
                        this.f30259a = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ux, true), sr.f30275c));
                    }
                    com.bytedance.sdk.component.ux.xv.xv.w.c(xvVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.ux.xv.xv.w.c(xvVar);
            throw th;
        }
    }

    private void xv() throws IOException {
        c(this.f30260f);
        Iterator<w> it = this.bk.values().iterator();
        while (it.hasNext()) {
            w next = it.next();
            int i4 = 0;
            if (next.ux != null) {
                next.ux = null;
                while (i4 < this.f30262p) {
                    c(next.c(i4));
                    c(next.w(i4));
                    i4++;
                }
                it.remove();
            } else {
                while (i4 < this.f30262p) {
                    this.f30261k += next.xv[i4];
                    i4++;
                }
            }
        }
    }

    public static c c(File file, int i4, int i5, long j4, ExecutorService executorService) throws IOException {
        if (j4 > 0) {
            if (i5 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        c(file2, file3, false);
                    }
                }
                c cVar = new c(file, i4, i5, j4, executorService);
                if (cVar.ux.exists()) {
                    try {
                        cVar.w();
                        cVar.xv();
                        return cVar;
                    } catch (IOException e4) {
                        Log.w("DiskLruCache ", file + " is corrupt: " + e4.getMessage() + ", removing");
                        cVar.delete();
                    }
                }
                file.mkdirs();
                c cVar2 = new c(file, i4, i5, j4, executorService);
                cVar2.sr();
                return cVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void ux(String str) {
        if (f30258c.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized boolean xv(String str) throws IOException {
        f();
        ux(str);
        w wVar = this.bk.get(str);
        if (wVar != null && wVar.ux == null) {
            for (int i4 = 0; i4 < this.f30262p; i4++) {
                File c4 = wVar.c(i4);
                if (c4.exists() && !c4.delete()) {
                    throw new IOException("failed to delete " + c4);
                }
                this.f30261k -= wVar.xv[i4];
                wVar.xv[i4] = 0;
            }
            this.f30264t++;
            this.f30259a.append((CharSequence) ("REMOVE " + str + '\n'));
            this.bk.remove(str);
            if (ux()) {
                this.f30265w.submit(this.ia);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sr() throws IOException {
        Writer writer = this.f30259a;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f30260f), sr.f30275c));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.ev));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f30262p));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (w wVar : this.bk.values()) {
            if (wVar.ux != null) {
                bufferedWriter.write("DIRTY " + wVar.f30272w + '\n');
            } else {
                bufferedWriter.write("CLEAN " + wVar.f30272w + wVar.c() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.ux.exists()) {
            c(this.ux, this.f30263r, true);
        }
        c(this.f30260f, this.ux, false);
        this.f30263r.delete();
        this.f30259a = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.ux, true), sr.f30275c));
    }

    public C0453c w(String str) throws IOException {
        return c(str, -1L);
    }

    private static void c(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void c(File file, File file2, boolean z3) throws IOException {
        if (z3) {
            c(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized xv c(String str) throws IOException {
        f();
        ux(str);
        w wVar = this.bk.get(str);
        if (wVar == null) {
            return null;
        }
        if (wVar.sr) {
            InputStream[] inputStreamArr = new InputStream[this.f30262p];
            for (int i4 = 0; i4 < this.f30262p; i4++) {
                try {
                    inputStreamArr[i4] = new FileInputStream(wVar.c(i4));
                } catch (FileNotFoundException unused) {
                    for (int i5 = 0; i5 < this.f30262p && inputStreamArr[i5] != null; i5++) {
                        com.bytedance.sdk.component.ux.xv.xv.w.c(inputStreamArr[i5]);
                    }
                    return null;
                }
            }
            this.f30264t++;
            this.f30259a.append((CharSequence) ("READ " + str + '\n'));
            if (ux()) {
                this.f30265w.submit(this.ia);
            }
            return new xv(str, wVar.f30271f, inputStreamArr, wVar.xv);
        }
        return null;
    }

    private synchronized C0453c c(String str, long j4) throws IOException {
        f();
        ux(str);
        w wVar = this.bk.get(str);
        if (j4 == -1 || (wVar != null && wVar.f30271f == j4)) {
            if (wVar != null) {
                if (wVar.ux != null) {
                    return null;
                }
            } else {
                wVar = new w(str);
                this.bk.put(str, wVar);
            }
            C0453c c0453c = new C0453c(wVar);
            wVar.ux = c0453c;
            Writer writer = this.f30259a;
            writer.write("DIRTY " + str + '\n');
            this.f30259a.flush();
            return c0453c;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(C0453c c0453c, boolean z3) throws IOException {
        w wVar = c0453c.f30268w;
        if (wVar.ux == c0453c) {
            if (z3 && !wVar.sr) {
                for (int i4 = 0; i4 < this.f30262p; i4++) {
                    if (c0453c.xv[i4]) {
                        if (!wVar.w(i4).exists()) {
                            c0453c.w();
                            return;
                        }
                    } else {
                        c0453c.w();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i4);
                    }
                }
            }
            for (int i5 = 0; i5 < this.f30262p; i5++) {
                File w3 = wVar.w(i5);
                if (z3) {
                    if (w3.exists()) {
                        File c4 = wVar.c(i5);
                        w3.renameTo(c4);
                        long j4 = wVar.xv[i5];
                        long length = c4.length();
                        wVar.xv[i5] = length;
                        this.f30261k = (this.f30261k - j4) + length;
                    }
                } else {
                    c(w3);
                }
            }
            this.f30264t++;
            wVar.ux = null;
            if (wVar.sr | z3) {
                wVar.sr = true;
                this.f30259a.write("CLEAN " + wVar.f30272w + wVar.c() + '\n');
                if (z3) {
                    long j5 = this.fp;
                    this.fp = 1 + j5;
                    wVar.f30271f = j5;
                }
            } else {
                this.bk.remove(wVar.f30272w);
                this.f30259a.write("REMOVE " + wVar.f30272w + '\n');
            }
            this.f30259a.flush();
            if (this.f30261k > this.gd || ux()) {
                this.f30265w.submit(this.ia);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public synchronized void c() throws IOException {
        f();
        r();
        this.f30259a.flush();
    }

    public void c(long j4) {
        this.ys = j4;
        this.f30265w.submit(this.ia);
    }
}
