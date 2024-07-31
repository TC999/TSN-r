package com.kwad.components.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p304n.p305a.p309d.p310a.C8699a;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p330s.C8934b;
import com.kwad.components.core.webview.tachikoma.p336d.C9279a;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.report.C10443a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11126t;
import com.kwad.sdk.widget.InterfaceC11147e;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.ak */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9072ak implements InterfaceC10625a {

    /* renamed from: Wf */
    private final C10605b f29153Wf;

    /* renamed from: Xr */
    private int f29154Xr = 0;

    /* renamed from: Xs */
    private InterfaceC9073a f29155Xs;

    /* renamed from: com.kwad.components.core.webview.jshandler.ak$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9073a {
        void onAdShow();
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.ak$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9074b extends C10443a implements InterfaceC9914b {

        /* renamed from: Jj */
        private String f29156Jj;

        /* renamed from: KG */
        private String f29157KG;

        /* renamed from: Xt */
        private int f29158Xt;
        private int actionType;
        private AdTemplate adTemplate;

        public final int getActionType() {
            return this.actionType;
        }

        /* renamed from: mM */
        public final String m29298mM() {
            return this.f29156Jj;
        }

        @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt("actionType");
            this.f29158Xt = jSONObject.optInt("refreshType");
            this.f29157KG = jSONObject.optString("payload");
            this.f29156Jj = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
            if (this.adTemplate == null && jSONObject.has("adCacheId")) {
                this.adTemplate = C10485c.m25663a(C8699a.m30005at(jSONObject.optInt("adCacheId")), this.f29156Jj);
            }
        }

        /* renamed from: sp */
        public final String m29297sp() {
            return this.f29157KG;
        }

        @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "actionType", this.actionType);
            C11126t.putValue(jSONObject, "payload", this.f29157KG);
            C11126t.putValue(jSONObject, "refreshType", this.f29158Xt);
            C11126t.m23678a(jSONObject, "adTemplate", this.adTemplate);
            C11126t.putValue(jSONObject, "creativeId", this.f29156Jj);
            return jSONObject;
        }
    }

    public C9072ak(C10605b c10605b) {
        this.f29153Wf = c10605b;
    }

    /* renamed from: c */
    private AdTemplate m29304c(@NonNull C9074b c9074b) {
        if (c9074b.adTemplate != null) {
            return c9074b.adTemplate;
        }
        return this.f29153Wf.m25324cV(c9074b.f29156Jj);
    }

    /* renamed from: a */
    public final void m29308a(InterfaceC9073a interfaceC9073a) {
        this.f29155Xs = interfaceC9073a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29306a(C9913b c9913b) {
    }

    /* renamed from: b */
    protected void mo29305b(boolean z, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable C9913b c9913b) {
        C8934b.m29570qY().m29571a(adTemplate, null, c9913b);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "log";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            C9074b c9074b = new C9074b();
            c9074b.parseJson(new JSONObject(str));
            if (m29304c(c9074b) == null) {
                interfaceC10627c.onError(-1, "native adTemplate is null");
            }
            mo29307a(c9074b);
            interfaceC10627c.mo25251a(null);
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
            interfaceC10627c.onError(-1, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SwitchIntDef"})
    /* renamed from: a */
    public void mo29307a(@NonNull C9074b c9074b) {
        C10331c.m26254d("WebCardLogHandler", "handleH5Log actionType actionType" + c9074b.actionType);
        if (c9074b.actionType == 1) {
            C9913b m27251dd = new C9913b().m27251dd(c9074b.f29157KG);
            InterfaceC9073a interfaceC9073a = this.f29155Xs;
            if (interfaceC9073a != null) {
                interfaceC9073a.onAdShow();
            }
            if (c9074b.adTemplate != null) {
                m27251dd.m27262cO(this.f29154Xr);
                mo29305b(true, c9074b.adTemplate, null, m27251dd);
            } else if (C11053bg.isNullString(c9074b.m29298mM())) {
                mo29305b(true, this.f29153Wf.getAdTemplate(), null, m27251dd);
            } else {
                for (AdTemplate adTemplate : this.f29153Wf.m25326GM()) {
                    if (C11053bg.isEquals(c9074b.m29298mM(), String.valueOf(C10487e.m25631ea(adTemplate)))) {
                        mo29305b(false, adTemplate, null, m27251dd);
                        return;
                    }
                }
            }
        } else if (c9074b.actionType == 2) {
            InterfaceC11147e interfaceC11147e = this.f29153Wf.aDJ;
            C9913b m27251dd2 = new C9913b().m27262cO(this.f29154Xr).m27251dd(c9074b.f29157KG);
            if (interfaceC11147e != null) {
                m27251dd2.m27247f(interfaceC11147e.getTouchCoords());
            }
            mo29306a(m27251dd2);
            C9908c.m27340a(m29304c(c9074b), m27251dd2, this.f29153Wf.mReportExtData);
        } else if (c9074b.actionType == 12006) {
            C8766a.m29888qi().m29903b(m29304c(c9074b), c9074b.f29158Xt, this.f29154Xr);
        } else if (c9074b.actionType == 140) {
            C9908c.m27309d(m29304c(c9074b), this.f29153Wf.mReportExtData, new C9913b().m27251dd(c9074b.f29157KG));
        } else if (c9074b.actionType == 141) {
            C9908c.m27306e(m29304c(c9074b), this.f29153Wf.mReportExtData, new C9913b().m27251dd(c9074b.f29157KG));
        } else {
            C9908c.m27347a(m29304c(c9074b), c9074b.actionType, this.f29153Wf.mReportExtData, c9074b.f29157KG);
            C9279a.m29119sY().m29120aW(c9074b.f29157KG);
        }
    }
}
