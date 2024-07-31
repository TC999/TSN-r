package com.bytedance.pangle.p123g;

import java.nio.ByteBuffer;

/* renamed from: com.bytedance.pangle.g.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
final class C6146h implements InterfaceC6149k {

    /* renamed from: a */
    private final ByteBuffer f22032a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6146h(ByteBuffer byteBuffer) {
        this.f22032a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.p123g.InterfaceC6149k
    /* renamed from: a */
    public final long mo37099a() {
        return this.f22032a.capacity();
    }

    @Override // com.bytedance.pangle.p123g.InterfaceC6149k
    /* renamed from: a */
    public final void mo37098a(InterfaceC6148j interfaceC6148j, long j, int i) {
        ByteBuffer slice;
        synchronized (this.f22032a) {
            this.f22032a.position(0);
            int i2 = (int) j;
            this.f22032a.limit(i + i2);
            this.f22032a.position(i2);
            slice = this.f22032a.slice();
        }
        interfaceC6148j.mo37100a(slice);
    }
}
