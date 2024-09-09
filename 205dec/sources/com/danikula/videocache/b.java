package com.danikula.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: ByteArrayCache.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f36728a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f36729b;

    public b() {
        this(new byte[0]);
    }

    @Override // com.danikula.videocache.d
    public void a(byte[] bArr, int i4) throws ProxyCacheException {
        n.d(this.f36728a);
        n.b(i4 >= 0 && i4 <= bArr.length);
        byte[] copyOf = Arrays.copyOf(this.f36728a, this.f36728a.length + i4);
        System.arraycopy(bArr, 0, copyOf, this.f36728a.length, i4);
        this.f36728a = copyOf;
    }

    @Override // com.danikula.videocache.d
    public long available() throws ProxyCacheException {
        return this.f36728a.length;
    }

    @Override // com.danikula.videocache.d
    public int b(byte[] bArr, long j4, int i4) throws ProxyCacheException {
        if (j4 >= this.f36728a.length) {
            return -1;
        }
        if (j4 <= 2147483647L) {
            return new ByteArrayInputStream(this.f36728a).read(bArr, (int) j4, i4);
        }
        throw new IllegalArgumentException("Too long offset for memory cache " + j4);
    }

    @Override // com.danikula.videocache.d
    public void close() throws ProxyCacheException {
    }

    @Override // com.danikula.videocache.d
    public void complete() {
        this.f36729b = true;
    }

    @Override // com.danikula.videocache.d
    public boolean isCompleted() {
        return this.f36729b;
    }

    public b(byte[] bArr) {
        this.f36728a = (byte[]) n.d(bArr);
    }
}
