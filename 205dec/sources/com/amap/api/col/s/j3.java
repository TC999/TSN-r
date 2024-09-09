package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ByteJoinDataStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j3 extends p3 {

    /* renamed from: c  reason: collision with root package name */
    ByteArrayOutputStream f9953c;

    public j3() {
        this.f9953c = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.s.p3
    protected final byte[] b(byte[] bArr) {
        byte[] byteArray = this.f9953c.toByteArray();
        try {
            this.f9953c.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        this.f9953c = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.s.p3
    public final void c(byte[] bArr) {
        try {
            this.f9953c.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public j3(p3 p3Var) {
        super(p3Var);
        this.f9953c = new ByteArrayOutputStream();
    }
}
