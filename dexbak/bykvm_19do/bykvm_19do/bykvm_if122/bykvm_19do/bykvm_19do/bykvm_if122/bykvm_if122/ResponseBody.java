package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class ResponseBody implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResponseBody.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1019a extends ResponseBody {

        /* renamed from: a */
        final /* synthetic */ MediaType f888a;

        /* renamed from: b */
        final /* synthetic */ long f889b;

        /* renamed from: c */
        final /* synthetic */ BufferedSource f890c;

        C1019a(MediaType mediaType, long j, BufferedSource bufferedSource) {
            this.f888a = mediaType;
            this.f889b = j;
            this.f890c = bufferedSource;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody
        /* renamed from: a */
        public long mo58752a() {
            return this.f889b;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody
        /* renamed from: b */
        public MediaType mo58751b() {
            return this.f888a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody
        /* renamed from: c */
        public BufferedSource mo58750c() {
            return this.f890c;
        }
    }

    /* renamed from: a */
    public static ResponseBody m58818a(MediaType mediaType, byte[] bArr) {
        return m58819a(mediaType, bArr.length, new Buffer().write(bArr));
    }

    /* renamed from: e */
    private Charset m58816e() {
        MediaType mo58751b = mo58751b();
        return mo58751b != null ? mo58751b.m58267a(C1061c.f1241i) : C1061c.f1241i;
    }

    /* renamed from: a */
    public abstract long mo58752a();

    /* renamed from: b */
    public abstract MediaType mo58751b();

    /* renamed from: c */
    public abstract BufferedSource mo58750c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C1061c.m58475a(mo58750c());
    }

    /* renamed from: d */
    public final String m58817d() throws IOException {
        BufferedSource mo58750c = mo58750c();
        try {
            return mo58750c.mo58910a(C1061c.m58478a(mo58750c, m58816e()));
        } finally {
            C1061c.m58475a(mo58750c);
        }
    }

    /* renamed from: a */
    public static ResponseBody m58819a(MediaType mediaType, long j, BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new C1019a(mediaType, j, bufferedSource);
        }
        throw new NullPointerException("source == null");
    }
}
