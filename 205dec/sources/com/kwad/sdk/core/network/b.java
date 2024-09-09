package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b implements f {
    private final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        try {
            onCreate();
            buildBaseHeader();
            buildBaseBody();
            if (encryptDisable()) {
                addHeader("x-ksad-ignore-decrypt", "true");
            }
            addHeader("cookie", com.kwad.sdk.core.response.b.f.Fi().Fj());
            com.kwad.sdk.core.a.d.f(getHeader());
            addHeader("User-Agent", p.getUserAgent());
            addHeader("BrowserUa", p.DP());
            addHeader("SystemUa", p.DO());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    public void addHeader(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mHeader.put(str, str2);
    }

    protected abstract void buildBaseBody();

    protected abstract void buildBaseHeader();

    protected boolean enableCrashReport() {
        return true;
    }

    public boolean encryptDisable() {
        return com.kwad.sdk.components.f.encryptDisable();
    }

    @Override // com.kwad.sdk.core.network.f
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        t.putValue(jSONObject, "version", fVar.getSDKVersion());
        if (!TextUtils.isEmpty(bj.getAppId())) {
            t.putValue(jSONObject, "appId", bj.getAppId());
        } else {
            t.putValue(jSONObject, "appId", fVar.getAppId());
        }
        t.putValue(jSONObject, "message", com.kwad.sdk.core.a.d.al(getBodyParamsString()));
        com.kwad.sdk.core.a.d.a(getUrl(), getHeader(), jSONObject.toString());
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getBodyMap() {
        return null;
    }

    public JSONObject getBodyParams() {
        return this.mBodyParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getBodyParamsString() {
        return this.mBodyParams.toString();
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getHeader() {
        return this.mHeader;
    }

    protected String getRequestHost() {
        return com.kwad.sdk.g.xV();
    }

    @Override // com.kwad.sdk.core.network.f
    @Nullable
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.f
    public abstract String getUrl();

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate() {
    }

    public void putBody(String str, String str2) {
        t.putValue(this.mBodyParams, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    public void putBody(String str, double d4) {
        t.putValue(this.mBodyParams, str, d4);
    }

    public void putBody(String str, int i4) {
        t.putValue(this.mBodyParams, str, i4);
    }

    public void putBody(String str, float f4) {
        t.putValue(this.mBodyParams, str, f4);
    }

    public void putBody(String str, byte b4) {
        t.putValue(this.mBodyParams, str, b4);
    }

    public void putBody(String str, long j4) {
        t.putValue(this.mBodyParams, str, j4);
    }

    public void putBody(String str, boolean z3) {
        t.putValue(this.mBodyParams, str, z3);
    }

    public void putBody(String str, JSONObject jSONObject) {
        t.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, JSONArray jSONArray) {
        t.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, com.kwad.sdk.core.b bVar) {
        t.a(this.mBodyParams, str, bVar);
    }

    public void putBody(String str, List<? extends com.kwad.sdk.core.b> list) {
        t.putValue(this.mBodyParams, str, list);
    }
}
