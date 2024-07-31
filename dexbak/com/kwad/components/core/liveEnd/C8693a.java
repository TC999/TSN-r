package com.kwad.components.core.liveEnd;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.core.network.AbstractC10410b;
import com.kwad.sdk.utils.C11025ar;
import java.util.Map;

/* renamed from: com.kwad.components.core.liveEnd.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8693a extends AbstractC10410b {

    /* renamed from: ga */
    private IAdLiveEndRequest f28362ga;

    public C8693a(IAdLiveEndRequest iAdLiveEndRequest) {
        this.f28362ga = iAdLiveEndRequest;
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final Map<String, String> getBodyMap() {
        return this.f28362ga.getBodyMap();
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final Map<String, String> getHeader() {
        IAdLiveEndRequest iAdLiveEndRequest = this.f28362ga;
        if (iAdLiveEndRequest != null && iAdLiveEndRequest.getHeader() != null && this.f28362ga.getHeader().size() > 0) {
            for (String str : this.f28362ga.getHeader().keySet()) {
                if (!TextUtils.isEmpty(this.f28362ga.getHeader().get(str))) {
                    addHeader(str, this.f28362ga.getHeader().get(str));
                }
            }
            return super.getHeader();
        }
        return super.getHeader();
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final String getUrl() {
        return C11025ar.appendUrl(this.f28362ga.getUrl(), this.f28362ga.getUrlParam());
    }
}
