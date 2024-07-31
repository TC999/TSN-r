package com.kwad.components.core.p304n.p311b.p312a;

import android.text.TextUtils;
import com.kwad.components.core.video.C9000j;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.core.n.b.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C8705b implements ICache {
    @Override // com.kwad.components.offline.api.core.api.ICache
    public final String getPreCacheUrl(String str) {
        return TextUtils.isEmpty(str) ? "" : C9000j.m29406f(ServiceProvider.getContext(), str);
    }
}
