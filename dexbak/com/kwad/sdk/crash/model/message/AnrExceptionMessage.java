package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11126t;
import com.snail.antifake.deviceid.ShellAdbUtils;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
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

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.InterfaceC9914b
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

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject json = super.toJson();
        C11126t.putValue(json, "mReason", this.mReason);
        C11126t.putValue(json, "mMessageQueueDetail", this.mMessageQueueDetail);
        C11126t.putValue(json, "mThreadDetail", this.mThreadDetail);
        C11126t.putValue(json, "mThreadStatus", this.mThreadStatus);
        return json;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        try {
            if (!TextUtils.isEmpty(this.mReason)) {
                sb.append("ANR 原因:\n");
                sb.append(this.mReason);
                sb.append(ShellAdbUtils.f33810d);
            }
            if (!TextUtils.isEmpty(this.mThreadStatus)) {
                sb.append("线程状态: \n");
                sb.append(this.mThreadStatus);
                sb.append(ShellAdbUtils.f33810d);
            }
            if (!TextUtils.isEmpty(this.mThreadDetail)) {
                sb.append("线程状态: \n");
                sb.append(this.mThreadDetail);
                sb.append(ShellAdbUtils.f33810d);
            }
            if (!TextUtils.isEmpty(this.mMessageQueueDetail)) {
                sb.append("消息队列: \n");
                sb.append(this.mMessageQueueDetail);
                sb.append(ShellAdbUtils.f33810d);
            }
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
        return sb.substring(0);
    }
}
