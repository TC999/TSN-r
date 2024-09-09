package com.qq.e.comm.plugin.p.j;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.p.j.l;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.x1;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements com.qq.e.comm.plugin.p.f, com.qq.e.comm.plugin.p.g {
    private static final com.qq.e.comm.plugin.p.b B = new b();

    /* renamed from: a  reason: collision with root package name */
    private final String f45225a;

    /* renamed from: b  reason: collision with root package name */
    private final File f45226b;

    /* renamed from: c  reason: collision with root package name */
    private int f45227c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.p.j.o.b f45228d;

    /* renamed from: f  reason: collision with root package name */
    private final ExecutorService f45230f;

    /* renamed from: g  reason: collision with root package name */
    private com.qq.e.comm.plugin.p.j.o.a f45231g;

    /* renamed from: i  reason: collision with root package name */
    private int f45233i;

    /* renamed from: j  reason: collision with root package name */
    private String f45234j;

    /* renamed from: k  reason: collision with root package name */
    private com.qq.e.comm.plugin.p.g f45235k;

    /* renamed from: l  reason: collision with root package name */
    private g f45236l;

    /* renamed from: n  reason: collision with root package name */
    private int f45238n;

    /* renamed from: o  reason: collision with root package name */
    private int f45239o;

    /* renamed from: p  reason: collision with root package name */
    private long f45240p;

    /* renamed from: q  reason: collision with root package name */
    private long f45241q;

    /* renamed from: r  reason: collision with root package name */
    private long f45242r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f45243s;

    /* renamed from: v  reason: collision with root package name */
    private com.qq.e.comm.plugin.p.b f45246v;

    /* renamed from: w  reason: collision with root package name */
    private volatile boolean f45247w;

    /* renamed from: y  reason: collision with root package name */
    private File f45249y;

    /* renamed from: z  reason: collision with root package name */
    private String f45250z;

    /* renamed from: h  reason: collision with root package name */
    private AtomicBoolean f45232h = new AtomicBoolean(false);

    /* renamed from: m  reason: collision with root package name */
    private long f45237m = -1;

    /* renamed from: t  reason: collision with root package name */
    private double f45244t = 1.0d;

    /* renamed from: u  reason: collision with root package name */
    private final List<h> f45245u = new ArrayList();

    /* renamed from: x  reason: collision with root package name */
    private volatile boolean f45248x = false;
    private Map<String, Object> A = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private final l f45229e = new com.qq.e.comm.plugin.p.j.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getAbsolutePath().startsWith(f.this.f45226b.getAbsolutePath());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class b implements com.qq.e.comm.plugin.p.b {
        b() {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, long j5, int i4) {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(long j4, boolean z3) {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(com.qq.e.comm.plugin.p.d dVar) {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(boolean z3) {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements Callable<Pair<Integer, String>> {

        /* renamed from: a  reason: collision with root package name */
        private final h f45252a;

        /* renamed from: b  reason: collision with root package name */
        private final com.qq.e.comm.plugin.p.j.c f45253b;

        public c(h hVar, com.qq.e.comm.plugin.p.j.c cVar) {
            this.f45252a = hVar;
            this.f45253b = cVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Pair<Integer, String> call() throws Exception {
            this.f45252a.a(this.f45253b);
            return new Pair<>(Integer.valueOf(this.f45252a.b()), this.f45252a.a());
        }
    }

    public f(String str, File file, int i4, com.qq.e.comm.plugin.p.c cVar, boolean z3, String str2) {
        this.f45225a = str;
        this.f45226b = file;
        this.f45227c = i4;
        this.f45228d = new com.qq.e.comm.plugin.p.j.o.b(cVar.a(), cVar.c(), cVar.d());
        this.f45230f = cVar.b();
        this.f45243s = z3;
        this.f45228d.a(str2);
    }

    private boolean d(List<File> list) throws IOException {
        if (list.size() == 1) {
            if (!b1.b(list.get(0), this.f45226b)) {
                this.f45233i |= 16384;
                this.f45234j = "ExceptionWhileRenameTmpFileToTargetFile";
                return false;
            }
        } else {
            a(list, 0, false);
        }
        return true;
    }

    private void j() {
        if (this.f45243s) {
            try {
                a(-1).createNewFile();
            } catch (IOException e4) {
                d1.a("throw IOException", e4);
            }
        }
    }

    private void k() {
        File file = this.f45249y;
        if (file == null || !file.exists()) {
            return;
        }
        this.f45249y.delete();
    }

    private boolean l() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f45233i = 0;
        this.f45234j = "";
        if (!this.f45247w) {
            m().a();
        }
        if (p()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            boolean z3 = b(arrayList, arrayList2) && a(arrayList, arrayList2) && b(arrayList) && this.f45233i == 0;
            this.f45242r = System.currentTimeMillis() - currentTimeMillis;
            if (z3 && this.f45240p <= 0) {
                this.f45240p = this.f45226b.length();
            }
            if (z3) {
                if (this.f45244t < 1.0d && this.f45226b.length() < this.f45240p) {
                    this.f45233i = 128;
                    this.f45234j = "DownloaderIsPausedAuto";
                    m().a(true);
                } else {
                    j();
                    k();
                    m().a(this.f45226b, this.f45242r);
                }
            } else if (com.qq.e.comm.plugin.p.e.e(this.f45233i)) {
                this.f45233i = 128;
                this.f45234j = "DownloaderIsPausedManual";
                m().a(false);
            } else if (com.qq.e.comm.plugin.p.e.a(this.f45233i)) {
                this.f45233i = 64;
                this.f45234j = "DownloaderIsCanceledManual";
                m().b();
                a(arrayList);
            } else {
                m().a(new com.qq.e.comm.plugin.p.d(this.f45233i, this.f45234j));
            }
            return z3;
        }
        return false;
    }

    private com.qq.e.comm.plugin.p.b m() {
        com.qq.e.comm.plugin.p.b bVar = this.f45246v;
        return bVar == null ? B : bVar;
    }

    private int n() {
        File[] listFiles;
        int a4 = x1.a(b1.d(this.f45249y), 0);
        if (a4 > 0) {
            this.f45239o = 1;
            return a4;
        }
        File parentFile = this.f45226b.getParentFile();
        if (parentFile == null || (listFiles = parentFile.listFiles(new a())) == null) {
            return 0;
        }
        this.f45239o = 2;
        return listFiles.length;
    }

    private void o() {
        if (this.f45232h.compareAndSet(false, true)) {
            for (h hVar : this.f45245u) {
                hVar.pause();
            }
        }
    }

    private boolean p() {
        if (TextUtils.isEmpty(this.f45225a)) {
            this.f45233i |= 4;
            this.f45234j = "UrlEmptyError";
            m().a(new com.qq.e.comm.plugin.p.d(this.f45233i, this.f45234j));
            return false;
        }
        File file = this.f45226b;
        File parentFile = file == null ? null : file.getParentFile();
        if (parentFile != null && (parentFile.exists() || parentFile.mkdirs())) {
            File file2 = this.f45249y;
            if (file2 == null || file2.exists()) {
                return true;
            }
            b1.c(this.f45249y, String.valueOf(this.f45227c));
            return true;
        }
        this.f45233i |= 2048;
        this.f45234j = "FailToCreateDirectory";
        m().a(new com.qq.e.comm.plugin.p.d(this.f45233i, this.f45234j));
        return false;
    }

    public void b(boolean z3) {
        this.f45247w = z3;
    }

    public void c(boolean z3) {
        if (z3) {
            this.f45249y = new File(this.f45226b.getAbsolutePath() + "_tc");
            int n4 = n();
            this.f45238n = n4;
            if (n4 != 0) {
                this.f45227c = n4;
            }
        }
    }

    @Override // com.qq.e.comm.plugin.p.f
    public void cancel() {
        this.f45233i |= 64;
        o();
    }

    @Override // com.qq.e.comm.plugin.p.f
    public Map<String, Object> e() {
        return this.A;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public long f() {
        return this.f45242r;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public boolean g() {
        try {
            return l();
        } catch (Exception e4) {
            m().a(new com.qq.e.comm.plugin.p.d(1, e4.getMessage(), e4));
            return false;
        }
    }

    @Override // com.qq.e.comm.plugin.p.f
    public String getContentType() {
        return this.f45250z;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public int h() {
        return this.f45227c;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public long i() {
        long a4;
        long j4;
        if (this.f45233i == 0) {
            a4 = this.f45240p;
            j4 = this.f45241q;
        } else {
            g gVar = this.f45236l;
            if (gVar == null) {
                return 0L;
            }
            a4 = gVar.a();
            j4 = this.f45241q;
        }
        return a4 - j4;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public void pause() {
        this.f45233i |= 128;
        o();
    }

    private boolean b(List<File> list) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (this.f45243s) {
                    c(list);
                } else if (!d(list)) {
                    return false;
                }
                if (this.f45226b.exists()) {
                    return true;
                }
                this.f45233i |= 32768;
                this.f45234j = "DownloadFileNotExist";
                return false;
            } catch (IOException e4) {
                this.f45233i |= 512;
                this.f45234j = "UnknownIOExceptionWhileMerge:" + e4.getMessage();
                return false;
            } catch (Throwable th) {
                this.f45233i = 1 | this.f45233i;
                this.f45234j = "UnknownExceptionWhileMerge:" + th.getMessage();
                return false;
            }
        } finally {
            this.f45237m = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    public void a(double d4) {
        this.f45244t = d4;
    }

    private void a(List<File> list) {
        if (this.f45226b.exists()) {
            this.f45226b.delete();
        }
        if (list.isEmpty()) {
            return;
        }
        for (File file : list) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private void c(List<File> list) throws IOException {
        if (list.size() > 1) {
            a(list, 1, true);
        }
    }

    private File c(int i4) {
        String str;
        if (i4 == -1) {
            str = "_complete";
        } else if (i4 != 0) {
            str = "_" + i4;
        } else {
            return this.f45226b;
        }
        String name = this.f45226b.getName();
        return new File(this.f45226b.getParentFile(), name + str);
    }

    @Override // com.qq.e.comm.plugin.p.f
    public long d() {
        return this.f45240p;
    }

    private boolean a(List<File> list, List<l.a> list2) {
        boolean z3 = true;
        if (this.f45248x) {
            return true;
        }
        boolean z4 = false;
        if (list2.size() != list.size()) {
            this.f45233i |= 1;
            this.f45234j = "RangeCount!=PartitionFileCount";
        } else {
            for (int i4 = 0; i4 < list2.size(); i4++) {
                long a4 = list2.get(i4).a();
                if (a4 <= 0) {
                    break;
                }
                long length = list.get(i4).length();
                if (a4 != length) {
                    this.f45233i |= 16;
                    this.f45234j = "PartitionFileSize!=RangeSize," + length + "," + a4;
                    z3 = false;
                }
            }
            z4 = z3;
        }
        if (!z4) {
            for (File file : list) {
                file.delete();
            }
        }
        return z4;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("ltc", Integer.valueOf(this.f45238n));
        hashMap.put("ltcs", Integer.valueOf(this.f45239o));
        hashMap.put("mt", Long.valueOf(this.f45237m));
        return hashMap;
    }

    private void a(List<File> list, int i4, boolean z3) throws IOException {
        int size = list.size();
        if (i4 >= size) {
            d1.a("MultiThreadFileDownloader mergeAndDelete error params startIndex: " + i4 + ", size: " + size);
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.f45226b, z3);
        byte[] bArr = new byte[8192];
        for (int i5 = i4; i5 < size; i5++) {
            FileInputStream fileInputStream = new FileInputStream(list.get(i5));
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                }
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
        while (i4 < size) {
            list.get(i4).delete();
            i4++;
        }
    }

    private boolean b(List<File> list, List<l.a> list2) {
        l.a[] aVarArr;
        File a4 = a(0);
        if (this.f45232h.get()) {
            this.f45233i |= 128;
            d1.a("download paused, quit", new Object[0]);
            return false;
        }
        boolean z3 = this.f45244t < 1.0d;
        if (a(a4, -1L, z3)) {
            ArrayList<Future> arrayList = new ArrayList();
            if (this.f45231g.p()) {
                long f4 = this.f45231g.f() + a4.length();
                this.f45240p = f4;
                if (z3) {
                    double d4 = this.f45244t;
                    double d5 = f4;
                    Double.isNaN(d5);
                    long j4 = (long) (d4 * d5);
                    long length = j4 - a4.length();
                    if (length <= 0) {
                        this.f45248x = true;
                        a(true);
                        m().a(j4, this.f45240p, (int) (this.f45244t * 100.0d));
                        this.f45231g.b();
                        return true;
                    } else if (!a(a4, length, false)) {
                        return false;
                    } else {
                        f4 = j4;
                    }
                }
                a(true);
                aVarArr = this.f45229e.a(f4, this.f45227c);
            } else if (a4.exists() && !a4.delete()) {
                this.f45233i |= 8192;
                this.f45234j = "FailToDeleteMainPartitionFile";
                return false;
            } else {
                this.f45240p = this.f45231g.f();
                if (z3 && !a(a4, -1L, false)) {
                    return false;
                }
                aVarArr = new l.a[]{new l.a(0L, this.f45240p)};
                a(false);
            }
            a(this.f45240p, aVarArr);
            list2.add(aVarArr[0]);
            e eVar = new e(this.f45231g, a4, aVarArr[0].a());
            arrayList.add(a(new c(eVar, this.f45236l.a(0))));
            list.add(a4);
            this.f45245u.add(eVar);
            for (int i4 = 1; i4 < aVarArr.length && !this.f45232h.get(); i4++) {
                list2.add(aVarArr[i4]);
                File a5 = a(i4);
                list.add(a5);
                m mVar = new m(this.f45225a, a5, aVarArr[i4].b(), aVarArr[i4].a(), this.f45228d);
                this.f45245u.add(mVar);
                arrayList.add(a(new c(mVar, this.f45236l.a(i4))));
            }
            for (Future future : arrayList) {
                try {
                    Pair pair = (Pair) future.get();
                    if (((Integer) pair.first).intValue() != 0) {
                        this.f45233i |= ((Integer) pair.first).intValue();
                        this.f45234j += ((String) pair.second) + ";\t";
                    }
                } catch (Throwable th) {
                    this.f45233i |= 1;
                    this.f45234j += "ExceptionWhileExecutePartitionWorks:" + th.getMessage() + "\t";
                }
            }
            this.f45231g.b();
            return this.f45233i == 0;
        }
        return false;
    }

    private void a(boolean z3) {
        com.qq.e.comm.plugin.p.b m4 = m();
        m4.a(this.f45240p, z3);
        String j4 = this.f45231g.j();
        this.f45250z = j4;
        if (m4 instanceof com.qq.e.comm.plugin.p.a) {
            ((com.qq.e.comm.plugin.p.a) m4).a(j4, this.f45240p);
        }
    }

    private boolean a(File file, long j4, boolean z3) {
        try {
            if (this.f45231g != null) {
                this.f45231g.b();
            }
            com.qq.e.comm.plugin.p.j.o.a a4 = this.f45228d.a(this.f45225a, file.length(), j4, z3);
            this.f45231g = a4;
            if (!a4.c()) {
                this.f45233i |= this.f45231g.g();
                this.f45234j = this.f45231g.h();
                this.f45231g.b();
                if (com.qq.e.comm.plugin.p.e.g(this.f45233i) && file.exists()) {
                    file.delete();
                }
                d1.a("main fail, code = %d, msg = %s", Integer.valueOf(this.f45231g.g()), this.f45231g.h());
                return false;
            }
            this.A.put("ekaio", Long.valueOf(this.f45231g.e()));
            return true;
        } catch (IOException e4) {
            d1.a("main exception: %s", e4.toString());
            this.f45233i |= 524288;
            this.f45234j = "IOExceptionWhileCreateConnection " + e4.getMessage();
            return false;
        }
    }

    private Future<Pair<Integer, String>> a(c cVar) {
        ExecutorService executorService = this.f45230f;
        if (executorService == null) {
            return new n(cVar);
        }
        return executorService.submit(cVar);
    }

    private void a(long j4, l.a[] aVarArr) {
        this.f45241q = 0L;
        int length = aVarArr.length;
        long[] jArr = new long[length];
        long[] jArr2 = new long[length];
        for (int i4 = 0; i4 < length; i4++) {
            jArr[i4] = aVarArr[i4].a();
            File a4 = a(i4);
            jArr2[i4] = a4 != null ? a4.length() : 0L;
            this.f45241q += jArr2[i4];
        }
        g gVar = new g(j4, jArr, jArr2);
        this.f45236l = gVar;
        gVar.a(this);
    }

    private File a(int i4) {
        if (this.f45243s) {
            return c(i4);
        }
        return b(i4);
    }

    @Override // com.qq.e.comm.plugin.p.f
    public void a(com.qq.e.comm.plugin.p.g gVar) {
        this.f45235k = gVar;
    }

    public void a(com.qq.e.comm.plugin.p.b bVar) {
        this.f45246v = bVar;
    }

    @Override // com.qq.e.comm.plugin.p.f
    public String a() {
        return this.f45234j;
    }

    @Override // com.qq.e.comm.plugin.p.g
    public void a(long j4, long j5) {
        if (this.f45246v != null) {
            this.f45246v.a(j4, j5, j5 <= 0 ? 0 : (int) ((100 * j4) / j5));
        }
        com.qq.e.comm.plugin.p.g gVar = this.f45235k;
        if (gVar != null) {
            gVar.a(j4, j5);
        }
    }

    private File b(int i4) {
        String name = this.f45226b.getName();
        File parentFile = this.f45226b.getParentFile();
        return new File(parentFile, name + "_" + i4);
    }

    @Override // com.qq.e.comm.plugin.p.f
    public int b() {
        return this.f45233i;
    }
}
