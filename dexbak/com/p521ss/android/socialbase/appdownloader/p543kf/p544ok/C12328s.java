package com.p521ss.android.socialbase.appdownloader.p543kf.p544ok;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.ss.android.socialbase.appdownloader.kf.ok.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12328s {

    /* renamed from: a */
    private boolean f34769a;

    /* renamed from: bl */
    private int f34770bl;

    /* renamed from: ok */
    private InputStream f34771ok;

    public C12328s() {
    }

    /* renamed from: a */
    public final int m18180a() throws IOException {
        return m18175ok(4);
    }

    /* renamed from: bl */
    public final void m18177bl(int i) throws IOException {
        if (i > 0) {
            long j = i;
            long skip = this.f34771ok.skip(j);
            this.f34770bl = (int) (this.f34770bl + skip);
            if (skip != j) {
                throw new EOFException();
            }
        }
    }

    /* renamed from: ok */
    public final void m18174ok(InputStream inputStream, boolean z) {
        this.f34771ok = inputStream;
        this.f34769a = z;
        this.f34770bl = 0;
    }

    public C12328s(InputStream inputStream, boolean z) {
        m18174ok(inputStream, z);
    }

    /* renamed from: a */
    public final int[] m18179a(int i) throws IOException {
        int[] iArr = new int[i];
        m18173ok(iArr, 0, i);
        return iArr;
    }

    /* renamed from: bl */
    public final void m18178bl() throws IOException {
        m18177bl(4);
    }

    /* renamed from: ok */
    public final void m18176ok() {
        InputStream inputStream = this.f34771ok;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            m18174ok(null, false);
        }
    }

    /* renamed from: ok */
    public final int m18175ok(int i) throws IOException {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.f34769a) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int read = this.f34771ok.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.f34770bl++;
                    i2 |= read << i3;
                }
                return i2;
            }
            int i4 = i * 8;
            int i5 = 0;
            while (i2 != i4) {
                int read2 = this.f34771ok.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.f34770bl++;
                i5 |= read2 << i2;
                i2 += 8;
            }
            return i5;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: ok */
    public final void m18173ok(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = m18180a();
            i2--;
            i++;
        }
    }
}
