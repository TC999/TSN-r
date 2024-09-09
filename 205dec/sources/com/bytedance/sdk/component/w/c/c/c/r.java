package com.bytedance.sdk.component.w.c.c.c;

import com.bytedance.sdk.component.w.c.ia;
import com.bytedance.sdk.component.w.c.p;
import com.bytedance.sdk.component.xv.w.i;
import com.bytedance.sdk.component.xv.w.y;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends ia {

    /* renamed from: c  reason: collision with root package name */
    y f30384c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(y yVar) {
        this.f30384c = yVar;
    }

    @Override // com.bytedance.sdk.component.w.c.ia
    public long c() {
        y yVar = this.f30384c;
        if (yVar != null) {
            return yVar.w();
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.w.c.ia, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        y yVar = this.f30384c;
        if (yVar != null) {
            yVar.close();
        }
    }

    @Override // com.bytedance.sdk.component.w.c.ia
    public byte[] sr() {
        try {
            return this.f30384c.ux();
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.w.c.ia
    public p ux() {
        i c4;
        y yVar = this.f30384c;
        if (yVar == null || (c4 = yVar.c()) == null) {
            return null;
        }
        return new p(c4.toString(), c4.c(), c4.w(), c4.xv() != null ? c4.xv().name() : null);
    }

    @Override // com.bytedance.sdk.component.w.c.ia
    public String w() {
        try {
            return this.f30384c.f();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.w.c.ia
    public InputStream xv() {
        y yVar = this.f30384c;
        if (yVar != null) {
            return yVar.sr();
        }
        return null;
    }
}
