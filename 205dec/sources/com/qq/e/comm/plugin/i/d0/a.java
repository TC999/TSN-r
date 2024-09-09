package com.qq.e.comm.plugin.i.d0;

import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.util.p0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements com.qq.e.comm.plugin.i.d0.b {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.i.d0.b f44071a;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.i.d0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class RunnableC0843a implements Runnable {
        RunnableC0843a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f44071a.c();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f44073c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f44074d;

        b(String str, com.qq.e.comm.plugin.g0.e eVar) {
            this.f44073c = str;
            this.f44074d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f44071a.b(this.f44073c, this.f44074d);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f44076c;

        c(String str) {
            this.f44076c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f44071a.a(this.f44076c);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f44078c;

        d(String str) {
            this.f44078c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f44071a.b(this.f44078c);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class e implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f44080c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f44081d;

        e(String str, com.qq.e.comm.plugin.g0.e eVar) {
            this.f44080c = str;
            this.f44081d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f44071a.a(this.f44080c, this.f44081d);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f44071a.b();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class g implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f44084c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.i.d0.c f44085d;

        g(String str, com.qq.e.comm.plugin.i.d0.c cVar) {
            this.f44084c = str;
            this.f44085d = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f44071a.a(this.f44084c, this.f44085d);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class h implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f44087c;

        h(boolean z3) {
            this.f44087c = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f44071a.a(this.f44087c);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class i implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.b f44089c;

        i(com.qq.e.comm.plugin.g0.b bVar) {
            this.f44089c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f44071a.a(this.f44089c);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class j implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f44091c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DownloadConfirmListener f44092d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.i.d0.c f44093e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f44094f;

        j(com.qq.e.comm.plugin.g0.e eVar, DownloadConfirmListener downloadConfirmListener, com.qq.e.comm.plugin.i.d0.c cVar, int i4) {
            this.f44091c = eVar;
            this.f44092d = downloadConfirmListener;
            this.f44093e = cVar;
            this.f44094f = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f44071a.a(this.f44091c, this.f44092d, this.f44093e, this.f44094f);
        }
    }

    public a(com.qq.e.comm.plugin.i.d0.b bVar) {
        this.f44071a = bVar;
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void b(String str, com.qq.e.comm.plugin.g0.e eVar) {
        if (this.f44071a != null) {
            p0.a((Runnable) new b(str, eVar));
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void c() {
        if (this.f44071a != null) {
            p0.a((Runnable) new RunnableC0843a());
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void a(String str) {
        if (this.f44071a != null) {
            p0.a((Runnable) new c(str));
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void b(String str) {
        if (this.f44071a != null) {
            p0.a((Runnable) new d(str));
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public boolean a(String str, com.qq.e.comm.plugin.g0.e eVar) {
        if (this.f44071a != null) {
            p0.a((Runnable) new e(str, eVar));
            return true;
        }
        return true;
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void b() {
        if (this.f44071a != null) {
            p0.a((Runnable) new f());
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void a(String str, com.qq.e.comm.plugin.i.d0.c cVar) {
        if (this.f44071a != null) {
            p0.a((Runnable) new g(str, cVar));
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void a(boolean z3) {
        if (this.f44071a != null) {
            p0.a((Runnable) new h(z3));
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void a(com.qq.e.comm.plugin.g0.b bVar) {
        if (this.f44071a != null) {
            p0.a((Runnable) new i(bVar));
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public void a(com.qq.e.comm.plugin.g0.e eVar, DownloadConfirmListener downloadConfirmListener, com.qq.e.comm.plugin.i.d0.c cVar, int i4) {
        if (this.f44071a != null) {
            p0.a((Runnable) new j(eVar, downloadConfirmListener, cVar, i4));
        }
    }

    @Override // com.qq.e.comm.plugin.i.d0.b
    public com.qq.e.comm.plugin.apkmanager.w.a a() {
        return this.f44071a.a();
    }
}
