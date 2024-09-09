package com.qq.e.comm.plugin.q;

import com.qq.e.comm.plugin.dl.q;
import com.qq.e.comm.plugin.dysi.IGDTAudioPlayer;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.o0.f.b;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d implements IGDTAudioPlayer, b.i {

    /* renamed from: a  reason: collision with root package name */
    private final q f45367a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f45368b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f45369c;

    /* renamed from: d  reason: collision with root package name */
    private com.qq.e.comm.plugin.o0.f.b f45370d;

    /* renamed from: e  reason: collision with root package name */
    private final com.qq.e.comm.dynamic.b f45371e;

    /* renamed from: f  reason: collision with root package name */
    private String f45372f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f45373g;

    public d(q qVar, com.qq.e.comm.plugin.g0.e eVar, y yVar, com.qq.e.comm.dynamic.b bVar) {
        this.f45367a = qVar;
        this.f45368b = eVar;
        this.f45369c = com.qq.e.comm.plugin.n0.c.a(eVar, yVar);
        this.f45371e = bVar;
        this.f45373g = com.qq.e.comm.plugin.t.c.a("apsa", this.f45368b.q0(), 0, this.f45368b.p0()) == 0;
    }

    private void a(String str) {
        com.qq.e.comm.dynamic.b bVar = this.f45371e;
        if (bVar != null) {
            try {
                bVar.b(str);
            } catch (Throwable th) {
                d1.a("GDTDynamic-AudioPlayer", "safeEvaluate script error", th);
                i.a(str, this.f45369c, th);
            }
        }
    }

    private void g() {
        if (this.f45370d == null && this.f45373g) {
            com.qq.e.comm.plugin.o0.f.b bVar = new com.qq.e.comm.plugin.o0.f.b(this.f45367a.d().b());
            this.f45370d = bVar;
            bVar.a(this);
        }
    }

    private boolean h() {
        return this.f45373g && this.f45370d != null;
    }

    @Override // com.qq.e.comm.plugin.o0.f.b.i
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.o0.f.b.i
    public void a(Throwable th) {
    }

    @Override // com.qq.e.comm.plugin.o0.f.b.i
    public void b() {
    }

    @Override // com.qq.e.comm.plugin.o0.f.b.i
    public void c() {
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public int currentTime() {
        if (h()) {
            return this.f45370d.f();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.o0.f.b.i
    public void d() {
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public int duration() {
        if (h()) {
            return this.f45370d.g();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.o0.f.b.i
    public void e() {
    }

    @Override // com.qq.e.comm.plugin.o0.f.b.i
    public void f() {
        a(this.f45372f);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void free() {
        if (h()) {
            this.f45370d.c();
            this.f45370d = null;
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public int isPlaying() {
        return (h() && this.f45370d.e() == 3) ? 1 : 0;
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void pause() {
        if (h()) {
            this.f45370d.r();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void play() {
        g();
        if (h()) {
            this.f45370d.j();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void prepareAudioPlayer(String str, String str2) {
        g();
        if (h()) {
            this.f45372f = str2;
            this.f45370d.b(str);
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void setNumberOfLoops(int i4) {
        g();
        if (h()) {
            this.f45370d.a(i4);
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void setVolume(double d4) {
        g();
        if (h()) {
            if (d4 == 1.0d) {
                this.f45370d.p();
            } else {
                this.f45370d.n();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTAudioPlayer
    public void stop() {
        if (h()) {
            this.f45370d.r();
        }
    }
}
