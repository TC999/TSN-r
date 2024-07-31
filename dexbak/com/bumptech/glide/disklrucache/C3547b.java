package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* renamed from: com.bumptech.glide.disklrucache.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class C3547b implements Closeable {

    /* renamed from: f */
    private static final byte f13289f = 13;

    /* renamed from: g */
    private static final byte f13290g = 10;

    /* renamed from: a */
    private final InputStream f13291a;

    /* renamed from: b */
    private final Charset f13292b;

    /* renamed from: c */
    private byte[] f13293c;

    /* renamed from: d */
    private int f13294d;

    /* renamed from: e */
    private int f13295e;

    /* compiled from: StrictLineReader.java */
    /* renamed from: com.bumptech.glide.disklrucache.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3548a extends ByteArrayOutputStream {
        C3548a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
                i--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, C3547b.this.f13292b.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public C3547b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* renamed from: b */
    private void m45663b() throws IOException {
        InputStream inputStream = this.f13291a;
        byte[] bArr = this.f13293c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f13294d = 0;
            this.f13295e = read;
            return;
        }
        throw new EOFException();
    }

    /* renamed from: c */
    public boolean m45662c() {
        return this.f13295e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f13291a) {
            if (this.f13293c != null) {
                this.f13293c = null;
                this.f13291a.close();
            }
        }
    }

    /* renamed from: d */
    public String m45661d() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f13291a) {
            if (this.f13293c != null) {
                if (this.f13294d >= this.f13295e) {
                    m45663b();
                }
                for (int i3 = this.f13294d; i3 != this.f13295e; i3++) {
                    byte[] bArr2 = this.f13293c;
                    if (bArr2[i3] == 10) {
                        int i4 = this.f13294d;
                        if (i3 != i4) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                String str = new String(bArr2, i4, i2 - i4, this.f13292b.name());
                                this.f13294d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(bArr2, i4, i2 - i4, this.f13292b.name());
                        this.f13294d = i3 + 1;
                        return str2;
                    }
                }
                C3548a c3548a = new C3548a((this.f13295e - this.f13294d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f13293c;
                    int i5 = this.f13294d;
                    c3548a.write(bArr3, i5, this.f13295e - i5);
                    this.f13295e = -1;
                    m45663b();
                    i = this.f13294d;
                    while (i != this.f13295e) {
                        bArr = this.f13293c;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i6 = this.f13294d;
                if (i != i6) {
                    c3548a.write(bArr, i6, i - i6);
                }
                this.f13294d = i + 1;
                return c3548a.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public C3547b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i >= 0) {
            if (charset.equals(C3549c.f13297a)) {
                this.f13291a = inputStream;
                this.f13292b = charset;
                this.f13293c = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
