package com.umeng.analytics.pro;

/* renamed from: com.umeng.analytics.pro.dd */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class TMemoryInputTransport extends TTransport {

    /* renamed from: a */
    private byte[] f38164a;

    /* renamed from: b */
    private int f38165b;

    /* renamed from: c */
    private int f38166c;

    public TMemoryInputTransport() {
    }

    /* renamed from: a */
    public void m14388a(byte[] bArr) {
        m14387c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: a */
    public boolean mo14385a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: b */
    public void mo14382b() throws TTransportException {
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: b */
    public void mo14380b(byte[] bArr, int i, int i2) throws TTransportException {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: c */
    public void mo14379c() {
    }

    /* renamed from: c */
    public void m14387c(byte[] bArr, int i, int i2) {
        this.f38164a = bArr;
        this.f38165b = i;
        this.f38166c = i + i2;
    }

    /* renamed from: e */
    public void m14386e() {
        this.f38164a = null;
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: f */
    public byte[] mo14376f() {
        return this.f38164a;
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: g */
    public int mo14375g() {
        return this.f38165b;
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: h */
    public int mo14374h() {
        return this.f38166c - this.f38165b;
    }

    public TMemoryInputTransport(byte[] bArr) {
        m14388a(bArr);
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: a */
    public int mo14383a(byte[] bArr, int i, int i2) throws TTransportException {
        int mo14374h = mo14374h();
        if (i2 > mo14374h) {
            i2 = mo14374h;
        }
        if (i2 > 0) {
            System.arraycopy(this.f38164a, this.f38165b, bArr, i, i2);
            mo14384a(i2);
        }
        return i2;
    }

    public TMemoryInputTransport(byte[] bArr, int i, int i2) {
        m14387c(bArr, i, i2);
    }

    @Override // com.umeng.analytics.pro.TTransport
    /* renamed from: a */
    public void mo14384a(int i) {
        this.f38165b += i;
    }
}
