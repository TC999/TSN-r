package com.ss.android.socialbase.appdownloader.f.c;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private InputStream f49085c;

    /* renamed from: w  reason: collision with root package name */
    private boolean f49086w;
    private int xv;

    public sr() {
    }

    public final void c(InputStream inputStream, boolean z3) {
        this.f49085c = inputStream;
        this.f49086w = z3;
        this.xv = 0;
    }

    public final int w() throws IOException {
        return c(4);
    }

    public final void xv(int i4) throws IOException {
        if (i4 > 0) {
            long j4 = i4;
            long skip = this.f49085c.skip(j4);
            this.xv = (int) (this.xv + skip);
            if (skip != j4) {
                throw new EOFException();
            }
        }
    }

    public sr(InputStream inputStream, boolean z3) {
        c(inputStream, z3);
    }

    public final int[] w(int i4) throws IOException {
        int[] iArr = new int[i4];
        c(iArr, 0, i4);
        return iArr;
    }

    public final void c() {
        InputStream inputStream = this.f49085c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            c(null, false);
        }
    }

    public final void xv() throws IOException {
        xv(4);
    }

    public final int c(int i4) throws IOException {
        if (i4 >= 0 && i4 <= 4) {
            int i5 = 0;
            if (this.f49086w) {
                for (int i6 = (i4 - 1) * 8; i6 >= 0; i6 -= 8) {
                    int read = this.f49085c.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.xv++;
                    i5 |= read << i6;
                }
                return i5;
            }
            int i7 = i4 * 8;
            int i8 = 0;
            while (i5 != i7) {
                int read2 = this.f49085c.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.xv++;
                i8 |= read2 << i5;
                i5 += 8;
            }
            return i8;
        }
        throw new IllegalArgumentException();
    }

    public final void c(int[] iArr, int i4, int i5) throws IOException {
        while (i5 > 0) {
            iArr[i4] = w();
            i5--;
            i4++;
        }
    }
}
