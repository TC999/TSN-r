package pl.droidsonroids.gif;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: GifDecoder.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final GifInfoHandle f61823a;

    public d(@NonNull l lVar) throws IOException {
        this(lVar, null);
    }

    private void a(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (bitmap.getWidth() >= this.f61823a.q() && bitmap.getHeight() >= this.f61823a.i()) {
                if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                    return;
                }
                throw new IllegalArgumentException("Only Config.ARGB_8888 is supported. Current bitmap config: " + bitmap.getConfig());
            }
            throw new IllegalArgumentException("Bitmap ia too small, size must be greater than or equal to GIF size");
        }
        throw new IllegalArgumentException("Bitmap is recycled");
    }

    public long b() {
        return this.f61823a.b();
    }

    public String c() {
        return this.f61823a.c();
    }

    public int d() {
        return this.f61823a.g();
    }

    public int e(@IntRange(from = 0) int i4) {
        return this.f61823a.h(i4);
    }

    public int f() {
        return this.f61823a.i();
    }

    public int g() {
        return this.f61823a.j();
    }

    public int h() {
        return this.f61823a.n();
    }

    public long i() {
        return this.f61823a.p();
    }

    public int j() {
        return this.f61823a.q();
    }

    public boolean k() {
        return this.f61823a.n() > 1 && d() > 0;
    }

    public void l() {
        this.f61823a.A();
    }

    public void m(@IntRange(from = 0, to = 2147483647L) int i4, @NonNull Bitmap bitmap) {
        a(bitmap);
        this.f61823a.G(i4, bitmap);
    }

    public void n(@IntRange(from = 0, to = 2147483647L) int i4, @NonNull Bitmap bitmap) {
        a(bitmap);
        this.f61823a.I(i4, bitmap);
    }

    public d(@NonNull l lVar, @Nullable h hVar) throws IOException {
        GifInfoHandle c4 = lVar.c();
        this.f61823a = c4;
        if (hVar != null) {
            c4.K(hVar.f61853a, hVar.f61854b);
        }
    }
}
