package pl.droidsonroids.gif;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* renamed from: pl.droidsonroids.gif.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class GifDecoder {

    /* renamed from: a */
    private final GifInfoHandle f44410a;

    public GifDecoder(@NonNull InputSource inputSource) throws IOException {
        this(inputSource, null);
    }

    /* renamed from: a */
    private void m2471a(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (bitmap.getWidth() >= this.f44410a.m2506q() && bitmap.getHeight() >= this.f44410a.m2514i()) {
                if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                    return;
                }
                throw new IllegalArgumentException("Only Config.ARGB_8888 is supported. Current bitmap config: " + bitmap.getConfig());
            }
            throw new IllegalArgumentException("Bitmap ia too small, size must be greater than or equal to GIF size");
        }
        throw new IllegalArgumentException("Bitmap is recycled");
    }

    /* renamed from: b */
    public long m2470b() {
        return this.f44410a.m2521b();
    }

    /* renamed from: c */
    public String m2469c() {
        return this.f44410a.m2520c();
    }

    /* renamed from: d */
    public int m2468d() {
        return this.f44410a.m2516g();
    }

    /* renamed from: e */
    public int m2467e(@IntRange(from = 0) int i) {
        return this.f44410a.m2515h(i);
    }

    /* renamed from: f */
    public int m2466f() {
        return this.f44410a.m2514i();
    }

    /* renamed from: g */
    public int m2465g() {
        return this.f44410a.m2513j();
    }

    /* renamed from: h */
    public int m2464h() {
        return this.f44410a.m2509n();
    }

    /* renamed from: i */
    public long m2463i() {
        return this.f44410a.m2507p();
    }

    /* renamed from: j */
    public int m2462j() {
        return this.f44410a.m2506q();
    }

    /* renamed from: k */
    public boolean m2461k() {
        return this.f44410a.m2509n() > 1 && m2468d() > 0;
    }

    /* renamed from: l */
    public void m2460l() {
        this.f44410a.m2537A();
    }

    /* renamed from: m */
    public void m2459m(@IntRange(from = 0, m60035to = 2147483647L) int i, @NonNull Bitmap bitmap) {
        m2471a(bitmap);
        this.f44410a.m2531G(i, bitmap);
    }

    /* renamed from: n */
    public void m2458n(@IntRange(from = 0, m60035to = 2147483647L) int i, @NonNull Bitmap bitmap) {
        m2471a(bitmap);
        this.f44410a.m2529I(i, bitmap);
    }

    public GifDecoder(@NonNull InputSource inputSource, @Nullable C15443h c15443h) throws IOException {
        GifInfoHandle mo2368c = inputSource.mo2368c();
        this.f44410a = mo2368c;
        if (c15443h != null) {
            mo2368c.m2527K(c15443h.f44440a, c15443h.f44441b);
        }
    }
}
