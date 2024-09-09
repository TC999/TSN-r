package com.kwad.components.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ak implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b Wf;
    private int Xr = 0;
    private a Xs;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void onAdShow();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class b extends com.kwad.sdk.core.report.a implements com.kwad.sdk.core.b {
        private String Jj;
        private String KG;
        private int Xt;
        private int actionType;
        private AdTemplate adTemplate;

        public final int getActionType() {
            return this.actionType;
        }

        public final String mM() {
            return this.Jj;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt("actionType");
            this.Xt = jSONObject.optInt("refreshType");
            this.KG = jSONObject.optString("payload");
            this.Jj = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            }
            if (this.adTemplate == null && jSONObject.has("adCacheId")) {
                this.adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.at(jSONObject.optInt("adCacheId")), this.Jj);
            }
        }

        public final String sp() {
            return this.KG;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionType", this.actionType);
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", this.KG);
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshType", this.Xt);
            com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.Jj);
            return jSONObject;
        }
    }

    public ak(com.kwad.sdk.core.webview.b bVar) {
        this.Wf = bVar;
    }

    private AdTemplate c(@NonNull b bVar) {
        if (bVar.adTemplate != null) {
            return bVar.adTemplate;
        }
        return this.Wf.cV(bVar.Jj);
    }

    public final void a(a aVar) {
        this.Xs = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.kwad.sdk.core.adlog.c.b bVar) {
    }

    protected void b(boolean z3, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.s.b.qY().a(adTemplate, null, bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "log";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            if (c(bVar) == null) {
                cVar.onError(-1, "native adTemplate is null");
            }
            a(bVar);
            cVar.a(null);
        } catch (JSONException e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
            cVar.onError(-1, e4.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SwitchIntDef"})
    public void a(@NonNull b bVar) {
        com.kwad.sdk.core.e.c.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.actionType);
        if (bVar.actionType == 1) {
            com.kwad.sdk.core.adlog.c.b dd = new com.kwad.sdk.core.adlog.c.b().dd(bVar.KG);
            a aVar = this.Xs;
            if (aVar != null) {
                aVar.onAdShow();
            }
            if (bVar.adTemplate != null) {
                dd.cO(this.Xr);
                b(true, bVar.adTemplate, null, dd);
            } else if (bg.isNullString(bVar.mM())) {
                b(true, this.Wf.getAdTemplate(), null, dd);
            } else {
                for (AdTemplate adTemplate : this.Wf.GM()) {
                    if (bg.isEquals(bVar.mM(), String.valueOf(com.kwad.sdk.core.response.b.e.ea(adTemplate)))) {
                        b(false, adTemplate, null, dd);
                        return;
                    }
                }
            }
        } else if (bVar.actionType == 2) {
            com.kwad.sdk.widget.e eVar = this.Wf.aDJ;
            com.kwad.sdk.core.adlog.c.b dd2 = new com.kwad.sdk.core.adlog.c.b().cO(this.Xr).dd(bVar.KG);
            if (eVar != null) {
                dd2.f(eVar.getTouchCoords());
            }
            a(dd2);
            com.kwad.sdk.core.adlog.c.a(c(bVar), dd2, this.Wf.mReportExtData);
        } else if (bVar.actionType == 12006) {
            com.kwad.components.core.o.a.qi().b(c(bVar), bVar.Xt, this.Xr);
        } else if (bVar.actionType == 140) {
            com.kwad.sdk.core.adlog.c.d(c(bVar), this.Wf.mReportExtData, new com.kwad.sdk.core.adlog.c.b().dd(bVar.KG));
        } else if (bVar.actionType == 141) {
            com.kwad.sdk.core.adlog.c.e(c(bVar), this.Wf.mReportExtData, new com.kwad.sdk.core.adlog.c.b().dd(bVar.KG));
        } else {
            com.kwad.sdk.core.adlog.c.a(c(bVar), bVar.actionType, this.Wf.mReportExtData, bVar.KG);
            com.kwad.components.core.webview.tachikoma.d.a.sY().aW(bVar.KG);
        }
    }
}
