package com.amap.api.col.p0003l;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AbstractBuilder.java */
/* renamed from: com.amap.api.col.3l.d8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class d8 {

    /* renamed from: a  reason: collision with root package name */
    f8 f7439a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f7440b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d8(int i4) {
        ByteBuffer allocate = ByteBuffer.allocate(i4);
        this.f7440b = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        this.f7439a = new f8(this.f7440b);
    }

    public final d8 a() {
        this.f7439a.c(this.f7440b);
        return this;
    }
}
