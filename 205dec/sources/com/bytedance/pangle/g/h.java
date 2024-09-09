package com.bytedance.pangle.g;

import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class h implements k {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f28793a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ByteBuffer byteBuffer) {
        this.f28793a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f28793a.capacity();
    }

    @Override // com.bytedance.pangle.g.k
    public final void a(j jVar, long j4, int i4) {
        ByteBuffer slice;
        synchronized (this.f28793a) {
            this.f28793a.position(0);
            int i5 = (int) j4;
            this.f28793a.limit(i4 + i5);
            this.f28793a.position(i5);
            slice = this.f28793a.slice();
        }
        jVar.a(slice);
    }
}
