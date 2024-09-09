package com.kwad.components.core.n.b.a;

import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.sdk.utils.bh;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n implements ISystemProperties {
    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final String get(String str, String str2) {
        return bh.get(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final boolean getBoolean(String str, boolean z3) {
        return bh.getBoolean(str, z3);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final int getInt(String str, int i4) {
        return bh.getInt(str, i4);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final long getLong(String str, long j4) {
        return bh.getLong(str, j4);
    }
}
