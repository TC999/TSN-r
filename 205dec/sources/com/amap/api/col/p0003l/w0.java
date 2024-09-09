package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.by;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.t6;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NetFileFetch.java */
/* renamed from: com.amap.api.col.3l.w0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class w0 implements t6.a {

    /* renamed from: a  reason: collision with root package name */
    x0 f9317a;

    /* renamed from: d  reason: collision with root package name */
    long f9320d;

    /* renamed from: f  reason: collision with root package name */
    private Context f9322f;

    /* renamed from: g  reason: collision with root package name */
    r0 f9323g;

    /* renamed from: h  reason: collision with root package name */
    private by f9324h;

    /* renamed from: i  reason: collision with root package name */
    private String f9325i;

    /* renamed from: j  reason: collision with root package name */
    private z6 f9326j;

    /* renamed from: k  reason: collision with root package name */
    private s0 f9327k;

    /* renamed from: n  reason: collision with root package name */
    a f9330n;

    /* renamed from: b  reason: collision with root package name */
    long f9318b = 0;

    /* renamed from: c  reason: collision with root package name */
    long f9319c = 0;

    /* renamed from: e  reason: collision with root package name */
    boolean f9321e = true;

    /* renamed from: l  reason: collision with root package name */
    long f9328l = 0;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9329m = false;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: NetFileFetch.java */
    /* renamed from: com.amap.api.col.3l.w0$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: NetFileFetch.java */
    /* renamed from: com.amap.api.col.3l.w0$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b extends f2 {

        /* renamed from: i  reason: collision with root package name */
        private final String f9331i;

        public b(String str) {
            this.f9331i = str;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            return this.f9331i;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    public w0(x0 x0Var, String str, Context context, by byVar) throws IOException {
        this.f9317a = null;
        this.f9323g = r0.b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f9317a = x0Var;
        this.f9322f = context;
        this.f9325i = str;
        this.f9324h = byVar;
        f();
    }

    private void b(long j4) {
        by byVar;
        long j5 = this.f9320d;
        if (j5 <= 0 || (byVar = this.f9324h) == null) {
            return;
        }
        byVar.a(j5, j4);
        this.f9328l = System.currentTimeMillis();
    }

    private void e() throws IOException {
        c1 c1Var = new c1(this.f9325i);
        c1Var.setConnectionTimeout(30000);
        c1Var.setSoTimeout(30000);
        this.f9326j = new z6(c1Var, this.f9318b, this.f9319c, MapsInitializer.getProtocol() == 2);
        this.f9327k = new s0(this.f9317a.b() + File.separator + this.f9317a.c(), this.f9318b);
    }

    private void f() {
        File file = new File(this.f9317a.b() + this.f9317a.c());
        if (file.exists()) {
            this.f9321e = false;
            this.f9318b = file.length();
            try {
                long i4 = i();
                this.f9320d = i4;
                this.f9319c = i4;
                return;
            } catch (IOException unused) {
                by byVar = this.f9324h;
                if (byVar != null) {
                    byVar.e(by.a.file_io_exception);
                    return;
                }
                return;
            }
        }
        this.f9318b = 0L;
        this.f9319c = 0L;
    }

    private boolean g() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9317a.b());
        sb.append(File.separator);
        sb.append(this.f9317a.c());
        return new File(sb.toString()).length() >= 10;
    }

    private void h() throws AMapException {
        if (g4.f7809a != 1) {
            for (int i4 = 0; i4 < 3; i4++) {
                try {
                    g4.c(this.f9322f, a3.s(), "", null);
                } catch (Throwable th) {
                    u5.p(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
                if (g4.f7809a == 1) {
                    return;
                }
            }
        }
    }

    private long i() throws IOException {
        if (ft.a(this.f9322f, a3.s()).f8385a != ft.c.SuccessCode) {
            return -1L;
        }
        String a4 = this.f9317a.a();
        Map<String, String> map = null;
        try {
            x6.n();
            map = x6.q(new b(a4), MapsInitializer.getProtocol() == 2);
        } catch (fk e4) {
            e4.printStackTrace();
        }
        int i4 = -1;
        if (map != null) {
            for (String str : map.keySet()) {
                if ("Content-Length".equalsIgnoreCase(str)) {
                    i4 = Integer.parseInt(map.get(str));
                }
            }
        }
        return i4;
    }

    private void j() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f9317a == null || currentTimeMillis - this.f9328l <= 500) {
            return;
        }
        k();
        this.f9328l = currentTimeMillis;
        b(this.f9318b);
    }

    private void k() {
        this.f9323g.f(this.f9317a.e(), this.f9317a.d(), this.f9320d, this.f9318b, this.f9319c);
    }

    public final void a() {
        try {
            if (a3.h0(this.f9322f)) {
                h();
                if (g4.f7809a != 1) {
                    by byVar = this.f9324h;
                    if (byVar != null) {
                        byVar.e(by.a.amap_exception);
                        return;
                    }
                    return;
                }
                if (!g()) {
                    this.f9321e = true;
                }
                if (this.f9321e) {
                    long i4 = i();
                    this.f9320d = i4;
                    if (i4 != -1 && i4 != -2) {
                        this.f9319c = i4;
                    }
                    this.f9318b = 0L;
                }
                by byVar2 = this.f9324h;
                if (byVar2 != null) {
                    byVar2.m();
                }
                if (this.f9318b >= this.f9319c) {
                    onFinish();
                    return;
                }
                e();
                this.f9326j.b(this);
                return;
            }
            by byVar3 = this.f9324h;
            if (byVar3 != null) {
                byVar3.e(by.a.network_exception);
            }
        } catch (AMapException e4) {
            u5.p(e4, "SiteFileFetch", "download");
            by byVar4 = this.f9324h;
            if (byVar4 != null) {
                byVar4.e(by.a.amap_exception);
            }
        } catch (IOException unused) {
            by byVar5 = this.f9324h;
            if (byVar5 != null) {
                byVar5.e(by.a.file_io_exception);
            }
        }
    }

    public final void c(a aVar) {
        this.f9330n = aVar;
    }

    public final void d() {
        z6 z6Var = this.f9326j;
        if (z6Var != null) {
            z6Var.a();
        }
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public final void onDownload(byte[] bArr, long j4) {
        try {
            this.f9327k.a(bArr);
            this.f9318b = j4;
            j();
        } catch (IOException e4) {
            e4.printStackTrace();
            u5.p(e4, "fileAccessI", "fileAccessI.write(byte[] data)");
            by byVar = this.f9324h;
            if (byVar != null) {
                byVar.e(by.a.file_io_exception);
            }
            z6 z6Var = this.f9326j;
            if (z6Var != null) {
                z6Var.a();
            }
        }
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public final void onException(Throwable th) {
        s0 s0Var;
        this.f9329m = true;
        d();
        by byVar = this.f9324h;
        if (byVar != null) {
            byVar.e(by.a.network_exception);
        }
        if ((th instanceof IOException) || (s0Var = this.f9327k) == null) {
            return;
        }
        s0Var.b();
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public final void onFinish() {
        j();
        by byVar = this.f9324h;
        if (byVar != null) {
            byVar.n();
        }
        s0 s0Var = this.f9327k;
        if (s0Var != null) {
            s0Var.b();
        }
        a aVar = this.f9330n;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.amap.api.col.p0003l.t6.a
    public final void onStop() {
        if (this.f9329m) {
            return;
        }
        by byVar = this.f9324h;
        if (byVar != null) {
            byVar.d();
        }
        k();
    }
}
