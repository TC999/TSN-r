package com.beizi.fusion.p073sm.p074a.p075a;

import com.beizi.fusion.p073sm.p074a.IGetter;
import com.beizi.fusion.p073sm.p074a.IOAID;
import com.beizi.fusion.p073sm.p074a.OAIDException;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* renamed from: com.beizi.fusion.sm.a.a.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class DefaultImpl implements IOAID {
    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public void mo48131a(IGetter iGetter) {
        if (iGetter == null) {
            return;
        }
        iGetter.mo48134a(new OAIDException(RtspHeaders.Names.UNSUPPORTED));
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public boolean mo48132a() {
        return false;
    }
}
