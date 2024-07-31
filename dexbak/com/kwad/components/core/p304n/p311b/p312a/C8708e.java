package com.kwad.components.core.p304n.p311b.p312a;

import com.kwad.components.core.p289e.p291b.C8596a;
import com.kwad.components.offline.api.core.api.IFlowUuid;
import com.kwad.sdk.core.p397e.C10331c;

/* renamed from: com.kwad.components.core.n.b.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8708e implements IFlowUuid {
    @Override // com.kwad.components.offline.api.core.api.IFlowUuid
    public final long decryptLongFromBase64(String str) {
        try {
            return C8596a.m30287ac(str);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            return 0L;
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IFlowUuid
    public final String encryptLongToBase64(long j) {
        try {
            return C8596a.m30285t(j);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            return null;
        }
    }
}
