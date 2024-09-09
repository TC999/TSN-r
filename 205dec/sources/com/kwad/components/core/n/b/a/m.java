package com.kwad.components.core.n.b.a;

import cn.jpush.android.local.JPushConstants;
import com.kwad.components.offline.api.core.network.IIdc;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m implements IIdc {
    @Override // com.kwad.components.offline.api.core.network.IIdc
    public final String hostForAPI(String str) {
        if (str.equals("api")) {
            return com.kwad.sdk.g.xV();
        }
        return JPushConstants.HTTPS_PRE + com.kwad.sdk.core.network.idc.a.DU().W(str, null);
    }
}
