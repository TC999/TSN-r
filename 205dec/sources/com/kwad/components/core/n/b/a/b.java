package com.kwad.components.core.n.b.a;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class b implements ICache {
    @Override // com.kwad.components.offline.api.core.api.ICache
    public final String getPreCacheUrl(String str) {
        return TextUtils.isEmpty(str) ? "" : com.kwad.components.core.video.j.f(ServiceProvider.getContext(), str);
    }
}
