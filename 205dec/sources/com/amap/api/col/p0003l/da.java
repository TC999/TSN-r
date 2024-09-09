package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.t6;
import com.stub.StubApp;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AuthTaskDownload.java */
/* renamed from: com.amap.api.col.3l.da  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class da implements t6.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7454a;

    /* renamed from: b  reason: collision with root package name */
    private RandomAccessFile f7455b;

    /* renamed from: c  reason: collision with root package name */
    private z6 f7456c;

    /* renamed from: d  reason: collision with root package name */
    private String f7457d;

    /* renamed from: e  reason: collision with root package name */
    a f7458e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AuthTaskDownload.java */
    /* renamed from: com.amap.api.col.3l.da$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        protected String f7459a;

        /* renamed from: b  reason: collision with root package name */
        protected String f7460b;

        /* renamed from: c  reason: collision with root package name */
        protected String f7461c;

        /* renamed from: d  reason: collision with root package name */
        protected String f7462d;

        /* renamed from: e  reason: collision with root package name */
        protected String f7463e;

        /* renamed from: f  reason: collision with root package name */
        protected c f7464f;

        public a(String str, String str2, String str3, String str4) {
            this.f7459a = str;
            this.f7460b = str2;
            this.f7461c = str3;
            this.f7462d = str4 + ".tmp";
            this.f7463e = str4;
        }

        public final String a() {
            return this.f7459a;
        }

        public final void b(c cVar) {
            this.f7464f = cVar;
        }

        public final String c() {
            return this.f7460b;
        }

        public final String d() {
            return this.f7462d;
        }

        public final String e() {
            return this.f7463e;
        }

        public final c f() {
            return this.f7464f;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AuthTaskDownload.java */
    /* renamed from: com.amap.api.col.3l.da$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class b extends f2 {

        /* renamed from: i  reason: collision with root package name */
        private final a f7465i;

        b(a aVar) {
            this.f7465i = aVar;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0003l.f2, com.amap.api.col.p0003l.Cif
        public final Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            a aVar = this.f7465i;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AuthTaskDownload.java */
    /* renamed from: com.amap.api.col.3l.da$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        protected String f7466a;

        /* renamed from: b  reason: collision with root package name */
        protected String f7467b;

        public c(String str, String str2) {
            this.f7466a = str;
            this.f7467b = str2;
        }

        public final String a() {
            return this.f7466a;
        }

        public final String b() {
            return this.f7467b;
        }

        public final boolean c() {
            return (TextUtils.isEmpty(this.f7466a) || TextUtils.isEmpty(this.f7467b)) ? false : true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AuthTaskDownload.java */
    /* renamed from: com.amap.api.col.3l.da$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class d extends a {
        public d(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }

        public final void g(String str, String str2) {
            b(new c(str, str2));
        }
    }

    public da(Context context, a aVar) {
        this.f7454a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f7458e = aVar;
        this.f7456c = new z6(new b(aVar));
        this.f7457d = aVar.d();
    }

    private boolean b() {
        c f4 = this.f7458e.f();
        return (f4 != null && f4.c() && q2.b(this.f7454a, f4.a(), f4.b(), "").equalsIgnoreCase(this.f7458e.c())) ? false : true;
    }

    public final void a() {
        z6 z6Var;
        if (com.amap.api.col.p0003l.c.f7290f == null || ft.a(com.amap.api.col.p0003l.c.f7290f, a3.s()).f8385a == ft.c.SuccessCode) {
            try {
                if (!b() || (z6Var = this.f7456c) == null) {
                    return;
                }
                z6Var.b(this);
            } catch (Throwable th) {
                u5.p(th, "AuthTaskDownload", "startDownload()");
            }
        }
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public final void onDownload(byte[] bArr, long j4) {
        try {
            if (this.f7455b == null) {
                File file = new File(this.f7457d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f7455b = new RandomAccessFile(file, "rw");
            }
            this.f7455b.seek(j4);
            this.f7455b.write(bArr);
        } catch (Throwable th) {
            u5.p(th, "AuthTaskDownload", "onDownload()");
        }
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public final void onException(Throwable th) {
        try {
            RandomAccessFile randomAccessFile = this.f7455b;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
        } catch (Throwable th2) {
            u5.p(th2, "AuthTaskDownload", "onException()");
        }
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public final void onFinish() {
        try {
            RandomAccessFile randomAccessFile = this.f7455b;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
            String c4 = this.f7458e.c();
            String a4 = m4.a(this.f7457d);
            if (a4 != null && c4.equalsIgnoreCase(a4)) {
                String e4 = this.f7458e.e();
                t0 t0Var = new t0();
                File file = new File(this.f7457d);
                t0Var.b(file, new File(e4), -1L, z0.b(file), null);
                c f4 = this.f7458e.f();
                if (f4 != null && f4.c()) {
                    q2.c(this.f7454a, f4.a(), f4.b(), a4);
                }
                new File(this.f7457d).delete();
                return;
            }
            new File(this.f7457d).delete();
        } catch (Throwable th) {
            u5.p(th, "AuthTaskDownload", "onFinish()");
        }
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public final void onStop() {
    }

    /* compiled from: AuthTerrainTask.java */
    /* renamed from: com.amap.api.col.3l.da$e */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f7468a;

        /* renamed from: b  reason: collision with root package name */
        public String f7469b;

        /* renamed from: c  reason: collision with root package name */
        public String f7470c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f7471d;

        private e() {
            this.f7471d = false;
        }

        /* synthetic */ e(byte b4) {
            this();
        }
    }
}
