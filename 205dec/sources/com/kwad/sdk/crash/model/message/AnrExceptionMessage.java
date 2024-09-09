package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class AnrExceptionMessage extends ExceptionMessage {
    private static final long serialVersionUID = 2116476830162477947L;
    public String mReason = "";
    public String mMessageQueueDetail = "";
    public String mThreadDetail = "";
    public String mThreadStatus = "";
    public int mIndex = -1;

    public AnrExceptionMessage() {
        this.mExceptionType = 3;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    protected final String getTypePrefix() {
        return "ANR_";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mReason = jSONObject.optString("mReason");
        this.mMessageQueueDetail = jSONObject.optString("mMessageQueueDetail");
        this.mThreadDetail = jSONObject.optString("mThreadDetail");
        this.mThreadStatus = jSONObject.optString("mThreadStatus");
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = super.toJson();
        t.putValue(json, "mReason", this.mReason);
        t.putValue(json, "mMessageQueueDetail", this.mMessageQueueDetail);
        t.putValue(json, "mThreadDetail", this.mThreadDetail);
        t.putValue(json, "mThreadStatus", this.mThreadStatus);
        return json;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        try {
            if (!TextUtils.isEmpty(this.mReason)) {
                sb.append("ANR \u539f\u56e0:\n");
                sb.append(this.mReason);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mThreadStatus)) {
                sb.append("\u7ebf\u7a0b\u72b6\u6001: \n");
                sb.append(this.mThreadStatus);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mThreadDetail)) {
                sb.append("\u7ebf\u7a0b\u72b6\u6001: \n");
                sb.append(this.mThreadDetail);
                sb.append("\n");
            }
            if (!TextUtils.isEmpty(this.mMessageQueueDetail)) {
                sb.append("\u6d88\u606f\u961f\u5217: \n");
                sb.append(this.mMessageQueueDetail);
                sb.append("\n");
            }
        } catch (Exception e4) {
            c.printStackTraceOnly(e4);
        }
        return sb.substring(0);
    }
}
