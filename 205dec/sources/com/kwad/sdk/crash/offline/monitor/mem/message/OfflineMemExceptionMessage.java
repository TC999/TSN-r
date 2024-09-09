package com.kwad.sdk.crash.offline.monitor.mem.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class OfflineMemExceptionMessage extends ExceptionMessage {
    private static final String MSG_QUEUE_DETAIL = "mMessageQueueDetail";
    private static final String REASON = "mReason";
    private static final String TAG = "OfflineMemExceptionMessage";
    private static final String THREAD_DETAIL = "mThreadDetail";
    private static final String THREAD_STATUS = "mThreadStatus";
    private static final long serialVersionUID = 2116476830162477948L;
    public String mReason = "";
    public String mMessageQueueDetail = "";
    public String mThreadDetail = "";
    public String mThreadStatus = "";

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    public String getTypePrefix() {
        return "offline_mem_";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
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
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.putValue(json, "mReason", this.mReason);
        t.putValue(json, "mMessageQueueDetail", this.mMessageQueueDetail);
        t.putValue(json, "mThreadDetail", this.mThreadDetail);
        t.putValue(json, "mThreadStatus", this.mThreadStatus);
        return json;
    }
}
