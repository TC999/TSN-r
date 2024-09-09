package com.kwad.components.core.liveEnd;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.core.network.b;
import com.kwad.sdk.utils.ar;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends b {
    private IAdLiveEndRequest ga;

    public a(IAdLiveEndRequest iAdLiveEndRequest) {
        this.ga = iAdLiveEndRequest;
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.ga.getBodyMap();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getHeader() {
        IAdLiveEndRequest iAdLiveEndRequest = this.ga;
        if (iAdLiveEndRequest != null && iAdLiveEndRequest.getHeader() != null && this.ga.getHeader().size() > 0) {
            for (String str : this.ga.getHeader().keySet()) {
                if (!TextUtils.isEmpty(this.ga.getHeader().get(str))) {
                    addHeader(str, this.ga.getHeader().get(str));
                }
            }
            return super.getHeader();
        }
        return super.getHeader();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return ar.appendUrl(this.ga.getUrl(), this.ga.getUrlParam());
    }
}
