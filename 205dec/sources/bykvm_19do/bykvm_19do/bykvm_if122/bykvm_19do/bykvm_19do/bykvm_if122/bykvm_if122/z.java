package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: RequestBody.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class z {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBody.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a extends z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f1456a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1457b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ byte[] f1458c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f1459d;

        a(u uVar, int i4, byte[] bArr, int i5) {
            this.f1456a = uVar;
            this.f1457b = i4;
            this.f1458c = bArr;
            this.f1459d = i5;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z
        public long a() {
            return this.f1457b;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z
        public u b() {
            return this.f1456a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z
        public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) throws IOException {
            dVar.write(this.f1458c, this.f1459d, this.f1457b);
        }
    }

    public static z a(u uVar, String str) {
        Charset charset = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1234i;
        if (uVar != null) {
            Charset a4 = uVar.a();
            if (a4 == null) {
                uVar = u.a(uVar + "; charset=utf-8");
            } else {
                charset = a4;
            }
        }
        return a(uVar, str.getBytes(charset));
    }

    public abstract long a() throws IOException;

    public abstract void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) throws IOException;

    public abstract u b();

    public static z a(u uVar, byte[] bArr) {
        return a(uVar, bArr, 0, bArr.length);
    }

    public static z a(u uVar, byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bArr.length, i4, i5);
            return new a(uVar, i5, bArr, i4);
        }
        throw new NullPointerException("content == null");
    }
}
