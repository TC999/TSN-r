package com.danikula.videocache;

import java.io.ByteArrayInputStream;

/* renamed from: com.danikula.videocache.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ByteArraySource implements InterfaceC6572q {

    /* renamed from: a */
    private final byte[] f23063a;

    /* renamed from: b */
    private ByteArrayInputStream f23064b;

    public ByteArraySource(byte[] bArr) {
        this.f23063a = bArr;
    }

    @Override // com.danikula.videocache.InterfaceC6572q
    /* renamed from: a */
    public void mo35833a(long j) throws ProxyCacheException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f23063a);
        this.f23064b = byteArrayInputStream;
        byteArrayInputStream.skip(j);
    }

    @Override // com.danikula.videocache.InterfaceC6572q
    public void close() throws ProxyCacheException {
    }

    @Override // com.danikula.videocache.InterfaceC6572q
    public long length() throws ProxyCacheException {
        return this.f23063a.length;
    }

    @Override // com.danikula.videocache.InterfaceC6572q
    public int read(byte[] bArr) throws ProxyCacheException {
        return this.f23064b.read(bArr, 0, bArr.length);
    }
}
