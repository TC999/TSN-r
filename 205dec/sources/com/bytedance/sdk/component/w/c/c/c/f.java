package com.bytedance.sdk.component.w.c.c.c;

import com.bytedance.sdk.component.w.c.bk;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.ia;
import com.bytedance.sdk.component.w.c.k;
import com.bytedance.sdk.component.xv.w.ba;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends fp {

    /* renamed from: c  reason: collision with root package name */
    public ba f30383c;

    public f(ba baVar) {
        this.f30383c = baVar;
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public long c() {
        return this.f30383c.t();
    }

    @Override // com.bytedance.sdk.component.w.c.fp, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f30383c.close();
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public bk ev() {
        try {
            return bk.c(this.f30383c.w().toString());
        } catch (Exception unused) {
            return bk.HTTP_1_1;
        }
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public ia f() {
        return new r(this.f30383c.ev());
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public k gd() {
        ba baVar = this.f30383c;
        if (baVar == null) {
            return null;
        }
        return new k(baVar.ys());
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public com.bytedance.sdk.component.w.c.f r() {
        return new com.bytedance.sdk.component.w.c.f(this.f30383c.r().f31096c);
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public boolean sr() {
        return this.f30383c.sr();
    }

    public String toString() {
        return this.f30383c.toString();
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public String ux() {
        return this.f30383c.ux();
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public long w() {
        return this.f30383c.bk();
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public int xv() {
        ba baVar = this.f30383c;
        if (baVar != null) {
            return baVar.xv();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public String c(String str) {
        return this.f30383c.c(str);
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public String c(String str, String str2) {
        return this.f30383c.c(str, str2);
    }
}
