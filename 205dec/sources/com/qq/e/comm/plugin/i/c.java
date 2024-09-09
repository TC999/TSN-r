package com.qq.e.comm.plugin.i;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c implements o, com.qq.e.comm.plugin.i.d0.c {

    /* renamed from: a  reason: collision with root package name */
    private h f44057a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.b f44058b;

    /* renamed from: c  reason: collision with root package name */
    private String f44059c;

    /* renamed from: d  reason: collision with root package name */
    private int f44060d;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.i.d0.b f44061e;

    /* renamed from: f  reason: collision with root package name */
    private int f44062f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f44063g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f44064h;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b a4 = c.a(c.this);
            if (c.b(c.this).a().f43572a != 200) {
                if (c.c(c.this) != null) {
                    c.c(c.this).b();
                }
                com.qq.e.comm.plugin.n0.v.a(1100702, c.b(c.this).f44153z, 6);
                return;
            }
            ApkDownloadTask a5 = c.a(c.this, a4);
            if (c.c(c.this) != null) {
                c.c(c.this).a(c.a(c.this, a5.p(), Integer.valueOf(c.d(c.this))));
            }
            com.qq.e.comm.plugin.apkmanager.k.e().c(a5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f44066a;

        /* renamed from: b  reason: collision with root package name */
        private final String f44067b;

        public b(String str, String str2) {
            this.f44066a = str;
            this.f44067b = str2;
        }
    }

    c() {
    }

    private ApkDownloadTask a(b bVar) {
        return (ApkDownloadTask) pro.getobjresult(415, 0, this, bVar);
    }

    static /* synthetic */ ApkDownloadTask a(c cVar, b bVar) {
        return (ApkDownloadTask) pro.getobjresult(416, 1, cVar, bVar);
    }

    static /* synthetic */ com.qq.e.comm.plugin.g0.b a(c cVar, String str, Integer num) {
        return (com.qq.e.comm.plugin.g0.b) pro.getobjresult(417, 1, cVar, str, num);
    }

    private com.qq.e.comm.plugin.g0.b a(String str, Integer num) {
        return (com.qq.e.comm.plugin.g0.b) pro.getobjresult(418, 0, this, str, num);
    }

    static /* synthetic */ b a(c cVar) {
        return (b) pro.getobjresult(419, 1, cVar);
    }

    private void a() {
        pro.getVresult(420, 0, this);
    }

    private boolean a(int i4) {
        return pro.getZresult(421, 0, this, Integer.valueOf(i4));
    }

    private boolean a(String str) {
        return pro.getZresult(422, 0, this, str);
    }

    static /* synthetic */ h b(c cVar) {
        return (h) pro.getobjresult(423, 1, cVar);
    }

    private void b() {
        pro.getVresult(424, 0, this);
    }

    private boolean b(int i4) {
        return pro.getZresult(425, 0, this, Integer.valueOf(i4));
    }

    private boolean b(String str) {
        return pro.getZresult(426, 0, this, str);
    }

    private b c() {
        return (b) pro.getobjresult(427, 0, this);
    }

    static /* synthetic */ com.qq.e.comm.plugin.i.d0.b c(c cVar) {
        return (com.qq.e.comm.plugin.i.d0.b) pro.getobjresult(428, 1, cVar);
    }

    static /* synthetic */ int d(c cVar) {
        return pro.getIresult(429, 1, cVar);
    }

    private b d() {
        return (b) pro.getobjresult(430, 0, this);
    }

    private void e() {
        pro.getVresult(431, 0, this);
    }

    @Override // com.qq.e.comm.plugin.i.d0.c
    public void a(boolean z3) {
        pro.getVresult(432, 0, this, Boolean.valueOf(z3));
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar) {
        return pro.getZresult(433, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(434, 0, this, hVar, bVar);
    }

    @Override // com.qq.e.comm.plugin.i.d0.c
    public void b(boolean z3) {
        pro.getVresult(435, 0, this, Boolean.valueOf(z3));
    }

    @Override // com.qq.e.comm.plugin.i.d0.c
    public void onCancel() {
        pro.getVresult(436, 0, this);
    }

    @Override // com.qq.e.comm.plugin.i.d0.c
    public boolean onConfirm() {
        return pro.getZresult(437, 0, this);
    }
}
