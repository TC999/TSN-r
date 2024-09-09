package com.kwad.components.offline.api.core.adlive.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.LiveStringUtil;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class LiveMessage extends BaseOfflineCompoJsonParse<LiveMessage> implements Serializable {
    private static final long serialVersionUID = 2264410572624564928L;
    public String content;
    public long mSortRank;
    public String userName;

    public boolean isInValid() {
        return LiveStringUtil.isNullString(this.userName) || LiveStringUtil.isNullString(this.content);
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(LiveMessage liveMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveMessage.userName = jSONObject.optString("userName");
        if (jSONObject.opt("userName") == JSONObject.NULL) {
            liveMessage.userName = "";
        }
        liveMessage.content = jSONObject.optString("content");
        if (jSONObject.opt("content") == JSONObject.NULL) {
            liveMessage.content = "";
        }
        liveMessage.mSortRank = jSONObject.optInt("sortRank");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(LiveMessage liveMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = liveMessage.userName;
        if (str != null && !str.equals("")) {
            t.putValue(jSONObject, "userName", liveMessage.userName);
        }
        String str2 = liveMessage.content;
        if (str2 != null && !str2.equals("")) {
            t.putValue(jSONObject, "content", liveMessage.content);
        }
        long j4 = liveMessage.mSortRank;
        if (j4 != 0) {
            t.putValue(jSONObject, "sortRank", j4);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(LiveMessage liveMessage) {
        return toJson(liveMessage, (JSONObject) null);
    }
}
