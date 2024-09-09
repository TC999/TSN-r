package com.kwad.sdk.core.diskcache.a;

import com.kwad.sdk.utils.q;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements Closeable {
    static final Pattern atD = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream atS = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i4) {
        }
    };
    private final File atE;
    private final File atF;
    private final File atG;
    private final File atH;
    private final int atI;
    private int atJ;
    private final int atK;
    private Writer atM;
    private int atO;
    private long maxSize;
    private long size = 0;
    private int atL = 0;
    private final LinkedHashMap<String, b> atN = new LinkedHashMap<>(0, 0.75f, true);
    private long atP = 0;
    final ThreadPoolExecutor atQ = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> atR = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: CS */
        public Void call() {
            synchronized (a.this) {
                if (a.this.atM == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.CY();
                if (a.this.CX()) {
                    a.this.CV();
                    a.a(a.this, 0);
                }
                return null;
            }
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public final class C0691a {
        private final b atU;
        private final boolean[] atV;
        private boolean atW;
        private boolean atX;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        class C0692a extends FilterOutputStream {
            /* synthetic */ C0692a(C0691a c0691a, OutputStream outputStream, byte b4) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0691a.b(C0691a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0691a.b(C0691a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i4) {
                try {
                    ((FilterOutputStream) this).out.write(i4);
                } catch (IOException unused) {
                    C0691a.b(C0691a.this, true);
                }
            }

            private C0692a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i4, int i5) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i4, i5);
                } catch (IOException unused) {
                    C0691a.b(C0691a.this, true);
                }
            }
        }

        /* synthetic */ C0691a(a aVar, b bVar, byte b4) {
            this(bVar);
        }

        static /* synthetic */ boolean b(C0691a c0691a, boolean z3) {
            c0691a.atW = true;
            return true;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final OutputStream cZ(int i4) {
            FileOutputStream fileOutputStream;
            C0692a c0692a;
            synchronized (a.this) {
                if (this.atU.aub == this) {
                    if (!this.atU.aua) {
                        this.atV[0] = true;
                    }
                    File db = this.atU.db(0);
                    try {
                        fileOutputStream = new FileOutputStream(db);
                    } catch (FileNotFoundException unused) {
                        a.this.atE.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(db);
                        } catch (FileNotFoundException unused2) {
                            return a.atS;
                        }
                    }
                    c0692a = new C0692a(this, fileOutputStream, (byte) 0);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0692a;
        }

        public final void commit() {
            if (this.atW) {
                a.this.a(this, false);
                a.this.remove(this.atU.key);
            } else {
                a.this.a(this, true);
            }
            this.atX = true;
        }

        private C0691a(b bVar) {
            this.atU = bVar;
            this.atV = bVar.aua ? null : new boolean[a.this.atK];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public final class b {
        private final long[] atZ;
        private boolean aua;
        private C0691a aub;
        private long auc;
        private final String key;

        /* synthetic */ b(a aVar, String str, byte b4) {
            this(str);
        }

        public final String Da() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j4 : this.atZ) {
                sb.append(' ');
                sb.append(j4);
            }
            return sb.toString();
        }

        public final File da(int i4) {
            File file = a.this.atE;
            return new File(file, this.key + i4);
        }

        public final File db(int i4) {
            File file = a.this.atE;
            return new File(file, this.key + i4 + ".tmp");
        }

        private b(String str) {
            this.key = str;
            this.atZ = new long[a.this.atK];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.atK) {
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    try {
                        this.atZ[i4] = Long.parseLong(strArr[i4]);
                    } catch (NumberFormatException unused) {
                        throw c(strArr);
                    }
                }
                return;
            }
            throw c(strArr);
        }

        private static IOException c(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        static /* synthetic */ boolean a(b bVar, boolean z3) {
            bVar.aua = true;
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public final class c implements Closeable {
        private final long[] atZ;
        private final long auc;
        private File[] aud;
        private final InputStream[] aue;
        private final String key;

        /* synthetic */ c(a aVar, String str, long j4, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b4) {
            this(str, j4, fileArr, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.aue) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }

        public final File dc(int i4) {
            return this.aud[0];
        }

        private c(String str, long j4, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.auc = j4;
            this.aud = fileArr;
            this.aue = inputStreamArr;
            this.atZ = jArr;
        }
    }

    private a(File file, int i4, int i5, long j4, int i6) {
        this.atE = file;
        this.atI = i4;
        this.atF = new File(file, "journal");
        this.atG = new File(file, "journal.tmp");
        this.atH = new File(file, "journal.bkp");
        this.atK = i5;
        this.maxSize = j4;
        this.atJ = i6;
    }

    private void CT() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.atF), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.atI).equals(readLine3) || !Integer.toString(this.atK).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i4 = 0;
            while (true) {
                try {
                    dn(bVar.readLine());
                    i4++;
                } catch (EOFException unused) {
                    this.atO = i4 - this.atN.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void CU() {
        p(this.atG);
        Iterator<b> it = this.atN.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i4 = 0;
            if (next.aub != null) {
                next.aub = null;
                while (i4 < this.atK) {
                    p(next.da(i4));
                    p(next.db(i4));
                    i4++;
                }
                it.remove();
            } else {
                while (i4 < this.atK) {
                    this.size += next.atZ[i4];
                    this.atL++;
                    i4++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void CV() {
        Writer writer = this.atM;
        if (writer != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.atG), com.kwad.sdk.crash.utils.a.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.atI));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.atK));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (b bVar : this.atN.values()) {
            if (bVar.aub != null) {
                bufferedWriter.write("DIRTY " + bVar.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + bVar.key + bVar.Da() + '\n');
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
        if (this.atF.exists()) {
            a(this.atF, this.atH, true);
        }
        a(this.atG, this.atF, false);
        this.atH.delete();
        this.atM = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.atF, true), com.kwad.sdk.crash.utils.a.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean CX() {
        int i4 = this.atO;
        return i4 >= 2000 && i4 >= this.atN.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CY() {
        while (this.atL > this.atJ) {
            remove(this.atN.entrySet().iterator().next().getKey());
        }
    }

    static /* synthetic */ int a(a aVar, int i4) {
        aVar.atO = 0;
        return 0;
    }

    private void checkNotClosed() {
        if (this.atM == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void dn(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i4 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i4);
            if (indexOf2 == -1) {
                substring = str.substring(i4);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.atN.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i4, indexOf2);
            }
            b bVar = this.atN.get(substring);
            if (bVar == null) {
                bVar = new b(this, substring, (byte) 0);
                this.atN.put(substring, bVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                b.a(bVar, true);
                bVar.aub = null;
                bVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.aub = new C0691a(this, bVar, (byte) 0);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private static void dq(String str) {
        if (atD.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private static void p(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.atN.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized int CW() {
        return this.atJ;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.atM == null) {
            return;
        }
        Iterator it = new ArrayList(this.atN.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.aub != null) {
                bVar.aub.abort();
            }
        }
        trimToSize();
        CY();
        com.kwad.sdk.crash.utils.b.closeQuietly(this.atM);
        this.atM = null;
    }

    public final void delete() {
        close();
        q.deleteContents(this.atE);
    }

    /* renamed from: do  reason: not valid java name */
    public final synchronized c m91do(String str) {
        if (this.atM == null) {
            return null;
        }
        dq(str);
        b bVar = this.atN.get(str);
        if (bVar == null) {
            return null;
        }
        if (bVar.aua) {
            int i4 = this.atK;
            File[] fileArr = new File[i4];
            InputStream[] inputStreamArr = new InputStream[i4];
            for (int i5 = 0; i5 < this.atK; i5++) {
                try {
                    File da = bVar.da(i5);
                    fileArr[i5] = da;
                    inputStreamArr[i5] = new FileInputStream(da);
                } catch (FileNotFoundException unused) {
                    for (int i6 = 0; i6 < this.atK && inputStreamArr[i6] != null; i6++) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamArr[i6]);
                    }
                    return null;
                }
            }
            this.atO++;
            this.atM.append((CharSequence) ("READ " + str + '\n'));
            if (CX()) {
                this.atQ.submit(this.atR);
            }
            return new c(this, str, bVar.auc, fileArr, inputStreamArr, bVar.atZ, (byte) 0);
        }
        return null;
    }

    public final C0691a dp(String str) {
        return e(str, -1L);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        CY();
        this.atM.flush();
    }

    public final File getDirectory() {
        return this.atE;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean remove(String str) {
        checkNotClosed();
        dq(str);
        b bVar = this.atN.get(str);
        if (bVar != null && bVar.aub == null) {
            for (int i4 = 0; i4 < this.atK; i4++) {
                File da = bVar.da(i4);
                if (da.exists() && !da.delete()) {
                    throw new IOException("failed to delete " + da);
                }
                this.size -= bVar.atZ[i4];
                this.atL--;
                bVar.atZ[i4] = 0;
            }
            this.atO++;
            this.atM.append((CharSequence) ("REMOVE " + str + '\n'));
            this.atN.remove(str);
            if (CX()) {
                this.atQ.submit(this.atR);
            }
            return true;
        }
        return false;
    }

    private synchronized C0691a e(String str, long j4) {
        checkNotClosed();
        dq(str);
        b bVar = this.atN.get(str);
        if (bVar != null) {
            if (bVar.aub != null) {
                return null;
            }
        } else {
            bVar = new b(this, str, (byte) 0);
            this.atN.put(str, bVar);
        }
        C0691a c0691a = new C0691a(this, bVar, (byte) 0);
        bVar.aub = c0691a;
        Writer writer = this.atM;
        writer.write("DIRTY " + str + '\n');
        this.atM.flush();
        return c0691a;
    }

    public static a a(File file, int i4, int i5, long j4) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i4, int i5, long j4, int i6) {
        if (j4 > 0) {
            if (i6 > 0) {
                if (i5 > 0) {
                    File file2 = new File(file, "journal.bkp");
                    if (file2.exists()) {
                        File file3 = new File(file, "journal");
                        if (file3.exists()) {
                            file2.delete();
                        } else {
                            a(file2, file3, false);
                        }
                    }
                    a aVar = new a(file, i4, i5, j4, i6);
                    if (aVar.atF.exists()) {
                        try {
                            aVar.CT();
                            aVar.CU();
                            aVar.atM = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.atF, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                            return aVar;
                        } catch (IOException e4) {
                            PrintStream printStream = System.out;
                            printStream.println("DiskLruCache " + file + " is corrupt: " + e4.getMessage() + ", removing");
                            aVar.delete();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i4, i5, j4, i6);
                    aVar2.CV();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private static void a(File file, File file2, boolean z3) {
        if (z3) {
            p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0691a c0691a, boolean z3) {
        b bVar = c0691a.atU;
        if (bVar.aub == c0691a) {
            if (z3 && !bVar.aua) {
                for (int i4 = 0; i4 < this.atK; i4++) {
                    if (c0691a.atV[i4]) {
                        if (!bVar.db(i4).exists()) {
                            c0691a.abort();
                            return;
                        }
                    } else {
                        c0691a.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i4);
                    }
                }
            }
            for (int i5 = 0; i5 < this.atK; i5++) {
                File db = bVar.db(i5);
                if (z3) {
                    if (db.exists()) {
                        File da = bVar.da(i5);
                        db.renameTo(da);
                        long j4 = bVar.atZ[i5];
                        long length = da.length();
                        bVar.atZ[i5] = length;
                        this.size = (this.size - j4) + length;
                        this.atL++;
                    }
                } else {
                    p(db);
                }
            }
            this.atO++;
            bVar.aub = null;
            if (!(bVar.aua | z3)) {
                this.atN.remove(bVar.key);
                this.atM.write("REMOVE " + bVar.key + '\n');
            } else {
                b.a(bVar, true);
                this.atM.write("CLEAN " + bVar.key + bVar.Da() + '\n');
                if (z3) {
                    long j5 = this.atP;
                    this.atP = 1 + j5;
                    bVar.auc = j5;
                }
            }
            this.atM.flush();
            if (this.size > this.maxSize || this.atL > this.atJ || CX()) {
                this.atQ.submit(this.atR);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
