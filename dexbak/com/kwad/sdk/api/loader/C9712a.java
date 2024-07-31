package com.kwad.sdk.api.loader;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.api.loader.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9712a {

    /* renamed from: com.kwad.sdk.api.loader.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9713a {
        int alW;
        String alX;
        transient File alY;
        long interval;
        String md5;
        String sdkVersion;

        C9713a() {
        }

        /* renamed from: Aa */
        public final boolean m27957Aa() {
            return this.alW == 1;
        }

        /* renamed from: Ab */
        public final boolean m27956Ab() {
            return this.alW == -1;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.alW = jSONObject.optInt("dynamicType");
            this.alX = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString("md5");
            this.interval = jSONObject.optLong(UMCommonContent.f37794aX);
            this.sdkVersion = jSONObject.optString("sdkVersion");
        }

        public final String toString() {
            return "Data{dynamicType=" + this.alW + ", dynamicUrl='" + this.alX + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.alY + '}';
        }
    }

    /* renamed from: com.kwad.sdk.api.loader.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9714b {
        long alZ;
        C9713a ama;
        String errorMsg;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: Ac */
        public final boolean m27955Ac() {
            return this.alZ == 1 && this.ama != null;
        }

        public final void parseJson(JSONObject jSONObject) {
            this.alZ = jSONObject.optLong(CommonNetImpl.RESULT);
            this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            C9713a c9713a = new C9713a();
            this.ama = c9713a;
            c9713a.parseJson(jSONObject.optJSONObject("data"));
        }

        public final String toString() {
            return "UpdateData{result=" + this.alZ + ", errorMsg='" + this.errorMsg + "', data=" + this.ama + '}';
        }
    }
}
