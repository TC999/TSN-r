package com.qq.e.comm.plugin.q;

import com.qq.e.comm.plugin.dl.h0;
import com.qq.e.comm.plugin.dl.q;
import com.qq.e.comm.plugin.dysi.IGDTVideoPlayer;
import com.qq.e.comm.plugin.g0.y;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class f implements IGDTVideoPlayer {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.dynamic.b f45416a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.o0.h.f f45417b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f45418c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements h0.d {
        a() {
        }

        @Override // com.qq.e.comm.plugin.dl.h0.d
        public void a(com.qq.e.comm.plugin.o0.h.f fVar) {
            f.this.f45417b = fVar;
            f.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(q qVar, com.qq.e.comm.dynamic.b bVar, com.qq.e.comm.plugin.g0.e eVar, y yVar) {
        this.f45416a = bVar;
        this.f45418c = com.qq.e.comm.plugin.n0.c.a(eVar, yVar);
        a(qVar);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public int currentTime() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f45417b;
        if (fVar == null) {
            return 0;
        }
        return fVar.getCurrentPosition();
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public int duration() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f45417b;
        if (fVar == null) {
            return 0;
        }
        return fVar.getDuration();
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public boolean isPlaying() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f45417b;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void pause() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f45417b;
        if (fVar != null) {
            fVar.pause();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void pauseAndLock() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f45417b;
        if (fVar != null) {
            fVar.s();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void play() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f45417b;
        if (fVar != null) {
            fVar.play();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void speed(double d4) {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f45417b;
        if (fVar != null) {
            fVar.a((float) d4);
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void stop() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f45417b;
        if (fVar != null) {
            fVar.G();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTVideoPlayer
    public void unlockAndPlay() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f45417b;
        if (fVar != null) {
            fVar.J();
        }
    }

    private void a(q qVar) {
        com.qq.e.comm.plugin.o0.h.f i4 = qVar.i();
        this.f45417b = i4;
        if (i4 != null) {
            a();
        } else if (qVar.e() != null) {
            qVar.e().a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f45417b == null) {
            return;
        }
        h.b().a("GDTViewCall", IGDTVideoPlayer.METHOD_INIT, new Object[0]).c().a(this.f45416a, this.f45418c);
    }
}
