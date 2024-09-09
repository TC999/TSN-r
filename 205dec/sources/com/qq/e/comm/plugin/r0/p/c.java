package com.qq.e.comm.plugin.r0.p;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.h.e;
import com.qq.e.comm.plugin.h.f;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.rewardvideo.q;
import com.qq.e.comm.plugin.util.c2;
import com.qq.e.comm.plugin.util.d1;
import yaq.pro;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements com.qq.e.comm.plugin.r0.p.a, c2.b, f {

    /* renamed from: i  reason: collision with root package name */
    private static final String f45837i = "c";

    /* renamed from: c  reason: collision with root package name */
    private final e f45838c = new e();

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.r0.p.b f45839d;

    /* renamed from: e  reason: collision with root package name */
    private final c2.c f45840e;

    /* renamed from: f  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f45841f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45842g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f45843h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.i.f> {
        a(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.i.f fVar) {
            c.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends com.qq.e.comm.plugin.h.d<Void> {
        b(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r12) {
            c.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.r0.p.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0886c extends com.qq.e.comm.plugin.h.d<Void> {
        C0886c(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r12) {
            c.this.d();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.isDestroyed()) {
                d1.a(c.f45837i, "\u5176\u4ed6\u573a\u666f\u89e6\u53d1\u4e86\u70b9\u51fb\uff0c\u8fd9\u91cc\u53d6\u6d88\u81ea\u52a8\u70b9\u51fb");
                return;
            }
            c cVar = c.this;
            cVar.a(cVar.f45841f.l0());
        }
    }

    public c(com.qq.e.comm.plugin.r0.p.b bVar) {
        this.f45839d = bVar;
        c2.c cVar = new c2.c(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 500L);
        this.f45840e = cVar;
        cVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f45843h) {
            return;
        }
        this.f45843h = true;
        this.f45840e.h();
        this.f45839d.destroy();
        d1.a(f45837i, "destroy");
    }

    private String e() {
        com.qq.e.comm.plugin.g0.b q3;
        com.qq.e.comm.plugin.g0.e eVar = this.f45841f;
        return (eVar == null || (q3 = eVar.q()) == null) ? "\u5e94\u7528" : q3.a();
    }

    @Override // com.qq.e.comm.plugin.util.c2.b
    public void b() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, 0, this);
    }

    @Override // com.qq.e.comm.plugin.h.f
    public e g() {
        return this.f45838c;
    }

    @Override // com.qq.e.comm.plugin.h.f
    public boolean isDestroyed() {
        return this.f45843h;
    }

    private void b(com.qq.e.comm.plugin.g0.e eVar) {
        FSCallback fSCallback = (FSCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), FSCallback.class);
        if (fSCallback == null) {
            return;
        }
        fSCallback.w().a(new a(this));
        fSCallback.i().a(new b(this));
        fSCallback.r().a(new C0886c(this));
    }

    @Override // com.qq.e.comm.plugin.r0.p.a
    public void a(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f45841f = eVar;
        long M0 = eVar.M0() * 1000;
        long a4 = (q.a(this.f45841f) * 1000) + ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        com.qq.e.comm.plugin.g0.b q3 = this.f45841f.q();
        if (M0 >= a4 && q3 != null) {
            if (com.qq.e.comm.plugin.apkmanager.w.d.e(q3.j())) {
                d1.a(f45837i, "\u5f53\u524d\u5e94\u7528\u6b63\u5728\u4e0b\u8f7d\u4e2d\uff0c\u4e0d\u9700\u8981\u81ea\u52a8\u70b9\u51fb\u7684\u903b\u8f91");
                d();
                return;
            }
            this.f45839d.a();
            this.f45839d.a(b(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT));
            b(this.f45841f);
            return;
        }
        d1.a(f45837i, "\u89c6\u9891\u65f6\u957f\u5c0f\u4e8e %s \u79d2\uff0c\u6216\u4e0d\u662f\u5e94\u7528\u7c7b\u5e7f\u544a\uff0c\u4e0d\u5c55\u793a\u81ea\u52a8\u6253\u5f00\u63d0\u793a", Long.valueOf(a4 / 1000));
        d();
    }

    private String b(long j4) {
        String str;
        com.qq.e.comm.plugin.g0.b q3;
        com.qq.e.comm.plugin.g0.e eVar = this.f45841f;
        if (eVar != null && (q3 = eVar.q()) != null) {
            if (com.qq.e.comm.plugin.apkmanager.w.d.f(q3.j())) {
                str = "\u6253\u5f00";
            } else if (com.qq.e.comm.plugin.apkmanager.w.d.d(q3.j())) {
                str = "\u5b89\u88c5";
            }
            return String.format("%s \u79d2\u540e\u4e3a\u60a8%s\u201c%s\u201d", Long.valueOf((j4 + 999) / 1000), str, e());
        }
        str = "\u4e0b\u8f7d";
        return String.format("%s \u79d2\u540e\u4e3a\u60a8%s\u201c%s\u201d", Long.valueOf((j4 + 999) / 1000), str, e());
    }

    @Override // com.qq.e.comm.plugin.r0.p.a
    public void a(boolean z3) {
        if (isDestroyed()) {
            return;
        }
        if (z3) {
            if (this.f45842g) {
                this.f45840e.f();
                d1.a(f45837i, "restartTick");
            } else {
                this.f45840e.g();
                d1.a(f45837i, "startTick");
            }
            this.f45842g = false;
            return;
        }
        this.f45840e.e();
        this.f45842g = true;
        d1.a(f45837i, "pauseTick");
    }

    @Override // com.qq.e.comm.plugin.r0.p.a
    public void a() {
        d();
        v.a(1100930, com.qq.e.comm.plugin.n0.c.a(this.f45841f));
    }

    @Override // com.qq.e.comm.plugin.util.c2.b
    public void a(long j4) {
        this.f45839d.a(b(j4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        d1.a(f45837i, "autoClick");
        com.qq.e.comm.plugin.i.f fVar = new com.qq.e.comm.plugin.i.f(this.f45841f);
        fVar.f44110g = 8;
        ((FSCallback) com.qq.e.comm.plugin.h.a.b(str, FSCallback.class)).w().b(fVar);
        d();
    }
}
