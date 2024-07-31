package com.kwad.components.p208ad.reward;

import androidx.annotation.Nullable;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.sdk.C10756f;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11095g;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8076o {

    /* renamed from: com.kwad.components.ad.reward.o$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C8078a {
        private String errorMsg;

        /* renamed from: qs */
        private boolean f26935qs;

        public C8078a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.f26935qs = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f26935qs = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.f26935qs;
        }
    }

    /* renamed from: b */
    public static void m31642b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String m25893bO = C10483a.m25893bO(adInfo);
        C10331c.m26254d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + m25893bO);
        if (C11053bg.isNullString(m25893bO)) {
            return;
        }
        C11095g.execute(new Runnable() { // from class: com.kwad.components.ad.reward.o.1
            /* renamed from: D */
            private void m31641D(String str) {
                C8766a.m29888qi().m29893g(adTemplate, 1, str);
            }

            /* renamed from: go */
            private void m31640go() {
                C8766a.m29888qi().m29893g(adTemplate, 0, "success");
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C10415c doGet = C10756f.m24902xT().doGet(m25893bO, null);
                    if (doGet == null) {
                        m31641D("Network Error: url invalid");
                    } else if (doGet.code == 200) {
                        C8078a c8078a = new C8078a(doGet.avs);
                        if (c8078a.isValid()) {
                            m31640go();
                        } else {
                            m31641D(c8078a.errorMsg);
                        }
                    } else {
                        m31641D("Network Error: " + doGet.avs);
                    }
                } catch (Throwable th) {
                    m31641D("Request Error: " + th.getMessage());
                }
            }
        });
    }
}
