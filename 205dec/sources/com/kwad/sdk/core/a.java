package com.kwad.sdk.core;

import android.text.TextUtils;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private ConcurrentHashMap<String, DownloadParams> aoS;
    private ConcurrentHashMap<String, AdTemplate> aoT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.sdk.core.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class C0687a {
        private static final a aoU = new a((byte) 0);
    }

    /* synthetic */ a(byte b4) {
        this();
    }

    public static a Bc() {
        return C0687a.aoU;
    }

    public final void a(String str, DownloadParams downloadParams) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.aoS.put(str, downloadParams);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    public final DownloadParams cT(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return null;
        }
        DownloadParams downloadParams = this.aoS.get(str);
        if (downloadParams != null) {
            return downloadParams;
        }
        String string = ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            DownloadParams downloadParams2 = new DownloadParams();
            try {
                downloadParams2.parseJson(new JSONObject(string));
                return downloadParams2;
            } catch (JSONException e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        }
        return null;
    }

    public final void cU(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.aoS.remove(str);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final AdTemplate cV(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return null;
        }
        AdTemplate adTemplate = this.aoT.get(str);
        if (adTemplate != null) {
            return adTemplate;
        }
        String string = ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            AdTemplate adTemplate2 = new AdTemplate();
            try {
                adTemplate2.parseJson(new JSONObject(string));
                return adTemplate2;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public final void cW(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.aoT.remove(str);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final void e(String str, AdTemplate adTemplate) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.aoT.put(str, adTemplate);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }

    private a() {
        this.aoS = new ConcurrentHashMap<>();
        this.aoT = new ConcurrentHashMap<>();
    }
}
