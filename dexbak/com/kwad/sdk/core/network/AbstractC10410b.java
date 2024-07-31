package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.components.C9865f;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p385a.C9889d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p409b.C10488f;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11060bj;
import com.kwad.sdk.utils.C11126t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.network.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10410b implements InterfaceC10420f {
    private final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC10410b() {
        try {
            onCreate();
            buildBaseHeader();
            buildBaseBody();
            if (encryptDisable()) {
                addHeader("x-ksad-ignore-decrypt", "true");
            }
            addHeader("cookie", C10488f.m25622Fi().m25621Fj());
            C9889d.m27428f(getHeader());
            addHeader("User-Agent", C10440p.getUserAgent());
            addHeader("BrowserUa", C10440p.m26067DP());
            addHeader("SystemUa", C10440p.m26068DO());
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
        return C9865f.encryptDisable();
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10420f
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
        C11126t.putValue(jSONObject, ConstantHelper.LOG_VS, interfaceC10968f.getSDKVersion());
        if (!TextUtils.isEmpty(C11060bj.getAppId())) {
            C11126t.putValue(jSONObject, "appId", C11060bj.getAppId());
        } else {
            C11126t.putValue(jSONObject, "appId", interfaceC10968f.getAppId());
        }
        C11126t.putValue(jSONObject, "message", C9889d.m27429al(getBodyParamsString()));
        C9889d.m27430a(getUrl(), getHeader(), jSONObject.toString());
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10420f
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

    @Override // com.kwad.sdk.core.network.InterfaceC10420f
    public Map<String, String> getHeader() {
        return this.mHeader;
    }

    protected String getRequestHost() {
        return C10760g.m24895xV();
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10420f
    @Nullable
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.InterfaceC10420f
    public abstract String getUrl();

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate() {
    }

    public void putBody(String str, String str2) {
        C11126t.putValue(this.mBodyParams, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            C10331c.printStackTrace(th);
        }
    }

    public void putBody(String str, double d) {
        C11126t.putValue(this.mBodyParams, str, d);
    }

    public void putBody(String str, int i) {
        C11126t.putValue(this.mBodyParams, str, i);
    }

    public void putBody(String str, float f) {
        C11126t.putValue(this.mBodyParams, str, f);
    }

    public void putBody(String str, byte b) {
        C11126t.putValue(this.mBodyParams, str, b);
    }

    public void putBody(String str, long j) {
        C11126t.putValue(this.mBodyParams, str, j);
    }

    public void putBody(String str, boolean z) {
        C11126t.putValue(this.mBodyParams, str, z);
    }

    public void putBody(String str, JSONObject jSONObject) {
        C11126t.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, JSONArray jSONArray) {
        C11126t.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, InterfaceC9914b interfaceC9914b) {
        C11126t.m23678a(this.mBodyParams, str, interfaceC9914b);
    }

    public void putBody(String str, List<? extends InterfaceC9914b> list) {
        C11126t.putValue(this.mBodyParams, str, list);
    }
}
