package com.qq.e.comm.plugin.nativeadunified.p;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.plugin.gdtnativead.p.a;
import com.qq.e.comm.plugin.gdtnativead.p.b.h;
import com.qq.e.comm.plugin.nativeadunified.g;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.n2;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a implements com.qq.e.comm.plugin.nativeadunified.p.b {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f44992a;

    /* renamed from: b  reason: collision with root package name */
    protected com.qq.e.comm.plugin.o0.h.f f44993b;

    /* renamed from: c  reason: collision with root package name */
    protected com.qq.e.comm.plugin.gdtnativead.p.a f44994c;

    /* renamed from: d  reason: collision with root package name */
    protected MediaView f44995d;

    /* renamed from: e  reason: collision with root package name */
    protected g f44996e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f44997f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f44998g;

    /* renamed from: h  reason: collision with root package name */
    private final com.qq.e.comm.plugin.r0.b f44999h;

    /* renamed from: i  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.nativeadunified.e f45000i;

    /* renamed from: j  reason: collision with root package name */
    protected final View.OnTouchListener f45001j;

    /* renamed from: k  reason: collision with root package name */
    private final a.d f45002k;

    /* renamed from: l  reason: collision with root package name */
    private final f.p f45003l;

    /* renamed from: m  reason: collision with root package name */
    protected com.qq.e.comm.plugin.gdtnativead.p.b.g f45004m;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.nativeadunified.p.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0860a implements h.a {
        C0860a() {
        }

        @Override // com.qq.e.comm.plugin.gdtnativead.p.b.h.a
        public void a() {
            a.this.f45000i.a();
        }

        @Override // com.qq.e.comm.plugin.gdtnativead.p.b.h.a
        public void a(View view, String str) {
            a.this.f45000i.a(str);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements View.OnLayoutChangeListener {

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.nativeadunified.p.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class RunnableC0861a implements Runnable {
            RunnableC0861a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams;
                com.qq.e.comm.plugin.gdtnativead.p.b.g gVar = a.this.f45004m;
                if (gVar == null || gVar.a() == null || (layoutParams = a.this.f45004m.a().getLayoutParams()) == null) {
                    return;
                }
                if (layoutParams.width == a.this.f44995d.getWidth() && layoutParams.height == a.this.f44993b.getHeight()) {
                    return;
                }
                layoutParams.width = a.this.f44995d.getWidth();
                layoutParams.height = a.this.f44995d.getHeight();
                a.this.f45004m.a().setLayoutParams(layoutParams);
            }
        }

        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            MediaView mediaView = a.this.f44995d;
            if (mediaView != null) {
                mediaView.post(new RunnableC0861a());
            }
        }
    }

    public a(Context context, g gVar, VideoOption videoOption, a.d dVar, f.p pVar, com.qq.e.comm.plugin.nativeadunified.e eVar, View.OnTouchListener onTouchListener, MediaView mediaView) {
        this.f44997f = true;
        this.f44998g = true;
        this.f44992a = context;
        this.f44996e = gVar;
        this.f45002k = dVar;
        this.f45003l = pVar;
        this.f45000i = eVar;
        this.f45001j = onTouchListener;
        this.f44995d = mediaView;
        if (videoOption != null) {
            this.f44998g = videoOption.isNeedCoverImage();
            this.f44997f = videoOption.isNeedProgressBar();
        }
        this.f44999h = new com.qq.e.comm.plugin.r0.b(this.f44995d.getContext());
    }

    public abstract void a(View view, FrameLayout.LayoutParams layoutParams);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.qq.e.comm.plugin.o0.h.f fVar) {
        fVar.a(this.f44996e);
        fVar.a(true);
        fVar.setFitsSystemWindows(true);
        fVar.setLayoutParams(l());
        fVar.b(this.f44996e.R0(), this.f44996e.N0());
        fVar.a(this.f44996e.o0(), this.f44996e.n0());
        fVar.a(this.f45003l);
        fVar.a(this.f44994c);
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public com.qq.e.comm.plugin.o0.h.f b() {
        return this.f44993b;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void c() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f44993b;
        if (fVar != null) {
            fVar.c();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void d() {
        com.qq.e.comm.plugin.gdtnativead.p.b.g gVar = this.f45004m;
        if (gVar != null) {
            gVar.b();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void destroy() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f44993b;
        if (fVar != null) {
            fVar.i();
        }
        com.qq.e.comm.plugin.gdtnativead.p.a aVar = this.f44994c;
        if (aVar != null) {
            aVar.i();
            this.f44994c.removeAllViews();
        }
        com.qq.e.comm.plugin.gdtnativead.p.b.g gVar = this.f45004m;
        if (gVar != null) {
            gVar.destroy();
            this.f45004m = null;
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void e() {
        this.f44999h.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f1.a(this.f44995d.getContext().getApplicationContext(), 46), f1.a(this.f44995d.getContext().getApplicationContext(), 46));
        layoutParams.gravity = 17;
        n2.a(this.f44999h);
        a(this.f44999h, layoutParams);
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public String f() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f44993b;
        if (fVar != null) {
            return fVar.k();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void g() {
        com.qq.e.comm.plugin.gdtnativead.p.a aVar = this.f44994c;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public int getCurrentPosition() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f44993b;
        if (fVar != null) {
            return fVar.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public int getDuration() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f44993b;
        if (fVar != null) {
            return fVar.getDuration();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void h() {
        com.qq.e.comm.plugin.gdtnativead.p.a aVar = this.f44994c;
        if (aVar != null) {
            aVar.a(0, true);
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void i() {
        com.qq.e.comm.plugin.r0.b bVar = this.f44999h;
        if (bVar != null) {
            bVar.setVisibility(8);
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public boolean isPlaying() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f44993b;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void k() {
        com.qq.e.comm.plugin.gdtnativead.p.b.g gVar = this.f45004m;
        if (gVar != null) {
            gVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameLayout.LayoutParams l() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public abstract boolean m();

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        ViewGroup viewGroup;
        if (m() || TextUtils.isEmpty(this.f44996e.e())) {
            return;
        }
        com.qq.e.comm.plugin.gdtnativead.p.b.g gVar = this.f45004m;
        if (gVar == null) {
            h hVar = new h(this.f44992a, this.f44996e);
            this.f45004m = hVar;
            hVar.a(new C0860a());
            this.f44995d.addOnLayoutChangeListener(new b());
        } else {
            View a4 = gVar.a();
            if (a4 != null && (viewGroup = (ViewGroup) a4.getParent()) != null) {
                viewGroup.removeView(a4);
            }
        }
        MediaView mediaView = this.f44995d;
        if (mediaView != null) {
            mediaView.addView(this.f45004m.a(), l());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.gdtnativead.p.a o() {
        com.qq.e.comm.plugin.gdtnativead.p.a aVar = new com.qq.e.comm.plugin.gdtnativead.p.a(this.f44992a, 1, this.f44996e.X(), this.f44997f, this.f44998g);
        aVar.b(false);
        aVar.a(com.qq.e.comm.plugin.n0.c.a(this.f44996e));
        aVar.a(true);
        aVar.a(this.f45002k);
        return aVar;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void pause() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f44993b;
        if (fVar != null) {
            fVar.pause();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void play() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f44993b;
        if (fVar != null) {
            fVar.play();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void stop() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f44993b;
        if (fVar != null) {
            fVar.a(true, true);
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void a() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f44993b;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void a(String str) {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f44993b;
        if (fVar != null) {
            fVar.a(str);
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void a(boolean z3) {
        com.qq.e.comm.plugin.gdtnativead.p.a aVar = this.f44994c;
        if (aVar != null) {
            if (z3) {
                aVar.show();
            } else {
                aVar.a(0L);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void a(int i4) {
        com.qq.e.comm.plugin.r0.b bVar = this.f44999h;
        if (bVar != null) {
            bVar.a(i4);
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void a(MediaView mediaView) {
        this.f44995d = mediaView;
    }
}
