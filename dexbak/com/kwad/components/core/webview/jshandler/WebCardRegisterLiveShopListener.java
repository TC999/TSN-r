package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import java.io.Serializable;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class WebCardRegisterLiveShopListener implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29066VX;

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class AdLiveItemShopInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = -7621721959722008440L;
        public String price;
        public int status;
        public String title;
        public String url;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29066VX = interfaceC10627c;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerLiveShopListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29066VX = null;
    }

    /* renamed from: a */
    public final void m29344a(AdLiveShopInfo adLiveShopInfo) {
        if (this.f29066VX == null) {
            return;
        }
        AdLiveItemShopInfo adLiveItemShopInfo = new AdLiveItemShopInfo();
        adLiveItemShopInfo.status = adLiveShopInfo.status;
        adLiveItemShopInfo.title = adLiveShopInfo.title;
        adLiveItemShopInfo.url = adLiveShopInfo.url;
        adLiveItemShopInfo.price = adLiveShopInfo.price;
        this.f29066VX.mo25251a(adLiveItemShopInfo);
    }
}
