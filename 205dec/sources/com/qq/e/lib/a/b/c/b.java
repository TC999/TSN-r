package com.qq.e.lib.a.b.c;

import java.nio.ByteOrder;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends com.qq.e.lib.a.e.a {
    @Override // com.qq.e.lib.a.e.a
    public void a(int i4) {
        super.a(i4);
        this.f47356a.order(ByteOrder.BIG_ENDIAN);
    }

    public void c(int i4) {
        a((byte) (i4 & 255));
        a((byte) ((i4 >> 8) & 255));
        a((byte) ((i4 >> 16) & 255));
        a((byte) ((i4 >> 24) & 255));
    }

    public void d(int i4) {
        a((byte) ((i4 >> 24) & 255));
        a((byte) ((i4 >> 16) & 255));
        a((byte) ((i4 >> 8) & 255));
        a((byte) (i4 & 255));
    }
}
