package com.kwad.sdk.core;

import android.text.TextUtils;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9882a {
    private ConcurrentHashMap<String, DownloadParams> aoS;
    private ConcurrentHashMap<String, AdTemplate> aoT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9883a {
        private static final C9882a aoU = new C9882a((byte) 0);
    }

    /* synthetic */ C9882a(byte b) {
        this();
    }

    /* renamed from: Bc */
    public static C9882a m27460Bc() {
        return C9883a.aoU;
    }

    /* renamed from: a */
    public final void m27459a(String str, DownloadParams downloadParams) {
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext() == null) {
            return;
        }
        this.aoS.put(str, downloadParams);
        ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    /* renamed from: cT */
    public final DownloadParams m27458cT(String str) {
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext() == null) {
            return null;
        }
        DownloadParams downloadParams = this.aoS.get(str);
        if (downloadParams != null) {
            return downloadParams;
        }
        String string = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            DownloadParams downloadParams2 = new DownloadParams();
            try {
                downloadParams2.parseJson(new JSONObject(string));
                return downloadParams2;
            } catch (JSONException e) {
                C10331c.printStackTrace(e);
            }
        }
        return null;
    }

    /* renamed from: cU */
    public final void m27457cU(String str) {
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext() == null) {
            return;
        }
        this.aoS.remove(str);
        ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    /* renamed from: cV */
    public final AdTemplate m27456cV(String str) {
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext() == null) {
            return null;
        }
        AdTemplate adTemplate = this.aoT.get(str);
        if (adTemplate != null) {
            return adTemplate;
        }
        String string = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            AdTemplate adTemplate2 = new AdTemplate();
            try {
                adTemplate2.parseJson(new JSONObject(string));
                return adTemplate2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: cW */
    public final void m27455cW(String str) {
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext() == null) {
            return;
        }
        this.aoT.remove(str);
        ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    /* renamed from: e */
    public final void m27454e(String str, AdTemplate adTemplate) {
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext() == null) {
            return;
        }
        this.aoT.put(str, adTemplate);
        ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }

    private C9882a() {
        this.aoS = new ConcurrentHashMap<>();
        this.aoT = new ConcurrentHashMap<>();
    }
}
