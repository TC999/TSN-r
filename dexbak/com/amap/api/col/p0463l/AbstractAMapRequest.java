package com.amap.api.col.p0463l;

import com.amap.api.col.p0463l.AbstractC1840if;
import com.amap.api.col.p0463l.Privacy;
import com.amap.api.maps.MapsInitializer;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.f2 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractAMapRequest extends AbstractC1840if {
    protected boolean isPostFlag = true;

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public Map<String, String> getParams() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] makeHttpRequest() throws AMapCoreException {
        ResponseEntity makeHttpRequestNeedHeader = makeHttpRequestNeedHeader();
        if (makeHttpRequestNeedHeader != null) {
            return makeHttpRequestNeedHeader.f5682a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ResponseEntity makeHttpRequestNeedHeader() throws AMapCoreException {
        if (MapFragmentDelegateImp.f3708f == null || Privacy.m54995a(MapFragmentDelegateImp.f3708f, C1732a3.m55691s()).f4676a == Privacy.EnumC1812c.SuccessCode) {
            setHttpProtocol(MapsInitializer.getProtocol() == 1 ? AbstractC1840if.EnumC1843c.HTTP : AbstractC1840if.EnumC1843c.HTTPS);
            NetManger.m53580p();
            if (this.isPostFlag) {
                return BaseNetManager.m54173d(this);
            }
            return NetManger.m53578r(this);
        }
        return null;
    }

    public byte[] makeHttpRequestWithInterrupted() throws AMapCoreException {
        setDegradeAbility(AbstractC1840if.EnumC1841a.INTERRUPT_IO);
        return makeHttpRequest();
    }
}
