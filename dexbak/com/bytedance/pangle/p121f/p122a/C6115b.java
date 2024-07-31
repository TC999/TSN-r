package com.bytedance.pangle.p121f.p122a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bytedance.pangle.f.a.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6115b {

    /* renamed from: a */
    InputStream f21998a;

    /* renamed from: b */
    private int f21999b;

    public C6115b(InputStream inputStream) {
        m37155a(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m37155a(InputStream inputStream) {
        this.f21998a = inputStream;
        this.f21999b = 0;
    }

    /* renamed from: b */
    public final void m37154b() {
        long skip = this.f21998a.skip(4L);
        this.f21999b = (int) (this.f21999b + skip);
        if (skip != 4) {
            throw new EOFException();
        }
    }

    /* renamed from: a */
    public final int m37157a() {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int read = this.f21998a.read();
            if (read == -1) {
                throw new EOFException();
            }
            this.f21999b++;
            i |= read << i2;
        }
        return i;
    }

    /* renamed from: b */
    public final void m37153b(int i) {
        int m37157a = m37157a();
        if (m37157a != i) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i), Integer.valueOf(m37157a)));
        }
    }

    /* renamed from: a */
    public final int[] m37156a(int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = m37157a();
            i--;
            i2++;
        }
        return iArr;
    }
}
