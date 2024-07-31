package com.amap.api.col.p0463l;

import java.nio.ByteBuffer;

/* renamed from: com.amap.api.col.3l.e8 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RobustFlatBufferBuilder extends FlatBufferBuilder {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RobustFlatBufferBuilder(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override // com.amap.api.col.p0463l.FlatBufferBuilder
    /* renamed from: b */
    public final int mo53704b(CharSequence charSequence) {
        try {
            return super.mo53704b(charSequence);
        } catch (Throwable th) {
            ALLog.m54456a(th);
            return super.mo53704b("");
        }
    }
}
