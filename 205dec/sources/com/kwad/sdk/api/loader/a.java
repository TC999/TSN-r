package com.kwad.sdk.api.loader;

import java.io.File;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class C0681a {
        int alW;
        String alX;
        transient File alY;
        long interval;
        String md5;
        String sdkVersion;

        C0681a() {
        }

        public final boolean Aa() {
            return this.alW == 1;
        }

        public final boolean Ab() {
            return this.alW == -1;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.alW = jSONObject.optInt("dynamicType");
            this.alX = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString("md5");
            this.interval = jSONObject.optLong("interval");
            this.sdkVersion = jSONObject.optString("sdkVersion");
        }

        public final String toString() {
            return "Data{dynamicType=" + this.alW + ", dynamicUrl='" + this.alX + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.alY + '}';
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class b {
        long alZ;
        C0681a ama;
        String errorMsg;

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean Ac() {
            return this.alZ == 1 && this.ama != null;
        }

        public final void parseJson(JSONObject jSONObject) {
            this.alZ = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString("errorMsg");
            C0681a c0681a = new C0681a();
            this.ama = c0681a;
            c0681a.parseJson(jSONObject.optJSONObject("data"));
        }

        public final String toString() {
            return "UpdateData{result=" + this.alZ + ", errorMsg='" + this.errorMsg + "', data=" + this.ama + '}';
        }
    }
}
