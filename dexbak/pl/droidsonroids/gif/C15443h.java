package pl.droidsonroids.gif;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

/* compiled from: GifOptions.java */
/* renamed from: pl.droidsonroids.gif.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C15443h {

    /* renamed from: a */
    char f44440a;

    /* renamed from: b */
    boolean f44441b;

    public C15443h() {
        m2395a();
    }

    /* renamed from: a */
    private void m2395a() {
        this.f44440a = (char) 1;
        this.f44441b = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m2394b(@Nullable C15443h c15443h) {
        if (c15443h == null) {
            m2395a();
            return;
        }
        this.f44441b = c15443h.f44441b;
        this.f44440a = c15443h.f44440a;
    }

    /* renamed from: c */
    public void m2393c(boolean z) {
        this.f44441b = z;
    }

    /* renamed from: d */
    public void m2392d(@IntRange(from = 1, m60035to = 65535) int i) {
        if (i >= 1 && i <= 65535) {
            this.f44440a = (char) i;
        } else {
            this.f44440a = (char) 1;
        }
    }
}
