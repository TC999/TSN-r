package com.amap.api.col.p0463l;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.amap.api.col.3l.i7 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ByteJoinDataStrategy extends UpdateDataStrategy {

    /* renamed from: c */
    ByteArrayOutputStream f4509c;

    public ByteJoinDataStrategy() {
        this.f4509c = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.p0463l.UpdateDataStrategy
    /* renamed from: b */
    protected final byte[] mo54164b(byte[] bArr) {
        byte[] byteArray = this.f4509c.toByteArray();
        try {
            this.f4509c.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f4509c = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.p0463l.UpdateDataStrategy
    /* renamed from: c */
    public final void mo54362c(byte[] bArr) {
        try {
            this.f4509c.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ByteJoinDataStrategy(UpdateDataStrategy updateDataStrategy) {
        super(updateDataStrategy);
        this.f4509c = new ByteArrayOutputStream();
    }
}
