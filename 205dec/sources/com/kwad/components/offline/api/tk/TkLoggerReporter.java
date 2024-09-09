package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.commercial.c;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class TkLoggerReporter {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class Holder {
        private static final TkLoggerReporter sInstance = new TkLoggerReporter();

        private Holder() {
        }
    }

    public static TkLoggerReporter get() {
        return Holder.sInstance;
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject, c cVar) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(cVar);
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.AJ().cu(str).i(0.1d).N("ad_tk_download_performance", "download_state").h(jSONObject));
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.AJ().cu(str).i(0.1d).k(0.001d).N("ad_tk_render_performance", "render_state").h(jSONObject));
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.AJ().cu(str).i(0.1d).N("ad_tk_so_download_event", "download_state").h(jSONObject));
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(c.AJ().cu(str).i(0.1d).N("ad_tk_so_load_performence", "download_state").h(jSONObject));
    }

    private TkLoggerReporter() {
    }
}
