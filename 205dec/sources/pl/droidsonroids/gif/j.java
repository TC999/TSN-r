package pl.droidsonroids.gif;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: GifTexImage2D.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final GifInfoHandle f61856a;

    public j(l lVar, @Nullable h hVar) throws IOException {
        hVar = hVar == null ? new h() : hVar;
        GifInfoHandle c4 = lVar.c();
        this.f61856a = c4;
        c4.K(hVar.f61853a, hVar.f61854b);
        c4.t();
    }

    public int a() {
        return this.f61856a.d();
    }

    public int b() {
        return this.f61856a.g();
    }

    public int c(@IntRange(from = 0) int i4) {
        return this.f61856a.h(i4);
    }

    public int d() {
        return this.f61856a.i();
    }

    public int e() {
        return this.f61856a.n();
    }

    public int f() {
        return this.f61856a.q();
    }

    protected final void finalize() throws Throwable {
        try {
            i();
        } finally {
            super.finalize();
        }
    }

    public void g(int i4, int i5) {
        this.f61856a.r(i4, i5);
    }

    public void h(int i4, int i5) {
        this.f61856a.s(i4, i5);
    }

    public void i() {
        GifInfoHandle gifInfoHandle = this.f61856a;
        if (gifInfoHandle != null) {
            gifInfoHandle.A();
        }
    }

    public void j(@IntRange(from = 0) int i4) {
        this.f61856a.H(i4);
    }

    public void k(@FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        this.f61856a.L(f4);
    }

    public void l() {
        this.f61856a.M();
    }

    public void m() {
        this.f61856a.N();
    }
}
