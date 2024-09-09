package com.qq.e.lib.a.e;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends FilterInputStream implements d {

    /* renamed from: c  reason: collision with root package name */
    private int f47360c;

    public e(InputStream inputStream) {
        super(inputStream);
        try {
            inputStream.reset();
        } catch (IOException unused) {
        }
    }

    @Override // com.qq.e.lib.a.e.d
    public InputStream a() throws IOException {
        return this;
    }

    @Override // com.qq.e.lib.a.e.d
    public byte peek() throws IOException {
        byte read = (byte) read();
        this.f47360c++;
        return read;
    }

    @Override // com.qq.e.lib.a.e.d
    public int position() {
        return this.f47360c;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.qq.e.lib.a.e.d
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        int read = super.read(bArr, i4, i5);
        this.f47360c += Math.max(0, read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.qq.e.lib.a.e.d
    public synchronized void reset() throws IOException {
        super.reset();
        this.f47360c = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.qq.e.lib.a.e.d
    public long skip(long j4) throws IOException {
        long skip = super.skip(j4);
        this.f47360c = (int) (this.f47360c + skip);
        return skip;
    }
}
