package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.p304n.p305a.p309d.InterfaceC8698a;
import com.kwad.components.core.p304n.p305a.p309d.InterfaceC8700b;
import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.offline.api.p341tk.model.BundleServiceConfig;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.widget.InterfaceC11147e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9295g {

    /* renamed from: Yt */
    private final Map<String, C9298a> f29341Yt = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.webview.tachikoma.g$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9298a {

        /* renamed from: YA */
        public List<InterfaceC9301b> f29347YA = new ArrayList();

        /* renamed from: Yy */
        public C9305i f29348Yy;

        /* renamed from: Yz */
        public boolean f29349Yz;

        C9298a(C9305i c9305i) {
            this.f29348Yy = c9305i;
        }

        /* renamed from: a */
        public final void m29086a(InterfaceC9301b interfaceC9301b) {
            if (interfaceC9301b != null) {
                this.f29347YA.add(interfaceC9301b);
            }
        }

        /* renamed from: aN */
        public final void m29085aN(final String str) {
            C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (InterfaceC9301b interfaceC9301b : C9298a.this.f29347YA) {
                        interfaceC9301b.onFailed(str);
                    }
                    C9298a.this.f29347YA.clear();
                }
            });
        }

        /* renamed from: sz */
        public final void m29084sz() {
            C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.g.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    for (InterfaceC9301b interfaceC9301b : C9298a.this.f29347YA) {
                        interfaceC9301b.onSuccess();
                    }
                    C9298a.this.f29347YA.clear();
                }
            });
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.g$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9301b {
        void onFailed(String str);

        void onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.webview.tachikoma.g$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9302c {

        /* renamed from: YD */
        private static final C9295g f29353YD = new C9295g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ai */
    public void m29090ai(Context context) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        C10331c.m26254d("KSAdTKBundleService", "begin load all services");
        SdkConfigData m26554Ca = C10251d.m26554Ca();
        if (context == null || (optJSONObject = m26554Ca.toJson().optJSONObject("appConfig")) == null || (optJSONArray = optJSONObject.optJSONArray("tkServiceConfigs")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            BundleServiceConfig bundleServiceConfig = new BundleServiceConfig();
            bundleServiceConfig.parseJson(optJSONArray.optJSONObject(i));
            if (bundleServiceConfig.loadType == 1) {
                m29089b(context, bundleServiceConfig.bundleName, null);
            }
        }
    }

    private static boolean isLocalDebugEnable() {
        C9861c.m27501f(DevelopMangerComponents.class);
        return false;
    }

    /* renamed from: sy */
    public static C9295g m29088sy() {
        return C9302c.f29353YD;
    }

    /* renamed from: b */
    public final void m29089b(Context context, String str, InterfaceC9301b interfaceC9301b) {
        if (isLocalDebugEnable()) {
            unloadBundle(str);
        }
        C10331c.m26254d("KSAdTKBundleService", "load bundle:" + str);
        if (TextUtils.isEmpty(str)) {
            C10331c.m26254d("KSAdTKBundleService", "load bundle fail: invalid bundle name");
            if (interfaceC9301b != null) {
                interfaceC9301b.onFailed("invalid bundle name");
                return;
            }
            return;
        }
        SdkConfigData m26554Ca = C10251d.m26554Ca();
        if (m26554Ca == null) {
            C10331c.m26254d("KSAdTKBundleService", "load bundle fail: config data empty");
            if (interfaceC9301b != null) {
                interfaceC9301b.onFailed("config data empty");
            }
        } else if (context == null) {
            C10331c.m26254d("KSAdTKBundleService", "load bundle fail: no context");
            if (interfaceC9301b != null) {
                interfaceC9301b.onFailed("no context");
            }
        } else {
            JSONObject optJSONObject = m26554Ca.toJson().optJSONObject("styleTemplatesConfig");
            StyleTemplate styleTemplate = null;
            JSONArray optJSONArray = optJSONObject == null ? null : optJSONObject.optJSONArray("styleTemplates");
            if (optJSONArray != null) {
                int i = 0;
                while (true) {
                    if (i >= optJSONArray.length()) {
                        break;
                    }
                    StyleTemplate styleTemplate2 = new StyleTemplate();
                    styleTemplate2.parseJson(optJSONArray.optJSONObject(i));
                    String str2 = styleTemplate2.templateId;
                    if (str2 != null && str2.equals(str)) {
                        styleTemplate = styleTemplate2;
                        break;
                    }
                    i++;
                }
            }
            if (isLocalDebugEnable() && styleTemplate == null) {
                styleTemplate = new StyleTemplate();
                styleTemplate.templateId = str;
            }
            if (styleTemplate == null) {
                C10331c.m26254d("KSAdTKBundleService", "load bundle fail: no bundle");
                if (interfaceC9301b != null) {
                    interfaceC9301b.onFailed("no bundle");
                    return;
                }
                return;
            }
            m29093a(context, styleTemplate, interfaceC9301b);
        }
    }

    public final void init() {
        try {
            InterfaceC8700b interfaceC8700b = (InterfaceC8700b) C9861c.m27501f(InterfaceC8700b.class);
            if (interfaceC8700b != null) {
                interfaceC8700b.mo28845a(new InterfaceC8698a() { // from class: com.kwad.components.core.webview.tachikoma.g.1
                    @Override // com.kwad.components.core.p304n.p305a.p309d.InterfaceC8698a
                    /* renamed from: a */
                    public final void mo29087a(int i, int i2, long j, long j2) {
                        C9295g.this.m29090ai(KsAdSDK.getContext());
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void unloadBundle(String str) {
        if (this.f29341Yt.get(str) != null) {
            C10331c.m26254d("KSAdTKBundleService", "unload bundle" + str);
            C9298a c9298a = this.f29341Yt.get(str);
            if (c9298a != null) {
                c9298a.f29348Yy.mo29029jp();
            }
            this.f29341Yt.remove(str);
        }
    }

    /* renamed from: a */
    public final void m29092a(Context context, String str, InterfaceC9301b interfaceC9301b) {
        if (TextUtils.isEmpty(str)) {
            interfaceC9301b.onFailed("invalid bundle string");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            StyleTemplate styleTemplate = new StyleTemplate();
            styleTemplate.parseJson(jSONObject);
            if (TextUtils.isEmpty(styleTemplate.templateId) || TextUtils.isEmpty(styleTemplate.templateUrl)) {
                interfaceC9301b.onFailed("invalid bundle:" + str);
            }
            m29093a(context, styleTemplate, interfaceC9301b);
        } catch (Throwable th) {
            interfaceC9301b.onFailed(th.getMessage());
        }
    }

    /* renamed from: a */
    private void m29093a(Context context, final StyleTemplate styleTemplate, InterfaceC9301b interfaceC9301b) {
        final String str = styleTemplate.templateId;
        C9298a c9298a = this.f29341Yt.get(str);
        if (c9298a != null) {
            if (c9298a.f29349Yz) {
                C10331c.m26254d("KSAdTKBundleService", "load bundle finish: already load");
                if (interfaceC9301b != null) {
                    interfaceC9301b.onSuccess();
                    return;
                }
                return;
            }
            c9298a.m29086a(interfaceC9301b);
            return;
        }
        C9305i c9305i = new C9305i(context, false);
        c9305i.m29054a("isService", Boolean.TRUE);
        final C9298a c9298a2 = new C9298a(c9305i);
        c9298a2.m29086a(interfaceC9301b);
        c9305i.m29060a(styleTemplate);
        c9305i.mo29075a((Activity) null, (AdResultData) null, new InterfaceC9339j() { // from class: com.kwad.components.core.webview.tachikoma.g.2
            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28991a(C9031a.C9033a c9033a) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28990a(C9109aw c9109aw) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
                C10331c.m26254d("KSAdTKBundleService", "load bundle fail: execute fail");
                c9298a2.m29085aN("execute fail");
                C9295g.this.unloadBundle(str);
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28988a(C9216o c9216o) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28987a(C9218p c9218p) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28986a(C9252m c9252m) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28985a(C9259t c9259t) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28984a(WebCloseStatus webCloseStatus) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28982a(@Nullable C10640a c10640a) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: b */
            public final void mo28981b(C9043ac.C9044a c9044a) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: bF */
            public final void mo28980bF() {
                C10331c.m26254d("KSAdTKBundleService", "load bundle success: done");
                C9298a c9298a3 = c9298a2;
                c9298a3.f29349Yz = true;
                c9298a3.m29084sz();
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: bG */
            public final void mo28979bG() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            public final FrameLayout getTKContainer() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            public final String getTKReaderScene() {
                return "tk_bundle_service";
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            public final String getTkTemplateId() {
                return styleTemplate.templateId;
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            public final InterfaceC11147e getTouchCoordsView() {
                return null;
            }
        });
        this.f29341Yt.put(str, c9298a2);
    }
}
