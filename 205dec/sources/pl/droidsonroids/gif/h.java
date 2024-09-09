package pl.droidsonroids.gif;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

/* compiled from: GifOptions.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    char f61853a;

    /* renamed from: b  reason: collision with root package name */
    boolean f61854b;

    public h() {
        a();
    }

    private void a() {
        this.f61853a = (char) 1;
        this.f61854b = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable h hVar) {
        if (hVar == null) {
            a();
            return;
        }
        this.f61854b = hVar.f61854b;
        this.f61853a = hVar.f61853a;
    }

    public void c(boolean z3) {
        this.f61854b = z3;
    }

    public void d(@IntRange(from = 1, to = 65535) int i4) {
        if (i4 >= 1 && i4 <= 65535) {
            this.f61853a = (char) i4;
        } else {
            this.f61853a = (char) 1;
        }
    }
}
