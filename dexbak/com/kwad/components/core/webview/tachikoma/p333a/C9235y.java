package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.y */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9235y implements InterfaceC10625a {
    private InterfaceC9237a aab;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.y$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9237a {
        /* renamed from: a */
        void mo29167a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo);
    }

    public C9235y(InterfaceC9237a interfaceC9237a) {
        this.aab = interfaceC9237a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "updateLiveCurrentShopInfo";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            C10331c.m26254d("UpdateLiveCurrentShopInfoHandler", "handleJsCall: " + str);
            final TKAdLiveShopItemInfo tKAdLiveShopItemInfo = new TKAdLiveShopItemInfo();
            tKAdLiveShopItemInfo.parseJson(new JSONObject(str));
            C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.a.y.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (C9235y.this.aab != null) {
                        C9235y.this.aab.mo29167a(tKAdLiveShopItemInfo);
                    }
                }
            });
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }
}
