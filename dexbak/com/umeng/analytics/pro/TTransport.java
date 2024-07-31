package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.de */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class TTransport {
    /* renamed from: a */
    public abstract int mo14383a(byte[] bArr, int i, int i2) throws TTransportException;

    /* renamed from: a */
    public void mo14384a(int i) {
    }

    /* renamed from: a */
    public abstract boolean mo14385a();

    /* renamed from: b */
    public abstract void mo14382b() throws TTransportException;

    /* renamed from: b */
    public void m14381b(byte[] bArr) throws TTransportException {
        mo14380b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public abstract void mo14380b(byte[] bArr, int i, int i2) throws TTransportException;

    /* renamed from: c */
    public abstract void mo14379c();

    /* renamed from: d */
    public int m14377d(byte[] bArr, int i, int i2) throws TTransportException {
        int i3 = 0;
        while (i3 < i2) {
            int mo14383a = mo14383a(bArr, i + i3, i2 - i3);
            if (mo14383a <= 0) {
                throw new TTransportException("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 += mo14383a;
        }
        return i3;
    }

    /* renamed from: d */
    public void mo14378d() throws TTransportException {
    }

    /* renamed from: f */
    public byte[] mo14376f() {
        return null;
    }

    /* renamed from: g */
    public int mo14375g() {
        return 0;
    }

    /* renamed from: h */
    public int mo14374h() {
        return -1;
    }

    /* renamed from: i */
    public boolean m14373i() {
        return mo14385a();
    }
}
