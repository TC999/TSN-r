package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class WebCardRegisterLiveMessageListener implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29065VX;

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class AdLiveMessageInfoList extends C10482a implements Serializable {
        private static final long serialVersionUID = -9127181276274466179L;
        public List<AdLiveMessageItemInfo> adLiveMessageInfos;

        @KsJson
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static final class AdLiveMessageItemInfo extends C10482a implements Serializable {
            private static final long serialVersionUID = 1943278809007082732L;
            public String content;
            public String userName;
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C10331c.m26254d("TAGGG", "recive CallBack ");
        this.f29065VX = interfaceC10627c;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerLiveMessageListener";
    }

    /* renamed from: n */
    public final void m29345n(List<AdLiveMessageInfo> list) {
        C10331c.m26254d("TAGGG", "size " + list.size());
        if (this.f29065VX == null) {
            return;
        }
        AdLiveMessageInfoList adLiveMessageInfoList = new AdLiveMessageInfoList();
        adLiveMessageInfoList.adLiveMessageInfos = new ArrayList();
        for (AdLiveMessageInfo adLiveMessageInfo : list) {
            AdLiveMessageInfoList.AdLiveMessageItemInfo adLiveMessageItemInfo = new AdLiveMessageInfoList.AdLiveMessageItemInfo();
            adLiveMessageItemInfo.userName = adLiveMessageInfo.userName;
            adLiveMessageItemInfo.content = adLiveMessageInfo.content;
            adLiveMessageInfoList.adLiveMessageInfos.add(adLiveMessageItemInfo);
        }
        C10331c.m26254d("TAGGG", "size " + adLiveMessageInfoList.toJson().toString());
        this.f29065VX.mo25251a(adLiveMessageInfoList);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29065VX = null;
    }
}
