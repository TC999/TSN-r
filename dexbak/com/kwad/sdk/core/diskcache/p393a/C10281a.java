package com.kwad.sdk.core.diskcache.p393a;

import com.kwad.sdk.crash.utils.C10737a;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.utils.C11122q;
import com.snail.antifake.deviceid.ShellAdbUtils;
import io.netty.handler.codec.http.HttpConstants;
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

/* renamed from: com.kwad.sdk.core.diskcache.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10281a implements Closeable {
    static final Pattern atD = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream atS = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i) {
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
    private final LinkedHashMap<String, C10287b> atN = new LinkedHashMap<>(0, 0.75f, true);
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
            synchronized (C10281a.this) {
                if (C10281a.this.atM == null) {
                    return null;
                }
                C10281a.this.trimToSize();
                C10281a.this.m26438CY();
                if (C10281a.this.m26439CX()) {
                    C10281a.this.m26441CV();
                    C10281a.m26434a(C10281a.this, 0);
                }
                return null;
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public final class C10285a {
        private final C10287b atU;
        private final boolean[] atV;
        private boolean atW;
        private boolean atX;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        class C10286a extends FilterOutputStream {
            /* synthetic */ C10286a(C10285a c10285a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C10285a.m26414b(C10285a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C10285a.m26414b(C10285a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C10285a.m26414b(C10285a.this, true);
                }
            }

            private C10286a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C10285a.m26414b(C10285a.this, true);
                }
            }
        }

        /* synthetic */ C10285a(C10281a c10281a, C10287b c10287b, byte b) {
            this(c10287b);
        }

        /* renamed from: b */
        static /* synthetic */ boolean m26414b(C10285a c10285a, boolean z) {
            c10285a.atW = true;
            return true;
        }

        public final void abort() {
            C10281a.this.m26436a(this, false);
        }

        /* renamed from: cZ */
        public final OutputStream m26413cZ(int i) {
            FileOutputStream fileOutputStream;
            C10286a c10286a;
            synchronized (C10281a.this) {
                if (this.atU.aub == this) {
                    if (!this.atU.aua) {
                        this.atV[0] = true;
                    }
                    File m26400db = this.atU.m26400db(0);
                    try {
                        fileOutputStream = new FileOutputStream(m26400db);
                    } catch (FileNotFoundException unused) {
                        C10281a.this.atE.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(m26400db);
                        } catch (FileNotFoundException unused2) {
                            return C10281a.atS;
                        }
                    }
                    c10286a = new C10286a(this, fileOutputStream, (byte) 0);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c10286a;
        }

        public final void commit() {
            if (this.atW) {
                C10281a.this.m26436a(this, false);
                C10281a.this.remove(this.atU.key);
            } else {
                C10281a.this.m26436a(this, true);
            }
            this.atX = true;
        }

        private C10285a(C10287b c10287b) {
            this.atU = c10287b;
            this.atV = c10287b.aua ? null : new boolean[C10281a.this.atK];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.diskcache.a.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public final class C10287b {
        private final long[] atZ;
        private boolean aua;
        private C10285a aub;
        private long auc;
        private final String key;

        /* synthetic */ C10287b(C10281a c10281a, String str, byte b) {
            this(str);
        }

        /* renamed from: Da */
        public final String m26412Da() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.atZ) {
                sb.append(HttpConstants.SP_CHAR);
                sb.append(j);
            }
            return sb.toString();
        }

        /* renamed from: da */
        public final File m26401da(int i) {
            File file = C10281a.this.atE;
            return new File(file, this.key + i);
        }

        /* renamed from: db */
        public final File m26400db(int i) {
            File file = C10281a.this.atE;
            return new File(file, this.key + i + ".tmp");
        }

        private C10287b(String str) {
            this.key = str;
            this.atZ = new long[C10281a.this.atK];
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m26405b(String[] strArr) {
            if (strArr.length == C10281a.this.atK) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.atZ[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw m26403c(strArr);
                    }
                }
                return;
            }
            throw m26403c(strArr);
        }

        /* renamed from: c */
        private static IOException m26403c(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        static /* synthetic */ boolean m26408a(C10287b c10287b, boolean z) {
            c10287b.aua = true;
            return true;
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public final class C10288c implements Closeable {
        private final long[] atZ;
        private final long auc;
        private File[] aud;
        private final InputStream[] aue;
        private final String key;

        /* synthetic */ C10288c(C10281a c10281a, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.aue) {
                C10738b.closeQuietly(inputStream);
            }
        }

        /* renamed from: dc */
        public final File m26398dc(int i) {
            return this.aud[0];
        }

        private C10288c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.auc = j;
            this.aud = fileArr;
            this.aue = inputStreamArr;
            this.atZ = jArr;
        }
    }

    private C10281a(File file, int i, int i2, long j, int i3) {
        this.atE = file;
        this.atI = i;
        this.atF = new File(file, "journal");
        this.atG = new File(file, "journal.tmp");
        this.atH = new File(file, "journal.bkp");
        this.atK = i2;
        this.maxSize = j;
        this.atJ = i3;
    }

    /* renamed from: CT */
    private void m26443CT() {
        C10289b c10289b = new C10289b(new FileInputStream(this.atF), C10737a.US_ASCII);
        try {
            String readLine = c10289b.readLine();
            String readLine2 = c10289b.readLine();
            String readLine3 = c10289b.readLine();
            String readLine4 = c10289b.readLine();
            String readLine5 = c10289b.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.atI).equals(readLine3) || !Integer.toString(this.atK).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m26426dn(c10289b.readLine());
                    i++;
                } catch (EOFException unused) {
                    this.atO = i - this.atN.size();
                    C10738b.closeQuietly(c10289b);
                    return;
                }
            }
        } catch (Throwable th) {
            C10738b.closeQuietly(c10289b);
            throw th;
        }
    }

    /* renamed from: CU */
    private void m26442CU() {
        m26418p(this.atG);
        Iterator<C10287b> it = this.atN.values().iterator();
        while (it.hasNext()) {
            C10287b next = it.next();
            int i = 0;
            if (next.aub != null) {
                next.aub = null;
                while (i < this.atK) {
                    m26418p(next.m26401da(i));
                    m26418p(next.m26400db(i));
                    i++;
                }
                it.remove();
            } else {
                while (i < this.atK) {
                    this.size += next.atZ[i];
                    this.atL++;
                    i++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CV */
    public synchronized void m26441CV() {
        Writer writer = this.atM;
        if (writer != null) {
            C10738b.closeQuietly(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.atG), C10737a.US_ASCII));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write("1");
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(Integer.toString(this.atI));
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(Integer.toString(this.atK));
        bufferedWriter.write(ShellAdbUtils.f33810d);
        bufferedWriter.write(ShellAdbUtils.f33810d);
        for (C10287b c10287b : this.atN.values()) {
            if (c10287b.aub != null) {
                bufferedWriter.write("DIRTY " + c10287b.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c10287b.key + c10287b.m26412Da() + '\n');
            }
        }
        C10738b.closeQuietly(bufferedWriter);
        if (this.atF.exists()) {
            m26430a(this.atF, this.atH, true);
        }
        m26430a(this.atG, this.atF, false);
        this.atH.delete();
        this.atM = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.atF, true), C10737a.US_ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CX */
    public boolean m26439CX() {
        int i = this.atO;
        return i >= 2000 && i >= this.atN.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CY */
    public void m26438CY() {
        while (this.atL > this.atJ) {
            remove(this.atN.entrySet().iterator().next().getKey());
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m26434a(C10281a c10281a, int i) {
        c10281a.atO = 0;
        return 0;
    }

    private void checkNotClosed() {
        if (this.atM == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: dn */
    private void m26426dn(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.atN.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            C10287b c10287b = this.atN.get(substring);
            if (c10287b == null) {
                c10287b = new C10287b(this, substring, (byte) 0);
                this.atN.put(substring, c10287b);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                C10287b.m26408a(c10287b, true);
                c10287b.aub = null;
                c10287b.m26405b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                c10287b.aub = new C10285a(this, c10287b, (byte) 0);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* renamed from: dq */
    private static void m26423dq(String str) {
        if (atD.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    /* renamed from: p */
    private static void m26418p(File file) {
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

    /* renamed from: CW */
    public final synchronized int m26440CW() {
        return this.atJ;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.atM == null) {
            return;
        }
        Iterator it = new ArrayList(this.atN.values()).iterator();
        while (it.hasNext()) {
            C10287b c10287b = (C10287b) it.next();
            if (c10287b.aub != null) {
                c10287b.aub.abort();
            }
        }
        trimToSize();
        m26438CY();
        C10738b.closeQuietly(this.atM);
        this.atM = null;
    }

    public final void delete() {
        close();
        C11122q.deleteContents(this.atE);
    }

    /* renamed from: do */
    public final synchronized C10288c m26425do(String str) {
        if (this.atM == null) {
            return null;
        }
        m26423dq(str);
        C10287b c10287b = this.atN.get(str);
        if (c10287b == null) {
            return null;
        }
        if (c10287b.aua) {
            int i = this.atK;
            File[] fileArr = new File[i];
            InputStream[] inputStreamArr = new InputStream[i];
            for (int i2 = 0; i2 < this.atK; i2++) {
                try {
                    File m26401da = c10287b.m26401da(i2);
                    fileArr[i2] = m26401da;
                    inputStreamArr[i2] = new FileInputStream(m26401da);
                } catch (FileNotFoundException unused) {
                    for (int i3 = 0; i3 < this.atK && inputStreamArr[i3] != null; i3++) {
                        C10738b.closeQuietly(inputStreamArr[i3]);
                    }
                    return null;
                }
            }
            this.atO++;
            this.atM.append((CharSequence) ("READ " + str + '\n'));
            if (m26439CX()) {
                this.atQ.submit(this.atR);
            }
            return new C10288c(this, str, c10287b.auc, fileArr, inputStreamArr, c10287b.atZ, (byte) 0);
        }
        return null;
    }

    /* renamed from: dp */
    public final C10285a m26424dp(String str) {
        return m26421e(str, -1L);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        m26438CY();
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
        m26423dq(str);
        C10287b c10287b = this.atN.get(str);
        if (c10287b != null && c10287b.aub == null) {
            for (int i = 0; i < this.atK; i++) {
                File m26401da = c10287b.m26401da(i);
                if (m26401da.exists() && !m26401da.delete()) {
                    throw new IOException("failed to delete " + m26401da);
                }
                this.size -= c10287b.atZ[i];
                this.atL--;
                c10287b.atZ[i] = 0;
            }
            this.atO++;
            this.atM.append((CharSequence) ("REMOVE " + str + '\n'));
            this.atN.remove(str);
            if (m26439CX()) {
                this.atQ.submit(this.atR);
            }
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private synchronized C10285a m26421e(String str, long j) {
        checkNotClosed();
        m26423dq(str);
        C10287b c10287b = this.atN.get(str);
        if (c10287b != null) {
            if (c10287b.aub != null) {
                return null;
            }
        } else {
            c10287b = new C10287b(this, str, (byte) 0);
            this.atN.put(str, c10287b);
        }
        C10285a c10285a = new C10285a(this, c10287b, (byte) 0);
        c10287b.aub = c10285a;
        Writer writer = this.atM;
        writer.write("DIRTY " + str + '\n');
        this.atM.flush();
        return c10285a;
    }

    /* renamed from: a */
    public static C10281a m26432a(File file, int i, int i2, long j) {
        return m26431a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static C10281a m26431a(File file, int i, int i2, long j, int i3) {
        if (j > 0) {
            if (i3 > 0) {
                if (i2 > 0) {
                    File file2 = new File(file, "journal.bkp");
                    if (file2.exists()) {
                        File file3 = new File(file, "journal");
                        if (file3.exists()) {
                            file2.delete();
                        } else {
                            m26430a(file2, file3, false);
                        }
                    }
                    C10281a c10281a = new C10281a(file, i, i2, j, i3);
                    if (c10281a.atF.exists()) {
                        try {
                            c10281a.m26443CT();
                            c10281a.m26442CU();
                            c10281a.atM = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c10281a.atF, true), C10737a.US_ASCII));
                            return c10281a;
                        } catch (IOException e) {
                            PrintStream printStream = System.out;
                            printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                            c10281a.delete();
                        }
                    }
                    file.mkdirs();
                    C10281a c10281a2 = new C10281a(file, i, i2, j, i3);
                    c10281a2.m26441CV();
                    return c10281a2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* renamed from: a */
    private static void m26430a(File file, File file2, boolean z) {
        if (z) {
            m26418p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m26436a(C10285a c10285a, boolean z) {
        C10287b c10287b = c10285a.atU;
        if (c10287b.aub == c10285a) {
            if (z && !c10287b.aua) {
                for (int i = 0; i < this.atK; i++) {
                    if (c10285a.atV[i]) {
                        if (!c10287b.m26400db(i).exists()) {
                            c10285a.abort();
                            return;
                        }
                    } else {
                        c10285a.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.atK; i2++) {
                File m26400db = c10287b.m26400db(i2);
                if (z) {
                    if (m26400db.exists()) {
                        File m26401da = c10287b.m26401da(i2);
                        m26400db.renameTo(m26401da);
                        long j = c10287b.atZ[i2];
                        long length = m26401da.length();
                        c10287b.atZ[i2] = length;
                        this.size = (this.size - j) + length;
                        this.atL++;
                    }
                } else {
                    m26418p(m26400db);
                }
            }
            this.atO++;
            c10287b.aub = null;
            if (!(c10287b.aua | z)) {
                this.atN.remove(c10287b.key);
                this.atM.write("REMOVE " + c10287b.key + '\n');
            } else {
                C10287b.m26408a(c10287b, true);
                this.atM.write("CLEAN " + c10287b.key + c10287b.m26412Da() + '\n');
                if (z) {
                    long j2 = this.atP;
                    this.atP = 1 + j2;
                    c10287b.auc = j2;
                }
            }
            this.atM.flush();
            if (this.size > this.maxSize || this.atL > this.atJ || m26439CX()) {
                this.atQ.submit(this.atR);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
