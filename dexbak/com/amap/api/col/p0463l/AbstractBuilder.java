package com.amap.api.col.p0463l;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.amap.api.col.3l.c8 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractBuilder {

    /* renamed from: a */
    RobustFlatBufferBuilder f3746a;

    /* renamed from: b */
    private ByteBuffer f3747b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractBuilder(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        this.f3747b = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        this.f3746a = new RobustFlatBufferBuilder(this.f3747b);
    }

    /* renamed from: a */
    public final AbstractBuilder m55446a() {
        this.f3746a.m53703c(this.f3747b);
        return this;
    }
}
