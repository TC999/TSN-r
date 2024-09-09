package defpackage;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.jar.JarFile;

/* renamed from: m  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1473m extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1475n f60813a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1473m(C1475n c1475n, InputStream inputStream) {
        super(inputStream);
        this.f60813a = c1475n;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        C1475n c1475n = this.f60813a;
        c1475n.f61486d = true;
        c1475n.f61487e.f61571b.close();
        JarFile jarFile = c1475n.f61483a;
        if (jarFile != null) {
            jarFile.close();
        }
    }
}
