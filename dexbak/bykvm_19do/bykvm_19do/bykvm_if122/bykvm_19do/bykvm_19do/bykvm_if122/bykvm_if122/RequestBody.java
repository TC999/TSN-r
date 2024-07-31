package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class RequestBody {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBody.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1084a extends RequestBody {

        /* renamed from: a */
        final /* synthetic */ MediaType f1466a;

        /* renamed from: b */
        final /* synthetic */ int f1467b;

        /* renamed from: c */
        final /* synthetic */ byte[] f1468c;

        /* renamed from: d */
        final /* synthetic */ int f1469d;

        C1084a(MediaType mediaType, int i, byte[] bArr, int i2) {
            this.f1466a = mediaType;
            this.f1467b = i;
            this.f1468c = bArr;
            this.f1469d = i2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.RequestBody
        /* renamed from: a */
        public long mo58189a() {
            return this.f1467b;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.RequestBody
        /* renamed from: b */
        public MediaType mo58187b() {
            return this.f1466a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.RequestBody
        /* renamed from: a */
        public void mo58188a(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.f1468c, this.f1469d, this.f1467b);
        }
    }

    /* renamed from: a */
    public static RequestBody m58192a(MediaType mediaType, String str) {
        Charset charset = C1061c.f1241i;
        if (mediaType != null) {
            Charset m58269a = mediaType.m58269a();
            if (m58269a == null) {
                mediaType = MediaType.m58268a(mediaType + "; charset=utf-8");
            } else {
                charset = m58269a;
            }
        }
        return m58191a(mediaType, str.getBytes(charset));
    }

    /* renamed from: a */
    public abstract long mo58189a() throws IOException;

    /* renamed from: a */
    public abstract void mo58188a(BufferedSink bufferedSink) throws IOException;

    /* renamed from: b */
    public abstract MediaType mo58187b();

    /* renamed from: a */
    public static RequestBody m58191a(MediaType mediaType, byte[] bArr) {
        return m58190a(mediaType, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static RequestBody m58190a(MediaType mediaType, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            C1061c.m58479a(bArr.length, i, i2);
            return new C1084a(mediaType, i2, bArr, i);
        }
        throw new NullPointerException("content == null");
    }
}
