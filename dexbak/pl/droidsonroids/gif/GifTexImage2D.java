package pl.droidsonroids.gif;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.io.IOException;

/* renamed from: pl.droidsonroids.gif.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class GifTexImage2D {

    /* renamed from: a */
    private final GifInfoHandle f44443a;

    public GifTexImage2D(InputSource inputSource, @Nullable C15443h c15443h) throws IOException {
        c15443h = c15443h == null ? new C15443h() : c15443h;
        GifInfoHandle mo2368c = inputSource.mo2368c();
        this.f44443a = mo2368c;
        mo2368c.m2527K(c15443h.f44440a, c15443h.f44441b);
        mo2368c.m2503t();
    }

    /* renamed from: a */
    public int m2389a() {
        return this.f44443a.m2519d();
    }

    /* renamed from: b */
    public int m2388b() {
        return this.f44443a.m2516g();
    }

    /* renamed from: c */
    public int m2387c(@IntRange(from = 0) int i) {
        return this.f44443a.m2515h(i);
    }

    /* renamed from: d */
    public int m2386d() {
        return this.f44443a.m2514i();
    }

    /* renamed from: e */
    public int m2385e() {
        return this.f44443a.m2509n();
    }

    /* renamed from: f */
    public int m2384f() {
        return this.f44443a.m2506q();
    }

    protected final void finalize() throws Throwable {
        try {
            m2381i();
        } finally {
            super.finalize();
        }
    }

    /* renamed from: g */
    public void m2383g(int i, int i2) {
        this.f44443a.m2505r(i, i2);
    }

    /* renamed from: h */
    public void m2382h(int i, int i2) {
        this.f44443a.m2504s(i, i2);
    }

    /* renamed from: i */
    public void m2381i() {
        GifInfoHandle gifInfoHandle = this.f44443a;
        if (gifInfoHandle != null) {
            gifInfoHandle.m2537A();
        }
    }

    /* renamed from: j */
    public void m2380j(@IntRange(from = 0) int i) {
        this.f44443a.m2530H(i);
    }

    /* renamed from: k */
    public void m2379k(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this.f44443a.m2526L(f);
    }

    /* renamed from: l */
    public void m2378l() {
        this.f44443a.m2525M();
    }

    /* renamed from: m */
    public void m2377m() {
        this.f44443a.m2524N();
    }
}
