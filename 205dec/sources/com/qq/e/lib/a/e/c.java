package com.qq.e.lib.a.e;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements d {

    /* renamed from: c  reason: collision with root package name */
    public d f47359c;

    public c(d dVar) {
        this.f47359c = dVar;
    }

    @Override // com.qq.e.lib.a.e.d
    public InputStream a() throws IOException {
        reset();
        return this.f47359c.a();
    }

    @Override // com.qq.e.lib.a.e.d
    public int available() throws IOException {
        return this.f47359c.available();
    }

    @Override // com.qq.e.lib.a.e.d
    public void close() throws IOException {
        this.f47359c.close();
    }

    @Override // com.qq.e.lib.a.e.d
    public byte peek() throws IOException {
        return this.f47359c.peek();
    }

    @Override // com.qq.e.lib.a.e.d
    public int position() {
        return this.f47359c.position();
    }

    @Override // com.qq.e.lib.a.e.d
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        return this.f47359c.read(bArr, i4, i5);
    }

    @Override // com.qq.e.lib.a.e.d
    public void reset() throws IOException {
        this.f47359c.reset();
    }

    @Override // com.qq.e.lib.a.e.d
    public long skip(long j4) throws IOException {
        return this.f47359c.skip(j4);
    }
}
