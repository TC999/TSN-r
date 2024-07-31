package com.kwad.sdk.core.request.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11060bj;
import com.kwad.sdk.utils.C11081e;
import com.kwad.sdk.utils.C11102k;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.model.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10474a implements InterfaceC9914b {
    private static JSONObject azc;
    private String appId;
    private String azd;
    private String name;
    private String packageName;
    private String version;

    /* renamed from: EY */
    public static JSONObject m25996EY() {
        if (!m25994l(azc)) {
            azc = m25995EZ().toJson();
        }
        return azc;
    }

    /* renamed from: EZ */
    public static C10474a m25995EZ() {
        C10474a c10474a = new C10474a();
        try {
            c10474a.appId = ServiceProvider.m24362KP().appId;
            c10474a.name = ServiceProvider.m24362KP().appName;
            c10474a.packageName = ServiceProvider.m24363KO().getPackageName();
            c10474a.version = C11102k.m23780bQ(ServiceProvider.m24363KO());
            c10474a.azd = C11081e.m23831bG(ServiceProvider.m24363KO());
            if (!TextUtils.isEmpty(C11060bj.getAppId())) {
                c10474a.appId = C11060bj.getAppId();
            }
            if (!TextUtils.isEmpty(C11060bj.getPackageName())) {
                c10474a.packageName = C11060bj.getPackageName();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return c10474a;
    }

    /* renamed from: l */
    private static boolean m25994l(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("name");
        return !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && optString.equals(ServiceProvider.m24362KP().appId) && optString2.equals(ServiceProvider.m24362KP().appName);
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "appId", this.appId);
        C11126t.putValue(jSONObject, "name", this.name);
        C11126t.putValue(jSONObject, TTDownloadField.TT_PACKAGE_NAME, this.packageName);
        C11126t.putValue(jSONObject, ConstantHelper.LOG_VS, this.version);
        C11126t.putValue(jSONObject, "sha1", this.azd);
        return jSONObject;
    }
}
