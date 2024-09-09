package com.qq.e.comm.plugin.u.k;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.plugin.dl.h0;
import com.qq.e.comm.plugin.dl.s;
import com.qq.e.comm.plugin.gdtnativead.p.a;
import com.qq.e.comm.plugin.gdtnativead.p.b.g;
import com.qq.e.comm.plugin.gdtnativead.p.b.h;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.plugin.util.p0;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements a.d, a.f, h.a {

    /* renamed from: h  reason: collision with root package name */
    private final s f46343h;

    /* renamed from: i  reason: collision with root package name */
    private final f f46344i;

    /* renamed from: j  reason: collision with root package name */
    private final com.qq.e.comm.plugin.gdtnativead.p.a f46345j;

    /* renamed from: k  reason: collision with root package name */
    private final FrameLayout f46346k;

    /* renamed from: l  reason: collision with root package name */
    private final g f46347l;

    /* renamed from: m  reason: collision with root package name */
    private int f46348m;

    /* renamed from: n  reason: collision with root package name */
    private final com.qq.e.comm.plugin.u.g f46349n;

    /* renamed from: o  reason: collision with root package name */
    private final VideoOption f46350o;

    /* renamed from: p  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f46351p;

    /* renamed from: q  reason: collision with root package name */
    private com.qq.e.comm.plugin.u.k.a f46352q;

    /* renamed from: s  reason: collision with root package name */
    private volatile String f46354s;

    /* renamed from: u  reason: collision with root package name */
    private final com.qq.e.comm.plugin.r0.a f46356u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f46357v;

    /* renamed from: c  reason: collision with root package name */
    private int f46338c = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f46339d = 1;

    /* renamed from: e  reason: collision with root package name */
    private int f46340e = 1;

    /* renamed from: f  reason: collision with root package name */
    private int f46341f = 1;

    /* renamed from: g  reason: collision with root package name */
    private com.qq.e.comm.plugin.nativeadunified.c f46342g = com.qq.e.comm.plugin.nativeadunified.c.INIT;

    /* renamed from: r  reason: collision with root package name */
    private final AtomicBoolean f46353r = new AtomicBoolean(false);

    /* renamed from: t  reason: collision with root package name */
    private int f46355t = 0;

    /* renamed from: w  reason: collision with root package name */
    private final j0 f46358w = new j0();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f46357v || !e.this.l()) {
                return;
            }
            e.this.f46357v = true;
            e.this.f46356u.setVisibility(0);
            e.this.f46356u.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f46356u.setVisibility(4);
            e.this.f46356u.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f46362a;

        static {
            int[] iArr = new int[com.qq.e.comm.plugin.nativeadunified.c.values().length];
            f46362a = iArr;
            try {
                iArr[com.qq.e.comm.plugin.nativeadunified.c.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46362a[com.qq.e.comm.plugin.nativeadunified.c.INIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46362a[com.qq.e.comm.plugin.nativeadunified.c.AUTO_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(s sVar, f fVar, com.qq.e.comm.plugin.gdtnativead.p.a aVar, FrameLayout frameLayout, g gVar, com.qq.e.comm.plugin.r0.a aVar2, VideoOption videoOption, com.qq.e.comm.plugin.g0.e eVar, boolean z3, com.qq.e.comm.plugin.u.g gVar2) {
        this.f46343h = sVar;
        this.f46344i = fVar;
        this.f46345j = aVar;
        this.f46346k = frameLayout;
        this.f46347l = gVar;
        this.f46356u = aVar2;
        this.f46349n = gVar2;
        this.f46350o = videoOption;
        this.f46351p = eVar;
        com.qq.e.comm.plugin.n0.c.a(eVar);
        this.f46345j.a(this);
        this.f46345j.c(!m());
        this.f46344i.a(new a(eVar, z3));
        g gVar3 = this.f46347l;
        if (gVar3 != null) {
            gVar3.a(this);
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        if (this.f46350o != null) {
            boolean z3 = com.qq.e.comm.plugin.d0.a.d().c().n() == com.qq.e.comm.plugin.d0.e.d.WIFI;
            int autoPlayPolicy = this.f46350o.getAutoPlayPolicy();
            return autoPlayPolicy != 0 ? autoPlayPolicy != 2 : z3;
        }
        return true;
    }

    private boolean m() {
        h0.b e4 = this.f46343h.e();
        return e4 != null && e4.f();
    }

    private void p() {
        if (m()) {
            a();
            return;
        }
        if (this.f46343h.o()) {
            this.f46343h.r();
        } else {
            g gVar = this.f46347l;
            if (gVar != null) {
                gVar.show();
            }
        }
        e(false);
    }

    private void q() {
        p0.a((Runnable) new b());
    }

    private void r() {
        VideoOption videoOption = this.f46350o;
        if (videoOption != null) {
            if (videoOption.getAutoPlayMuted()) {
                this.f46344i.c();
                return;
            } else {
                this.f46344i.a();
                return;
            }
        }
        this.f46344i.c();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.a.f
    public void a(long j4, long j5) {
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.a.d
    public void a(boolean z3) {
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f46341f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f46338c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f46340e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f46339d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f k() {
        return this.f46344i;
    }

    public void n() {
        q();
    }

    void o() {
        com.qq.e.comm.plugin.u.g gVar;
        this.f46353r.set(true);
        if (!TextUtils.isEmpty(this.f46354s)) {
            this.f46342g = com.qq.e.comm.plugin.nativeadunified.c.PLAYING;
            this.f46344i.play();
        } else if (!TextUtils.isEmpty(this.f46354s) || (gVar = this.f46349n) == null) {
        } else {
            gVar.a(1001, new int[0]);
        }
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoComplete() {
        this.f46342g = com.qq.e.comm.plugin.nativeadunified.c.END;
        this.f46355t = this.f46344i.getCurrentPosition();
        this.f46349n.a(206, new int[0]);
        p();
        this.f46339d = 3;
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoPause() {
        this.f46355t = this.f46344i.getCurrentPosition();
        this.f46349n.a(204, new int[0]);
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoReady() {
        this.f46340e = 0;
        int duration = this.f46344i.getDuration();
        this.f46348m = duration;
        this.f46349n.a(210, duration);
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoResume() {
        this.f46339d = 2;
        this.f46349n.a(203, new int[0]);
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoStart() {
        this.f46349n.a(202, new int[0]);
        if (this.f46347l != null && !this.f46343h.o()) {
            this.f46347l.b();
        }
        d();
        e(true);
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void onVideoStop() {
        this.f46355t = this.f46344i.getCurrentPosition();
        this.f46342g = com.qq.e.comm.plugin.nativeadunified.c.END;
        this.f46349n.a(205, new int[0]);
    }

    private void e(boolean z3) {
        if (this.f46351p.o() == com.qq.e.comm.plugin.b.g.NATIVEEXPRESSAD) {
            this.f46343h.a(z3);
        }
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.a.d
    public void b(boolean z3) {
        if (!z3) {
            this.f46341f = 0;
        }
        com.qq.e.comm.plugin.u.k.a aVar = this.f46352q;
        if (aVar != null) {
            aVar.a();
        }
        this.f46342g = z3 ? com.qq.e.comm.plugin.nativeadunified.c.MANUAL_PAUSE : com.qq.e.comm.plugin.nativeadunified.c.PLAYING;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z3) {
        int i4 = d.f46362a[this.f46342g.ordinal()];
        if (i4 == 1) {
            if (z3) {
                return;
            }
            d(false);
            return;
        }
        if (i4 != 2) {
            if (i4 != 3) {
                return;
            }
        } else if (!l()) {
            this.f46345j.a(0, true);
            return;
        }
        if (z3) {
            this.f46341f = 1;
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z3) {
        this.f46353r.set(false);
        this.f46342g = z3 ? com.qq.e.comm.plugin.nativeadunified.c.MANUAL_PAUSE : com.qq.e.comm.plugin.nativeadunified.c.AUTO_PAUSE;
        this.f46344i.pause();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f46348m;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f46340e = 2;
            d();
        } else if (TextUtils.isEmpty(this.f46354s)) {
            this.f46354s = str;
            this.f46340e = 0;
            this.f46344i.a(this.f46354s);
            if (this.f46353r.get()) {
                o();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends com.qq.e.comm.plugin.o0.h.d {
        a(com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
            super(eVar, z3);
        }

        @Override // com.qq.e.comm.plugin.o0.h.d, com.qq.e.comm.plugin.o0.h.f.p
        public void a(int i4, int i5) {
            super.a(i4, i5);
            e.this.f46349n.a(1008, i4, i5);
            e.this.f46358w.a("vdoP", ((i4 * 1.0f) / i5) * 100.0f);
            e.this.f46343h.a(e.this.f46358w.a());
        }

        @Override // com.qq.e.comm.plugin.o0.h.d, com.qq.e.comm.plugin.o0.h.f.p
        public boolean a(int i4, f.t tVar, float f4) {
            super.a(i4, tVar, f4);
            e.this.f46349n.a(1009, i4, tVar.a());
            return true;
        }
    }

    public int e() {
        if (this.f46342g == com.qq.e.comm.plugin.nativeadunified.c.PLAYING) {
            this.f46355t = this.f46344i.getCurrentPosition();
        }
        return this.f46355t;
    }

    private void d() {
        p0.a((Runnable) new c());
    }

    public void a(long j4, long j5, int i4) {
        q();
    }

    @Override // com.qq.e.comm.plugin.o0.h.b.a
    public void a(int i4, Exception exc) {
        this.f46340e = 2;
        this.f46342g = com.qq.e.comm.plugin.nativeadunified.c.ERROR;
        this.f46349n.a(207, new int[0]);
        d();
        p();
    }

    public void c() {
        g gVar = this.f46347l;
        if (gVar != null) {
            gVar.destroy();
        }
        this.f46344i.i();
    }

    public void a(com.qq.e.comm.plugin.u.k.a aVar) {
        this.f46352q = aVar;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.h.a
    public void a() {
        o();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.h.a
    public void a(View view, String str) {
        this.f46349n.a(str);
    }
}
