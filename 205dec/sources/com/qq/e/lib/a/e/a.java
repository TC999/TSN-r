package com.qq.e.lib.a.e;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    protected ByteBuffer f47356a;

    public a() {
        a(10240);
    }

    public void a(byte b4) {
        this.f47356a.put(b4);
    }

    public void b(int i4) {
        this.f47356a.position(i4 + a());
    }

    @Override // com.qq.e.lib.a.e.f
    public void close() {
    }

    public void a(byte[] bArr) {
        this.f47356a.put(bArr);
    }

    public byte[] b() {
        return this.f47356a.array();
    }

    public int a() {
        return this.f47356a.position();
    }

    public void a(int i4) {
        ByteBuffer byteBuffer = this.f47356a;
        if (byteBuffer == null || i4 > byteBuffer.capacity()) {
            ByteBuffer allocate = ByteBuffer.allocate(i4);
            this.f47356a = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.f47356a.clear();
    }
}
