package com.bytedance.sdk.component.xv.w.c.c;

import com.bytedance.sdk.component.xv.c.a;
import com.bytedance.sdk.component.xv.c.fz;
import com.bytedance.sdk.component.xv.c.s;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr implements Closeable, Flushable {
    static final /* synthetic */ boolean bk = true;

    /* renamed from: c  reason: collision with root package name */
    static final Pattern f30739c = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: a  reason: collision with root package name */
    boolean f30740a;
    boolean ev;

    /* renamed from: f  reason: collision with root package name */
    final LinkedHashMap<String, w> f30741f;
    private final File fp;
    private long fz;
    boolean gd;

    /* renamed from: i  reason: collision with root package name */
    private final Executor f30742i;
    private final int ia;

    /* renamed from: k  reason: collision with root package name */
    boolean f30743k;

    /* renamed from: p  reason: collision with root package name */
    boolean f30744p;

    /* renamed from: q  reason: collision with root package name */
    private final Runnable f30745q;

    /* renamed from: r  reason: collision with root package name */
    int f30746r;

    /* renamed from: s  reason: collision with root package name */
    private long f30747s;
    final int sr;

    /* renamed from: t  reason: collision with root package name */
    private final File f30748t;

    /* renamed from: u  reason: collision with root package name */
    private long f30749u;
    com.bytedance.sdk.component.xv.c.sr ux;

    /* renamed from: w  reason: collision with root package name */
    final com.bytedance.sdk.component.xv.w.c.f.c f30750w;
    final File xv;
    private final File ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class xv implements Closeable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ sr f30760c;
        private final fz[] sr;

        /* renamed from: w  reason: collision with root package name */
        private final String f30761w;
        private final long xv;

        public c c() throws IOException {
            return this.f30760c.c(this.f30761w, this.xv);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (fz fzVar : this.sr) {
                com.bytedance.sdk.component.xv.w.c.xv.c(fzVar);
            }
        }
    }

    private void ev() throws IOException {
        this.f30750w.delete(this.ys);
        Iterator<w> it = this.f30741f.values().iterator();
        while (it.hasNext()) {
            w next = it.next();
            int i4 = 0;
            if (next.f30757f == null) {
                while (i4 < this.sr) {
                    this.fz += next.f30759w[i4];
                    i4++;
                }
            } else {
                next.f30757f = null;
                while (i4 < this.sr) {
                    this.f30750w.delete(next.xv[i4]);
                    this.f30750w.delete(next.sr[i4]);
                    i4++;
                }
                it.remove();
            }
        }
    }

    private void f() throws IOException {
        com.bytedance.sdk.component.xv.c.ux c4 = a.c(this.f30750w.c(this.f30748t));
        try {
            String fp = c4.fp();
            String fp2 = c4.fp();
            String fp3 = c4.fp();
            String fp4 = c4.fp();
            String fp5 = c4.fp();
            if (!"libcore.io.DiskLruCache".equals(fp) || !"1".equals(fp2) || !Integer.toString(this.ia).equals(fp3) || !Integer.toString(this.sr).equals(fp4) || !"".equals(fp5)) {
                throw new IOException("unexpected journal header: [" + fp + ", " + fp2 + ", " + fp4 + ", " + fp5 + "]");
            }
            int i4 = 0;
            while (true) {
                try {
                    c(c4.fp());
                    i4++;
                } catch (EOFException unused) {
                    this.f30746r = i4 - this.f30741f.size();
                    if (!c4.ux()) {
                        w();
                    } else {
                        this.ux = r();
                    }
                    com.bytedance.sdk.component.xv.w.c.xv.c(c4);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.xv.w.c.xv.c(c4);
            throw th;
        }
    }

    private synchronized void gd() {
        if (sr()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private com.bytedance.sdk.component.xv.c.sr r() throws FileNotFoundException {
        return a.c(new ux(this.f30750w.xv(this.f30748t)) { // from class: com.bytedance.sdk.component.xv.w.c.c.sr.1

            /* renamed from: c  reason: collision with root package name */
            static final /* synthetic */ boolean f30751c = true;

            @Override // com.bytedance.sdk.component.xv.w.c.c.ux
            protected void c(IOException iOException) {
                if (!f30751c && !Thread.holdsLock(sr.this)) {
                    throw new AssertionError();
                }
                sr.this.ev = true;
            }
        });
    }

    public synchronized void c() throws IOException {
        if (!bk && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.gd) {
            return;
        }
        if (this.f30750w.sr(this.fp)) {
            if (this.f30750w.sr(this.f30748t)) {
                this.f30750w.delete(this.fp);
            } else {
                this.f30750w.c(this.fp, this.f30748t);
            }
        }
        if (this.f30750w.sr(this.f30748t)) {
            try {
                f();
                ev();
                this.gd = true;
                return;
            } catch (IOException e4) {
                com.bytedance.sdk.component.xv.w.c.r.ux w3 = com.bytedance.sdk.component.xv.w.c.r.ux.w();
                w3.c(5, "DiskLruCache " + this.xv + " is corrupt: " + e4.getMessage() + ", removing", e4);
                delete();
                this.f30744p = false;
            }
        }
        w();
        this.gd = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.gd && !this.f30744p) {
            for (w wVar : (w[]) this.f30741f.values().toArray(new w[this.f30741f.size()])) {
                c cVar = wVar.f30757f;
                if (cVar != null) {
                    cVar.xv();
                }
            }
            ux();
            this.ux.close();
            this.ux = null;
            this.f30744p = true;
            return;
        }
        this.f30744p = true;
    }

    public void delete() throws IOException {
        close();
        this.f30750w.f(this.xv);
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.gd) {
            gd();
            ux();
            this.ux.flush();
        }
    }

    public synchronized boolean sr() {
        return this.f30744p;
    }

    void ux() throws IOException {
        while (this.fz > this.f30747s) {
            c(this.f30741f.values().iterator().next());
        }
        this.f30743k = false;
    }

    synchronized void w() throws IOException {
        com.bytedance.sdk.component.xv.c.sr srVar = this.ux;
        if (srVar != null) {
            srVar.close();
        }
        com.bytedance.sdk.component.xv.c.sr c4 = a.c(this.f30750w.w(this.ys));
        c4.w("libcore.io.DiskLruCache").gd(10);
        c4.w("1").gd(10);
        c4.a(this.ia).gd(10);
        c4.a(this.sr).gd(10);
        c4.gd(10);
        for (w wVar : this.f30741f.values()) {
            if (wVar.f30757f != null) {
                c4.w("DIRTY").gd(32);
                c4.w(wVar.f30756c);
                c4.gd(10);
            } else {
                c4.w("CLEAN").gd(32);
                c4.w(wVar.f30756c);
                wVar.c(c4);
                c4.gd(10);
            }
        }
        c4.close();
        if (this.f30750w.sr(this.f30748t)) {
            this.f30750w.c(this.f30748t, this.fp);
        }
        this.f30750w.c(this.ys, this.f30748t);
        this.f30750w.delete(this.fp);
        this.ux = r();
        this.ev = false;
        this.f30740a = false;
    }

    boolean xv() {
        int i4 = this.f30746r;
        return i4 >= 2000 && i4 >= this.f30741f.size();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class c {

        /* renamed from: c  reason: collision with root package name */
        final w f30753c;
        private boolean sr;

        /* renamed from: w  reason: collision with root package name */
        final boolean[] f30754w;

        c(w wVar) {
            this.f30753c = wVar;
            this.f30754w = wVar.ux ? null : new boolean[sr.this.sr];
        }

        void c() {
            if (this.f30753c.f30757f != this) {
                return;
            }
            int i4 = 0;
            while (true) {
                sr srVar = sr.this;
                if (i4 < srVar.sr) {
                    try {
                        srVar.f30750w.delete(this.f30753c.sr[i4]);
                    } catch (IOException unused) {
                    }
                    i4++;
                } else {
                    this.f30753c.f30757f = null;
                    return;
                }
            }
        }

        public void w() throws IOException {
            synchronized (sr.this) {
                if (!this.sr) {
                    if (this.f30753c.f30757f == this) {
                        sr.this.c(this, true);
                    }
                    this.sr = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        public void xv() throws IOException {
            synchronized (sr.this) {
                if (!this.sr) {
                    if (this.f30753c.f30757f == this) {
                        sr.this.c(this, false);
                    }
                    this.sr = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        public s c(int i4) {
            synchronized (sr.this) {
                if (!this.sr) {
                    w wVar = this.f30753c;
                    if (wVar.f30757f != this) {
                        return a.c();
                    }
                    if (!wVar.ux) {
                        this.f30754w[i4] = true;
                    }
                    try {
                        return new ux(sr.this.f30750w.w(wVar.sr[i4])) { // from class: com.bytedance.sdk.component.xv.w.c.c.sr.c.1
                            @Override // com.bytedance.sdk.component.xv.w.c.c.ux
                            protected void c(IOException iOException) {
                                synchronized (sr.this) {
                                    c.this.c();
                                }
                            }
                        };
                    } catch (FileNotFoundException unused) {
                        return a.c();
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class w {

        /* renamed from: c  reason: collision with root package name */
        final String f30756c;

        /* renamed from: f  reason: collision with root package name */
        c f30757f;

        /* renamed from: r  reason: collision with root package name */
        long f30758r;
        final File[] sr;
        boolean ux;

        /* renamed from: w  reason: collision with root package name */
        final long[] f30759w;
        final File[] xv;

        w(String str) {
            this.f30756c = str;
            int i4 = sr.this.sr;
            this.f30759w = new long[i4];
            this.xv = new File[i4];
            this.sr = new File[i4];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i5 = 0; i5 < sr.this.sr; i5++) {
                sb.append(i5);
                this.xv[i5] = new File(sr.this.xv, sb.toString());
                sb.append(".tmp");
                this.sr[i5] = new File(sr.this.xv, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException w(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        void c(String[] strArr) throws IOException {
            if (strArr.length == sr.this.sr) {
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    try {
                        this.f30759w[i4] = Long.parseLong(strArr[i4]);
                    } catch (NumberFormatException unused) {
                        throw w(strArr);
                    }
                }
                return;
            }
            throw w(strArr);
        }

        void c(com.bytedance.sdk.component.xv.c.sr srVar) throws IOException {
            for (long j4 : this.f30759w) {
                srVar.gd(32).a(j4);
            }
        }
    }

    private void c(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i4 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i4);
            if (indexOf2 == -1) {
                substring = str.substring(i4);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f30741f.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i4, indexOf2);
            }
            w wVar = this.f30741f.get(substring);
            if (wVar == null) {
                wVar = new w(substring);
                this.f30741f.put(substring, wVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                wVar.ux = true;
                wVar.f30757f = null;
                wVar.c(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                wVar.f30757f = new c(wVar);
                return;
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void w(String str) {
        if (f30739c.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    synchronized c c(String str, long j4) throws IOException {
        c();
        gd();
        w(str);
        w wVar = this.f30741f.get(str);
        if (j4 == -1 || (wVar != null && wVar.f30758r == j4)) {
            if (wVar == null || wVar.f30757f == null) {
                if (!this.f30743k && !this.f30740a) {
                    this.ux.w("DIRTY").gd(32).w(str).gd(10);
                    this.ux.flush();
                    if (this.ev) {
                        return null;
                    }
                    if (wVar == null) {
                        wVar = new w(str);
                        this.f30741f.put(str, wVar);
                    }
                    c cVar = new c(wVar);
                    wVar.f30757f = cVar;
                    return cVar;
                }
                this.f30742i.execute(this.f30745q);
                return null;
            }
            return null;
        }
        return null;
    }

    synchronized void c(c cVar, boolean z3) throws IOException {
        w wVar = cVar.f30753c;
        if (wVar.f30757f == cVar) {
            if (z3 && !wVar.ux) {
                for (int i4 = 0; i4 < this.sr; i4++) {
                    if (cVar.f30754w[i4]) {
                        if (!this.f30750w.sr(wVar.sr[i4])) {
                            cVar.xv();
                            return;
                        }
                    } else {
                        cVar.xv();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i4);
                    }
                }
            }
            for (int i5 = 0; i5 < this.sr; i5++) {
                File file = wVar.sr[i5];
                if (z3) {
                    if (this.f30750w.sr(file)) {
                        File file2 = wVar.xv[i5];
                        this.f30750w.c(file, file2);
                        long j4 = wVar.f30759w[i5];
                        long ux = this.f30750w.ux(file2);
                        wVar.f30759w[i5] = ux;
                        this.fz = (this.fz - j4) + ux;
                    }
                } else {
                    this.f30750w.delete(file);
                }
            }
            this.f30746r++;
            wVar.f30757f = null;
            if (wVar.ux | z3) {
                wVar.ux = true;
                this.ux.w("CLEAN").gd(32);
                this.ux.w(wVar.f30756c);
                wVar.c(this.ux);
                this.ux.gd(10);
                if (z3) {
                    long j5 = this.f30749u;
                    this.f30749u = 1 + j5;
                    wVar.f30758r = j5;
                }
            } else {
                this.f30741f.remove(wVar.f30756c);
                this.ux.w("REMOVE").gd(32);
                this.ux.w(wVar.f30756c);
                this.ux.gd(10);
            }
            this.ux.flush();
            if (this.fz > this.f30747s || xv()) {
                this.f30742i.execute(this.f30745q);
            }
            return;
        }
        throw new IllegalStateException();
    }

    boolean c(w wVar) throws IOException {
        c cVar = wVar.f30757f;
        if (cVar != null) {
            cVar.c();
        }
        for (int i4 = 0; i4 < this.sr; i4++) {
            this.f30750w.delete(wVar.xv[i4]);
            long j4 = this.fz;
            long[] jArr = wVar.f30759w;
            this.fz = j4 - jArr[i4];
            jArr[i4] = 0;
        }
        this.f30746r++;
        this.ux.w("REMOVE").gd(32).w(wVar.f30756c).gd(10);
        this.f30741f.remove(wVar.f30756c);
        if (xv()) {
            this.f30742i.execute(this.f30745q);
        }
        return true;
    }
}
