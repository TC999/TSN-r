package com.danikula.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* renamed from: com.danikula.videocache.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ByteArrayCache implements InterfaceC6541d {

    /* renamed from: a */
    private volatile byte[] f23061a;

    /* renamed from: b */
    private volatile boolean f23062b;

    public ByteArrayCache() {
        this(new byte[0]);
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    /* renamed from: a */
    public void mo35942a(byte[] bArr, int i) throws ProxyCacheException {
        C6567n.m35858d(this.f23061a);
        C6567n.m35860b(i >= 0 && i <= bArr.length);
        byte[] copyOf = Arrays.copyOf(this.f23061a, this.f23061a.length + i);
        System.arraycopy(bArr, 0, copyOf, this.f23061a.length, i);
        this.f23061a = copyOf;
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    public long available() throws ProxyCacheException {
        return this.f23061a.length;
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    /* renamed from: b */
    public int mo35941b(byte[] bArr, long j, int i) throws ProxyCacheException {
        if (j >= this.f23061a.length) {
            return -1;
        }
        if (j <= 2147483647L) {
            return new ByteArrayInputStream(this.f23061a).read(bArr, (int) j, i);
        }
        throw new IllegalArgumentException("Too long offset for memory cache " + j);
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    public void close() throws ProxyCacheException {
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    public void complete() {
        this.f23062b = true;
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    public boolean isCompleted() {
        return this.f23062b;
    }

    public ByteArrayCache(byte[] bArr) {
        this.f23061a = (byte[]) C6567n.m35858d(bArr);
    }
}
