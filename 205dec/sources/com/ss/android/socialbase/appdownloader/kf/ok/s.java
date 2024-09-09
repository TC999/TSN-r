package com.ss.android.socialbase.appdownloader.kf.ok;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private boolean f49143a;
    private int bl;
    private InputStream ok;

    public s() {
    }

    public final int a() throws IOException {
        return ok(4);
    }

    public final void bl(int i4) throws IOException {
        if (i4 > 0) {
            long j4 = i4;
            long skip = this.ok.skip(j4);
            this.bl = (int) (this.bl + skip);
            if (skip != j4) {
                throw new EOFException();
            }
        }
    }

    public final void ok(InputStream inputStream, boolean z3) {
        this.ok = inputStream;
        this.f49143a = z3;
        this.bl = 0;
    }

    public s(InputStream inputStream, boolean z3) {
        ok(inputStream, z3);
    }

    public final int[] a(int i4) throws IOException {
        int[] iArr = new int[i4];
        ok(iArr, 0, i4);
        return iArr;
    }

    public final void bl() throws IOException {
        bl(4);
    }

    public final void ok() {
        InputStream inputStream = this.ok;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            ok(null, false);
        }
    }

    public final int ok(int i4) throws IOException {
        if (i4 >= 0 && i4 <= 4) {
            int i5 = 0;
            if (this.f49143a) {
                for (int i6 = (i4 - 1) * 8; i6 >= 0; i6 -= 8) {
                    int read = this.ok.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.bl++;
                    i5 |= read << i6;
                }
                return i5;
            }
            int i7 = i4 * 8;
            int i8 = 0;
            while (i5 != i7) {
                int read2 = this.ok.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.bl++;
                i8 |= read2 << i5;
                i5 += 8;
            }
            return i8;
        }
        throw new IllegalArgumentException();
    }

    public final void ok(int[] iArr, int i4, int i5) throws IOException {
        while (i5 > 0) {
            iArr[i4] = a();
            i5--;
            i4++;
        }
    }
}
