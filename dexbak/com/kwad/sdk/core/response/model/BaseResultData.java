package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.InterfaceC9866g;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p385a.InterfaceC9890e;
import com.kwad.sdk.core.response.p409b.C10488f;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11126t;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class BaseResultData implements InterfaceC9914b, Serializable {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public int result;
    public String testErrorMsg;

    public JSONObject baseToJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "llsid", this.llsid);
        C11126t.putValue(jSONObject, "extra", this.extra);
        C11126t.putValue(jSONObject, CommonNetImpl.RESULT, this.result);
        C11126t.putValue(jSONObject, "hasAd", this.hasAd);
        C11126t.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, this.errorMsg);
        C11126t.putValue(jSONObject, "testErrorMsg", this.testErrorMsg);
        C11126t.putValue(jSONObject, "cookie", this.cookie);
        return jSONObject;
    }

    public boolean hasData() {
        return this.hasAd;
    }

    public boolean isDataEmpty() {
        return false;
    }

    public boolean isResultOk() {
        return this.result == 1;
    }

    public boolean notifyFailOnResultError() {
        return true;
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong("llsid");
        this.result = jSONObject.optInt(CommonNetImpl.RESULT);
        this.hasAd = jSONObject.optBoolean("hasAd");
        this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        this.testErrorMsg = jSONObject.optString("testErrorMsg");
        String optString = jSONObject.optString("extra");
        if (!C11053bg.isNullString(optString)) {
            this.extra = ((InterfaceC9890e) C9861c.m27501f(InterfaceC9890e.class)).getResponseData(optString);
        }
        InterfaceC9866g interfaceC9866g = (InterfaceC9866g) C9861c.m27501f(InterfaceC9866g.class);
        if (interfaceC9866g != null) {
            interfaceC9866g.mo27497ak(jSONObject.optString("egid"));
            interfaceC9866g.mo27494x(jSONObject.optLong("gidExpireTimeMs"));
        }
        String optString2 = jSONObject.optString("cookie");
        this.cookie = optString2;
        if (TextUtils.isEmpty(optString2)) {
            return;
        }
        C10488f.m25622Fi().m25619eq(this.cookie);
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        return baseToJson();
    }
}
