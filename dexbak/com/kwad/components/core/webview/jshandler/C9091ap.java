package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.p289e.p293d.C8633e;
import com.kwad.components.core.p304n.p305a.p309d.p310a.C8699a;
import com.kwad.components.core.webview.p332a.C9012c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.ap */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9091ap implements InterfaceC10625a {
    private AdTemplate mAdTemplate;
    private Context mContext;

    public C9091ap(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9012c c9012c = new C9012c();
        if (this.mContext == null) {
            C9908c.m27297j(this.mAdTemplate, 2);
            interfaceC10627c.onError(-1, "context为空");
            return;
        }
        AdTemplate adTemplate = null;
        try {
            c9012c.parseJson(new JSONObject(str));
            AdTemplate adTemplate2 = this.mAdTemplate;
            try {
                int i = c9012c.f29034VN;
                if (i > 0) {
                    adTemplate2 = C10485c.m25663a(C8699a.m30005at(i), c9012c.f29031Jj);
                }
                if (adTemplate2 == null) {
                    C9908c.m27297j(this.mAdTemplate, 2);
                    interfaceC10627c.onError(-1, "adTemplate为空：" + c9012c.f29034VN);
                    return;
                }
                AdInfo m25641dQ = C10487e.m25641dQ(adTemplate2);
                if (!C10483a.m25969S(m25641dQ) && C8633e.m30101a(this.mContext, m25641dQ.adConversionInfo.smallAppJumpInfo.mediaSmallAppId, c9012c.f29032VL, c9012c.f29033VM, adTemplate2) == 1) {
                    interfaceC10627c.mo25251a(null);
                } else {
                    interfaceC10627c.onError(-1, "跳转失败");
                }
            } catch (Exception e) {
                e = e;
                adTemplate = adTemplate2;
                C9908c.m27297j(adTemplate, 2);
                interfaceC10627c.onError(-1, "解析失败");
                C10331c.printStackTrace(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "openWechatMiniProgram";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
