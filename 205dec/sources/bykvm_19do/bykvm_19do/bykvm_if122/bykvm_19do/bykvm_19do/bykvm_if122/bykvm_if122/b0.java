package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: ResponseBody.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class b0 implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResponseBody.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a extends b0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f881a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f882b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f883c;

        a(u uVar, long j4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar) {
            this.f881a = uVar;
            this.f882b = j4;
            this.f883c = eVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0
        public long a() {
            return this.f882b;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0
        public u b() {
            return this.f881a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0
        public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e c() {
            return this.f883c;
        }
    }

    public static b0 a(u uVar, byte[] bArr) {
        return a(uVar, bArr.length, new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c().write(bArr));
    }

    private Charset e() {
        u b4 = b();
        return b4 != null ? b4.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1234i) : bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1234i;
    }

    public abstract long a();

    public abstract u b();

    public abstract bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(c());
    }

    public final String d() throws IOException {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e c4 = c();
        try {
            return c4.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(c4, e()));
        } finally {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(c4);
        }
    }

    public static b0 a(u uVar, long j4, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar) {
        if (eVar != null) {
            return new a(uVar, j4, eVar);
        }
        throw new NullPointerException("source == null");
    }
}
