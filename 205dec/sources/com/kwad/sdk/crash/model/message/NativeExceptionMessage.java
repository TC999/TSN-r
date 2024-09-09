package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class NativeExceptionMessage extends ExceptionMessage {
    private static final long serialVersionUID = -7790706181005700630L;
    public String mFingerprint = "Unknown";
    public String mRevision = "Unknown";
    public String mRegister = "Unknown";
    public String mSignal = "Unknown";
    public String mCode = "Unknown";
    public String mManuallyKill = "Unknown";
    public String mFaultAddr = "Unknown";
    public String mAbortMsg = "";

    public NativeExceptionMessage() {
        this.mExceptionType = 4;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    protected final String getTypePrefix() {
        return "NATIVE_";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mFingerprint = jSONObject.optString("mFingerprint");
        this.mRevision = jSONObject.optString("mRevision");
        this.mRegister = jSONObject.optString("mRegister");
        this.mSignal = jSONObject.optString("mSignal");
        this.mCode = jSONObject.optString("mCode");
        this.mManuallyKill = jSONObject.optString("mManuallyKill");
        this.mFaultAddr = jSONObject.optString("mFaultAddr");
        this.mAbortMsg = jSONObject.optString("mAbortMsg");
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = super.toJson();
        t.putValue(json, "mFingerprint", this.mFingerprint);
        t.putValue(json, "mRevision", this.mRevision);
        t.putValue(json, "mRegister", this.mRegister);
        t.putValue(json, "mSignal", this.mSignal);
        t.putValue(json, "mCode", this.mCode);
        t.putValue(json, "mManuallyKill", this.mManuallyKill);
        t.putValue(json, "mFaultAddr", this.mFaultAddr);
        t.putValue(json, "mAbortMsg", this.mAbortMsg);
        return json;
    }
}
