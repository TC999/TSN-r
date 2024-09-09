package com.bytedance.sdk.component.w.c.c.w;

import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.gd;
import com.bytedance.sdk.component.w.c.t;
import java.io.IOException;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements gd.c {

    /* renamed from: c  reason: collision with root package name */
    List<gd> f30403c;

    /* renamed from: w  reason: collision with root package name */
    t f30404w;
    int xv = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(List<gd> list, t tVar) {
        this.f30403c = list;
        this.f30404w = tVar;
    }

    @Override // com.bytedance.sdk.component.w.c.gd.c
    public t c() {
        return this.f30404w;
    }

    @Override // com.bytedance.sdk.component.w.c.gd.c
    public fp c(t tVar) throws IOException {
        this.f30404w = tVar;
        int i4 = this.xv + 1;
        this.xv = i4;
        return this.f30403c.get(i4).c(this);
    }
}
