package com.qq.e.comm.plugin.nativeadunified.p;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.plugin.dl.i;
import com.qq.e.comm.plugin.dl.q;
import com.qq.e.comm.plugin.dl.r;
import com.qq.e.comm.plugin.dl.s;
import com.qq.e.comm.plugin.nativeadunified.g;
import com.qq.e.comm.plugin.util.n2;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    protected MediaView f45015a;

    /* renamed from: b  reason: collision with root package name */
    protected g f45016b;

    /* renamed from: c  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.nativeadunified.e f45017c;

    /* renamed from: d  reason: collision with root package name */
    private final s f45018d;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends r {
        a(q qVar, com.qq.e.comm.plugin.g0.e eVar) {
            super(qVar, eVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void a(com.qq.e.comm.plugin.i.f fVar, com.qq.e.dl.l.j.c cVar) {
            super.a(fVar, cVar);
            f.this.f45017c.a(fVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void k(com.qq.e.dl.l.j.c cVar) {
        }
    }

    public f(Context context, g gVar, com.qq.e.comm.plugin.nativeadunified.e eVar, MediaView mediaView) {
        this.f45016b = gVar;
        this.f45017c = eVar;
        this.f45015a = mediaView;
        this.f45018d = i.a().a(context, gVar);
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void a(int i4) {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void a(MediaView mediaView) {
        ImageView imageView;
        this.f45015a = mediaView;
        s sVar = this.f45018d;
        if (sVar == null) {
            ImageView imageView2 = new ImageView(mediaView.getContext());
            com.qq.e.comm.plugin.b0.b.a().a(this.f45016b.X(), imageView2);
            imageView = imageView2;
        } else {
            View j4 = sVar.j();
            n2.a(j4);
            this.f45018d.a(new a(this.f45018d, this.f45016b));
            imageView = j4;
        }
        this.f45015a.addView(imageView, l());
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void a(String str) {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void a(boolean z3) {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public com.qq.e.comm.plugin.o0.h.f b() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void c() {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void d() {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void destroy() {
        s sVar = this.f45018d;
        if (sVar != null) {
            sVar.b();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void e() {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public String f() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void g() {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public int getCurrentPosition() {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public int getDuration() {
        return 1;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void h() {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void i() {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public boolean isPlaying() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void j() {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void k() {
    }

    protected FrameLayout.LayoutParams l() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void pause() {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void play() {
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.p.b
    public void stop() {
    }
}
