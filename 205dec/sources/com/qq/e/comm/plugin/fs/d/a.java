package com.qq.e.comm.plugin.fs.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Pair;
import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.fs.f.e.b;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.r0.i;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.l1;
import com.qq.e.comm.plugin.util.p0;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends com.qq.e.comm.plugin.fs.d.b {
    public int A;

    /* renamed from: w  reason: collision with root package name */
    protected com.qq.e.comm.plugin.fs.f.e.b f43186w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f43187x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f43188y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f43189z;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.fs.d.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0819a extends com.qq.e.comm.plugin.h.d<Pair<Integer, Long>> {
        C0819a(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Pair<Integer, Long> pair) {
            if (pair == null) {
                return;
            }
            Integer num = (Integer) pair.first;
            if (num.intValue() != a.this.f43211c.i0().p()) {
                v.a(1403021, a.this.f43212d, 2, num, null);
            } else if (num == null) {
            } else {
                a aVar = a.this;
                aVar.f43229u = true;
                com.qq.e.comm.plugin.h.c<com.qq.e.comm.plugin.rewardvideo.m> I = aVar.h().I();
                Object obj = pair.second;
                I.b(new com.qq.e.comm.plugin.rewardvideo.m(obj == null ? -1L : ((Long) obj).longValue(), com.qq.e.comm.plugin.fs.e.d.b(), a.this.f43214f.h(), -1, a.this.f43226r, 2));
                com.qq.e.comm.plugin.fs.f.c.d w3 = a.this.w();
                if (w3 != null) {
                    w3.onReward(num.intValue());
                }
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b extends com.qq.e.comm.plugin.h.d<Void> {
        b(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            a aVar = a.this;
            com.qq.e.comm.plugin.fs.e.a.a(aVar.f43211c, aVar.w(), a.this.f43214f.i(), 0);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.adview.video.a> {
        c(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.adview.video.a aVar) {
            a.this.f43189z = true;
            a aVar2 = a.this;
            com.qq.e.comm.plugin.fs.e.a.a(aVar2.f43211c, aVar2.w(), a.this.f43214f.i(), 2);
            a.this.a(false);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d extends com.qq.e.comm.plugin.h.d<Void> {
        d(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r22) {
            a.this.a(true);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class e extends com.qq.e.comm.plugin.h.d<Void> {
        e(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r4) {
            a aVar = a.this;
            com.qq.e.comm.plugin.fs.e.a.a(aVar.f43211c, aVar.w(), a.this.f43214f.i(), 0);
            a.this.a(true);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f extends com.qq.e.comm.plugin.h.d<Void> {
        f(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r22) {
            a.this.A = 3;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class g extends com.qq.e.comm.plugin.h.d<Void> {
        g(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r12) {
            a.this.x();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class h extends com.qq.e.comm.plugin.h.d<Integer> {
        h(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Integer num) {
            a.this.f43188y = true;
            a.this.o();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class i extends com.qq.e.comm.plugin.h.d<Integer> {
        i(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Integer num) {
            a.this.f43188y = false;
            a.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class j implements i.f {
        j() {
        }

        @Override // com.qq.e.comm.plugin.r0.i.f
        public void onComplainSuccess() {
            a.this.h().onComplainSuccess().a();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f43215g.removeView(aVar.f43216h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class l implements DialogInterface.OnDismissListener {
        l() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.v().onDismiss().b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class m {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f43202a;

        static {
            int[] iArr = new int[LifecycleCallback.a.values().length];
            f43202a = iArr;
            try {
                iArr[LifecycleCallback.a.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43202a[LifecycleCallback.a.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.e.a a4 = com.qq.e.comm.plugin.e.a.a();
            a aVar = a.this;
            a4.a(aVar.f43215g, aVar.f43211c);
            a.this.h().E().a();
            a aVar2 = a.this;
            com.qq.e.comm.plugin.fs.e.a.a(aVar2.f43211c, aVar2.f43215g, 3);
            a aVar3 = a.this;
            l1.a(aVar3.f43215g, aVar3.f43211c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class o implements b.c {
        o() {
        }

        @Override // com.qq.e.comm.plugin.fs.f.e.b.c
        public void a() {
            a.this.v().onDismiss().b(2);
        }

        @Override // com.qq.e.comm.plugin.fs.f.e.b.c
        public void b() {
            a.this.h().B().a();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class p extends com.qq.e.comm.plugin.h.d<LifecycleCallback.a> {
        p(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(LifecycleCallback.a aVar) {
            if (aVar == null) {
                return;
            }
            int i4 = m.f43202a[aVar.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.A == 1) {
                    aVar2.o();
                }
            } else if (a.this.A()) {
            } else {
                a aVar3 = a.this;
                if (aVar3.A != 4) {
                    aVar3.p();
                }
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class q extends com.qq.e.comm.plugin.h.d<Void> {
        q(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r12) {
            a.this.C();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class r extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.i.f> {
        r(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.i.f fVar) {
            int f4 = a.this.f();
            com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(a.this.f43215g);
            if (d4 != null) {
                d4.b(fVar.f44106c);
                d4.a(fVar.f44109f);
                d4.d(fVar.f44110g);
                int i4 = fVar.f44110g;
                if (2 == i4) {
                    d4.a(fVar.f44111h);
                } else if (5 == i4) {
                    d4.a(fVar.f44112i, fVar.f44113j);
                }
                d4.a(fVar.b());
                d4.a(fVar.f44117n);
                d4.a(fVar.f44118o);
                d4.b(fVar.f44119p);
                d4.c(f4);
            }
            fVar.f44105b = com.qq.e.comm.plugin.e.a.a().a(a.this.f43215g);
            fVar.f44120q = f4;
            a.this.b(fVar);
            a.this.f43230v = true;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class s extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.i.f> {
        s(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.i.f fVar) {
            com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(a.this.f43215g);
            if (d4 != null) {
                d4.b(fVar.f44106c);
                d4.a(fVar.f44109f);
                d4.d(fVar.f44110g);
                d4.a(fVar.b());
                d4.a(fVar.f44117n);
                d4.a(fVar.f44118o);
                d4.b(fVar.f44119p);
            }
            fVar.f44105b = com.qq.e.comm.plugin.e.a.a().a(a.this.f43215g);
            a.this.b(fVar);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class t extends com.qq.e.comm.plugin.h.d<Void> {
        t(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r22) {
            if (a.this.f43187x) {
                d1.a("NativeFSPresenter", "DemoGame error");
            } else {
                a.this.f43217i.e();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class u extends com.qq.e.comm.plugin.h.d<Long> {
        u(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Long l4) {
            a aVar = a.this;
            if (!aVar.f43221m || l4 == null) {
                return;
            }
            aVar.f43228t = System.currentTimeMillis();
            com.qq.e.comm.plugin.rewardvideo.f fVar = com.qq.e.comm.plugin.rewardvideo.f.MEDIA;
            a aVar2 = a.this;
            com.qq.e.comm.plugin.g0.e eVar = aVar2.f43211c;
            com.qq.e.comm.plugin.o0.h.f fVar2 = aVar2.f43219k;
            long duration = fVar2 == null ? -1L : fVar2.getDuration();
            long longValue = l4.longValue();
            int b4 = com.qq.e.comm.plugin.fs.e.d.b();
            com.qq.e.comm.plugin.o0.h.f fVar3 = a.this.f43219k;
            com.qq.e.comm.plugin.rewardvideo.n.b(fVar, eVar, duration, longValue, b4, fVar3 == null ? null : fVar3.getVideoState(), false, false);
            a.this.h().I().b(new com.qq.e.comm.plugin.rewardvideo.m(l4.longValue(), com.qq.e.comm.plugin.fs.e.d.b(), a.this.f43214f.h(), -1, a.this.f43226r, 1));
            com.qq.e.comm.plugin.fs.f.c.d w3 = a.this.w();
            if (w3 != null) {
                w3.onReward(1);
            }
            a aVar3 = a.this;
            aVar3.f43221m = false;
            com.qq.e.comm.plugin.rewardvideo.f fVar4 = com.qq.e.comm.plugin.rewardvideo.f.MEDIA;
            com.qq.e.comm.plugin.g0.e eVar2 = aVar3.f43211c;
            com.qq.e.comm.plugin.o0.h.f fVar5 = aVar3.f43219k;
            long duration2 = fVar5 != null ? fVar5.getDuration() : -1L;
            long longValue2 = l4.longValue();
            int b5 = com.qq.e.comm.plugin.fs.e.d.b();
            com.qq.e.comm.plugin.o0.h.f fVar6 = a.this.f43219k;
            com.qq.e.comm.plugin.rewardvideo.n.a(fVar4, eVar2, duration2, longValue2, b5, fVar6 != null ? fVar6.getVideoState() : null, false, false);
            com.qq.e.comm.plugin.fs.e.f.a().g(a.this.f43211c);
        }
    }

    public a(Activity activity, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.fs.d.d.a aVar) {
        super(activity, eVar, aVar);
        this.f43188y = false;
        this.f43189z = false;
        if (eVar.l1()) {
            this.A = 1;
        } else {
            this.A = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        return this.f43188y;
    }

    private boolean B() {
        com.qq.e.comm.plugin.g0.e eVar;
        return (this.f43216h == null || (eVar = this.f43211c) == null || eVar.i0() == null || !this.f43211c.i0().w()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.f43214f.j()) {
            t();
        } else {
            u();
        }
        com.qq.e.comm.plugin.fs.f.d.c cVar = this.f43220l;
        if (cVar != null) {
            cVar.b();
        }
    }

    private void r() {
        p();
        com.qq.e.comm.plugin.fs.f.e.d.f fVar = this.f43217i;
        if (fVar != null) {
            fVar.c();
        }
        com.qq.e.comm.plugin.g0.e eVar = this.f43211c;
        if (eVar != null) {
            if (eVar.l1()) {
                this.A = 1;
            } else {
                this.A = 2;
            }
        }
    }

    private boolean s() {
        com.qq.e.comm.plugin.fs.f.a aVar = this.f43216h;
        return (aVar == null || aVar.a() == null || !this.f43216h.a().m()) ? false : true;
    }

    private void t() {
        this.f43211c.a(System.currentTimeMillis());
        if (this.f43221m && !this.f43189z) {
            o();
            if (this.f43214f.m()) {
                h().B().a();
                return;
            }
            int a4 = (int) com.qq.e.comm.plugin.fs.e.b.a(this.f43211c.M0() * 1000, this.f43214f);
            int b4 = com.qq.e.comm.plugin.fs.e.d.b();
            a((!this.f43211c.l1() || ((long) b4) + 1000 < ((long) a4)) ? String.format(Locale.getDefault(), "\u89c2\u770b\u6ee1 %d \u79d2\u5373\u53ef\u83b7\u5f97\u5956\u52b1\n\u786e\u8ba4\u8981\u79bb\u5f00\u5417\uff1f", Integer.valueOf(b4 / 1000)) : "\u5b8c\u6574\u89c2\u770b\u5373\u53ef\u83b7\u5f97\u5956\u52b1\n\u786e\u8ba4\u8981\u79bb\u5f00\u5417\uff1f", "\u6293\u4f4f\u5956\u52b1\u673a\u4f1a", "\u653e\u5f03\u5956\u52b1\u79bb\u5f00");
            return;
        }
        com.qq.e.comm.plugin.fs.f.e.b bVar = this.f43186w;
        if (bVar != null && bVar.isShowing()) {
            this.f43186w.cancel();
        }
        if (B()) {
            o();
            h().J().a();
        } else if (this.f43214f.o()) {
            o();
            h().B().a();
        } else {
            y();
        }
    }

    private void u() {
        if (this.f43214f.n()) {
            h().B().a();
        } else {
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.qq.e.comm.plugin.r0.i iVar = new com.qq.e.comm.plugin.r0.i(this.f43213e, this.f43211c);
        iVar.a(new j());
        iVar.a(new l());
        v().d().b(1);
        iVar.i();
    }

    private void y() {
        if (z()) {
            if (s()) {
                h().v().a();
                return;
            }
            o();
            h().r().a();
        } else if (this.f43217i != null) {
            o();
            this.f43217i.show();
        } else {
            o();
            h().B().a();
        }
    }

    private boolean z() {
        com.qq.e.comm.plugin.fs.f.a aVar = this.f43216h;
        return (aVar == null || aVar.a() == null || !this.f43216h.a().o()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.fs.d.b
    public void j() {
        if (B() || z()) {
            return;
        }
        this.f43214f.a(this.f43213e);
        super.j();
    }

    @Override // com.qq.e.comm.plugin.fs.d.b
    public void l() {
        d1.a("NativeFSPresenter", "onADExposure");
        this.f43215g.post(new n());
        this.f43214f.r();
    }

    @Override // com.qq.e.comm.plugin.fs.d.b
    public void m() {
        if (!com.qq.e.comm.plugin.fs.e.a.a(this.f43211c)) {
            d1.a("NativeFSPresenter", "onBackPressed enable = false");
            return;
        }
        int i4 = this.A;
        if (i4 == 3) {
            a();
        } else if (i4 == 4) {
            r();
        } else {
            com.qq.e.comm.plugin.o0.h.f fVar = this.f43219k;
            if (fVar == null || ((long) fVar.getCurrentPosition()) >= this.f43214f.f()) {
                o();
                if (this.f43214f.p()) {
                    C();
                }
            }
        }
    }

    @Override // com.qq.e.comm.plugin.fs.d.b
    public void n() {
        super.n();
        com.qq.e.comm.plugin.g0.e eVar = this.f43211c;
        if (eVar != null) {
            eVar.e(System.currentTimeMillis());
            com.qq.e.comm.plugin.fs.e.e.c(this.f43211c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.fs.d.b
    public void p() {
        if (this.A == 3) {
            return;
        }
        super.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.fs.d.b
    public void q() {
        super.q();
        this.f43223o.a(this.f43211c);
        ((LifecycleCallback) com.qq.e.comm.plugin.h.a.b(this.f43214f.g(), LifecycleCallback.class)).l().a(new p(this));
        h().i().a(new q(this));
        h().w().a(new r(this));
        h().p().a(new s(this));
        h().k().a(new t(this));
        h().j().a(new u(this));
        h().x().a(new C0819a(this));
        i().onPause().a(new b(this));
        i().m().a(new c(this));
        i().onStop().a(new d(this));
        i().onComplete().a(new e(this));
        h().r().a(new f(this));
        h().s().a(new g(this));
        v().d().a(new h(this));
        v().onDismiss().a(new i(this));
    }

    protected DialogStateCallback v() {
        return (DialogStateCallback) com.qq.e.comm.plugin.h.a.b(this.f43214f.g(), DialogStateCallback.class);
    }

    com.qq.e.comm.plugin.fs.f.c.d w() {
        com.qq.e.comm.plugin.c.c cVar = this.f43218j;
        if (cVar instanceof com.qq.e.comm.plugin.fs.f.c.d) {
            return (com.qq.e.comm.plugin.fs.f.c.d) cVar;
        }
        d1.b("NativeFSPresenter", "mVideoAdView must be IFSNativeVideoAdView");
        return null;
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.a
    public void d() {
        d1.a("NativeFSPresenter", "onEndCardShow");
        if (this.A == 4) {
            return;
        }
        if (!this.f43222n) {
            p0.a((Runnable) new k());
        }
        h().f().a();
        com.qq.e.comm.plugin.fs.f.d.c cVar = this.f43220l;
        if (cVar != null) {
            cVar.a();
        }
        this.A = 3;
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.a
    public void b() {
        this.f43187x = true;
        h().b().b(Boolean.TRUE);
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.a
    public void c() {
        if (this.f43222n) {
            return;
        }
        o();
        this.A = 4;
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.a
    public void a() {
        if (this.A == 4) {
            r();
            return;
        }
        com.qq.e.comm.plugin.fs.e.e.a(this.f43211c, true);
        h().B().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.qq.e.comm.plugin.i.f fVar) {
        this.f43214f.q();
        d1.a("NativeFSPresenter", "onADClick, clickArea : " + fVar.f44109f);
        com.qq.e.comm.plugin.fs.e.a.a(this.f43223o, fVar, B(), this.f43215g);
        if (this.A == 1 && fVar.a() != null) {
            com.qq.e.comm.plugin.fs.e.a.a(fVar.a(), w(), this.f43214f.i(), 3);
        }
        h().y().a();
    }

    @Override // com.qq.e.comm.plugin.fs.d.b, com.qq.e.comm.plugin.fs.f.e.d.a
    public void a(com.qq.e.comm.plugin.i.f fVar, boolean z3) {
        super.a(fVar, z3);
        com.qq.e.comm.plugin.g0.e a4 = fVar.a();
        if (a4 == null) {
            return;
        }
        com.qq.e.comm.plugin.fs.e.e.a(a4, false);
    }

    private void a(String str, String str2, String str3) {
        if (this.A == 3) {
            return;
        }
        if (this.f43186w == null) {
            this.f43186w = new com.qq.e.comm.plugin.fs.f.e.b(this.f43213e);
        }
        this.f43186w.a(this.f43213e, this.f43211c, this.f43214f, str, str2, str3, new o());
        v().d().b(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z3) {
        if (z3 && this.f43214f.a()) {
            h().B().a();
        } else if (z()) {
            h().r().a();
        }
    }
}
