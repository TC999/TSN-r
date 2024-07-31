package com.bytedance.pangle.res.p124a;

import java.io.InputStream;

/* renamed from: com.bytedance.pangle.res.a.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6207e extends AbstractC6212j {

    /* renamed from: a */
    private long f22172a;

    public C6207e(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.bytedance.pangle.res.p124a.AbstractC6212j
    /* renamed from: a */
    protected final synchronized void mo36972a(int i) {
        if (i != -1) {
            this.f22172a += i;
        }
    }

    /* renamed from: b */
    public final synchronized long m36982b() {
        return this.f22172a;
    }

    @Override // com.bytedance.pangle.res.p124a.AbstractC6212j, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j) {
        long skip;
        skip = super.skip(j);
        this.f22172a += skip;
        return skip;
    }

    /* renamed from: a */
    public final int m36983a() {
        long m36982b = m36982b();
        if (m36982b <= 2147483647L) {
            return (int) m36982b;
        }
        throw new ArithmeticException("The byte count " + m36982b + " is too large to be converted to an int");
    }
}
