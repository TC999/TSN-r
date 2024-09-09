package com.bytedance.pangle.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    InputStream f28759a;

    /* renamed from: b  reason: collision with root package name */
    private int f28760b;

    public b(InputStream inputStream) {
        a(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InputStream inputStream) {
        this.f28759a = inputStream;
        this.f28760b = 0;
    }

    public final void b() {
        long skip = this.f28759a.skip(4L);
        this.f28760b = (int) (this.f28760b + skip);
        if (skip != 4) {
            throw new EOFException();
        }
    }

    public final int a() {
        int i4 = 0;
        for (int i5 = 0; i5 != 32; i5 += 8) {
            int read = this.f28759a.read();
            if (read == -1) {
                throw new EOFException();
            }
            this.f28760b++;
            i4 |= read << i5;
        }
        return i4;
    }

    public final void b(int i4) {
        int a4 = a();
        if (a4 != i4) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i4), Integer.valueOf(a4)));
        }
    }

    public final int[] a(int i4) {
        int[] iArr = new int[i4];
        int i5 = 0;
        while (i4 > 0) {
            iArr[i5] = a();
            i4--;
            i5++;
        }
        return iArr;
    }
}
