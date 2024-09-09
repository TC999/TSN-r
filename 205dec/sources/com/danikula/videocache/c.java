package com.danikula.videocache;

import java.io.ByteArrayInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: ByteArraySource.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements q {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f36730a;

    /* renamed from: b  reason: collision with root package name */
    private ByteArrayInputStream f36731b;

    public c(byte[] bArr) {
        this.f36730a = bArr;
    }

    @Override // com.danikula.videocache.q
    public void a(long j4) throws ProxyCacheException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f36730a);
        this.f36731b = byteArrayInputStream;
        byteArrayInputStream.skip(j4);
    }

    @Override // com.danikula.videocache.q
    public void close() throws ProxyCacheException {
    }

    @Override // com.danikula.videocache.q
    public long length() throws ProxyCacheException {
        return this.f36730a.length;
    }

    @Override // com.danikula.videocache.q
    public int read(byte[] bArr) throws ProxyCacheException {
        return this.f36731b.read(bArr, 0, bArr.length);
    }
}
