package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.ft;
import com.amap.api.maps.MapsInitializer;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AbstractAMapRequest.java */
/* renamed from: com.amap.api.col.3l.f2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class f2 extends Cif {
    protected boolean isPostFlag = true;

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getParams() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] makeHttpRequest() throws fk {
        y6 makeHttpRequestNeedHeader = makeHttpRequestNeedHeader();
        if (makeHttpRequestNeedHeader != null) {
            return makeHttpRequestNeedHeader.f9524a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y6 makeHttpRequestNeedHeader() throws fk {
        if (c.f7290f == null || ft.a(c.f7290f, a3.s()).f8385a == ft.c.SuccessCode) {
            setHttpProtocol(MapsInitializer.getProtocol() == 1 ? Cif.c.HTTP : Cif.c.HTTPS);
            x6.p();
            if (this.isPostFlag) {
                return q6.d(this);
            }
            return x6.r(this);
        }
        return null;
    }

    public byte[] makeHttpRequestWithInterrupted() throws fk {
        setDegradeAbility(Cif.a.INTERRUPT_IO);
        return makeHttpRequest();
    }
}
