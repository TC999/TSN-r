package com.umeng.analytics.pro;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TTransport.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class de {
    public abstract int a(byte[] bArr, int i4, int i5) throws df;

    public void a(int i4) {
    }

    public abstract boolean a();

    public abstract void b() throws df;

    public void b(byte[] bArr) throws df {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i4, int i5) throws df;

    public abstract void c();

    public int d(byte[] bArr, int i4, int i5) throws df {
        int i6 = 0;
        while (i6 < i5) {
            int a4 = a(bArr, i4 + i6, i5 - i6);
            if (a4 <= 0) {
                throw new df("Cannot read. Remote side has closed. Tried to read " + i5 + " bytes, but only got " + i6 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i6 += a4;
        }
        return i6;
    }

    public void d() throws df {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }
}
