package com.amap.api.col.p0003l;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ByteJoinDataStrategy.java */
/* renamed from: com.amap.api.col.3l.j7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j7 extends p7 {

    /* renamed from: c  reason: collision with root package name */
    ByteArrayOutputStream f8222c;

    public j7() {
        this.f8222c = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.p0003l.p7
    protected final byte[] b(byte[] bArr) {
        byte[] byteArray = this.f8222c.toByteArray();
        try {
            this.f8222c.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        this.f8222c = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.p0003l.p7
    public final void c(byte[] bArr) {
        try {
            this.f8222c.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public j7(p7 p7Var) {
        super(p7Var);
        this.f8222c = new ByteArrayOutputStream();
    }
}
