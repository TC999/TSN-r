package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class o {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private String errorMsg;
        private boolean qs;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.qs = false;
                this.errorMsg = "\u6570\u636e\u89e3\u6790\u5931\u8d25";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.qs = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.qs;
        }
    }

    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String bO = com.kwad.sdk.core.response.b.a.bO(adInfo);
        com.kwad.sdk.core.e.c.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + bO);
        if (bg.isNullString(bO)) {
            return;
        }
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.reward.o.1
            private void D(String str) {
                com.kwad.components.core.o.a.qi().g(adTemplate, 1, str);
            }

            private void go() {
                com.kwad.components.core.o.a.qi().g(adTemplate, 0, "success");
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.core.network.c doGet = com.kwad.sdk.f.xT().doGet(bO, null);
                    if (doGet == null) {
                        D("Network Error: url invalid");
                    } else if (doGet.code == 200) {
                        a aVar = new a(doGet.avs);
                        if (aVar.isValid()) {
                            go();
                        } else {
                            D(aVar.errorMsg);
                        }
                    } else {
                        D("Network Error: " + doGet.avs);
                    }
                } catch (Throwable th) {
                    D("Request Error: " + th.getMessage());
                }
            }
        });
    }
}
