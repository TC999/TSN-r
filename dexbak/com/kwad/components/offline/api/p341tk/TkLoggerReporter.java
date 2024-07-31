package com.kwad.components.offline.api.p341tk;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.commercial.C9821c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.offline.api.tk.TkLoggerReporter */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class TkLoggerReporter {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.offline.api.tk.TkLoggerReporter$Holder */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class Holder {
        private static final TkLoggerReporter sInstance = new TkLoggerReporter();

        private Holder() {
        }
    }

    public static TkLoggerReporter get() {
        return Holder.sInstance;
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject, C9821c c9821c) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c9821c);
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(C9821c.m27636AJ().m27631cu(str).m27628i(0.1d).m27635N("ad_tk_download_performance", "download_state").m27629h(jSONObject));
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(C9821c.m27636AJ().m27631cu(str).m27628i(0.1d).m27626k(0.001d).m27635N("ad_tk_render_performance", "render_state").m27629h(jSONObject));
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(C9821c.m27636AJ().m27631cu(str).m27628i(0.1d).m27635N("ad_tk_so_download_event", "download_state").m27629h(jSONObject));
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(C9821c.m27636AJ().m27631cu(str).m27628i(0.1d).m27635N("ad_tk_so_load_performence", "download_state").m27629h(jSONObject));
    }

    private TkLoggerReporter() {
    }
}
