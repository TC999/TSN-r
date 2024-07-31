package com.kwad.sdk.collector.p370a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.core.network.AbstractC10418d;
import com.kwad.sdk.utils.C11126t;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.collector.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9782a extends AbstractC10418d {
    private C9783a anF;

    /* renamed from: com.kwad.sdk.collector.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9783a {
        private List<String> anG;

        public C9783a(List<String> list) {
            this.anG = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, TTDownloadField.TT_PACKAGE_NAME, this.anG);
            return jSONObject;
        }
    }

    public C9782a(List<String> list) {
        C9783a c9783a = new C9783a(list);
        this.anF = c9783a;
        putBody("targetAppInfo", c9783a.toJson());
        putBody("sdkVersion", BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final String getUrl() {
        return C10760g.m24886ye();
    }
}
